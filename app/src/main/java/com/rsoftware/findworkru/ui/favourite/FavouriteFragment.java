package com.rsoftware.findworkru.ui.favourite;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rsoftware.findworkru.R;
import com.rsoftware.findworkru.databinding.FragmentFavouriteBinding;
import com.rsoftware.findworkru.model.FavouriteAdapter;
import com.rsoftware.findworkru.model.FavouriteList;
import com.rsoftware.findworkru.model.FavouritePresenter;
import com.rsoftware.findworkru.model.VacanciesAdapter;
import com.rsoftware.findworkru.screens.SearchResultsActivity;
import com.rsoftware.findworkru.screens.VacancyInfoActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FavouriteFragment extends Fragment {

    private FavouriteViewModel favouriteViewModel;
    private FragmentFavouriteBinding binding;
    private RecyclerView recyclerViewFavourite;
    private TextView textViewFavouriteEmpty;
    private FavouriteAdapter adapter;
    private FavouritePresenter presenter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        favouriteViewModel =
                new ViewModelProvider(this).get(FavouriteViewModel.class);

        binding = FragmentFavouriteBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerViewFavourite = root.findViewById(R.id.recyclerViewFavourite);
        textViewFavouriteEmpty = root.findViewById(R.id.textViewFavouriteEmpty);
        adapter = new FavouriteAdapter();
        recyclerViewFavourite.setLayoutManager(new LinearLayoutManager(root.getContext()));
        adapter.setVacancyList(new ArrayList<FavouriteList>());
        recyclerViewFavourite.setAdapter(adapter);
        presenter = new FavouritePresenter();
        List<FavouriteList> list = presenter.LoadData(root.getContext());
        if (!list.isEmpty()) {
            textViewFavouriteEmpty.setVisibility(View.INVISIBLE);
            adapter.setVacancyList(list);
            adapter.setListener(new VacanciesAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int pos, String vacancyName, String vacancySalary, String vacancyDescription, String date, String category, String education, String work_exp, String business, String schedule, String city, String phone, String company) {
                    Intent intent = new Intent(root.getContext(), VacancyInfoActivity.class);
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
                    getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }
            });
        }
        else {
            textViewFavouriteEmpty.setVisibility(View.VISIBLE);
        }
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}