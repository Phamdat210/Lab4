package com.example.demoslide4;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PolyService {

    //http://asian.dotplays.com/wp-json/wp/v2/posts?category=18

    @GET("wp-json/wp/v2/posts")
    Call<String> getPostOfCategory(@Query("category") String category);
}
