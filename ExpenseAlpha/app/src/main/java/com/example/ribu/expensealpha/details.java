package com.example.ribu.expensealpha;

/**
 * Created by ribu on 24-Sep-15.
 */
public class details {


    String cat, description, date1, time1;
    String expense, id;


    int dy, mn, yr;

    details(String id, String expense, String cat, String description, String time1, String date1, int dy, int mn, int yr) {
        this.id = id;
        this.expense = expense;
        this.cat = cat;
        this.description = description;
        this.time1 = time1;
        this.date1 = date1;
        this.dy = dy;
        this.mn = mn;
        this.yr = yr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getExpense() {
        return expense;
    }

    public void setExpense(String expense) {
        this.expense = expense;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getMn() {
        return mn;
    }

    public void setMn(int mn) {
        this.mn = mn;
    }

    public int getYr() {
        return yr;
    }

    public void setYr(int yr) {
        this.yr = yr;
    }
}
