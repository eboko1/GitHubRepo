package com.example.vika.githubrepo.controller;

import com.example.vika.githubrepo.api.model.GitHubRepo;
import com.example.vika.githubrepo.api.service.GitHubClient;
import com.example.vika.githubrepo.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Vika on 24.09.2017.
 */


public class ControllerGit {
    private static Retrofit getRetrofitInstance(){
        Retrofit retrofit = null;
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.HTTP.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static GitHubClient getApiClient(){
        GitHubClient gitHubClient = getRetrofitInstance().create(GitHubClient.class);
        return gitHubClient;
    }
}
