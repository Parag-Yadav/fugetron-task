package WebUITesting;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTestObjects {

	WebDriver driver;
	
	public WebTestObjects (WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@data-cy='oneWayTrip']")
	public WebElement oneway_Rbtn;
	
	@FindBy(xpath = "//*[@id='fromCity']")
	public WebElement fromCity;
	
	@FindBy(xpath = "//*[@class='hsw_autocomplePopup autoSuggestPlugin ']")
	public WebElement fromCity_Popup;
	
	@FindBy(xpath = "//*[@class='hsw_autocomplePopup autoSuggestPlugin ']//li//*[@class='font14 appendBottom5 blackText']")
	public List<WebElement> fromCity_List;
	
	@FindBy(xpath = "//*[@id='toCity']")
	public WebElement toCity;
	
	@FindBy(xpath = "//*[@class='hsw_autocomplePopup autoSuggestPlugin makeFlex column spaceBetween']")
	public WebElement toCity_Popup;
	
	@FindBy(xpath = "//*[@class='fsw_inputBox searchToCity inactiveWidget activeWidget']//li//*[@class='font14 appendBottom5 blackText']")
	public List<WebElement> toCity_List;
	
	@FindBy(xpath = "//*[@for='departure']")
	public WebElement departureDate;
	
	@FindBy(xpath = "//*[text()='Tap to add a return date for bigger discounts']")
	public WebElement return_Msg;
	
	@FindBy(xpath = "//*[@class='fsw_inputBox flightTravllers inactiveWidget ']")
	public WebElement travellerClass_Lbl;
	
	@FindBy(xpath = "//*[contains(@class,'guestCounter')]//li[contains(@data-cy,'adults')]")
	public List<WebElement> adultsContainer;
	
	@FindBy(xpath = "//*[contains(@class,'guestCounter')]//li[contains(@data-cy,'children')]")
	public List<WebElement> childrenContainer;
	
	@FindBy(xpath = "//*[contains(@class,'guestCounter')]//li[contains(@data-cy,'infants')]")
	public List<WebElement> infantContainer;
	
	@FindBy(xpath = "//*[contains(@class,'guestCounter')]//li[contains(@data-cy,'travelClass')]")
	public List<WebElement> classContainer;
	
	@FindBy(xpath = "//button[text()='APPLY']")
	public WebElement apply_Btn;
	
	@FindBy(xpath = "//a[text()='Search']")
	public WebElement search_Link;
	
	@FindBy(xpath = "//*[@id='listing-id']")
	public WebElement FlightsList;
	
}
