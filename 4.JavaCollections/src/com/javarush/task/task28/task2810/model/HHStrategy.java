package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sukora Stas.
 */
public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&area=%d";;

    @Override
    public List<Vacancy> getVacancies(String searchString) throws IOException {
        Document document = Jsoup.connect(String.format(URL_FORMAT, "Киев", 1)).get();
//        System.out.println(document);
        return new ArrayList<>();
    }

}
