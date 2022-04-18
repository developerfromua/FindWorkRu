package com.rsoftware.findworkru.model;

import android.content.Context;

public class EditResumePresenter {

    private Resume resume;
    private Database database;

    public void EditResume(Context context, Resume resume) {
        database = Database.getInstance(context);
        database.resumeDao().update(resume);
    }
}
