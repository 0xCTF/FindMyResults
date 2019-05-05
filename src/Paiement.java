import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Paiement extends JFrame {

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
					Paiement frame = new Paiement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/*
	 * public class forDriver extends Login {
	 * 
	 * 
	 * 
	 * }
	 */

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public Paiement() throws IOException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 874, 200);
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

		PaiementInfo id = new PaiementInfo();

		id.id();
		ImageIcon img = new ImageIcon("temp\\pay.png");
		img.getImage().flush();

		JLabel lblNewLabel_1 = new JLabel(
				"ATTENTION : Veuillez v\u00E9rifier l'ann\u00E9e universitaire et la tranche de paiement avant de proc\u00E9der au paiement ! ");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 15));
		lblNewLabel_1.setBounds(23, 11, 833, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel(
				"Le tableau suivant r\u00E9sume les inscriptions que vous pouvez faire dans votre \u00E9tablissement. Pour payer les frais d'une inscription, vous pouvez ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(20, 29, 861, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel(
				"choisir le lien \"payer\" dans le tableau. Ce lien est remplac\u00E9 par la mention \"d\u00E9sactiv\u00E9e\" si les inscriptions n'ont pas encore commenc\u00E9 ou bien si la date limite a \u00E9t\u00E9  atteinte.");
		lblNewLabel_3.setBounds(20, 53, 836, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 78, 856, 81);
		contentPane.add(lblNewLabel);
		ImageIcon img1 = new ImageIcon("temp\\pay.png");
		img1.getImage().flush();
		lblNewLabel.setIcon(img1);

	}
}
