package com.test;

import java.util.Objects;

public class Employee {

  private Integer employeeId;


  public Integer getEmployeeId() {
    return employeeId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Employee employee = (Employee) o;
    return Objects.equals(employeeId, employee.employeeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(employeeId);
  }

  public void setEmployeeId(Integer employeeId) {
    this.employeeId = employeeId;
  }
}
