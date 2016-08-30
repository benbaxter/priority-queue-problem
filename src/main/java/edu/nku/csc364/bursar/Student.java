package edu.nku.csc364.bursar;


public class Student {

    private String name;
    private double gpa;
    private ClassStatus status;
    private int token;

    public Student(String name, double gpa, ClassStatus status) {
        this.name = name;
        this.gpa = gpa;
        this.status = status;
    }

    public Student(String name, double gpa, int token) {
        this.name = name;
        this.gpa = gpa;
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public ClassStatus getStatus() {
        return status;
    }

    public int getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "{" + name + ", " + gpa + ", " + status + ", " + token + "}";
    }
}
