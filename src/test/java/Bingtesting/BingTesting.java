package Bingtesting;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BingAction.BingAction;

public class BingTesting {
	BingAction bing=new BingAction();
	@BeforeClass
	public void launchBrowser()
	{
		bing.launchbrowser();
		
	}
	@Test
	public void Test01_user_able_to_open_drop_down_list()
	{
		bing.open_drop_down_list();
	}
	@Test
	public void Test02_user_able_to_select_language()
	{
		bing.select_language();
	}
	@Test
	public void Test03_Translate_language() throws InterruptedException
	{
		bing.translate_language();
	}
	@Test
	public void Test04_swap_language() throws InterruptedException
	{
		bing.swap_language();
	}
	@Test
	public void Test05_select_last_and_secondlast_language()
	{
		bing.select_the_last_and_second_last_language();
	}

	@Test
	public void Test06_clear_button()
	{
		bing.clear_button();
	}
	@Test
	public void Test07_click_on_audio_button() throws InterruptedException
	{
		bing.click_on_audio_button();
	}
	@Test
	public void Test08_click_on_copy_button() throws InterruptedException
	{
		bing.copy_button();
	}
	@Test
	public void Test09_feedback() throws InterruptedException
	{
		bing.feedback();
	}
	@Test
	public void Test10_click_on_signin_button() throws InterruptedException
	{
		bing.signin_button();
	}
	@Test
	public void Test11_click_on_bing()
	{
		bing.click_bing();
	}
	
	
	@Test
	public void Test12_user_able_to_click_on_microsoft_button()
	{
		bing.click_on_microsoft_button();
	}

	@Test
	public void Test13_user_able_to_search()
	{
		bing.search_button();
	}	

	

}
