package app;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User {

    private String name, tel, email, psw;
    long ssn;
    private ArrayList<Event> events;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

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

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    public long getSsn() {
        return ssn;
    }

    public void setSsn(long ssn) {
        this.ssn = ssn;
    }

    /*public String saveUser() {
        try {

            FileWriter fw = new FileWriter(ssn + "user.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("Name:" + this.name);
            pw.println("SSN:" + this.ssn);
            pw.println("Email:" + this.email);
            pw.println("psw:" + this.psw);
            pw.println("name:" + this.name);                                
            pw.flush();
            pw.close();
            fw.close();
         
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }*/

}
