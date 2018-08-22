package com.example.ahmedosman.instagramlite;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import java.util.ArrayList;
import com.koushikdutta.ion.Ion;


public class InstagramAdapter extends RecyclerView.Adapter<InstagramAdapter.MyViewHolder> {
    private List<InstagramObject> mFeed;

    public InstagramAdapter() {
        mFeed = new ArrayList<>();
    }

    public InstagramAdapter(List<InstagramObject> feed) {
        mFeed = feed;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.instagram_feed_post, parent, false);

        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        InstagramObject post = mFeed.get(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return mFeed.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        View mView;

        public ImageView mImage;
        public TextView mName;
        public TextView mMotto;

        private InstagramObject mPost;

        public MyViewHolder(View view) {
            super(view);
            mView = view;
            mName = view.findViewById(R.id.name);
            mImage = view.findViewById(R.id.image);
            mMotto = view.findViewById(R.id.motto);
        }

        public void bind(InstagramObject post) {
            mPost = post;
            mName.setText(post.name);
            mMotto.setText(post.motto);

            Ion.with(mImage).error(R.drawable.error).load(mPost.imageUrl);
        }
    }
}
