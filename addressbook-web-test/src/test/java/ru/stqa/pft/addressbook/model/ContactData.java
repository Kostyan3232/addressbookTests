package ru.stqa.pft.addressbook.model;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "addressbook")
public class ContactData {
    @Id
    @Column(name = "id")
   private int id ;
    @Column(name = "firstname")
    private  String firstname;
    @Column(name = "middlename")
    private  String middlename;
    @Column(name = "lastname")
    private String lastname;

    @Column(name = "address")
    transient private  String address;
    @Column(name = "home")
    @Type(type = "text")
    private  String homephone;
    @Column(name = "mobile")
    @Type(type = "text")
    private  String mobile;
    @Column(name = "work")
    @Type(type = "text")
    private  String workphone;
    @Column(name = "email")
    transient String email;
    @Column(name = "photo")
    @Type(type = "text")
    private String photo;

    public String getGroup() {
        return group;
    }
    @Transient
    private String group;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "address_in_groups",
            joinColumns = @JoinColumn(name = "id"),inverseJoinColumns = @JoinColumn(name="group_id"))
    private Set<GroupData> groups = new HashSet<GroupData>();

    public Groups getGroups() {
        return new Groups(groups);
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

    public File getPhoto() {
        return new File( photo);
    }



    //public ContactData withtDetail(String detail) {
       // this.detail = detail;
       // return  this;
   // }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    //public String getDetail() {
       // return detail;
   // }

    //private  String detail;

   // public ContactData withAllphones(String allphones) {
       // this.allphones = allphones;
       // return this;
    //}

    //public String getAllphones() {
       // return allphones;
    //}

    //private String allphones;


    ///public ContactDate (String firstname, String lastname, String middlename, String addres, String homephone, String mobile,String workphone) {

       // this.firstname = firstname;
        //this.middlename = middlename;
        //this.lastname = lastname;
        //this.addres = addres;
        //this.homephone = homephone;
        //this.mobile = mobile;
        //this.workphone = workphone;

    //}


    public String getFirstname() {
         return firstname;
  }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
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

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id && Objects.equals(firstname, that.firstname) && Objects.equals(middlename, that.middlename) && Objects.equals(lastname, that.lastname) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, middlename, lastname, address);
    }

    public int getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
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
        this.address = addres;
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



}

