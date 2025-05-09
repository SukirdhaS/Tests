package JavaSelenium;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MyFirstwebsiteExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Suki/Desktop/Firstproject.html");
		driver.manage().window().maximize();
		WebElement dropdown_cars = driver.findElement(By.id("cars"));
		//Thread.sleep(3000);
		Select choose_option = new Select(dropdown_cars);
		choose_option.selectByValue("opel");
		
		List<WebElement> ListOfCars = choose_option.getOptions();
		int Size = ListOfCars.size();
		System.out.println("Number Of Values = "+Size);
		
		WebElement Alertexample = driver.findElement(By.xpath("/html/body/button"));
		Alertexample.click();
		Alert alertaccept = driver.switchTo().alert();
		alertaccept.accept();
	}

	private static void sendKeys(String string) {
		// TODO Auto-generated method stub
		
	}

}
