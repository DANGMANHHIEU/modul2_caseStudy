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
                " Môn toán: " + mathScores +
                ", Môn lý: " + physicalScore +
                ", Môn hóa: " + chemistryScore +
                "]";
    }
}
