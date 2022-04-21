package com.rsoftware.findworkru.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.rsoftware.findworkru.R;
import com.rsoftware.findworkru.presenters.EditResumePresenter;
import com.rsoftware.findworkru.model.database.Resume;

public class EditResumeActivity extends AppCompatActivity {
    private EditText editTextEditResumeName;
    private EditText editTextEditResumeSurname;
    private EditText editTextEditResumeMiddleName;
    private EditText editTextEditResumeWantedVacancy;
    private EditText editTextEditResumeWantedSalary;
    private Spinner spinnerEditResumeBusiness;
    private Spinner spinnerEditResumeSchedule;
    private EditText editTextEditResumePhone;
    private EditText editTextEditResumeEmail;
    private EditText editTextEditResumeCity;
    private EditText editTextEditResumeCitizenship;
    private Spinner spinnerEditResumeSex;
    private Spinner spinnerEditResumeEducation;
    private EditText editTextEditResumeWorkExp;
    private EditText editTextEditResumeEducationInstitution;
    private EditText editTextEditResumeFactuality;
    private EditText editTextEditResumeEducationSpeciality;
    private EditText editTextEditResumeYearEndingEducation;
    private Spinner spinnerEditResumeEducationForm;
    private EditText editTextEditResumeSkills;

    private int uid;
    private String name;
    private String surname;
    private String middle_name;
    private String wanted_vacancy;
    private String wanted_salary;
    private String business;
    private String schedule;
    private String phone;
    private String email;
    private String city;
    private String citizenship;
    private String sex;
    private String education;
    private String work_exp;
    private String edu_inst;
    private String edu_fact;
    private String edu_spec;
    private String edu_end;
    private String edu_form;
    private String skills;
    private String date;

    private Resume resume;

