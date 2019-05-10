package io.github.aokilipa.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.github.aokilipa.model.Contribution;
import io.github.aokilipa.vo.ContributionResults;

/**
 * Project Name: 52WeekChallenge
 * Created by Okilipa Antony on 5/10/2019 at 1:18 PM
 */
@Dao
public abstract class ContributionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertContribution(List<Contribution> contributions);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insert(ContributionResults result);

    @Query("SELECT * FROM ContributionResults WHERE id = :id")
    public abstract LiveData<ContributionResults> search(int id);

    @Query("SELECT * FROM contribution WHERE week in(:id)")
    public abstract LiveData<List<Contribution>> selectAll(List<Integer> id);
}
