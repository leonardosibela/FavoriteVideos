package com.siblea.favotirevideos.task;

import com.siblea.favotirevideos.model.FavoriteVideo;

import java.util.List;

public interface ListFavoriteVideosTask {

    interface View {

        void setFavoriteVideos(List<FavoriteVideo> places);

        void displayEmptyListMesssage();

    }

    interface Presenter {

        void getAllVideos();

    }
}