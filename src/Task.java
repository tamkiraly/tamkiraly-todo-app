public class Task {
    protected String taskDescription;
    protected boolean isTaskChecked;

    public Task(String lineOfFile) {
        taskDescription = lineOfFile;
    }

    public boolean getTaskStatus() {
        return isTaskChecked;
    }

    public void checkTask() {
        isTaskChecked = true;
    }
}
