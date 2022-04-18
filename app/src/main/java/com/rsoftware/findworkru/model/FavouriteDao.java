package com.rsoftware.findworkru.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface FavouriteDao {
    @Query("SELECT * FROM localdb")
    List<FavouriteList> getAllFavourites();
    @Query("SELECT * FROM localdb WHERE vacancyServerUid = :uid")
    List<FavouriteList> getByUid(String uid);
    @Insert
    void addFavourite(FavouriteList favourite);
    @Query("DELETE FROM localdb WHERE vacancyServerUid = :uid")
    void deleteAllFavourite(String uid);
}
