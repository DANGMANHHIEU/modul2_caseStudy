package model;

import java.io.Serializable;
import java.time.LocalDate;

import static model.Scores.*;

public class Student implements Serializable {
    //lựa chon giới tính
    public enum Gender{
        Nam,Nữ,Khác;
    }
    private String id;
    private String name;
    private Gender gender;
    private LocalDate dateOfBrith;
    private String phoneNumber;
    private Address address;
    private String email;
    private Scores scores;

    public Student() {
    }

    public Student(String id, String name, Gender gender, LocalDate dateOfBrith, String phoneNumber, Address address, String email, Scores scores) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dateOfBrith = dateOfBrith;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.scores = scores;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBrith() {
        return dateOfBrith;
    }

    public void setDateOfBrith(LocalDate dateOfBrith) {
        this.dateOfBrith = dateOfBrith;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Scores getScores() {
        return scores;
    }

    public void setScores(Scores scores) {
        this.scores = scores;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double averageOfSubject(){
        double average= (scores.getMathScores()+scores.getPhysicalScore()+scores.getChemistryScore())/3;
        return average;
    }
    @Override
    public String toString() {
        return "***"+"\u001B[31m"+" Student"+"\u001B[0m"+" {" +
                "\u001B[32m"+ " Mã sinh viên: " +"\u001B[0m"+ id +
                "\u001B[32m"+"| Họ và tên: "+"\u001B[0m" + name +
                "\u001B[32m"+  "| Giới tính: "+"\u001B[0m" + gender +
                "\u001B[32m"+"| Ngày sinh: "+"\u001B[0m" + dateOfBrith +
                "\u001B[32m"+ "| Email: "+"\u001B[0m" + email +"\n"+
                "\u001B[32m"+ "| SĐT: "+"\u001B[0m"+phoneNumber+
                "\u001B[32m"+  " Địa chỉ: "+"\u001B[0m" + address +"\n"+
               "\u001B[32m"+ " Điểm: "+"\u001B[0m" + scores +
                "\u001B[32m"+ "==> Điểm trung bình: "+"\u001B[0m"+this.averageOfSubject()+
                "}"+
                "\n"+
                "------------------------------------";
    }
}
