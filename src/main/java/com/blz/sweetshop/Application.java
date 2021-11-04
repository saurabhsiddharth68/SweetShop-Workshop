package com.blz.sweetshop;

import java.util.Scanner;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        System.out.println("Welcome to Sweet Shop Management program");
        Application application = new Application();
        UserInterface userInterface = UserInterface.getInstance();
        while (true) {
            int choice = userInterface.showUserMenu();
            if (choice != 0) {
                application.handleUserSelection(choice);
            } else {
                break;
            }
        }
        System.out.println("Good Bye!!!");
    }


        public void handleUserSelection(int choice) {
            SweetRepository sweetRepository = SweetRepository.getInstance();
            UserInterface userInterface = UserInterface.getInstance();
            Set sweetSet = sweetRepository.getSweetList();
            switch (choice) {
                case 1:
                    addSweet();
                    break;
                case 2:
                    removeSweet();
                    break;
                case 3:
                    editSweet();
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
                default:
                    System.out.println("Enter correct choice");
                    break;
            }
        }
        public void addSweet() {
            Sweet sweet = new Sweet();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your Sweet name");
            String sweetName = scanner.next();
            System.out.println("Enter your Sweet colour");
            setColor(sweet);
            System.out.println("Enter your Sweet Category");
            setCategory(sweet);
            System.out.println("Enter your Sweet Price");
            int price = scanner.nextInt();
            sweet.price = price;
            System.out.println("Enter your Sweet ID");
            String id = scanner.next();
            sweet.id = id;
            System.out.println("Enter sweet property");
            setProperty(sweet);
            SweetRepository sweetRepository = SweetRepository.getInstance();
            sweetRepository.add(sweet);
        }

        public void editSweet() {
            SweetRepository sweetRepository = SweetRepository.getInstance();
            System.out.println("Enter which sweet you want to edit");
            Scanner scanner = new Scanner(System.in);
            String editSweetName = scanner.next();
            Sweet sweet = sweetRepository.getSweet(editSweetName);
            System.out.println("Enter\n 1. To change name\n 2. To change colour\n" +
                    "3. To change Category\n 4. To change Price\n 5. To change Id");
            int edit = scanner.nextInt();
            switch (edit) {
                case 1:
                    System.out.println("Enter new Sweet name");
                    String newSweetName = scanner.next();
                    sweet.name = newSweetName;
                case 2:
                    setColor(sweet);
                case 3:
                    setCategory(sweet);
                case 4:
                    System.out.println("Enter new Price");
                    int newPrice = scanner.nextInt();
                    sweet.price = newPrice;
                case 5:
                    System.out.println("Enter new Id");
                    String newId = scanner.next();
                    sweet.id = newId;
                    break;
                default:
                    System.out.println("Entered incorrect choice, please enter correct choice!... ");
                    break;
            }
        }

        public void removeSweet() {
            SweetRepository sweetRepository = SweetRepository.getInstance();
            System.out.println("Enter which sweet you want to delete");
            Scanner scanner = new Scanner(System.in);
            String deleteSweetName = scanner.next();
            Sweet sweet = sweetRepository.getSweet(deleteSweetName);
            sweetRepository.delete(sweet);
        }

        public void setProperty(Sweet sweet){
            System.out.println("Enter for property\n 1. for DIET\n 2. for NORMAL");
            Scanner scanner = new Scanner(System.in);
            int property = scanner.nextInt();
            switch (property) {
                case 1:
                    sweet.propertyType = Sweet.PropertyType.DIET;
                    break;
                case 2:
                    sweet.propertyType = Sweet.PropertyType.NORMAL;
                    break;
                default:
                    System.out.println("Entered incorrect choice, please enter correct choice!... ");
            }
        }
        public void setCategory(Sweet sweet) {
            System.out.println("Enter for category\n 1. for SUGAR\n 2. for SUGAR_LESS\n 3. for GHEE\n 4. for JAGGERY");
            Scanner scanner = new Scanner(System.in);
            int category = scanner.nextInt();
            switch (category) {
                case 1:
                    sweet.category = Sweet.Category.SUGAR;
                    break;
                case 2:
                    sweet.category = Sweet.Category.SUGARLESS;
                    break;
                case 3:
                    sweet.category = Sweet.Category.GHEE;
                    break;
                case 4:
                    sweet.category = Sweet.Category.JAGGERY;
                    break;
                default:
                    System.out.println("Entered incorrect choice, please enter correct choice!... ");
            }

        }
        public void setColor(Sweet sweet) {
            System.out.println("Enter for colour \n 1. for YELLOW\n 2. for RED\n 3. for WHITE\n 4. for BROWN");
            Scanner scanner = new Scanner(System.in);
            int colour = scanner.nextInt();
            switch (colour) {
                case 1:
                    sweet.colour = Sweet.Colour.YELLOW;
                    break;
                case 2:
                    sweet.colour = Sweet.Colour.RED;
                    break;
                case 3:
                    sweet.colour = Sweet.Colour.WHITE;
                    break;
                case 4:
                    sweet.colour = Sweet.Colour.BROWN;
                    break;
                default:
                    System.out.println("Entered incorrect choice, please enter correct choice!... ");
            }
        }


}