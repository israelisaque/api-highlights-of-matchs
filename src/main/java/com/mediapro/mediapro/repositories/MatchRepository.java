package com.mediapro.mediapro.repositories;

import com.mediapro.mediapro.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    List<Match> findAllByCompetition_Id(Long id);
    Match findByIdAndCompetition_Id(Long idMatch, Long idCompetition);
}
