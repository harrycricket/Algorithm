package data;

import java.util.EmptyStackException;
import util.MyUtils;

/**
 *
 * @author Huynh Van Phuot
 */
public class SinglyLinkedList {

    Node head, tail;

    public SinglyLinkedList() {
        head = tail = null;
    }

    /**
     * Check the list is empty or not
     *
     * @return isEmpty()
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Clear the list
     */
    public void clear() {
        head = tail = null;
    }

    /**
     * Add a laptop to the top of the list
     *
     * @param p
     */
    public void addALaptop(Laptop p) {
        Node newLaptop = new Node(p, null);
        if (newLaptop.info.getYearOfProduct() == 2022) {
            System.out.println("The laptop " + newLaptop.info.getId() + " has year produced is 2022!");
        } else {
            if (this.isEmpty()) {
                head = tail = newLaptop;
            } else {
                newLaptop.next = head;
                head = newLaptop;
            }
        }
    }

    /**
     * Add a laptop from user input the value
     */
    public void addALaptop() {
        Laptop newLaptop;
        String id;
        double price;
        int yearOfProduct;
        String color;
        String branch;
        
        id = MyUtils.getString("Input the laptop's id: ", "The input was wrong!").toUpperCase();
        price = MyUtils.getADouble("Input the price: ", "The input was wrong!", 0, 100000000);
        yearOfProduct = MyUtils.getAnInteger("Input the year of product: ", "The input was wrong!");
        color = MyUtils.getString("Input the laptop's color: ", "The input was wrong!").toUpperCase();
        branch = MyUtils.getString("Input the laptop's branch: ", "The input was wrong!").toUpperCase();
        newLaptop = new Laptop(id, price, yearOfProduct, color, branch);
        if(yearOfProduct == 2022) {
            System.out.println("The laptop " + newLaptop.getId() + " has year produced is 2022!");
            System.out.println("Add a new laptop failed!");
        } else {
            System.out.println("Add a new laptop successfully!");
            addALaptop(newLaptop);
        }
    }

    /**
     * Take the gray laptops from the list
     */
    public void takeGrayLaptops() {
        Node temp = head;
        if (this.isEmpty()) {
            System.out.println("There's no laptop here");
        } else {
            while (temp != null) {
                if (temp.info.getColor().equalsIgnoreCase("Gray")) {
                    System.out.println(temp.info);
                }
                temp = temp.next;
            }
        }
    }

    /**
     * Remove a laptop in the top of the list
     */
    public void removeALaptop() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        } else {
            head = head.next;
        }
    }

    /**
     * Remove 3 laptops in the top of the list
     */
    public void remove3Laptops() {
        if (countElements() < 3) {
            System.out.println("Can't remove 3 laptops because the list has less than 3 laptops!");;
        } else {
            for (int i = 0; i < 3; i++) {
                head = head.next;
            }
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.info);
                temp = temp.next;
            }
        }
    }

    /**
     * Discount the laptop produced by Acer
     */
    public void updatePrice() {
        Node temp = head;
        if (!this.isEmpty()) {
            while (temp != null) {
                if (temp.info.getBranch().equalsIgnoreCase("Acer")) {
                    temp.info.setPrice(temp.info.getPrice() - 1050000);
                }
                System.out.println(temp.info);
                temp = temp.next;
            }
        } else {
            System.out.println("There's no laptop here");
        }
    }

    /**
     * Traverse all the element in the list
     */
    public void traverse() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.info);
            temp = temp.next;
        }
    }

    /**
     * Count the number of elements in the list
     *
     * @return numberOfElements
     */
    public int countElements() {
        int numberOfElements = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            numberOfElements++;
        }
        return numberOfElements;
    }

    /**
     * Sorting the list of laptops ascending by price
     */
//    Sort using for loop
    public void sortByPriceAsc() {
        Node temp = head;
        if (!this.isEmpty()) {
            int count = countElements();
            for (int i = 0; i < count - 1; i++) {
                Node tmp = temp.next;
                for (int j = i + 1; j < count; j++) {
                    if (temp.info.getPrice() > tmp.info.getPrice()) {
                        Laptop t = temp.info;
                        temp.info = tmp.info;
                        tmp.info = t;
                    }
                    tmp = tmp.next;
                }
                temp = temp.next;
            }
        } else {
            System.out.println("There's no laptop here");
        }
    }

//    Sort using while loop
//    public void sortByPriceAsc() {
//        Node temp = head;
//        while (temp != null) {
//            Node tmp = temp.next;
//            while (tmp != null) {
//                if (temp.info.getPrice() > tmp.info.getPrice()) {
//                    Laptop t = temp.info;
//                    temp.info =tmp.info;
//                    tmp.info = t;
//                }
//                tmp = tmp.next;
//            }
//            temp = temp.next;
//        }
//    }
}
