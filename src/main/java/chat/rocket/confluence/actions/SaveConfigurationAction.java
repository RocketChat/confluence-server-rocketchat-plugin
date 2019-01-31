package chat.rocket.confluence.actions;

import chat.rocket.confluence.components.ConfigurationManager;
import com.atlassian.confluence.core.ConfluenceActionSupport;
import com.atlassian.xwork.RequireSecurityToken;
import com.opensymphony.xwork.Action;

import java.net.MalformedURLException;
import java.net.URL;

public class SaveConfigurationAction extends ConfluenceActionSupport {
    private static final long serialVersionUID = -5908100302197890668L;

    private ConfigurationManager configurationManager;

    private String rocketchatUrl;

    @Override
    public void validate() {
        try {
            new URL(rocketchatUrl);
        } catch(MalformedURLException e) {
            addActionError(getText("rocketchat.WebhookURLInvalid"));
        }
    }

    @Override
    @RequireSecurityToken(true)
    public String execute() throws Exception {
        configurationManager.setRocketchatUrl(rocketchatUrl);

        return Action.SUCCESS;
    }

    public void setRocketchatUrl(String rocketchatUrl) {
        this.rocketchatUrl = rocketchatUrl;
    }

    public String getRocketchatUrl()
    {
        return rocketchatUrl;
    }


    public void setConfigurationManager(ConfigurationManager configurationManager) {
        this.configurationManager = configurationManager;
    }
}
