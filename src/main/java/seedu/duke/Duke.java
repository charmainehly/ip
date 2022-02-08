package seedu.duke;

import java.io.IOException;

/**
 * Includes the Main driver class.
 * Stores public static instances of storage, task and ui objects.
 * Contains methods to run and instantiate the object instances.
 * Handles the result from the parsed commands to print out different
 * results back to the user.
 */
public class Duke {
    private static Storage storage;
    private static TaskList tasks;
    private Ui ui;
    private String FILE_PATH = "taskHistory.txt";

    /**
     * Instantiates the ui, storage and tasklist objects.
     * Stores the tasks loaded into the tasklist object.
     *
     */
    public Duke() {
        ui = new Ui();
        storage = new Storage(FILE_PATH);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            //ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    /**
     * Shows the welcome line when Duke chat-bot starts running.
     * Interacts with user inputs by calling getNextInput() from ui class.
     * Calls Parser class methods to parse in the user inputs.
     * Switches between cases based on the command passed in.
     * Exits the running chat-bot when the 'bye' command is read from user input.
     */
    public String getResponse(String input) {
        ui.showWelcome();
        String message = "HI";
        String nextInput = input;

        /*while (!nextInput.equals("bye")) {
            String command = Parser.getCommand(nextInput);
            try {
                switch (command) {
                case "list":
                    System.out.println("Here are the tasks in your list:");
                    System.out.println(tasks.toString());
                    break;
                case "deadline":
                    if (Parser.getLength(nextInput) == 1) {
                        throw new DukeException("The description of a deadline cannot be empty.");
                    } else {
                        String[] task = Parser.getDeadlineDetails(nextInput);
                        Deadline d = new Deadline(task[0], task[1]);
                        tasks.add(d);
                        try {
                            storage.write(tasks.getTaskList());
                        } catch (IOException de) {
                            System.out.println("Something went wrong: " + de.getMessage());
                        }
                        System.out.println("Got it. I've added this task:");
                        System.out.println(d);
                        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                    }
                    break;
                case "todo":
                    if (Parser.getLength(nextInput) == 1) {
                        throw new DukeException("The description of a todo cannot be empty.");
                    } else {
                        String task = Parser.getTodoDetails(nextInput);
                        ToDo t = new ToDo(task);
                        tasks.add(t);
                        try {
                            storage.write(tasks.getTaskList());
                        } catch (IOException te) {
                            System.out.println("Something went wrong: " + te.getMessage());
                        }
                        System.out.println("Got it. I've added this task:");
                        System.out.println(t);
                        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                    }
                    break;
                case "event":
                    if (Parser.getLength(nextInput) == 1) {
                        throw new DukeException("The description of an event cannot be empty.");
                    } else {
                        String[] task = Parser.getEventDetails(nextInput);
                        Event e = new Event(task[0], task[1]);
                        tasks.add(e);
                        try {
                            storage.write(tasks.getTaskList());
                        } catch (IOException ee) {
                            System.out.println("Something went wrong: " + ee.getMessage());
                        }
                        System.out.println("Got it. I've added this task:");
                        System.out.println(e);
                        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                    }
                    break;
                case "mark":
                    if (Parser.getLength(nextInput) == 1) {
                        throw new DukeException("You did not provide a task to mark.");
                    } else {
                        int taskId = Parser.getTaskId(nextInput);
                        tasks.getTasks(taskId - 1).markDone();
                        try {
                            storage.write(tasks.getTaskList());
                        } catch (IOException e) {
                            System.out.println("Something went wrong: " + e.getMessage());
                        }
                        System.out.println("Nice! I've marked this task as done:");
                        System.out.println(tasks.getTasks(taskId - 1).toString());
                    }
                    break;
                case "unmark":
                    if (Parser.getLength(nextInput) == 1) {
                        throw new DukeException("You did not provide a task to unmark.");
                    } else {
                        int taskId = Parser.getTaskId(nextInput);
                        tasks.getTasks(taskId - 1).markUndone();
                        try {
                            storage.write(tasks.getTaskList());
                        } catch (IOException e) {
                            System.out.println("Something went wrong: " + e.getMessage());
                        }
                        System.out.println("OK, I've marked this task as not done yet:");
                        System.out.println(tasks.getTasks(taskId - 1).toString());
                    }
                    break;
                case "delete":
                    if (Parser.getLength(nextInput) == 1) {
                        throw new DukeException("You did not provide a task to delete.");
                    } else {
                        int taskId = Parser.getTaskId(nextInput);
                        System.out.println("Noted. I've removed this task:");
                        System.out.println(tasks.getTasks(taskId - 1).toString());
                        tasks.delete(taskId - 1);
                        try {
                            storage.write(tasks.getTaskList());
                        } catch (IOException e) {
                            System.out.println("Something went wrong: " + e.getMessage());
                        }
                        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                    }
                    break;
                case "find":
                    if (Parser.getLength(nextInput) == 1) {
                        throw new DukeException("You did not provide a keyword to search.");
                    } else {
                        String keyword = Parser.getKeyword(nextInput);
                        System.out.println("Here are the matching tasks in your list:");
                        System.out.println(tasks.findTasks(keyword).toString());
                    }
                    break;
                default:
                    throw new DukeException("I'm sorry, but I don't know what that means :-(");
                }
            } catch (DukeException error) {
                System.out.println("OOPS!!! " + error.getMessage());
            }
            nextInput = ui.getNextInput();
        }
        ui.showExit();*/

        return message;
    }
}
