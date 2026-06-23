package exercise4;

public class Main {
    public static void main(String[] args){
        Employee e1 = new Employee(1, "sahala", "manager", 70000.0);
        Employee e2 = new Employee(2, "sajna", " pro manager", 80000.0);
        Employee e3 = new Employee(3, "musthafa", "manager", 70000.0);
        Employee e4 = new Employee(4, "suhara", "chef", 90000.0);
        Employee e5 = new Employee(5, "salam", "chef", 100000.0);

        EmployeeManag em = new EmployeeManag();
        /*em.employees[0]= e1;
        em.employees[1]= e2;
        em.employees[2]= e3;
        em.employees[3]= e4;
        em.employees[4]= e5;*/
        em.addEmployee(e1);
        em.addEmployee(e2);
        em.addEmployee(e3);
        em.addEmployee(e4);
        em.addEmployee(e5);
        em.traverse();
        int l = em.seaarchById(2);
        System.out.println(l);
em.deleteById(2);
em.traverse();
    }
}
