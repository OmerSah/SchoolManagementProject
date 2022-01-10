
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
public class TheoreticalCourse extends Course implements ICalculate, IGenericDao<TheoreticalCourse> {
    private String courseBook;

    public TheoreticalCourse(String name, int credits, double midtermPercentage, double finalPercentage, String courseBook) {
        super(name, credits, midtermPercentage, finalPercentage);
        this.courseBook = courseBook;
    }

    public TheoreticalCourse(String name, int credits, String instructor) {
        super(name, credits, instructor);
    }

    public TheoreticalCourse() {
    }
   
    
    public String getCourseBook() {
        return courseBook;
    }

    public void setCourseBook(String courseBook) {
        this.courseBook = courseBook;
    }

    @Override
    public void printInfo() {
        System.out.println("Teorik Ders: " + this.getId());
        System.out.println("İsim: " + this.getName());
        System.out.println("Kredi: " + this.getCredits());
        System.out.println("Vize yüzdesi: " + this.getMidtermPercentage());
        System.out.println("Final yüzdesi: " + this.getFinalPercentage());
        System.out.println("Kaynak kitap: " + this.courseBook);
    }

    @Override
    public double calculateGPA() {
        return (double)(this.getMidtermGrade() * this.getMidtermGrade() 
                + this.getFinalGrade() * this.getFinalPercentage()) / 100;
    }

    @Override
    public double calculateAverage() {
        return (double)(this.getMidtermGrade() + this.getFinalGrade()) / 2;
    }

    @Override
    public int addRow() throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO sys.theoretical_course VALUES (?, ?, ?, ?, '', '', '')";
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
        String sql = "DELETE FROM sys.theoretical_course WHERE id = "+ this.getId();
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        return stm.executeUpdate();
    }

    @Override
    public int updateRow() throws ClassNotFoundException, SQLException {
        String sql = "UPDATE sys.theoretical_course SET name = ? ,credits= ?, instructor = ?" +
                "WHERE id = " + this.getId();
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1,this.getName());
        stm.setObject(2,this.getCredits());
        stm.setObject(3,this.getInstructor());

        return stm.executeUpdate();
    }

    @Override
    public ArrayList<TheoreticalCourse> retrieveAll() throws ClassNotFoundException, SQLException {
        String query = "SELECT * FROM sys.theoretical_course";
        ArrayList<TheoreticalCourse> list = new ArrayList<TheoreticalCourse>();
        TheoreticalCourse theoreticalCourse;
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs;
        
        rs = statement.executeQuery(query);
        
        while (rs.next()) {
            theoreticalCourse = new TheoreticalCourse(rs.getString("name"), Integer.parseInt(rs.getString("credits")),
                    rs.getString("instructor"));

            theoreticalCourse.setId(rs.getInt("id"));
            list.add(theoreticalCourse);
        }
        return list;

    }
}
