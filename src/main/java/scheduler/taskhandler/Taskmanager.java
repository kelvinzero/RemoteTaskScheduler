package scheduler.taskhandler;

import javafx.concurrent.Task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Taskmanager {

    private static final String TASKLISTPATH = "C:\\Users\\Josh Cotes\\IdeaProjects\\TaskScheduler\\taskfile.tss";
    private static final String ASSIGNEDTASKPATH = "C:\\Users\\Josh Cotes\\IdeaProjects\\TaskScheduler\\assignedtasks.tss";
    private List<Assignee> assignees;
    private List<STask> tasks;
    private Vector[] taskColumns;

    public Taskmanager() throws IOException{
        tasks = Taskloader.loadTasks(TASKLISTPATH);
        assignees = Taskloader.loadAssignedTasks(ASSIGNEDTASKPATH, tasks);
    }

    public List<Assignee> getAssignees(){
        return assignees;
    }
}
