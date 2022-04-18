package com.rsoftware.findworkru.model;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rsoftware.findworkru.R;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ResumesAdapter extends RecyclerView.Adapter<ResumesAdapter.ResumesViewHolder> {
    private List<Resume> resumeList;
    private Database database;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int pos, int uid, String name, String surname, String middle_name, String wanted_vacancy, String wanted_salary, String business, String schedule, String phone, String email, String city, String citizenship, String sex, String education, String work_exp, String educationInstitution, String factuality, String educationSpeciality, String yearEndingEducation, String educationForm, String resumeSkills, String date);
    }

    @NonNull
    @Override
    public ResumesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.resume_card_item_layout, parent, false);
        return new ResumesAdapter.ResumesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResumesViewHolder holder, int position) {
        holder.bind(resumeList.get(position));
    }

    @Override
    public int getItemCount() {
        return resumeList.size();
    }

    class ResumesViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewResumeTitle;
        private TextView textViewResumeDate;
        private ImageView imageViewResumeDel;

        public ResumesViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewResumeTitle = itemView.findViewById(R.id.textViewResumeTitle);
            textViewResumeDate = itemView.findViewById(R.id.textViewResumeDate);
            imageViewResumeDel = itemView.findViewById(R.id.imageViewResumeDel);
        }

        public void bind(Resume resume) {
            int uid = resume.getUid();
            String name = resume.getName();
            String surname = resume.getSurname();
            String middle_name = resume.getMiddleName();
            String wantedVacancy =resume.getWantedVacancy();
            String wantedSalary = resume.getWantedSalary();
            String business = resume.getBusiness();
            String schedule = resume.getSchedule();
            String phone = resume.getPhone();
            String email = resume.getEmail();
            String city = resume.getCity();
            String citizenship = resume.getCitizenship();
            String sex = resume.getSex();
            String education = resume.getEducation();
            String workExp = resume.getWorkExp();
            String educationInstitution = resume.getEducationInstitution();
            String factuality = resume.getFactuality();
            String educationSpeciality = resume.getEducationSpeciality();
            String yearEndingEducation = resume.getYearEndingEducation();
            String educationForm = resume.getEducationForm();
            String resumeSkills = resume.getResumeSkills();
            String date = resume.getDate();


            textViewResumeTitle.setText(wantedVacancy);
            textViewResumeDate.setText(date);
            imageViewResumeDel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    database = Database.getInstance(itemView.getContext());
                    database.resumeDao().delete(resume);
                    resumeList.remove(getAdapterPosition());
                    notifyDataSetChanged();
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.onItemClick(getAdapterPosition(), uid, name, surname, middle_name, wantedVacancy, wantedSalary, business, schedule, phone, email, city, citizenship, sex, education, workExp, educationInstitution, factuality, educationSpeciality,yearEndingEducation, educationForm, resumeSkills, date);
                    }
                }
            });
        }
    }

    public void setResumeList(List<Resume> resumeList) {
        this.resumeList = resumeList;
        notifyDataSetChanged();
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
