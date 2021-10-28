package com.exercises.Exercise_01;

public class Student {

    private int id;
    private String name;
    private String email;
    private double bonus;
    private double report;
    private double app;
    private double lt;

    public double getFinalPoint() {
        double finalPoint = this.finalPoint * 0.1 + this.report * 0.3 + this.app * 0.15 + this.lt * 0.45;
        return Student.roundPoint(finalPoint, 2);
    }

    public void setFinalPoint(double finalPoint) {
        this.finalPoint = finalPoint;
    }

    private double finalPoint;

    public Student() {
    }

    public Student(int id, String name, String email, double bonus, double report, double app, double lt, double finalPoint) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.bonus = bonus;
        this.report = report;
        this.app = app;
        this.lt = lt;
        this.finalPoint = finalPoint;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getReport() {
        return report;
    }

    public void setReport(double report) {
        this.report = report;
    }

    public double getApp() {
        return app;
    }

    public void setApp(double app) {
        this.app = app;
    }

    public double getLt() {
        return lt;
    }

    public void setLt(double lt) {
        this.lt = lt;
    }


    public static double roundPoint(double value, int position) {
        if (position < 0) {
            throw new IllegalArgumentException();
        }

        long factor = (long) Math.pow(10, position);
        value = value * factor;
        long temporary = Math.round(value);
        return (double) temporary / factor;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", bonus=" + bonus +
                ", report=" + report +
                ", app=" + app +
                ", lt=" + lt +
                ", finalPoint=" + finalPoint +
                '}';
    }
}
