package com.ujjwal.instagram;

import com.ujjwal.instagram.models.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface PostApi {

    @GET("instagram/posts")
    Call<List<PostModel>> getPosts();

    @GET("instagram/posts/{pId}")
    Call<PostModel> getPost(@Path("pId") String pId);

    @GET("uploads/")
    Call<List<PostModel>> getPostImages(@Header("Authorization")String token);
}
