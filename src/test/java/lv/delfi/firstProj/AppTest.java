package lv.delfi.firstProj;

import java.net.MalformedURLException;
import org.testng.annotations.Test;

public class AppTest {
	
	public static MainPart obj = new MainPart();
	
	@Test
	public static void Test() throws MalformedURLException, InterruptedException {		
			driver.driverChoose();
			obj.openTasty();
			obj.findRec();
			obj.findIng();
			obj.Search();
			driver.exit();
	}
	
}