package swag_testcase;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import swag_common_functions.Common_Functions;
import swag_page_objects.Login_Page_objects;

public class Login_test_cases extends Common_Functions {
	
	@Test
	public void login() throws IOException, AWTException {
		getproperty();
		String username=property.getProperty("username");
		String password=property.getProperty("password");
		
		PageFactory.initElements(driver,Login_Page_objects.class);
		Login_Page_objects.username.sendKeys(username);
		Login_Page_objects.password.sendKeys(password);
		Login_Page_objects.loginbutton.click();
		
		screenshot();
	}

}
