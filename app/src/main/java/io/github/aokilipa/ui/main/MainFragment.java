package io.github.aokilipa.ui.main;

import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.github.aokilipa.R;
import io.github.aokilipa.binding.FragmentDataBindingComponent;
import io.github.aokilipa.databinding.MainFragmentBinding;
import io.github.aokilipa.ui.base.BaseFragment;
import io.github.aokilipa.utils.AutoClearedValue;
import io.github.aokilipa.utils.Calculator;
import timber.log.Timber;

public class MainFragment extends BaseFragment {

    private MainViewModel mViewModel;

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
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel

        ContributionAdapter contributionAdapter = new ContributionAdapter(dataBindingComponent);
        binding.get().rvWeeks.setAdapter(contributionAdapter);
        adapter = new AutoClearedValue<>(this,contributionAdapter);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Calculator.calculateTotal(50, 54);
    }
}
