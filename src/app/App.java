package app;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Register> reg = new ArrayList();
        
        boolean controller = true;
        // MENU USER //
        System.out.println("Welcome to Events!");
        while (controller) {
            System.out.println("[1]- REGISTER A NEW USER");
            System.out.println("[2]- LOGIN");
            System.out.println("[3]- OUT");
            System.out.print("TYPE AN OPTION:");
            int opn = sc.nextInt();
            // PROCESSING //
            switch (opn) {
                case 1: {
                    System.out.println("====== REGISTER A USER ======");
                    System.out.println("type ur email:");
                    String email = sc.nextLine();
                    System.out.println("no a password:");
                    String psw = sc.nextLine();
                    Register user = new Register();
                    
                    break;
                }
                case 2: {
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
