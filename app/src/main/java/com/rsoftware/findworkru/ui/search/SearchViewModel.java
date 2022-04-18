package com.rsoftware.findworkru.ui.search;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rsoftware.findworkru.model.NetworkUtil.NetworkService;
import com.rsoftware.findworkru.model.NetworkUtil.VacanciesPojo;
import com.rsoftware.findworkru.model.Vacancy;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchViewModel extends ViewModel {

    private MutableLiveData<List<Vacancy>> mVacancyList;
    private List<Vacancy> vacancies;
    private int page = 1;
    private String title = "";

    public SearchViewModel() {
        mVacancyList = new MutableLiveData<>();
        vacancies = new ArrayList<>();
    }

    public void LoadVacancies() {

    }

    public void Clear() {
        mVacancyList.setValue(null);
        vacancies.clear();
        page = 1;
        title="";
    }

    public MutableLiveData<List<Vacancy>> getMVacancyList() {
        LoadVacancies();
        return mVacancyList;
    }

    public void LoadPage() {
        page++;
        LoadVacancies();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        Log.i("DEBUG_TAG", "new title: " + title);
        LoadVacancies();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mVacancyList = null;
    }

}