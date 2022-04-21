package com.rsoftware.findworkru.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.rsoftware.findworkru.R;
import com.rsoftware.findworkru.model.adapters.VacanciesAdapter;
import com.rsoftware.findworkru.model.Vacancy;
import com.rsoftware.findworkru.presenters.SearchResultsPresenter;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;
    private VacanciesAdapter adapter;

    private SearchResultsPresenter presenter;
    private int page = 1;
    private String search_title;
    private String city;
    private String category;
    private String work_exp;
    private String business;
    private String schedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        recyclerView = findViewById(R.id.recyclerViewVacancies);
        mLayoutManager = new LinearLayoutManager(this);
        presenter = new SearchResultsPresenter(this);
        adapter = new VacanciesAdapter();
        Intent intent = getIntent();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        search_title = intent.getStringExtra("search_title");
        city = intent.getStringExtra("city");
        category = intent.getStringExtra("category");
        work_exp = intent.getStringExtra("work_exp");
        business = intent.getStringExtra("business");
        schedule = intent.getStringExtra("schedule");
        Log.i("DEBUG_TAG", "SEARCHING: " + search_title);
        getSupportActionBar().setTitle("Результаты поиска");
        recyclerView.setLayoutManager(mLayoutManager);
        setRecyclerView();

    }
    public void setRecyclerView(){
        adapter.setVacancies(new ArrayList<Vacancy>());
        recyclerView.setAdapter(adapter);
        presenter.LoadData(page, search_title, city, category, work_exp, business, schedule);
        adapter.setListener(new VacanciesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, String vacancyName, String vacancySalary, String vacancyDescription, String date, String category, String education, String work_exp, String business, String schedule, String city, String phone, String company) {
                Intent intent = new Intent(SearchResultsActivity.this, VacancyInfoActivity.class);
                intent.putExtra("vacancyName", vacancyName);
                intent.putExtra("vacancySalary", vacancySalary);
                intent.putExtra("vacancyDescription", vacancyDescription);
                intent.putExtra("date", date);
                intent.putExtra("category", category);
                intent.putExtra("education", education);
                intent.putExtra("work_exp", work_exp);
                intent.putExtra("business", business);
                intent.putExtra("schedule", schedule);
                intent.putExtra("city", city);
                intent.putExtra("phone", phone);
                intent.putExtra("company", company);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);


            }
        });
        adapter.setOnReachEndListener(new VacanciesAdapter.OnReachEndListener() {
            @Override
            public void onReachEnd() {
                page++;
                presenter.LoadData(page, search_title, city, category, work_exp, business, schedule);
            }
        });
    }
    public void showData(List<Vacancy> vacancies){
        adapter.addVacancies(vacancies);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}