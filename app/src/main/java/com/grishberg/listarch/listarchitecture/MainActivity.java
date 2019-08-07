package com.grishberg.listarch.listarchitecture;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.github.grishberg.consoleview.Logger;
import com.github.grishberg.consoleview.LoggerImpl;
import com.grishberg.listarch.listarchitecture.rv.CustomItemDecorator;
import com.grishberg.listarch.listarchitecture.rv.GreenItem;
import com.grishberg.listarch.listarchitecture.rv.Item;
import com.grishberg.listarch.listarchitecture.rv.ItemsAdapter;
import com.grishberg.listarch.listarchitecture.rv.ItemsRecyclerView;
import com.grishberg.listarch.listarchitecture.rv.RedItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private Logger log;
    private ItemsAdapter adapter;
    private ItemsRecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        log = new LoggerImpl();
        rv = findViewById(R.id.rv);

        adapter = new ItemsAdapter(LayoutInflater.from(this));
        rv.addItemDecoration(new DividerItemDecoration(this, RecyclerView.VERTICAL));
        adapter.attachToRecyclerView(rv);
        adapter.populate(createData());

        LinearLayoutManager lm = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rv.setLayoutManager(lm);
        rv.addItemDecoration(new CustomItemDecorator(lm, this));
        rv.scrollToPosition(3);
    }

    private List<Item> createData() {
        ArrayList<Item> res = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                res.add(new RedItem("Menu item " + i));
            } else {
                res.add(new GreenItem("Menu item " + i));
            }
        }
        return res;
    }
}
