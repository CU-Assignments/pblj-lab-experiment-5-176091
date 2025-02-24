// Menu-based Java application that allows you to add employee details, display all employees, and exit. The employee details will be stored in a file, and the program will
// read the file to display the stored employee information.

// Steps:
// 1. Create an Employee class with fields like name, id, designation, and salary.
// 2. Create a menu with three options:
// Add an Employee
// Display All Employees
// Exit
// 3. Store Employee Data in a File: Serialize the employee objects and store them in a file.
// 4. Read Employee Data from the File: Deserialize the employee objects from the file and display the details.
// 5. Handle Exceptions: Handle file I/O exceptions.



// ---Implementation
  
// Employee Class: This class contains details like name, id, designation, and salary. It implements Serializable to allow serialization of Employee objects.
// addEmployee(): This method takes input from the user for an employee's details, creates an Employee object, and saves it to a file using ObjectOutputStream.
// saveEmployeeToFile(): This method appends employee details to a file. The file is opened in append mode (true parameter in FileOutputStream).
// displayAllEmployees(): This method reads all employee objects from the file and prints their details.
// readEmployeesFromFile(): This method reads the employee objects from the file using ObjectInputStream and stores them in a list. 
// The loop continues until the end of the file is reached (IOFException).

import java.io.*;
import java.util.*;

class Employee {
    private String name;
    private int id;
    private String designation;
    private double salary;

    public Employee(String name, int id, String designation, double salary) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + id + ", Name: " + name + ", Designation: " + designation + ", Salary: " + salary;
    }

    public String toFileFormat() {
        return id + "," + name + "," + designation + "," + salary;
    }
}

public class EmployeeManagementSystem {
    private static final String FILE_NAME = "employees.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add an Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Please select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (option) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    displayAllEmployees();
                    break;
                case 3:
                    System.out.println("Exiting the program...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    
    public static void addEmployee(Scanner scanner) {
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline character
        System.out.print("Enter Designation: ");
        String designation = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();

        Employee employee = new Employee(name, id, designation, salary);

        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(employee.toFileFormat());
            writer.newLine();
            System.out.println("Employee added successfully!");
        } catch (IOException e) {
            System.out.println("Error while saving the employee details.");
        }
    }

    
    public static void displayAllEmployees() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\nEmployee Details:");
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                System.out.println("Employee ID: " + details[0] + ", Name: " + details[1] + ", Designation: " + details[2] + ", Salary: " + details[3]);
            }
        } catch (IOException e) {
            System.out.println("Error while reading the employee details.");
        }
    }
}



// Test Cases:

// Test Case 1: Add a new employee and display all employees.
// Steps: Select option 1 to add a new employee, then select option 2 to display all employees.
// Input:
// Employee Name: John Doe
// Employee ID: 101
// Designation: Software Engineer
// Salary: 50000
  
// Expected Output:
// Employee added successfully!
// Employee ID: 101, Name: John Doe, Designation: Software Engineer, Salary: 50000.0

// Test Case 2: Try adding multiple employees and display all of them.
// Steps: Add multiple employees (using option 1) and then display all employees (using option 2).
// Expected Output:
// Employee added successfully!
// Employee ID: 101, Name: John Doe, Designation: Software Engineer, Salary: 50000.0
// Employee added successfully!
// Employee ID: 102, Name: Jane Smith, Designation: Manager, Salary: 75000.0
