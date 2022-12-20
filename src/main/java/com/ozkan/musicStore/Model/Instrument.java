package com.ozkan.musicStore.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table( name = "intruments" )
public class Instrument
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "name", nullable = false, length = 100)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "model_id", nullable = false)
    @JsonIgnore
    private InstrumentModel model;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id", nullable = false)
    @JsonIgnore
    private InstrumentType type;

    @Column( name = "price", nullable = false)
    private Double price;

    @Column(name = "picByte", length = 1000)
    private byte[] picByte;

    @Column( name = "create_time", nullable = false)
    private LocalDateTime createTime;
}
