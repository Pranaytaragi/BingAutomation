package BingAction;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BingAction {
	WebDriver driver=setup();
	String baseUrl="https://www.bing.com/TRANSLATOR";
	
	public WebDriver setup()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\pranaytaragi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		return driver;
	}
	
	public void launchbrowser()
	{
		driver.get(baseUrl);
		
	}
	
	public void open_drop_down_list()
	{
		driver.get(baseUrl);
		driver.findElement(By.xpath("//div[@class='t_select']/..//select[@id='t_sl']")).click();
					
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)","");
		driver.findElement(By.xpath("//div[@class='t_select']/..//select[@id='t_tl']")).click();
	
	}
	
	public void select_language()
	{
		driver.get(baseUrl);
		driver.findElement(By.xpath("//div[@class='t_select']/..//select[@id='t_sl']/..//option[@value='hi']")).click();
		String s=driver.findElement(By.xpath("//div[@class='t_select']/..//select[@id='t_sl']/..//option[@value='hi']")).getText();
		
		driver.findElement(By.xpath("//div[@class='t_select']/..//select[@id='t_tl']/..//option[@value='de']")).click();
		String d=driver.findElement(By.xpath("//div[@class='t_select']/..//select[@id='t_tl']/..//option[@value='de']")).getText();
		Assert.assertTrue(s.contains("Hindi"));
		Assert.assertTrue(d.contains("German"));
		
	}
	
	public void translate_language() throws InterruptedException
	{
		driver.get(baseUrl);
		driver.findElement(By.xpath("//div[@class='t_select']/..//select[@id='t_sl']/..//option[@value='en']")).click();
		driver.findElement(By.xpath("//div[@class='t_select']/..//select[@id='t_tl']/..//option[@value='de']")).click();
		driver.findElement(By.xpath("//textarea[@id='t_sv']")).sendKeys("Hello");
		Thread.sleep(1000);
		String s = driver.findElement(By.xpath("//div[@id='t_txtoutblk']/textarea")).getAttribute("placeholder");

		Assert.assertTrue(s.contains("Translation"));

		
	}
	
	public void swap_language() throws InterruptedException
	{
		driver.get(baseUrl);
		driver.findElement(By.xpath("//div[@class='t_select']/..//select[@id='t_sl']/..//option[@value='en']")).click();
		driver.findElement(By.xpath("//div[@class='t_select']/..//select[@id='t_tl']/..//option[@value='de']")).click();
		driver.findElement(By.xpath("//textarea[@id='t_sv']")).sendKeys("Hello");
		Thread.sleep(2000);
		
		driver.manage().window().maximize() ;
		driver.findElement(By.xpath("//div[@class='t_spacer trtl_inline']/a")).click();
		
		
	}
	
	
	public void copy_button() throws InterruptedException
	{
		driver.get(baseUrl);
		driver.manage().window().maximize() ;
		driver.findElement(By.xpath("//div[@class='t_select']/..//select[@id='t_sl']/..//option[@value='en']")).click();
	    driver.findElement(By.xpath("//div[@class='t_select']/..//select[@id='t_tl']/..//option[@value='hi']")).click();
        driver.findElement(By.xpath("//textarea[@id='t_sv']")).sendKeys("Hello");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='t_output']/div/div/span/a")).click();
        String s=driver.findElement(By.xpath("//div[@class='t_output']/..//div[@class='t_outputCtrl']/div/span/span[@id='copy_result']")).getText();
	    Assert.assertTrue(s.contains("Copied!"));
	}
	
	public void clear_button()
	{
		driver.get(baseUrl);
		driver.findElement(By.xpath("//div[@class='t_select']/..//select[@id='t_sl']/..//option[@value='en']")).click();
		driver.findElement(By.xpath("//textarea[@id='t_sv']")).sendKeys("Hello");
		driver.findElement(By.xpath("//div[@class='t_inputexwrp']/a")).click();
		String s=driver.findElement(By.xpath("//div[@class='t_input']/div/div[@id='t_inptCtrlblk']/div/a[@id='t_edc']")).getAttribute("class");
		Assert.assertTrue(s.contains("b_hide"));
	}
	
	public void signin_button() throws InterruptedException
	{
		
		driver.get(baseUrl);

		Thread .sleep(1000);
		driver.findElement(By.xpath("//body/div/div[@id='theader']/div/div[@id='id_h']/a/span[@id='id_s']")).click();
		Thread .sleep(1000);
	
	}
	
	public void click_on_microsoft_button()
	{
		driver.get(baseUrl);
		driver.findElement(By.xpath("//img[@class='msmt_logo rms_img']")).click();
		String s=driver.findElement(By.xpath("//div[@class='theme-light js-global-head f-closed ']/div/a/span")).getText();
		Assert.assertTrue(s.contains("Microsoft"));
	}
	
	public void search_button()
	{
		driver.get(baseUrl);
		driver.findElement(By.id("sb_form_q")).sendKeys("java");
		driver.findElement(By.id("sb_form_q")).submit();
	}
	
	public void click_bing()
	{
		driver.get(baseUrl);
		driver.findElement(By.xpath("//div[@class='header_sbidentity ']/div/a")).click();
		
		String s=driver.findElement(By.xpath("//div[@class='hp_sw_logo hpcLogoWhite']")).getText();
		Assert.assertTrue(s.contains("Bing"));
	}
	
	public void feedback() throws InterruptedException
	{
		driver.get(baseUrl);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//footer[@id='b_footer']/div/ul/li/a[@id='sb_feedback']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='fbpgdg']"));
		driver.findElement(By.xpath("//div[@id='fbpgdg']/div[@id='fbctgrs']/div/div/input[@id='fbpgdgtp2']")).click();
		driver.findElement(By.xpath("//div[@id='fbvrbtm']//textarea")).sendKeys("Good!!");
		driver.findElement(By.xpath("//div[@class='button step1 hlig']/a[@id='fbpgdgsbbt']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='fbpgdg']"));
		String s=driver.findElement(By.xpath("//div[@id='fbpgdg']/div[@id='fbthnk']/h2")).getText();
		Assert.assertTrue(s.contains("Thank you!"));
		driver.findElement(By.xpath("//div[@class='button step2 hlig']/a")).click();

		
	}
	
	public void select_the_last_and_second_last_language()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		driver.get(baseUrl);
		driver.findElement(By.xpath("//div[@class='t_select']/..//select[@id='t_sl']")).click();
		WebElement element=driver.findElement(By.xpath("//div[@class='t_select']/..//select[@id='t_sl']/..//option[@value='yua']"));
		js.executeScript("arguments[0].scrollIntoView(true);",element);
		driver.findElement(By.xpath("//div[@class='t_select']/..//select[@id='t_sl']/..//option[@value='yua']")).click();			
		
		js.executeScript("window.scrollBy(0,250)","");
		driver.findElement(By.xpath("//div[@class='t_select']/..//select[@id='t_tl']")).click();
		element=driver.findElement(By.xpath("//div[@class='t_select']/..//select[@id='t_tl']/..//option[@value='hi']"));
		js.executeScript("arguments[0].scrollIntoView(true);",element);
		driver.findElement(By.xpath("//div[@class='t_select']/..//select[@id='t_tl']/..//option[@value='cy']")).click();	
		String s=driver.findElement(By.xpath("//div[@class='t_select']/..//select[@id='t_sl']/..//option[@value='yua']")).getText();
	    String d=driver.findElement(By.xpath("//div[@class='t_select']/..//select[@id='t_tl']/..//option[@value='cy']")).getText();
	    Assert.assertTrue(s.contains("Yucatec Maya"));
	    Assert.assertTrue(d.contains("Welsh"));
	}
	
	public void click_on_audio_button() throws InterruptedException
	{
		driver.get(baseUrl);
		driver.findElement(By.xpath("//div[@class='t_select']/..//select[@id='t_sl']/..//option[@value='en']")).click();
		driver.findElement(By.xpath("//div[@class='t_select']/..//select[@id='t_tl']/..//option[@value='de']")).click();
		driver.findElement(By.xpath("//textarea[@id='t_sv']")).sendKeys("Hello");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[@id='t_inptCtrlblk']"));
		driver.findElement(By.xpath("//div[@id='t_inptCtrlblk']/div/a[@id='t_srcplaycIcon']")).click();
		String s=driver.findElement(By.xpath("//a[@id='t_srcplaycIcon']")).getAttribute("class");
		System.out.println(s);
		Assert.assertTrue(s.contains("audio"));
		
		
	}
	
	
	
}
