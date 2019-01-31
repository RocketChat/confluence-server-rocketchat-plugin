package chat.rocket.confluence.components;

import com.atlassian.event.api.EventListener;
import com.atlassian.event.api.EventPublisher;
import com.atlassian.confluence.event.events.content.page.PageUpdateEvent;
import com.atlassian.confluence.event.events.content.page.PageCreateEvent;
import com.atlassian.plugin.spring.scanner.annotation.imports.ConfluenceImport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class RocketChatEventListener implements InitializingBean, DisposableBean {

    @ConfluenceImport
    private EventPublisher eventPublisher;

    private static final Logger log = LoggerFactory.getLogger(RocketChatEventListener.class);

    @Inject
    public RocketChatEventListener(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @EventListener
    public void pageUpdateEvent(PageUpdateEvent event) {
        // this.sendNotification(event);
    }

    @EventListener
    public void pageCreateEvent(PageCreateEvent event) {
        // this.sendNotification(event);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        eventPublisher.register(this);
    }

    @Override
    public void destroy() throws Exception {
        eventPublisher.unregister(this);
    }


}
