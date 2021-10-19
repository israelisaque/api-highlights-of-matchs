package com.mediapro.mediapro.services;

import com.mediapro.mediapro.dto.CompetitionDTO;
import com.mediapro.mediapro.mappers.CompetitionMapper;
import com.mediapro.mediapro.model.Competition;
import com.mediapro.mediapro.repositories.CompetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompetitionService {

    @Autowired
    private CompetitionRepository competitionRepository;

    @Autowired
    private ExternalAPIService externalAPIService;


    @Transactional()
    @Cacheable(value = "competitions")
    public List<CompetitionDTO> findAllCompetitions() {
        externalAPIService.persistenceAPIToEntities();

        List<Competition> list = competitionRepository.findAll();

        return list
                .stream()
                .map(competition -> new CompetitionDTO(competition))
                .collect(Collectors.toList());
    }


    public Competition saveCompetition(CompetitionMapper compDTO) {
        Competition competition = competitionRepository.findByName(compDTO.getCompetition());
        if (competition == null) {
            competition = new Competition(compDTO.getCompetition());
            competition = competitionRepository.save(competition);
        }
        return competition;
    }
}
