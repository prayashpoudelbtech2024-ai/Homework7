import java.util.ArrayList;

class Employee {

    String employeeId;
    String name;
    String role;
    double baseSalary;
    double finalSalary;

    Employee(String employeeId, String name, String role, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.role = role;
        this.baseSalary = baseSalary;
        this.finalSalary = 0;
    }

    void calculateSalary() {

        switch(role) {

            case "Manager":
                finalSalary = baseSalary + (baseSalary * 0.20);
                break;

            case "Developer":
                finalSalary = baseSalary + (baseSalary * 0.10);
                break;

            case "Designer":
                finalSalary = baseSalary + (baseSalary * 0.05);
                break;

            case "Intern":
                finalSalary = 1000;
                break;

            default:
                finalSalary = baseSalary;
                break;
        }
    }

    void applyDeduction(double amount) {

        finalSalary = finalSalary - amount;

        System.out.println("Deduction of " + amount + " applied to " + name);
    }

    void displayEmployeeDetails() {

        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Role: " + role);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Final Salary: " + finalSalary);
        System.out.println("-------------------------");
    }
}

class Payroll {

    ArrayList<Employee> employees = new ArrayList<Employee>();

    void addEmployee(Employee employee) {

        employees.add(employee);

        System.out.println(employee.name + " added to payroll.");
    }

    void calculateAllSalaries() {

        System.out.println("\nCalculating Salaries:");

        for(Employee emp : employees) {
            emp.calculateSalary();
            emp.displayEmployeeDetails();
        }
    }

    Employee findEmployeeById(String employeeId) {

        for(Employee emp : employees) {

            if(emp.employeeId.equals(employeeId)) {
                return emp;
            }
        }

        return null;
    }
}

public class Main5 {

    public static void main(String[] args) {

        Payroll payroll = new Payroll();

        Employee e1 = new Employee("E101", "Prayash", "Manager", 5000);
        Employee e2 = new Employee("E102", "Ram", "Developer", 4000);
        Employee e3 = new Employee("E103", "Prahash", "Intern", 2000);

        payroll.addEmployee(e1);
        payroll.addEmployee(e2);
        payroll.addEmployee(e3);

        payroll.calculateAllSalaries();

        Employee found = payroll.findEmployeeById("E102");

        if(found != null) {
            found.applyDeduction(500);
            found.displayEmployeeDetails();
        }
    }
}
