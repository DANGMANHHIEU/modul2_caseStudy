package model;

import java.io.Serializable;

public class Address implements Serializable {
    private String homeNumber;   //số nhà
    private String social;     //xã
    private String provincial;   // huyện
    private String districts;    //tỉnh

    public Address() {
    }

    public Address(String homeNumber, String social, String provincial, String districts) {
        this.homeNumber = homeNumber;
        this.social = social;
        this.provincial = provincial;
        this.districts = districts;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getSocial() {
        return social;
    }

    public void setSocial(String social) {
        this.social = social;
    }

    public String getProvincial() {
        return provincial;
    }

    public void setProvincial(String provincial) {
        this.provincial = provincial;
    }

    public String getDistricts() {
        return districts;
    }

    public void setDistricts(String districts) {
        this.districts = districts;
    }

    @Override
    public String toString() {
        return "[" +
                "Số nhà: " + homeNumber  +
                ", Xã: " + social  +
                ", Huyện: " + provincial  +
                ", Tỉnh: " + districts  +
                "]";
    }
}
