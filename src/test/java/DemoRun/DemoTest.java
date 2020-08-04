package DemoRun;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Ty.crm.basic.DataBaseLib;
import com.Ty.crm.basic.ExcellLib;
import com.Ty.crm.basic.PropertyFileLib;

public class DemoTest {
	
	@Test(priority = 0, invocationCount = 0)
	public void DemoGetProperty() throws IOException {
		PropertyFileLib lib = new PropertyFileLib();
		System.out.println(lib.getPropertyFileData("browser"));
		System.out.println(lib.getPropertyFileData("url"));
		System.out.println(lib.getPropertyFileData("username"));
		System.out.println(lib.getPropertyFileData("password"));
	}
	
	@Test(priority = 1,invocationCount = 0)
	public void DemoDataBaseconnection() throws Throwable {
		DataBaseLib dblib = new DataBaseLib();
		dblib.conectToDatabase();
		dblib.executeSelectQuery("select * from seleniumuser");
		dblib.executeNonSelectQuery("insert into seleniumuser values('rama','rama@gmail.com')");
		dblib.executeNonSelectQuery("Delete from seleniumuser where firstname='rama'");
		dblib.executeSelectQuery("select * from seleniumuser");
		dblib.closeDBConnection();
		
	}
	
	@Test
	public void DemoExcellreadTest() throws Throwable {
		ExcellLib exlib = new ExcellLib();
		for (int i = 1; i <= 10; i++) {
//			for (int j = 1; j < 5; j++) {
//		String emp_id = exlib.readExcell("C:\\Users\\admin\\Desktop\\TY Training\\SampleWorkBook.xlsx","Emp_Info",i,j);
//		}
			 String emp_id = exlib.readData( "Emp_Info", i, 0);
			 String name = exlib.readData("Emp_Info", i, 1);
			 String email = exlib.readData("Emp_Info", i, 2);
			 String job_title = exlib.readData("Emp_Info", i, 3);
			 String salary = exlib.readData("Emp_Info", i, 4);
			 
			System.out.println();
		}
		
	}

}
