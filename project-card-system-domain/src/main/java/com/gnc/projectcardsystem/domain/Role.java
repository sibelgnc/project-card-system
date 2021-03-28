package com.gnc.projectcardsystem.domain;

import com.gnc.projectcardsystem.enums.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Table(name = "ROLE", uniqueConstraints = {@UniqueConstraint(columnNames = {"NAME", "COMPANY_ID"})})
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "COMPANY_ID", nullable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private Company company;

    @Column(name = "NAME", length = 50, nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", length = 100, nullable = false)
    private String description;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "STATE", nullable = false)
    private State state = State.ACTIVE;

    @Override
    public String getAuthority() {
        return this.name;
    }
}
