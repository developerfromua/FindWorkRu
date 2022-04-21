package com.rsoftware.findworkru.presenters;

import android.content.Context;

import com.rsoftware.findworkru.model.database.Database;
import com.rsoftware.findworkru.model.database.Resume;

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
