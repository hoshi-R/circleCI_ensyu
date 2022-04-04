package com.example.circleci;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CircleciApplicationTests {

	@Test
	void contextLoads() {
		try {
			System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://www.google.com/");
      File sfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      Date date = new Date();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy'/'MM'/'dd'/'E'/'k'/'mm'/'ss'/'");
      try {
        Files.copy(sfile.toPath(), new File(sdf.format(date) + ".png").toPath());
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
