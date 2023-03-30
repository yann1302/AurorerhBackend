package com.advance.aurore_rh.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "AUTH_USER")
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(callSuper = false)


public class User extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long create_id;
    @Column(length = 50)
    private String username;
    private String password;
    @Email
    @Column(unique =true )
    private String email;
    @OneToOne
    @JoinColumn(name = "employer_id" )
    private Employer employer;

    public static final class UserBuilder {
        private long create_id;
        private String username;
        private String password;
        private @Email String email;
        private Employer employer;

        private UserBuilder() {
        }

        public static UserBuilder anUser() {
            return new UserBuilder();
        }

        public UserBuilder create_id(long create_id) {
            this.create_id = create_id;
            return this;
        }

        public UserBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder employer(Employer employer) {
            this.employer = employer;
            return this;
        }

        public User build() {
            User user = new User();
            user.setCreate_id(create_id);
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setEmployer(employer);
            return user;
        }
    }
}
