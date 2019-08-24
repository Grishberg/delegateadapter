package com.grishberg.listarch.listarchitecture;

import android.os.Bundle;
import android.view.ViewGroup;

import com.github.grishberg.consoleview.Logger;
import com.github.grishberg.consoleview.LoggerImpl;
import com.grishberg.core.ActivityLifeCycleAction;
import com.grishberg.core.ActivityLifeCycleDelegate;
import com.grishberg.feedsui.presentation.VerticalFeedFacade;
import com.grishberg.horizontalfeed.HorizontalContent;
import com.grishberg.horizontalfeed.HorizontalFeedFacade;
import com.grishberg.horizontalfeed.di.DaggerHorizontalFeedComponent;
import com.grishberg.horizontalfeed.di.HorisontalFeedModule;
import com.grishberg.horizontalfeed.di.HorizontalFeedComponent;
import com.grishberg.verticalfeeds.VerticalFeedContent;
import com.grishberg.verticalfeedsdomain.di.DaggerVerticalFeedComponent;
import com.grishberg.verticalfeedsdomain.di.FeedModule;
import com.grishberg.verticalfeedsdomain.di.VerticalFeedComponent;

import java.util.ArrayList;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends FragmentActivity implements ActivityLifeCycleDelegate {
    private Logger log;
    private VerticalFeedFacade verticalFeedFacade;
    private ArrayList<ActivityLifeCycleAction> lifecycleActions = new ArrayList<>();
    private HorizontalFeedFacade horizontalFeedFacade;
    private VerticalFeedContent verticalFeedContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        log = new LoggerImpl();

        ViewGroup content = findViewById(R.id.content);

        VerticalFeedComponent verticalFeedComponent = DaggerVerticalFeedComponent.builder()
                .feedModule(new FeedModule())
                .build();
        verticalFeedContent = verticalFeedComponent.provideFeedContent();

        HorizontalFeedComponent horizontalFeedComponent = DaggerHorizontalFeedComponent.builder()
                .horisontalFeedModule(new HorisontalFeedModule(verticalFeedContent))
                .build();
        HorizontalContent horizontalContent = horizontalFeedComponent.provideHorizontalFeedContent();

        horizontalFeedFacade = new HorizontalFeedFacade(horizontalContent);
        horizontalFeedFacade.attachView((RecyclerView) findViewById(R.id.rv), this);

        verticalFeedFacade = new VerticalFeedFacade(verticalFeedContent);
        ViewGroup.LayoutParams verticalsLp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        verticalFeedFacade.attachView(this, content, verticalsLp);
        horizontalContent.requestData();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        verticalFeedContent.requestData();
    }

    @Override
    public void registerActivityLifeCycleAction(ActivityLifeCycleAction action) {
        lifecycleActions.add(action);
    }

    @Override
    public void unregisterActivityLifeCycleAction(ActivityLifeCycleAction action) {
        lifecycleActions.remove(action);
    }

    @Override
    protected void onResume() {
        super.onResume();
        for (ActivityLifeCycleAction a : lifecycleActions) {
            a.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        for (ActivityLifeCycleAction a : lifecycleActions) {
            a.onPause();
        }
    }
}
