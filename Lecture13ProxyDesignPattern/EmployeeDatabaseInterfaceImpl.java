package Lecture13ProxyDesignPattern;

public class EmployeeDatabaseInterfaceImpl implements  EmployeeDatabaseInterface {
    

    @Override
    public void deleteEmployee(String user,String empId) {
        System.out.println("Employee with id "+empId+" is deleted");
    }

    @Override
    public Employee getEmployee(String user,String empId) {
        System.out.println("Implement Feature get");
        return new Employee("",1);
    }

    @Override
    public void createEmployee(String user,Employee emp) {
        System.out.println("A new employee has been created");
    }

}
