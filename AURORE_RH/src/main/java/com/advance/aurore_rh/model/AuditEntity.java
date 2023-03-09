package com.advance.aurore_rh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.annotation.PostConstruct;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.time.LocalDateTime;
import java.util.TimeZone;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public  abstract class AuditEntity {

    @Version
    protected Long version = 0L;

    @CreatedDate
    protected LocalDateTime date_creation = LocalDateTime.now();

    @LastModifiedDate
    protected LocalDateTime date_modif = LocalDateTime.now();

    @CreatedBy
    protected String util_creation = "SYSTEM";

    @LastModifiedDate
    @JsonIgnore
    protected String util_modif = "SYSTEM";
    protected Character forwarded = 'N';

    @PostConstruct
    void postConstruct(){
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

}
