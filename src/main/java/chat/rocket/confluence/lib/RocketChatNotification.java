package chat.rocket.confluence.lib;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class RocketChatNotification {
    public enum NotificationType {
        PAGE_CREATED, PAGE_UPDATED
    }

    private NotificationType notificationType;

    private String userFullName;

    private String pageTitle;

    private String pageUrl;

    private String pageContentType;

    public NotificationType getNotificationType()
    {
        return notificationType;
    }

    public RocketChatNotification setNotificationType(NotificationType notificationType)
    {
        this.notificationType = notificationType;
        return this;
    }

    public String getUserFullName()
    {
        return userFullName;
    }

    public RocketChatNotification setUserFullName(String userFullName)
    {
        this.userFullName = userFullName;
        return this;
    }

    public String getPageTitle()
    {
        return pageTitle;
    }

    public RocketChatNotification setPageTitle(String pageTitle)
    {
        this.pageTitle = pageTitle;
        return this;
    }

    public String getPageUrl()
    {
        return pageUrl;
    }

    public RocketChatNotification setPageUrl(String pageUrl)
    {
        this.pageUrl = pageUrl;
        return this;
    }

    public String getPageContentType()
    {
        return pageContentType;
    }

    public RocketChatNotification setPageContentType(String pageContentType)
    {
        this.pageContentType = pageContentType;
        return this;
    }

    Map<String, String> toMap()
    {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.convertValue(this, new TypeReference<Map<String, String>>() {});
    }
}
