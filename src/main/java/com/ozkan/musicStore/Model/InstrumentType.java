package com.ozkan.musicStore.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "instrumentTypes")
public class InstrumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_name", nullable = false, length = 50)
    private String typeName;
}
