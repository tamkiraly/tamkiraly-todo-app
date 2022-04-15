public class Task {
    protected String taskDescription;
    public boolean isTaskChecked;

    public Task(String lineOfFile){
        taskDescription = lineOfFile;
    }

    public void checkTask(){
        isTaskChecked = true;
    }
}
