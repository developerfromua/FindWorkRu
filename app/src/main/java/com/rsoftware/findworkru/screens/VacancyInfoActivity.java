package com.rsoftware.findworkru.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.rsoftware.findworkru.R;
import com.rsoftware.findworkru.model.Vacancy;

public class VacancyInfoActivity extends AppCompatActivity {

    private Vacancy vacancy;
    private TextView textViewVacancyInfoName;
    private TextView textViewVacancyInfoCreatedDate;
    private TextView textViewVacancyInfoSalary;
    private TextView textViewVacancyInfoCompany;
    private TextView textViewVacancyInfoCity;
    private TextView textViewVacancyInfoDescription;
    private TextView textViewVacancyInfoAdditional;
    private String phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacancy_info);

        textViewVacancyInfoName = findViewById(R.id.textViewVacancyInfoName);
        textViewVacancyInfoCreatedDate = findViewById(R.id.textViewVacancyInfoCreatedDate);
        textViewVacancyInfoSalary = findViewById(R.id.textViewVacancyInfoSalary);
        textViewVacancyInfoCompany = findViewById(R.id.textViewVacancyInfoCompany);
        textViewVacancyInfoCity = findViewById(R.id.textViewVacancyInfoCity);
        textViewVacancyInfoDescription = findViewById(R.id.textViewVacancyInfoDescription);
        textViewVacancyInfoAdditional = findViewById(R.id.textViewVacancyInfoAdditional);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Описание");

        Intent intent = getIntent();

        String name = intent.getStringExtra("vacancyName");
        String salary = intent.getStringExtra("vacancySalary");
        String city = intent.getStringExtra("city");
        String date = intent.getStringExtra("date");
        String desc = intent.getStringExtra("vacancyDescription");
        String category = intent.getStringExtra("category");
        String education = intent.getStringExtra("education");
        String work_exp = intent.getStringExtra("work_exp");
        String business = intent.getStringExtra("business");
        String schedule = intent.getStringExtra("schedule");
        phone = intent.getStringExtra("phone");
        String company = intent.getStringExtra("company");

        vacancy = new Vacancy(name, salary, desc, date, category, education, work_exp, business, schedule, city, phone, company);

        textViewVacancyInfoName.setText(vacancy.getVacancy_name());
        textViewVacancyInfoCreatedDate.append(vacancy.getDate());
        textViewVacancyInfoSalary.setText(vacancy.getVacancy_salary());
        textViewVacancyInfoCompany.setText(vacancy.getCompany());
        textViewVacancyInfoCity.setText(vacancy.getCity());
        textViewVacancyInfoDescription.setText(vacancy.getVacancy_description());
        textViewVacancyInfoAdditional.setText("Образование: " + vacancy.getEducation() + "\nЗанятость: " + vacancy.getBusiness() + "\nГрафик: " + vacancy.getSchedule());


    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public void onClickCallPhone(View view) {
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
        try {
            this.startActivity(i);
        } catch (Exception e) {
            Toast.makeText(this, "Вызовы недоступны", Toast.LENGTH_SHORT).show();
        }
    }
}