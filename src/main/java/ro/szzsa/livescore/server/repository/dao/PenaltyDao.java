package ro.szzsa.livescore.server.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.szzsa.livescore.server.repository.model.Penalty;

/**
 *
 */
public interface PenaltyDao extends JpaRepository<Penalty, Integer> {
}
