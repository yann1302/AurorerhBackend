package com.advance.aurore_rh.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "auth_role")
public class Role extends AuditEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "description", length = 5000)
    private String description;


    public Role(Long idRole) {
        this.id = idRole;
    }

    public Role(String name) {
        this.name = name;
    }

    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        //final Role role = (Role) obj;
        // boolean value = role.equals(role.name);
        return false;
    }

    @Override
    public String toString() {
        return "Role [name=" + name + "]" + "[id=" + id + "]";
    }

//    public void removeListeUser(User user) {
//        getUser().remove(user);
//        user.getRoles().remove(this);
//    }
//
//
//    public Set<User> getUser() {
//        if (users == null) {
//            users = new HashSet<>();
//        }
//        return this.users;
//    }
//
//    public void addUtilisateur(User user) {
//        getUser().add(user);
//        user.getRoles().add(this);
//    }
//
//    public void removeUtilisateur(User user) {
//        getUsers().remove(user);
//        user.getRoles().remove(this);
//    }
//
//


}
