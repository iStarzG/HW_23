package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/auth.properties"
})

public interface AuthConfig extends Config {

    @Key("browserstack.user")
    @DefaultValue("kirill_IcK4CD")
    String userName();

    @DefaultValue("9cPqaW6bZsssNwmWwYJH")
    @Key("browserstack.key")
    String userKey();
}
