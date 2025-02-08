public class TestPayroll {
    public static void main(String[] args) {
        Payroll pay = new Payroll();
        pay.print();
        System.out.println("size: " + pay.size());

        Employee e1 = new Employee();
        e1.name = "laura"; e1.ID = 124353; e1.salary = 200000.44;
        pay.add_employee(e1);
        pay.print();
        System.out.println("size: " + pay.size());

        Employee e2 = new Employee();
        e2.name = "michael"; e2.ID = 124322; e2.salary = 20.44;
        pay.add_employee(e2);
        pay.print();
        System.out.println("size: " + pay.size());

        try {
            System.out.println("Laura found at index: " + pay.find_employee("laura"));
            System.out.println("Michael found at index: " + pay.find_employee("michael"));
            System.out.println("May found at index: " + pay.find_employee("may"));
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            pay.remove_employee(0);
            pay.remove_employee(1026);
        } catch (EmployeeIndexException e) {
            System.out.println(e.getMessage());
        }

        pay.print();
        System.out.println("Size: " + pay.size());

        Payroll pay2 = new Payroll();

        Employee e3 = new Employee();
        e3.name = "eleanor"; e3.ID = 124300; e3.salary = 32239.44;
        pay2.add_employee(e3);
        pay2.print();
        System.out.println("size: " + pay2.size());

        pay2.add_employee(e2);
        pay2.print();
        System.out.println("size: " + pay2.size());

        System.out.println("Added Payroll");
        pay.add_payroll(pay2);
        pay.print();
        System.out.println("size: " + pay.size());

        System.out.println("Copied Payroll");
        pay.copy_payroll(pay2);
        pay.print();
        System.out.println("size: " + pay.size());

        for (int i = 0; i < 1027; i++) {
            pay.add_employee(e3);
        }
        System.out.println("size: " + pay.size());

        try {
            pay.remove_employee(1027);
        } catch (EmployeeIndexException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("size: " + pay.size());

        pay.add_payroll(pay2);
        System.out.println("size: " + pay.size());

        pay2.copy_payroll(pay);
        System.out.println("size: " + pay2.size());
    }
}
