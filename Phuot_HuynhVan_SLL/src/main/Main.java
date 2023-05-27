package main;

import data.SinglyLinkedList;
import data.Laptop;
import ui.Menu;

/**
 *
 * @author Huynh Van Phuot
 */
public class Main {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        Laptop l1 = new Laptop("LAP01", 30000000, 2018, "Black", "ACER");
        Laptop l2 = new Laptop("LAP02", 25000000, 2015, "Pink", "DELL");
        Laptop l3 = new Laptop("LAP03", 27000000, 2017, "Gray", "HP");
        Laptop l4 = new Laptop("LAP04", 15000000, 2021, "Green", "ACER");
        Laptop l5 = new Laptop("LAP05", 45000000, 2016, "Blue", "DELL");
        Laptop l6 = new Laptop("LAP06", 40000000, 2018, "Gray", "LENOVO");
        Laptop l7 = new Laptop("LAP07", 20000000, 2020, "Red", "HP");
        Laptop l8 = new Laptop("LAP08", 50000000, 2015, "Gray", "MACBOOK");
        Laptop l9 = new Laptop("LAP09", 25000000, 2019, "Pink", "HP");
        Laptop l10 = new Laptop("LAP10", 32000000, 2022, "Gray", "LENOVO");

        Menu menu = new Menu("Laptop Management");
        menu.addNewOption("1. Add a new laptop (auto) to the top of the list (except the laptop which produced in 2022)");
        menu.addNewOption("2. Add a new laptop from the user");
        menu.addNewOption("3. Update the price of laptop produced by Acer");
        menu.addNewOption("4. Take the laptops has gray color");
        menu.addNewOption("5. Remove 3 laptops from the top of the list");
        menu.addNewOption("6. Sort the laptops ascending by price");
        menu.addNewOption("7. Quit");

        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1 -> {
                    list.addALaptop(l1);
                    list.addALaptop(l2);
                    list.addALaptop(l3);
                    list.addALaptop(l4);
                    list.addALaptop(l5);
                    list.addALaptop(l6);
                    list.addALaptop(l7);
                    list.addALaptop(l8);
                    list.addALaptop(l9);
                    list.addALaptop(l10);   // laptop has yearOfProduct is 2022
                    System.out.println();
                    System.out.println("The list of laptops: ");
                    list.traverse();
                }
                case 2 -> {
                    list.addALaptop();
                    System.out.println();
                    System.out.println("The list of laptops: ");
                    list.traverse();
                }
                case 3 -> {
                    System.out.println();
                    System.out.println("The list of laptops after update the price: ");
                    list.updatePrice();
                }
                case 4 -> {
                    System.out.println();
                    System.out.println("The list of laptops have gray color: ");
                    list.takeGrayLaptops();
                }
                case 5 -> {
                    System.out.println();
                    System.out.println("The list of laptops after remove 3 laptops in the top of the list: ");
                    list.remove3Laptops();
                }
                case 6 -> {
                    System.out.println();
                    System.out.println("The list of laptops after sort ascending by price: ");
                    list.sortByPriceAsc();
                    list.traverse();
                }
                case 7 ->
                    System.out.println("Catch you later!");
            }
        } while (choice != 7);
    }
}
