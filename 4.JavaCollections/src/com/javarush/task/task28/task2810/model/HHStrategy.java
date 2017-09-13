package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Sukora Stas.
 */
public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&area=%d";

//    @Override
//    public List<Vacancy> getVacancies(String searchString) throws IOException {
//        String url = String.format(URL_FORMAT, searchString, 1);
//        Document document = Jsoup.connect(url)
//                .userAgent("Mozilla")
//                .referrer("https://hh.ua")
//                .get();
//        System.out.println(document);
//        return new ArrayList<>();
//    }

    @Override
    public List<Vacancy> getVacancies(String searchString) throws IOException {
        List<Vacancy> vacancies = new ArrayList<>();

        for (int i = 0; ; i++) {
            Document document = getDocument(URL_FORMAT, i);

            System.out.println(document);

            Elements plainVacancies = document.select("[data-qa=\"vacancy-serp__vacancy\"]");
            if (plainVacancies.size() == 0) {
                break;
            }
            Iterator iterator = plainVacancies.iterator();
            Element rawVacancy;
            while (iterator.hasNext()) {
                Vacancy vacancy = new Vacancy();
                rawVacancy = (Element) iterator.next();

                vacancy.setTitle(rawVacancy.select("[data-qa=\"vacancy-serp__vacancy-title\"]").first().text());

                Elements salaries = rawVacancy.select("[data-qa=\"vacancy-serp__vacancy-compensation\"]");
                if (salaries.size() > 0) {
                    vacancy.setSalary(salaries.first().text());
                } else {
                    vacancy.setSalary("");
                }

                vacancy.setCity(rawVacancy.select("[data-qa=\"vacancy-serp__vacancy-address\"]").first().text());
                vacancy.setCompanyName(rawVacancy.select("[data-qa=\"vacancy-serp__vacancy-employer\"]").first().text());
                vacancy.setSiteName("hh.ru");
                vacancy.setUrl(rawVacancy.select("[data-qa=\"vacancy-serp__vacancy-title\"]").first().attr("href"));

                vacancies.add(vacancy);
            }
        }
        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        String url = String.format(URL_FORMAT, searchString, 1);
        Document document = Jsoup.connect(url)
                .userAgent("Mozilla")
                .referrer("https://hh.ua")
                .get();
        System.out.println(document);
        return document;
    }

}
