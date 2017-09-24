package com.example.vika.githubrepo.api.service;

import com.example.vika.githubrepo.api.model.GitHubRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Vika on 24.09.2017.
 */

public interface GitHubClient {
    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>> getAllData(@Path("user") String user);
}
