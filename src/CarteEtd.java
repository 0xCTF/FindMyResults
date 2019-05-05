import java.awt.EventQueue;
import java.io.IOException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class CarteEtd extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarteEtd frame = new CarteEtd();
					frame.setVisible(true);
					ImageIcon img = new ImageIcon(Connection.class.getResource("/images/logo.ico"));
					frame.setIconImage(img.getImage());

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public CarteEtd() throws IOException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 670, 460);
		try {
            URL resource = this.getClass().getResource("/images/icon.png");
            BufferedImage image = ImageIO.read(resource);
            this.setIconImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }	
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		java.awt.Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		CarteEtdInfo c = new CarteEtdInfo();
		c.captCarte();

		JLabel carteCap = new JLabel("");
		ImageIcon img = new ImageIcon("temp\\carte.png");
		img.getImage().flush();
		carteCap.setIcon(img);
		carteCap.setBounds(117, 22, 527, 390);
		contentPane.add(carteCap);
		contentPane.setOpaque(false);
		contentPane.repaint();
		JLabel lblNewLabel_1 = new JLabel("Votre carte \u00E9tudiant:");
		lblNewLabel_1.setFont(new Font("GeForce", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(235, 11, 275, 31);
		contentPane.add(lblNewLabel_1);

	}
}
