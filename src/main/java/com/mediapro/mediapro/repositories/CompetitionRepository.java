package com.mediapro.mediapro.repositories;

import com.mediapro.mediapro.model.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Long> {

    Competition findByName(String competition);
}
