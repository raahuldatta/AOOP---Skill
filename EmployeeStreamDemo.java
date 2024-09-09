import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeStreamDemo {
    // Employee class with name, age, and salary
    static class Employee {
        private String name;
        private int age;
        private double salary;

        public Employee(String name, int age, double salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + '}';
        }
    }

    public static void main(String[] args) {
        // Create a list of employees
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 30, 60000),
            new Employee("Bob", 25, 50000),
            new Employee("Charlie", 35, 70000),
            new Employee("David", 28, 55000),
            new Employee("Eve", 40, 80000),
            new Employee("Frank", 32, 62000),
            new Employee("Grace", 29, 52000),
            new Employee("Hannah", 45, 75000),
            new Employee("Ivy", 31, 61000),
            new Employee("Jack", 27, 53000)
        );

        // Filter employees with salary greater than 55000
        List<Employee> highEarners = employees.stream()
                .filter(e -> e.getSalary() > 55000)
                .collect(Collectors.toList());
        System.out.println("Employees with salary greater than 55000:");
        highEarners.forEach(System.out::println);

        // Sort employees by salary in descending order
        List<Employee> sortedBySalary = employees.stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .collect(Collectors.toList());
        System.out.println("\nEmployees sorted by salary (highest first):");
        sortedBySalary.forEach(System.out::println);

        // Find the highest salary
        Optional<Employee> highestSalaryEmployee = employees.stream()
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        if (highestSalaryEmployee.isPresent()) {
            System.out.println("\nHighest salary employee:");
            System.out.println(highestSalaryEmployee.get());
        }

        // Calculate the average salary
        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
        System.out.println("\nAverage salary of employees: " + averageSalary);
    }
}
