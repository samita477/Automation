package AutomationPractice;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Day1 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
		driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")).isDisplayed();
		driver.findElement(By.xpath("//input[@id='Email']")).clear();
		driver.findElement(By.xpath("//input[@id='Password']")).clear();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("demonopcommerce@gmail.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("demo123");
		driver.findElement(By.xpath("//button[contains(@class,'login-button')]")).click();
		
		String title=driver.getTitle();
		if(title.equals("nopCommerce demo store"))
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
		
		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("books");
		/*
		List<WebElement> options=driver.findElements(By.xpath("//a[contains(@id,'ui-id')]//span"));
		System.out.println(options.size());
		for(int i=0;i<options.size();i++)
			System.out.println(options.get(i).getText());
		*/
		
		driver.findElement(By.xpath("//button[contains(@class,'search-box-button')]")).click();
		
		List<WebElement> options=driver.findElements(By.xpath("//div[@class='item-box']"));
		System.out.println(options.size());
		String selected_value=driver.findElement(By.xpath("//select[@id='products-pagesize']//option[@value='6']")).getText();
		if(selected_value.equals("6"))
		{
			driver.findElement(By.xpath("//a[contains(text(),\"Next\")]")).isDisplayed();
			System.out.println(driver.findElements(By.xpath("//div[@class='product-item']")).size());
		}
		
	}

}
