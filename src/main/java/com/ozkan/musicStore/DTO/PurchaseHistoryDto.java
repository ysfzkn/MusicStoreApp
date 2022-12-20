package com.ozkan.musicStore.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseHistoryDto {

    private Long userId;

    private Long instrumentId;

    private Double price;

    private LocalDateTime purchaseTime;
}
