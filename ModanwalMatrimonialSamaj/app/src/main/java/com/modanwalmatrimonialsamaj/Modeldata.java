package com.modanwalmatrimonialsamaj;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

public class Modeldata
{
   String nameId;
   String state;
   String name;
   String district;
   String gender;
   String profession;
   String parentname;
   String height;
   String color;
   String mob;
   String dob;
   String address;
   String url;
   String email;

    public Modeldata(String nameId, String state, String name, String district, String gender, String profession, String parentname, String height, String color, String mob, String dob, String address, String url,String email) {
        this.nameId = nameId;
        this.state = state;
        this.name = name;
        this.district = district;
        this.gender = gender;
        this.profession = profession;
        this.parentname = parentname;
        this.height = height;
        this.color = color;
        this.mob = mob;
        this.dob = dob;
        this.address = address;
        this.url = url;
        this.email=email;
    }

    public Modeldata() {

    }

    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
        this.nameId = nameId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getParentname() {
        return parentname;
    }

    public void setParentname(String parentname) {
        this.parentname = parentname;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
