package duke;

import duke.task.Task;

import java.util.List;
import java.util.ArrayList;

public class TaskList {
    private final List<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public TaskList(List<Task> tasks) {
        this.tasks = new ArrayList<>(tasks);
    }
    
    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public Task deleteTask(int taskNum) {
        Task deletedTask = this.tasks.get(taskNum - 1);
        this.tasks.remove(taskNum - 1);
        return deletedTask;
    }

    public void markAsDone(int taskNum) {
        this.tasks.get(taskNum - 1).markAsDone();
    }

    public Task getTask(int taskNum) {
        return this.tasks.get(taskNum - 1);
    }

    public List<Task> getTasks() {
        return this.tasks;
    }

    public int getNumOfTasks() {
        return this.tasks.size();
    }

    /**
     * Gets a task list of tasks containing the keyword.
     * @param keyword is the keyword used to find the tasks.
     * @return a task list of tasks containing the keyword.
     */
    public TaskList getMatchingTasks(String keyword) {
        TaskList taskList = new TaskList();
        for (int i = 0; i < this.tasks.size(); i++) {
            if (this.tasks.get(i).toString().contains(keyword)) {
                taskList.addTask(this.tasks.get(i));
            }
        }
        return taskList;
    }

    @Override
    public String toString() {
        StringBuilder orderedList = new StringBuilder();
        for (int i = 1; i <= this.tasks.size(); i++) {
            orderedList.append("\n\t" + i + "." + this.tasks.get(i - 1));
        }
        return orderedList.toString();
    }
}
