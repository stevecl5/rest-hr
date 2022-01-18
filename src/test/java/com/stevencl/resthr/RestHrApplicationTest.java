package com.stevencl.resthr;

import com.stevencl.resthr.controller.ManagerController;
import com.stevencl.resthr.controller.TeamMemberController;
import com.stevencl.resthr.model.Manager;
import com.stevencl.resthr.repository.ManagerRepository;
import com.stevencl.resthr.repository.TeamMemberRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RestHrApplicationTest {

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private ManagerController managerController;

    @Autowired
    private TeamMemberRepository teamMemberRepository;

    @Autowired
    private TeamMemberController teamMemberController;

    @Test
    void contextLoads() {
        assertThat(managerRepository).isNotNull();
        assertThat(managerController).isNotNull();
        assertThat(teamMemberRepository).isNotNull();
        assertThat(teamMemberController).isNotNull();
    }

    @Test
    void managerIntegrationTests() {
        List<Manager> managers = new ArrayList<>();
        managerRepository.findAll().forEach(managers::add);
        assertThat(managers).hasSize(3);

        String first = "Linda";
        String last = "Carter";
        String email = "lcarter@domain.com";
        managerRepository.save(new Manager(first, last, email));

        var result = managerRepository.findById(4L);
        assert(result.isPresent());
        var manager = result.get();
        assert(manager.getFirstName().equals(first));
        assert(manager.getLastName().equals(last));
        assert(manager.getEmail().equals(email));

        managerRepository.deleteById(4L);
        result = managerRepository.findById(4L);
        assert(result.isEmpty());
    }

}
