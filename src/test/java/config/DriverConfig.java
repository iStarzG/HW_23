package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/driverBrowserStack.properties"})

public interface DriverConfig extends Config {

    @DefaultValue("https://hub.browserstack.com/wd/hub")
    @Key("remote.url")
    String remoteUrl();

    @Key("device")
    String deviceName();

    @Key("version")
    String versionDevice();

    @Key("search.data")
    String searchData();


}