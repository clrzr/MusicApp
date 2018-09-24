package com.clrzr.googlealc.musicapp;

import android.support.v7.widget.CardView;
import android.widget.ImageView;

interface AlbumGeneratorListener {
    void onAddToFavoriteSelected(int position);

    void onPlayNextSelected(int position);

    void onThumbnailSelected(int position, ImageView thumbnail);

    void onCardSelected(int position, CardView cardview);
}
