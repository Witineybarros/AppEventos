package app;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static Scanner sc = new Scanner(System.in);
    public static User loggedUser = null;

    //public static boolean onOff = false;
    public static String status, yn;

    public static void main(String[] args) {

        ArrayList<User> list_user = new ArrayList();

        boolean controller = true;
        // MENU USER //
        System.out.println("----- Welcome to Events -----");
        while (controller) {
            System.out.println("============ MENU ============");
            System.out.println(".----------------------------.");
            System.out.println("|      [1]- NEW USER         |");
            System.out.println("|      [2]- LOGIN            |");
            System.out.println("|      [0]- LOGOUT           |");
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
                    String psw = sc.nextLine();

                    User user = new User();
                    user.setName(name);
                    user.setSsn(ssn);
                    user.setEmail(email);
                    user.setPsw(psw);

                    ArrayList<Event> event = new ArrayList();
                    user.setEvents(event);
                    user.saveUser();
                    list_user.add(user);

        
                    System.out.println("==============================");//30 
                    System.out.println("-> Registered successfully <-");//29

                    //homePage();
                    break;
                }

                case "2": {
                    System.out.println("============ LOGIN ===========");
                    System.out.print("ur SSN:");
                    long ssn = sc.nextLong();
                    sc.nextLine();
                    System.out.print("ur password:");
                    String psw = sc.nextLine();
                    System.out.println("==============================");

                    // EMAIL and PSWD VERIFICATION  //
                    boolean truLogin = false;
                    for (User user : list_user) {

                        long ussn = user.getSsn();
                        String uPsw = user.getPsw();

                        boolean truSsn = ssn == ussn;
                        boolean truPsw = psw.equals(uPsw);

                        if (truSsn && truPsw) {
                            truLogin = true;
                            loggedUser = user;
                            break;
                        }
                    }
                    if (!truLogin) {
                        System.out.println("SSN and Password dont match!");
                    } else {
                        System.out.println("  -> Successfully loaded <-   ");
                        System.out.println("");
                        homePage();
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

    public static void homePage() {
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
                    String numb = sc.nextLine();
                    System.out.print("Ave or St:");
                    String st_ave = sc.nextLine();
                    System.out.print("apartment number:");
                    String numbHome = sc.nextLine();
                    System.out.print("city:");
                    String city = sc.nextLine();
                    System.out.print("State:");
                    String state = sc.nextLine();
                    System.out.print("Zip Code:");
                    String zipCode = sc.nextLine();
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
                            ev.setFinished(true);
                            status = "CONFIRMED";
                            System.out.println("Status:" + status + ev.isFinished());
                            ev.setName(name);
                            ev.setNumb(numb);
                            ev.setSt_ave(st_ave);
                            ev.setNumbHome(numbHome);
                            ev.setCity(city);
                            ev.setState(state);
                            ev.setZip_code(zipCode);
                            ev.setCountry(country);
                            ev.setCategory(category);
                            ev.setDescription(description);
                            ev.setStatus(status);

                            loggedUser.getEvents().add(ev);
                            System.out.println("EVENT added successfully!");
                            break;
                        case "no":
                            ev.setFinished(false);
                            status = "UNCONFIRMED";
                            System.out.println("status:" + status + ev.isFinished());
                            ev.setName(name);
                            ev.setNumb(numb);
                            ev.setSt_ave(st_ave);
                            ev.setNumbHome(numbHome);
                            ev.setCity(city);
                            ev.setState(state);
                            ev.setZip_code(zipCode);
                            ev.setCountry(country);
                            ev.setCategory(category);
                            ev.setDescription(description);
                            ev.setStatus(status);

                            loggedUser.getEvents().add(ev);
                            System.out.println("EVENT added successfully!");

                            break;

                    }
                    break;
                }
                case "2": {
                    System.out.println("------- DELETE AN EVENT -------");
                    ArrayList<Event> list_5 = loggedUser.getEvents();

                    if (list_5.isEmpty()) {
                        System.out.println("U don't have Events!!!");
                    }

                    for (int i = 0; i < list_5.size(); i++) {
                        Event ev = list_5.get(i);
                        System.out.println("[" + i + "] Name:" + ev.getName());
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
                    ArrayList<Event> list3 = loggedUser.getEvents();
                    ArrayList<Event> confirmed = new ArrayList();

                    for (Event ev : list3) {
                        if (ev.isFinished()) {
                            confirmed.add(ev);
                        }
                    }
                    if (confirmed.isEmpty()) {
                        System.out.println("U dont have confirmed Events!!!");
                    } else {
                        for (int i = 0; i < confirmed.size(); i++) {
                            Event ev = confirmed.get(i);
                            System.out.println("--------- Evento " + i + " ------------");
                            System.out.println("Name:" + ev.getName());
                            System.out.println("Adress:" + ev.getNumb() + "," + ev.getSt_ave() + "," + ev.getNumbHome() + "," + ev.getCity() + "," + ev.getState() + "," + ev.getZip_code() + "," + ev.getCountry());
                            System.out.println("Category:" + ev.getCategory());
                            System.out.println("Description:" + ev.getDescription());
                            System.out.println("Status:" + ev.getStatus());
                            System.out.println("------------------------------");

                        }
                        // enter new status //
                        System.out.println("Would u like UNCONFIRMED ur presence at an EVENT,");
                        System.out.println("YES OR NO?");
                        String yn = sc.nextLine();
                        switch (yn) {
                            case "yes":
                                for (int inn = 0; inn < confirmed.size(); inn++) {
                                    Event even = confirmed.get(inn);
                                    System.out.println("[" + inn + "] Name:" + even.getName());
                                }
                                System.out.println("Type ur option:");
                                int position = sc.nextInt();
                                sc.nextLine();
                                Event confir = confirmed.get(position);
                                confir.setFinished(false);
                                status = "UNCONFIRMED";
                                confir.setStatus(status);
                                System.out.println("Event NOT CONFIRMED successfully");
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
                    ArrayList<Event> list4 = loggedUser.getEvents();
                    ArrayList<Event> unConfirmed = new ArrayList();

                    for (Event ev : list4) {
                        if (!ev.isFinished()) {
                            unConfirmed.add(ev);
                        }
                    }
                    if (unConfirmed.isEmpty()) {
                        System.out.println("U have no unconfimed Events!!!");
                    } else {
                        for (int i = 0; i < unConfirmed.size(); i++) {
                            Event ev = unConfirmed.get(i);
                            System.out.println("--------- Evento " + i + " ------------");
                            System.out.println("Name:" + ev.getName());
                            System.out.println("Adress:" + ev.getNumb() + "," + ev.getSt_ave() + "," + ev.getNumbHome() + "," + ev.getCity() + "," + ev.getState() + "," + ev.getZip_code());
                            System.out.println("Category:" + ev.getCategory());
                            System.out.println("Description:" + ev.getDescription());
                            System.out.println("Status:" + ev.getStatus());
                            System.out.println("------------------------------");

                        }

                        // enter new status //
                        System.out.println("Would u like to confirm ur presence at an EVENT,");
                        System.out.println("YES OR NO?");
                        String yn = sc.nextLine();
                        switch (yn) {
                            case "yes":
                                for (int in = 0; in < unConfirmed.size(); in++) {
                                    Event even = unConfirmed.get(in);
                                    System.out.println("[" + in + "] Name:" + even.getName());
                                }
                                System.out.println("Type ur option:");
                                int position = sc.nextInt();
                                sc.nextLine();
                                Event confirmed = unConfirmed.get(position);
                                confirmed.setFinished(true);
                                status = "CONFIRMED";
                                confirmed.setStatus(status);
                                System.out.println("Event CONFIRMED successfully");
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
                    ArrayList<Event> list_2 = loggedUser.getEvents();

                    if (list_2.isEmpty()) {
                        System.out.println("U don't have Events!!!");
                    }

                    for (int i = 0; i < list_2.size(); i++) {
                        Event ev = list_2.get(i);

                        System.out.println("========= Event - " + i + " =========");
                        System.out.println("Name:" + ev.getName());
                        System.out.println("Adress:" + ev.getNumb() + "," + ev.getSt_ave() + "," + ev.getNumbHome() + "," + ev.getCity() + "," + ev.getState() + "," + ev.getZip_code());
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
