package model;

public class AverageNumber {
    private int count;
    private double sum;

    public AverageNumber() {
        this.count = 0;
        this.sum = 0;
    }

    public void add(double x){
        this.count++;
        this.sum+=x;

    }

    public double getAverage(){
        return this.sum/this.count;
    }

    public int getCount() {
        return count;
    }

    public double getSum() {
        return sum;
    }
}
