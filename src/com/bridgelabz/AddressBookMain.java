package com.bridgelabz;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain {

    Scanner scan = new Scanner(System.in);
    HashMap<String, AddressBook> setOfBooks = new HashMap<>();
    String currAddressBook;
    Map<String, String> cityToPerson = new HashMap<>();
    Map<String, String> stateToPerson = new HashMap<>();


    public void choiceSelect() {
        AddressBook obj = setOfBooks.get(currAddressBook);
        System.out.println("Please enter you choice from below action");
        System.out.println("1) Add Person Details\n" +
                            "2) Edit Person Details\n" +
                            "3) Delete Person's Details\n" +
                            "4) Add Multiple People at the Same Time\n" +
                            "5) Add New Address Book\n" +
                            "6) Search by City\n" +
                            "7) Search By State\n" +
                            "8) View Person By City and State\n" +
                            "9) Exit\n");
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
            case 6:
                searchByCity();
                break;
            case 7:
                searchByState();
                break;
            case 8:
                System.exit(0);
                break;
            case 9:
                System.exit(0);
        }
    }


    public void searchByState() {
        System.out.println("Please Enter the Name of the State you want to search by.");
        String stateName = scan.nextLine();
        setOfBooks.values().forEach(e ->{
            e.personArrayList.forEach(s -> {
                if(s.state.equals(stateName)){
                    System.out.println(s.firstName);
                }
            });
        });
    }

    public void searchByCity() {
        System.out.println("Please Enter the City Name you want to search by.");
        String cityName = scan.nextLine();
        setOfBooks.values().forEach(e ->{
            e.personArrayList.forEach(s -> {
                if(s.city.equals(cityName)){
                    System.out.println(s.firstName);
                }
            });
        });
    }

    public void addNewAddressBook(){
        System.out.println("Enter the New Address Book Name");
        String nameOfBook = scan.nextLine();
        while(setOfBooks.containsKey(nameOfBook)){
            System.out.println("The Name already exists, Please try again");
            nameOfBook = scan.nextLine();
        }
        currAddressBook = nameOfBook;
        setOfBooks.put(nameOfBook, new AddressBook());
    }

    public static void main(String[] args){
        AddressBookMain obj = new AddressBookMain();
        if(obj.setOfBooks.isEmpty()){
            System.out.println("There is currently no address books in the system. Please add a Address Book Before Moving Forward");
            obj.currAddressBook = obj.scan.nextLine();
            obj.setOfBooks.put(obj.currAddressBook, new AddressBook());
        }
        obj.choiceSelect();

    }
}
