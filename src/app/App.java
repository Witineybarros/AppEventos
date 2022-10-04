package app;

import DAO.EventDAO;
import DAO.UserDAO;
import MODEL.Event;
import MODEL.User;
import Services.Finishi_event;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static Scanner sc = new Scanner(System.in);
    public static User loggedUser = null;

    //public static boolean onOff = false;
    public static String yn;

    public static void main(String[] args) {

        ArrayList<User> list_user = new ArrayList();

        boolean controller = true;

        // MENU USER //
        System.out.println("----- Welcome to Events -----");
        while (controller) {
            System.out.println("============ MENU ============");
            System.out.println(".----------------------------.");
            System.out.println("|   {1]- NEW USER            |");
            System.out.println("|   [2]- LOGIN               |");
            System.out.println("|   [0]- LOGOUT              |");
            System.out.println("*----------------------------*");
            System.out.print("TYPE AN OPTION:");
            String opn = sc.nextLine();
            // PROCESSING //
            switch (opn) {
                // SIGN UP //
                case "1": {

                    System.out.println("=========== SIGN UP ===========");//30
                    System.out.print("type ur name:");
                    String name = sc.nextLine();
                    System.out.print("ur SSN:");
                    long ssn = sc.nextLong();
                    sc.nextLine();
                    System.out.print("type email:");
                    String email = sc.nextLine();
                    System.out.print("type password:");
                    String pswd = sc.nextLine();

                    User user = new User();

                    user.setName(name);
                    user.setSsn(ssn);
                    user.setEmail(email);
                    user.setPswd(pswd);

                    ArrayList<Event> event = new ArrayList();
                    user.setEvents(event);

                    boolean newUser = UserDAO.newUser(user);
                    if (newUser) {
                        System.out.println("==============================");//30 
                        System.out.println("-> Registered successfully <-");//29
                    } else {
                        System.out.println("==============================");
                        System.out.println("-> Erro when registering <-,");
                    }
                    //homePage();1
                    break;
                }

                case "2": {
                    System.out.println("============ LOGIN ===========");
                    System.out.print("ur SSN:");
                    long ssn = sc.nextLong();
                    sc.nextLine();
                    System.out.print("ur password:");
                    String pswd = sc.nextLine();
                    System.out.println("==============================");

                    // EMAIL and PSWD VERIFICATION  //
                    User u = UserDAO.searchSSN(ssn);
                    boolean truLogin = false;

                    if (u != null && u.getPswd().equals(pswd)) {
                        truLogin = true;
                    }

                    if (truLogin) {
                        System.out.println("  -> Successfully loaded <-   ");
                        loggedUser = u;
                        homePageUser();
                    } else {
                        System.out.println("SSN and Password dont match!");
                    }
                    break;
                }
                case "0": {
                    controller = false;
                    System.out.println("Right,see U!");

                    break;
                }
                default: {
                    System.out.println("You need to enter a valid number!");
                }
            }
        }

        System.out.println("Finished!!!");

    }

    public static void homePageUser() {
        boolean controller = true;
        while (controller) {
            System.out.println("======== UR HOMEPAGE =========");
            System.out.println(".----------------------------.");
            System.out.println("|   [1]- ADD NEW EVENT       |");
            System.out.println("|   [2]- DELETE AN EVENT     |");
            System.out.println("|   [3]- CONFIRMED EVENTS    |");
            System.out.println("|   [4]- UNCONFIRMED EVENTS  |");
            System.out.println("|   [5]- LIST ALL EVENTS     |");
            System.out.println("|   [0]- LOGOUT              |");
            System.out.println("*----------------------------*");
            System.out.print("TYPE AN OPTION:");
            String opn = sc.nextLine();

            switch (opn) {
                case "1": {
                    System.out.println("------- ADD NEW EVENT --------");
                    System.out.print("Name ur event:");
                    String name = sc.nextLine();
                    System.out.println("Now the andress:");
                    System.out.print("Number:");
                    String number = sc.nextLine();
                    System.out.print("Ave or St:");
                    String ave_st = sc.nextLine();
                    System.out.print("apartment number:");
                    String ap_numb = sc.nextLine();
                    System.out.print("city:");
                    String city = sc.nextLine();
                    System.out.print("State:");
                    String state = sc.nextLine();
                    System.out.print("Zip Code:");
                    String zip_code = sc.nextLine();
                    System.out.print("Country:");
                    String country = sc.nextLine();
                    System.out.println("Category:");
                    String category = sc.nextLine();
                    System.out.println("an DESCRIPTION 'BOUT event:");
                    String description = sc.nextLine();
                    System.out.println("-------------------------------");
                    do {
                        System.out.println("Would u like to confirm ur "
                                + "presence at this EVENT,");
                        System.out.println("YES OR NO?");
                        yn = sc.nextLine();
                        if (!"no".equals(yn) && !"yes".equals(yn)) {
                            System.out.println("U NEED TYPE YES OR NO");
                            System.out.println("");
                        }
                    } while (!"no".equals(yn) && !"yes".equals(yn));

                    Event ev = new Event();
                    switch (yn) {
                        case "yes":
                            ev.setConfirmed(true);

                            String status = "CONFIRMED";
                            System.out.println("Status:" + status + ev.isConfirmed());

                            ev.setName(name);
                            ev.setNumber(number);
                            ev.setAve_st(ave_st);
                            ev.setAp_numb(ap_numb);
                            ev.setCity(city);
                            ev.setState(state);
                            ev.setZip_code(zip_code);
                            ev.setCountry(country);
                            ev.setCategory(category);
                            ev.setDescription(description);
                            ev.setStatus(status);
                            ev.setId_user(loggedUser.getId());

                            boolean insert = EventDAO.insertEvent(ev);
                            if (insert) {
                                System.out.println("EVENT added successfully!");
                            } else {
                                System.out.println("Try again...");
                            }

                            break;
                        case "no":
                            ev.setConfirmed(false);

                            status = "UNCONFIRMED";
                            System.out.println("status:" + status + ev.isConfirmed());

                            ev.setName(name);
                            ev.setNumber(number);
                            ev.setAve_st(ave_st);
                            ev.setAp_numb(ap_numb);
                            ev.setCity(city);
                            ev.setState(state);
                            ev.setZip_code(zip_code);
                            ev.setCountry(country);
                            ev.setCategory(category);
                            ev.setDescription(description);
                            ev.setStatus(status);
                            ev.setId_user(loggedUser.getId());

                            boolean insertt = EventDAO.insertEvent(ev);
                            if (insertt) {
                                System.out.println("EVENT added successfully!");
                            } else {
                                System.out.println("Try again...");
                            }

                            break;

                    }
                    break;
                }
                case "2": {
                    System.out.println("------- DELETE AN EVENT -------");
                    ArrayList<Event> list_5 = EventDAO.search_eventUser(loggedUser);

                    if (list_5.isEmpty()) {
                        System.out.println("U don't have Events!!!");
                    }

                    for (int i = 0; i < list_5.size(); i++) {
                        Event ev = list_5.get(i);
                        System.out.println("[" + ev.getId() + "] Name:" + ev.getName());
                    }
                    System.out.println("Type ur option:");
                    int position = sc.nextInt();
                    sc.nextLine();
                    list_5.remove(position);
                    System.out.println("Event DELETED successfully!");

                    break;
                }
                case "3": {
                    System.out.println("----- Confirmed Events ------");
                    ArrayList<Event> list3 = EventDAO.search_eventUser(loggedUser);
                    ArrayList<Event> confirmed = new ArrayList();

                    for (Event ev : list3) {
                        if (ev.isConfirmed()) {
                            confirmed.add(ev);
                        }
                    }
                    if (confirmed.isEmpty()) {
                        System.out.println("U dont have confirmed Events!!!");
                    } else {

                        for (Event ev : confirmed) {

                            System.out.println("--------- Evento " + ev.getId() + " ------------");
                            System.out.println("Name:" + ev.getName());
                            System.out.println("Adress:" + ev.getNumber() + "," + ev.getAve_st() + "," + ev.getAp_numb() + "," + ev.getCity() + "," + ev.getState() + "," + ev.getZip_code() + "," + ev.getCountry());
                            System.out.println("Category:" + ev.getCategory());
                            System.out.println("Description:" + ev.getDescription());
                            System.out.println("Status:" + ev.getStatus());
                            System.out.println("------------------------------");

                        }
                        // enter new status //
                        System.out.println("Would u like UNCONFIRMED ur presence at an EVENT,");
                        System.out.println("YES OR NO?");
                        yn = sc.nextLine();
                        switch (yn) {
                            case "yes":
                                for (Event ev : confirmed) {

                                    System.out.println("[" + ev.getId() + "] Name:" + ev.getName());
                                }
                                System.out.println("Type ur option:");
                                int id = sc.nextInt();
                                sc.nextLine();
                                String status = "UNCONFIRMED";
                                
                                Event ev = new Event();
                                ev.setStatus(status);
                                
                                ev.setId(id);
                                ev.setId_user(loggedUser.getId());

                                Finishi_event.unConfirmed(ev);

                                System.out.println("-> Unconfirmed Event <-");
                                break;
                            case "no":
                                System.out.println("all right...");
                                break;
                            default:
                                System.out.println("u need type YES OR NO");
                                break;
                        }
                    }
                    break;
                }
                case "4": {

                    System.out.println("----- Unconfirmed Events ------");
                    ArrayList<Event> list4 = EventDAO.search_eventUser(loggedUser);
                    ArrayList<Event> unConfirmed = new ArrayList();

                    for (Event ev : list4) {
                        if (!ev.isConfirmed()) {
                            unConfirmed.add(ev);
                        }
                    }
                    if (unConfirmed.isEmpty()) {
                        System.out.println("U have no unconfimed Events!!!");
                    } else {
                        for (Event ev : unConfirmed) {

                            System.out.println("--------- Evento " + ev.getId() + " ------------");
                            System.out.println("Id:" + ev.getId());
                            System.out.println("Name:" + ev.getName());
                            System.out.println("Adress:" + ev.getNumber() + "," + ev.getAve_st() + "," + ev.getAp_numb() + "," + ev.getCity() + "," + ev.getState() + "," + ev.getZip_code());
                            System.out.println("Category:" + ev.getCategory());
                            System.out.println("Description:" + ev.getDescription());
                            System.out.println("Status:" + ev.getStatus());
                            System.out.println("------------------------------");

                        }

                        // enter new status //
                        System.out.println("Would u like to confirm ur presence at an EVENT,");
                        System.out.println("YES OR NO?");
                        yn = sc.nextLine();
                        switch (yn) {
                            case "yes":

                                for (Event ev : unConfirmed) {

                                    System.out.println("[" + ev.getId() + "] Name:" + ev.getName());
                                }
                                System.out.println("Type ur option:");
                                int id = sc.nextInt();
                                sc.nextLine();
                                String status = "CONFIRMED";
                                
                                Event ev = new Event();
                                ev.setStatus(status);
                                
                                ev.setId(id);
                                ev.setId_user(loggedUser.getId());

                                boolean finished = Finishi_event.confirmed(ev);
                                if(finished){
                                System.out.println("Event CONFIRMED successfully");
                                }else{
                                    System.out.println("Try again...");
                                }
                                break;

                            case "no":
                                System.out.println("all right...");
                                break;
                            default:
                                System.out.println("u need type YES OR NO");
                                break;
                        }
                    }

                    break;

                }

                case "5": {
                    System.out.println("-------- ALL EVENTS ---------");
                    ArrayList<Event> list_2 = EventDAO.search_eventUser(loggedUser);

                    if (list_2.isEmpty()) {
                        System.out.println("U don't have Events!!!");
                    }

                    for (int i = 0; i < list_2.size(); i++) {
                        Event ev = list_2.get(i);

                        System.out.println("========= Event - " + ev.getId() + " =========");
                        System.out.println("Name:" + ev.getName());
                        System.out.println("Adress:" + ev.getNumber() + "," + ev.getAve_st() + "," + ev.getAp_numb() + "," + ev.getCity() + "," + ev.getState() + "," + ev.getZip_code());
                        System.out.println("Category:" + ev.getCategory());
                        System.out.println("Description:" + ev.getDescription());
                        System.out.println("Status:" + ev.getStatus());
                    }
                    break;
                }
                case "0": {

                    controller = false;
                    loggedUser = null;

                    break;
                }
                default: {
                    System.out.println("You need to enter a valid number!");
                }
            }

        }
    }

}
