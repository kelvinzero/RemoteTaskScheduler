package scheduler.taskhandler;

import java.io.Serializable;

public class STask implements Serializable{

    private int ID;
    private String name;
    private String description;

    public STask(){}

    public STask(String name){
        this.name = name;
    }

    public STask(String name, String description, int ID) {
        this.ID = ID;
        this.name = name;
        this.description = description;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
