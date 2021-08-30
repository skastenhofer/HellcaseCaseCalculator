package model;

import java.util.ArrayList;

public class Skin {
    private String name;
    private String weapon;
    private ArrayList<Condition> conditions;

    public double getOddsWin (double casePrice){
        double win = 0;
        for (Condition condition : conditions){
            if(condition.getValue()>=casePrice){
                win+=condition.getOdds();
            }
        }
        return win;
    }

    public double getOddsLose (double casePrice){
        double lose = 0;
        for (Condition condition : conditions){
            if(condition.getValue()<casePrice){
                lose+=condition.getOdds();
            }
        }
        return lose;
    }
    public void getAverageWin(double price, AverageNumber averagewin) {
        for (Condition condition : conditions){
            if(condition.getValue()>=price){
                averagewin.add(condition.getValue());
            }
        }
    }

    public void getAverageLoss(double price, AverageNumber averageLoss) {
        for (Condition condition : conditions){
            if(condition.getValue()<price){
                averageLoss.add(condition.getValue());
            }
        }
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setConditions(ArrayList<Condition> conditions) {
        this.conditions = conditions;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Condition> getConditions() {
        return conditions;
    }

    public String getWeapon() {
        return weapon;
    }


}
