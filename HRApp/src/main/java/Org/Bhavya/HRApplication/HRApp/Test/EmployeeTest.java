package Org.Bhavya.HRApplication.HRApp.Test;

import static org.junit.Assert.assertThat;

import java.util.Map;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import Org.Bhavya.HRApplication.HRApp.Database.EmployeeDatabase;
import Org.Bhavya.HRApplication.HRApp.Exception.EmployeeNotFoundException;
import Org.Bhavya.HRApplication.HRApp.Model.Address;
import Org.Bhavya.HRApplication.HRApp.Model.Contact;
import Org.Bhavya.HRApplication.HRApp.Model.Employee;
import Org.Bhavya.HRApplication.HRApp.Service.EmployeeService;


public class EmployeeTest {
	 

	EmployeeService eService = new EmployeeService();
	
	@Test
	public void testGetEmployeeSuccessful() throws Exception 
	{
		Employee emp = eService.getEmployee("105");
		System.out.println("emp" + emp);
		Contact c5 = new Contact("0800099995", "9100099995", "OPK@gmail.com");
		Address a5 = new Address("House5", "Street5", "AB115AO", "Mumbai", "Maharastra");
	    Employee empy = new Employee("Emp5", "105", "CICS", c5, a5);
	    System.out.println("empy" + empy);

	    //Assert.assertTrue(emp.equals(empy));
	    //Assert.assertEquals(emp, empy);
	    Assert.assertEquals(emp.getDUnit(), empy.getDUnit());
	    Assert.assertEquals(emp.getEmpId(), empy.getEmpId());
	    Assert.assertEquals(emp.getEmpName(), empy.getEmpName());
	    Assert.assertEquals(emp.getAddrDetails().getAddrLine1(), empy.getAddrDetails().getAddrLine1());
	    Assert.assertEquals(emp.getAddrDetails().getAddrLine2(), empy.getAddrDetails().getAddrLine2());
	    Assert.assertEquals(emp.getAddrDetails().getCity(), empy.getAddrDetails().getCity());
	    Assert.assertEquals(emp.getAddrDetails().getPincode(), empy.getAddrDetails().getPincode());
	    Assert.assertEquals(emp.getAddrDetails().getState(), empy.getAddrDetails().getState());
	    
	    Assert.assertEquals(emp.getContactDetails().getEmail(), empy.getContactDetails().getEmail());
	    Assert.assertEquals(emp.getContactDetails().getHomeTeleNo(), empy.getContactDetails().getHomeTeleNo());
	    Assert.assertEquals(emp.getContactDetails().getMobileNo(), empy.getContactDetails().getMobileNo());
	   	}

	
}
	
