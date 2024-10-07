package amaronpagelocate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AmaronLocateActions 
{
	WebDriver driver;
	
	//LOCATE LOGO
	@FindBy(xpath="//*[@id=\"block-sitebranding\"]/a/img")
	WebElement amaronLogo;
	
	//LOCATE TWITTER LOGO
	@FindBy(xpath="//*[@id=\"block-socialheadericons\"]/div/div/ul/li[3]/ul/li[2]/a/img")
	WebElement twitterLogo;
	
	//LOCATE TWITTER URL
	@FindBy(xpath="//*[@id=\"block-socialheadericons\"]/div/div/ul/li[3]/ul/li[2]/a")
	WebElement twitterURL;
	
	//LOCATE ASG BATTERY
	@FindBy(xpath="//*[@id=\"block-views-block-home-page-banner-block-1\"]/div/div/div/div/div/ul/div[1]/div/div[3]/li/div/span/div/div[1]/div/pre/a")
	WebElement asgBattery;
	
	//LOCATE AGM BATTERY
	@FindBy(xpath="//*[@id=\"block-views-block-home-page-banner-block-1\"]/div/div/div/div/div/ul/div[1]/div/div[4]/li/div/span/div/div[1]/div/pre/a")
	WebElement agmBattery;	
	
	//LOCATE GOOGLE PLAY STORE
	@FindBy(xpath="//*[@id=\"block-views-block-home-page-banner-block-1\"]/div/div/div/div/div/ul/div[1]/div/div[2]/li/div/span/div/div[1]/div/div/pre/a[1]")
	WebElement googlePlayStore;
	
	//LOCATE APP STORE
	@FindBy(xpath="//*[@id=\"block-views-block-home-page-banner-block-1\"]/div/div/div/div/div/ul/div[1]/div/div[2]/li/div/span/div/div[1]/div/div/pre/a[2]")
	WebElement appStore;
	
	//LOCATE BLOGS LINK OF OTHERS MENU FROM THE FOOTER
	@FindBy(xpath="//*[@id=\"block-amaron-others\"]/div[2]/ul/li[2]/a")
	WebElement blogsOfOthers;
		
	//LOCATE BLOGS LINK OF OTHERS MENU FROM THE FOOTER
	@FindBy(xpath="//*[@id=\"block-amaron-amaronexperience\"]/div[2]/ul/li[7]/a")
	WebElement blogsOfAmaronExperience;
	
	//LOCATE LOGIN/SIGNUP
	@FindBy(xpath="//*[@id=\"block-useraccount\"]/div/a")
	WebElement loginsignupLink;
	//LOCATE SIGNUP OPTION
	@FindBy(xpath="//*[@id=\"quicktabs-tab-signup_login-0\"]/a")
	WebElement signupOption;
	
	//LOCATE MOBILE NUMBER TEXT FIELD FOR SIGN UP
	@FindBy(xpath="//*[@id=\"edit-mobile-number\"]")
	WebElement mobileSignup;
		
	//LOCATE OTP TEXT FIELD FOR SIGNUP
	@FindBy(xpath="//*[@id=\"edit-otp-value\"]")
	WebElement otpSignup;
	
	//LOCATE GET OTP BUTTON FOR SIGNUP
	@FindBy(xpath="//*[@id=\"otp-signup-form\"]/div[2]/div/a")
	WebElement getOtpSignup;
	
	//LOCATE RESEND? LINK FOR SIGNUP
	@FindBy(xpath="//*[@id=\"otp-signup-form\"]/div[2]/div/a")
	WebElement resendSignup;
	
	//LOCATE EMAILID FOR SIGNUP--OPTIONAL
	@FindBy(xpath="//*[@id=\"edit-email\"]")
	WebElement emailidSignup;
		
	//LOCATE SET PASSWORD FOR SIGNUP--OPTIONAL
	@FindBy(xpath="//*[@id=\"edit-pass\"]")
	WebElement setpasswordSignup;
		
	//LOCATE SIGNUP BUTTON
	@FindBy(xpath="//*[@id=\"edit-submit\"]")
	WebElement signupButton;
	
	//LOCATE LOGIN OPTION
	@FindBy(xpath="//*[@id=\"quicktabs-tab-signup_login-1\"]/a")
	WebElement loginOption;
	
	//LOCATE MOBILE NUMBER LINK FOR LOGIN
	@FindBy(xpath="//*[@id=\"quicktabs-tab-login_mobile_email-0\"]/a")
	WebElement mobileLoginMenu;
	
	//LOCATE MOBILE NUMBER TEXT FIELD FOR LOGIN
	@FindBy(xpath="//*[@id=\"edit-mobile-number--2\"]")
	WebElement mobileNoLogin;
	
	//LOCATE OTP TEXT FIELD FOR LOGIN
	@FindBy(xpath="//*[@id=\"edit-otp-value--2\"]")
	WebElement otpLogin;
	
	//LOCATE GET OTP BUTTON FOR LOGIN
	@FindBy(xpath="//*[@id=\"otp-login-form\"]/div[2]/div/a")
	WebElement getOtpLogin;
		
	//LOCATE EMAIL ID LINK FOR LOGIN
	@FindBy(xpath="//*[@id=\"quicktabs-tab-login_mobile_email-1\"]/a")
	WebElement mailidLoginMenu;
	
	//LOCATE EMAIL ID TEXT FIELD FOR LOGIN
	@FindBy(xpath="//*[@id=\"edit-email--2\"]")
	WebElement emailIDLogin;
	
	//LOCATE PASSWORD TEXT FIELD FOR LOGIN
	@FindBy(xpath="//*[@id=\"edit-pass--2\"]")
	WebElement passwordLogin;
		
	//LOCATE FORGOT PASSWORD? LINK FOR LOGIN
	@FindBy(xpath="//*[@id=\"email-login-form\"]/a")
	WebElement forgotPasswordLogin;
	
	//LOCATE LOGIN BUTTON
	@FindBy(xpath="//*[@id=\"edit-submit--3\"]")
	WebElement loginButton;
	
	//LOCATE ALL LINKS
	@FindBy(tagName="a")
	List<WebElement> allAngerTags;
	
	//LOCATE ABOUT MENU
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[1]/span")
	WebElement aboutMenu;
	
	//LOCATE AMARA RAJA
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[1]/ul/li[2]/a")
	WebElement amaraRaja;
	
	//LOCATE AMARA RAJA ENERGY & MOBILITY
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[1]/ul/li[1]/a")
	WebElement energyMobility;
	
	//LOCATE MANAGEMENT
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[1]/ul/li[3]/a")
	WebElement management;
		
	//LOCATE AFTER MARKET
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[1]/ul/li[4]/a")
	WebElement afterMarket;
		
	//LOCATE OEM
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[1]/ul/li[5]/a")
	WebElement oem;
		
	//LOCATE INTERNATIONAL OPERATIONS
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[1]/ul/li[6]/a")
	WebElement internationalOperations;
		
	//LOCATE MANUFACTURING
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[1]/ul/li[7]/a")
	WebElement manufacturing;
		
	//LOCATE PRODUCTS & SOLUTIONS MENU
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[2]/span")
	WebElement productsMenu;
		
	//LOCATE TWO WHEELERS
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[2]/ul/li[1]/a")
	WebElement twoWheelers;
		
	//LOCATE THREE WHEELERS
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[2]/ul/li[2]/a")
	WebElement threeWheelers;
	
	//LOCATE PASSENGER VEHICLES
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[2]/ul/li[3]/a")
	WebElement passengerVehicles;
			
	//LOCATE COMMERCIAL VEHICLES
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[2]/ul/li[4]/a")
	WebElement commercialVehicles;
			
	//LOCATE FARM VEHICLES
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[2]/ul/li[5]/a")
	WebElement farmVehicles;
			
	//LOCATE EARTH MOVING EQUIPMENT
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[2]/ul/li[6]/a")
	WebElement earthMovingEquipment;
			
	//LOCATE GENSET
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[2]/ul/li[7]/a")
	WebElement genset;
			
	//LOCATE INVERTER AND BATTERIES
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[2]/ul/li[8]/a")
	WebElement inverterBatteries;
			
	//LOCATE E-RIKSHAW
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[2]/ul/li[9]/a")
	WebElement eRikshaw;
			
	//LOCATE CHOOSE YOUR BATTERY
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[2]/ul/li[10]/a")
	WebElement chooseBattery;
	
	//LOCATE SERVICE MENU
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[3]/span")
	WebElement serviceMenu;
	
	//LOCATE AMCARE
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[3]/ul/li[1]/a")
	WebElement amCare;
	
	//LOCATE WARRANTY REGISTRATION
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[3]/ul/li[2]/a")
	WebElement warrantyRegistration;
		
	//LOCATE WARRANTY TERMS & CONDITION
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[3]/ul/li[3]/a")
	WebElement warrentyTerms;
		
	//LOCATE AMARON KONNEKT
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[3]/ul/li[4]/a")
	WebElement amaronKonnekt;
		
	//LOCATE TIPS FOR BUYING BATTERY
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[3]/ul/li[5]/a")
	WebElement batteryTips;
		
	//LOCATE BATTERY SAFETY GUIDLINES
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[3]/ul/li[6]/a")
	WebElement safetyGuidlines;
		
	//LOCATE TERMINOLOGY
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[3]/ul/li[7]/a")
	WebElement terminology;
		
	//LOCATE FAQ'S
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[3]/ul/li[8]/a")
	WebElement faqs;
		
	//LOCATE BATTERY RECYCLING
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[3]/ul/li[9]/a")
	WebElement batteryRecycling;
	
	//LOCATE AMARON EXPERIENCE MENU
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[4]/span")
	WebElement experienceMenu;
	
	//LOCATE ABOUT AMARON
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[4]/ul/li[1]/a")
	WebElement aboutAmaron;
		
	//LOCATE MEDIA
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[4]/ul/li[2]/a")
	WebElement media;
		
	//LOCATE AD GALLERY
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[4]/ul/li[3]/a")
	WebElement adGallery;
		
	//LOCATE FUN FACTS
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[4]/ul/li[4]/a")
	WebElement funFacts;
		
	//LOCATE AMARON LOGO
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[4]/ul/li[5]/a")
	WebElement amaronLogoMenu;
	
	//LOCATE DOWNLOAD HIGH RESOLUTION LOGO BUTTON
	@FindBy(xpath="//*[@id=\"block-views-block-downlaod-document-block-1\"]/div/div/div/div/div/div/span/div/a")
	WebElement downloadLogo;
	
	//LOCATE EVENTS
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[4]/ul/li[6]/a")
	WebElement events;
		
	//LOCATE BLOGS
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[4]/ul/li[7]/a")
	WebElement blogs;
		
	//LOCATE PITSTOP LOCATOR MENU
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[5]/a")
	WebElement pitstopMenu;
	
	//LOCATE CONTACT MENU
	@FindBy(xpath="//*[@id=\"block-amaron-mainmenu\"]/div[2]/ul/li[6]/a")
	WebElement contactMenu;
	
	//LOCATE BRANCH DROPDOWN
	@FindBy(xpath="//*[@id=\"edit-field-city-target-id\"]")
	WebElement selectBranch;
	
	//LOCATE SERVICE OPTION
	@FindBy(xpath="//*[@id=\"edit-contact-query\"]/div[2]/label")
	WebElement service;
			
	//LOCATE QUERY TYPE
	@FindBy(xpath="//*[@id=\"edit-contact-form-service-query-type\"]")
	WebElement queryType;
		
	//LOCATE SUB QUERY TYPE
	@FindBy(xpath="//*[@id=\"sub_query_type\"]")
	WebElement subQueryType;

	//LOCATE NAME
	@FindBy(xpath="//*[@id=\"last_name\"]")
	WebElement enterName;
		
	//LOCATE STATE
	@FindBy(xpath="//*[@id=\"edit-state-code\"]")
	WebElement state;
		
	//LOCATE SELECT DISTRICT
	@FindBy(xpath="/html/body/div[1]/main/div/div/div[3]/div/form/div[11]/div/select")
	WebElement district;

	//LOCATE LOCALITY
	@FindBy(xpath="//*[@id=\"edit-locality--hWzweajMWEM\"]")
	WebElement locality;
		
	//LOCATE PINCODE
	@FindBy(xpath="//*[@id=\"edit-pincode--R3jBfQn_D4M\"]")
	WebElement selectPincode;
		
	//LOCATE PHONE NUMBER
	@FindBy(xpath="//*[@id=\"phone\"]")
	WebElement phoneNumber;
		
	//LOCATE ENTER OTP
	@FindBy(xpath="//*[@id=\"edit-otp-value\"]")
	WebElement enterOTP;
		
	//LOCATE GET OTP
	@FindBy(xpath="//*[@id=\"web-to-lead-contact-form\"]/div[20]/span/a[1]")
	WebElement getOTP;
		
	//LOCATE VALIDATE OTP
	@FindBy(xpath="//*[@id=\"web-to-lead-contact-form\"]/div[20]/span/a[2]")
	WebElement validateOTP;
		
	//LOCATE EMAIL
	@FindBy(xpath="//*[@id=\"email\"]")
	WebElement emailAddress;

	//LOCATE SERVICE CALL NUMBER
	@FindBy(xpath="//*[@id=\"service_call_reference\"]")
	WebElement serviceCallNo;

	//LOCATE PRODUCT SERIAL NUMBER CALL NUMBER
	@FindBy(xpath="//*[@id=\"product_serial_no\"]")
	WebElement productSN;

	//LOCATE CHOOSE FILE
	@FindBy(xpath="//*[@id=\"edit-upload-invoice-upload\"]")
	WebElement chooseFile;
		
	//LOCATE UPLOAD BUTTON
	@FindBy(xpath="//*[@id=\"edit-upload-invoice-upload-button\"]")
	WebElement uploadFile;
	
	//LOCATE SUBMIT QUERY
	@FindBy(xpath="//*[@id=\"edit-submit\"]")
	WebElement submitQuery;
			
	//LOCATE SEARCH BAR
	@FindBy(xpath="//*[@id=\"edit-search\"]")
	WebElement searchBar;
	
	//LOCATE SEARCH BUTTON
	@FindBy(xpath="//*[@id=\"edit-submit\"]")
	WebElement searchButton;
	
	//LOCATE TWO WHEELER LINK
	@FindBy(xpath="//*[@id=\"block-theresanamaronforeveryneed-2\"]/div/div/div[5]/div[1]/a")
	WebElement twoWheelerLink;
	
	//LOCATE VEHICLE MAKE
	@FindBy(xpath="//*[@id=\"edit-vehicle-make\"]")
	WebElement vehicleMake;
	
	//LOCATE VEHICLE MODEL
	@FindBy(xpath="//*[@id=\"edit-model\"]")
	WebElement vehicleModel;
	
	//LOCATE VEHICLE FUEL
	@FindBy(xpath="//*[@id=\"edit-fuel\"]")
	WebElement vehicleFuel;
	
	//LOCATE FIND NOW
	@FindBy(xpath="//*[@id=\"edit-apply\"]")
	WebElement findNow;
	
	//LOCATE SELECT BUTTON
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/a[1]")
	WebElement selectBattery;
	
	//LOCATE PINCODE TEXTBOX
	@FindBy(xpath="//*[@id=\"edit-pincode\"]")
	WebElement pinCode;
	
	//LOCATE CHECK BUTTON
	@FindBy(xpath="//*[@id=\"edit-checklink\"]")
	WebElement checkPincode;
	
	//LOCATE ADD TO CART BUTTON
	@FindBy(xpath="//*[@id=\"edit-add-to-cart\"]")
	WebElement addToCart;
	
	//LOCATE GO TO CART BUTTON
	@FindBy(xpath="//*[@id=\"price-by-pincode-form\"]/a[2]")
	WebElement goToCart;
	
	//LOCATE ADD A NEW ADDRESS
	@FindBy(xpath="//*[@id=\"deliver_address_area\"]/a")
	WebElement addANewAddress;
	
	//LOCATE DELIVER HERE BUTTON
	@FindBy(xpath="//*[@id=\"address_53468\"]")
	WebElement deliverHereAddress;
	
	//LOCATE EDIT ADDRESS BUTTON
	@FindBy(xpath="//*[@id=\"create_edit_link_53468\"]")
	WebElement editAddress;
	
	//PROCEED TO ORDER
	@FindBy(xpath="//*[@id=\"edit-checkout-link\"]")
	WebElement proceedToOrder;
	
	//LOCATE CART LINK
	@FindBy(xpath="//*[@id=\"edit-add-to-cart\"]")
	WebElement cartLink;
	
	//LOCATE COMPLETE ORDER BUTTON
	@FindBy(xpath="//*[@id=\"edit-complete-payment\"]")
	WebElement completeOrder;
	
	//LOCATE MY ACCOUNT
	@FindBy(xpath="//*[@id=\"block-useraccountmobile\"]/div/span")
	WebElement myAccount;
	
	//LOCATE LOG OUT
	@FindBy(xpath="//*[@id=\"block-useraccountmenu-2\"]/div[2]/ul/li[2]/a")
	WebElement logOut;
		
		
	//INITIALIZING THE LOCATED WEB ELEMENTS
	public AmaronLocateActions(WebDriver driver) 
	{
		this.driver=driver;
		//APPLY IMPLICIT WAIT
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		//INITIALIZE ALL WEB ELEMENTS
		PageFactory.initElements(driver,this);
	}
	
	//1.TITLE VERIFICATION:
	public void verifyAmaronTitle() 
	{
		//1.TITLE VERIFICATION OF HOME PAGE USING HARD ASSERTION
		String expectedTitle="Amaron - India's Top Selling Automotive Batteries";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle);
		System.out.println("Expected Title of the HOME page is "+expectedTitle);
		System.out.println("Actual Title of the HOME page is "+actualTitle);
		
		Actions actionObject=new Actions(driver);
		
		//APPLY EXPLICIT WAIT
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(aboutMenu));
		
        //2.TITLE VERIFICATION AMARA RAJA PAGE USING HARD ASSERTION
        actionObject.moveToElement(aboutMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.moveToElement(amaraRaja).click().perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        String amaraRajaExpect="About Us - Amaron Batteries, Automobile & Car Battery Manufacturer";
		String amaraRajaActual=driver.getTitle();
		Assert.assertEquals(amaraRajaActual,amaraRajaExpect);
		System.out.println("Expected Title of the AMARA RAJA page is "+amaraRajaExpect);
		System.out.println("Actual Title of the AMARA RAJA page is "+amaraRajaActual);
		
		//3.TITLE VERIFICATION AMARA RAJA ENERGY & MOBILITY PAGE USING HARD ASSERTION
        actionObject.moveToElement(aboutMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.moveToElement(energyMobility).click().perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        String energyMobilityExpect="About Us - Amaron Batteries, Automobile & Car Battery Manufacturer";
		String energyMobilityActual=driver.getTitle();
		Assert.assertEquals(energyMobilityActual,energyMobilityExpect);
		System.out.println("Expected Title of the AMARA RAJA ENERGY & MOBILITY page is "+energyMobilityExpect);
		System.out.println("Actual Title of the AMARA RAJA ENERGY & MOBILITY page is "+energyMobilityActual);
		
		//4.TITLE VERIFICATION MANAGEMENT PAGE USING HARD ASSERTION
        actionObject.moveToElement(aboutMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.moveToElement(management).click().perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        String managementExpect="Amaron - Management | Chairman and Managing Director";
		String managementActual=driver.getTitle();
		Assert.assertEquals(managementActual,managementExpect);
		System.out.println("Expected Title of the MANAGEMENT page is "+managementExpect);
		System.out.println("Actual Title of the MANAGEMENT page is "+managementActual);
		
		//5.TITLE VERIFICATION AFTER MARKET PAGE USING HARD ASSERTION
        actionObject.moveToElement(aboutMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.moveToElement(afterMarket).click().perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        String afterMarketExpect="Our Aftermarket Presence in Automotive Market | Amaron";
		String afterMarketActual=driver.getTitle();
		Assert.assertEquals(afterMarketActual,afterMarketExpect);
		System.out.println("Expected Title of the AFTER MARKET page is "+afterMarketExpect);
		System.out.println("Actual Title of the AFTER MARKET page is "+afterMarketActual);

		//6.TITLE VERIFICATION OEM PAGE USING HARD ASSERTION
        actionObject.moveToElement(aboutMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.moveToElement(oem).click().perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        String oemExpect="Amaron Batteries - Automotive Original Equipment Manufacturer";
		String oemActual=driver.getTitle();
		Assert.assertEquals(oemActual,oemExpect);
		System.out.println("Expected Title of the OEM page is "+oemExpect);
		System.out.println("Actual Title of the OEM page is "+oemActual);

		//7.TITLE VERIFICATION INTERNATIONAL OPERATIONS PAGE USING HARD ASSERTION
        actionObject.moveToElement(aboutMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.moveToElement(internationalOperations).click().perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        String internationalExpect="Exports - Amaron India | Global Player in Automotive Batteries";
		String internationalActual=driver.getTitle();
		Assert.assertEquals(internationalActual,internationalExpect);
		System.out.println("Expected Title of the INTERNATIONAL OPERATIONS page is "+internationalExpect);
		System.out.println("Actual Title of the INTERNATIONAL OPERATIONS page is "+internationalActual);
		
		//8.TITLE VERIFICATION MANUFACTURING PAGE USING HARD ASSERTION
        actionObject.moveToElement(aboutMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.moveToElement(manufacturing).click().perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        String manufacturingExpect="Leading Battery Manufacturers in India - Amaron";
		String manufacturingActual=driver.getTitle();
		Assert.assertEquals(manufacturingActual,manufacturingExpect);
		System.out.println("Expected Title of the MANUFACTURING page is "+manufacturingExpect);
		System.out.println("Actual Title of the MANUFACTURING page is "+manufacturingActual);
		
		//9.TITLE VERIFICATION TWO WHEELERS PAGE USING HARD ASSERTION
        actionObject.moveToElement(productsMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.moveToElement(twoWheelers).click().perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        String twoWheelersExpect="Two Wheeler Batteries, Buy Motorcycle/Bike Batteries Online - Amaron";
		String twoWheelersActual=driver.getTitle();
		Assert.assertEquals(twoWheelersActual,twoWheelersExpect);
		System.out.println("Expected Title of the TWO WHEELERS page is "+twoWheelersExpect);
		System.out.println("Actual Title of the TWO WHEELERS page is "+twoWheelersActual);
		
		//10.TITLE VERIFICATION THREE WHEELERS PAGE USING HARD ASSERTION
        actionObject.moveToElement(productsMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.moveToElement(threeWheelers).click().perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        String threeWheelersExpect="Auto Rickshaw, Three Wheeler Battery Only| Amaron";
		String threeWheelersActual=driver.getTitle();
		Assert.assertEquals(threeWheelersActual,threeWheelersExpect);
		System.out.println("Expected Title of the THREE WHEELERS page is "+threeWheelersExpect);
		System.out.println("Actual Title of the THREE WHEELERS page is "+threeWheelersActual);
		
		//11.TITLE VERIFICATION PASSENGER VEHICLES PAGE USING HARD ASSERTION
        actionObject.moveToElement(productsMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.moveToElement(passengerVehicles).click().perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        String passengerExpect="Zero Maintenance Car Battery | Car Batteries Online - Amaron";
		String passengerActual=driver.getTitle();
		Assert.assertEquals(passengerActual,passengerExpect);
		System.out.println("Expected Title of the PASSENGER VEHICLES page is "+passengerExpect);
		System.out.println("Actual Title of the PASSENGER VEHICLES page is "+passengerActual);
		
		//12.TITLE VERIFICATION COMMERCIAL VEHICLES PAGE USING HARD ASSERTION
        actionObject.moveToElement(productsMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.moveToElement(commercialVehicles).click().perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        String commercialExpect="Heavy Duty Commercial Vehicle Batteries | Bus, Truck & Tractor";
		String commercialActual=driver.getTitle();
		Assert.assertEquals(commercialActual,commercialExpect);
		System.out.println("Expected Title of the COMMERCIAL VEHICLES page is "+commercialExpect);
		System.out.println("Actual Title of the COMMERCIAL VEHICLES page is "+commercialActual);
		
		//13.TITLE VERIFICATION FARM VEHICLES PAGE USING HARD ASSERTION
        actionObject.moveToElement(productsMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.moveToElement(farmVehicles).click().perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        String farmExpect="Tractor, Dumper, Harvester Battery | Heavy Duty Farm Vehicle Batteries";
		String farmActual=driver.getTitle();
		Assert.assertEquals(farmActual,farmExpect);
		System.out.println("Expected Title of the FARM VEHICLES page is "+farmExpect);
		System.out.println("Actual Title of the FARM VEHICLES page is "+farmActual);
		
		//14.TITLE VERIFICATION EARTH MOVING EQUIPMENT PAGE USING HARD ASSERTION
        actionObject.moveToElement(productsMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.moveToElement(earthMovingEquipment).click().perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        String earthMoveExpect="Buy Battery for Earth Moving Equipment | Amaron";
		String earthMoveActual=driver.getTitle();
		Assert.assertEquals(earthMoveActual,earthMoveExpect);
		System.out.println("Expected Title of the EARTH MOVING EQUIPMENT page is "+earthMoveExpect);
		System.out.println("Actual Title of the EARTH MOVING EQUIPMENT page is "+earthMoveActual);
		
		//15.TITLE VERIFICATION GENSET PAGE USING HARD ASSERTION
        actionObject.moveToElement(productsMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.moveToElement(genset).click().perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        String gensetExpect="Buy Genset Battery, Batteries for your Genset | Amaron";
		String gensetActual=driver.getTitle();
		Assert.assertEquals(gensetActual,gensetExpect);
		System.out.println("Expected Title of the GENSET page is "+gensetExpect);
		System.out.println("Actual Title of the GENSET page is "+gensetActual);
		
		//16.TITLE VERIFICATION INVERTER AND BATTERIES PAGE USING HARD ASSERTION
        actionObject.moveToElement(productsMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.moveToElement(inverterBatteries).click().perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        String inverterBatteryExpect="Home UPS and Inverter Batteries Online | Amaron";
		String inverterBatteryActual=driver.getTitle();
		Assert.assertEquals(inverterBatteryActual,inverterBatteryExpect);
		System.out.println("Expected Title of the INVERTER AND BATTERIES page is "+inverterBatteryExpect);
		System.out.println("Actual Title of the INVERTER AND BATTERIES page is "+inverterBatteryActual);
		
		//17.TITLE VERIFICATION E-RIKSHAW PAGE USING HARD ASSERTION
        actionObject.moveToElement(productsMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.moveToElement(eRikshaw).click().perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        String eRikshawExpect="Amaron E-Rickshaw Battery at Best Prices | Amaron";
		String eRikshawActual=driver.getTitle();
		Assert.assertEquals(eRikshawActual,eRikshawExpect);
		System.out.println("Expected Title of the E-RIKSHAW page is "+eRikshawExpect);
		System.out.println("Actual Title of the E-RIKSHAW page is "+eRikshawActual);
		
		//18.TITLE VERIFICATION CHOOSE YOUR BATTERY PAGE USING HARD ASSERTION
        actionObject.moveToElement(productsMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.moveToElement(chooseBattery).click().perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        String chooseBatteryExpect="Choose and Get Battery for your Two, Three or Four Wheeler Vehicle";
		String chooseBatteryActual=driver.getTitle();
		Assert.assertEquals(chooseBatteryActual,chooseBatteryExpect);
		System.out.println("Expected Title of the CHOOSE YOUR BATTERY page is "+chooseBatteryExpect);
		System.out.println("Actual Title of the CHOOSE YOUR BATTERY page is "+chooseBatteryActual);
		
		//19.TITLE VERIFICATION AMCARE PAGE USING HARD ASSERTION
        actionObject.moveToElement(serviceMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.moveToElement(amCare).click().perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        String amCareExpect="AMCARE | Amaron Batteries - Customer Care Services";
		String amCareActual=driver.getTitle();
		Assert.assertEquals(amCareActual,amCareExpect);
		System.out.println("Expected Title of the AMCARE page is "+amCareExpect);
		System.out.println("Actual Title of the AMCARE page is "+amCareActual);

		//20.TITLE VERIFICATION WARRANTY REGISTRATION PAGE USING HARD ASSERTION
        actionObject.moveToElement(serviceMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.moveToElement(warrantyRegistration).click().perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        String warrantyExpect="Warranty Registration | Amaron";
		String warrantyActual=driver.getTitle();
		Assert.assertEquals(warrantyActual,warrantyExpect);
		System.out.println("Expected Title of the WARRANTY REGISTRATION page is "+warrantyExpect);
		System.out.println("Actual Title of the WARRANTY REGISTRATION page is "+warrantyActual);

		//21.TITLE VERIFICATION WARRANTY TERMS & CONDITION PAGE USING HARD ASSERTION
        actionObject.moveToElement(serviceMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.moveToElement(warrentyTerms).click().perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        String termsExpect="Warranty T&C | Amaron";
		String termsActual=driver.getTitle();
		Assert.assertEquals(termsActual,termsExpect);
		System.out.println("Expected Title of the WARRANTY TERMS & CONDITION page is "+termsExpect);
		System.out.println("Actual Title of the WARRANTY TERMS & CONDITION page is "+termsActual);

		//22.TITLE VERIFICATION AMARON KONNEKT PAGE USING HARD ASSERTION
        actionObject.moveToElement(serviceMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.moveToElement(amaronKonnekt).click().perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        String konnektExpect="Download Amaron Konnekt App - Amaron Battery App for IOS & Android";
		String konnektActual=driver.getTitle();
		Assert.assertEquals(konnektActual,konnektExpect);
		System.out.println("Expected Title of the AMARON KONNEKT page is "+konnektExpect);
		System.out.println("Actual Title of the AMARON KONNEKT page is "+konnektActual);
		
		//23.TITLE VERIFICATION TIPS FOR BUYING BATTERY PAGE USING HARD ASSERTION
        actionObject.moveToElement(serviceMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.moveToElement(batteryTips).click().perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        String tipsExpect="Tips for Buying Car Battery - How to Choose Right Car Battery";
		String tipsActual=driver.getTitle();
		Assert.assertEquals(tipsActual,tipsExpect);
		System.out.println("Expected Title of the TIPS FOR BUYING BATTERY page is "+tipsExpect);
		System.out.println("Actual Title of the TIPS FOR BUYING BATTERY page is "+tipsActual);

		//24.TITLE VERIFICATION BATTERY SAFETY GUIDLINES PAGE USING HARD ASSERTION
        actionObject.moveToElement(serviceMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.moveToElement(safetyGuidlines).click().perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        String safetyExpect="Battery Safety and Handling Guidelines - Amaron Vehicle Batteries";
		String safetyActual=driver.getTitle();
		Assert.assertEquals(safetyActual,safetyExpect);
		System.out.println("Expected Title of the BATTERY SAFETY GUIDLINES page is "+safetyExpect);
		System.out.println("Actual Title of the BATTERY SAFETY GUIDLINES page is "+safetyActual);
		
		//25.TITLE VERIFICATION TERMINOLOGY PAGE USING HARD ASSERTION
        actionObject.moveToElement(serviceMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.moveToElement(terminology).click().perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        String terminologyExpect="Common Terminology Used at Amaron";
		String terminologyActual=driver.getTitle();
		Assert.assertEquals(terminologyActual,terminologyExpect);
		System.out.println("Expected Title of the TERMINOLOGY page is "+terminologyExpect);
		System.out.println("Actual Title of the TERMINOLOGY page is "+terminologyActual);
		
		//26.TITLE VERIFICATION FAQ'S PAGE USING HARD ASSERTION
        actionObject.moveToElement(serviceMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.moveToElement(faqs).click().perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        String faqsExpect="Frequently Asked Questions | Amaron";
		String faqsActual=driver.getTitle();
		Assert.assertEquals(faqsActual,faqsExpect);
		System.out.println("Expected Title of the FAQ'S page is "+faqsExpect);
		System.out.println("Actual Title of the FAQ'S page is "+faqsActual);
		
		//27.TITLE VERIFICATION BATTERY RECYCLING PAGE USING HARD ASSERTION
        actionObject.moveToElement(serviceMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.moveToElement(batteryRecycling).click().perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        String recycleExpect="Battery Recycling at Amaron - Safe Disposal of Old Car Batteries";
		String recycleActual=driver.getTitle();
		Assert.assertEquals(recycleActual,recycleExpect);
		System.out.println("Expected Title of the BATTERY RECYCLING page is "+recycleExpect);
		System.out.println("Actual Title of the BATTERY RECYCLING page is "+recycleActual);
		
		//28.TITLE VERIFICATION ABOUT AMARON PAGE USING HARD ASSERTION
        actionObject.moveToElement(experienceMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.moveToElement(aboutAmaron).click().perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        String aboutExpect="About Amaron | Amaron";
		String aboutActual=driver.getTitle();
		Assert.assertEquals(aboutActual,aboutExpect);
		System.out.println("Expected Title of the ABOUT AMARON page is "+aboutExpect);
		System.out.println("Actual Title of the ABOUT AMARON page is "+aboutActual);
		
		//29.TITLE VERIFICATION MEDIA PAGE USING HARD ASSERTION
        actionObject.moveToElement(experienceMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.moveToElement(media).click().perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        String mediaExpect="Amaron Experience: Press Releases | News | Events";
		String mediaActual=driver.getTitle();
		Assert.assertEquals(mediaActual,mediaExpect);
		System.out.println("Expected Title of the MEDIA page is "+mediaExpect);
		System.out.println("Actual Title of the MEDIA page is "+mediaActual);
		
		//30.TITLE VERIFICATION AD GALLERY PAGE USING HARD ASSERTION
        actionObject.moveToElement(experienceMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.moveToElement(adGallery).click().perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        String adExpect="Print, Digital, & Television commercials from Amaron";
		String adActual=driver.getTitle();
		Assert.assertEquals(adActual,adExpect);
		System.out.println("Expected Title of the AD GALLERY page is "+adExpect);
		System.out.println("Actual Title of the AD GALLERY page is "+adActual);
		
		//31.TITLE VERIFICATION FUN FACTS PAGE USING HARD ASSERTION
        actionObject.moveToElement(experienceMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.moveToElement(funFacts).click().perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        String funExpect="Our Leading Story, Some Fun Facts | Amaron";
		String funActual=driver.getTitle();
		Assert.assertEquals(funActual,funExpect);
		System.out.println("Expected Title of the FUN FACTS page is "+funExpect);
		System.out.println("Actual Title of the FUN FACTS page is "+funActual);
		
		//32.TITLE VERIFICATION AMARON LOGO PAGE USING HARD ASSERTION
        actionObject.moveToElement(experienceMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.moveToElement(amaronLogoMenu).click().perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        String logoExpect="Our Logo - The Logic Behind | Amaron";
		String logoActual=driver.getTitle();
		Assert.assertEquals(logoActual,logoExpect);
		System.out.println("Expected Title of the AMARON LOGO page is "+logoExpect);
		System.out.println("Actual Title of the AMARON LOGO page is "+logoActual);
		
		//33.TITLE VERIFICATION EVENTS PAGE USING HARD ASSERTION
        actionObject.moveToElement(experienceMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.moveToElement(events).click().perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        String eventsExpect="Event Highlights at Amaron | Amaron";
		String eventsActual=driver.getTitle();
		Assert.assertEquals(eventsActual,eventsExpect);
		System.out.println("Expected Title of the EVENTS page is "+eventsExpect);
		System.out.println("Actual Title of the EVENTS page is "+eventsActual);
		
		//34.TITLE VERIFICATION BLOGS PAGE USING HARD ASSERTION
        actionObject.moveToElement(experienceMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.moveToElement(blogs).click().perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        String blogsExpect="Our Thoughts for the Industry | Amaron Blog";
		String blogsActual=driver.getTitle();
		Assert.assertEquals(blogsActual,blogsExpect);
		System.out.println("Expected Title of the BLOGS page is "+blogsExpect);
		System.out.println("Actual Title of the BLOGS page is "+blogsActual);
		
		//35.TITLE VERIFICATION PITSTOP PAGE USING HARD ASSERTION
        actionObject.moveToElement(pitstopMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.click(pitstopMenu).perform();
		actionObject.pause(Duration.ofMillis(500)).perform();
        String pitstopExpect="Amaron Car Battery Pitstop Locator - Battery Dealers Near Me";
		String pitstopActual=driver.getTitle();
		Assert.assertEquals(pitstopActual,pitstopExpect);
		System.out.println("Expected Title of the PITSTOP page is "+pitstopExpect);
		System.out.println("Actual Title of the PITSTOP page is "+pitstopActual);
		
		//36.TITLE VERIFICATION CONTACT PAGE USING HARD ASSERTION
        actionObject.moveToElement(contactMenu).perform();
        actionObject.pause(Duration.ofMillis(300)).perform();
        actionObject.click(contactMenu).perform();
		actionObject.pause(Duration.ofMillis(500)).perform();
        String contactExpect="Amaron - Contact Us | Automotive Battery Manufacturer";
		String contactActual=driver.getTitle();
		Assert.assertEquals(contactActual,contactExpect);
		System.out.println("Expected Title of the CONTACT page is "+contactExpect);
		System.out.println("Actual Title of the CONTACT page is "+contactActual);
		
		//REDIRECT TO THE HOME PAGE
		amaronLogo.click();
   	}
	
	//2.LOGO VERIFICATION:
	public void verifyLogo() throws IOException, InterruptedException 
	{
		//AMARON LOGO VERIFICATION USING SOFT ASSERTION
		boolean logoStatus=amaronLogo.isEnabled();
		if(logoStatus) 
		{
			System.out.println("Amaron Logo is Present.\nStatus is "+logoStatus);
		}
		else 
		{
			System.out.println("Amaron Logo is not Present.\nStatus is "+logoStatus);
		}
		
		//TWITTER LOGO VERIFICATION
		File src=twitterLogo.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,new File("./Screenshot/AmaronXLogo.jpeg"));
		
		twitterURL.click();
		
		String xURLExpected=twitterURL.getAttribute("href");
		
		//SWITCH TO NEW WINDOW
		ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		
		//WAIT FOR PAGE LOAD
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains("Amaron (@amaronofficial) / X"));
		
		//X TITLE VERIFICATION
		String xTitleExpected="Amaron (@amaronofficial) / X";
	    String xTitleActual=driver.getTitle();
	    Assert.assertEquals(xTitleActual,xTitleExpected,"X Title mismatch");
	    System.out.println("Expected Title of the X page is "+xTitleExpected);
		System.out.println("Actual Title of the X page is "+xTitleActual);
		
		//X URL VERIFICATION
		String xURLActual=driver.getCurrentUrl();
		if(xURLExpected.equalsIgnoreCase(xURLActual))
		{
			System.out.println("X URL in the xpath matches with Actual URL");
		}
		else
		{
			System.out.println("X URL in the xpath doesn't match with Actual URL");
		}
		System.out.println("Expected URL of the X page is "+xURLExpected);
		System.out.println("Actual URL of the X page is "+xURLActual);
		
		Thread.sleep(300);
		
	    //CLOSSE X WINDOW
	    driver.close();
	    
	    //REDIRECT TO THE HOME PAGE
	    driver.switchTo().window(windows.get(0));
	}
	
	//3.VERIFY ALL LINKS:
	public int brokenLinksCount = 0;
	public int validLinksCount = 0;
	
	public void linkSearch() throws Exception 
	{
		System.out.println("Total Links avaliable : "+allAngerTags.size());
			
		for(WebElement we:allAngerTags) 
		{
			String hrefValue=we.getAttribute("href");
			String text=we.getText();
			System.out.println(text+"\t"+hrefValue);
			verifyBrokenLinks(hrefValue);
		}
		System.out.println("Total Broken Links: " + brokenLinksCount);
	    System.out.println("Total Valid Links: " + validLinksCount);
	}
	
	public void verifyBrokenLinks(String hrefLink) 
	{
		try 
		{
			URL url=new URL(hrefLink);
			HttpURLConnection con=(HttpURLConnection) url.openConnection();
			con.setConnectTimeout(1000);
			con.connect();
			
			if(con.getResponseCode()==200) 
			{
				System.out.println("Valid Link : "+hrefLink);
				validLinksCount++;
			}
			else 
			{
				System.out.println("Broken Link : "+hrefLink);
				brokenLinksCount++;
			}
		}
		catch(Exception e) 
		{
			System.out.println(e);
			brokenLinksCount++;
		}
	}
	
	//4.HOME PAGE BUTTON'S ACTION VERIFICATION
	public void homeButtonActions()
	{
		Actions actionObject=new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		JavascriptExecutor jseObject=(JavascriptExecutor) driver;
		
		//VERIFY ASG BATTERY
		wait.until(ExpectedConditions.elementToBeClickable(asgBattery));		
		asgBattery.click();
		actionObject.pause(Duration.ofMillis(1000)).perform();
		
		//SCROLL DOWN
		for (int i =0;i<16;i++) 
		{
	        jseObject.executeScript("window.scrollBy(0,100)", "");
	        actionObject.pause(Duration.ofMillis(1000)).perform();
	    }
		
		//REDIRECT TO THE HOME PAGE
		amaronLogo.click();
		
		//VERIFY AGM BATTERY
		wait.until(ExpectedConditions.elementToBeClickable(agmBattery));
		agmBattery.click();
		actionObject.pause(Duration.ofMillis(1000)).perform();
     
		//SCROLL DOWN
		for (int i =0;i<16;i++) 
		{
	        jseObject.executeScript("window.scrollBy(0,100)", "");
	        actionObject.pause(Duration.ofMillis(1000)).perform();
	    }
		
		//VERIFY DUPLICATION OF BLOGS LINKS
		blogsOfAmaronExperience.click();
		actionObject.pause(Duration.ofMillis(500)).perform();
		String amaronExperienceBlogs=driver.getTitle();

		//SCROLL TO THE BOTTOM OF THE PAGE
		jseObject.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    actionObject.pause(Duration.ofMillis(1000)).perform();
	    
	    blogsOfOthers.click();
		actionObject.pause(Duration.ofMillis(500)).perform();
		String othersBlogs=driver.getTitle();
		
		Assert.assertEquals(amaronExperienceBlogs,othersBlogs,"Duplicated Blogs links");
		System.out.println("Blogs page Title of the Amaron Experience link is "+amaronExperienceBlogs);
		System.out.println("Blogs page Title of the Others link is "+othersBlogs);

		//REDIRECT TO THE HOME PAGE
		amaronLogo.click();
		}
	
	//5.HOME PAGE APP STORE LINKS VERIFICATION
	public void homeAppStoreIcons()
	{
		//VERIFY GOOGLE PLAY STORE LINK
		JavascriptExecutor jseObject=(JavascriptExecutor) driver;
		jseObject.executeScript("window.scrollBy(0,100)", "");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		//googlePlayStore.click();
		Actions actionObject=new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(googlePlayStore));
		actionObject.moveToElement(appStore).click().perform();
		actionObject.pause(Duration.ofMillis(2000)).perform();
				
		//SWITCH TO NEW WINDOW THEN CLOSE IT
		ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		driver.close();

		driver.switchTo().window(windows.get(0));
				
		//VERIFY APPLE STORE LINK
		wait.until(ExpectedConditions.visibilityOf(appStore));
		//appStore.click();
		actionObject.moveToElement(appStore).click().perform();
		actionObject.pause(Duration.ofMillis(2000)).perform();
				
		//SWITCH TO NEW WINDOW THEN CLOSE IT
		windows = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		driver.close();
		driver.switchTo().window(windows.get(0));
	}
	//6.MOUSEOVER ON CONTACT MENU,THEN SELECT CITY BRANCH. SEND PRODUCT SERVICE QUERY.
		public void contactSendQueries(String name,String mobileNo,String email,String serviceNo,String serialNo) throws InterruptedException
		{
			Actions actionObject=new Actions(driver);
			
			//APPLY EXPLICIT WAIT
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(contactMenu));
			
	        //MOUSE OVER ON NAVIGATION MENU.
	        actionObject.moveToElement(contactMenu).perform();
	        actionObject.pause(Duration.ofMillis(500)).perform();

			//SELECT CONTACT MENU
			actionObject.click(contactMenu).perform();
			
			//SCROLL DOWN
			JavascriptExecutor jseObject=(JavascriptExecutor) driver;
			jseObject.executeScript("window.scrollBy(0,100)","");
			
			Select branch=new Select(selectBranch);
			branch.selectByVisibleText("Cochin");
			actionObject.pause(Duration.ofMillis(1000)).perform();
			
			jseObject.executeScript("window.scrollBy(0,600)","");
			
			//WAIT FOR SERVICE ELEMENT TO BE CLICKABLE
	        wait.until(ExpectedConditions.elementToBeClickable(service));

	        service.click();
	        actionObject.pause(Duration.ofMillis(500)).perform();

			Select query=new Select(queryType);
			query.selectByIndex(1);
			actionObject.pause(Duration.ofMillis(1000)).perform();
			
			//WAIT FOR SUB QUERY ELEMENT TO BE CLICKABLE
	        wait.until(ExpectedConditions.elementToBeClickable(subQueryType));

	        Select subQuery=new Select(subQueryType);
			subQuery.selectByVisibleText("Functionality");
			actionObject.pause(Duration.ofMillis(500)).perform();

			enterName.sendKeys(name);
			
			Select selectState=new Select(state);
			selectState.selectByIndex(17);
			actionObject.pause(Duration.ofMillis(1500)).perform();

			jseObject.executeScript("window.scrollBy(0,400)","");
			
			//WAIT FOR SUB QUERY ELEMENT TO BE CLICKABLE
	        wait.until(ExpectedConditions.elementToBeClickable(district));
//BELOW CODE TO BE CHECKED
			Select selectDistrict=new Select(district);
			selectDistrict.selectByValue("Kannur");
			actionObject.pause(Duration.ofMillis(1000)).perform();

			Select selectLocality=new Select(locality);
			selectLocality.selectByValue("Palayad S.O");
			actionObject.pause(Duration.ofMillis(500)).perform();

			Select selectPin=new Select(selectPincode);
			selectPin.selectByIndex(1);
			actionObject.pause(Duration.ofMillis(500)).perform();

			phoneNumber.sendKeys(mobileNo);
			actionObject.pause(Duration.ofMillis(500)).perform();

			jseObject.executeScript("window.scrollBy(0,100)","");
			
			getOTP.click();
			actionObject.pause(Duration.ofMillis(1000)).perform();
			
			validateOTP.click();
			actionObject.pause(Duration.ofMillis(500)).perform();

			emailAddress.sendKeys(email);
			actionObject.pause(Duration.ofMillis(500)).perform();

			serviceCallNo.sendKeys(serviceNo);
			actionObject.pause(Duration.ofMillis(500)).perform();

			productSN.sendKeys(serialNo);
			actionObject.pause(Duration.ofMillis(500)).perform();

			submitQuery.click();
			actionObject.pause(Duration.ofMillis(500)).perform();
		}
		
	//7.SELECT AMARON LOGO FROM AMARON EXPERIENCE MENU, THEN DOWNLOAD THE LOGO
	public void downloadAmaronLogo()
	{
		Actions actionObject=new Actions(driver);
		
		actionObject.moveToElement(experienceMenu).perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        
        actionObject.moveToElement(amaronLogoMenu).perform();
        actionObject.click(amaronLogoMenu).perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        
        //MOVE TO THE DOWNLOAD BUTTON AND THEN CLICK ON IT
        actionObject.moveToElement(downloadLogo).click().perform();
        actionObject.pause(Duration.ofMillis(500)).perform();
        
        //STORE PARENT WINDOW/TAB
        String parentWindow = driver.getWindowHandle();
        //STORE ALL THE OPENED WINDOW/TAB
		Set<String> windowHandles = driver.getWindowHandles();
		//SWITCH TO THE PREVIOUS WINDOW
		for (String handle : windowHandles) {
			actionObject.pause(Duration.ofMillis(1000)).perform();
		    if (!handle.equals(parentWindow)) 
		    {
		        driver.switchTo().window(handle);
		        driver.close();
		    }
		    driver.switchTo().window(parentWindow);
		}
	}
	
	//8.SEARCH PRODUCTS USING DATA DRIVEN
	public void searchFromExcel() throws IOException, InterruptedException 
	{
		String excelFilePath = "C:\\Users\\Aswinigfs\\Documents\\Software Testing\\Amaron Project\\searchProduct1.xlsx";
		FileInputStream excelSource=new FileInputStream(excelFilePath);
		XSSFWorkbook workbook = new XSSFWorkbook(excelSource);
	    XSSFSheet sheet = workbook.getSheet("Sheet1");
	        
	    int lastRow = sheet.getLastRowNum();
	    System.out.println("Last Row: " + lastRow);
	      
	    for(int i=1;i<=lastRow;i++) 
	    {
	    	String productName=sheet.getRow(i).getCell(0).getStringCellValue();
	       	System.out.println("Product Name: " +productName);
		
	        searchBar.sendKeys(productName,Keys.ENTER);
	       	Thread.sleep(200);
	       	
	       	searchBar.clear();
	    }
	        
		//TAKE PAGE SCREENSHOT OF SEARCH PAGE
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = "C:\\Users\\Aswinigfs\\Documents\\Software Testing\\Amaron Project\\Screenshots\\SearchResultPage3.jpeg";
        FileHandler.copy(src, new File(screenshotPath));
	}	
	
	public void selectBattery() throws InterruptedException
	{
		//CLICK ON ASG BATTERY
		asgBattery.click();
		
		Thread.sleep(2000);
		amaronLogo.click();
		
		//CLICK ON AGM BATTERY
		agmBattery.click();
		Thread.sleep(2000);
		
		amaronLogo.click();
	}
	
	//9.SELECT LOGIN/SIGNUP THEN SELECT SIGN UP
	public void signupNewUser(String mobileNumber,String captureOTP,String mailID,String setPassword) throws InterruptedException, IOException
	{
		//CLICK ON LOGIN/SIGNUP LINK
		loginsignupLink.click();
				
		//CLICK ON SIGN UP OPTION
		signupOption.click();
		
		//APPLY EXPLICIT WAIT
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(mobileSignup));
		
		//INPUT VALUES
		mobileSignup.sendKeys(mobileNumber);
		getOtpSignup.click();
		
		Thread.sleep(300);
		
		//otpSignup.sendKeys(captureOTP);
		emailidSignup.sendKeys(mailID);
		setpasswordSignup.sendKeys(setPassword);
		
		signupButton.click();
		Thread.sleep(500);
		
		//TAKE PAGE SCREENSHOT OF SEARCH PAGE
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = "C:\\Users\\Aswinigfs\\Documents\\Software Testing\\Amaron Project\\Screenshots\\SignUpError2.jpeg";
		FileHandler.copy(src, new File(screenshotPath));
	}
	
	//10.SELECT LOGIN/SIGNUP THEN SELECT LOGIN
	public void LoginUser(String mailID,String setPassword) throws InterruptedException
	{
		//CLICK ON LOGIN/SIGNUP LINK
		loginsignupLink.click();
		
		//APPLY EXPLICIT WAIT
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(loginOption));
		
		//CLICK ON LOGIN OPTION
		loginOption.click();
		
		//CLICK ON MAIL ID MENU
		mailidLoginMenu.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(emailIDLogin));
		
		//INPUT VALUES
		emailIDLogin.sendKeys(mailID);
		passwordLogin.sendKeys(setPassword);
		
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		
		loginButton.click();
		
		//APPLY EXPLICIT WAIT
		wait.until(ExpectedConditions.elementToBeClickable(amaronLogo));
        
        //REDIRECT TO HOME PAGE
		amaronLogo.click();
	}
	
	//11.SEARCH TWO WHEELER,CLICK ON THE FIRST LINK,SELECT VEHICLE MAKE,MODEL,FUEL THEN CLICK ON FIND NOW,SELECT PRODUCT
	public void searchTwoWheelerBattery(String searchText,String searchPincode) throws InterruptedException, IOException 
	{
		searchBar.sendKeys(searchText);
		searchButton.click();
		
		//SCROLL DOWN
		JavascriptExecutor jseObject=(JavascriptExecutor) driver;
		jseObject.executeScript("window.scrollBy(0,700)","");
		
		//APPLY EXPLICIT WAIT
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(twoWheelerLink));
		
		twoWheelerLink.click();
		
		//SCROLL DOWN
		jseObject.executeScript("window.scrollBy(0,300)","");
		
		Select v=new Select(vehicleMake);
		v.selectByValue("6804");
		
		Select m=new Select(vehicleModel);
		m.selectByVisibleText("Pulsar 180F Neon (ES)");
		
		Select f=new Select(vehicleFuel);
		f.selectByIndex(0);
		
		//APPLY EXPLICIT WAIT
		//wait.until(ExpectedConditions.elementToBeClickable(findNow));
		Thread.sleep(750);
		
		findNow.click();
		
		//APPLY EXPLICIT WAIT
		wait.until(ExpectedConditions.elementToBeClickable(selectBattery));

		selectBattery.click();
		
		pinCode.sendKeys(searchPincode);
		checkPincode.click();
		
		addToCart.click();
		
		goToCart.click();
		
		proceedToOrder.click();
		
		deliverHereAddress.click();
		
		completeOrder.click();
		
		//SCROLL UP TO VIEW THE ERROR MESSAGE
		jseObject.executeScript("window.scrollBy(0,0)","");
		
		//TAKE PAGE SCREENSHOT OF SEARCH PAGE
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//String screenshotPath = "C:\\Users\\Aswinigfs\\Documents\\Software Testing\\Amaron Project\\Screenshots\\CompleteOrder1.jpeg";
		String screenshotPath = "./Screenshot/CompleteOrder1.jpeg";
		FileHandler.copy(src, new File(screenshotPath));
	}
}