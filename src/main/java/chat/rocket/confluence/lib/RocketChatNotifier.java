package chat.rocket.confluence.lib;

import chat.rocket.confluence.components.RocketChatEventListener;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class RocketChatNotifier {
    private static final Logger log = LoggerFactory.getLogger(RocketChatEventListener.class);

    private static final HttpTransport transport = new NetHttpTransport();
    private static final HttpRequestFactory requestFactory = transport.createRequestFactory();

    public static void notify(String rocketChatURL, RocketChatNotification notification) {
        try {
            requestFactory.buildPostRequest(
                    new GenericUrl(rocketChatURL),
                    new JsonHttpContent(new JacksonFactory(), notification.toMap())
            ).execute();
        } catch (IOException e) {
            log.error("Error sending notification: " + e.getMessage());
        }
    }
}
