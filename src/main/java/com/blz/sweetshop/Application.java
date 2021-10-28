package com.blz.sweetshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        System.out.println("Welcome to Sweet Shop Management program");
        int choice = 0;
        Application application = new Application();
        while (choice != 7) {
            choice = application.userInterface.showUserMenu();
            application.handleUserSelection(choice);
        }
        System.out.println("Good Bye!!!");
    }
        SweetRepository sweetRepository = new SweetRepository();
        UserInterface userInterface = new UserInterface();


        public void handleUserSelection(int choice) {
            Set sweetSet = sweetRepository.getSweetList();
            switch (choice) {
                case 1:
                    addSweet();
                    break;
                case 2:

                    break;
                case 3:
                    break;
                case 4:
                    userInterface.print(sweetSet);
                    break;
                case 5:
                    System.out.println("\nPrinting IDietSweet\n");
                    userInterface.printDietSweets(sweetSet);
                    break;
                case 6:
                    System.out.println("\nPrinting INormalSweet\n");
                    userInterface.printNormalSweets(sweetSet);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Enter correct choice");
            }
        }
        public void addSweet() {

        Sweet laddu = new Laddu();
        laddu.id = "Bl001";
        laddu.price = 20;

        Sweet kajukatdhi = new Kajukatdhi();
        kajukatdhi.id = "Kk002";
        kajukatdhi.price= 25;

        Sweet jelibi = new Jelibi();
        jelibi.id = "j003";
        jelibi.price = 15;

        Sweet kalakhand = new Kalakhand();
        kalakhand.id = "k004";
        kalakhand.price = 50;

        Sweet rasmalai = new Rasmalai();
        rasmalai.id = "p005";
        rasmalai.price = 100;


        SweetRepository sweetRepository = new SweetRepository();
        sweetRepository.add(laddu);
        sweetRepository.add(kajukatdhi);
        sweetRepository.add(jelibi);
        sweetRepository.add(kalakhand);
        sweetRepository.add(rasmalai);



        UserInterface userInterface = new UserInterface();
        Set sweetSet = sweetRepository.getSweetList();

        userInterface.print(sweetSet);
        System.out.println("\nPrinting IDietSweet\n");
        userInterface.printDietSweets(sweetSet);
        System.out.println("\nPrinting INormalSweet\n");
        userInterface.printNormalSweets(sweetSet);
        sweetRepository.delete(laddu);
        sweetRepository.delete(kalakhand);
        sweetRepository.delete(kajukatdhi);
        System.out.println("\nPrinting after remove the sweet\n");
        userInterface.print(sweetSet);

    }
}