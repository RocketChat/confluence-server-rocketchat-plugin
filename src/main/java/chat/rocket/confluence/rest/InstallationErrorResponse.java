package chat.rocket.confluence.rest;

import javax.xml.bind.annotation.*;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class InstallationErrorResponse {

    @XmlElement(name = "error")
    private String message;

    public InstallationErrorResponse()
    {

    }

    public InstallationErrorResponse(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}
