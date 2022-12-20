package com.ozkan.musicStore.DTO;

import com.ozkan.musicStore.Model.InstrumentModel;
import com.ozkan.musicStore.Model.InstrumentType;
import com.ozkan.musicStore.Model.PurchaseHistory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstrumentDto {

    private String name;

    private String model;

    private String type;

    private Double price;

    private byte[] picByte;
}
