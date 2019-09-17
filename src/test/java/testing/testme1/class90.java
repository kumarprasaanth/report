package testing.testme1;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class class90 {
	WebDriver driver;
	@Given("login working normally")
	public void login_working_normally() {
		System.setProperty("webdriver.chrome.driver", "C:\\kprasaanth\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp/");
		driver.manage().window().maximize();
		
		/*driver.findElement(By.partialLinkText("SignUp")).click();
		driver.findElement(By.id("userName")).sendKeys("prasaanth123");
		driver.findElement(By.id("firstName")).sendKeys("prasaanth");
		driver.findElement(By.id("lastName")).sendKeys("kumar");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.id("pass_confirmation")).sendKeys("Password123");
		driver.findElement(By.xpath("//input[@value='Male']")).click();;
		driver.findElement(By.id("emailAddress")).sendKeys("asdfg@gmail.com");
		driver.findElement(By.id("mobileNumber")).sendKeys("1234567891");
		driver.findElement(By.id("dob")).sendKeys("17/12/2001");
		driver.findElement(By.id("address")).sendKeys("51,tnagar");
		Select b=new Select(driver.findElement(By.id("securityQuestion")));
		b.selectByVisibleText("What is your Birth Place?");
		driver.findElement(By.id("answer")).sendKeys("chennai");
		driver.findElement(By.name("Submit")).click();*/
		driver.findElement(By.partialLinkText("SignIn")).click();
		driver.findElement(By.id("userName")).sendKeys("Lalitha");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.name("Login")).click();
		
		System.out.println("user logged in successsfully");
		
	}
	@When("search product")
	public void search_product() throws InterruptedException {
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.linkText("All Categories"))).build().perform();
		a.moveToElement(driver.findElement(By.linkText("Electronics"))).click().build().perform();
		Thread.sleep(3000);
		a.moveToElement(driver.findElement(By.linkText("Head Phone"))).click().build().perform();
	}
	@And("add to cart") 
		public void add_to_cart() {
		    driver.findElement(By.linkText("Add to cart")).click();
		    driver.findElement(By.partialLinkText("Cart")).click();
		    Assert.assertEquals("View Cart", driver.getTitle());
		    System.out.println("product is available");
		    
		}
	
	@Then("finally done")
	public void finally_done() {
		System.out.println("testing done successfully");
		
	}
}
