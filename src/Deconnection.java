import java.io.IOException;
import org.openqa.selenium.WebDriver;

public class Deconnection extends Connection {

	public Deconnection() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void decnx() throws IOException {

		Connection d = new Connection();
		WebDriver deco = d.driver;
		deco.get("https://www4.inscription.tn/ORegMx/quitter.jsp");
		d.main(null);

	}

}
