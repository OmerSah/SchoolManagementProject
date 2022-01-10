/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author omersahin
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IGenericDao<T> {
    int addRow() throws ClassNotFoundException, SQLException;
    int deleteRow() throws ClassNotFoundException, SQLException;
    int updateRow() throws ClassNotFoundException, SQLException;
    ArrayList<T> retrieveAll() throws ClassNotFoundException, SQLException;
}
