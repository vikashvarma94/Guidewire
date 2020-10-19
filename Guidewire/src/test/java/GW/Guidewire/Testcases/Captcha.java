package GW.Guidewire.Testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import GW.Guidewire.base.baseclass;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Captcha extends baseclass {
  @Test
  public void f() throws IOException, TesseractException {
	  driver.manage().window().maximize();
	  driver.get("https://www.irctc.co.in/nget/train-search");
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  
	  driver.findElement(By.xpath("//button[contains(text(),\"Ok\")]")).click();
	  
	  driver.findElement(By.xpath("//div/a/i")).click();
	  driver.findElement(By.xpath("//button[contains(text(),\"LOGIN\")]")).click();
	  
	  File f = driver.findElement(By.xpath("(//div/div/div/div/div/div)[15]")).getScreenshotAs(OutputType.FILE);
	
	  String path=System.getProperty("user.dir")+"//Scren Shorts/cap.png";
		
		File destination=new File(path);
		FileUtils.copyFile(f, destination);
	  
	  ITesseract captcha = new Tesseract();
	  System.out.println(destination);
	  String captcha_text = captcha.doOCR(destination);
	  System.out.println("test");
	  System.out.println(captcha_text);
  }
}
