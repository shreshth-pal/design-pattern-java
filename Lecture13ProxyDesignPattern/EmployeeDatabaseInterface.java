package Lecture13ProxyDesignPattern;

public interface EmployeeDatabaseInterface {
    void createEmployee(String user,Employee emp) throws Exception;
    void deleteEmployee(String user,String empId) throws Exception;
    Employee getEmployee(String user,String empID) throws Exception;
}
