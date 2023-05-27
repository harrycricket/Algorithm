package main;

import data.BST;
import data.Student;
import ui.Menu;
import util.MyUtils;

/**
 *
 * @author Huynh Van Phuot
 */
public class BST_Management {

    private final BST<Student> studentTree;

    public BST_Management() {
        studentTree = new BST<>();
    }

    private Student searchById(String stuID) {
        Student std = studentTree.search(new Student(stuID));
        return std;
    }

    private String inputStudentId() {
        String stdId = MyUtils.getStringReg("Input student ID: ", Student.CODE_PATTERN,
                "The code must be " + Student.CODE_FORMAT + "(x is a digit)", true);
        return stdId;
    }

    private void addANewStudent() {
        Student std;
        String stdId;
        do {
            stdId = inputStudentId();
            std = searchById(stdId);
            if (std != null) {
                System.out.println("This student's id already exist!");
            }
        } while (std != null);
        String name = MyUtils.getString("Input the student's name: ", "The input is illegal!");
        int yob = MyUtils.getAnInteger("Input the year of birth: ", "The input is illegal!", 1995, 2010);
        double gpa = MyUtils.getADouble("Input the student's GPA: ", "The input is illegal!", 0, 10);
        String phoneNumber = MyUtils.getStringReg("Input phone number: ", Student.PHONE_NUMER_PATTERN,
                "The phone number must be " + Student.PHONE_NUMER_FORMAT + "(x is a digit)", true);
        Student student = new Student(stdId, name, yob, gpa, phoneNumber);
        studentTree.insert(student);
    }

    private void updateGpa() {
        String stdId = inputStudentId();
        Student std = searchById(stdId);
        if (std != null) {
            std.setGpa(MyUtils.getADouble("Input a new student's GPA: ", "The input is not empty!", 0, 10));
            print();
            System.out.println("Update succesfully!");
        } else {
            System.out.println("The student's id is not found!");
        }
    }

    private void removeAStudent() {
        String stdId = inputStudentId();
        Student std = searchById(stdId);
        if (std != null) {
            studentTree.deleteByMerging(std);
            print();
            System.out.println("Remove succesfully!");
        } else {
            System.out.println("The student's id is not found!");
        }
    }

    private void print() {
        studentTree.inorder();
    }

    private void process() {
        Menu menu = new Menu("Student Management");
        menu.addNewOption("1. Add a new student (automatic)");
        menu.addNewOption("2. Add a new student(input from user)");
        menu.addNewOption("3. Update the student's GPA");
        menu.addNewOption("4. Remove a student");
        menu.addNewOption("5. Quit");

        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1 -> {
                    Student st1 = new Student("S22222", "Ronaldo", 2000, 8.2, "0123012301");
                    Student st2 = new Student("S44444", "Kane", 2003, 6.4, "0123456012");
                    Student st3 = new Student("S11111", "Messi", 2002, 9.1, "0120120120");
                    Student st4 = new Student("S33333", "Neymar", 2001, 7.3, "0123401234");
                    studentTree.insert(st1);
                    studentTree.insert(st2);
                    studentTree.insert(st3);
                    studentTree.insert(st4);
                    print();
                    System.out.println("Add list of students successfully!");
                }
                case 2 -> {
                    addANewStudent();
                    print();
                    System.out.println("Add a new student successfully!");
                }
                case 3 -> {
                    updateGpa();
                }
                case 4 -> {
                    removeAStudent();
                }
                case 5 -> {
                    System.out.println("Catch you later!");
                }
            }
        } while (choice != 5);
    }

    public static void main(String[] args) {
        BST_Management student = new BST_Management();
        student.process();
    }
}
