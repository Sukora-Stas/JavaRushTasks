package com.javarush.task.task28.task2810;


import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sukora Stas.
 */
public class Controller
{
    private Provider[] providers;

    public Controller(Provider... providers)
    {
        if (providers == null || providers.length == 0)
        {
            throw new IllegalArgumentException();
        }
        this.providers = providers;
    }

    @Override
    public String toString()
    {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }

    public void scan()
    {
        List<Vacancy> vacancies = new ArrayList<>();
        for (Provider provider : providers)
        {
            vacancies.addAll(provider.getJavaVacancies(""));
        }
        System.out.println(vacancies.size());
    }
}