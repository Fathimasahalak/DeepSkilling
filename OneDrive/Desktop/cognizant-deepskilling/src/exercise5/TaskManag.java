package exercise5;

import java.util.LinkedList;

public class TaskManag {
    Task head = null;

    public void addTask(Task t) {
        Task current = head;
        while(current != null){
            if(t.taskId == current.taskId){
                System.out.println("duplictae");
                return;
            }
            current = current.next;
        }
    if(head == null){
        head = t;
    }
    else{

        current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = t;
    }
    }

    public Task searchTask(int taskId){
        Task current = head;
        while(current!=null){
            if(current.taskId == taskId){
                return current;
            }
            current =current.next;
        }
        return null;
    }
    public void traverse(){
        Task current = head;
        while(current!= null){
            System.out.println(current);
            current = current.next;
        }
    }
    public void deleteId(int taskId){
        Task current = head;
        Task prev = null;
        if (head == null) return;
        if(head.taskId == taskId){
            head = head.next;
            return;
        }
        while(current!= null){
            if(current.taskId == taskId){
                prev.next = current.next;
                return;
            }
            prev = current;
            current = current.next;
        }
        System.out.println("Task not found");
    }

}
