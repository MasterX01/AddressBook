import java.util.*;
public class AddressBookMain {

    ArrayList<ArrayList<String>> contact = new ArrayList<ArrayList<String>>();

    Scanner scan = new Scanner(System.in);

    public void addContact() {
        ArrayList<String> addNew = new ArrayList<String>();
        System.out.print("Please enter the First Name: ");
        addNew.add(scan.next());
        System.out.print("Please enter the Last Name: ");
        addNew.add(scan.next());
        System.out.print("Please enter your address: ");
        addNew.add(scan.next());
        System.out.print("Please enter the City of your address: ");
        addNew.add(scan.next());
        System.out.print("Please enter the State of your address: ");
        addNew.add(scan.next());
        System.out.print("Please enter the ZIP of your address: ");
        addNew.add(scan.next());
        System.out.print("Please enter your Phone Number: ");
        addNew.add(scan.next());
        System.out.print("Please enter your email address: ");
        addNew.add(scan.next());

        //Adding contact to main list
        contact.add(addNew);

        System.out.println("The contact has been added to the Address Book");
        for(int i = 0; i < contact.size(); i++) {
            for (int j = 0; j < contact.get(i).size(); j++) {
                System.out.print(contact.get(i).get(j) + " ");
            }
            System.out.println();
        }

        System.out.println("Do you want to add another contact to the Address Book? (Y/N)");
        String choice = scan.next();
        if(choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes"))
            addContact();
        else
            choiceSelect();
        }

    public void editContact() {
        System.out.print("Please enter the First Name of the person you want to edit the contact of: ");
        String name = scan.next();
        for(int i = 0; i < contact.size(); i++){
            //Check if contact exists or not
            if(contact.get(i).contains(name)) {
                System.out.println("What do you want to edit?");
                for(int j = 0; j < contact.get(i).size(); j++) {
                    System.out.println(j + ") " + contact.get(i).get(j));
                }
                System.out.print("Enter the Number Associated with the field you want to change: ");
                int index = scan.nextInt();
                System.out.print("Enter the new data for the field: ");
                String newData = scan.next();
                contact.get(i).set(index, newData);
                System.out.println("Data Changed Successfully.");
                break;
            }
        }
    }

    public void deleteContact() {
        System.out.print("Please enter the First Name of the person you want to edit the contact of: ");
        String name = scan.next();
        for(int i = 0; i < contact.size(); i++) {
            //Check if contact exists or not
            if(contact.get(i).contains(name)) {
                contact.remove(i);
                System.out.println("Contact Deleted Successfully");
                System.out.println("Current Records in Address Book are " + contact.size());
                break;
            }
        }
    }

    public void choiceSelect() {
        System.out.println("Current Records present in the Address Book are " + contact.size());
        System.out.println("Please select you choice, do you want to\n 0) Exit the Program\n 1) Add New Contact\n 2) Edit Existing Contact\n 3) Delete a Contact\n");
        int choice = scan.nextInt();
        switch (choice) {
            case 0:
                System.exit(0);
            case 1:
                addContact();
                break;
            case 2:
                editContact();
                break;
            case 3:
                deleteContact();
                break;
            default:
                System.out.println("Please enter the Number associated with the choice");
                choiceSelect();
                break;
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        AddressBookMain obj = new AddressBookMain();
        obj.choiceSelect();
    }
}
