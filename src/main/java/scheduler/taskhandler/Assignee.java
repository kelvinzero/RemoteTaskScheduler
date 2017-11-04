package scheduler.taskhandler;

import scheduler.utilities.TaskTimeComparator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Assignee implements Serializable{

    private String name;
    private boolean sexMale;
    private Vector<STaskAssigned>[] assignedTasks;

    public Assignee(String name, boolean male){
        this.name = name;
        this.sexMale = male;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSexMale() {
        return sexMale;
    }

    public void setSexMale(boolean sexMale) {
        this.sexMale = sexMale;
    }

    public Vector<STaskAssigned>[] getAssignedTasks() {
        return assignedTasks;
    }

    public void setAssignedTasks(List<STaskAssigned> atasks){

        TaskTimeComparator cmptr = new TaskTimeComparator();
        assignedTasks = new Vector[48];
        for(int i = 0; i < assignedTasks.length; i++)
            assignedTasks[i] = new Vector<>();

        atasks.sort(cmptr);

        for(STaskAssigned t : atasks){
            int hour = t.getStartHour();
            int minute = t.getStartMinute();
            boolean pm = t.isPM();

            if(hour==12)
                hour = 0;
            if(pm)
                hour = 24 + 2*hour;
            if(minute >= 30)
                assignedTasks[2*hour+1].add(t);
            else
                assignedTasks[2*hour].add(t);
        }
    }
}
