public class EmployeeDatabase {
    Entry [] entries;
    Type type;
    Employee doesNotExists = new Employee("This Employee Does Not Exist");
    enum Type{
        LINEAR, QUADRATIC
    }
    EmployeeDatabase(int numEntries, Type type){
        entries = new Entry[numEntries];
        this.type = type;
    }

    private class Entry{
        int ID;
        Employee employee;
        Entry(int ID, Employee employee){
            this.ID = ID;
            this.employee = employee;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "ID=" + ID +
                    ", employee=" + employee +
                    '}';
        }
    }

    private int hashCode(int key){
        int code = key% entries.length;
        //Linear(Worse)
        //Quadratic(Better)
        return type==Type.LINEAR?validateLinear(code,key):validateQuadratic(code, key);
    }

    Employee get(int key){
        try {
            return entries[hashCode(key)].employee;
        }catch (Exception e){
            return doesNotExists;
        }
    }

    boolean put(int key, Employee value){
        try {
            entries[hashCode(key)] = new Entry(key, value);
            return  true;
        }catch (Exception e){
            return false;
        }
    }

    private int validateLinear(int code, int key){
        int count = 0;
        while(entries[code]!=null&&entries[code].ID!=key){
            if(count==entries.length){
                return -1;
            }
            count++;
            code++;
            if(code==entries.length){
                code = 0;
            }
        }
        return code;
    }
    private int validateQuadratic(int code, int key){
        int count = 0;
        while(entries[code]==null||entries[code].ID!=key){
            if(count==entries.length){
                return -1;
            }
            count++;
            code+=4;
            if(code==entries.length){
                code = 0;
            }
        }
        return code;
    }

}
class Employee{
    private String name;
    Employee(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
