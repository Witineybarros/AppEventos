
package app;

public class Event {
    private String name,numb,st_ave,city,state,country,zip_code,category,description,numbHome;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumb() {
        return numb;
    }

    public void setNumb(String numb) {
        this.numb = numb;
    }

    public String getSt_ave() {
        return st_ave;
    }

    public void setSt_ave(String st_ave) {
        this.st_ave = st_ave;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
    private boolean finished;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumbHome() {
        return numbHome;
    }

    public void setNumbHome(String numbHome) {
        this.numbHome = numbHome;
    }
public boolean isFinished() {
        return finished;
    }
    }
