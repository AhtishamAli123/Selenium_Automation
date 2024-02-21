package air_sial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;




public class Bookong_Tickets {

    static WebDriver driver;

    

    public static void main(String[] args) {
        String driverPath = "chromedriver.exe";
        driver = new ChromeDriver();
        

        String baseUrl = "https://www.airsial.com/";
        driver.get(baseUrl);

        System.out.println("launching the AirSial Limited");
        System.setProperty("webdriver.chrome.driver", driverPath);

        try { 
            selectOrigin("LAHORE");
            selectDestination("MADINAH");
            selectDepartureDate("31-01-2024");
            selectOneWay();
            selectRoundTrip();
            selectReturnDate("2-2-2024");
            selectPassengerDetails(3, 1, 1);
            searchBookFlight();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Uncomment the line below if you want to close the browser after execution
//             driver.quit();
        }
    }

    private static void selectOrigin(String originText) {
        WebElement origin = findElement(By.cssSelector("#building_search > form > div.go-left > div:nth-child(1) > select"));
        Select dropdown = new Select(origin);
        dropdown.selectByVisibleText(originText);
        origin.click();
    }

    private static void selectDestination(String destinationText) {
        WebElement destination = findElement(By.name("destination"));
        Select dropdown = new Select(destination);
        dropdown.selectByVisibleText(destinationText);
        destination.click();
    }

    private static void selectDepartureDate(String date) {
        WebElement depDate = findElement(By.id("dpDate"));
        depDate.click();
        //Select Year
        WebElement DepYear = driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/thead/tr[1]/th[2]"));
        DepYear.click();
        
       
       
        //Select MOnth
        WebElement DepMonth = driver.findElement(By.xpath("/html/body/div[3]/div[2]/table/tbody/tr/td/span[1]"));
        DepMonth.click();
        
        
        //Select Day
        WebElement Depday = driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/tbody/tr[5]/td[4]"));
        Depday.click();
        selectDate(date);
    }
    
    private static void selectOneWay() {
    	WebElement oneWayTrip = driver.findElement(By.xpath("//input[@type=\"radio\" and @name=\"tripType\" and @value = \"one\"]"));
        oneWayTrip.click();
    }
    
    private static void  selectRoundTrip() {
    	WebElement RoundTrip = driver.findElement(By.xpath("//input[@type=\"radio\" and @name=\"tripType\" and @value = \"round\"]"));
        RoundTrip.click();
    }

    private static void selectReturnDate(String date) throws InterruptedException {
    	 //Return DATE
        
//        
        WebElement cal_2 = driver.findElement(By.xpath("//input[@name='returnDate']"));
        cal_2.click();
//        
//      
//        //Select Year
        WebElement RetYear = driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/thead/tr[1]/th[2]"));
        RetYear.click();
        Thread.sleep(3000);//        
//       
//       
//        //Select MOnth
        WebElement RetMonth = driver.findElement(By.xpath("/html/body/div[3]/div[2]/table/tbody/tr/td/span[2]"));
        RetMonth.click();
//        
//        
//        //Select Day
        WebElement Retday = driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/tbody/tr[1]/td[6]"));
        Retday.click();
        
        selectDate(date);
    }

    private static void selectDate(String date) {
        // Implement the logic to select the date
        // Parse the date and interact with the date picker
    }

    
    private static void selectPassengerDetails(int adultCount, int childCount, int infantCount) {
        WebElement passenger = findElement(By.xpath("//div[@class='col-md-10 p-3 m-auto container']"));
        passenger.click();

        WebElement addAdult = findElement(By.xpath("//div[@onclick=\"inc('.adult','+')\"]"));
        WebElement addChild = findElement(By.xpath("//div[@onclick=\"inc('.child','+')\"]"));
        WebElement addInfant = findElement(By.xpath("//div[@onclick=\"inc('.infant','+')\"]"));

        for (int i = 0; i < adultCount; i++) {
            addAdult.click();
        }

        for (int i = 0; i < childCount; i++) {
            addChild.click();
        }

        for (int i = 0; i < infantCount; i++) {
            addInfant.click();
        }

        WebElement closePassengerTab = findElement(By.xpath("//ib[@class='fa fa-times']"));
        closePassengerTab.click();
    }

    private static void searchBookFlight() {
        WebElement searchBookFlight = findElement(By.xpath("//*[@id=\"building_search\"]/form/div[2]/div[3]/button"));
        searchBookFlight.click();
    }

    private static WebElement findElement(By by) {
        return driver.findElement(by);
    }
}