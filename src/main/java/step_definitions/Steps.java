package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class Steps {

    WebDriver driver;

    @Given("^Open the chrome and launch the application$")
    public void Open_the_chrome_and_launch_the_application() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
//        System.out.println("This step Open the chrome and launch the application");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa.cilsy.id:31300/id/");
    }

    @And("^Click Login$")
    public void click_login() {
        System.out.println("This step click login");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/a/span")).click();
    }

    @When("^Input email address$")
    public void input_email_address(Map<String,String> inputEmail) {
        System.out.println("This step input email address");
        String actual = driver.getCurrentUrl();
        Assert.assertEquals("url is valid","http://qa.cilsy.id:31300/id/login?back=my-account",actual);
        driver.findElement(By.id("email_create")).sendKeys((inputEmail.get("email")));
    }

    @And("^Click create an account$")
    public void click_create_an_account() {
        System.out.println("This step click create an account");
        driver.findElement(By.id("SubmitCreate")).click();
    }

    @And("^user fill data$")
    public void user_fill_data() {
        System.out.println("This step user fill data");
        WebDriverWait wait = new WebDriverWait(driver, 70000);
//        driver.findElement(By.id("id_gender2")).isSelected();
        WebElement select1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"id_gender2\"]")));
        select1.click();
        WebElement FirstName = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("customer_firstname")));
        FirstName.sendKeys("Resa");
        WebElement LastName = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("customer_lastname")));
        LastName.sendKeys("NS");
        WebElement Password = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("passwd")));
        Password.sendKeys("123456");
        // select date
        Select xSelect = new Select(driver.findElement(By.id("days")));
        xSelect.selectByValue("30");
        // select months
        Select xSelect1 = new Select(driver.findElement(By.id("months")));
        xSelect1.selectByValue("4");
        // select years
        Select xSelect2 = new Select(driver.findElement(By.id("years")));
        xSelect2.selectByValue("1994");
        // click checkbox
        WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"newsletter\"]"));
        checkbox.click();
    }

    @And("^user click button register$")
    public void user_click_button_register() {
        System.out.println("This step click button register");
        WebElement Button_Register = driver.findElement(By.id("submitAccount"));
        Button_Register.click();
    }

    @Then("^Verify page url$")
    public void verify_page_url() throws InterruptedException {
        System.out.println("This step verify page url");
        //-- verify page
        Thread.sleep(3000);
        String actual = driver.getCurrentUrl();
        Assert.assertEquals("url is valid","http://qa.cilsy.id:31300/id/login?back=my-account#account-creation",actual);
    }

    @Given("^Open the chrome and launch the app$")
    public void Open_the_chrome_and_launch_the_app() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        System.out.println("This step Open the chrome and launch the application");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa.cilsy.id:31300/id/");
    }

    @And("^click header login$")
    public void click_header_login() {
        System.out.println("This step click header login");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/a/span")).click();
    }

    @When("^user fill email dan password$")
    public void user_fill_email_dan_password() {
        System.out.println("This step fill email and password");
        WebDriverWait wait = new WebDriverWait(driver, 70000);
        WebElement Email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
        Email.sendKeys("resanirmaya21@gmail.com");
        WebElement Password = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("passwd")));
        Password.sendKeys("123456");
    }

    @Then("^click button sign in$")
    public void click_button_sign_in() {
        System.out.println("This step click button sign in");
        driver.findElement(By.id("SubmitLogin")).click();
    }

    @And("^click add my first address$")
    public void click_add_my_first_address() {
        System.out.println("This step click add my first address");
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/ul/li[1]/a/span")).click();
    }

    @And("^fill a new address$")
    public void fill_a_new_address() {
        System.out.println("This step fill a new address");
        WebDriverWait wait = new WebDriverWait(driver, 70000);
        WebElement Address = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("address1")));
        Address.sendKeys("padang, sumatera barat");
        WebElement Postalcode = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("postcode")));
        Postalcode.sendKeys("25673");
        WebElement City = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("city")));
        City.sendKeys("padang");
        Select State = new Select(driver.findElement(By.id("id_state")));
        State.selectByValue("264");
        WebElement MobilePhone = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("phone_mobile")));
        MobilePhone.sendKeys("081234567890");
        driver.findElement(By.id("submitAddress")).click();
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[12]/a[1]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/a/span")).click();
        if( driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div")).isDisplayed()){
            System.out.println("Element is Visible");
        }else{
            System.out.println("Element is InVisible");
        }
    }

    @Given("^Open the chrome and launch website$")
    public void open_the_chrome_and_launch_website() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        System.out.println("This step Open the chrome and launch website");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa.cilsy.id:31300/id/");
    }

    @And("^user fill booking date$")
    public void user_fill_booking_date() throws InterruptedException {
        System.out.println("This step user fill booking date");
        Thread.sleep(3000);
        driver.findElement(By.id("hotel_location")).sendKeys("Jakarta");
        driver.findElement(By.id("id_hotel_button")).click();
        WebElement DropdownButton = driver.findElement(By.xpath("//*[@id=\"search_hotel_block_form\"]/div[2]/div/ul/li"));
        DropdownButton.click();
        driver.findElement(By.xpath("//*[@id=\"check_in_time\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[6]")).click();
        driver.findElement(By.xpath("//*[@id=\"check_out_time\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[6]/td[1]")).click();
    }

    @When("^click button search now$")
    public void click_button_search_now() {
        System.out.println("This step click button search now");
        driver.findElement(By.id("search_room_submit")).click();
    }

    @And("^system direct to page search room$")
    public void system_direct_to_page_search_room() {
        System.out.println("This step system direct to page search room");
        String actual = driver.getCurrentUrl();
        Assert.assertEquals("url is valid","http://qa.cilsy.id:31300/id/6-the-hotel-prime?date_from=2021-10-29&date_to=2021-10-31",actual);
    }

    @And("^user choose one of rooms$")
    public void user_choose_one_of_rooms() {
        System.out.println("This step user choose one of rooms");
        driver.findElement(By.xpath("//*[@id=\"category_data_cont\"]/div[1]/div/div[2]/a/span")).click();
        if( driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/h2/span[1]")).isDisplayed()){
            System.out.println("Element is Visible");
        }else{
            System.out.println("Element is InVisible");
        }
        driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")).click();
        driver.findElement(By.xpath("//*[@id=\"collapse-shopping-cart\"]/div/div[2]/div[2]/div/a/span")).click();
    }

    @And("^fill data guest information$")
    public void fill_data_guest_information() throws InterruptedException {
        System.out.println("This step fill data guest information");
        Select xSelect = new Select(driver.findElement(By.id("id_gender")));
        xSelect.selectByValue("2");
        driver.findElement(By.id("customer_firstname")).sendKeys("Sakura");
        driver.findElement(By.id("customer_lastname")).sendKeys("Jimamai");
        driver.findElement(By.id("email")).sendKeys("sakurajimamai@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("123456");
        driver.findElement(By.id("phone_mobile")).sendKeys("082339760376");
    }

    @And("^click button submit$")
    public void click_button_submit() {
        System.out.println("This step click button submit");
        driver.findElement(By.xpath("//*[@id=\"submitAccount\"]")).click();
    }

    @Then("^Process payment booking room$")
    public void process_payment_booking_room() throws InterruptedException {
        System.out.println("This step Process payment booking room");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"collapse-guest-info\"]/div/div[4]/div/a")).click();
        WebElement checkbox = driver.findElement(By.id("cgv"));
        checkbox.click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span")).click();
    }

//    WebElement allert = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div"));
////    WebElement otcBtn = driver.findElement(By.className("icon-otc"));
////    WebElement herbBtn = driver.findElement(By.className("icon-herb"));
//
//    Assert.assertEquals(true, rxBtn.isDisplayed());
////    Assert.assertEquals(true, otcBtn.isDisplayed());
////    Assert.assertEquals(true, herbBtn.isDisplayed());
}
