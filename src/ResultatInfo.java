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

public class ResultatInfo extends Connection {
	private static final long serialVersionUID = 1L;

	public ResultatInfo() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void NbrRes() throws IOException {
		String cookie = String.join("\n", Files.readAllLines(Paths.get("temp\\cookie.txt")));

		Connection webpage = new Connection();
		WebDriver pagee = webpage.driver;
		pagee.navigate()
				.to("https://www4.inscription.tn/ORegMx/servlet/ServletResultatEtudiant?action=goResultat&Idsession="
						+ cookie);
		WebElement rez = driver.findElement(By.xpath(
				"/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[3]/td[1]"));
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage fullImg = null;
		try {
			fullImg = ImageIO.read(screenshot);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Get the location of element on the page
		org.openqa.selenium.Point point = rez.getLocation();

		// Get width and height of the element
		int eleWidth = rez.getSize().getWidth();
		int eleHeight = rez.getSize().getHeight();

		// Crop the entire page screenshot to get only element screenshot
		BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
		try {
			ImageIO.write(eleScreenshot, "png", screenshot);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Copy the element screenshot to disk
		File screenshotLocation = new File("temp\\nbrRes.png");
		try {
			FileUtils.copyFile(screenshot, screenshotLocation);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Res1Sem() throws IOException {
		String cookie = String.join("\n", Files.readAllLines(Paths.get("temp\\cookie.txt")));

		Connection webpage = new Connection();
		WebDriver pagee = webpage.driver;
		pagee.navigate()
				.to("https://www4.inscription.tn/ORegMx/servlet/ServletResultatEtudiant?action=goResultat&Idsession="
						+ cookie);
		WebElement rez = pagee.findElement(By.xpath(
				"//a[starts-with(@href, '/ORegMx/servlet/ServletResultatEtudiant?action=voirResultatEtudiant&Idsession=')]"));
		String res = rez.getAttribute("href");
		pagee.navigate().to(res);
		WebElement fullRes = driver.findElement(By.xpath(
				"/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[3]/td[1]"));

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage fullImg = null;
		try {
			fullImg = ImageIO.read(screenshot);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Get the location of element on the page
		org.openqa.selenium.Point point = fullRes.getLocation();

		// Get width and height of the element
		int eleWidth = fullRes.getSize().getWidth();
		int eleHeight = fullRes.getSize().getHeight();

		// Crop the entire page screenshot to get only element screenshot
		BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
		try {
			ImageIO.write(eleScreenshot, "png", screenshot);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Copy the element screenshot to disk
		File screenshotLocation = new File("temp\\res1Sem.png");
		try {
			FileUtils.copyFile(screenshot, screenshotLocation);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
