package com.tests;

import org.testng.annotations.BeforeMethod;

import com.pages.FooterPage;


public class FooterTest extends TestBase {
	FooterPage footerpage;


	public FooterTest(){
		super();
	}
	
	@BeforeMethod
	public void Setup()
	{
		//initDriver();
		footerpage=new FooterPage(driver);
		driver.get("https://realtyassistant.in/"); 
	}
}
