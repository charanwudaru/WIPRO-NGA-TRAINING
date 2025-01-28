import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbcsql {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "charan123";

        try {
            // Establish Connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected!");
            Statement stmt = conn.createStatement();

            // create database
            // String query = "CREATE database assignment";
            // stmt.executeUpdate(query);
            // System.out.println("Database created successfully...");

            // use database
            String useQuery = "USE assignment";
            stmt.executeUpdate(useQuery);
            System.out.println("Database selected successfully...");

            // //create table
            // String createTableQuery = "CREATE TABLE employee (id INT, name VARCHAR(20),
            // age INT, salary INT, department VARCHAR(20))";
            // stmt.executeUpdate(createTableQuery);
            // System.out.println("Table created successfully...");

            // //insert data
            // String insertQuery = "INSERT INTO employee VALUES " +
            // "(1, 'Charan', 21, 10000, 'IT'), " +
            // "(2, 'Raj', 22, 20000, 'HR'), " +
            // "(3, 'Ravi', 23, 30000, 'Finance'), " +
            // "(4, 'Rahul', 24, 40000, 'Admin'), " +
            // "(5, 'Rajesh', 25, 50000, 'IT'), " +
            // "(6, 'Rakesh', 26, 60000, 'HR'), " +
            // "(7, 'Rajat', 27, 70000, 'Finance'), " +
            // "(8, 'Rajeev', 28, 80000, 'Admin'), " +
            // "(9, 'Rajendra', 29, 90000, 'IT'), " +
            // "(10, 'Rajnish', 30, 100000, 'HR')";
            // stmt.executeUpdate(insertQuery);
            // System.out.println("Data inserted successfully...");

            // highest salary
            String highestSalaryQuery = "SELECT MAX(salary) FROM employee";
            ResultSet rs = stmt.executeQuery(highestSalaryQuery);
            if (rs.next()) {
                int highestSalary = rs.getInt(1);
                System.out.println("Highest salary: " + highestSalary);
            }

            // average salary
            String averageSalaryQuery = "SELECT AVG(salary) FROM employee";
            rs = stmt.executeQuery(averageSalaryQuery);
            if (rs.next()) {
                int averageSalary = rs.getInt(1);
                System.out.println("Average salary: " + averageSalary);
            }

            // Salary Greater Than 5000
            String salaryGreaterThan5000Query = "SELECT name FROM employee WHERE salary > 5000";
            rs = stmt.executeQuery(salaryGreaterThan5000Query);
            System.out.println("Employees with salary greater than 5000:");
            while (rs.next()) {
                String name = rs.getString("name");
                System.out.println(name);

            }

            // Get Employee Names and Salaries:
            String employeeNamesSalariesQuery = "SELECT name, salary FROM employee";
            rs = stmt.executeQuery(employeeNamesSalariesQuery);
            System.out.println("Employee names and salaries:");
            while (rs.next()) {
                String name = rs.getString("name");
                int salary = rs.getInt("salary");
                System.out.println(name + " - " + salary);
            }

            // count of employees
            String countQuery = "SELECT COUNT(*) FROM employee";
            rs = stmt.executeQuery(countQuery);
            if (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("Number of employees: " + count);
            }

            // Group Employees by Department:
            String groupByDepartmentQuery = "SELECT department, COUNT(*) FROM employee GROUP BY department";
            rs = stmt.executeQuery(groupByDepartmentQuery);
            System.out.println("Employees grouped by department:");
            while (rs.next()) {
                String department = rs.getString("department");
                int count = rs.getInt(2);
                System.out.println(department + " - " + count);
            }

            // Sort Employees by Salary
            String sortBySalaryQuery = "SELECT name, salary FROM employee ORDER BY salary";
            rs = stmt.executeQuery(sortBySalaryQuery);
            System.out.println("Employees sorted by salary:");
            while (rs.next()) {
                String name = rs.getString("name");
                int salary = rs.getInt("salary");
                System.out.println(name + " - " + salary);
            }

            // Find Employee with Second Highest Salary
            String secondHighestSalaryQuery = "SELECT name, salary FROM employee ORDER BY salary DESC LIMIT 1 OFFSET 1";
            rs = stmt.executeQuery(secondHighestSalaryQuery);
            if (rs.next()) {
                String name = rs.getString("name");
                int salary = rs.getInt("salary");
                System.out.println("Employee with second highest salary: " + name + " - " + salary);
            }

            // Partition Employees by Salary Threshold
            String partitionBySalaryQuery = "SELECT name, salary, " +
                    "CASE " +
                    "WHEN salary < 20000 THEN 'Low' " +
                    "WHEN salary < 50000 THEN 'Medium' " +
                    "ELSE 'High' " +
                    "END AS salary_partition " +
                    "FROM employee";
            rs = stmt.executeQuery(partitionBySalaryQuery);
            System.out.println("Employees partitioned by salary:");
            while (rs.next()) {
                String name = rs.getString("name");
                int salary = rs.getInt("salary");
                String salaryPartition = rs.getString("salary_partition");
                System.out.println(name + " - " + salary + " - " + salaryPartition);
            }

            // Find Employee with Longest Name
            String longestNameQuery = "SELECT name FROM employee ORDER BY LENGTH(name) DESC LIMIT 1";
            rs = stmt.executeQuery(longestNameQuery);
            if (rs.next()) {
                String name = rs.getString("name");
                System.out.println("Employee with longest name: " + name);
            }

            // Group Employees by Department and Calculate Average Salary:
            String groupByDepartmentAverageSalaryQuery = "SELECT department, AVG(salary) FROM employee GROUP BY department";
            rs = stmt.executeQuery(groupByDepartmentAverageSalaryQuery);
            System.out.println("Average salary of employees grouped by department:");
            while (rs.next()) {
                String department = rs.getString("department");
                int averageSalary = rs.getInt(2);
                System.out.println(department + " - " + averageSalary);
            }

            // Find Top 3 Highest Paid Employees:
            String top3HighestPaidEmployeesQuery = "SELECT name, salary FROM employee ORDER BY salary DESC LIMIT 3";
            rs = stmt.executeQuery(top3HighestPaidEmployeesQuery);
            System.out.println("Top 3 highest paid employees:");
            while (rs.next()) {
                String name = rs.getString("name");
                int salary = rs.getInt("salary");
                System.out.println(name + " - " + salary);
            }

            // Calculate Total Salary of All Employees Using Reduce
            String totalSalaryQuery = "SELECT salary FROM employee";
            rs = stmt.executeQuery(totalSalaryQuery);
            int totalSalary = 0;
            while (rs.next()) {
                int salary = rs.getInt("salary");
                totalSalary += salary;
            }
            System.out.println("Total salary of all employees: " + totalSalary);

            // Close connection
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}