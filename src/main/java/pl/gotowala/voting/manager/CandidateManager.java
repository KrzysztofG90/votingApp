package pl.gotowala.voting.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.gotowala.voting.dao.CandidateRepo;
import pl.gotowala.voting.dao.entity.Candidate;

import java.util.Optional;

@Service
public class CandidateManager {

    private  CandidateRepo candidateRepo;

    @Autowired
    public CandidateManager(CandidateRepo candidateRepo) {
        this.candidateRepo = candidateRepo;
    }

    public Iterable<Candidate> findAll(){
        return candidateRepo.findAll();
    }

    public Optional<Candidate> findById(long id){
        return candidateRepo.findById(id);
    }

    public Candidate save(Candidate candidate){
        return candidateRepo.save(candidate);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillCandidates(){
        save(new Candidate(1L, "Johny Bravo", 2));
        save(new Candidate(2L, "Pluto", 6));
    }
}
