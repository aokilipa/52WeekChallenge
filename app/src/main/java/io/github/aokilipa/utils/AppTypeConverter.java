package io.github.aokilipa.utils;

import android.annotation.SuppressLint;

import androidx.room.TypeConverter;
import androidx.room.util.StringUtil;

import java.util.Collections;
import java.util.List;

/**
 * Project Name: 52WeekChallenge
 * Created by Okilipa Antony on 5/10/2019 at 1:31 PM
 */
public class AppTypeConverter {
    @SuppressLint("RestrictedApi")
    @TypeConverter
    public static List<Integer> stringToIntList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }
        return StringUtil.splitToIntList(data);
    }

    @SuppressLint("RestrictedApi")
    @TypeConverter
    public static String intListToString(List<Integer> ints) {
        return StringUtil.joinIntoString(ints);
    }
}
