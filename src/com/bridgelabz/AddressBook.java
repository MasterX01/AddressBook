package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class AddressBook {

    ArrayList<Person> personArrayList = new ArrayList<Person>();
    static Scanner scan = new Scanner(System.in);
    Person person = new Person();

    public void addPersonDetails() {

        System.out.println("Please enter the First Name: ");
        String fName = scan.nextLine();
        String finalFName = fName;
        while(personArrayList.stream().anyMatch(s -> s.firstName.equalsIgnoreCase(finalFName))){
            System.out.println("Name Already exists, Please enter a New Name");
            fName = scan.nextLine();
        }
        System.out.println("Please enter the Last Name: ");
        person.setLastName(scan.nextLine());
        System.out.println("Please enter the Address: ");
        person.setAddress(scan.nextLine());
        System.out.println("Please enter the City: ");
        person.setCity(scan.nextLine());
        System.out.println("Please enter the State: ");
        person.setState(scan.nextLine());
        System.out.println("Please enter the Zip: ");
        person.setZip(scan.nextLine());
        System.out.println("Please enter the Phone Number: ");
        person.setpNo(scan.nextLine());
        System.out.println("Please enter the Email: ");
        person.setEmail(scan.nextLine());
        personArrayList.add(person);
    }

    public void viewPersons(){
        personArrayList.stream().forEach(s -> {
            System.out.println("First Name : " + s.firstName);
            System.out.println("Last Name : " + s.lastName);
            System.out.println("Address : " + s.address);
            System.out.println("City : " + s.city);
            System.out.println("State : " + s.state);
            System.out.println("Zip : " + s.zip);
            System.out.println("Phone Number : " + s.pNo);
            System.out.println("Email : " + s.email);
        });
    }

    public void editPersonDetails() {
        System.out.println("Enter the First Name of the Person");
        String fName = scan.nextLine();
        personArrayList.stream().filter(s -> s.firstName.equals(fName)).peek(s->{
            Person person = s;
        });
        System.out.println(person.firstName);
        System.out.println("What do you want to edit?\n" +
                "1) Last Name" +
                "2) Address" +
                "3) City" +
                "4) State" +
                "5) Zip" +
                "6) Phone Number" +
                "7) Email");
        int choice = scan.nextInt();
        switch (choice){
            case 1:
                System.out.println("Enter the New Last Name");
                person.setLastName(scan.nextLine());
                break;
            case 2:
                System.out.println("Enter the New Address");
                person.setAddress(scan.nextLine());
                break;
            case 3:
                System.out.println("Enter the New City");
                person.setCity(scan.nextLine());
                break;
            case 4:
                System.out.println("Enter the New State");
                person.setState(scan.nextLine());
            case 5:
                System.out.println("Enter the New Zip");
                person.setZip(scan.nextLine());
            case 6:
                System.out.println("Enter the New Phone Number");
                person.setpNo(scan.nextLine());
            case 7:
                System.out.println("Enter the New Email");
                person.setEmail(scan.nextLine());
        }
    }

    public void deletePersonDetails() {
        System.out.println("Enter the First Name of the Person whose contact you want to delete.");
        String fName = scan.nextLine();
        personArrayList.stream().filter(s -> s.firstName.equals(fName)).peek(s->{
            Person person = s;
        });
        personArrayList.remove(person);
    }

    public void addMultiplePerson() {
        System.out.println("How Many People do you want to add?");
        int numOfPeople = scan.nextInt();
        for(int i = 0; i < numOfPeople; i++){
            addPersonDetails();
        }
    }

}
