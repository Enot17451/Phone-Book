package contacts;

import java.util.ArrayList;
import java.util.Scanner;

class PhoneBook {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Contact> contacts = new ArrayList<>();

    void add() {
        Contact contact = new Contact();
        contact.id = contacts.size() + 1;
        enterName(contact);
        enterSurname(contact);
        enterNumber(contact);
        contacts.add(contact);
        System.out.println("The record added.");
    }

    boolean validateNumber(String number) {
        String validNumberReg = "^(\\d{10})|(([\\(]?([0-9]{3})[\\)]?)?[ \\.\\-]?([0-9]{3})[ \\.\\-]([0-9]{4}))$\n";
        return number.matches(validNumberReg);
    }

    void count() {
        System.out.println("The Phone Book has " + contacts.size() + " records.");
    }

    void edit() {
        if (contacts.size() == 0) {
            System.out.println("No records to edit!");
        } else {
            list();
            System.out.println("Select a record:");
            int id = scanner.nextInt();
            System.out.println("Select a field (name, surname, number):");
            String field = scanner.nextLine();
            switch (field) {
                case "name":
                    enterName(contacts.get(id - 1));
                    break;
                case "surname":
                    enterSurname(contacts.get(id - 1));
                    break;
                case "number":
                    enterNumber(contacts.get(id - 1));
                    break;
            }
            System.out.println("The record updated!");
        }
    }

    void enterName(Contact contact) {
        System.out.println("Enter the name:");
        contact.name = scanner.nextLine();
    }

    void enterSurname(Contact contact) {
        System.out.println("Enter the surname:");
        contact.surname = scanner.nextLine();
    }

    void enterNumber(Contact contact) {
        System.out.println("Enter number:");
        String phone = scanner.nextLine();
        if (validateNumber(phone)) {
            contact.phone = phone;
        } else {
            contact.phone = "[no number]";
            System.out.println("Wrong number format!");
        }
    }


    void delete() {
        if (contacts.size() == 0) {
            System.out.println("No records to remove!");
        }
    }

    void list() {
        if (contacts.size() == 0) {
            System.out.println("The Phone Book has 0 records.");
        } else {
            for (var c : contacts) {
                System.out.println(c.id + ". " + c.name + " " + c.surname + ", " + c.phone);
            }
        }

    }
}

class Contact {
    int id;
    String name;
    String surname;
    String phone;
}

public class Main {
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        PhoneBook book = new PhoneBook();
        boolean exit = false;
        while (!exit) {
            System.out.println("Enter action (add, remove, edit, count, list, exit):");
            String action = scaner.nextLine();
            switch (action) {
                case "add":
                    book.add();
                    break;
                case "remove":
                    book.delete();
                    break;
                case "edit":
                    book.edit();
                    break;
                case "count":
                    book.count();
                    break;
                case "list":
                    book.list();
                    break;
                case "exit":
                    exit = true;
                    break;

            }
        }

    }
}