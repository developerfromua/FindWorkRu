package com.rsoftware.findworkru.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "resumes")
public class Resume {
    @NotNull
    @PrimaryKey(autoGenerate = true)
    private int uid;

    private String name;
    private String surname;
    private String middleName;
    private String wantedVacancy;
    private String wantedSalary;
    private String business;
    private String schedule;
    private String phone;
    private String email;
    private String city;
    private String citizenship;
    private String sex;
    private String education;
    private String workExp;
    private String educationInstitution;
    private String factuality;
    private String educationSpeciality;
    private String yearEndingEducation;
    private String educationForm;
    private String resumeSkills;
    private String date;

    public Resume(int uid, String name, String surname, String middleName, String wantedVacancy, String wantedSalary, String business, String schedule, String phone, String email, String city, String citizenship, String sex, String education, String workExp, String educationInstitution, String factuality, String educationSpeciality, String yearEndingEducation, String educationForm, String resumeSkills, String date) {
        this.uid = uid;
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.wantedVacancy = wantedVacancy;
        this.wantedSalary = wantedSalary;
        this.business = business;
        this.schedule = schedule;
        this.phone = phone;
        this.email = email;
        this.city = city;
        this.citizenship = citizenship;
        this.sex = sex;
        this.education = education;
        this.workExp = workExp;
        this.educationInstitution = educationInstitution;
        this.factuality = factuality;
        this.educationSpeciality = educationSpeciality;
        this.yearEndingEducation = yearEndingEducation;
        this.educationForm = educationForm;
        this.resumeSkills = resumeSkills;
        this.date = date;
    }
    @Ignore
    public Resume(String name, String surname, String middleName, String wantedVacancy, String wantedSalary, String business, String schedule, String phone, String email, String city, String citizenship, String sex, String education, String workExp, String educationInstitution, String factuality, String educationSpeciality, String yearEndingEducation, String educationForm, String resumeSkills, String date) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.wantedVacancy = wantedVacancy;
        this.wantedSalary = wantedSalary;
        this.business = business;
        this.schedule = schedule;
        this.phone = phone;
        this.email = email;
        this.city = city;
        this.citizenship = citizenship;
        this.sex = sex;
        this.education = education;
        this.workExp = workExp;
        this.educationInstitution = educationInstitution;
        this.factuality = factuality;
        this.educationSpeciality = educationSpeciality;
        this.yearEndingEducation = yearEndingEducation;
        this.educationForm = educationForm;
        this.resumeSkills = resumeSkills;
        this.date = date;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getWantedVacancy() {
        return wantedVacancy;
    }

    public void setWantedVacancy(String wantedVacancy) {
        this.wantedVacancy = wantedVacancy;
    }

    public String getWantedSalary() {
        return wantedSalary;
    }

    public void setWantedSalary(String wantedSalary) {
        this.wantedSalary = wantedSalary;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getWorkExp() {
        return workExp;
    }

    public void setWorkExp(String workExp) {
        this.workExp = workExp;
    }

    public String getEducationInstitution() {
        return educationInstitution;
    }

    public void setEducationInstitution(String educationInstitution) {
        this.educationInstitution = educationInstitution;
    }

    public String getFactuality() {
        return factuality;
    }

    public void setFactuality(String factuality) {
        this.factuality = factuality;
    }

    public String getEducationSpeciality() {
        return educationSpeciality;
    }

    public void setEducationSpeciality(String educationSpeciality) {
        this.educationSpeciality = educationSpeciality;
    }

    public String getYearEndingEducation() {
        return yearEndingEducation;
    }

    public void setYearEndingEducation(String yearEndingEducation) {
        this.yearEndingEducation = yearEndingEducation;
    }

    public String getEducationForm() {
        return educationForm;
    }

    public void setEducationForm(String educationForm) {
        this.educationForm = educationForm;
    }

    public String getResumeSkills() {
        return resumeSkills;
    }

    public void setResumeSkills(String resumeSkills) {
        this.resumeSkills = resumeSkills;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}