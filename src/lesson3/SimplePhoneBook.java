package lesson3;

import java.util.HashMap;
import java.util.HashSet;

class SimplePhoneBook {

    private HashMap<String, HashSet<Long>> phoneBook = new HashMap<String, HashSet<Long>>();

    void add (String name, long phoneNumber){

        if(phoneBook.get(name) == null) {
            phoneBook.put(name, new HashSet<>());
        }

        HashSet<Long> numbers = phoneBook.get(name);
        numbers.add(phoneNumber);
    }

    void get (String name){
        if(phoneBook.get(name) == null)
            System.err.println("There isn't '" + name +"' in the phone book!");
        else
            System.out.println("Name: " + name + ". Numbers: " + phoneBook.get(name));
    }
}
