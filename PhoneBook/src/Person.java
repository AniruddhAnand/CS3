import java.util.Objects;

public class Person {
    private String name;
    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        //Hash Code for the lab
//        int hash = 0;
//        for(int i=0;i<name.length();i++){
//            hash+=name.charAt(i)*(i+1);
//        }
//        return hash;

        //Hash Code for the unit tests
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}
