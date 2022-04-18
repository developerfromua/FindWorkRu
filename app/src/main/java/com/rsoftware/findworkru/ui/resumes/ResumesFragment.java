package com.rsoftware.findworkru.ui.resumes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.rsoftware.findworkru.R;
import com.rsoftware.findworkru.databinding.FragmentResumesBinding;
import com.rsoftware.findworkru.model.Resume;
import com.rsoftware.findworkru.model.ResumesAdapter;
import com.rsoftware.findworkru.model.ResumesPresenter;
import com.rsoftware.findworkru.screens.AddResumeActivity;
import com.rsoftware.findworkru.screens.EditResumeActivity;

import java.util.ArrayList;
import java.util.List;

public class ResumesFragment extends Fragment {

    private ResumesViewModel resumesViewModel;
    private FragmentResumesBinding binding;
    private RecyclerView recyclerView;
    private ResumesAdapter adapter;
    private ResumesPresenter presenter;
    private ExtendedFloatingActionButton button;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        resumesViewModel =
                new ViewModelProvider(this).get(ResumesViewModel.class);

        binding = FragmentResumesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerView = root.findViewById(R.id.recyclerViewResumes);
        button = root.findViewById(R.id.addResumeButton);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        adapter = new ResumesAdapter();
        adapter.setResumeList(new ArrayList<Resume>());
        recyclerView.setAdapter(adapter);
        presenter = new ResumesPresenter();
        List<Resume> resumeList = presenter.LoadData(root.getContext());
        adapter.setResumeList(resumeList);
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
                startActivityForResult(intent,1);
            }
        });
        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        Log.i("DEBUG_TAG", "RESULT CODE: " + resultCode);
        if (resultCode == Activity.RESULT_OK) {
            List<Resume> resumeList = presenter.LoadData(getContext());
            adapter.setResumeList(resumeList);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}