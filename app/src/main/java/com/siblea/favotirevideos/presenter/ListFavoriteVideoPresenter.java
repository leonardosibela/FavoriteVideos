package com.siblea.favotirevideos.presenter;

import com.siblea.favotirevideos.model.FavoriteVideo;
import com.siblea.favotirevideos.task.ListFavoriteVideosTask;
import com.siblea.favotirevideos.util.GsonUtil;

import java.util.List;

public class ListFavoriteVideoPresenter implements ListFavoriteVideosTask.Presenter {

    private ListFavoriteVideosTask.View view;

    public ListFavoriteVideoPresenter(ListFavoriteVideosTask.View view) {
        this.view = view;
    }

    @Override
    public void getAllVideos() {
        String mock = "[\n" +
                "\t{\"id\":73,\"name\":\"Regra de Sarrus\",\"url\":\"https://api.vimeo.com/videos/114289752\"},\n" +
                "  {\"id\":74,\"name\":\"Cálculo da Determinante de Ordem 3\",\"url\":\"https://api.vimeo.com/videos/114285450\"},\n" +
                "  {\"id\":75,\"name\":\"Regra de La Place\",\"url\":\"https://api.vimeo.com/videos/164411378\"},\n" +
                "  {\"id\":76,\"name\":\"Regra de La Place - Calculando Cofator\",\"url\":\"https://api.vimeo.com/videos/114287316\"}\n" +
                "]\n";

        List<FavoriteVideo> favoriteVideos = GsonUtil.fromJsonList(mock, FavoriteVideo.class);
        view.setFavoriteVideos(favoriteVideos);
    }
}
