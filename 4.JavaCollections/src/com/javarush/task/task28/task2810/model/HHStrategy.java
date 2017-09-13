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
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 Safari/537.36";
        String referrer = "https://hh.ua/search/vacancy?text=java+Киев";
        Document document = Jsoup.connect(String.format(URL_FORMAT, "Киев", 1)).userAgent(userAgent).referrer(referrer).get();
//        System.out.println(document);
        return new ArrayList<>();
    }

}
