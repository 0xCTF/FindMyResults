import java.awt.EventQueue;
import java.io.IOException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;

public class Resultat extends JFrame {

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
					Resultat frame = new Resultat();
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
	public Resultat() throws IOException {

		ResultatInfo nbrRez = new ResultatInfo();
		nbrRez.NbrRes();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 505, 95);
		try {
            URL resource = this.getClass().getResource("/images/icon.png");
            BufferedImage image = ImageIO.read(resource);
            this.setIconImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		java.awt.Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		JButton btnNewButton = new JButton("\tVoir r\u00E9sultat");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Resultat1Sem r = null;
				try {
					r = new Resultat1Sem();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				r.setVisible(true);
			}
		});
		btnNewButton.setBounds(381, 41, 116, 17);
		contentPane.add(btnNewButton);
		JLabel lblNewLabel = new JLabel();
		ImageIcon img1 = new ImageIcon("temp\\nbrRes.png");
		img1.getImage().flush();
		lblNewLabel.setIcon(img1);
		lblNewLabel.setFont(new Font("GeForce", Font.PLAIN, 18));
		lblNewLabel.setBounds(0, 0, 497, 62);
		contentPane.add(lblNewLabel);

	}
}
