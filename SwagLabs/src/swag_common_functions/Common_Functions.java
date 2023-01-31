package swag_common_functions;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Common_Functions {
	public static Properties property;
	public static WebDriver driver;
	public Properties getproperty() throws IOException {
		FileInputStream filesteam=new FileInputStream("config.properties");
		property=new Properties();
		property.load(filesteam);
		return property;	
	}
	@BeforeSuite
	public void launchbrowser() throws IOException {
		getproperty();
		String driverloaction=property.getProperty("driverlocation");
		String drivername=property.getProperty("driver");
		String url=property.getProperty("url");
		if (drivername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",driverloaction);
			driver=new ChromeDriver();
		}
		else if (drivername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",driverloaction);
			driver=new FirefoxDriver();
			}
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@AfterSuite
	public void teardown() {
		//driver.quit();
		
	}
	public void screenshot() throws AWTException, IOException {
		Robot robot=new Robot();
		Dimension screensize= Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle=new Rectangle(screensize);
		BufferedImage sourcefile=  robot.createScreenCapture(rectangle);
		File destinationfile=new File("D:\\Photos\\Screenshots\\photo.png");
		ImageIO.write(sourcefile, "png", destinationfile);
	}
	
	
	

}
