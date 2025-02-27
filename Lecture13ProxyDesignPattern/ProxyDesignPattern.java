package Lecture13ProxyDesignPattern;

public class ProxyDesignPattern {

    public static void main(String[] args) {
        try {
            EmployeeDatabaseImplAcessProxy ed=new EmployeeDatabaseImplAcessProxy(new EmployeeDatabaseInterfaceImpl());
            ed.createEmployee("ADMIN", new Employee("Shreshth", 3));
            ed.deleteEmployee("ADMIN", "3");
            ed.getEmployee("USER", "3");
            ed.deleteEmployee("USER", "1");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
