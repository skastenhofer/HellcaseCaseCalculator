package model;

import java.util.ArrayList;

public class Case {
    private String name;
    private ArrayList<Skin> skinList;
    private double price;



    public void getOdds(){
        double win = 0;
        AverageNumber averagewin = new AverageNumber();
        double lose = 0;
        AverageNumber averageloss = new AverageNumber();
        for (Skin skin : skinList){
            win+=skin.getOddsWin(price);
            lose+=skin.getOddsLose(price);
            skin.getAverageWin(price,averagewin);
            skin.getAverageLoss(price,averageloss);
        }
        //Average not working
        System.out.println("\nCase: "+name+": "+price);
        System.out.println("Win: "+win);
        System.out.println("Average Win Value:"+averagewin.getAverage());
        System.out.println("Lose: "+lose);
        System.out.println("Average Loss Value:"+averageloss.getAverage());
    }



    public Case() {
        this.skinList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Skin> getSkinList() {
        return skinList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSkinList(ArrayList<Skin> skinList) {
        this.skinList = skinList;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
