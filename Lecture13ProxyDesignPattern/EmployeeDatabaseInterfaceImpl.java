package Lecture13ProxyDesignPattern;

public class EmployeeDatabaseInterfaceImpl implements  EmployeeDatabaseInterface {
    

    @Override
    public void deleteEmployee() {
        System.out.println("Implement Feature Delete");
    }

    @Override
    public void getEmployee() {
        System.out.println("Implement Feature get");
    }

    @Override
    public void createEmployee() {
        System.out.println("Implement Feature create");
    }

}
