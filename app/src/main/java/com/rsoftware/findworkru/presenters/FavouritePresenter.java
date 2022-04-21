package com.rsoftware.findworkru.presenters;

import android.content.Context;

import com.rsoftware.findworkru.model.database.Database;
import com.rsoftware.findworkru.model.database.FavouriteList;

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
