package com.rsoftware.findworkru.model;

import android.content.Context;
import android.util.Log;

import java.util.List;

public class FavouritePresenter {
    private List<FavouriteList> list;
    private Database database;

    public List<FavouriteList> LoadData(Context context) {
        database = Database.getInstance(context);
        list = database.favouriteDao().getAllFavourites();
        return list;
    }
}
