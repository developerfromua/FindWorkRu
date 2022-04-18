package com.rsoftware.findworkru.ui.favourite;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rsoftware.findworkru.model.Database;
import com.rsoftware.findworkru.model.FavouriteList;
import com.rsoftware.findworkru.model.Vacancy;

import java.util.List;

public class FavouriteViewModel extends ViewModel {

    private MutableLiveData<Vacancy> vacancyMutableLiveData;
    private Database database;
    private List<FavouriteList> favouriteFromDb;

    public FavouriteViewModel() {

    }


    public void LoadData(Context context) {
        database = Database.getInstance(context);
        favouriteFromDb = database.favouriteDao().getAllFavourites();

    }

    public LiveData<Vacancy> getVacancies() {
        return vacancyMutableLiveData;
    }

}