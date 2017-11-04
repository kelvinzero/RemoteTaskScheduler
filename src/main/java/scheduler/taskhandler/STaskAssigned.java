package scheduler.taskhandler;

import java.io.Serializable;

public class STaskAssigned extends STask implements Serializable{

    private int durationMinutes;
    private Assignee assignee;
    private boolean repeatDaily;
    private int startHour;
    private int startMinute;

    public boolean isPM() {
        return isPM;
    }

    public void setPM(boolean PM) {
        this.isPM = PM;
    }

    private boolean isPM;

    public STaskAssigned(){
    }

    public STaskAssigned(STask unassigned){
        super(unassigned.getName(), unassigned.getDescription(), unassigned.getID());
    }

    public STaskAssigned(STask unassigned, Assignee assignee){
        this(unassigned);
        this.assignee = assignee;
    }

    public STaskAssigned(Assignee assignee){
        this.assignee = assignee;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public Assignee getAssignee() {
        return assignee;
    }

    public void setAssignee(Assignee assignee) {
        this.assignee = assignee;
    }

    public boolean isRepeatDaily() {
        return repeatDaily;
    }

    public void setRepeatDaily(boolean repeatDaily) {
        this.repeatDaily = repeatDaily;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getStartMinute() {
        return startMinute;
    }

    public void setStartMinute(int startMinute) {
        this.startMinute = startMinute;
    }
}
