package chat.rocket.confluence.components;

import chat.rocket.confluence.lib.RocketChatNotification;
import chat.rocket.confluence.lib.RocketChatNotifier;
import com.atlassian.confluence.pages.AbstractPage;
import com.atlassian.confluence.setup.settings.SettingsManager;
import com.atlassian.event.api.EventListener;
import com.atlassian.event.api.EventPublisher;
import com.atlassian.confluence.event.events.content.page.PageUpdateEvent;
import com.atlassian.confluence.event.events.content.page.PageCreateEvent;
import com.atlassian.plugin.spring.scanner.annotation.imports.ConfluenceImport;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class RocketChatEventListener implements InitializingBean, DisposableBean {

    @ConfluenceImport
    private EventPublisher eventPublisher;

    @ConfluenceImport
    private SettingsManager settingsManager;

    private ConfigurationManager configurationManager;


    @Inject
    public RocketChatEventListener(EventPublisher eventPublisher, SettingsManager settingsManager, ConfigurationManager configurationManager)
    {
        this.eventPublisher = eventPublisher;
        this.settingsManager = settingsManager;
        this.configurationManager = configurationManager;
    }

    @EventListener
    public void pageUpdateEvent(PageUpdateEvent event)
    {
        sendNotification(event.getPage(), RocketChatNotification.NotificationType.PAGE_UPDATED);
    }

    @EventListener
    public void pageCreateEvent(PageCreateEvent event)
    {
        sendNotification(event.getPage(), RocketChatNotification.NotificationType.PAGE_CREATED);
    }

    private void sendNotification(AbstractPage page, RocketChatNotification.NotificationType notificationType)
    {
        RocketChatNotification notification = new RocketChatNotification();

        notification
                .setNotificationType(notificationType)
                .setUserFullName(page.getLastModifier().getFullName())
                .setPageContentType(page.getType())
                .setPageTitle(page.getTitle())
                .setPageUrl(
                        settingsManager.getGlobalSettings().getBaseUrl() + page.getUrlPath()
                );

        RocketChatNotifier.notify(configurationManager.getRocketchatUrl(), notification);
    }

    @Override
    public void afterPropertiesSet()
    {
        eventPublisher.register(this);
    }

    @Override
    public void destroy()
    {
        eventPublisher.unregister(this);
    }


}
