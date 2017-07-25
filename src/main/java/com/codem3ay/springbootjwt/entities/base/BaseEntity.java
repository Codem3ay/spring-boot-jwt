package com.codem3ay.springbootjwt.entities.base;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by HABCHI Hamza on 11/07/2017 - 19:25.
 */
@MappedSuperclass
public class BaseEntity {

    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
