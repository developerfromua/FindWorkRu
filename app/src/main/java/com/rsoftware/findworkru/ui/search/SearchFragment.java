package com.rsoftware.findworkru.ui.search;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputLayout;
import com.rsoftware.findworkru.R;
import com.rsoftware.findworkru.databinding.FragmentSearchBinding;
import com.rsoftware.findworkru.screens.SearchResultsActivity;


public class SearchFragment extends Fragment {


    private FragmentSearchBinding binding;
    private SearchView searchView = null;
    private Button buttonSearchVacancies;
    private EditText editTextSearchText;
    private Spinner spinnerSearchCategories;
    private Spinner spinnerSearchCity;
    private Spinner spinnerSearchWorkExp;
    private Spinner spinnerSearchBusiness;
    private Spinner spinnerSearchSchedule;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSearchBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        buttonSearchVacancies = (Button) root.findViewById(R.id.buttonSearchVacancies);
        editTextSearchText = (EditText) root.findViewById(R.id.editTextSearchText);
        spinnerSearchCategories = (Spinner) root.findViewById(R.id.spinnerSearchCategories);
        spinnerSearchCity = (Spinner) root.findViewById(R.id.spinnerSearchCity);
        spinnerSearchWorkExp = (Spinner) root.findViewById(R.id.spinnerSearchWorkExp);
        spinnerSearchBusiness = (Spinner) root.findViewById(R.id.spinnerSearchBusiness);
        spinnerSearchSchedule = (Spinner) root.findViewById(R.id.spinnerSearchSchedule);
        buttonSearchVacancies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String empty = "Не выбрано";
                String category = spinnerSearchCategories.getSelectedItem().toString();
                String city = spinnerSearchCity.getSelectedItem().toString();
                String work_exp = spinnerSearchWorkExp.getSelectedItem().toString();
                String business = spinnerSearchBusiness.getSelectedItem().toString();
                String schedule = spinnerSearchSchedule.getSelectedItem().toString();
                Intent intent = new Intent(root.getContext(), SearchResultsActivity.class);
                intent.putExtra("search_title", editTextSearchText.getText().toString());
                if (!category.equals(empty)) {
                    intent.putExtra("category", category);
                }
                if (!city.equals(empty)) {
                    intent.putExtra("city", city);
                }
                if (!work_exp.equals(empty)) {
                    intent.putExtra("work_exp", work_exp);
                }
                if (!business.equals(empty)) {
                    intent.putExtra("business", business);
                }
                if (!schedule.equals(empty)) {
                    intent.putExtra("schedule", schedule);
                }
                startActivity(intent);
            }
        });
     //   setHasOptionsMenu(true);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}


