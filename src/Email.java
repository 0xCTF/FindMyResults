import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.jdesktop.swingx.prompt.PromptSupport;
import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JHTMLEditor;
import chrriis.dj.nativeswing.swtimpl.components.JHTMLEditor.HTMLEditorImplementation;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.mail.*;
import javax.mail.internet.*;
import java.awt.TextArea;
import java.awt.Toolkit;

public class Email extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private TextArea message;
	private JTextField subject;
	private JTextField sender;
	private TextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Email frame = new Email();
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
	public Email() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 819, 585);
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
		java.awt.Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		message = new TextArea();
		message.setBounds(59, 273, 679, 230);
		contentPane.add(message);
		message.setColumns(10);
		// PromptSupport.setPrompt("Votre message", message);

		subject = new JTextField();
		subject.setBounds(59, 74, 288, 36);
		contentPane.add(subject);
		subject.setColumns(10);
		PromptSupport.setPrompt("Objet", subject);

		sender = new JTextField();
		sender.setBounds(59, 29, 288, 34);
		contentPane.add(sender);
		sender.setColumns(10);
		PromptSupport.setPrompt("Votre adresse e-mail", sender);

		JButton btnNewButton = new JButton("Envoyer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sub = subject.getText();
				String from = sender.getText();
				String m = message.getText();

				String to = "findmyresults.tn@gmail.com";

				// String messg=m.getMsg();
				// Sender's email ID needs to be mentioned

				final String username = "putYourEmailHere"; // change accordingly
				final String password = "YourEmailPassword"; // change accordingly

				// Assuming you are sending email through relay.jangosmtp.net
				Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.socketFactory.port", "465");
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.port", "465");

				// Get the Session object.
				Session session = Session.getInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

				try {
					// Create a default MimeMessage object.
					Message message = new MimeMessage(session);

					// Set From: header field of the header.
					message.setFrom(new InternetAddress(from));

					// Set To: header field of the header.
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

					// Set Subject: header field
					message.setSubject(sub);

					// Send the actual HTML message, as big as you like
					message.setContent(m, "text/html; charset=utf-8");

					// Send message
					Transport.send(message);
					JOptionPane.showMessageDialog(null, "Merci pour votre message", "Message envoyé avec succès",
							JOptionPane.INFORMATION_MESSAGE);
					dispose();

				} catch (MessagingException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}

			}
		});
		btnNewButton.setBounds(598, 81, 140, 31);
		contentPane.add(btnNewButton);

		UIUtils.setPreferredLookAndFeel();
		NativeInterface.open();
		final String configurationScript = "FCKConfig.ToolbarSets[\"Default\"] = [\n"
				+ "['Source','DocProps','-','Save','NewPage','Preview','-','Templates'],\n"
				+ "['Cut','Copy','Paste','PasteText','PasteWord','-','Print','SpellCheck'],\n"
				+ "['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],\n"
				+ "['Form','Checkbox','Radio','TextField','Textarea','Select','Button','ImageButton','HiddenField'],\n"
				+ "'/',\n" + "['Style','FontFormat','FontName','FontSize'],\n" + "['TextColor','BGColor'],\n" + "'/',\n"
				+ "['Bold','Italic','Underline','StrikeThrough','-','Subscript','Superscript'],\n"
				+ "['OrderedList','UnorderedList','-','Outdent','Indent','Blockquote'],\n"
				+ "['JustifyLeft','JustifyCenter','JustifyRight','JustifyFull'],\n" + "['Link','Unlink','Anchor'],\n"
				+ "['Image','Flash','Table','Rule','Smiley','SpecialChar','PageBreak', '-', 'ShowBlocks'],\n" + "];\n"
				+ "FCKConfig.ToolbarCanCollapse = false;\n";
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				JHTMLEditor htmlEditor = new JHTMLEditor(HTMLEditorImplementation.FCKEditor,
						JHTMLEditor.FCKEditorOptions.setCustomJavascriptConfiguration(configurationScript));
				htmlEditor.setBounds(59, 160, 679, 100);
				contentPane.add(htmlEditor);

			}
		});
		// JEditorPane htmlEditor = new JEditorPane();

	}

}
