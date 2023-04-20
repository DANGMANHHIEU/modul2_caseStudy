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
        return "*** Student {" +
                " Mã sinh viên: " + id +
                "| Họ và tên: " + name +
                "| Giới tính: " + gender +
                "| Ngày sinh: " + dateOfBrith +
                "| Email: " + email +"\n"+
                "| SĐT: "+phoneNumber+
                " Địa chỉ: " + address +"\n"+
                " Điểm: " + scores +
                "==> Điểm trung bình: "+this.averageOfSubject()+
                "}"+
                "\n"+
                "----------------------------";
    }
}
