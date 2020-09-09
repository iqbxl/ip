package duke.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a deadline to be done by a specified date.
 */
public class Deadline extends Task {

    protected LocalDate by;

    /**
     * Creates a new Deadline with the given description and date.
     *
     * @param description is the description of the deadline.
     * @param by is the deadline date.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = LocalDate.parse(by);
    }

    /**
     * Gives a Deadline task from the full task description in the file.
     *
     * @param loadTask is the full task description in the file.
     * @return a Deadline task.
     */
    public static Deadline load(String loadTask) {
        String[] splitTask = loadTask.split(" \\| ", 4);
        Deadline deadline = new Deadline(splitTask[2], splitTask[3]);
        if (splitTask[1].equals("1")) {
            deadline.markAsDone();
        }
        return deadline;
    }

    /**
     * Gives a string indicating whether the deadline is done and the description of the deadline.
     *
     * @param isFinished is the value 1 if deadline is done or 0 if deadline is not done.
     * @return a string indicating 1 or 0 and the description of the deadline.
     */
    @Override
    public String save(int isFinished) {
        return "D | " + super.save(isFinished) + " | " + this.by;
    }

    /**
     * Returns a string representation of the deadline.
     *
     * @return a string representation of the deadline.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.format(DateTimeFormatter.ofPattern("d MMM yyyy")) + ")";
    }
}
