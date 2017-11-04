package scheduler.utilities;

import scheduler.taskhandler.STaskAssigned;

import java.util.Comparator;

public class TaskTimeComparator implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        STaskAssigned t1 = (STaskAssigned) o1;
        STaskAssigned t2 = (STaskAssigned) o2;
        int timeone;
        int timetwo;

        if(t1.isPM())
            timeone = 12 + t1.getStartHour() + t1.getStartMinute();
        else
            timeone = t1.getStartHour() + t1.getStartMinute();
        if(t2.isPM())
            timetwo = 12 + t1.getStartHour() + t1.getStartMinute();
        else
            timetwo = t1.getStartHour() + t1.getStartMinute();

        return timetwo-timeone;
    }
}
