import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class InfoEtd extends JFrame {

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
					InfoEtd frame = new InfoEtd();
					frame.setVisible(true);
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
	public InfoEtd() throws IOException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 630, 755);
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
		Info a = new Info();
		a.getAllInfo();
		JLabel infoCap = new JLabel("");
		ImageIcon img = new ImageIcon("temp\\info.png");
		img.getImage().flush();
		infoCap.setIcon(img);
		infoCap.setBounds(-13, 0, 639, 718);
		contentPane.add(infoCap);
	}

}
