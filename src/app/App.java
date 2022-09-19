package app;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Register> list = new ArrayList();

        boolean controller = true;
        // MENU USER //
        System.out.println("Welcome to Events!");
        while (controller) {
            System.out.println("[1]- REGISTER A NEW USER");
            System.out.println("[2]- LOGIN");
            System.out.println("[3]- OUT");
            System.out.print("TYPE AN OPTION:");
            int opn = sc.nextInt();
            sc.nextLine();
            // PROCESSING //
            switch (opn) {
                // SIGN UP //
                case 1: {
                    System.out.println("========== SIGN UP ==========");//29
                    System.out.println("type ur email:");
                    String email = sc.nextLine();
                    System.out.print("now a password:");
                    String psw = sc.nextLine();

                    Register user = new Register();
                    user.setEmail(email);
                    user.setPsw(psw);
                    list.add(user);

                    System.out.println("-> registered successfully <-");//28
                    System.out.println("==============================");//29                   
                    break;
                }
                case 2: {
                    System.out.println("============ LOGIN ===========");
                    System.out.println("ur email:");
                    String email = sc.nextLine();
                    System.out.print("ur password:");
                    String psw = sc.nextLine();
                    
                    // VERIFICATION OF EMAIL //
                    boolean truLogin = false;
                    for (Register user : list) {

                        String uEmail = user.getEmail();
                        String uPsw = user.getPsw();

                        boolean truEmail = email.equals(uEmail);
                        boolean truPsw = psw.equals(uPsw);

                        if (truEmail && truPsw) {
                            truLogin = true;
                            break;
                        }
                    }
                    if (!truLogin) {
                        System.out.println("Email and Password dont match!");
                    } else {
                        System.out.println("Successfully loaded!!!");
                    }
                    break;
                }
                case 3: {
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

}
