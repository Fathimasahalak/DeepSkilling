package DataStructures.exercise5;

public class Main {
    public static void main(String[] args) {
        TaskManag tm = new TaskManag();
        Task t1 = new Task(1, "Design UI", "pending");
        Task t2 = new Task(2, "Setup Database", "in-progress");
        Task t3 = new Task(3, "Write API", "pending");
        Task t4 = new Task(4, "Testing", "completed");
        tm.addTask(t1);
        tm.addTask(t2);
        tm.addTask(t3);
        tm.addTask(t4);
        tm.addTask(new Task(2, "Duplicate", "pending"));
        tm.traverse();
        Task result = tm.searchTask(3);
        tm.deleteId(2);
        tm.traverse();
    }
}

