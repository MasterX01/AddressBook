import java.util.*;
public class AddressBookMain {
    ArrayList<ArrayList<String>> contact = new ArrayList<ArrayList<String>>();
    Scanner scan = new Scanner(System.in);
    public void addContact() {
        ArrayList<String> addNew = new ArrayList<String>();
        System.out.println("Please enter the First Name: ");
        addNew.add(scan.nextLine());
        System.out.println("Please enter the Last Name: ");
        addNew.add(scan.nextLine());
        System.out.println("Please enter your address: ");
        addNew.add(scan.nextLine());
        System.out.println("Please enter the City of your address: ");
        addNew.add(scan.nextLine());
        System.out.println("Please enter the State of your address: ");
        addNew.add(scan.nextLine());
        System.out.println("Please enter the ZIP of your address: ");
        addNew.add(scan.nextLine());
        System.out.println("Please enter your Phone Number: ");
        addNew.add(scan.nextLine());
        System.out.println("Please enter your email address: ");
        addNew.add(scan.nextLine());

        //Adding contact to main list
        contact.add(addNew);
        
        System.out.println("The contact has been added to the Address Book");
        for(int i = 0; i < contact.size(); i++)
            for(int j = 0; j < contact.get(i).size(); j++)
                System.out.print(contact.get(i).get(j) + " ");

        }

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        AddressBookMain obj = new AddressBookMain();
        obj.addContact();
    }
}
