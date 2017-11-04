package scheduler.utilities;

import scheduler.taskhandler.Assignee;
import scheduler.taskhandler.STaskAssigned;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class HTMLBuilder {


    public static String getTimeTable(){

        StringBuilder sb = new StringBuilder();
        sb.append("<table>\n");
        sb.append("<tr><th>Time</th></tr>\n");
        sb.append("<tr><td>12:00 AM</td></tr>\n");

        for(int i = 1; i < 24; i++){
                sb.append("<tr><td>");
                if(i < 12) {
                    sb.append(i).append(":00 AM");
                    sb.append("</td></tr><tr><td>");
                    sb.append(i).append(":30 AM");
                }
                else if (i == 12) {
                    sb.append("12:00 PM");
                    sb.append("</td></tr><tr><td>");
                    sb.append("12:30 PM");
                }
                else{
                    sb.append(i % 12).append(":00 PM");
                    sb.append("</td></tr><tr><td>");
                    sb.append(i % 12).append(":30 PM");
                }
                sb.append("</td></tr>");
        }
        sb.append("</table>");
        return sb.toString();
    }


    public static String buildTaskTable(List<Assignee> assigneeList){

        String[] timeArray = getTimeArray();
        final StringBuilder sb = new StringBuilder();

        sb.append("<table><tr>");
        sb.append("<th> Time </th>");

        for(Assignee as : assigneeList)
            sb.append("<th> ").append(as.getName()).append(" </th>");

        sb.append("</tr>");

        for(int i = 0; i < 48; i++) {
            sb.append("<tr>");
            sb.append("<td>").append(timeArray[i]).append("</td>");
            for(Assignee as : assigneeList){
                Vector<STaskAssigned>[] assignedTasks = as.getAssignedTasks();
                sb.append("<td>");
                if(assignedTasks[i].size() == 0)
                    sb.append("");
                else{
                    for(STaskAssigned at : assignedTasks[i]){
                        sb.append("Start time: <span class=\"timeFont\">");
                        sb.append(at.getStartHour()).append(":");
                        sb.append(at.getStartMinute() < 10 ? "0" + at.getStartMinute() : at.getStartMinute());
                        sb.append(at.isPM() ? " PM" : " AM");
                        sb.append("</span></br>");
                        sb.append("Duration: <span class=\"durationFont\">").append(at.getDurationMinutes()).append(" minutes</span></br>");
                        sb.append("Task name: <span class=\"taskNameFont\">").append(at.getName()).append("</span></br>");
                        sb.append("Description: <span class=\"descriptionFont\">").append(at.getDescription()).append("</span></br>");
                    }
                }
                sb.append("</td>");
            }
            sb.append("</tr>");
        }
        sb.append("</table>");
        return sb.toString();
    }

    private static String[] getTimeArray() {

        String[] timeArray = new String[48];
        for(int i = 0; i <= 24; i++){
            if(i == 0 || i == 24)
                timeArray[i] = i == 0 ? "12:00 AM" : "12:00 PM";
            else if(i == 1) {
                timeArray[i] = "12:30 AM";
                timeArray[i+24] = "12:30 PM";
            }
            else if(i % 2 == 0){
                timeArray[i] =  i/2 + ":00 AM";
                timeArray[i+24] = i/2 + ":00 PM";
            }
            else{
                timeArray[i] =  i/2 + ":30 AM";
                timeArray[i+24] = i/2 + ":30 PM";
            }
        }
        return timeArray;
    }
}
