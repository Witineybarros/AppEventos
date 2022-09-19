package app;

import java.util.ArrayList;

public class User {

    private String email, psw;
    private ArrayList<Event> tasks;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public ArrayList<Event> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Event> tasks) {
        this.tasks = tasks;
    }

    
}
