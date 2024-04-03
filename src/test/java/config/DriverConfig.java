package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/driver.properties"})

public interface DriverConfig extends Config {

    @DefaultValue("https://hub.browserstack.com/wd/hub")
    @Key("remote.url")
    String remoteUrl();

    @Key("device.name")
    String deviceName();

    @Key("version.device")
    String versionDevice();

    @Key("search.data")
    String searchData();


}