package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.AuthConfig;
import config.DriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackDriver implements WebDriverProvider {
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());
        DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class, System.getProperties());
        MutableCapabilities caps = new MutableCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", authConfig.userName());
        caps.setCapability("browserstack.key", authConfig.userKey());

        // Set URL of the application under test
        caps.setCapability("app", "bs://8548e1e323b1f3c59725084ff8dcaee4f2cf8415");

        // Specify device and os_version for testing
        caps.setCapability("device", driverConfig.deviceName());
        caps.setCapability("os_version", driverConfig.versionDevice());

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL(driverConfig.remoteUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}