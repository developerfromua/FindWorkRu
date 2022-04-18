package com.rsoftware.findworkru.screens;

import android.util.Log;

import com.rsoftware.findworkru.model.NetworkUtil.NetworkService;
import com.rsoftware.findworkru.model.NetworkUtil.VacanciesPojo;
import com.rsoftware.findworkru.model.Vacancy;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchResultsPresenter {

    private List<Vacancy> vacancies;
    private SearchResultsActivity activity;

    public SearchResultsPresenter(SearchResultsActivity activity) {
        this.activity = activity;
    }


    public void LoadData(int page, String title, String city, String category, String work_exp, String business, String schedule) {
        vacancies = new ArrayList<>();
        NetworkService.getInstance()
                .getJSONAPI()
                .getData(page, title, city, category, work_exp, business, schedule)
                .enqueue(new Callback<List<VacanciesPojo>>() {
                    @Override
                    public void onResponse(Call<List<VacanciesPojo>> call, Response<List<VacanciesPojo>> response) {
                        Log.i("DEBUG_TAG", "response code: " + response.code());
                        if (response.code() != 404) {
                            Log.i("DEBUG_TAG", "parsed page: " + page + "response code: " + response.code() + response.body().toString());
                            List<VacanciesPojo> vacanciesPojo = response.body();
                            for (VacanciesPojo v : vacanciesPojo) {
                                vacancies.add(new Vacancy(v.getVacancyUid(), v.getVacancyName(), v.getVacancySalary(), v.getVacancyDescription(), v.getDate(), v.getCategory(), v.getEducation(), v.getWorkExp(), v.getBusiness(), v.getSchedule(), v.getCity(), v.getPhone(), v.getCompany()));
                            }
                            activity.showData(vacancies);

                        }
                    }

                    @Override
                    public void onFailure(Call<List<VacanciesPojo>> call, Throwable t) {
                        Log.i("DEBUG_TAG", t.toString());
                    }
                });
    }
}
