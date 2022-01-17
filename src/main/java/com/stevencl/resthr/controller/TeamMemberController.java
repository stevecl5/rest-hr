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

@RestController
@RequestMapping("api/team-members")
public class TeamMemberController {

    private final TeamMemberRepository teamMemberRepository;

    public TeamMemberController(TeamMemberRepository teamMemberRepository) {
        this.teamMemberRepository = teamMemberRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<TeamMember> listTeamMembers() {
        return teamMemberRepository.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TeamMember getTeamMember(@PathVariable long id) {
        return teamMemberRepository.findTeamMemberById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public TeamMember createTeamMember(@RequestBody TeamMember newTeamMember) {
        return teamMemberRepository.save(newTeamMember);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public TeamMember updateTeamMember(@RequestBody TeamMember newTeamMember,
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

    @DeleteMapping("/{id}")
    public void deleteTeamMember(@PathVariable long id) {
        teamMemberRepository.deleteById(id);
    }

}
