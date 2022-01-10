
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author omersahin
 */
public abstract class Course {

    private int id;
    private static int instantNo;
    private String name;
    private int credits;
    private String instructor;
    private double midtermGrade;
    private double finalGrade;
    private double midtermPercentage;
    private double finalPercentage;

    public Course(String name, int credits, double midtermPercentage, double finalPercentage) {
        this.name = name;
        this.credits = credits;
        this.midtermPercentage = midtermPercentage;
        this.finalPercentage = finalPercentage;
        id = instantNo;
        instantNo++;
    }

    public Course(String name, int credits, String instructor) {
        this.name = name;
        this.credits = credits;
        this.instructor = instructor;
    }

    public Course() {
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract void printInfo();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public double getMidtermGrade() {
        return midtermGrade;
    }

    public void setMidtermGrade(double midtermGrade) {
        this.midtermGrade = midtermGrade;
    }

    public double getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(double finalGrade) {
        this.finalGrade = finalGrade;
    }

    public double getMidtermPercentage() {
        return midtermPercentage;
    }

    public void setMidtermPercentage(double midtermPercentage) {
        this.midtermPercentage = midtermPercentage;
    }

    public double getFinalPercentage() {
        return finalPercentage;
    }

    public void setFinalPercentage(double finalPercentage) {
        this.finalPercentage = finalPercentage;
    }
    
    public ArrayList<String> getTableElements() {
        ArrayList list = new ArrayList();
        
        list.add(this.getId());
        list.add(this.getName());
        list.add(this.getCredits());
        list.add(this.getInstructor());
        
        
        return list;
    }
}
