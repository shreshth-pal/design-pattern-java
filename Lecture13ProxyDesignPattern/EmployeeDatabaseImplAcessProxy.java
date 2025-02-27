package Lecture13ProxyDesignPattern;

public class EmployeeDatabaseImplAcessProxy implements EmployeeDatabaseInterface {
    EmployeeDatabaseInterfaceImpl employeeDatabaseInterfaceImpl;



    

    public EmployeeDatabaseImplAcessProxy(EmployeeDatabaseInterfaceImpl employeeDatabaseInterfaceImpl
          ) {
        this.employeeDatabaseInterfaceImpl = employeeDatabaseInterfaceImpl;
        
    }

    @Override
    public void createEmployee(String user,Employee emp) throws Exception{
       if(user.contentEquals("ADMIN")){
            employeeDatabaseInterfaceImpl.createEmployee(user, emp);
       }
       else{
            throw new Exception("You are not authorized");
       }
    }

    @Override
    public void deleteEmployee(String user,String empId) throws Exception {
        if(user.contentEquals("ADMIN")){
            employeeDatabaseInterfaceImpl.deleteEmployee(user, empId);
          }
       else{
            throw new Exception("You are not authorized");
       }
    }

    @Override
    public Employee getEmployee(String user,String empId) throws Exception {
     if(user.contentEquals("ADMIN") || user.contentEquals("USER")){
      return employeeDatabaseInterfaceImpl.getEmployee(user, empId);
    }
          throw new Exception("You are not authorized");
     }

}
