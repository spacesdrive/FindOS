package com.findos.api.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.dao.DataIntegrityViolationException;

// @DataJpaTest starts only the JPA slice and wraps each test in a transaction
// that is rolled back, so no rows are left behind.
// replace = NONE: use the real PostgreSQL (with Flyway), not an embedded DB,
// because the case-insensitive unique index only exists in PostgreSQL.
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void savesUserAndGeneratesIdTimestampsAndDefaultStatus() {
        User saved = userRepository.saveAndFlush(new User("Ada", "ada@example.com", "hash"));

        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getAccountStatus()).isEqualTo(UserStatus.PENDING);
        assertThat(saved.getCreatedAt()).isNotNull();
        assertThat(saved.getUpdatedAt()).isNotNull();
        assertThat(saved.getEmailVerifiedAt()).isNull();
    }

    @Test
    void rejectsEmailDifferingOnlyByCaseAndWhitespace() {
        userRepository.saveAndFlush(new User("Ada", "ada@example.com", "hash"));

        // flush forces the INSERT now, so PostgreSQL's unique index is what rejects it
        assertThatThrownBy(() ->
                userRepository.saveAndFlush(new User("Other", "  ADA@Example.com ", "hash")))
                .isInstanceOf(DataIntegrityViolationException.class);
    }
}
