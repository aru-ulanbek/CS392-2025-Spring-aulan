
public class Payroll {
    public static final int INITIAL_MAXIMUM_SIZE = 1024;

    public Payroll() {
	/* your code */
        this.maximum_size = INITIAL_MAXIMUM_SIZE;
        this.people = new Employee[maximum_size];
        this.current_size = 0;
    }
    
    public void add_employee(Employee newbie) {
	/* your code */        
        if (current_size >= maximum_size) {
            Employee arr[] = new Employee[maximum_size + 1];
            maximum_size += 1;
            for (int i = 0; i < arr.length - 1; i++) {
                arr[i] = people[i];
            }
            arr[maximum_size - 1] = newbie;
            people = arr;
        } else {
            for (int i = 0; i < maximum_size; i++) {
                if (people[i] == null) {
                    people[i] = newbie;
                    break;
                }
            }
        }
        current_size += 1;
    }

    public void remove_employee(int i) throws EmployeeIndexException {
	/* your code */
    
        if (i < 0 || i > maximum_size || people[i] == null) {
            throw new EmployeeIndexException("Employee Index Invalid: " + i);
        }

        Employee arr[] = new Employee[maximum_size];

        for (int j = 0, k = 0; j < maximum_size; j++) {
            if (j != i) {
                arr[k] = people[j];
                k++;
            }
        }
        people = arr;
        current_size -= 1;
    }
    
    public int find_employee(String name) throws EmployeeNotFoundException {
	/* your code */
        int person = -1;
        for (int i = 0; i < current_size; i++) {
            if (people[i].name == name) {
                person = i;
                break;
            }
        }

        if (person == -1) {
            throw new EmployeeNotFoundException("Employee Not Found: " + name);
        }

        return person;
    }

    public void add_payroll(Payroll source) {
	/* your code */
        for (int i = 0; i < source.current_size; i++) {
            if (source.people[i] != null) {
                add_employee(source.people[i]);
            }
        }
    }

    public void copy_payroll(Payroll source) {
	/* your code */
        this.current_size = source.current_size;
        this.maximum_size = source.maximum_size;
        this.people = new Employee[maximum_size];
        for (int i = 0; i < maximum_size; i++) {
            this.people[i] = source.people[i];
        }
    }

    public int size() {
        // for (int i = 0; i < maximum_size; i++) {
        //     if (people[i] != null) {
        //         current_size += 1;
        //     }
        // }
        return current_size;
    }

    public void print() {
        for (int i = 0; i < current_size; i++) {
            System.out.println("Employee: " + people[i].name + ", ID: " + people[i].ID + ", Salary: " + people[i].salary);
        }
    }

    private Employee people[];
    private int maximum_size;
    private int current_size;
    // ...
}
