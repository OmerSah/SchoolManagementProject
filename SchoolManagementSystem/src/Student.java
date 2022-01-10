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

public class Student extends Person implements IGenericDao<Student>{
    private String takenCourses;
    private String parentName;
    private String guideTeacher;

    public Student() {}

    public Student(String name, String password, String email, String phone, String takenCourses, String parentName, String guideTeacher) {
        super(name, password, email, phone);
        this.takenCourses = takenCourses;
        this.parentName = parentName;
        this.guideTeacher = guideTeacher;
    }

    public String getTakenCourses() {
        return takenCourses;
    }

    public void setTakenCourses(String takenCourses) {
        this.takenCourses = takenCourses;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getGuideTeacher() {
        return guideTeacher;
    }

    public void setGuideTeacher(String guideTeacher) {
        this.guideTeacher = guideTeacher;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", email='" + this.getEmail() + '\'' +
                ", phone='" + this.getPhone() + '\'' +
                ", takenCourses='" + takenCourses + '\'' +
                ", parentName='" + parentName + '\'' +
                ", guideTeacher='" + guideTeacher + '\'' +
                '}';
    }

    @Override
    public int addRow() throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO sys.student VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1,this.getId());
        stm.setObject(2,this.getName());
        stm.setObject(3,this.getPassword());
        stm.setObject(4,this.getEmail());
        stm.setObject(5,this.getPhone());
        stm.setObject(6,this.parentName);
        stm.setObject(7,this.guideTeacher);
        stm.setObject(8,this.takenCourses);

        return stm.executeUpdate();
    }

    @Override
    public int deleteRow() throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM sys.student WHERE id = "+ this.getId();
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        return stm.executeUpdate();
    }

    @Override
    public int updateRow() throws ClassNotFoundException, SQLException {
        String sql = "UPDATE sys.student SET name = ? ,password= ?, email = ?, phone = ?, " +
                "parentName = ?, guideTeacher = ?, takenCourses = ?" +
                "WHERE id = " + this.getId();
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1,this.getName());
        stm.setObject(2,this.getPassword());
        stm.setObject(3,this.getEmail());
        stm.setObject(4,this.getPhone());
        stm.setObject(5,this.parentName);
        stm.setObject(6,this.guideTeacher);
        stm.setObject(7,this.takenCourses);

        return stm.executeUpdate();
    }

    @Override
    public ArrayList<Student> retrieveAll() throws ClassNotFoundException, SQLException {
        String query = "SELECT * FROM sys.student";
        ArrayList<Student> list = new ArrayList<Student>();
        Student student;
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs;
        
        rs = statement.executeQuery(query);
        
        while (rs.next()) {
            student = new Student(rs.getString("name"), rs.getString("password"),
                    rs.getString("email"), rs.getString("phone"),
                    rs.getString("takenCourses"),
                    rs.getString("parentName"), rs.getString("guideTeacher"));

            student.setId(rs.getInt("id"));
            list.add(student);
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
        list.add(this.parentName);
        list.add(this.guideTeacher);
        list.add(this.takenCourses);
        
        return list;
    }
}
