package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/auth.properties"
})

public interface AuthConfig extends Config {
    @DefaultValue("kirill_IcK4CD")
    @Key("browserstack.user")
    String userName();

    @DefaultValue("9cPqaW6bZsssNwmWwYJH")
    @Key("browserstack.key")
    String userKey();
}
