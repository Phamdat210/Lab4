package com.example.demoslide4;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.demoslide4.Post.Post;

import java.util.List;

import vn.hailt.lab4.lt.models.Post;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {

    private Context context;
    private List<Post> posts;

    public PostAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_post, viewGroup, false);
        return new PostHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int i) {

        Post post = posts.get(i);

        holder.tvTitle.setText(post.getTitle().getRendered());

        int begin = post.getContent().getRendered().lastIndexOf("http");
        int end = post.getContent().getRendered().lastIndexOf(".jpg") + 4;

        if (begin != -1) {
            String image = post.getContent().getRendered().substring(begin, end);
            Glide.with(context).load(image).into(holder.imgPost);
        }
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class PostHolder extends RecyclerView.ViewHolder {

        private ImageView imgPost;
        private TextView tvTitle;

        public PostHolder(@NonNull View itemView) {
            super(itemView);

            imgPost = itemView.findViewById(R.id.imgPost);
            tvTitle = itemView.findViewById(R.id.tvTitle);

        }
    }
}
