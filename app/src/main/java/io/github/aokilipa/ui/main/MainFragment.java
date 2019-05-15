package io.github.aokilipa.ui.main;

import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;

import javax.inject.Inject;

import io.github.aokilipa.R;
import io.github.aokilipa.binding.FragmentDataBindingComponent;
import io.github.aokilipa.databinding.MainFragmentBinding;
import io.github.aokilipa.di.Injectable;
import io.github.aokilipa.ui.base.BaseFragment;
import io.github.aokilipa.utils.AutoClearedValue;
import io.github.aokilipa.utils.Calculator;
import timber.log.Timber;

public class MainFragment extends BaseFragment implements Injectable {

    final int NUM_OF_WEEKS = 52;

    @Inject
    ViewModelProvider.Factory factory;
    private MainViewModel viewModel;

    DataBindingComponent dataBindingComponent = new FragmentDataBindingComponent(this);

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    private AutoClearedValue<MainFragmentBinding> binding;
    private AutoClearedValue<ContributionAdapter> adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        MainFragmentBinding mainFragmentBinding = DataBindingUtil
                .inflate(inflater, R.layout.main_fragment,container,false,dataBindingComponent);
        binding = new AutoClearedValue<>(this,mainFragmentBinding);
        return mainFragmentBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this,factory).get(MainViewModel.class);
         init();

        ContributionAdapter contributionAdapter = new ContributionAdapter(dataBindingComponent);
        binding.get().rvWeeks.setAdapter(contributionAdapter);
        adapter = new AutoClearedValue<>(this,contributionAdapter);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public void init(){

        binding.get().etDeposit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (s!=null && s.toString().length()!=0){

                        long deposit = Long.parseLong(s.toString());
                            if (deposit<50000000 && deposit>0){
                                viewModel.calculateTotal(deposit,NUM_OF_WEEKS);
                            }

                    }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        viewModel.getContributions().observe(this, result -> {

            long totalSaving;

            binding.get().setResultCount((result == null)
                    ? 0 : result.size());
            adapter.get().replace(result);

            if (result != null && result.size()>0){
                totalSaving = result.get(result.size() -1).total_amount;
                binding.get().etTotalSaving.setText(String.valueOf(totalSaving));
            }
            //binding.get().etTotalSaving.setText("");
            binding.get().executePendingBindings();
        });
    }
}
