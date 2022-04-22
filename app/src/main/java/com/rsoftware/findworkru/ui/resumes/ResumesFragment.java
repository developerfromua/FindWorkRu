package com.rsoftware.findworkru.ui.resumes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.print.PrintAttributes;
import android.print.pdf.PrintedPdfDocument;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.rsoftware.findworkru.BuildConfig;
import com.rsoftware.findworkru.R;
import com.rsoftware.findworkru.databinding.FragmentResumesBinding;
import com.rsoftware.findworkru.model.PdfUtils.PdfGenerator;
import com.rsoftware.findworkru.model.database.Resume;
import com.rsoftware.findworkru.model.adapters.ResumesAdapter;
import com.rsoftware.findworkru.presenters.ResumesPresenter;
import com.rsoftware.findworkru.screens.AddResumeActivity;
import com.rsoftware.findworkru.screens.EditResumeActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ResumesFragment extends Fragment {

    private FragmentResumesBinding binding;
    private RecyclerView recyclerView;
    private TextView textViewResumeEmpty;
    private ResumesAdapter adapter;
    private ResumesPresenter presenter;
    private ExtendedFloatingActionButton button;
    private Intent mShareIntent;

    private PdfGenerator pdfGenerator;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentResumesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerView = root.findViewById(R.id.recyclerViewResumes);
        button = root.findViewById(R.id.addResumeButton);
        textViewResumeEmpty = root.findViewById(R.id.textViewResumeEmpty);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        adapter = new ResumesAdapter();
        adapter.setResumeList(new ArrayList<Resume>());
        recyclerView.setAdapter(adapter);
        presenter = new ResumesPresenter();
        pdfGenerator = new PdfGenerator();
        List<Resume> resumeList = presenter.LoadData(root.getContext());
        if (!resumeList.isEmpty()) {
            adapter.setResumeList(resumeList);
            textViewResumeEmpty.setVisibility(View.INVISIBLE);
        } else {
            adapter.setResumeList(resumeList);
            textViewResumeEmpty.setVisibility(View.VISIBLE);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(root.getContext(), AddResumeActivity.class);
                startActivityForResult(intent, 1);
            }
        });
        adapter.setListener(new ResumesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, int uid, String name, String surname, String middle_name, String wanted_vacancy, String wanted_salary, String business, String schedule, String phone, String email, String city, String citizenship, String sex, String education, String work_exp, String educationInstitution, String factuality, String educationSpeciality, String yearEndingEducation, String educationForm, String resumeSkills, String date) {
                Intent intent = new Intent(getContext(), EditResumeActivity.class);
                intent.putExtra("uid", uid);
                intent.putExtra("name", name);
                intent.putExtra("surname", surname);
                intent.putExtra("middle_name", middle_name);
                intent.putExtra("wanted_vacancy", wanted_vacancy);
                intent.putExtra("wanted_salary", wanted_salary);
                intent.putExtra("business", business);
                intent.putExtra("schedule", schedule);
                intent.putExtra("phone", phone);
                intent.putExtra("email", email);
                intent.putExtra("city", city);
                intent.putExtra("citizenship", citizenship);
                intent.putExtra("sex", sex);
                intent.putExtra("education", education);
                intent.putExtra("work_exp", work_exp);
                intent.putExtra("educationInstitution", educationInstitution);
                intent.putExtra("factuality", factuality);
                intent.putExtra("educationSpeciality", educationSpeciality);
                intent.putExtra("yearEndingEducation", yearEndingEducation);
                intent.putExtra("educationForm", educationForm);
                intent.putExtra("resumeSkills", resumeSkills);
                intent.putExtra("date", date);
                startActivityForResult(intent, 1);
            }
        });
        adapter.setListenerSend(new ResumesAdapter.OnClickListener() {
            @Override
            public void onClick(String name, String surname, String middle_name, String wanted_vacancy, String wanted_salary, String business, String schedule, String phone, String email, String city, String citizenship, String sex, String education, String work_exp, String educationInstitution, String factuality, String educationSpeciality, String yearEndingEducation, String educationForm, String resumeSkills) {
                Uri contentUri = pdfGenerator.createPdf(root.getContext(), name, surname, middle_name, wanted_vacancy, wanted_salary, business, schedule, phone, email, city, citizenship, sex, education, work_exp, educationInstitution, factuality, educationSpeciality,yearEndingEducation, educationForm, resumeSkills);
                if (contentUri!=null) {
                    shareDocument(contentUri);
                }
            }
        });
        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("DEBUG_TAG", "RESULT CODE: " + resultCode);
        if (resultCode == Activity.RESULT_OK) {
            List<Resume> resumeList = presenter.LoadData(getContext());
            if (!resumeList.isEmpty()) {
                adapter.setResumeList(resumeList);
                textViewResumeEmpty.setVisibility(View.INVISIBLE);
            } else {
                adapter.setResumeList(resumeList);
                textViewResumeEmpty.setVisibility(View.VISIBLE);
            }

        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    private void shareDocument(Uri uri) {
        mShareIntent = new Intent();
        mShareIntent.setAction(Intent.ACTION_SEND);
        mShareIntent.setType("application/pdf");
        mShareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        mShareIntent.putExtra(Intent.EXTRA_SUBJECT, "Отклик на вакансию");
        mShareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        startActivity(mShareIntent);
    }

}

