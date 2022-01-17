package com.stevencl.resthr.repository;

import com.stevencl.resthr.model.TeamMember;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMemberRepository extends CrudRepository<TeamMember, Long> {
    TeamMember findTeamMemberById(long id);
}
