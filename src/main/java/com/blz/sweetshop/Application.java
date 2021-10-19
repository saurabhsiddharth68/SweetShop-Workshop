package com.blz.sweetshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {

        System.out.println("Welcome to Sweet Shop Management program");

        Sweet Laddu = new Laddu();
        bundharLaddu.id = "Bl001";
        bundharLaddu.price = 20;

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
        sweetRepository.add(Laddu);
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
        sweetRepository.delete(Laddu);
        sweetRepository.delete(kalakhand);
        sweetRepository.delete(kajukatdhi);
        System.out.println("\nPrinting after remove the sweet\n");
        userInterface.print(sweetSet);

    }
}