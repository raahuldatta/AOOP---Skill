import java.util.*;

// Employee class implementing Comparable and Cloneable
class Employee implements Comparable<Employee>, Cloneable, Iterable<Employee> {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Implementing Comparable for natural ordering (by name)
    @Override
    public int compareTo(Employee other) {
        return this.name.compareTo(other.name);
    }

    // Implementing Cloneable
    @Override
    public Employee clone() {
        try {
            return (Employee) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported", e);
        }
    }

    // Implementing Iterable
    @Override
    public Iterator<Employee> iterator() {
        return Arrays.asList(this).iterator();
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + '}';
    }
}

// Comparator for sorting by age
class AgeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return Integer.compare(e1.getAge(), e2.getAge());
    }
}

// Comparator for sorting by salary
class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return Double.compare(e1.getSalary(), e2.getSalary());
    }
}

// Main class to test the Employee class and comparators
public class EmployeeTest {
    public static void main(String[] args) {
        // Create a list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 30, 60000));
        employees.add(new Employee("Bob", 25, 50000));
        employees.add(new Employee("Charlie", 35, 70000));

        // Sort by natural ordering (name)
        Collections.sort(employees);
        System.out.println("Sorted by name: " + employees);

        // Sort by age using AgeComparator
        Collections.sort(employees, new AgeComparator());
        System.out.println("Sorted by age: " + employees);

        // Sort by salary using SalaryComparator
        Collections.sort(employees, new SalaryComparator());
        System.out.println("Sorted by salary: " + employees);

        // Clone an employee
        Employee clonedEmployee = employees.get(0).clone();
        System.out.println("Cloned employee: " + clonedEmployee);

        // Iterate over employees
        System.out.println("Iterating over employees:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}
