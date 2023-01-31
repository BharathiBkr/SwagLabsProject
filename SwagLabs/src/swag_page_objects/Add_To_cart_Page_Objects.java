package swag_page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Add_To_cart_Page_Objects {
	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	public static WebElement additem;
	@FindBy(id = "shopping_cart_container")
	public static WebElement cartbox;
	@FindBy(xpath = "//a[@class='shopping_cart_link']/child::span")
	public static WebElement aftercart;
}
