package app.entities;

public class Task {
    private int taskId;
    private String name;
    private boolean done;
    private int userId;

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", name='" + name + '\'' +
                ", done=" + done +
                ", userId=" + userId +
                '}';
    }

    public Task(int taskId, String name, boolean done, int userId) {
        this.taskId = taskId;
        this.name = name;
        this.done = done;
        this.userId = userId;
    }
}
