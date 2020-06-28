package com.example.studentmng;

public class User {
    //int ID;
    String firstname;
    String lastname;
    String favfood;
            String note;
            String noteCc;

    public User(String firstname, String lastname, String favfood,String note,String noteCc) {
        this.firstname = firstname;
        this.lastname= lastname;
        this.favfood= favfood;
        this.note=note;
        this.noteCc=noteCc;
       // this.ID=ID;


    }

  /*  public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }*/

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getFavfood() {
        return favfood;
    }

    public void setFavfood(String favfood) {
        this.favfood = favfood;
    }

   public String getNoteCc() {
        return noteCc;
    }

    public void setNoteCc(String noteCc) {
        this.noteCc = noteCc;
    }
}
