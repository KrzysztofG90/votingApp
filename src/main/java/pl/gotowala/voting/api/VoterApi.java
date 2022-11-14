package pl.gotowala.voting.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.gotowala.voting.dao.entity.Voter;
import pl.gotowala.voting.manager.VoterManager;

import java.util.Optional;

@RestController
@RequestMapping("/api/voters")
public class VoterApi {

    private VoterManager voterManager;

    @Autowired
    public VoterApi(VoterManager voterManager) {
        this.voterManager = voterManager;
    }

    @GetMapping("/all")
    public Iterable<Voter> getAll() {
        return voterManager.findAll();
    }

    @GetMapping
    public Optional<Voter> getById(@RequestParam long id) {
        return voterManager.findById(id);
    }

    @PostMapping
    public Voter addCandidate(@RequestBody Voter voter) {
        return voterManager.save(voter);
    }

    @PutMapping
    public Voter updateCandidate(@RequestBody Voter voter) {
        return voterManager.save(voter);
    }
}
