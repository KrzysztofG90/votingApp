package pl.gotowala.voting.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.gotowala.voting.dao.entity.Voter;

@Repository
public interface VoterRepo extends CrudRepository<Voter, Long> {
}
