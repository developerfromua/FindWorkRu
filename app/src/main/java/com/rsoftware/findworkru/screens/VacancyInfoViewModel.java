package com.rsoftware.findworkru.screens;

import android.content.Intent;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rsoftware.findworkru.model.Vacancy;

public class VacancyInfoViewModel extends ViewModel {
    private MutableLiveData<Vacancy> mVacancy;
    public VacancyInfoViewModel(){
        mVacancy = new MutableLiveData<>();
    }

    public void buildVacancy(){

    }

    public MutableLiveData<Vacancy> getMVacancy(){
        buildVacancy();
        return mVacancy;
    }

    public void setMVacancy(Vacancy mVacancy) {

    }
}
