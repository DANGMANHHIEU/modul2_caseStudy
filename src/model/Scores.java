package model;

import java.io.Serializable;

public class Scores implements Serializable {
    private double mathScores;
    private double physicalScore;
    private double chemistryScore;

    public Scores() {
    }

    public Scores(double mathScores, double physicalScore, double chemistryScore) {
        this.mathScores = mathScores;
        this.physicalScore = physicalScore;
        this.chemistryScore = chemistryScore;
    }

    public double getMathScores() {
        return mathScores;
    }

    public void setMathScores(double mathScores) {
        this.mathScores = mathScores;
    }

    public double getPhysicalScore() {
        return physicalScore;
    }

    public void setPhysicalScore(double physicalScore) {
        this.physicalScore = physicalScore;
    }

    public double getChemistryScore() {
        return chemistryScore;
    }

    public void setChemistryScore(double chemistryScore) {
        this.chemistryScore = chemistryScore;
    }




    @Override
    public String toString() {
        return "[" +
                "\u001B[32m"+  " Môn toán: "+"\u001B[0m"+ mathScores +
                "\u001B[32m"+", Môn lý: " +"\u001B[0m"+ physicalScore +
                "\u001B[32m"+ ", Môn hóa: "+"\u001B[0m" + chemistryScore +
                "]";
    }
}
