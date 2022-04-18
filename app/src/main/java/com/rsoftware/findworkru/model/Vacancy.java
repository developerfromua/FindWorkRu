package com.rsoftware.findworkru.model;

public class Vacancy {
    private String vacancy_uid;
    private String vacancy_name;
    private String vacancy_salary;
    private String vacancy_description;
    private String date;
    private String category;
    private String education;
    private String work_exp;
    private String business;
    private String schedule;
    private String city;
    private String phone;
    private String company;

    public Vacancy(String vacancy_uid, String vacancy_name, String vacancy_salary, String vacancy_description, String date, String category, String education, String work_exp, String business, String schedule, String city, String phone, String company) {
        this.vacancy_uid = vacancy_uid;
        this.vacancy_name = vacancy_name;
        this.vacancy_salary = vacancy_salary;
        this.vacancy_description = vacancy_description;
        this.date = date;
        this.category = category;
        this.education = education;
        this.work_exp = work_exp;
        this.business = business;
        this.schedule = schedule;
        this.city = city;
        this.phone = phone;
        this.company = company;
    }
    public Vacancy(String vacancy_name, String vacancy_salary, String vacancy_description, String date, String category, String education, String work_exp, String business, String schedule, String city, String phone, String company) {
        this.vacancy_uid = vacancy_uid;
        this.vacancy_name = vacancy_name;
        this.vacancy_salary = vacancy_salary;
        this.vacancy_description = vacancy_description;
        this.date = date;
        this.category = category;
        this.education = education;
        this.work_exp = work_exp;
        this.business = business;
        this.schedule = schedule;
        this.city = city;
        this.phone = phone;
        this.company = company;
    }

    public String getVacancy_uid() {
        return vacancy_uid;
    }

    public void setVacancy_uid(String vacancy_uid) {
        this.vacancy_uid = vacancy_uid;
    }

    public String getVacancy_name() {
        return vacancy_name;
    }

    public void setVacancy_name(String vacancy_name) {
        this.vacancy_name = vacancy_name;
    }

    public String getVacancy_salary() {
        return vacancy_salary;
    }

    public void setVacancy_salary(String vacancy_salary) {
        this.vacancy_salary = vacancy_salary;
    }

    public String getVacancy_description() {
        return vacancy_description;
    }

    public void setVacancy_description(String vacancy_description) {
        this.vacancy_description = vacancy_description;
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

    public String getWork_exp() {
        return work_exp;
    }

    public void setWork_exp(String work_exp) {
        this.work_exp = work_exp;
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
