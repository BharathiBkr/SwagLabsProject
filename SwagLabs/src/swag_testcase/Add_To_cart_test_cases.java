package swag_testcase;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import swag_common_functions.Common_Functions;
import swag_page_objects.Add_To_cart_Page_Objects;

public class Add_To_cart_test_cases extends Common_Functions {
	@Test
	public void addcart() throws IOException {
		getproperty();
		PageFactory.initElements(driver, Add_To_cart_Page_Objects.class);
		String beforeadding=Add_To_cart_Page_Objects.cartbox.getText();
		System.out.println(beforeadding);
		Add_To_cart_Page_Objects.additem.click();
		String afteradding=Add_To_cart_Page_Objects.aftercart.getText();
		System.out.println(afteradding);
	}
	
}
