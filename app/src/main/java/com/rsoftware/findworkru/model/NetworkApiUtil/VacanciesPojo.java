package com.rsoftware.findworkru.model.NetworkApiUtil;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VacanciesPojo {

    @SerializedName("vacancy_uid")
    @Expose
    private String vacancyUid;
    @SerializedName("vacancy_name")
    @Expose
    private String vacancyName;
    @SerializedName("vacancy_salary")
    @Expose
    private String vacancySalary;
    @SerializedName("vacancy_description")
    @Expose
    private String vacancyDescription;
    @SerializedName("vacancy_owner_uid")
    @Expose
    private String vacancyOwnerUid;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("education")
    @Expose
    private String education;
    @SerializedName("work_exp")
    @Expose
    private String workExp;
    @SerializedName("business")
    @Expose
    private String business;
    @SerializedName("schedule")
    @Expose
    private String schedule;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("company")
    @Expose
    private String company;

    public String getVacancyUid() {
        return vacancyUid;
    }

    public void setVacancyUid(String vacancyUid) {
        this.vacancyUid = vacancyUid;
    }

    public String getVacancyName() {
        return vacancyName;
    }

    public void setVacancyName(String vacancyName) {
        this.vacancyName = vacancyName;
    }

    public String getVacancySalary() {
        return vacancySalary;
    }

    public void setVacancySalary(String vacancySalary) {
        this.vacancySalary = vacancySalary;
    }

    public String getVacancyDescription() {
        return vacancyDescription;
    }

    public void setVacancyDescription(String vacancyDescription) {
        this.vacancyDescription = vacancyDescription;
    }

    public String getVacancyOwnerUid() {
        return vacancyOwnerUid;
    }

    public void setVacancyOwnerUid(String vacancyOwnerUid) {
        this.vacancyOwnerUid = vacancyOwnerUid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}