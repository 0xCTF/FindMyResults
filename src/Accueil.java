import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.commons.io.FileUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Accueil extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accueil frame = new Accueil();
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
	public Accueil() throws IOException {
		 try {
	            URL resource = this.getClass().getResource("/images/icon.png");
	            BufferedImage image5 = ImageIO.read(resource);
	            this.setIconImage(image5);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if (screenSize.width >= 1920) {

			setBounds(100, 100, 1450, 827);
		} else {

			setBounds(100, 100, 1094, 637);

		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(null);
		setUndecorated(true);

		contentPane.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				setShape(new RoundRectangle2D.Double(2, 2, getWidth(), getHeight(), 35, 35));
			}
		});
		java.awt.Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		JButton carteetd = new JButton("");
		carteetd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CarteEtd car = null;
				try {
					car = new CarteEtd();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				car.setVisible(true);
				carteetd.setEnabled(false);
				car.addWindowListener(new WindowAdapter() { 
					@Override 
					public void windowClosing(WindowEvent e3) {
					carteetd.setEnabled(true);
					}
				});
			}});
		
		

		carteetd.setOpaque(false);
		carteetd.setContentAreaFilled(false);
		carteetd.setBorderPainted(false);
		if (screenSize.width >= 1920) {
			carteetd.setIcon(new ImageIcon(Accueil.class.getResource("/menu/carteetd.png")));
			carteetd.setBounds(257, 130, 310, 205);
		} else {
			carteetd.setIcon(new ImageIcon(Accueil.class.getResource("/menu_1366/carteetd_1366.png")));

			carteetd.setBounds(203, 130, 233, 150);

		}

		contentPane.add(carteetd);

		JLabel lblNewLabel_2 = new JLabel("");
		if (screenSize.width >= 1920) {
			lblNewLabel_2.setIcon(new ImageIcon(Accueil.class.getResource("/images/ministere.png")));
			lblNewLabel_2.setBounds(22, 11, 409, 46);

		} else {
			lblNewLabel_2.setIcon(new ImageIcon(Accueil.class.getResource("/menu_1366/ministere_1366.png")));
			lblNewLabel_2.setBounds(10, 5, 409, 46);

		}
		contentPane.add(lblNewLabel_2);

		JLabel avatar = new JLabel("");
		CarteEtdInfo photo = new CarteEtdInfo();
		photo.photoProfile();
		ImageIcon img1 = new ImageIcon("temp\\avatar.png");
		java.awt.Image image1 = img1.getImage(); // transform it

		if (screenSize.width >= 1920) {
			java.awt.Image newimg = image1.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // scale it the
																										// smooth way
			img1 = new ImageIcon(newimg); // transform it back

		} else {
			java.awt.Image newimg = image1.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH); // scale it the
																									// smooth way
			img1 = new ImageIcon(newimg); // transform it back

		}
		img1.getImage().flush();
		avatar.setIcon(img1);
		// avatar.setIcon(new ImageIcon("temp\\\\avatar.png"));
		if (screenSize.width >= 1920) {
			avatar.setBounds(55, 130, 127, 124);
		} else {
			avatar.setBounds(25, 99, 80, 80);

		}
		contentPane.add(avatar);
		// problems caused by this

		Info newName = new Info();
		String nom = newName.getNom();
		JLabel nom_1 = new JLabel("<html><span bgcolor=\"SILVER\">" + nom + "</span></html>");
		if (screenSize.width >= 1920) {
			nom_1.setFont(new Font("Roboto Medium", Font.PLAIN, 12));

			nom_1.setBounds(22, 277, 154, 22);
		} else {

			nom_1.setFont(new Font("Roboto Medium", Font.PLAIN, 11));

			nom_1.setBounds(25, 190, 134, 22);

		}
		contentPane.add(nom_1);

		Info depa = new Info();
		String depName = depa.getDep();
		JLabel dep = new JLabel(depName);
		if (screenSize.width >= 1920) {
			nom_1.setFont(new Font("Roboto Medium", Font.PLAIN, 12));

			dep.setBounds(43, 305, 154, 14);
		} else {
			nom_1.setFont(new Font("Roboto Medium", Font.PLAIN, 10));
			dep.setBounds(23, 218, 127, 14);

		}
		contentPane.add(dep);

		JButton paiement = new JButton("");
		paiement.setOpaque(false);
		paiement.setContentAreaFilled(false);
		paiement.setBorderPainted(false);
		if (screenSize.width >= 1920) {

			paiement.setIcon(new ImageIcon(Accueil.class.getResource("/menu/paiement.png")));
			paiement.setBounds(666, 130, 400, 205);

		} else {
			paiement.setIcon(new ImageIcon(Accueil.class.getResource("/menu_1366/paiement_1366.png")));
			paiement.setBounds(517, 130, 275, 150);
		}
		contentPane.add(paiement);
		paiement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Paiement pay = null;
				try {
					pay = new Paiement();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pay.setVisible(true);
				paiement.setEnabled(false);
				pay.addWindowListener(new WindowAdapter() { 
					@Override 
					public void windowClosing(WindowEvent e3) {
						paiement.setEnabled(true);
					}
				});
			}
		});

		JButton infos = new JButton("");
		infos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoEtd a = null;
				try {
					a = new InfoEtd();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				a.setVisible(true);
				infos.setEnabled(false);
				a.addWindowListener(new WindowAdapter() { 
					@Override 
					public void windowClosing(WindowEvent e3) {
						infos.setEnabled(true);
					}
				});
			}
		});
		infos.setOpaque(false);
		infos.setContentAreaFilled(false);
		infos.setBorderPainted(false);
		if (screenSize.width >= 1920) {

			infos.setIcon(new ImageIcon(Accueil.class.getResource("/menu/info.png")));
			infos.setBounds(1090, 130, 350, 205);

		} else {
			infos.setIcon(new ImageIcon(Accueil.class.getResource("/menu_1366/info_1366.png")));
			infos.setBounds(817, 130, 233, 150);
		}
		contentPane.add(infos);

		JButton resultat = new JButton("");
		resultat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Resultat r = null;
				try {
					r = new Resultat();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				r.setVisible(true);
				resultat.setEnabled(false);
				r.addWindowListener(new WindowAdapter() { 
					@Override 
					public void windowClosing(WindowEvent e3) {
						resultat.setEnabled(true);
					}
				});
			}
		});
		if (screenSize.width >= 1920) {

			resultat.setIcon(new ImageIcon(Accueil.class.getResource("/menu/res.png")));
			resultat.setBounds(257, 511, 350, 205);
		} else {
			resultat.setIcon(new ImageIcon(Accueil.class.getResource("/menu_1366/res_1366.png")));
			resultat.setBounds(202, 355, 275, 162);

		}
		resultat.setOpaque(false);
		resultat.setContentAreaFilled(false);
		resultat.setBorderPainted(false);
		contentPane.add(resultat);

		JButton recus = new JButton("");
		recus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Recus recu = null;
				try {
					recu = new Recus();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				recu.setVisible(true);
				recus.setEnabled(false);
				recu.addWindowListener(new WindowAdapter() { 
					@Override 
					public void windowClosing(WindowEvent e3) {
						recus.setEnabled(true);
					}
				});
			}
		});
		if (screenSize.width >= 1920) {

			recus.setIcon(new ImageIcon(Accueil.class.getResource("/menu/recus.png")));
			recus.setBounds(693, 511, 350, 205);
		} else {
			recus.setIcon(new ImageIcon(Accueil.class.getResource("/menu_1366/recus_1366.png")));
			recus.setBounds(521, 360, 258, 157);
		}

		recus.setOpaque(false);
		recus.setContentAreaFilled(false);
		recus.setBorderPainted(false);
		contentPane.add(recus);

		JButton bourse = new JButton("");
		bourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				BourseLogin bou = null;
				bou = new BourseLogin();
				bou.setVisible(true);
			}
		});
		if (screenSize.width >= 1920) {

			bourse.setIcon(new ImageIcon(Accueil.class.getResource("/menu/bourse.png")));
			bourse.setBounds(1100, 511, 350, 205);
		} else {
			bourse.setIcon(new ImageIcon(Accueil.class.getResource("/menu_1366/bourse_1366.png")));
			bourse.setBounds(822, 360, 233, 157);
		}
		bourse.setOpaque(false);
		bourse.setContentAreaFilled(false);
		bourse.setBorderPainted(false);
		contentPane.add(bourse);

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
		CLOSE.setForeground(Color.RED);
		CLOSE.setFont(new Font("ITC Garamond", Font.BOLD | Font.ITALIC, 18));
		if (screenSize.width >= 1920) {

			CLOSE.setBounds(1414, 0, 84, 32);
		} else {
			CLOSE.setBounds(1058, 5, 20, 14);

		}
		getContentPane().add(CLOSE);

		JMenuBar menuBar = new JMenuBar();
		if (screenSize.width >= 1920) {

			menuBar.setBounds(1400, 33, 20, 33);
		} else {
			menuBar.setBounds(1050, 20, 22, 22);

		}
		contentPane.add(menuBar);
		menuBar.setOpaque(false);
		menuBar.setBorderPainted(false);
		JMenu mnNewMenu = new JMenu("▼");
		menuBar.add(mnNewMenu);

		JMenuItem bug = new JMenuItem("Signaler un bug");
		bug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Bug url1 = new Bug();
				url1.main(null);
			}
		});
		mnNewMenu.add(bug);

		JMenuItem feedB = new JMenuItem("Feedback");
		feedB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Feedback_Link url = new Feedback_Link();
				url.main(null);
			}
		});
		mnNewMenu.add(feedB);

		JMenuItem Decnx = new JMenuItem("Déconnexion");
		Decnx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Deconnection de = null;
				try {
					dispose();

					de = new Deconnection();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					de.decnx();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mnNewMenu.add(Decnx);

		JLabel label = new JLabel("Bienvenue, ");
		if (screenSize.width >= 1920) {
			label.setBounds(1272, 43, 84, 14);
		} else {
			label.setBounds(902, 25, 75, 14);

		}
		contentPane.add(label);

		Info is = new Info();
		String prenom = is.getPrenom();
		// String ismFinal = is.getPrenom(ism);
		JLabel lblNewLabel = new JLabel(prenom);
		if (screenSize.width >= 1920) {

			lblNewLabel.setBounds(1336, 43, 136, 14);
		} else {
			lblNewLabel.setBounds(970, 25, 136, 14);

		}
		contentPane.add(lblNewLabel);

		JLabel bg_1 = new JLabel("");
		if (screenSize.width >= 1920) {

			bg_1.setBounds(0, 0, 1458, 849);
			bg_1.setIcon(new ImageIcon(Accueil.class.getResource("/images/bg_accueil.png")));
		} else {
			bg_1.setBounds(0, 0, 1094, 637);
			bg_1.setIcon(new ImageIcon(Accueil.class.getResource("/menu_1366/bg_accueil_1366.png")));
		}
		contentPane.add(bg_1);

	}
}
