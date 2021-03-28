package com.gnc.projectcardsystem.domain;

import com.gnc.projectcardsystem.enums.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "COMPANY", uniqueConstraints = {@UniqueConstraint(columnNames = {"CODE"})})
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CODE", length = 50, nullable = false)
    private String code;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "STATE", nullable = false)
    private State state = State.ACTIVE;

}
