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
                            "9) Sort By Name\n" +
                            "10) Sort By City\n" +
                            "11) Sort By State\n" +
                            "12) Sort By Zip\n" +
                            "13) Exit\n");
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
                viewByCityAndState();
                break;
            case 9:
                sortByName();
                break;
            case 10:
                sortByCity();
                break;
            case 11:
                sortByState();
                break;
            case 12:
                sortByZip();
                break;
            case 13:
                System.exit(0);
        }
    }

    public void sortByZip() {
        List<String> personList5 = setOfBooks.values().stream()
                .flatMap(s -> s.personArrayList.stream()).map(st -> st.zip).sorted().distinct()
                .collect(Collectors.toList());
        for (String zip : personList5) {
            setOfBooks.values().forEach(s -> {
                s.personArrayList.forEach(sm -> {
                    if (sm.zip == zip) {
                        s.viewPersons(sm);
                    }
                });
            });
        }
    }

    public void sortByState() {
        List<String> personList4 = setOfBooks.values().stream()
                .flatMap(s -> s.personArrayList.stream()).map(st -> st.state).sorted().distinct()
                .collect(Collectors.toList());
        System.out.println(personList4);
        for (String state : personList4) {
            setOfBooks.values().forEach(s -> {
                s.personArrayList.forEach(sm -> {
                    if (sm.state.equals(state)) {
                        s.viewPersons(sm);
                    }
                });
            });
        }
    }

    public void sortByCity() {
        List<String> personList3 = setOfBooks.values().stream()
                .flatMap(s -> s.personArrayList.stream()).map(st -> st.city).sorted().distinct()
                .collect(Collectors.toList());
        for (String city : personList3) {
            setOfBooks.values().forEach(s -> {
                s.personArrayList.forEach(sm -> {
                    if (sm.city.equals(city)) {
                        s.viewPersons(sm);
                    }
                });
            });
        }
    }

    public void sortByName() {
        List<String> sortListByName = setOfBooks.values().stream().flatMap(s -> s.personArrayList.stream())
                .map(st -> st.firstName).sorted().collect(Collectors.toList());
        System.out.println("Sorted by First Names");
        for (String name : sortListByName) {
            setOfBooks.values().forEach(s -> {
                s.personArrayList.forEach(sm -> {
                    if (sm.firstName.equals(name)) {
                        s.viewPersons(sm);
                    }
                });
            });
        }
    }

    public void viewByCityAndState() {
        setOfBooks.values().forEach(s->{
            s.personArrayList.forEach(sm->{
                {
                    cityToPerson.put(sm.firstName, sm.city);
                    stateToPerson.put(sm.firstName, sm.state);
                    System.out.println(sm.firstName + " : " + sm.city + " : " + sm.state);
                }
            });
        });
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
        //UC-10 count for state
        List<Person> personList1 = setOfBooks.values().stream().flatMap(s->s.personArrayList.stream()).collect(Collectors.toList());
        long count1 = personList1.stream().filter(s->s.state.equals(stateName)).count();
        System.out.println("Count in "+stateName+" is "+count1);

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
        //UC-10 count for city
        List<Person> personList = setOfBooks.values().stream().flatMap(s->s.personArrayList.stream()).collect(Collectors.toList());
        long count = personList.stream().filter(s->s.city.equals(cityName)).count();
        System.out.println("Count in "+cityName+" is "+count);
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

    public static void main(String[] args) {
        AddressBookMain obj = new AddressBookMain();
        if(obj.setOfBooks.isEmpty()){
            System.out.println("There is currently no address books in the system. Please add a Address Book Before Moving Forward");
            obj.currAddressBook = obj.scan.nextLine();
            obj.setOfBooks.put(obj.currAddressBook, new AddressBook());
        }
        obj.choiceSelect();

    }
}
