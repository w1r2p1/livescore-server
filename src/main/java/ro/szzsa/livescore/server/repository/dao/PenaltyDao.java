package ro.szzsa.livescore.server.repository.dao;

import org.springframework.data.repository.CrudRepository;

import ro.szzsa.livescore.server.repository.model.Penalty;

/**
 *
 */
public interface PenaltyDao extends CrudRepository<Penalty, Integer> {
}
