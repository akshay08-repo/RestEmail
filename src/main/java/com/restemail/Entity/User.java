package com.restemail.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(value = {AuditingEntityListener.class})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String fname;
    private String lname;
    private String emailId;
    @CreatedDate
    @Column(name = "created_date",updatable = false)
    private Timestamp createdDate;
    @Column(name = "updated_date")
    @LastModifiedDate
    private Timestamp updatedDate;
    @Column(name = "created_by",updatable = false)
    @CreatedBy
    private String createdBy;
    @Column(name = "updated_by")
    @LastModifiedBy
    private String updatedBy;

}
