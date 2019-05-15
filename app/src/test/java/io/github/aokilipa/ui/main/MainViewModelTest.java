package io.github.aokilipa.ui.main;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import io.github.aokilipa.repository.ContributionRepository;

import static org.junit.Assert.*;

/**
 * Project Name: 52WeekChallenge
 * Created by Okilipa Antony on 5/10/2019 at 4:28 PM
 */
public class MainViewModelTest {

    private MainViewModel viewModel;

    @Mock
    private ContributionRepository repository;



    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        // Make viewmodel a mock while using mock repository created above
        viewModel = Mockito.spy(new MainViewModel(repository));
    }

    @Test
    public void getContributions() {

    }

    @Test
    public void calculateTotal() {
        MainViewModel viewModel = new MainViewModel(repository);

    }

    @Test
    public void accepts_value_between_0_50m(){

    }
}