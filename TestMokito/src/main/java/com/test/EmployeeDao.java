package com.test;

public class EmployeeDao {


  public  Employee getEmployeeById(Integer employeeId) throws IllegalAccessException {
    if(employeeId==null || employeeId==0)
    throw new IllegalAccessException();

    return new Employee();
  }

  public  void getEmployee(Integer employeeId) throws IllegalAccessException {

    System.out.println("Employee id : "+employeeId +" in void method !!");

    Employee emp  = new Employee();

  }


}
