package ro.szzsa.livescore.server.controller.impl;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.szzsa.livescore.api.management.protocol.ManagementApiEndpoints;
import ro.szzsa.livescore.server.controller.ManagementApiController;

/**
 *
 */
@RestController
@RequestMapping(ManagementApiEndpoints.MANAGEMENT_API_ROOT_PATH)
public class ManagementApiControllerImpl implements ManagementApiController {

  @PostMapping(value = ManagementApiEndpoints.UPDATE_STANDINGS_PATH,
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public void updateStandings() {
  }

  @PostMapping(value = ManagementApiEndpoints.UPDATE_GAMES_PATH,
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public void updateGames() {
  }

  @PostMapping(value = ManagementApiEndpoints.UPDATE_GAME_DETAILS_PATH,
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public void updateGameDetails() {
  }
}
