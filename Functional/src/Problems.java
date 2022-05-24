import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Problems {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<String> list = new ArrayList<>(Arrays.asList("hello", "and", "goodbye"));

        //1
        nums.forEach(System.out::println);
        list.forEach(System.out::println);

        //2
        nums.removeIf(n -> n % 2 == 0);

        //3
        System.out.println(nums.stream()
                .filter(n -> n % 2 != 0)
                .count());

        //4
        list.stream()
                .filter(n -> n.indexOf("a") == 0)
                .forEach(n -> System.out.println(n));

        //5
        nums = nums.stream()
                .map(n -> n *= 2)
                .collect(Collectors.toList());
        nums.forEach(n -> System.out.println(n));

        //6 ->Coding Bat

        //7
        List<Double> items = new ArrayList<Double>(Arrays.asList(new Double[]{1.0, 4.12, 5.67, 67.80}));
        items = items.stream()
                .map(n -> n *= 1.12)
                .collect(Collectors.toList());
        //8
        List<Integer> nums2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println(nums2.stream().reduce((n, m) -> n + m).get());

        //9
        List<Double> items2 = new ArrayList<Double>(Arrays.asList(1.0, 4.12, 5.67, 67.80));
        System.out.println(items2.stream()
                .map(n -> n *= 1.12)
                .reduce(Double::sum)
                .get());

        //10
        System.out.println(
        items2.stream().max((Double o1, Double o2) ->
                 o1.compareTo(o2)
        ).get());

        //1
        JButton button = new JButton("Click here");
        JFrame  frame  = new JFrame("Button test"); //window to contain the button

        //add your code here

        frame.setSize(200, 200); //set the size of the container window
        frame.add(button);       //add button to the window
        frame.setVisible(true);

        button.addActionListener(e -> System.out.println("Action Conducted"));

        //12
        List<Person> users = new ArrayList<>();
        users.add(new Person("Sarah",   40));
        users.add(new Person("Peter",   50));
        users.add(new Person("Lucy",    60));
        users.add(new Person("Albert",  20));
        users.add(new Person("Charlie", 30));

        System.out.println(
        users.stream().max((o1, o2) -> Integer
                .compare(o1.age,o2.age))
                .get());
    }
}
class Person {
    String name;
    int    age;

    Person(String name, int age) {
        this.name = name;
        this.age  = age;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.age;
    }

    int getAge() { return this.age; }
}
