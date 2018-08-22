package com.example.ahmedosman.instagramlite;

import android.os.Bundle;
import android.support.annotation.BinderThread;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recycleView)
    public RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private InstagramAdapter mInstagramAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);



        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mInstagramAdapter = new InstagramAdapter(InstagramList.Koala);
        mRecyclerView.setAdapter(mInstagramAdapter);
    }
}