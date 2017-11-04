package scheduler.utilities;

public class ScheduleTable {

    private String[] times = new String[24];

    public ScheduleTable(){

        times[0] = "12:00 AM";
        for(int i = 1; i < 24; i++)
            times[i] = i + i <= 12 ? " AM" : " PM";
    }

}
