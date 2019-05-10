package io.github.aokilipa.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Project Name: 52WeekChallenge
 * Created by Okilipa Antony on 5/10/2019 at 10:57 AM
 *
 * This will hold the weekply contributions
 */
@Entity
public class Contribution {
    @PrimaryKey
    public int week;
    public Integer deposit;
    public Integer total_amount;

    public Contribution(int week, Integer deposit, Integer total_amount) {
        this.week = week;
        this.deposit = deposit;
        this.total_amount = total_amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contribution)) return false;

        Contribution that = (Contribution) o;

        if (week != that.week) return false;
        if (!deposit.equals(that.deposit)) return false;
        return total_amount.equals(that.total_amount);
    }

    @Override
    public int hashCode() {
        int result = week;
        result = 31 * result + deposit.hashCode();
        result = 31 * result + total_amount.hashCode();
        return result;
    }
}
