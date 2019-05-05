import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PhantomJs {

	public static WebDriver createDriver() {
		DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS,
				new String[] { "--web-security=no", "--ignore-ssl-errors=yes", "--ssl-protocol=tlsv1" });
		PhantomJSDriver driver;
		return driver = new PhantomJSDriver(capabilities);
		// return new PhantomJSDriver(dcaps);
	}

}
