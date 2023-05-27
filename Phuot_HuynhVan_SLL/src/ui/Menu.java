package ui;

import java.util.ArrayList;
import util.MyUtils;

/**
 *
 * @author Huynh Van Phuot
 */
public class Menu {

    private String menuTitle;
    private ArrayList<String> optionList = new ArrayList<>();

    public Menu() {
    }

    public Menu(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public void addNewOption(String newOption) {
        optionList.add(newOption);
    }

    public void printMenu() {
        if (optionList.isEmpty()) {
            System.out.println("There's no item in the menu!");
            return;
        }
        System.out.println();
        System.out.println("Welcome to " + menuTitle);
        for (String x : optionList) {
            System.out.println(x);
        }
    }

    public int getChoice() {
        int maxOption = optionList.size();
        String inputMsg = "Input your choice from 1 to " + maxOption + ": ";
        String errorMsg = "Please re-input your choice from the following options 1 to " + maxOption;
        return MyUtils.getAnInteger(inputMsg, errorMsg, 1, maxOption);
    }
}
