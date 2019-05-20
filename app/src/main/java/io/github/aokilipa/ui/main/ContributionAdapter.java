package io.github.aokilipa.ui.main;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;

import java.util.Objects;

import io.github.aokilipa.R;
import io.github.aokilipa.databinding.ItemWeeklyBinding;
import io.github.aokilipa.model.Contribution;
import io.github.aokilipa.ui.base.DataBoundListAdapter;

/**
 * Project Name: 52WeekChallenge
 * Created by Okilipa Antony on 5/10/2019 at 11:01 AM
 */
public class ContributionAdapter extends DataBoundListAdapter<Contribution, ItemWeeklyBinding> {


    private final DataBindingComponent dataBindingComponent;

    public ContributionAdapter(androidx.databinding.DataBindingComponent dataBindingComponent) {
        this.dataBindingComponent = dataBindingComponent;
    }

    @Override
    protected ItemWeeklyBinding createBinding(ViewGroup parent) {
        ItemWeeklyBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_weekly,parent,false,dataBindingComponent);

        return binding;
    }

    @Override
    protected void bind(ItemWeeklyBinding binding, Contribution item) {
        binding.setContribution(item);
    }

    @Override
    protected boolean areItemsTheSame(Contribution oldItem, Contribution newItem) {
        return Objects.equals(oldItem.week,newItem.week);
    }

    @Override
    protected boolean areContentsTheSame(Contribution oldItem, Contribution newItem) {
        return Objects.equals(oldItem.deposit,newItem.deposit);
    }
}
