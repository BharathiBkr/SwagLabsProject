package swag_testcase;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import swag_common_functions.Common_Functions;
import swag_page_objects.Login_Page_objects;

public class Login_page_Test_Case extends Common_Functions {
	

	public String[][] values=null;
	
	public String[][] getexceldata() throws BiffException, IOException {
		FileInputStream inputStream=new FileInputStream("C:\\Users\\User\\Desktop\\LoginData.xls");
		Workbook workbook=Workbook.getWorkbook(inputStream);
		Sheet sheet=workbook.getSheet(2);
		int noOfRows= sheet.getRows();
		int noOfColumns=sheet.getColumns();
		String[][] testdata=new String[noOfRows-1][noOfColumns];
		
		for (int i = 1; i < noOfRows; i++) {
			for (int j = 0; j <noOfColumns; j++) {
				testdata[i-1][j]=sheet.getCell(j, i).getContents();	
			}	
		}
		return testdata;
	}
	@DataProvider(name="excelvalue")
	public String[][] testcasedata() throws BiffException, IOException {
		values=getexceldata();
		return values;
	}
	@Test(dataProvider = "excelvalue")
	public void login_Test_case(String username,String password) throws AWTException, IOException {
		PageFactory.initElements(driver, Login_Page_objects.class);
		Login_Page_objects.username.sendKeys(username);
		Login_Page_objects.password.sendKeys(password);
		Login_Page_objects.loginbutton.click();
		screenshot();
		if (driver.getCurrentUrl().equalsIgnoreCase("https://www.saucedemo.com/inventory.html")) {
			driver.navigate().back();	
		}
		else {
			driver.navigate().refresh();
		}
		
	}
	

}
