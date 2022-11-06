package me.iantapply.scoutingPlatform.API;

import me.iantapply.scoutingPlatform.utilities.ConfigurationUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2/private")
public class PrivateAPI {

    private final ConfigurationUtils configurationUtils;

    public PrivateAPI(ConfigurationUtils configurationUtils) {
        this.configurationUtils = configurationUtils;
    }
}
