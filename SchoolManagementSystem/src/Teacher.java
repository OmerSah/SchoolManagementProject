/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author omersahin
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.TreeMap;

public class Teacher extends Person implements IGenericDao<Teacher> {
    private String givenCourses;
    private String guidedStudents;

    public Teacher(String name, String password, String email, String phone, String givenCourses, String guidedStudents) {
        super(name, password, email, phone);
        this.givenCourses = givenCourses;
        this.guidedStudents = guidedStudents;
    }
    
    public Teacher() {}

    public String getGivenCourses() {
        return givenCourses;
    }

    public void setGivenCourses(String givenCourses) {
        this.givenCourses = givenCourses;
    }

    public String getGuidedStudents() {
        return guidedStudents;
    }

    public void setGuidedStudents(String guidedStudents) {
        this.guidedStudents = guidedStudents;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", email='" + this.getEmail() + '\'' +
                ", phone='" + this.getPhone() + '\'' +
                ", givenCourses='" + givenCourses + '\'' +
                ", guidedStudents='" + guidedStudents + '\'' +
                '}';
    }

    @Override
    public int addRow() throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO sys.teacher VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1,this.getId());
        stm.setObject(2,this.getName());
        stm.setObject(3,this.getPassword());
        stm.setObject(4,this.getEmail());
        stm.setObject(5,this.getPhone());
        stm.setObject(6,this.givenCourses);
        stm.setObject(7,this.guidedStudents);

        return stm.executeUpdate();
    }

    @Override
    public int deleteRow() throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM sys.teacher WHERE id = " + this.getId();
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        return stm.executeUpdate();
    }

    @Override
    public int updateRow() throws ClassNotFoundException, SQLException {
        String sql = "UPDATE sys.teacher SET name = ? ,password= ?, email = ?, phone = ?, " +
                "givenCourses = ?, guidedStudents = ? " +
                "WHERE id = " + this.getId();
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1,this.getName());
        stm.setObject(2,this.getPassword());
        stm.setObject(3,this.getEmail());
        stm.setObject(4,this.getPhone());
        stm.setObject(5,this.givenCourses);
        stm.setObject(6,this.guidedStudents);

        return stm.executeUpdate();
    }

    @Override
    public ArrayList<Teacher> retrieveAll() throws ClassNotFoundException, SQLException {
        String query = "SELECT * FROM sys.teacher";
        ArrayList<Teacher> list = new ArrayList<Teacher>();
        ResultSet rs;
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement statement = conn.createStatement();
        Teacher teacher;

        rs = statement.executeQuery(query);
        while (rs.next()) {
            teacher = new Teacher(rs.getString("name"), rs.getString("password"),
                    rs.getString("email"), rs.getString("phone"),
                    rs.getString("givenCourses"),
                    rs.getString("guidedStudents"));

            teacher.setId(rs.getInt("id"));
            list.add(teacher);
        }
        return list;
    }
    
    public ArrayList getAllElements() {
        ArrayList list = new ArrayList();
        
        list.add(this.getId());
        list.add(this.getName());
        list.add(this.getPassword());
        list.add(this.getEmail());
        list.add(this.getPhone());
        list.add(this.givenCourses);
        list.add(this.guidedStudents);
        
        return list;
    }
}