    private EditResumePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_resume);
        editTextEditResumeName = findViewById(R.id.editTextEditResumeName);
        editTextEditResumeSurname = findViewById(R.id.editTextEditResumeSurname);
        editTextEditResumeMiddleName = findViewById(R.id.editTextEditResumeMiddleName);
        editTextEditResumeWantedVacancy = findViewById(R.id.editTextEditResumeWantedVacancy);
        editTextEditResumeWantedSalary = findViewById(R.id.editTextEditResumeWantedSalary);
        spinnerEditResumeBusiness = findViewById(R.id.spinnerEditResumeBusiness);
        spinnerEditResumeSchedule = findViewById(R.id.spinnerEditResumeSchedule);
        editTextEditResumePhone = findViewById(R.id.editTextEditResumePhone);
        editTextEditResumeEmail = findViewById(R.id.editTextEditResumeEmail);
        editTextEditResumeCity = findViewById(R.id.editTextEditResumeCity);
        editTextEditResumeCitizenship = findViewById(R.id.editTextEditResumeCitizenship);
        spinnerEditResumeSex = findViewById(R.id.spinnerEditResumeSex);
        spinnerEditResumeEducation = findViewById(R.id.spinnerEditResumeEducation);
        editTextEditResumeWorkExp = findViewById(R.id.editTextEditResumeWorkExp);
        editTextEditResumeEducationInstitution = findViewById(R.id.editTextEditResumeEducationInstitution);
        editTextEditResumeFactuality = findViewById(R.id.editTextEditResumeFactuality);
        editTextEditResumeEducationSpeciality = findViewById(R.id.editTextEditResumeEducationSpeciality);
        editTextEditResumeYearEndingEducation = findViewById(R.id.editTextEditResumeYearEndingEducation);
        spinnerEditResumeEducationForm = findViewById(R.id.spinnerEditResumeEducationForm);
        editTextEditResumeSkills = findViewById(R.id.editTextEditResumeSkills);
        presenter = new EditResumePresenter();
        getSupportActionBar().setTitle("Редактирование");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
         uid = intent.getIntExtra("uid", -1);
         name = intent.getStringExtra("name");
         surname = intent.getStringExtra("surname");
         middle_name = intent.getStringExtra("middle_name");
         wanted_vacancy = intent.getStringExtra("wanted_vacancy");
         wanted_salary = intent.getStringExtra("wanted_salary");
         business = intent.getStringExtra("business");
         schedule = intent.getStringExtra("schedule");
         phone = intent.getStringExtra("phone");
         email = intent.getStringExtra("email");
         city = intent.getStringExtra("city");
         citizenship = intent.getStringExtra("citizenship");
         sex = intent.getStringExtra("sex");
         education = intent.getStringExtra("education");
         work_exp = intent.getStringExtra("work_exp");
         edu_inst = intent.getStringExtra("educationInstitution");
         edu_fact = intent.getStringExtra("factuality");
         edu_spec = intent.getStringExtra("educationSpeciality");
         edu_end = intent.getStringExtra("yearEndingEducation");
         edu_form = intent.getStringExtra("educationForm");
         skills = intent.getStringExtra("resumeSkills");
         date = intent.getStringExtra("date");

        editTextEditResumeName.setText(name);
        editTextEditResumeSurname.setText(surname);
        editTextEditResumeMiddleName.setText(middle_name);
        editTextEditResumeWantedVacancy.setText(wanted_vacancy);
        editTextEditResumeWantedSalary.setText(wanted_salary);
        spinnerEditResumeBusiness.setSelection(((ArrayAdapter) spinnerEditResumeBusiness.getAdapter()).getPosition(business));
        spinnerEditResumeSchedule.setSelection(((ArrayAdapter) spinnerEditResumeSchedule.getAdapter()).getPosition(schedule));
        editTextEditResumePhone.setText(phone);
        editTextEditResumeEmail.setText(email);
        editTextEditResumeCity.setText(city);
        editTextEditResumeCitizenship.setText(citizenship);
        spinnerEditResumeSex.setSelection(((ArrayAdapter) spinnerEditResumeSex.getAdapter()).getPosition(sex));
        spinnerEditResumeEducation.setSelection(((ArrayAdapter) spinnerEditResumeEducation.getAdapter()).getPosition(education));
        editTextEditResumeWorkExp.setText(work_exp);
        editTextEditResumeEducationInstitution.setText(edu_inst);
        editTextEditResumeFactuality.setText(edu_fact);
        editTextEditResumeEducationSpeciality.setText(edu_spec);
        editTextEditResumeYearEndingEducation.setText(edu_end);
        spinnerEditResumeEducationForm.setSelection(((ArrayAdapter) spinnerEditResumeEducationForm.getAdapter()).getPosition(edu_form));
        editTextEditResumeSkills.setText(skills);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void onClickEditResume(View view) {
        name = editTextEditResumeName.getText().toString();
        surname = editTextEditResumeSurname.getText().toString();
        middle_name = editTextEditResumeMiddleName.getText().toString();
        wanted_vacancy = editTextEditResumeWantedVacancy.getText().toString();
        wanted_salary = editTextEditResumeWantedSalary.getText().toString();
        business = spinnerEditResumeBusiness.getSelectedItem().toString();
        schedule = spinnerEditResumeSchedule.getSelectedItem().toString();
        phone = editTextEditResumePhone.getText().toString();
        email = editTextEditResumeEmail.getText().toString();
        city = editTextEditResumeCity.getText().toString();
        citizenship = editTextEditResumeCitizenship.getText().toString();
        sex = spinnerEditResumeSex.getSelectedItem().toString();
        education = spinnerEditResumeEducation.getSelectedItem().toString();
        work_exp = editTextEditResumeWorkExp.getText().toString();
        edu_inst = editTextEditResumeEducationInstitution.getText().toString();
        edu_fact = editTextEditResumeFactuality.getText().toString();
        edu_spec = editTextEditResumeEducationSpeciality.getText().toString();
        edu_end = editTextEditResumeYearEndingEducation.getText().toString();
        edu_form = spinnerEditResumeEducationForm.getSelectedItem().toString();
        skills = editTextEditResumeSkills.getText().toString();
        resume = new Resume(uid, name, surname, middle_name, wanted_vacancy, wanted_salary, business, schedule, phone, email, city, citizenship, sex,education,work_exp,edu_inst,edu_fact,edu_spec,edu_end,edu_form,skills,date);
        presenter.EditResume(this, resume);
        setResult(RESULT_OK);
        finish();
    }
}