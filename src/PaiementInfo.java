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

class PaiementInfo extends Connection {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PaiementInfo() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void id() throws IOException {

		String sess = String.join("\n", Files.readAllLines(Paths.get("temp\\cookie.txt")));

		Connection dd = new Connection();
		WebDriver driver = dd.driver;
		driver.navigate().to("https://www4.inscription.tn/ORegMx/ListeInscriptions.jsp?Idsession=" + sess);

		// Get entire page screenshot
		WebElement ele = driver.findElement(By.xpath(
				"/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[2]/tbody[1]/tr[1]/td[1]/table[1]"));
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage fullImg = null;
		try {
			fullImg = ImageIO.read(screenshot);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Get the location of element on the page
		org.openqa.selenium.Point point = ele.getLocation();

		// Get width and height of the element
		int eleWidth = ele.getSize().getWidth();
		int eleHeight = ele.getSize().getHeight();

		// Crop the entire page screenshot to get only element screenshot
		BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
		try {
			ImageIO.write(eleScreenshot, "png", screenshot);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Copy the element screenshot to disk
		File screenshotLocation = new File("temp\\pay.png");
		try {
			FileUtils.copyFile(screenshot, screenshotLocation);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
