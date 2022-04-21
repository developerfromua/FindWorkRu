package com.rsoftware.findworkru.presenters;

import android.content.Context;

import com.rsoftware.findworkru.model.database.Database;
import com.rsoftware.findworkru.model.database.Resume;

public class AddResumePresenter {
    private Database database;
    public void LoadData() {

    }
    public void AddResume(Context context, Resume resume) {
        database = Database.getInstance(context);
        database.resumeDao().add(resume);
    }
}
