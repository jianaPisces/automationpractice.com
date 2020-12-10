package PageObjectsUtils;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	public static void main(String[] args) {
		String test = "Color : Orange, Size : S";
		String[] txt = test.split(", ")[0].split(" : ");
		System.out.println(txt[1]);
	}
	
	public static String getProjectPath() {
		String projectPath = System.getProperty("user.dir");
//		System.out.println(projectPath);
		return projectPath;
	}

	public static void takeSnapShot(WebDriver driver, String fileWithPath) throws Exception {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(fileWithPath);
		if(!DestFile.canWrite())
	        DestFile.setWritable(true);
		FileUtils.copyFile(SrcFile, DestFile);
	}
	
	public static String getFileTime() {
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter fd = DateTimeFormatter.ofPattern("yyyyMMMddHHmm");
		String fileDate = fd.format(date);
		return fileDate;	
	}
	
	public static String getErrorFileName() {
		return getProjectPath()
				+ "/target/ScreenShot/error" + getFileTime()
				+ ".png";
	}
	
	public static String setFileName(String name) {
		return getProjectPath()
				+ "/target/ScreenShot/" + name
				+ ".png";
	}

}
