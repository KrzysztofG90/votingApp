package pl.gotowala.voting.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.gotowala.voting.dao.entity.Candidate;

@Repository
public interface CandidateRepo extends CrudRepository<Candidate, Long> {
}
