package model;

public class Condition {
    private String name;
    private double value;
    private double odds;
    private boolean stattrack;

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public double getOdds() {
        return odds;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setOdds(double odds) {
        this.odds = odds;
    }

    public void setStattrack(boolean stattrack) {
        this.stattrack = stattrack;
    }

    public boolean isStattrack() {
        return stattrack;
    }
}
