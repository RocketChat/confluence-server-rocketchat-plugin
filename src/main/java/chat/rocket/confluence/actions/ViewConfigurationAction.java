package chat.rocket.confluence.actions;

import chat.rocket.confluence.components.ConfigurationManager;
import com.atlassian.confluence.core.ConfluenceActionSupport;
import com.opensymphony.xwork.Action;

public class ViewConfigurationAction extends ConfluenceActionSupport {
    private static final long serialVersionUID = 5297282387258304683L;

    private ConfigurationManager configurationManager;

    private boolean successfullUpdate;

    @Override
    public String execute() throws Exception
    {
        return Action.SUCCESS;
    }

    public String getRocketchatUrl()
    {
        return configurationManager.getRocketchatUrl();
    }

    public void setResult(String result) {
        if ("success".equals(result)) {
            successfullUpdate = true;
        }
    }

    public void setConfigurationManager(ConfigurationManager configurationManager) {
        this.configurationManager = configurationManager;
    }

    public boolean isSuccessfullUpdate() {
        return successfullUpdate;
    }
}
