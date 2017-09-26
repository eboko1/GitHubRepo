package com.example.vika.githubrepo.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.vika.githubrepo.R;
import com.example.vika.githubrepo.model.GitHubRepo;
import com.example.vika.githubrepo.controller.ControllerGit;
import com.example.vika.githubrepo.ui.adapter.GitHubRestAdapter;
import com.example.vika.githubrepo.utils.InternetConnection;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String LOG = "MainActivity";
    private RecyclerView recyclerView;
    private GitHubRestAdapter gitHubRestAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(LOG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        getApiData();
     /*   if(InternetConnection.isInternetConnection(getApplicationContext()) ) {
            Log.i(LOG, "connection inet " + InternetConnection.isInternetConnection(getApplicationContext()));
            Toast.makeText(this,"inet successful ",Toast.LENGTH_LONG).show();
            getApiData();
        } else {
            Toast.makeText(this,"Please connection internet ",Toast.LENGTH_LONG).show();

        }*/
    }

    private void getApiData() {
        String user = getString(R.string.user_repo);
        Call<List<GitHubRepo>> call = ControllerGit.getApiClient().getAllData(user);
        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                List<GitHubRepo> list = response.body();
                recyclerView.setAdapter( new GitHubRestAdapter(MainActivity.this, list));
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "oooppps error", Toast.LENGTH_LONG).show();
            }
        });

    }
}
