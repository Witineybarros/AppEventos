package app;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static Scanner sc = new Scanner(System.in);
    public static User loggedUser = null;
    public static boolean onOff;
    public static String status;

    public static void main(String[] args) {

        ArrayList<User> list = new ArrayList();

        boolean controller = true;
        // MENU USER //
        System.out.println("     Welcome to Events!      ");
        while (controller) {
            System.out.println("=========== MENU ============");
            System.out.println("[1]- REGISTER A NEW USER");
            System.out.println("[2]- LOGIN");
            System.out.println("[0]- LOGOUT");
            System.out.print("TYPE AN OPTION:");
            String opn = sc.nextLine();
            // PROCESSING //
            switch (opn) {
                // SIGN UP //
                case "1": {

                    System.out.println("========== SIGN UP ==========");//29
                    System.out.print("type ur email:");
                    String email = sc.nextLine();
                    System.out.print("now password:");
                    String psw = sc.nextLine();

                    User user = new User();
                    user.setEmail(email);
                    user.setPsw(psw);

                    ArrayList<Event> event = new ArrayList();
                    user.setEvents(event);

                    list.add(user);

                    System.out.println("-> registered successfully <-");//28
                    System.out.println("==============================");//29 
                    //homePage();
                    break;

                }
                case "2": {
                    System.out.println("============ LOGIN ===========");
                    System.out.print("ur email:");
                    String email = sc.nextLine();
                    System.out.print("ur password:");
                    String psw = sc.nextLine();

                    // EMAIL VERIFICATION  //
                    boolean truLogin = false;
                    for (User user : list) {

                        String uEmail = user.getEmail();
                        String uPsw = user.getPsw();

                        boolean truEmail = email.equals(uEmail);
                        boolean truPsw = psw.equals(uPsw);

                        if (truEmail && truPsw) {
                            truLogin = true;
                            loggedUser = user;
                            break;
                        }
                    }
                    if (!truLogin) {
                        System.out.println("Email and Password dont match!");
                    } else {
                        System.out.println("Successfully loaded!!!");
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
            System.out.println("======= UR HOMEPAGE =========");
            System.out.println("[1]- ADD NEW EVENT");
            System.out.println("[2]- DELETE AN EVENT");
            System.out.println("[3]- EVENTS CONFIRMED");
            System.out.println("[4]- UNCONFIRMED EVENTS");
            System.out.println("[5]- LIST ALL EVENTS");
            System.out.println("[0]- LOGOUT");
            System.out.print("Type an option:");
            String opn = sc.nextLine();

            switch (opn) {
                case "1": {
                    System.out.println("------- ADD NEW EVENT -------");
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
                    System.out.println("-----------------------------");
                    System.out.println("Category:");
                    String category = sc.nextLine();
                    System.out.println("an DESCRIPTION 'BOUT event:");
                    String description = sc.nextLine();
                    System.out.println("-----------------------------");
                    System.out.println("Would u like to confirm ur presence at this EVENT,");
                    System.out.println("YES OR NO?");
                    String yn = sc.nextLine();
                    if (yn.equals("yes")) {
                        onOff = true;
                        status = "CONFIRMED";
                        System.out.println("Status:" + onOff + status);

                    } else {
                        onOff = false;
                        status = "UNCONFIRMED";
                        System.out.println("status:" + onOff + status);
                    }
                    Event ev = new Event();
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
                    ev.setYn(yn);
                    ev.setFinished(onOff);
                    ev.setStatus(status);

                    loggedUser.getEvents().add(ev);
                    System.out.println("EVENT added successfully!");

                    break;
                }
                case "2": {
                    break;
                }
                case "3": {
                    System.out.println("----- Confirmed Events ------");
                    ArrayList<Event> list3 = loggedUser.getEvents();
                    ArrayList<Event> finished = new ArrayList();

                    for (Event ev : list3) {
                        if (ev.isFinished()) {
                            finished.add(ev);
                        }
                    }
                    if (finished.isEmpty()) {
                        System.out.println("U dont have confirmed Events!!!");
                    }
                    for (int i = 0; i < finished.size(); i++) {
                        Event ev = finished.get(i);
                        System.out.println("--------- Evento" + i + " ------------");
                        System.out.println("Name:" + ev.getName());
                        System.out.println("Adress:" + ev.getNumb() + "," + ev.getSt_ave() + "," + ev.getNumbHome() + "," + ev.getCity() + "," + ev.getState() + "," + ev.getZip_code() + "," + ev.getCountry());
                        System.out.println("Category:" + ev.getCategory());
                        System.out.println("Description:" + ev.getDescription());
                        System.out.println("Status:" + ev.getStatus());
                        System.out.println("------------------------------");

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
                    }
                    for (int i = 0; i < unConfirmed.size(); i++) {
                        Event ev = unConfirmed.get(i);
                        System.out.println("--------- Evento" + i + " ------------");
                        System.out.println("Name:" + ev.getName());
                        System.out.println("Adress:" + ev.getNumb() + "," + ev.getSt_ave() + "," + ev.getNumbHome() + "," + ev.getCity() + "," + ev.getState() + "," + ev.getZip_code());
                        System.out.println("Category:" + ev.getCategory());
                        System.out.println("Description:" + ev.getDescription());
                        System.out.println("Status:" + ev.getStatus());
                        System.out.println("------------------------------");
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
