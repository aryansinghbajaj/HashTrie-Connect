import java.util.*;

// Node class represents a single node in the Trie.
class Node {
    HashMap<Character, Node> reference; // Map that represents the character and the reference node.
    boolean flag; // Boolean variable indicating the end of the word.
    
    public Node() {
        reference = new HashMap<Character, Node>(); // Initialize the reference map.
        for (char c = 'a'; c <= 'z'; c++) {
            reference.put(c, null); // Initialize all the references to null on object creation.
        }
        flag = false; // Initialize the flag variable to false because the node might not mark the end of the word.
    }
}

// TelephoneDirectory class using Trie for contact names.
class TelephoneDirectory {
    HashMap<String, Integer> contact; // Map to store the name and their respective contact numbers.
    Trie trie; // Trie structure to manage the contact names.
    
    public TelephoneDirectory() {
        contact = new HashMap<String, Integer>(); // Initialize the contact map with type parameters.
        trie = new Trie(); // Initialize the trie.
    }
    
    public void addContact(String name, Integer number) {
        contact.put(name.toLowerCase(), number); // Insert the contact and its number into the directory, converting name to lowercase.
        trie.insert(name.toLowerCase()); // Insert the contact name into the trie, converting name to lowercase.
    }
    
    public void searchAndShowNumbers(String entry) {
        trie.searchContacts(entry.toLowerCase(), contact); // Search for contacts starting with the given prefix, converting entry to lowercase.
    }
}

// Trie class represents the Trie structure.
class Trie {
    Node root; // Root node of the trie.
    
    public Trie() {
        root = new Node(); // Initialize the root node.
    }
    
    public void insert(String contactName) {
        Node node = root;
        for (int i = 0; i < contactName.length(); i++) {
            char currentChar = contactName.charAt(i);
            Node nextNode = node.reference.get(currentChar); // Get the reference node corresponding to the character.
            if (nextNode == null) {
                nextNode = new Node(); // If the reference doesn't exist, create a new node.
                node.reference.put(currentChar, nextNode);
            }
            node = nextNode; // Move to the next node.
            if (i == contactName.length() - 1) {
                node.flag = true; // Mark the end of the contact name.
            }
        }
    }
    
    public void displayRelatedContacts(Node current, String prefix, ArrayList<String> relatedContacts) {
        if (current.flag) {
            relatedContacts.add(prefix); // If the current node represents the end of the contact name, add it to the list.
        }
        for (char c = 'a'; c <= 'z'; c++) { // Check all possible reference nodes.
            Node nextNode = current.reference.get(c);
            if (nextNode != null) {
                displayRelatedContacts(nextNode, prefix + c, relatedContacts); // Recursively process the child node.
            }
        }
    }
    
    // Function to search for the contacts with the given prefix and display their phone numbers.
    public void searchContacts(String entry, HashMap<String, Integer> contact) {
        Node current = root;
        String prefix = "";
        for (int i = 0; i < entry.length(); i++) {
            prefix += entry.charAt(i); // Build the prefix incrementally.
            char currentChar = prefix.charAt(i);
            current = current.reference.get(currentChar); // Move to the reference corresponding to the current character.
            if (current == null) {
                System.out.println("No contacts were found with the given prefix");
                return;
            }
        }
        
        // If we reach here, current contains the node corresponding to the last character of the prefix
        ArrayList<String> relatedContacts = new ArrayList<>();
        displayRelatedContacts(current, prefix, relatedContacts); // Find all contacts related to the current prefix.
        
        for (String contactName : relatedContacts) {
            System.out.println("Contact Name: " + contactName + " - Phone Number: " + contact.get(contactName));
        }
    }
}

// Driver class to test the telephone directory.
public class HashTrie {
    public static void main(String[] args) {
        TelephoneDirectory directory = new TelephoneDirectory();
        directory.addContact("aryan", 456812654);
        directory.addContact("arya", 874621059);
        directory.addContact("arham", 630189735);
        directory.addContact("arushi", 861203297);
        directory.addContact("arnav", 705623480);
        String searchEntry = "ary";
        directory.searchAndShowNumbers(searchEntry);
    }
}
