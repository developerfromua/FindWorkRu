package com.rsoftware.findworkru.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.rsoftware.findworkru.R;
import com.rsoftware.findworkru.model.AddResumePresenter;
import com.rsoftware.findworkru.model.Resume;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddResumeActivity extends AppCompatActivity {
    private EditText editTextAddResumeName;
    private EditText editTextAddResumeSurname;
    private EditText editTextAddResumeMiddleName;
    private EditText editTextAddResumeWantedVacancy;
    private EditText editTextAddResumeWantedSalary;
    private Spinner spinnerAddResumeBusiness;
    private Spinner spinnerAddResumeSchedule;
    private EditText editTextAddResumePhone;
    private EditText editTextAddResumeEmail;
    private EditText editTextAddResumeCity;
    private EditText editTextAddResumeCitizenship;
    private Spinner spinnerAddResumeSex;
    private Spinner spinnerAddResumeEducation;
    private EditText editTextAddResumeWorkExp;
    private EditText editTextAddResumeEducationInstitution;
    private EditText editTextAddResumeFactuality;
    private EditText editTextAddResumeEducationSpeciality;
    private EditText editTextAddResumeYearEndingEducation;
    private Spinner spinnerAddResumeEducationForm;
    private EditText editTextAddResumeSkills;
    private Resume resume;

    private AddResumePresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_resume);
        getSupportActionBar().setTitle("Резюме");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        presenter = new AddResumePresenter();
        editTextAddResumeName = findViewById(R.id.editTextAddResumeName);
        editTextAddResumeSurname = findViewById(R.id.editTextAddResumeSurname);
        editTextAddResumeMiddleName = findViewById(R.id.editTextAddResumeMiddleName);
        editTextAddResumeWantedVacancy = findViewById(R.id.editTextAddResumeWantedVacancy);
        editTextAddResumeWantedSalary = findViewById(R.id.editTextAddResumeWantedSalary);
        spinnerAddResumeBusiness = findViewById(R.id.spinnerAddResumeBusiness);
        spinnerAddResumeSchedule = findViewById(R.id.spinnerAddResumeSchedule);
        editTextAddResumePhone = findViewById(R.id.editTextAddResumePhone);
        editTextAddResumeEmail = findViewById(R.id.editTextAddResumeEmail);
        editTextAddResumeCity = findViewById(R.id.editTextAddResumeCity);
        editTextAddResumeCitizenship = findViewById(R.id.editTextAddResumeCitizenship);
        spinnerAddResumeSex = findViewById(R.id.spinnerAddResumeSex);
        spinnerAddResumeEducation = findViewById(R.id.spinnerAddResumeEducation);
        editTextAddResumeWorkExp = findViewById(R.id.editTextAddResumeWorkExp);
        editTextAddResumeEducationInstitution = findViewById(R.id.editTextAddResumeEducationInstitution);
        editTextAddResumeFactuality = findViewById(R.id.editTextAddResumeFactuality);
        editTextAddResumeEducationSpeciality = findViewById(R.id.editTextAddResumeEducationSpeciality);
        editTextAddResumeYearEndingEducation = findViewById(R.id.editTextAddResumeYearEndingEducation);
        spinnerAddResumeEducationForm = findViewById(R.id.spinnerAddResumeEducationForm);
        editTextAddResumeSkills = findViewById(R.id.editTextAddResumeSkills);

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void onClickAddResume(View view) {
        String name = editTextAddResumeName.getText().toString();
        String surname = editTextAddResumeSurname.getText().toString();
        String middle_name = editTextAddResumeMiddleName.getText().toString();
        String wanted_vacancy = editTextAddResumeWantedVacancy.getText().toString();
        String wanted_salary = editTextAddResumeWantedSalary.getText().toString();
        String business = spinnerAddResumeBusiness.getSelectedItem().toString();
        String schedule = spinnerAddResumeSchedule.getSelectedItem().toString();
        String phone = editTextAddResumePhone.getText().toString();
        String email = editTextAddResumeEmail.getText().toString();
        String city = editTextAddResumeCity.getText().toString();
        String citizenship = editTextAddResumeCitizenship.getText().toString();
        String sex = spinnerAddResumeSex.getSelectedItem().toString();
        String education = spinnerAddResumeEducation.getSelectedItem().toString();
        String work_exp = editTextAddResumeWorkExp.getText().toString();
        String edu_inst = editTextAddResumeEducationInstitution.getText().toString();
        String edu_fact = editTextAddResumeFactuality.getText().toString();
        String edu_spec = editTextAddResumeEducationSpeciality.getText().toString();
        String edu_end = editTextAddResumeYearEndingEducation.getText().toString();
        String edu_form = spinnerAddResumeEducationForm.getSelectedItem().toString();
        String skills = editTextAddResumeSkills.getText().toString();
        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
        String date = dateformat.format(c.getTime());
        resume = new Resume(name, surname, middle_name, wanted_vacancy, wanted_salary, business, schedule, phone, email,city, citizenship, sex, education, work_exp,edu_inst,edu_fact,edu_spec,edu_end,edu_form,skills, date);
        presenter.AddResume(this, resume);
        setResult(RESULT_OK);
        finish();
    }
}