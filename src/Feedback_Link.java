import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
public class Feedback_Link {
  public static void main(String[] a) {
    try {
			URI uri = new URI("https://goo.gl/forms/F9TWbPe54qgwLCGk1");
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