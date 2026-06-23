package exercise5;

public class Task {
    int taskId;
    String name;
    String status;
    Task next;

    public Task(int taskId,
    String name,
    String status){
        this.taskId = taskId;
        this.name =name;
        this.status=status;
        this.next = null;
    }
    @Override
    public String toString(){
        return "name: " + name + "TaskId: " + taskId + "status: " + status ;
    }

}
