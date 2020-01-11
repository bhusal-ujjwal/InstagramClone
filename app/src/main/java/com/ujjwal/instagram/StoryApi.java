package com.ujjwal.instagram;

import com.ujjwal.instagram.models.StoryModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface StoryApi {

    @GET("instagram/stories")
    Call<List<StoryModel>> getStories();

    @GET("instagram/stories/{sId}")
    Call<StoryModel> getStory(@Path("sId") String sId);


}
