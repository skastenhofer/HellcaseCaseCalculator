import model.Case;
import model.Condition;
import model.Skin;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class HellcaseCaseDownloader {
    private Case hellCase= new Case();
    private static String URL;

    public HellcaseCaseDownloader(String url) {
        this.hellCase.setName(url);
        this.URL = "https://hellcase.com/en/open/"+url;
    }

    public void downloadCase(){ // wandelt die URL in die Element-List
        try{
            Document doc = Jsoup.connect(URL).get();
            Elements elements = doc.getAllElements();
            hellCase.setPrice(Double.parseDouble(parseCasePrice(doc.getElementsByTag("small"))));
            for (Element element : elements) {
                if(element.attr("class").equals("item-wrap")){
                    parseSkin(element.getAllElements());
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    private String parseCasePrice(Elements elements) {
        return elements.get(0).text();
    }

    private void parseSkin(Elements elements) { // Sucht Conditions des Skins
        Skin skin=new Skin();
        for (Element element : elements) {
            if(element.attr("class").equals("admin-info")){
                skin.setConditions(parseConditions(element.getElementsByClass("odds-table")));
            }
            if(element.attr("class").equals("base-item is-size-7 item")){
                skin.setName(parseSkinName(element.children()));
                skin.setWeapon(parseSkinWeapon(element.children()));
            }
        }
        hellCase.getSkinList().add(skin);
    }

    private String parseSkinWeapon(Elements elements) {
        for (Element x : elements){
            if(x.attr("class").equals("base-item__inner is-flex is-flex-direction-column")){
                for (Element element : x.getAllElements()){
                    if(element.attr("class").equals("base-item__weapon has-text-weight-bold is-capitalized")){
                        return element.text();
                    }
                }
            }
        }
        return "";
    }

    private String parseSkinName(Elements elements) {
        for (Element x : elements){
            if(x.attr("class").equals("base-item__inner is-flex is-flex-direction-column")){
                for (Element element : x.getAllElements()){
                    if(element.attr("class").equals("base-item__skin")){
                        return element.text();
                    }
                }
            }
        }
        return "";
    }

    private ArrayList<Condition> parseConditions(Elements elements) {
        ArrayList<Condition> conditions = new ArrayList<>();
        if(elements.size()==1){
            elements = elements.get(0).getElementsByTag("tbody").get(0).children();
        }
        for (Element element : elements){
            conditions.add(parseCondition(element));
        }
        return conditions;
    }

    private Condition parseCondition(Element parent) {
        Condition condition = new Condition();

        if(parent.hasAttr("class") && parent.attr("class").equals("stattrack")){
            condition.setStattrack(true);
        }

        for(Element element : parent.children() ){
            if(element.attr("class").equals("quality")){
                condition.setName(element.text());
            }
            if(element.attr("class").equals("price")){
                condition.setValue(Double.parseDouble(element.text()));
            }
            if(element.attr("class").equals("odds-number")){
                condition.setOdds(Double.parseDouble(element.text().replace( '%','0')));
            }
        }

        return condition;
    }

    public Case getHellCase() {
        return hellCase;
    }
}
