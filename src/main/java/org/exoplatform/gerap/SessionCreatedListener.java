package org.exoplatform.gerap;

import javax.servlet.http.HttpSessionEvent;
import org.exoplatform.container.PortalContainer;
import org.exoplatform.services.listener.*;
import org.exoplatform.services.log.*;


public class SessionCreatedListener extends Listener<PortalContainer, HttpSessionEvent> {

    private static Log log = ExoLogger.getLogger(SessionCreatedListener.class);
    private static int sessionTimeoutSeconds = Integer.parseInt(System.getProperty("exo.gerap.sessiontimeout.seconds","60")); ;

    @Override
    public void onEvent(Event<PortalContainer, HttpSessionEvent> event) throws Exception {
        log.info("Im working :) ");
        event.getData().getSession().setMaxInactiveInterval(sessionTimeoutSeconds);
    }
}