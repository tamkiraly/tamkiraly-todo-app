public class Todo {

    public static void main(String[] args) {
        TaskList taskList = new TaskList("tasks");

        if (args.length < 1) {
            printUsage();
        } else if (args[0].equals("-l")) {
            taskList.printAllTasks();
        } else if (args[0].equals("-a")) {
            try {
                taskList.addNewTask(args[1]);
            } catch (IndexOutOfBoundsException exception) {
                System.out.println("Unable to add: no task provided");
            }
        } else if (args[0].equals("-r")) {
            try {
                taskList.removeTask(args[1]);
            } catch (NumberFormatException exception) {
                System.out.println("Unable to remove: index is not a number");
            } catch (ArrayIndexOutOfBoundsException exception) {
                System.out.println("Unable to remove: no index provided");
            }
        } else if (args[0].equals("-c")) {
            taskList.checkThisTask(args[1]);
            System.out.println("Task number " + args[1] + " is checked.");
        } else {
            printUsage();
        }
    }

    public static void printUsage() {
        System.out.println(
                "Command Line Todo application\n" +
                        "=============================\n" +
                        "\n" +
                        "Command line arguments:\n" +
                        "\t-l  Lists all the tasks\n" +
                        "\t-a  Adds a new task\n" +
                        "\t-r  Removes an task\n" +
                        "\t-c  Completes an task");
    }

    //region használatlan kódok
    /*
    public static List<String> readTasksFromFile() {
        Path filePath = Paths.get("tasks");
        List<String> linesFromFile = new ArrayList<>();
        try {
            linesFromFile = Files.readAllLines(filePath);
        } catch (IOException exception) {
            System.out.println("File not found");
        }
        return linesFromFile;
    }

    public static void printAllTasks() {
        Path filePath = Paths.get("tasks");
        List<String> lines = new ArrayList<>();
        lines = readTasksFromFile();
        if (lines.size() == 0) {
            System.out.println("No todos for today :-)");
        } else {

            for (int i = 0; i < lines.size(); i++) {
                System.out.println((i + 1) + " - " + lines.get(i));
            }
        }
    }

    public static void addTaskToFile(String userInput) {
        Path filePath = Paths.get("tasks");
        String newLine = "\n" + userInput;
        try {
            Files.writeString(filePath, newLine, StandardOpenOption.APPEND);
        } catch (IOException exception) {
            System.out.println("File not found");
        }
    }

    public static void removeTask(String indexOfLine) {
        int indexToNumber = Integer.parseInt(indexOfLine);

        List<String> lines = new ArrayList<>();
        lines = readTasksFromFile();

        try {
            lines.remove(lines.get(indexToNumber - 1));
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Unable to remove: index is out of bound");
        }

        Path filePath = Paths.get("tasks");
        try {
            for (int i = 0; i < lines.size(); i++) {
                if (i == 0) {
                    Files.writeString(filePath, lines.get(i));
                } else {
                    Files.writeString(filePath, "\n" + lines.get(i), StandardOpenOption.APPEND);
                }
            }
        } catch (IOException exception) {
            System.out.println("File not found");
        }
    }

    public static List<Task> taskStringToObjectList(List<String> fileLines) {
        fileLines = readTasksFromFile();
        List<Task> taskList = new ArrayList<>();
        for (String line : fileLines) {
            taskList.add(new Task(line));
        }
        return taskList;
    }

    public static void checkTask(String index) {
        List<String> fileLines = readTasksFromFile();
        List<Task> taskList = taskStringToObjectList(fileLines);
        int parseIndexToInt = Integer.parseInt(index);
        if (taskList.size() >= 2) {
            taskList.get(parseIndexToInt).checkTask();
        }

    }
*/
    //endregion
}
