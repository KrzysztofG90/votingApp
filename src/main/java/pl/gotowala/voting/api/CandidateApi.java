package pl.gotowala.voting.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.gotowala.voting.dao.entity.Candidate;
import pl.gotowala.voting.manager.CandidateManager;

import java.util.Optional;

@RestController
@RequestMapping("/api/candidates")
public class CandidateApi {

    private CandidateManager candidateManager;

    @Autowired
    public CandidateApi(CandidateManager candidateManager) {
        this.candidateManager = candidateManager;
    }

    @GetMapping("/all")
    public Iterable<Candidate> getAll() {
        return candidateManager.findAll();
    }

    @GetMapping
    public Optional<Candidate> getById(@RequestParam long id) {
        return candidateManager.findById(id);
    }

    @PostMapping
    public Candidate addCandidate(@RequestBody Candidate candidate) {
        return candidateManager.save(candidate);
    }

    @PutMapping
    public Candidate updateCandidate(@RequestBody Candidate candidate) {
        return candidateManager.save(candidate);

    }
}
