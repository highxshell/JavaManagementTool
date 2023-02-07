package service;

import entities.Employee;
import util.DatabaseUtil;
import util.QueryUtil;

import java.sql.*;
import java.util.List;

public class DatabaseService {
    DatabaseUtil databaseUtil = new DatabaseUtil();
    public void insertEmployee(Employee employee) throws SQLException {
        try (Connection connection = databaseUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.insertEmployeeQuery());){
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeeAddress());
            preparedStatement.setDouble(3, employee.getEmployeeSalary());

            int rows = preparedStatement.executeUpdate();

            if (rows > 0){
                System.out.println("Record created successfully.");
            }
            else{
                System.out.println("Insert record failed.");
            }

        }
    }
    public void getAllEmployees() throws SQLException{
        try (Connection connection = databaseUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(QueryUtil.selectAllEmployeeQuery());){
            while(resultSet.next()) {
                printEmployee(new Employee(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getDouble("salary")
                ));
            }
        }
    }
    private void printEmployee(Employee employee){
        System.out.println("Employee id: " + employee.getEmployeeID());
        System.out.println("Employee name: " + employee.getEmployeeName());
        System.out.println("Employee address: " + employee.getEmployeeAddress());
        System.out.println("Employee salary: " + employee.getEmployeeSalary());
        System.out.println("--------------------------");
    }
    public boolean getEmployeeById(int id) throws SQLException{
        boolean isFound = false;
        try(Connection connection = databaseUtil.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QueryUtil.selectEmployeeById(id));
            ) {
            if(resultSet.next()){
                isFound = true;
                printEmployee(new Employee(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getDouble("salary")
                ));
            }else{
                System.out.println("Record not found for id " + id);
            }
        }
        return isFound;
    }

    public void deleteEmployeeById(int id) throws SQLException{
        try(Connection connection = databaseUtil.getConnection();
            Statement statement = connection.createStatement();){
            int rows = statement.executeUpdate(QueryUtil.deleteEmployeeById(id));
            if(rows > 0){
                System.out.println("Record deleted successfully.");
            }else {
                System.out.println("Something went wrong.");
            }
        }
    }
    public void updateEmployee(Employee employee) throws SQLException{
        try(Connection connection = databaseUtil.getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement(QueryUtil.updateEmployeeQuery(employee.getEmployeeID()))) {
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeeAddress());
            preparedStatement.setDouble(3, employee.getEmployeeSalary());

            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("Record updated successfully.");
            }else {
                System.out.println("Failed to update record.");
            }
        }
    }

}
