package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoikrugStrategy implements Strategy {
    //private static final String URL_FORMAT = "https://career.habr.com/vacancies?q=java+%s&page=%d";
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d"; //для валика

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        ArrayList<Vacancy> vacancies = new ArrayList<>();
        int page = 0;
        Document document = null;
        while (true) {
            document = getDocument(searchString, page);
            if (document == null) break;
            Elements vacElements = document.getElementsByAttributeValue("class", "job");
            vacElements.addAll(document.getElementsByAttributeValue("class", "job marked"));
            if (vacElements.size() == 0) {
                page = 0;
                break;
            }
            for (Element element: vacElements) {
                String title = element.getElementsByAttributeValue("class","title").text();
                String city = element.getElementsByAttributeValue("class","location").text();
                String companyName = element.getElementsByAttributeValue("class","company_name").text();
                //String siteName = "https://career.habr.com";
                String siteName = "https://moikrug.ru"; //для валика
                String salary = element.getElementsByAttributeValue("class","count").text();
                String url = siteName + element.getElementsByAttributeValueContaining("class", "job_icon").attr("href");

                Vacancy vacancy = new Vacancy();
                vacancy.setTitle(title);
                vacancy.setCity(city);
                vacancy.setCompanyName(companyName);
                vacancy.setSalary(salary);
                vacancy.setUrl(url);
                vacancy.setSiteName(siteName);
                vacancies.add(vacancy);
                //System.out.println(vacancy);
            }
            page++;
        }
        return vacancies;
    }

    protected Document getDocument(String searchString, int page) {
        String url = String.format(URL_FORMAT, searchString, page);
        Document document = null;
        try {
            Connection connection = Jsoup.connect(url);
            connection.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.132 Safari/537.36 OPR/67.0.3575.79");
            //connection.referrer("https://hh.ua/search/vacancy?text=java+%D0%BA%D0%B8%D0%B5%D0%B2");
            connection.referrer("");
            document = connection.get();
        } catch (IOException e) {
        }
        return document;
    }
}
