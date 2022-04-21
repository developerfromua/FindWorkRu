package com.rsoftware.findworkru.model.NetworkApiUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JSONHolder {
    @GET("/api/vacancies/page/{id}?")
    Call<List<VacanciesPojo>> getData(@Path("id") int id, @Query("title") String title, @Query("city") String city, @Query("category") String category, @Query("work_exp") String work_exp, @Query("business") String business, @Query("schedule") String schedule);

}
