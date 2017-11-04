
package scheduler.taskhandler;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Taskloader {

    public static List<STask> loadTasks(String path) throws IOException {

        ArrayList<STask> tasks = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
        int idCounter = 1;
        StringBuilder description;
        String line;
        STask newTask;

        while((line = reader.readLine()) != null){

            if(line.startsWith("##")){
                newTask = new STask(line.split("## *")[1]);
                line = reader.readLine();
                description = new StringBuilder();

                while(line != null && !line.equals("")){
                    if(!line.startsWith("//"))
                        description.append(line).append("\n");
                    line = reader.readLine();
                }

                newTask.setDescription(description.toString());
                newTask.setID(idCounter++);
                tasks.add(newTask);
            }
        }
        reader.close();
        return tasks;
    }

    public static boolean checkTaskFilesMatch(List<STask> stasks, String assignedTasksPath){
        return true;
    }

    // TODO: This
    public static List<Assignee> loadAssignedTasks(String path, List<STask> tasks) throws IOException{

        if(!checkTaskFilesMatch(tasks, path))
            throw new IOException("Tasks do not match in tasks file and assigned tasks file");

        ArrayList<Assignee> assignees = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
        String line;

        while((line = reader.readLine()) != null){

            if(line.startsWith("##")){
                Assignee newAssignee = new Assignee(line.split("## *| +")[1].trim(),
                        line.split("## *| +")[2].toLowerCase().trim().equals("male"));

                ArrayList<STaskAssigned> assignedTasks = new ArrayList<>();
                line = reader.readLine().trim();

                while(!line.equals("end") && line != null) {
                    while (line.equals("") || line.startsWith("//"))
                        line = reader.readLine().trim();

                    if(line.equals("end") || line == null)
                        break;
                    for (STask st : tasks) {
                        if (st.getName().trim().toLowerCase().equals(line.toLowerCase())) {

                            STaskAssigned newAssigned = new STaskAssigned(st, newAssignee);
                            line = reader.readLine().trim().toLowerCase();
                            String[] splitline = line.split(":| +");
                            newAssigned.setStartHour(new Integer(splitline[0]));
                            newAssigned.setStartMinute(new Integer(splitline[1]));
                            newAssigned.setPM(splitline[2].equals("pm"));
                            line = reader.readLine().trim().toLowerCase();
                            newAssigned.setDurationMinutes(new Integer(line.split(" +")[0]));
                            assignedTasks.add(newAssigned);
                            break;
                        }
                    }
                    line = reader.readLine().trim();
                }
                newAssignee.setAssignedTasks(assignedTasks);
                assignees.add(newAssignee);
            }
        }
        return assignees;

    }



}
