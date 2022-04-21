package com.rsoftware.findworkru.model.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rsoftware.findworkru.R;
import com.rsoftware.findworkru.model.database.Database;
import com.rsoftware.findworkru.model.database.FavouriteList;
import com.rsoftware.findworkru.model.Vacancy;

import java.util.List;

public class VacanciesAdapter extends RecyclerView.Adapter<VacanciesAdapter.VacanciesViewHolder> {

    private List<Vacancy> vacancies;
    private OnItemClickListener listener;
    private OnReachEndListener onReachEndListener;
    private Database database;
    private List<FavouriteList> favouriteFromDb;


    public interface OnItemClickListener {
        void onItemClick(int pos, String vacancyName, String vacancySalary, String vacancyDescription, String date, String category, String education, String work_exp, String business, String schedule, String city, String phone, String company);
    }

    public interface OnReachEndListener {
        void onReachEnd();
    }

    public void setOnReachEndListener(OnReachEndListener onReachEndListener) {
        this.onReachEndListener = onReachEndListener;
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public VacanciesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vacancy_card_item_layout, parent, false);
        return new VacanciesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VacanciesViewHolder holder, int position) {
        if (vacancies.size() >= 10 && position > vacancies.size() - 2 && onReachEndListener != null) {
            onReachEndListener.onReachEnd();
        }
        holder.bind(vacancies.get(position));
    }

    @Override
    public int getItemCount() {
        return vacancies.size();
    }

    class VacanciesViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewVacancyName;
        private TextView textViewVacancySalary;
        private TextView textViewVacancyCity;
        private TextView textViewVacancyDate;
        private TextView textViewVacancyDesc;
        private ImageView imageViewFavourite;

        public VacanciesViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewVacancyName = (TextView) itemView.findViewById(R.id.textViewVacancyName);
            textViewVacancySalary = (TextView) itemView.findViewById(R.id.textViewVacancySalary);
            textViewVacancyCity = (TextView) itemView.findViewById(R.id.textViewVacancyCity);
            textViewVacancyDate = (TextView) itemView.findViewById(R.id.textViewVacancyDate);
            textViewVacancyDesc = (TextView) itemView.findViewById(R.id.textViewVacancyDesc);
            imageViewFavourite = (ImageView) itemView.findViewById(R.id.imageViewFavourite);
        }

        public void bind(Vacancy vacancy) {
            Log.i("DEBUG_TAG", vacancy.getVacancy_uid());
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
            imageViewFavourite.setImageResource(R.drawable.ic_heart_svgrepo_com_2);
            database = Database.getInstance(itemView.getContext());
            getFavourite();
            String param1 = vacancy.getVacancy_uid();
            List<FavouriteList> param2 = database.favouriteDao().getByUid(param1);
            for (FavouriteList i : param2) {
                if (i.getVacancyServerUid().equals(param1)){
                    imageViewFavourite.setImageResource(R.drawable.ic_heart_svgrepo_com);
                }
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.onItemClick(getAdapterPosition(), name, salary, desc, date, category, education, work_exp, business, schedule, city, phone, company);
                        Log.i("DEBUG_TAG", String.valueOf(getAdapterPosition()));
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
                        database.favouriteDao().addFavourite(new FavouriteList(vacancy.getVacancy_uid(), name, salary, desc, date, category, education, work_exp, business, schedule, city, phone, company));
                        imageViewFavourite.setImageResource(R.drawable.ic_heart_svgrepo_com);
                        Log.i("DEBUG_TAG", "try add to favour");
                    }
                    else {
                        database.favouriteDao().deleteAllFavourite(vacancy.getVacancy_uid());
                        imageViewFavourite.setImageResource(R.drawable.ic_heart_svgrepo_com_2);
                    }
                }
            });
        }
    }

    public void clearVacancies() {
        this.vacancies = null;
        notifyDataSetChanged();
    }

    public void setVacancies(List<Vacancy> vacancies) {
        this.vacancies = vacancies;
        notifyDataSetChanged();
    }

    public void addVacancies(List<Vacancy> vacancies) {
        for (Vacancy i : vacancies) {
            this.vacancies.add(i);
        }
        notifyDataSetChanged();
    }

    private void getFavourite() {
        favouriteFromDb = database.favouriteDao().getAllFavourites();
    }
}
