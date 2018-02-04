package com.test;

public class EmployeeService {

  private EmployeeDao employeeDao;

  public EmployeeService(EmployeeDao employeeDao){
    this.employeeDao=employeeDao;
  }

  public boolean getEmployee(Integer employeeId) throws IllegalAccessException {

    if(employeeId==null || employeeId==0){

      return false;
    }
    Employee emp = employeeDao.getEmployeeById(employeeId);

    return emp!=null;
  }

  public Employee getEmployee(Long employeeId) throws IllegalAccessException {

    Employee emp = employeeDao.getEmployeeById(employeeId.intValue());

    employeeDao.getEmployee(employeeId.intValue());

    return emp;
  }


}
