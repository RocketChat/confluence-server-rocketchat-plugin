package chat.rocket.confluence.components;

import com.atlassian.bandana.BandanaManager;
import com.atlassian.confluence.setup.bandana.ConfluenceBandanaContext;

import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import org.springframework.beans.factory.annotation.Autowired;
import javax.inject.Named;

@Named
public class ConfigurationManager {
    private static final String rocketchatUrlKey = "chat.rocket.confluence.rocketchatUrl";
    private static final ConfluenceBandanaContext GLOBAL_CONTEXT = ConfluenceBandanaContext.GLOBAL_CONTEXT;
    private BandanaManager bandanaManager;

    @Autowired
    public ConfigurationManager(@ComponentImport BandanaManager bandanaManager) {
        this.bandanaManager = bandanaManager;
    }

    public void setRocketchatUrl(String rocketchatUrl)
    {
        bandanaManager.setValue(GLOBAL_CONTEXT, rocketchatUrlKey, rocketchatUrl);
    }

    public String getRocketchatUrl()
    {
        Object fromBandana = bandanaManager.getValue(GLOBAL_CONTEXT, rocketchatUrlKey);
        if (fromBandana == null) {
            return "";
        }
        return fromBandana.toString();
    }
}
