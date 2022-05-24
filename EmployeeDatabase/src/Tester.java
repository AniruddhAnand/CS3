public class Tester {
    public static void main(String[] args) {
        EmployeeDatabase db = new EmployeeDatabase(100, EmployeeDatabase.Type.LINEAR);
        db.put(10000,new Employee("Jane"));
        System.out.println(db.get(10000));
        System.out.println(db.get(1));
    }
}
