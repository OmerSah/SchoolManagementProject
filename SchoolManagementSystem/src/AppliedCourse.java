
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author omersahin
 */
public class AppliedCourse extends Course implements ICalculate, IGenericDao<AppliedCourse> {
    private double labGrade;
    private double projectGrade;
    private double labPercentage;
    private double projectPercentage;

    public AppliedCourse(String name, int credits, double midtermPercentage, double finalPercentage, double labPercentage, double projectPercentage) {
        super(name, credits, midtermPercentage, finalPercentage);
        this.labPercentage = labPercentage;
        this.projectPercentage = projectPercentage;
    }

    public AppliedCourse(String name, int credits, String instructor) {
        super(name, credits, instructor);
    }

    public AppliedCourse() {
    }
    
    
    public double getLabGrade() {
        return labGrade;
    }

    public void setLabGrade(double labGrade) {
        this.labGrade = labGrade;
    }

    public double getProjectGrade() {
        return projectGrade;
    }

    public void setProjectGrade(double projectGrade) {
        this.projectGrade = projectGrade;
    }

    public double getLabPercentage() {
        return labPercentage;
    }

    public void setLabPercentage(double labPercentage) {
        this.labPercentage = labPercentage;
    }

    public double getProjectPercentage() {
        return projectPercentage;
    }

    public void setProjectPercentage(double projectPercentage) {
        this.projectPercentage = projectPercentage;
    }

    @Override
    public void printInfo() {
        System.out.println("Uygulamalı Ders: " + this.getId());
        System.out.println("İsim: " + this.getName());
        System.out.println("Kredi: " + this.getCredits());
        System.out.println("Vize yüzdesi: " + this.getMidtermPercentage());
        System.out.println("Final yüzdesi: " + this.getFinalPercentage());
        System.out.println("Lab yüzdesi: " + this.labPercentage);
        System.out.println("Proje yüzdesi: " + this.projectPercentage);
    }

    @Override
    public double calculateGPA() {
        return (double)(this.getMidtermGrade() * this.getMidtermGrade() + this.getFinalGrade() * this.getFinalPercentage()
                + this.labGrade * this.labPercentage + this.projectPercentage * this.projectGrade) / 100;
    }

    @Override
    public double calculateAverage() {
        return (double)(this.getMidtermGrade() + this.getFinalGrade() + this.projectGrade + this.labGrade) / 4;
    }

    @Override
    public int addRow() throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO sys.applied_course VALUES (?, ?, ?, ?, '', '', '', '')";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        
        stm.setObject(1,this.getId());
        stm.setObject(2,this.getName());
        stm.setObject(3,this.getCredits());
        stm.setObject(4,this.getInstructor());
        

        return stm.executeUpdate();
    }

    @Override
    public int deleteRow() throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM sys.applied_course WHERE id = "+ this.getId();
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        return stm.executeUpdate();
    }

    @Override
    public int updateRow() throws ClassNotFoundException, SQLException {
        String sql = "UPDATE sys.applied_course SET name = ? ,credits= ?, instructor = ?" +
                "WHERE id = " + this.getId();
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1,this.getName());
        stm.setObject(2,this.getCredits());
        stm.setObject(3,this.getInstructor());

        return stm.executeUpdate();
    }

    @Override
    public ArrayList<AppliedCourse> retrieveAll() throws ClassNotFoundException, SQLException {
        String query = "SELECT * FROM sys.applied_course";
        ArrayList<AppliedCourse> list = new ArrayList<AppliedCourse>();
        AppliedCourse appliedCourse;
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs;
        
        rs = statement.executeQuery(query);
        
        while (rs.next()) {
            appliedCourse = new AppliedCourse(rs.getString("name"), Integer.parseInt(rs.getString("credits")),
                    rs.getString("instructor"));

            appliedCourse.setId(rs.getInt("id"));
            list.add(appliedCourse);
        }
        return list;
    }
}

