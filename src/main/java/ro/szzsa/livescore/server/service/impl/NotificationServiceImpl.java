package ro.szzsa.livescore.server.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import ro.szzsa.livescore.api.device.server.NotificationException;
import ro.szzsa.livescore.api.device.server.NotificationSender;
import ro.szzsa.livescore.model.Game;
import ro.szzsa.livescore.server.service.ConfigService;
import ro.szzsa.livescore.server.service.NotificationService;

/**
 *
 */
@Service
public class NotificationServiceImpl implements NotificationService {

  private final static Logger LOGGER = Logger.getLogger(NotificationServiceImpl.class);

  private final ConfigService configService;

  @Autowired
  public NotificationServiceImpl(ConfigService configService) {
    this.configService = configService;
  }

  @Async
  @Override
  public void sendNotification(Game game) {
    try {
      new NotificationSender().sendGameUpdate(configService.getFCMApiKey(), game);
    } catch (NotificationException e) {
      LOGGER.error("Cannot send notification", e);
    }
  }
}
