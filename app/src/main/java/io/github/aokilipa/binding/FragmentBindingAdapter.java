package io.github.aokilipa.binding;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Project Name: 52WeekChallenge
 * Created by Okilipa Antony on 5/10/2019 at 12:20 PM
 *
 * Binding adapter that works with fragment instance
 */

public class FragmentBindingAdapter {
    private final Fragment fragment;

    @Inject
    public FragmentBindingAdapter(Fragment fragment) {
        this.fragment = fragment;
    }


}
