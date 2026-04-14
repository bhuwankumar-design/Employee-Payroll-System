// Parent Class
class Employee {
    String name;
    int id;
    double baseSalary;

    // Constructor
    Employee(String name, int id, double baseSalary) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
    }

    // Method (to be overridden)
    double calculateSalary() {
        return baseSalary;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

// Full-Time Employee
class FullTimeEmployee extends Employee {
    double bonus;

    FullTimeEmployee(String name, int id, double baseSalary, double bonus) {
        super(name, id, baseSalary);
        this.bonus = bonus;
    }

    @Override
    double calculateSalary() {
        return baseSalary + bonus;
    }
}

// Part-Time Employee
class PartTimeEmployee extends Employee {
    int hoursWorked;
    double hourlyRate;

    PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id, 0); // baseSalary not needed here
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

// Main Class
public class PayrollSystem {
    public static void main(String[] args) {

        // Creating objects using polymorphism
        Employee e1 = new FullTimeEmployee("Rahul", 101, 40000, 10000);
        Employee e2 = new PartTimeEmployee("Aman", 102, 80, 150);

        // Full-Time Employee Output
        System.out.println("----- Full Time Employee -----");
        e1.displayDetails();
        System.out.println("Salary: " + e1.calculateSalary());

        // Part-Time Employee Output
        System.out.println("\n----- Part Time Employee -----");
        e2.displayDetails();
        System.out.println("Salary: " + e2.calculateSalary());
    }
}