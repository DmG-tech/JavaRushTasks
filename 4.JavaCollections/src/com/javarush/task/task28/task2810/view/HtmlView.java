package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HtmlView implements  View{
    private Controller controller;
    private final String filePath = "./4.JavaCollections/src/"+this.getClass().getPackage().getName().replace('.', '/')+"/vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies) {
        String s = getUpdatedFileContent(vacancies);
        try {
            updateFile(s);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) {
        Document document = null;
        try {
            document = getDocument();

        Element template = document.getElementsByClass("template").first().clone();
        template.removeAttr("style");
        template.removeClass("template");
        document.getElementsByAttributeValue("class", "vacancy").remove();
        for (Vacancy vacancy: vacancies) {
            template.getElementsByClass("city").html(vacancy.getCity());
            template.getElementsByClass("companyName").html(vacancy.getCompanyName());
            template.getElementsByClass("salary").html(vacancy.getSalary());
            template.getElementsByClass("title").attr("href", vacancy.getUrl()).html(vacancy.getTitle());
            document.getElementsByAttributeValue("class", "vacancy template").first().before(template.outerHtml());
        }
        } catch (IOException e) {
            e.printStackTrace();
            return "Some exception occurred";
        }
        return document.html();
    }

    private void updateFile(String s) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.write(s);
        writer.close();
    }

    protected Document getDocument() throws IOException {
        Document document = Jsoup.parse(new File(filePath), "UTF-8");
        return document;
    }
}