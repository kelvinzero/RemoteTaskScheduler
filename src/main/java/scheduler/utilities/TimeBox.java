package scheduler.utilities;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TimeBox {

    GregorianCalendar cal;

    public TimeBox(){
        cal = new GregorianCalendar();
    }

    public int getHour(){
        return cal.get(Calendar.HOUR);
    }

    public int getMinute(){
        return cal.get(Calendar.MINUTE);
    }

    public int getSecond(){
        return cal.get(Calendar.SECOND);
    }

    public int getDay(){
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public int getMonth(){
        return cal.get(Calendar.MONTH);
    }

    public int getYear(){
        return cal.get(Calendar.YEAR);
    }

}
