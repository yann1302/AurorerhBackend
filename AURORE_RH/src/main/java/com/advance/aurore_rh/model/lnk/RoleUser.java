package com.advance.aurore_rh.model.lnk;

import com.advance.aurore_rh.model.AuditEntity;
import com.advance.aurore_rh.model.Role;
import com.advance.aurore_rh.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lnk_role_user")
public class RoleUser extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role_user")
    private Long id;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne(targetEntity = Role.class)
    @JoinColumn(name = "id_role")
    private Role role;

    @Column(name = "date_alloc")
    private LocalDateTime dateAlloc = LocalDateTime.now();

//    public static RoleUser buildFromIdUserIdRole(Long idUser, Long idRole) {
//        return RoleUser.builder()
//                .user(User.UserBuilder.anUser().withId(idUser).build())
//                .role(Role.builder().id(idRole).build())
//                .build();
//    }
}
