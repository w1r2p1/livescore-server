package ro.szzsa.livescore.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import ro.szzsa.livescore.model.Team;
import ro.szzsa.livescore.server.repository.dao.TeamDao;
import ro.szzsa.livescore.server.service.TeamService;
import ro.szzsa.livescore.server.service.converter.TeamConverter;

/**
 *
 */
@Service
public class TeamServiceImpl implements TeamService {

  private final TeamDao dao;

  private final TeamConverter converter;

  @Autowired
  public TeamServiceImpl(TeamDao dao,
                         TeamConverter converter) {
    this.dao = dao;
    this.converter = converter;
  }

  @Override
  public List<Team> getTeams() {
    return convertTeams(dao.findAll());
  }

  @Override
  public void updateTeam(Team team) {
    if (team == null) {
      return;
    }
    dao.save(converter.toEntity(team));
  }

  @Override
  public void deleteTeam(Team team) {
    if (team == null) {
      return;
    }
    if (dao.exists(team.getId())) {
      dao.delete(team.getId());
    }
  }

  private List<Team> convertTeams(Iterable<ro.szzsa.livescore.server.repository.model.Team> entities) {
    List<Team> teams = new ArrayList<>();
    entities.forEach(team -> teams.add(converter.toModel(team)));
    return teams;
  }
}
