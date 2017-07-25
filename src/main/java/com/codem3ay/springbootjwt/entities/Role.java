package com.codem3ay.springbootjwt.entities;

import com.codem3ay.springbootjwt.entities.base.BaseEntity;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.Set;

/**
 * Created by HABCHI Hamza on 11/07/2017 - 19:23.
 */
@Entity
public class Role extends BaseEntity implements GrantedAuthority {

    private String role;

    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
    private Set<User> users;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String getAuthority () {
        return "ROLE_"+role;
    }


}

