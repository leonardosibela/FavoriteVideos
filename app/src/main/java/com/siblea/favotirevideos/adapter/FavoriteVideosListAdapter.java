package com.siblea.favotirevideos.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.siblea.favotirevideos.R;
import com.siblea.favotirevideos.model.FavoriteVideo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavoriteVideosListAdapter extends RecyclerView.Adapter<FavoriteVideosListAdapter.ViewHolder> {

    private List<FavoriteVideo> favoriteVideos;
    private Callbacks callbacks;

    public FavoriteVideosListAdapter(Callbacks callbacks) {
        this.callbacks = callbacks;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final FavoriteVideo favoriteVideo = favoriteVideos.get(position);

        holder.title.setText(favoriteVideo.getName());
        // TODO: more stuff

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callbacks.onFavoriteVideoClicked(favoriteVideo);
            }
        });
    }

    @Override
    public int getItemCount() {
        return favoriteVideos != null ? favoriteVideos.size() : 0;
    }

    public void addFavoriteVideo(FavoriteVideo favoriteVideo) {
        favoriteVideos.add(favoriteVideo);
        notifyItemInserted(favoriteVideos.indexOf(favoriteVideo));
    }

    // TODO: test later
    public void addFavoriteVideos(List<FavoriteVideo> favoriteVideos) {
        int positionStart = this.favoriteVideos.size();
        int itemCount = favoriteVideos.size();
        this.favoriteVideos.addAll(favoriteVideos);
        notifyItemRangeChanged(positionStart, itemCount);
    }

    public void deleteFavoriteVideo(FavoriteVideo favoriteVideo) {
        int index = favoriteVideos.indexOf(favoriteVideo);
        if (index != -1) {
            favoriteVideos.remove(favoriteVideo);
            notifyItemRemoved(index);
        }
    }

    public void updateFavoriteVideo(FavoriteVideo favoriteVideo, int position) {
        favoriteVideos.add(position, favoriteVideo);
        notifyItemChanged(position);
    }

    public void setFavoriteVideos(List<FavoriteVideo> favoriteVideos) {
        this.favoriteVideos = favoriteVideos;
        notifyDataSetChanged();
    }

    public interface Callbacks {
        void onFavoriteVideoClicked(FavoriteVideo favoriteVideo);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.favoriteVideoTitleTextView)
        TextView title;

        @BindView(R.id.playImageView)
        ImageView playImage;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, itemView);
        }
    }
}