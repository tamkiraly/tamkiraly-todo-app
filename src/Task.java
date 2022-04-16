public class Task {
    protected String taskDescription;
    protected boolean isTaskChecked;

    public Task(String lineOfFile){
        taskDescription = lineOfFile;
    }

    public void checkTask(){
        this.isTaskChecked = true;
    }
}
