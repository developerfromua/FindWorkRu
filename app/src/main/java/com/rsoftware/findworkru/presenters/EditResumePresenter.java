package com.rsoftware.findworkru.presenters;

import android.content.Context;

import com.rsoftware.findworkru.model.database.Database;
import com.rsoftware.findworkru.model.database.Resume;

public class EditResumePresenter {

    private Resume resume;
    private Database database;

    public void EditResume(Context context, Resume resume) {
        database = Database.getInstance(context);
        database.resumeDao().update(resume);
    }
}
