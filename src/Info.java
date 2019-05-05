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

public class Info extends Connection {
	public Info() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getNom() throws IOException {
		String cookie = String.join("\n", Files.readAllLines(Paths.get("temp\\cookie.txt")));

		Connection webpage = new Connection();
		WebDriver pagee = webpage.driver;
		pagee.get("https://www4.inscription.tn/ORegMx/servlet/AuthentificationEtud?Idsession=" + cookie
				+ "&action1=toCarteEtd");
		WebElement nomPos = pagee.findElement(By.xpath(
				"/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[2]/tbody[1]/tr[2]/td[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/p[1]"));
		String nom = nomPos.getAttribute("innerText");
		return nom;

	}

	public String getPrenom() throws IOException {

		String cookie = String.join("\n", Files.readAllLines(Paths.get("temp\\cookie.txt")));

		Connection webpage = new Connection();
		WebDriver pagee = webpage.driver;
		pagee.navigate().to("https://www4.inscription.tn/ORegMx/servlet/AuthentificationEtud?Idsession=" + cookie
				+ "&action1=toCarteEtd");
		String nomPos = pagee.findElement(By.xpath(
				"/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[2]/tbody[1]/tr[2]/td[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/p[1]"))
				.getAttribute("innerText");
		int iend = nomPos.indexOf(" ");

		if (iend < 0) {

			String[] text_arr = nomPos.split("\u00A0", iend);
			String A = text_arr[1].toLowerCase();
			String ACaps = A.toUpperCase().charAt(0) + A.substring(1, A.length());
			return ACaps;
		} else {
			String[] text_arr = nomPos.split(" ");

			String A = text_arr[1].toLowerCase();
			String ACaps = A.toUpperCase().charAt(0) + A.substring(1, A.length());
			return ACaps;
		}

	}

	public String getDep() throws IOException {
		String cookie = String.join("\n", Files.readAllLines(Paths.get("temp\\cookie.txt")));

		Connection webpage = new Connection();
		WebDriver pagee = webpage.driver;
		pagee.navigate().to("https://www4.inscription.tn/ORegMx/servlet/AuthentificationEtud?Idsession=" + cookie
				+ "&action1=toCarteEtd");
		WebElement depPos = pagee.findElement(By.xpath(
				"/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[2]/tbody[1]/tr[4]/td[1]/div[2]/div[1]/table[2]/tbody[1]/tr[5]/td[1]"));
		String dep = depPos.getAttribute("innerText");
		return dep;

	}

	public void getAllInfo() throws IOException {
		String cookie = String.join("\n", Files.readAllLines(Paths.get("temp\\cookie.txt")));

		Connection webpage = new Connection();
		WebDriver pagee = webpage.driver;
		pagee.navigate().to(
				"https://www4.inscription.tn/ORegMx/servlet/ServletInfoEtud?action=toInfoPerson&Idsession=" + cookie);

		// Get entire page screenshot
		WebElement taswira = driver.findElement(By.xpath(
				"/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[2]/tbody[1]/tr[2]/td[1]/div[1]"));
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
		File screenshotLocation = new File("temp\\info.png");
		try {
			FileUtils.copyFile(screenshot, screenshotLocation);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
