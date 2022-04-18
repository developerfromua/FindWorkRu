package com.rsoftware.findworkru.model;

import android.content.Context;

import java.util.List;

public class ResumesPresenter {
    private List<Resume> resumeList;
    private Database database;

    public List<Resume> LoadData(Context context) {
        database = Database.getInstance(context);
        resumeList = database.resumeDao().getAllResumes();
        return resumeList;
    }
}
