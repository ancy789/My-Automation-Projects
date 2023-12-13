package newpkg;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyntraTest {
	WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable--notifications");
		driver.get("https://www.ajio.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@Test
	public void testMyntra() throws InterruptedException
	{
		// Title verification of Ajio
		
		String window1Details=driver.getWindowHandle();  //parent window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		String Title=driver.getTitle();	
		System.out.println("Title is - "+Title);
		if(Title.equals("Online Shopping for Women, Men, Kids – Clothing, Footwear | AJIO"))
		{
			System.out.println("Title verified");	
		}
		else
		{
			System.out.println("Title is not verified");
		}
		
		//Enter shoe in the search field and select shoe for infants
		
		driver.findElement(By.xpath("//*[@id=\"appContainer\"]/div[1]/div/header/div[3]/div[2]/form/div/div/input")).sendKeys("shoe");
		driver.findElement(By.xpath("//*[@id=\"react-autowhatever-1\"]/ul/li[7]/a/span[2]")).click();
		
		//Click on five grid and select sort as "what's new"
		
		driver.findElement(By.xpath("//*[@id=\"products\"]/div[2]/div/div[2]/div/div[2]/div")).click();
		driver.findElement(By.xpath("//*[@id=\"products\"]/div[2]/div/div[3]/div/select")).click();
		driver.findElement(By.xpath("//*[@id=\"products\"]/div[2]/div/div[3]/div/select/option[4]")).click();
		System.out.println("Grid selection and sorting completed");
		
		//Enter price range minimum 2000 and maximum 5000
		
		driver.findElement(By.xpath("//*[@id=\"facets\"]/div[2]/ul/li[3]/div/div/div/span[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"minPrice\"]")).sendKeys("1000");
		driver.findElement(By.xpath("//*[@id=\"maxPrice\"]")).sendKeys("5000");
		driver.findElement(By.xpath("//*[@id=\"facets\"]/div[2]/ul/li[3]/div/div/div[2]/form/div/div/div[2]/button")).click();
		
		//Select any one of the product and select size
		
		
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[1]/div/div[1]/a/div/div[1]/div[1]/img")).click();
		
		Set<String> childwindows=driver.getWindowHandles(); //child window
		  for(String values:childwindows)
		  {
			  if(!values.equalsIgnoreCase(window1Details))
			  {
				   driver.switchTo().window(values);
				  
				   driver.findElement(By.xpath("//*[@id=\"appContainer\"]/div[2]/div/div/div[2]/div/div[3]/div/div[6]/div[2]/div/div/div[2]/div/span")).click();
				   driver.findElement(By.xpath("//*[@id=\"edd\"]/div[1]/div/span[2]")).click();
				  
				   //Enter pincode to check delivery
				  
				   driver.findElement(By.xpath("//*[@id=\"edd-pincode\"]/div/div/div[2]/form/div/input")).sendKeys("680724");
				   driver.findElement(By.xpath("//*[@id=\"edd-pincode\"]/div/div/div[2]/form/div/button")).click();
				  
				  //print product's country of origin, customer care address
				  
				    JavascriptExecutor js = (JavascriptExecutor) driver;
				    js.executeScript("window.scrollBy(0,650)", "");
		                    Thread.sleep(2000);
				    driver.findElement(By.xpath("//*[@id=\"appContainer\"]/div[2]/div/div/div[2]/div/div[3]/div/section/h2[2]/ul/li[13]/div")).click();
				    String origin= driver.findElement(By.xpath("//*[@id=\"appContainer\"]/div[2]/div/div/div[2]/div/div[3]/div/section/h2[2]/ul/li[17]/div/div[1] ")).getText();
				    String country= driver.findElement(By.xpath("//*[@id=\"appContainer\"]/div[2]/div/div/div[2]/div/div[3]/div/section/h2[2]/ul/li[17]/div/div[3]")).getText();
				    String address1= driver.findElement(By.xpath("//*[@id=\"appContainer\"]/div[2]/div/div/div[2]/div/div[3]/div/section/h2[2]/ul/li[18]/div/div[1]")).getText();
				    String address2= driver.findElement(By.xpath("//*[@id=\"appContainer\"]/div[2]/div/div/div[2]/div/div[3]/div/section/h2[2]/ul/li[18]/div/div[3]")).getText();
				    
				    System.out.println(origin +"--"+country);
				    System.out.println(address1 +"--"+address2);
				    
				    //Add product to the cart and go to cart
				    
				    js.executeScript("window.scrollBy(0,-550)", "");
				   
				    driver.findElement(By.xpath("//*[@id=\"appContainer\"]/div[2]/div/div/div[2]/div/div[3]/div/div[10]/div[1]/div[1]/div/span[2]")).click();
				    Thread.sleep(4000);
				    System.out.println("Hello");
//				    Thread.sleep(3000);
				    driver.findElement(By.xpath("//*[@id=\"appContainer\"]/div[1]/div/header/div[3]/div[2]/div[2]/a/div")).click();
				    
				    //Increase quantity by 1 and update
				    driver.findElement(By.xpath("//*[@id=\"dCartWrapper\"]/div[2]/div[2]/div[1]/div[3]/div/div[1]/div[2]/div[2]/div[2]/div/span")).click();
				    driver.findElement(By.xpath("//*[@id=\"cardQtyPopup\"]/div/button[2]")).click();
				    driver.findElement(By.xpath("//*[@id=\"updateQuantity\"]")).click();
				    
				    //Apply coupon code and find coupon name
				    
				    driver.findElement(By.xpath("//*[@id=\"BIGBOLD\"]")).click();
				    String coupon=driver.findElement(By.xpath("//*[@id=\"dCartWrapper\"]/div[2]/div[2]/div[2]/div[3]/div/div[3]/div/ul/li[1]/div/div[2]/p[2]")).getText();
				    System.out.println("Coupon applied is -- "+coupon);
				    driver.findElement(By.xpath("//*[@id=\"dCartWrapper\"]/div[2]/div[2]/div[2]/div[3]/div/div[2]/div/button")).click();
				    
				    //Print the total price and coupon savings
				    
				    String coupon_savings=driver.findElement(By.xpath("//*[@id=\"couponDiscount\"]/span[2]")).getText();
				    String total_price=driver.findElement(By.xpath("//*[@id=\"orderTotal\"]/span[2]")).getText();
				    System.out.println("Coupon savings = "+coupon_savings);
				    System.out.println("Total price = "+total_price);
				    
				    //Proceed to shipping enter invalid phone number and verify error message
				    
				    driver.findElement(By.xpath("//*[@id=\"dCartWrapper\"]/div[2]/div[2]/div[2]/div[2]/button")).click();
				    driver.findElement(By.xpath("//*[@id=\"login-modal\"]/div/div/div[2]/div/form/div[2]/div[1]/label/input")).sendKeys("564253416");
				    driver.findElement(By.xpath("//*[@id=\"login-modal\"]/div/div/div[2]/div/form/div[2]/div[2]/input")).click();
				    String error_msg=driver.findElement(By.xpath("//*[@id=\"error-msg\"]")).getText();
				    System.out.println("Error message: "+error_msg);
				    
				    driver.close();
				    
				    
			  }
			  driver.switchTo().window(window1Details);
			 
		  }
	   }		
	

}
