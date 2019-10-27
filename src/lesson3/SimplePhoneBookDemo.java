package lesson3;

public class SimplePhoneBookDemo {
    public static void main(String[] args) {
        SimplePhoneBook phoneBook = new SimplePhoneBook();

        phoneBook.add("Igor", 89262749495l);
        phoneBook.add("Igor", 1234567898l);
        phoneBook.add("Ksenia", 4567891231l);
        phoneBook.add("Dream", 784684384384l);

        phoneBook.get("Igor");
        phoneBook.get("Space");
        phoneBook.get("Ksenia");
    }
}