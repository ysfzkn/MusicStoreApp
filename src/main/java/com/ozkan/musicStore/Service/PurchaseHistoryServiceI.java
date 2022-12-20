package com.ozkan.musicStore.Service;

import com.ozkan.musicStore.DTO.PurchaseHistoryDto;
import com.ozkan.musicStore.Model.PurchaseHistory;
import com.ozkan.musicStore.Repository.Projection.PurchaseItemI;

import java.util.List;

public interface PurchaseHistoryServiceI
{
    PurchaseHistory savePurchaseHistory(PurchaseHistoryDto purchaseHistoryDto);

    List<PurchaseItemI> findPurchasedItemsOfUser(Long userId);
}
