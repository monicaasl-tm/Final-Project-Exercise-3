package Tests;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Page.HomePage;

public class HomePageTests {
	
	public String baseURL = "http://www.phptravels.net/";

	private String driverPath = "src/test/resources/drivers/chromedriver";
	private WebDriver driver;
	private HomePage home;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		this.driver = new ChromeDriver();
		this.home = new HomePage(this.driver);
		this.driver.get(baseURL);
	    this.driver.manage().window().maximize();
	}
	
	@Test
	public void selectTravel() throws InterruptedException {
		
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(home.fligthIcon));
		this.home.fligthIcon.click();
		
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(home.roundTrip));
		this.home.roundTrip.click();
		
		this.home.selectOrigin.sendKeys("Monterrey");
		
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(home.selectAirportOrigin));
		this.home.selectAirportOrigin.click();
		
		this.home.selectDestination.sendKeys("Cancun");
		
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(home.selectAirportDest));
		this.home.selectAirportDest.click();
		
		//Select date
		this.home.selectDepartDate.click();
		LocalDate dt = LocalDate.now();
		LocalDate tomorrow = dt.plusDays(1);
		LocalDate tenDays = dt.plusDays(10);
		String pattern = "dd-MM-yyyy";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		this.home.selectDepartDate.clear();
		this.home.selectDepartDate.sendKeys(formatter.format(tomorrow));
		
		this.home.selectReturnDate.click();
		this.home.selectReturnDate.clear();
		this.home.selectReturnDate.sendKeys(formatter.format(tenDays));
		
		this.home.passengerDropDown.click();
		
		this.home.selectPassengersAdults.clear();
		this.home.selectPassengersAdults.sendKeys("3");
		
		this.home.selectPassengersChild.clear();
		this.home.selectPassengersChild.sendKeys("1");
		
		this.home.selectClass.click();
		
		this.home.selectFirstClass.click();
		
		this.home.searchButton.click();
		
		Assert.assertNotNull(this.home.totalFlights.getText());
		
	}

	
	@AfterTest
	public void tearDown() {
		this.driver.close();
	}

}
