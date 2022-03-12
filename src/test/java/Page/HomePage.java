package Page;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HomePage {
	
	private WebDriver driver;
	
	//Page Factory Web Elements
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Mapeo
	@FindBy(xpath = "//button[@id='hotels-tab' and @aria-controls='flights']")
	public WebElement fligthIcon;
	
	@FindBy(xpath = "//input[@id='round-trip']")
	public WebElement roundTrip;

	@FindBy(xpath = " //input[@id='autocomplete']")
	public WebElement selectOrigin;
	
	@FindBy(xpath = "//strong[contains(text(),'General Mariano Escobedo Intl')]")
	public WebElement selectAirportOrigin;
	
	@FindBy(xpath = "//input[@id='autocomplete2']")
	public WebElement selectDestination;
	
	@FindBy(xpath = "//div[contains(text(),'Cancun, Mexico')]")
	public WebElement selectAirportDest;

	@FindBy(xpath = "//input[@id='departure']")
	public WebElement selectDepartDate;

	@FindBy(xpath = "//input[@id='return']")
	public WebElement selectReturnDate;
	
	@FindBy(xpath = "//a[@class='dropdown-toggle dropdown-btn waves-effect']")
	public WebElement passengerDropDown;
	
	@FindBy(xpath = "//input[@id='fadults']")
	public WebElement selectPassengersAdults;
	
	@FindBy(xpath = "//input[@id='fchilds']")
	public WebElement selectPassengersChild;
	
	@FindBy(xpath = "//select[@id='flight_type']")
	public WebElement selectClass;
	
	@FindBy(xpath = "//option[contains(text(),'First')]")
	public WebElement selectFirstClass;
	
	@FindBy(xpath = "//button[@id='flights-search']")
	public WebElement searchButton;
	
	@FindBy(xpath = "//a[contains(text(),'Total Flights')]")
	public WebElement totalFlights;

}
