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

    @DefaultValue("Huawei P30")
    @Key("device")
    String deviceName();

    @DefaultValue("9.0")
    @Key("version")
    String versionDevice();

    @DefaultValue("Selenide")
    @Key("search.data")
    String searchData();


}