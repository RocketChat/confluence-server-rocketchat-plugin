package chat.rocket.confluence.rest;

import javax.xml.bind.annotation.*;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class InstallationRequest {

    @XmlElement(name = "rocketchatUrl")
    private String rocketchatUrl;

    public InstallationRequest () {

    }

    public InstallationRequest(String rocketchatUrl)
    {
        this.rocketchatUrl = rocketchatUrl;
    }

    public String getRocketchatUrl()
    {
        return rocketchatUrl;
    }

    public void setRocketchatUrl(String newRocketchatUrl)
    {
        rocketchatUrl = newRocketchatUrl;
    }
}
