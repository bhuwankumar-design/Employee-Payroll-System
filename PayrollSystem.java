abstract class Employee {
    String name;
    int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }
    abstract double calculateSalary();

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

class FullTimeEmployee extends Employee {
    double baseSalary;
    double bonus;

    FullTimeEmployee(String name, int id, double baseSalary, double bonus) {
        super(name, id);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }
    double calculateSalary() {
        return baseSalary + bonus;
    }

    void conductMeeting() {
        System.out.println("Meeting Conducted");
    }
}

class PartTimeEmployee extends Employee {
    int hoursWorked;
    double hourlyRate;

    PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    void showHours() {
        System.out.println("Hours Worked: " + hoursWorked);
    }
}

public class PayrollSystem {
    public static void main(String[] args) {

        Employee e1 = new FullTimeEmployee("Rahul", 101, 40000, 10000);
        Employee e2 = new PartTimeEmployee("Aman", 102, 80, 150);

        Employee[] employees = {e1, e2};

        for (Employee emp : employees) {

            emp.displayDetails();

            double salary = emp.calculateSalary();
            System.out.println("Salary: " + salary);

            if (salary > 30000) {
                System.out.println("High Salary Employee");
            } else {
                System.out.println("Regular Employee");
            }

            if (emp instanceof FullTimeEmployee) {
                FullTimeEmployee ft =
                        (FullTimeEmployee) emp;
                ft.conductMeeting();
            } else if (emp instanceof PartTimeEmployee) {
                PartTimeEmployee pt =
                        (PartTimeEmployee) emp;
                pt.showHours();
            }

            System.out.println(" ");
        }
    }
}
