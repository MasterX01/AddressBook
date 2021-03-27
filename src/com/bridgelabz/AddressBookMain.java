package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMain {

    Scanner scan = new Scanner(System.in);
    HashMap<String, AddressBook> setOfBooks = new HashMap<>();
    String currAddressBook;

    public void choiceSelect() {
        AddressBook obj = setOfBooks.get(currAddressBook);
        System.out.println("Please enter you choice from below action");
        System.out.println("1) Add Person Details\n" +
                            "2) Edit Person Details\n" +
                            "3) Delete Person's Details\n" +
                            "4) Add Multiple People at the Same Time\n" +
                            "5) Add New Address Book\n" +
                            "6) Exit");
        int choice = scan.nextInt();
        switch (choice){
            case 1:
                obj.addPersonDetails();
                break;
            case 2:
                obj.editPersonDetails();
                break;
            case 3:
                obj.deletePersonDetails();
                break;
            case 4:
                obj.addMultiplePerson();
                break;
            case 5:
                addNewAddressBook();
                break;
        }
    }

    public void addNewAddressBook(){
        System.out.println("Enter the New Address Book Name");
        String nameOfBook = scan.nextLine();
        while(setOfBooks.containsKey(nameOfBook)){
            System.out.println("The Name already exists, Please try again");
            nameOfBook = scan.nextLine();
        }
        setOfBooks.put(nameOfBook, new AddressBook());
    }

    public static void main(String[] args){
        AddressBookMain obj = new AddressBookMain();
        if(obj.setOfBooks.isEmpty()){
            System.out.println("There is currently no address books in the system. Please add a Address Book Before Moving Forward");
            obj.currAddressBook = obj.scan.nextLine();
            obj.setOfBooks.put(obj.currAddressBook, new AddressBook());
            obj.choiceSelect();
        }else {
            obj.choiceSelect();
        }

    }
}
