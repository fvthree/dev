package com.fvthree.dev;

import static org.assertj.core.api.Assertions.assertThat;

import com.fvthree.dev.api.rest.user.entities.User;
import com.fvthree.dev.api.rest.user.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    UserRepository userRepository;

    @Test
    public void findByUsername_whenUserFound_returnUser() {
        testEntityManager.persist(TestUtils.createUser("FirstUser"));
        User user = userRepository.findByUsername("FirstUser");
        assertThat(user).isNotNull();
    }

    @Test
    public void findByUsername_whenUserNotFound_returnNull() {
        testEntityManager.persist(TestUtils.createUser("SecondUser"));
        User user = userRepository.findByUsername("FirstUser");
        assertThat(user).isNull();
    }

}
