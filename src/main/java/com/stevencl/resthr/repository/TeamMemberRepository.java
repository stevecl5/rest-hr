package com.stevencl.resthr.repository;

import com.stevencl.resthr.model.TeamMember;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Provides methods for interacting with the team member repository.
 */
@Repository
public interface TeamMemberRepository extends CrudRepository<TeamMember, Long> {
    TeamMember findTeamMemberById(long id);
}
