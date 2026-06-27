package DataStructures.exercise4;

public class Employee {
    int employeeId;
    String name;
    String position;
    double salary;
    public Employee(int employeeId,
    String name,
    String position,
    double salary){
        this.employeeId=employeeId;
        this.name = name;
        this.position = position;
        this.salary=salary;
    }
    @Override
    public String toString(){
        return "name: " + name + "employeeId: " + employeeId + "position: " + position + "salary: " + salary;
    }

}
