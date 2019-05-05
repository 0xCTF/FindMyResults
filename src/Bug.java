import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Bug {
	public static void main(String[] a) {

		try {
			URI uri = new URI(
					"https://docs.google.com/forms/d/e/1FAIpQLSfdktWjVC9Xno_SN5r_NYQsdrnHToRI7Mg_jYydI0JeDEVaQQ/viewform?usp=sf_link");
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
}