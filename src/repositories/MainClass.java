package repositories;

import entities.Employee;
import service.DatabaseService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args){
        DatabaseService databaseService = new DatabaseService();
        try(Scanner scanner = new Scanner(System.in);) {
            boolean isRunning = true;
            while (isRunning) {
                System.out.println("Enter your choice");
                System.out.println("1. Insert person");
                System.out.println("2. Select all employees");
                System.out.println("3. Select employee by an id");
                System.out.println("4. Delete employee");
                System.out.println("5. Update employee");
                System.out.println("6. Select all employees sorted by salary");
                System.out.println("7. Select all employees sorted by name");
                System.out.println("8. Select employee by a name");
                System.out.println("9. Exit ManagementTool");

                int choiceNum = Integer.parseInt(scanner.nextLine());

                switch (choiceNum) {
                    case 1:
                        System.out.println("Enter employee's name, address, salary");
                        databaseService.insertEmployee(new Employee(scanner.nextLine(), scanner.nextLine(),
                                Double.parseDouble(scanner.nextLine())));
                        break;
                    case 2:
                        databaseService.getAllEmployees();
                        break;
                    case 3:
                        System.out.println("Enter id of an employee");
                        databaseService.getEmployeeById(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 4:
                        System.out.println("Enter id of an employee");
                        databaseService.deleteEmployeeById(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 5:
                        System.out.println("Enter id of an employee");
                        int updateId = Integer.parseInt(scanner.nextLine());
                        boolean isFound = databaseService.getEmployeeById(updateId);
                        if (isFound){
                            System.out.println("Enter employee's name, address, salary");
                            databaseService.updateEmployee(new Employee(updateId, scanner.nextLine(),
                                    scanner.nextLine(),
                                    Double.parseDouble(scanner.nextLine())));
                        }
                        break;
                    case 6:
                        databaseService.getAllEmployeesSalarySort();
                        break;
                    case 7:
                        databaseService.getAllEmployeesNameSort();
                        break;
                    case 8:
                        System.out.println("Enter name of an employee");
                        String name = scanner.nextLine();
                        boolean isFoundName = databaseService.getEmployeeByName(name);
                        if (!isFoundName){
                            System.out.println("Record not found for name " + name);
                        }
                        break;
                    case 9:
                        System.out.println("Thank you for using our Management Tool!");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Please enter a number from list.");
                        break;
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Input must be integer");
        }
        catch (Exception e){
            throw new RuntimeException("Something went wrong." + e);
        }
    }
}
