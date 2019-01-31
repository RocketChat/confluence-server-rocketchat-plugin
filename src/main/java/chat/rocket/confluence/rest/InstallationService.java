package chat.rocket.confluence.rest;

import chat.rocket.confluence.components.ConfigurationManager;

import com.atlassian.annotations.security.XsrfProtectionExcluded;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.net.URL;
import java.net.MalformedURLException;

/**
 * A resource of message.
 */
@Path("/installation")
@Produces({MediaType.APPLICATION_JSON})
public class InstallationService {
    private ConfigurationManager configurationManager;

    public InstallationService(ConfigurationManager cm)
    {
        configurationManager = cm;
    }

    @POST
    @XsrfProtectionExcluded
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postInstall(InstallationRequest request)
    {
        try {
            new URL(request.getRocketchatUrl());
        } catch (MalformedURLException e) {
            return Response.ok(new InstallationErrorResponse("Invalid URL")).status(Response.Status.BAD_REQUEST).build();
        }

        configurationManager.setRocketchatUrl(request.getRocketchatUrl());

        return Response.ok(request).build();
    }
}
