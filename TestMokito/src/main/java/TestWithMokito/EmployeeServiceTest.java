package TestWithMokito;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.test.Employee;
import com.test.EmployeeDao;
import com.test.EmployeeService;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.stubbing.Answer;

/**
 * In Case of for a particular when() condition if we have both callRealMethod() as well as mockMethod then the real method call will be
 * done. We we mokito Answer to provide behaviour to a particular mock method.And we need to use doXXX() for any void method to provide the
 * behaviour.
 *
 *
 */
public class EmployeeServiceTest {

  private Integer employesId = 1234;

  private EmployeeService employeeService;

  @Before
  public void setUp() throws IllegalAccessException {

     EmployeeDao employeeDao = mock(EmployeeDao.class);
     when(employeeDao.getEmployeeById(employesId)).thenReturn(new Employee());
     when(employeeDao.getEmployeeById(0)).thenThrow(IllegalAccessException.class);
     Answer<Employee> empAns = invocationMock ->{
       Optional<Object[]> arguments = Optional.of(invocationMock.getArguments());
       Employee emp = null;
       if(arguments.isPresent() && arguments.get().length!=0){

           emp= new Employee();
           emp.setEmployeeId((Integer)arguments.get()[0]);

       }
        return emp;
     };

    when(employeeDao.getEmployeeById(employesId)).then(empAns);
     employeeService = new EmployeeService(employeeDao);
    // Void Method mocking.In Mokito Answer is  used to pass the behaviour to any method mocking.Here since the getEmployee()
    //returns void and i want to induce the behaviour (i.e to mock the behaviour of void method)to the particular method and hence had to follow this following approach.

    doAnswer(invocationOnMock -> {
       Employee emp = new Employee();
       emp.setEmployeeId((Integer)invocationOnMock.getArguments()[0]);
       System.out.println("Within do Answer!!");
       return null;
    }).when(employeeDao).getEmployee(employesId);

//    doCallRealMethod().when(employeeDao).getEmployee(employesId);

  }

  @Test
  public void testEmployeeService() throws IllegalAccessException {
    Integer empId = 0;
    Assert.assertFalse(employeeService.getEmployee(empId));
    empId = null;
    Assert.assertFalse(employeeService.getEmployee(empId));
    Assert.assertTrue(employeeService.getEmployee(employesId));


  }

  @Test(expected = IllegalAccessException.class)
  public void testEmployeeServiceLong() throws IllegalAccessException{

    Long empid =0L;
    employeeService.getEmployee(empid);

  }



  @Test
  public void testEmployeeServiceLong2() throws IllegalAccessException{

    Long empid =1234L;
  //  Employee emp = ;

    Employee empExp = new Employee();
    empExp.setEmployeeId(empid.intValue());
    //This needs to have the equals and hashCode overriden int the model Employee.
    Assert.assertEquals(empExp,employeeService.getEmployee(empid));

  }

  @Test(expected = IllegalAccessException.class)
  public void testEmployeeServiceLongExcep() throws IllegalAccessException{

    Long empid =0L;
    //  Employee emp = ;

    Employee empExp = new Employee();
    empExp.setEmployeeId(empid.intValue());
    //This needs to have the equals and hashCode overriden int the model Employee.
    Assert.assertEquals(empExp,employeeService.getEmployee(empid));

  }

  @Test
  public void testVerifyCalls()(){

    verify()

  }





}
