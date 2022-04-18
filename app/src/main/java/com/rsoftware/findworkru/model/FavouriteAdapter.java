package com.rsoftware.findworkru.model;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rsoftware.findworkru.R;

import java.util.List;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.FavouriteViewHolder>{

    private List<FavouriteList> vacancyList;
    private VacanciesAdapter.OnItemClickListener listener;
    private Database database;
    public interface OnItemClickListener {
        void onItemClick(int pos, String vacancyName, String vacancySalary, String vacancyDescription, String date, String category, String education, String work_exp, String business, String schedule, String city, String phone, String company);
    }

    @NonNull
    @Override
    public FavouriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vacancy_card_item_layout, parent, false);
        return new FavouriteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavouriteViewHolder holder, int position) {
        holder.bind(vacancyList.get(position));
    }

    @Override
    public int getItemCount() {
        return vacancyList.size();
    }

    class FavouriteViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewVacancyName;
        private TextView textViewVacancySalary;
        private TextView textViewVacancyCity;
        private TextView textViewVacancyDate;
        private TextView textViewVacancyDesc;
        private ImageView imageViewFavourite;
        public FavouriteViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewVacancyName = (TextView) itemView.findViewById(R.id.textViewVacancyName);
            textViewVacancySalary = (TextView) itemView.findViewById(R.id.textViewVacancySalary);
            textViewVacancyCity = (TextView) itemView.findViewById(R.id.textViewVacancyCity);
            textViewVacancyDate = (TextView) itemView.findViewById(R.id.textViewVacancyDate);
            textViewVacancyDesc = (TextView) itemView.findViewById(R.id.textViewVacancyDesc);
            imageViewFavourite = (ImageView) itemView.findViewById(R.id.imageViewFavourite);
        }
        public void bind(FavouriteList vacancy) {
            imageViewFavourite.setImageResource(R.drawable.ic_heart_svgrepo_com);
            String name = vacancy.getVacancy_name();
            textViewVacancyName.setText(name);
            String salary = vacancy.getVacancy_salary();
            textViewVacancySalary.setText(salary);
            String city = vacancy.getCity();
            textViewVacancyCity.setText(city);
            String date = vacancy.getDate();
            textViewVacancyDate.setText(date);
            String desc = vacancy.getVacancy_description();
            textViewVacancyDesc.setText(desc);
            String category = vacancy.getCategory();
            String education = vacancy.getEducation();
            String work_exp = vacancy.getWork_exp();
            String business = vacancy.getBusiness();
            String schedule = vacancy.getSchedule();
            String phone = vacancy.getPhone();
            String company = vacancy.getCompany();
            database = Database.getInstance(itemView.getContext());
            String param1 = vacancy.getVacancyServerUid();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener!=null) {
                        listener.onItemClick(getAdapterPosition(), name, salary, desc, date, category, education, work_exp, business, schedule, city, phone, company);
                    }
                }
            });
            imageViewFavourite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Log.i("DEBUG_TAG", "param1: " +  param1);

                    List<FavouriteList> checkOnClick = database.favouriteDao().getByUid(param1);
                    for (FavouriteList i : checkOnClick) {
                        Log.i("DEBUG_TAG", "c: " + i);
                    }
                    if (checkOnClick.isEmpty()) {
                        database.favouriteDao().addFavourite(new FavouriteList(vacancy.getVacancyServerUid(), name, salary, desc, date, category, education, work_exp, business, schedule, city, phone, company));
                        imageViewFavourite.setImageResource(R.drawable.ic_heart_svgrepo_com);
                        Log.i("DEBUG_TAG", "try add to favour");
                    }
                    else {
                        database.favouriteDao().deleteAllFavourite(vacancy.getVacancyServerUid());
                        imageViewFavourite.setImageResource(R.drawable.ic_heart_svgrepo_com_2);
                    }
                }
            });
        }
    }

    public void setListener(VacanciesAdapter.OnItemClickListener listener) {
        this.listener = listener;
    }

    public void setVacancyList(List<FavouriteList> vacancyList) {
        this.vacancyList = vacancyList;
        notifyDataSetChanged();
    }
}

