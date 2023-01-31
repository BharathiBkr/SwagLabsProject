package swag_page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page_objects {
	
	@FindBy(id = "user-name")
	public static WebElement username;
	@FindBy(id = "password")
	public static WebElement password;
	@FindBy(id="login-button")
	public static WebElement loginbutton;

}
