import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CarteEtdInfo extends Connection {
	private static final long serialVersionUID = 1L;

	public CarteEtdInfo() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void photoProfile() throws IOException {

		String cookie = String.join("\n", Files.readAllLines(Paths.get("temp\\cookie.txt")));

		Connection webpage = new Connection();
		WebDriver pagee = webpage.driver;
		pagee.get("https://www4.inscription.tn/ORegMx/servlet/AuthentificationEtud?Idsession=" + cookie
				+ "&action1=toCarteEtd");

		// Get entire page screenshot
		String Url = driver.findElement(By.xpath("//img[@class='photo']")).getAttribute("src");
		String url2 = Url.replace("https://www2", "");
		String substring = "https://www2";
		if (Url.contains(substring)) {
			String url21 = Url.replace("https://www2", "");
			String FinalUrl = "https://www4" + url21;
			WebDriver page = webpage.driver;
			page.get(FinalUrl);
		}
		WebDriver page = webpage.driver;
		page.get(Url);
		WebElement avatarImg = driver.findElement(By.cssSelector("body > img"));

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage fullImg = null;
		try {
			fullImg = ImageIO.read(screenshot);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Get the location of element on the page
		org.openqa.selenium.Point point = avatarImg.getLocation();

		// Get width and height of the element
		int eleWidth = avatarImg.getSize().getWidth();
		int eleHeight = avatarImg.getSize().getHeight();

		// Crop the entire page screenshot to get only element screenshot
		BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
		try {
			ImageIO.write(eleScreenshot, "png", screenshot);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Copy the element screenshot to disk
		File screenshotLocation = new File("temp\\avatar.png");
		try {
			FileUtils.copyFile(screenshot, screenshotLocation);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void captCarte() throws IOException {
		String cookie = String.join("\n", Files.readAllLines(Paths.get("temp\\cookie.txt")));

		Connection webpage = new Connection();
		WebDriver pagee = webpage.driver;
		pagee.get("https://www4.inscription.tn/ORegMx/servlet/AuthentificationEtud?Idsession=" + cookie
				+ "&action1=toCarteEtd");

		// Get entire page screenshot
		WebElement taswira = driver.findElement(By.xpath(
				"	/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[2]/tbody[1]/tr[4]/td[1]/div[2]/div[1]\r\n"
						+ ""));
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage fullImg = null;
		try {
			fullImg = ImageIO.read(screenshot);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Get the location of element on the page
		org.openqa.selenium.Point point = taswira.getLocation();

		// Get width and height of the element
		int eleWidth = taswira.getSize().getWidth();
		int eleHeight = taswira.getSize().getHeight();

		// Crop the entire page screenshot to get only element screenshot
		BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
		try {
			ImageIO.write(eleScreenshot, "png", screenshot);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Copy the element screenshot to disk
		File screenshotLocation = new File("temp\\carte.png");
		try {
			FileUtils.copyFile(screenshot, screenshotLocation);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
