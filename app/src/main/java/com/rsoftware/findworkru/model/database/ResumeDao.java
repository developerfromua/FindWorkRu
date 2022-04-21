package com.rsoftware.findworkru.model.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ResumeDao {
    @Query("SELECT * FROM resumes")
    List<Resume> getAllResumes();
    @Query("SELECT * FROM resumes WHERE uid=:uid")
    List<Resume> getResumeByUid(int uid);
    @Delete
    void delete(Resume resume);
    @Update
    void update(Resume resume);
    @Insert
    void add(Resume resume);
}
