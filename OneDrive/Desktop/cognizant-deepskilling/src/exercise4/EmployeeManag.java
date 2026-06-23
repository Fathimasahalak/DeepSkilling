package exercise4;

public class EmployeeManag {
    Employee[] employees = new Employee[10];
    int size =0;

    public void addEmployee(Employee e){
        if(size == employees.length){
            System.out.println("employee array is full");
        }
        else{
            boolean found = false;
            for(int i=0;i<size;i++){
                if(employees[i].employeeId==e.employeeId){
                    System.out.println("dublicate Id");
                    found = true;
                    break;
                }
            }
            if(!found){
                employees[size] = e;
                size++;
            }
        }

    }

    public int seaarchById(int employeeId){
        int found = -1;
        for(int i =0;i<size;i++){
            if(employees[i].employeeId == employeeId){
                found = i;
                break;

            }
        }
        return found;
    }
    public void traverse(){
        for(int i=0;i<size;i++){
            System.out.println(employees[i]);
        }
    }
    public void deleteById(int employeeId) {
        int index = seaarchById(employeeId); // reuse your search
        if (index == -1) {
            System.out.println("Employee not found");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            employees[i] = employees[i + 1]; // shift left
        }
        employees[size - 1] = null;
        size--;
    }
}
