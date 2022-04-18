package com.rsoftware.findworkru.model;

import android.content.Context;

import java.util.List;

public class AddResumePresenter {
    private Database database;
    public void LoadData() {

    }
    public void AddResume(Context context, Resume resume) {
        database = Database.getInstance(context);
        database.resumeDao().add(resume);
    }
}
