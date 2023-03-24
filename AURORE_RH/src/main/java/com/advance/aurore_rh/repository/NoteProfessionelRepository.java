package com.advance.aurore_rh.repository;

import com.advance.aurore_rh.model.Formation;
import com.advance.aurore_rh.model.NoteProfessionel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NoteProfessionelRepository extends JpaRepository<NoteProfessionel,Long> {

    @Query("SELECT e FROM NoteProfessionel e " +
            "WHERE ( e.theme like :token or e.description like :token   )"
    )
    Page<NoteProfessionel> findAllByToken(String token, Pageable pageable);
}
