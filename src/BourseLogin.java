import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;

public class BourseLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField sec;

	static WebDriver oous = new PhantomJSDriver();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BourseLogin frame = new BourseLogin();

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public BourseLogin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 323, 115);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		java.awt.Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		try {
            URL resource = this.getClass().getResource("/images/icon.png");
            BufferedImage image = ImageIO.read(resource);
            this.setIconImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }	
		oous.manage().window().maximize();
		String url = "http://www.oous.rnu.tn/PackOffice/esp_etud/loginserv.php?d=b";

		oous.get(url);
		WebElement ele = oous.findElement(By.xpath("//img[@src='img.php']"));

		oous.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		// Get entire page screenshot
		File screenshot = ((TakesScreenshot) oous).getScreenshotAs(OutputType.FILE);
		BufferedImage fullImg = null;
		try {
			fullImg = ImageIO.read(screenshot);
		} catch (IOException e11) {
			// TODO Auto-generated catch block
			e11.printStackTrace();
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
		} catch (IOException e111) {
			// TODO Auto-generated catch block
			e111.printStackTrace();
		}

		// Copy the element screenshot to disk
		File screenshotLocation = new File("temp\\oousCaptcha.png");
		try {
			FileUtils.copyFile(screenshot, screenshotLocation);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JLabel lblNewLabel = new JLabel("");

		ImageIcon img = new ImageIcon("temp\\\\oousCaptcha.png");
		img.getImage().flush();
		lblNewLabel.setIcon(img);

		lblNewLabel.setBounds(10, 23, 79, 37);
		contentPane.add(lblNewLabel);

		sec = new JTextField();
		sec.setBounds(99, 23, 94, 37);
		contentPane.add(sec);
		sec.setColumns(10);

		JButton btnNewButton = new JButton("Valider");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// JButton btnNewButton = new JButton("Button 2");
				// btnNewButton.addActionListener(e -> System.out.println("Button 2 action
				// fired"));

				String cin = null;
				try {
					cin = String.join("\n", Files.readAllLines(Paths.get("temp\\cin.txt")));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				WebElement cin1 = oous.findElement(By.name("cin"));
				WebElement cap = oous.findElement(By.name("captcha"));
				String capp = sec.getText();

				cin1.sendKeys(cin);
				cap.sendKeys(capp);
				cap.submit();

				// oous.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

				String title = oous.getTitle();
				if (title.equals("نتائج دراسة ملفات المنح الجامعية")) {
					WebElement ele2 = oous
							.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]"));
					System.out.println(title);
					oous.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
					// Get entire page screenshot
					File screenshot1 = ((TakesScreenshot) oous).getScreenshotAs(OutputType.FILE);
					BufferedImage fullImg1 = null;
					try {
						fullImg1 = ImageIO.read(screenshot1);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					// Get the location of element on the page
					org.openqa.selenium.Point point1 = ele2.getLocation();

					// Get width and height of the element
					int eleWidth1 = ele2.getSize().getWidth();
					int eleHeight1 = ele2.getSize().getHeight();
					// eleWidth1=eleWidth1+100;
					// Crop the entire page screenshot to get only element screenshot
					BufferedImage eleScreenshot1 = fullImg1.getSubimage(point1.getX(), point1.getY(), eleWidth1,
							eleHeight1);
					try {
						ImageIO.write(eleScreenshot1, "png", screenshot1);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					// Copy the element screenshot to disk
					File screenshotLocation1 = new File("temp\\bourse.png");
					try {
						FileUtils.copyFile(screenshot1, screenshotLocation1);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();

					}

					dispose();
					Bourse wind = new Bourse();
					wind.setVisible(true);

				} else {

					WebElement msg = oous.findElement(By.xpath(
							"/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/center[1]/div[3]/strong[1]"));
					String name = msg.getAttribute("innerText");
					JOptionPane.showMessageDialog(null, name, "error", JOptionPane.INFORMATION_MESSAGE);
					String url = "http://www.oous.rnu.tn/PackOffice/esp_etud/loginserv.php?d=b";

					oous.get(url);

					WebElement ele1 = oous.findElement(By.xpath("//img[@src='img.php']"));

					oous.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
					// Get entire page screenshot
					File screenshot1 = ((TakesScreenshot) oous).getScreenshotAs(OutputType.FILE);
					BufferedImage fullImg1 = null;
					try {
						fullImg1 = ImageIO.read(screenshot1);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					// Get the location of element on the page
					org.openqa.selenium.Point point1 = ele1.getLocation();

					// Get width and height of the element
					int eleWidth1 = ele1.getSize().getWidth();
					int eleHeight1 = ele1.getSize().getHeight();

					// Crop the entire page screenshot to get only element screenshot
					BufferedImage eleScreenshot1 = fullImg1.getSubimage(point1.getX(), point1.getY(), eleWidth1,
							eleHeight1);
					try {
						ImageIO.write(eleScreenshot1, "png", screenshot1);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					// Copy the element screenshot to disk
					File screenshotLocation1 = new File("temp\\oousCaptcha.png");

					try {
						FileUtils.copyFile(screenshot1, screenshotLocation1);

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					ImageIcon img = new ImageIcon("temp\\\\oousCaptcha.png");
					img.getImage().flush();
					lblNewLabel.setIcon(img);
				}

			}
		});

		btnNewButton.setBounds(203, 28, 99, 32);
		contentPane.add(btnNewButton);

	}
}
