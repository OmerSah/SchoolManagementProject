/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author omersahin
 */
import java.sql.SQLException;

public class Principal extends Person {

    public Principal(String name, String password, String email, String phone) {
        super(name, password, email, phone);
    }
    
    public Principal() {}
    
    
    public void addStudent(Student student) throws ClassNotFoundException,SQLException {
        student.addRow();
    }

    public void addTeacher(Teacher teacher) throws ClassNotFoundException,SQLException {
        teacher.addRow();
    }

    public void addCourse(Course course) throws ClassNotFoundException,SQLException {
        
    }
    
    public void updateStudent(Student student) throws ClassNotFoundException,SQLException {
        student.updateRow();
    }

    public void updateTeacher(Teacher teacher) throws ClassNotFoundException,SQLException {
        teacher.updateRow();
    }
    
    public void updateCourse(Course course) throws ClassNotFoundException,SQLException {
        
    }
    
    public void deleteStudent(Student student) throws ClassNotFoundException,SQLException {
        student.deleteRow();
    }

    public void deleteTeacher(Teacher teacher) throws ClassNotFoundException,SQLException {
        teacher.deleteRow();
    }

    public void deleteCourse(Course course) throws ClassNotFoundException,SQLException {
        
    }
 
    @Override
    public String toString() {
        return "Principal{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", email='" + this.getEmail() + '\'' +
                ", phone='" + this.getPhone() + '\'' +
                '}';
    }
}


