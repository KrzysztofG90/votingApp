package pl.gotowala.voting.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.gotowala.voting.dao.VoterRepo;
import pl.gotowala.voting.dao.entity.Voter;

import java.util.Optional;

@Service
public class VoterManager {

    private VoterRepo voterRepo;

    @Autowired
    public VoterManager(VoterRepo voterRepo) {
        this.voterRepo = voterRepo;
    }

    public Iterable<Voter> findAll() {
        return voterRepo.findAll();
    }

    public Optional<Voter> findById(long id) {
        return voterRepo.findById(id);
    }

    public Voter save(Voter voter) {
        return voterRepo.save(voter);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillVoters() {
        save(new Voter(1L, "Peppa", false));
        save(new Voter(2L, "Rumcajs", true));
    }
}
