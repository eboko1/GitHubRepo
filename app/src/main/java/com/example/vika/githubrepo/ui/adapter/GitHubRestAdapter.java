package com.example.vika.githubrepo.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vika.githubrepo.R;
import com.example.vika.githubrepo.model.GitHubRepo;

import java.util.List;

/**
 * Created by Vika on 24.09.2017.
 */

public class GitHubRestAdapter extends RecyclerView.Adapter<GitHubRestAdapter.GitHubRestHolder> {
    private Context context;
    private List<GitHubRepo> gitHubRepoList;

    public GitHubRestAdapter(Context context, List<GitHubRepo> gitHubRepoList) {
        this.context = context;
        this.gitHubRepoList = gitHubRepoList;
    }

    @Override
    public GitHubRestHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_git_hub, parent, false);
        return new GitHubRestHolder(view);
    }

    @Override
    public void onBindViewHolder(GitHubRestHolder holder, int position) {
        GitHubRepo gitHubRepo = gitHubRepoList.get(position);
        holder.infoTextView.setText(gitHubRepo.getName());
    }

    @Override
    public int getItemCount() {
        return gitHubRepoList.size();
    }



    public class GitHubRestHolder extends RecyclerView.ViewHolder {
        TextView infoTextView;

        public GitHubRestHolder(View itemView) {
            super(itemView);
            infoTextView = (TextView)itemView.findViewById(R.id.info_textView);

        }
    }
}
