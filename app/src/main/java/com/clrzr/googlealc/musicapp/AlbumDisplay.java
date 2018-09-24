package com.clrzr.googlealc.musicapp;

class AlbumDisplay {

    private final String name;
    private final int numOfSongs;
    private final int thumbnail;

    AlbumDisplay(String name, int numOfSongs, int thumbnail) {
        this.name = name;
        this.numOfSongs = numOfSongs;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public int getNumOfSongs() {
        return numOfSongs;
    }

    public int getThumbnail() {
        return thumbnail;
    }

}