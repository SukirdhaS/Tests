package JavaSelenium;

import java.awt.Point;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class findelementbylink1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		
		WebElement InputLink = driver.findElement(By.linkText("Inputs"));
		InputLink.click();
		
		WebElement ProvideValue =  driver.findElement(By.xpath("//*[@id=\'content\']/div/div/div/input"));
		ProvideValue.sendKeys("SUKI");
		
		org.openqa.selenium.Point location = 	ProvideValue.getLocation();
		double xvalue = location.getX();
		double yvalue = location.getY();
		System.out.println("x value is:"+xvalue + "y value is:" +yvalue);
		int height = ProvideValue.getSize().getHeight();
		int width = ProvideValue.getSize().getWidth();
		
		System.out.println("HEIGHT:"+height);
		System.out.println("WIDTH:"+width);
		WebElement PoweredBy = driver.findElement(By.linkText("Elemental Selenium"));
		//PoweredBy.click();
	     String colorofPoweredBy = PoweredBy.getCssValue("color");
				
		System.out.println(colorofPoweredBy);
	}

}
