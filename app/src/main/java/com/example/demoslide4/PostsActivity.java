package com.example.demoslide4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.demoslide4.Post.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.hailt.lab4.lt.models.Post;

public class PostsActivity extends AppCompatActivity {

    private RecyclerView rvPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        rvPosts = findViewById(R.id.rvPosts);

        int cate_id = getIntent().getIntExtra("cate_id", -1);

        PolyService dotplaysService = PolyRetrofit.getInstance().create(PolyService.class);

        dotplaysService.getPostOfCategory(cate_id).enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.code() == 200) {

                    PostAdapter adapter = new PostAdapter(PostsActivity.this, response.body());
                    rvPosts.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.e("TAG", "onFailure: " + t.getMessage());
            }
        });

    }
}
