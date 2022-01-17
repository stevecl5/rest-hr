package com.stevencl.resthr.controller;

import com.stevencl.resthr.model.TeamMember;
import com.stevencl.resthr.repository.TeamMemberRepository;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Provides a REST controller for CRUD operations on team members.
 */
@RestController
@RequestMapping("api/team-members")
public class TeamMemberController {

    /** The team member repository for the application. */
    private final TeamMemberRepository teamMemberRepository;

    /**
     * Sole constructor.
     *
     * @param teamMemberRepository  the team member repository dependency
     */
    public TeamMemberController(TeamMemberRepository teamMemberRepository) {
        this.teamMemberRepository = teamMemberRepository;
    }

    /**
     * Returns a list of all team members.
     *
     * @return  a list of all team members
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<TeamMember> listTeamMembers() {
        return teamMemberRepository.findAll();
    }

    /**
     * Gets a single team member.
     *
     * @param id  the ID of the team member to be retrieved
     * @return    a single team member with the given ID
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TeamMember getTeamMember(@PathVariable long id) {
        return teamMemberRepository.findTeamMemberById(id);
    }

    /**
     * Creates a new team member.
     *
     * @param newTeamMember  new team member to be added to the repository
     * @return               the successfully added team member
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public TeamMember createTeamMember(@RequestBody TeamMember newTeamMember) {
        return teamMemberRepository.save(newTeamMember);
    }

    /**
     * Replaces an existing team member.
     *
     * @param newTeamMember  new team member to replace an existing team member
     * @param id             ID of the team member to be replaced
     * @return  the successfully updated (i.e. replaced) team member
     */
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public TeamMember replaceTeamMember(@RequestBody TeamMember newTeamMember,
            @PathVariable long id) {
        return teamMemberRepository.findById(id)
                .map(teamMember -> {
                    teamMember.setFirstName(newTeamMember.getFirstName());
                    teamMember.setLastName(newTeamMember.getLastName());
                    teamMember.setEmail(newTeamMember.getEmail());
                    teamMember.setManager(newTeamMember.getManager());
                    return teamMemberRepository.save(teamMember);
                })
                .orElseThrow(RuntimeException::new);
    }

    /**
     * Deletes a team member.
     *
     * @param id  ID of the team member to be deleted
     */
    @DeleteMapping("/{id}")
    public void deleteTeamMember(@PathVariable long id) {
        teamMemberRepository.deleteById(id);
    }

}
