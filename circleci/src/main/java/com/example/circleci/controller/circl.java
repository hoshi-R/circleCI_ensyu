package com.example.circleci.controller;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class circl {
  public static void main(String[] args) {
    
    try {
			System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://www.google.com/");
      File sfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      Date date = new Date();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy'年'MM'月'dd'日'E'曜日'k'時'mm'分'ss'秒'");
      try {
        Files.copy(sfile.toPath(), new File("保存先" + "スクリーンキャプチャ" + sdf.format(date) + ".png").toPath());					
      } catch (Exception e) {
      }
      System.out.println(sfile);
      Thread.sleep(2000);
      driver.quit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    
  }
  
}
