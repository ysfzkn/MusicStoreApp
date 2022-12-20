package com.ozkan.musicStore.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "instrumentModels")
public class InstrumentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model_name", nullable = false, length = 50)
    private String modelName;
}