import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Contact class
class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Contact{name='" + name + "', phoneNumber='" + phoneNumber + "', email='" + email + "'}";
    }

    // Override equals and hashCode for proper functioning in HashSet
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return phoneNumber.equals(contact.phoneNumber);
    }

    @Override
    public int hashCode() {
        return phoneNumber.hashCode();
    }
}

// ContactManager class
public class ContactManagerApp {
    private Set<Contact> contactsSet;
    private Map<String, Contact> contactsMap;

    public ContactManagerApp() {
        contactsSet = new HashSet<>();
        contactsMap = new HashMap<>();
    }

    // Add a new contact
    public void addContact(Contact contact) {
        if (contactsMap.containsKey(contact.getPhoneNumber())) {
            System.out.println("Contact with this phone number already exists.");
        } else {
            contactsSet.add(contact);
            contactsMap.put(contact.getPhoneNumber(), contact);
            System.out.println("Contact added: " + contact);
        }
    }

    // Remove a contact by phone number
    public void removeContact(String phoneNumber) {
        Contact contact = contactsMap.remove(phoneNumber);
        if (contact != null) {
            contactsSet.remove(contact);
            System.out.println("Contact removed: " + contact);
        } else {
            System.out.println("Contact not found.");
        }
    }

    // Find a contact by phone number
    public Contact findContactByPhoneNumber(String phoneNumber) {
        return contactsMap.get(phoneNumber);
    }

    // Display all contacts
    public void displayAllContacts() {
        System.out.println("All Contacts:");
        for (Contact contact : contactsSet) {
            System.out.println(contact);
        }
    }

    public static void main(String[] args) {
        ContactManagerApp contactManager = new ContactManagerApp();

        // Adding contacts
        contactManager.addContact(new Contact("Alice", "1234567890", "alice@example.com"));
        contactManager.addContact(new Contact("Bob", "0987654321", "bob@example.com"));
        contactManager.addContact(new Contact("Charlie", "1112223333", "charlie@example.com"));

        // Displaying all contacts
        contactManager.displayAllContacts();

        // Finding a contact
        System.out.println("Finding contact with phone number 1234567890:");
        System.out.println(contactManager.findContactByPhoneNumber("1234567890"));

        // Removing a contact
        contactManager.removeContact("0987654321");

        // Displaying all contacts again
        contactManager.displayAllContacts();
    }
}
