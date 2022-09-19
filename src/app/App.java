package app;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static Scanner sc = new Scanner(System.in);
    public static User loggedUser = null;

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
                    System.out.print("now a password:");
                    String psw = sc.nextLine();

                    User user = new User();
                    user.setEmail(email);
                    user.setPsw(psw);
                    list.add(user);

                    System.out.println("-> registered successfully <-");//28
                    System.out.println("==============================");//29 
                    homePage();
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
            System.out.println("[3]- EVENTS YOU CONFIRMED");
            System.out.println("[4]- EVENTS YOU DIDN'T CONFIRM");
            System.out.println("[5]- LIST ALL EVENTS");
            System.out.println("[0]- LOGOUT");
            System.out.print("Type an option:");
            String opn = sc.nextLine();

            switch (opn) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    System.out.println("-------- ALL EVENTS ---------");
                    ArrayList<Event> list_2 = loggedUser.getTasks();
                    
                    for(int i = 0;i < list_2.size();i++){
                        Event t = list_2.get(i);
                        System.out.println("Event - "+ i);
                    }
                    break;
                case "0":
                    System.out.println("Right,see U!");
                    controller = false;
                     loggedUser = null;                   
                    break;
                default: {
                    System.out.println("You need to enter a valid number!");
                }
            }

        }
    }
}
