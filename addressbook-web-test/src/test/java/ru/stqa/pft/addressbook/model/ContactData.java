package ru.stqa.pft.addressbook.model;


import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;

public class ContactData {


    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withAddres(String addres) {
        this.addres = addres;
        return this;
    }

    public ContactData withHomephone(String homephone) {
        this.homephone = homephone;
        return this;
    }

    public ContactData withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public ContactData withWorkphone(String workphone) {
        this.workphone = workphone;
        return this;
    }
    public ContactData withId(int id) {
        this.id = id;
        return this;
    }
    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }
   private  String firstname;

    private  String middlename;

    private String lastname;

    private  String addres;
    private  String homephone;

    private  String mobile;

    private  String workphone;
    private  String email;
    private File photo;

    public ContactData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    public File getPhoto() {
        return photo;
    }

    private int id ;

    public ContactData withtDetail(String detail) {
        this.detail = detail;
        return  this;
    }

    public String getDetail() {
        return detail;
    }

    private  String detail;

    public ContactData withAllphones(String allphones) {
        this.allphones = allphones;
        return this;
    }

    public String getAllphones() {
        return allphones;
    }

    private String allphones;


    ///public ContactDate (String firstname, String lastname, String middlename, String addres, String homephone, String mobile,String workphone) {

       // this.firstname = firstname;
        //this.middlename = middlename;
        //this.lastname = lastname;
        //this.addres = addres;
        //this.homephone = homephone;
        //this.mobile = mobile;
        //this.workphone = workphone;

    //}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }

    @Override
    public String toString() {
        return "ContactDate{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", id=" + id +
                '}';
    }

    public String getFirstname() {
         return firstname;
  }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

   public String getAddres() {
        return addres;
    }

    public String getHomephone() {
        return homephone;
    }

    public String getMobile() {
       return mobile;
    }
    public String getWorkPhone() {
        return workphone;
    }
    public int getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }



}

