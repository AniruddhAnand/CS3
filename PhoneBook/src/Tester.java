public class Tester {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.put(new Person("Jacob"),new PhoneNumber("12345"));
        System.out.println(phoneBook.get(new Person("Jacob")));
        phoneBook.put(new Person("Jackson"),new PhoneNumber("56"));
        System.out.println(phoneBook.get(new Person("Jackson")));;
        phoneBook.put(new Person("James"),new PhoneNumber("2874"));
        System.out.println(phoneBook.put(new Person("Jacob"),new PhoneNumber("1234")));
        System.out.println(phoneBook.get(new Person("Jacob")));
        phoneBook.put(new Person("aJmes"),new PhoneNumber("13426"));
        System.out.println(phoneBook.get(new Person("aJmes")));
    }
}
