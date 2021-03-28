package com.gnc.projectcardsystem.domain;

import com.gnc.projectcardsystem.enums.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;


@Table(name = "APP_USER", uniqueConstraints = {@UniqueConstraint(columnNames = {"USER_NAME", "COMPANY_ID"})})
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @JoinColumn(name = "COMPANY_ID", nullable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private Company company;

    @Column(name = "PASSWORD", length = 200, nullable = false)
    private String password;

    @Column(name = "USERNAME", length = 50, nullable = false)
    private String username;

    @Column(name = "NAME", length = 50, nullable = false)
    private String name;

    @Column(name = "FULL_NAME", length = 100, nullable = false)
    private String fullName;

    @Column(name = "LAST_NAME", length = 50, nullable = false)
    private String lastName;


    @JoinTable(name = "USER_ROLE", joinColumns = {@JoinColumn(name = "USER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID")})
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private Set<Role> roles = new LinkedHashSet<>();

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "STATE", nullable = false)
    private State state = State.ACTIVE;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
