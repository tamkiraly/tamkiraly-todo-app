import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class TaskList {
    protected List<Task> tasks;
    protected String filename;

    public TaskList(String filename) {
        setTaskList(readLinesFromFile(filename));
    }

    public List<String> readLinesFromFile(String filename) {
        Path filePath = Paths.get(filename);
        this.filename = filename;
        List<String> fileLines = new ArrayList<>();
        try {
            fileLines = Files.readAllLines(filePath);
        } catch (IOException exception) {
            System.out.println("File not found");
        }
        return fileLines;
    }

    public void writeTasksToFile() {
        Path filePath = Paths.get(filename);
        try {
            Files.writeString(filePath, tasks.get(0).taskDescription);
        } catch (IOException exception) {
            System.out.println("File not found");
        }
        try {
            for (int i = 1; i < tasks.size(); i++) {
                Files.writeString(filePath, "\n" + tasks.get(i).taskDescription, StandardOpenOption.APPEND);
            }
        } catch (IOException exception) {
            System.out.println("File not found");
        }
    }

    public void setTaskList(List<String> lines) {
        lines = readLinesFromFile(filename);
        List<Task> taskList = new ArrayList<>();
        for (String line : lines) {
            taskList.add(new Task(line));
        }
        tasks = taskList;
    }

    public void addNewTask(String userInput) {
        Task userTask = new Task(userInput);
        tasks.add(userTask);
        writeTasksToFile();
    }

    public void checkThisTask(String index) {
        int parseIndexToInt = Integer.parseInt(index) - 1;
        if (tasks.size() >= 2) {
            (tasks.get(parseIndexToInt)).checkTask();
        }
    }

    public void printAllTasks() {
        if (tasks.size() == 0) {
            System.out.println("No todos for today :-)");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                if (tasks.get(i).isTaskChecked) {
                    System.out.println((i + 1) + " - " + "[x] " + tasks.get(i).taskDescription);
                } else {
                    System.out.println((i + 1) + " - " + "[ ] " + tasks.get(i).taskDescription);
                }
            }
        }
    }

    public void removeTask(String indexOfLine) {
        int indexToInteger = Integer.parseInt(indexOfLine) - 1;
        try {
            tasks.remove(indexToInteger);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Unable to remove: index is out of bound");
        }
        writeTasksToFile();
    }
}
