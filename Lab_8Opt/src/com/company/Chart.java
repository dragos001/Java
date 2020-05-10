package com.company;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Chart {
    private Integer albumId;
    private List<Album> albumList;

    public Chart() {
        this.albumId = null;
        this.albumList = new ArrayList<>();
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public List getAlbumList() {
        return this.albumList;
    }

}
