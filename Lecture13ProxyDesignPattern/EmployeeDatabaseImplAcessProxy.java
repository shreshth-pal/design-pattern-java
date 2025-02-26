package Lecture13ProxyDesignPattern;

public class EmployeeDatabaseImplAcessProxy implements EmployeeDatabaseInterface {
    EmployeeDatabaseInterfaceImpl employeeDatabaseInterfaceImpl;
    String accessLevel;    


    

    public EmployeeDatabaseImplAcessProxy(EmployeeDatabaseInterfaceImpl employeeDatabaseInterfaceImpl,
            String accessLevel) {
        this.employeeDatabaseInterfaceImpl = employeeDatabaseInterfaceImpl;
        this.accessLevel = accessLevel;
    }

    @Override
    public void createEmployee() throws Exception{
       if(accessLevel=="ADMIN"){
            employeeDatabaseInterfaceImpl.createEmployee();
       }
       else{
            throw new Exception("You are not authorized");
       }
    }

    @Override
    public void deleteEmployee() throws Exception {
        if(accessLevel=="ADMIN"){
            employeeDatabaseInterfaceImpl.createEmployee();
       }
       else{
            throw new Exception("You are not authorized");
       }
    }

    @Override
    public void getEmployee() {
       
    }

}
