package com.siblea.favotirevideos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.siblea.favotirevideos.adapter.FavoriteVideosListAdapter;
import com.siblea.favotirevideos.model.FavoriteVideo;
import com.siblea.favotirevideos.presenter.ListFavoriteVideoPresenter;
import com.siblea.favotirevideos.task.ListFavoriteVideosTask;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ListFavoriteVideosTask.View {

    @BindView(R.id.videos_recycler)
    RecyclerView videosRecycler;

    @BindView(R.id.empty_list_message)
    TextView emptyListMessage;

    private FavoriteVideosListAdapter adapter;
    private ListFavoriteVideosTask.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupRecyclerView();

        presenter = new ListFavoriteVideoPresenter(this);
        presenter.getAllVideos();
    }

    private void setupRecyclerView() {
        videosRecycler.setHasFixedSize(true);
        videosRecycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FavoriteVideosListAdapter();
        videosRecycler.setAdapter(adapter);
    }

    @Override
    public void setFavoriteVideos(List<FavoriteVideo> favoriteVideos) {
        videosRecycler.setVisibility(View.VISIBLE);
        emptyListMessage.setVisibility(View.GONE);
        adapter.setFavoriteVideos(favoriteVideos);
    }

    @Override
    public void displayEmptyListMesssage() {
        videosRecycler.setVisibility(View.GONE);
        emptyListMessage.setVisibility(View.VISIBLE);
    }
}