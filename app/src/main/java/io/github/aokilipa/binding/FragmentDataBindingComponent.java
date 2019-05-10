package io.github.aokilipa.binding;

import androidx.fragment.app.Fragment;

/**
 * Project Name: 52WeekChallenge
 * Created by Okilipa Antony on 5/10/2019 at 12:19 PM
 *
 * A Data Binding Component implementation for fragments.
 */

public class FragmentDataBindingComponent implements androidx.databinding.DataBindingComponent {
    private final FragmentBindingAdapter adapter;

    public FragmentDataBindingComponent(Fragment fragment) {
        this.adapter = new FragmentBindingAdapter(fragment);
    }


    public FragmentBindingAdapter getFragmentBindingAdapter() {
        return adapter;
    }

    /*public InverseSpinnerBindings getInverseSpinnerBindings(){
        return new InverseSpinnerBindings();
    }

    public SpinnerBindings getSpinnerBindings(){
        return new SpinnerBindings();
    }
*/
}