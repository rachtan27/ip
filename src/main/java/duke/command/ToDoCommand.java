package duke.command;

import duke.Ui;
import duke.TaskList;
import duke.Storage;
import duke.task.Todo;

/**
 * ToDoCommand that has description.
 */
public class ToDoCommand extends AddCommand {
    public static final String COMMAND_WORD = "todo";
    private String desc;

    /**
     * Constructor for ToDoCommand.
     * @param desc
     */
    public ToDoCommand(String desc) {
        this.desc = desc;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Todo newTask = new Todo(desc);
        tasks.addTask(newTask);
        String response = "OK! I've added:\n" + newTask.toString() +
                String.format("\nNow you have %d task(s) in the list.", tasks.getSize());
        Ui.showResponse(response);
        this.responseFromDukeAfterExecution = response;
    }

}
