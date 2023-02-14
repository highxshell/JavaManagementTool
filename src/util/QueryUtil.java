package util;

public class QueryUtil {
    public static String insertEmployeeQuery(){
        return "INSERT INTO employee_info(name,address,salary) VALUES (?,?,?)";
    }
    public static String selectAllEmployeeQuery(){
        return "SELECT id,name,address,salary FROM employee_info";
    }
    public static String selectEmployeeById(int id){
        return "SELECT id,name,address,salary FROM employee_info WHERE id = " + id;
    }
    public static String selectEmployeeByName(String name){
        return "SELECT id,name,address,salary FROM employee_info WHERE name LIKE " + "\'" + name + "%\'";
    }
    public static String deleteEmployeeById(int id){
        return "DELETE FROM employee_info WHERE id = " + id;
    }
    public static String updateEmployeeQuery(int id){
        return "UPDATE employee_info SET name = ?, address = ?, salary = ? WHERE id = "
                + id;
    }
}
