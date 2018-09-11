package Org.Bhavya.HRApplication.HRApp.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import Org.Bhavya.HRApplication.HRApp.HRAppRESTServicesApplication;
import Org.Bhavya.HRApplication.HRApp.Model.Address;
import Org.Bhavya.HRApplication.HRApp.Model.Contact;
import Org.Bhavya.HRApplication.HRApp.Model.Employee;
import Org.Bhavya.HRApplication.HRApp.Service.EmployeeService;

/*import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HRAppRESTServicesApplication.class)
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class HRApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeService empService;
	
	Contact c5 = new Contact("0800099995", "9100099995", "OPK@gmail.com");
	Address a5 = new Address("House5", "Street5", "AB115AO", "Mumbai", "Maharastra");
	Employee e5 = new Employee("Emp5", "105", "CICS", c5, a5);
	String exampleCourseJson = "";
	
	@Test
	public void getIndividualEmployee() throws Exception {

		Mockito.when(
				empService.getEmployee(Mockito.anyString(),
						Mockito.anyString())).thenReturn(e5);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/employees/105").accept(
				MediaType.APPLICATION_JSON);
	
		
		
		
		
	}
}
