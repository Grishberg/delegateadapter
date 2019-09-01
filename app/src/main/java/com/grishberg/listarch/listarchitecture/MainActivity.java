package com.grishberg.listarch.listarchitecture;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.grishberg.content.ContentDetails;
import com.grishberg.contentui.ContentViewHolder;
import com.grishberg.contentui.ContentViewModel;
import com.grishberg.domain.di.ContentDetailsComponent;
import com.grishberg.domain.di.ContentDetailsModule;
import com.grishberg.domain.di.DaggerContentDetailsComponent;
import com.grishberg.feedsui.presentation.RenderedFeedsFactory;
import com.grishberg.feedsui.presentation.VerticalFeedFacade;
import com.grishberg.feedsui.presentation.cards.renderer.RendererProvider;
import com.grishberg.horizontalfeed.HorizontalContent;
import com.grishberg.horizontalfeed.HorizontalFeedFacade;
import com.grishberg.horizontalfeed.cards.FeedConverterImpl;
import com.grishberg.horizontalfeed.cards.HorizontalCardsFactoryImpl;
import com.grishberg.horizontalfeed.di.DaggerHorizontalFeedComponent;
import com.grishberg.horizontalfeed.di.HorizontalFeedComponent;
import com.grishberg.horizontalfeed.di.HorizontalFeedModule;
import com.grishberg.listarch.listarchitecture.domain.ApplicationUseCase;
import com.grishberg.listarch.listarchitecture.presentation.Router;
import com.grishberg.listarch.listarchitecture.presentation.RouterViewModel;
import com.grishberg.verticalfeeds.FeedContent;
import com.grishberg.verticalfeedsdomain.di.DaggerVerticalFeedComponent;
import com.grishberg.verticalfeedsdomain.di.FeedModule;
import com.grishberg.verticalfeedsdomain.di.VerticalFeedComponent;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends FragmentActivity {
    private VerticalFeedFacade verticalFeedFacade;
    private HorizontalFeedFacade horizontalFeedFacade;
    private FeedContent verticalFeedContent;
    private ApplicationUseCase applicationUseCase;
    private ContentViewModel contentViewModel;
    private Router router;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ViewGroup content = findViewById(R.id.content);

        RendererProvider rendererProvider = new RendererProvider();
        VerticalFeedComponent verticalFeedComponent = DaggerVerticalFeedComponent.builder()
                .feedModule(new FeedModule(new RenderedFeedsFactory(rendererProvider)))
                .build();
        verticalFeedContent = verticalFeedComponent.provideFeedContent();

        HorizontalFeedComponent horizontalFeedComponent = DaggerHorizontalFeedComponent.builder()
                .horizontalFeedModule(new HorizontalFeedModule(verticalFeedContent,
                        new FeedConverterImpl(), new HorizontalCardsFactoryImpl()))
                .build();
        HorizontalContent horizontalContent = horizontalFeedComponent.provideHorizontalFeedContent();

        horizontalFeedFacade = new HorizontalFeedFacade(horizontalContent);
        horizontalFeedFacade.attachView((RecyclerView) findViewById(R.id.rv), this);

        verticalFeedFacade = new VerticalFeedFacade(verticalFeedContent);
        ViewGroup.LayoutParams verticalsLp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        verticalFeedFacade.attachView(this, content, verticalsLp);

        ContentDetailsComponent contentDetailsComponent = DaggerContentDetailsComponent.builder()
                .contentDetailsModule(new ContentDetailsModule())
                .build();
        ContentDetails contentDetails = contentDetailsComponent.provideContentDetails();
        contentViewModel = ViewModelProviders.of(this, new ContentViewModelFactory(contentDetails))
                .get(ContentViewModel.class);
        View contentDetailsRootView = findViewById(R.id.contentDetailsRoot);

        ContentViewHolder contentViewHolder = new ContentViewHolder(this, contentViewModel,
                contentDetailsRootView);
        applicationUseCase = new ApplicationUseCase(contentDetails, horizontalContent, verticalFeedContent);
        RouterViewModel routerViewModel = ViewModelProviders.of(this, new RouterViewModelFactory(applicationUseCase))
                .get(RouterViewModel.class);

        router = new Router(this, routerViewModel,
                contentDetailsRootView,
                findViewById(R.id.feedView));
        horizontalContent.requestData();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        verticalFeedContent.requestData();
    }

    @Override
    public void onBackPressed() {
        router.onBackPressed();
    }

    private static class RouterViewModelFactory implements ViewModelProvider.Factory {
        private final ApplicationUseCase applicationUseCase;

        RouterViewModelFactory(ApplicationUseCase applicationUseCase) {
            this.applicationUseCase = applicationUseCase;
        }

        @SuppressWarnings("unchecked")
        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new RouterViewModel(applicationUseCase);
        }
    }

    private static class ContentViewModelFactory implements ViewModelProvider.Factory {
        private final ContentDetails contentDetails;

        public ContentViewModelFactory(ContentDetails contentDetails) {
            this.contentDetails = contentDetails;
        }

        @SuppressWarnings("unchecked")
        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new ContentViewModel(contentDetails);
        }
    }
}
