package WebUITesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest {
	

		 @Test
		 public void VerifyMkMyTrip() throws InterruptedException
		 {
		
			 String flag="False";
			 String str_FromCity="Pune";
			 String str_ToCity="Goa";
			 String str_date="Thu Sep 02 2021";
			 String str_ReturnMsg="";
			 String oneway="";
			 String str_Adults="2";
			 String str_Childrean="1";
			 String str_Infant="1";
			 String str_Class="Business";
			 
			 System.setProperty("webdriver.chrome.driver","C:\\SeleniumDriver\\chromedriver.exe");
			 WebDriver driver=new ChromeDriver();  //object for driver
			 driver.get("https://www.makemytrip.com/");
			 WebTestObjects obj=new WebTestObjects(driver);
			 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			 WebDriverWait wait= new WebDriverWait(driver,20);

			 driver.manage().window().maximize();
 
			 //Oneway radioButton selection
			 if(obj.oneway_Rbtn.isDisplayed())
			 {
				 oneway=obj.oneway_Rbtn.getAttribute("class").trim();
				 Assert.assertEquals("selected",oneway);
			 }
			 else
			 {
				 System.out.println("Sign Up Popup is not displayed");
			 }
			 
			 //From City selection
			 if(obj.fromCity.isDisplayed())
			 {
				 obj.fromCity.click();
				 obj.fromCity.sendKeys(str_FromCity);
				 if(obj.fromCity_Popup.isDisplayed())
				 {
					 for ( WebElement fromList: obj.fromCity_List) { 
					        if ( fromList.getText().contains( str_FromCity ) )
					        	{
					        		fromList.click();
					        		System.out.println("Required From city Selected");
					        		break;
					        	}
					    }
				 }
				 else
				 {
					 System.out.println("From City list popup is not displayed");
				 }
			 }
			 else
			 {
				 System.out.println("From City section is not displayed");
			 }
			 
			//To City selection
			 if(obj.toCity.isDisplayed())
			 {
				 obj.toCity.click();
				 if(obj.toCity_Popup.isDisplayed())
				 {
					 for ( WebElement toList: obj.toCity_List) { 
					        if ( toList.getText().contains( str_ToCity ) )
					        	{
					        		toList.click();
					        		System.out.println("Required To city Selected");
					        		break;
					        	}
					    }
				 }
				 else
				 {
					 System.out.println("To City List popup is not displayed");
				 }
			 }
			 else
			 {
				 System.out.println("To City section is not displayed");
			 }
			 
			 //Departure date selection
			 if(obj.departureDate.isDisplayed())
			 {
				 obj.departureDate.click();
				 while(flag=="False") {
					   
					   if(driver.findElements(By.xpath("//div[@class='DayPicker-Day'][contains(@aria-label,'"+str_date+"')]")).size()>0) 
					   {
						   driver.findElement(By.xpath("//div[@class='DayPicker-Day'][contains(@aria-label,'"+str_date+"')]")).click();
						   flag="True";
						   Thread.sleep(5000);
					   }
					   
					   else {
						    Thread.sleep(5000);
						    driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
					   }
				 }
			 }
			 else
			 {
				 System.out.println("Departure Date is not displayed");
			 }
			 
			 if(obj.return_Msg.isDisplayed())
			 {
				 str_ReturnMsg=obj.return_Msg.getText().trim();
				 Assert.assertEquals("Tap to add a return date for bigger discounts",str_ReturnMsg);
			 }
			 else
			 {
				 System.out.println("Return Date area is not displayed");
			 }
			 
			 if(obj.travellerClass_Lbl.isDisplayed())
			 {
				 obj.travellerClass_Lbl.click();
				 
				 //selection of adults
				 for ( WebElement adultList: obj.adultsContainer) { 
					 
				        if ( adultList.getText().contains( str_Adults ) )
				        	{
				        		adultList.click();
				        		System.out.println("Required no. of adults are selected");
				        		break;
				        	}
				    }
				 
				//selection of Children
				 for ( WebElement ChildList: obj.childrenContainer) { 
					
				        if ( ChildList.getText().contains( str_Childrean ) )
				        	{
				        		ChildList.click();
				        		System.out.println("Required no. of Children are selected");
				        		break;
				        	}
				    }
				 
				//selection of infants
				 for ( WebElement infantList: obj.infantContainer) { 
					 
				        if ( infantList.getText().contains( str_Infant ) )
				        	{
				        		infantList.click();
				        		System.out.println("Required no. of infants are selected");
				        		break;
				        	}
				    }
				 
				//selection of class
				 for ( WebElement classList: obj.classContainer) { 
					 
				        if ( classList.getText().contains( str_Class ) )
				        	{
				        		classList.click();
				        		System.out.println("Required no. of class are selected");
				        		break;
				        	}
				    }
				 
				 if(obj.apply_Btn.isDisplayed())
				 {
					 obj.apply_Btn.click();
					 System.out.println("Apply button is clicked");
				 }
				 else
				 {
					 System.out.println("Apply button is not displayed");
				 }
			 }
			 else
			 {
				 
			 }
			 
			 if(obj.search_Link.isDisplayed())
			 {
				 obj.search_Link.click();
	 
				 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='listing-id']")));
				 if(obj.FlightsList.isDisplayed())
				 {
					 System.out.println("Search button is clicked successfully and list of required flights is displayed"); 
				 }
				 else
				 {
					 System.out.println("List of required flights is not displayed"); 
				 }
			 }
			 else
			 {
				 System.out.println("Search button is not displayed");
			 }
			 
			 //Closing the browser
			 driver.close();
		 }
		 
		 
			 
		 
}
