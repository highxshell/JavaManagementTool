package service.Interfaces;

import entities.Employee;

import java.sql.SQLException;

public interface IDBServices {
    void insertEmployee(Employee employee) throws SQLException;
    void getAllEmployees() throws SQLException;
    void getAllEmployeesSalarySort() throws SQLException;
    void getAllEmployeesNameSort() throws SQLException;
    boolean getEmployeeById(int id) throws SQLException;
    boolean getEmployeeByName(String name) throws SQLException;
    void deleteEmployeeById(int id) throws SQLException;
    void updateEmployee(Employee employee) throws SQLException;
}
