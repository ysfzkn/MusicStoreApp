package com.ozkan.musicStore.Service;

import com.ozkan.musicStore.DTO.PurchaseHistoryDto;
import com.ozkan.musicStore.Model.*;
import com.ozkan.musicStore.Repository.InstrumentRepositoryI;
import com.ozkan.musicStore.Repository.Projection.PurchaseItemI;
import com.ozkan.musicStore.Repository.PurchaseHistoryRepositoryI;
import com.ozkan.musicStore.Repository.UserRepositoryI;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseHistoryService implements PurchaseHistoryServiceI
{
    private final PurchaseHistoryRepositoryI purchaseHistoryRepository;
    private final UserRepositoryI userRepository;
    private final InstrumentRepositoryI instrumentRepository;

    public PurchaseHistoryService(PurchaseHistoryRepositoryI purchaseHistoryRepository, UserRepositoryI userRepository, InstrumentRepositoryI instrumentRepository)
    {
        this.purchaseHistoryRepository = purchaseHistoryRepository;
        this.userRepository = userRepository;
        this.instrumentRepository = instrumentRepository;
    }

    @Override
    public PurchaseHistory savePurchaseHistory(PurchaseHistoryDto purchaseHistoryDto)
    {
        PurchaseHistory purchaseHistory = dtoToEntity(purchaseHistoryDto);
        Instrument instrument = instrumentRepository.findById(purchaseHistoryDto.getInstrumentId()).get();
        User user = userRepository.findById(purchaseHistoryDto.getUserId()).get();
        purchaseHistory.setInstrument(instrument);
        purchaseHistory.setUser(user);
        purchaseHistory.setPurchaseTime(LocalDateTime.now());
        return purchaseHistoryRepository.save(purchaseHistory);
    }

    private PurchaseHistory dtoToEntity(PurchaseHistoryDto purchaseHistoryDto) {
        PurchaseHistory purchaseHistory = new PurchaseHistory();
        BeanUtils.copyProperties(purchaseHistoryDto, purchaseHistory);
        return purchaseHistory;
    }

    @Override
    public List<PurchaseItemI> findPurchasedItemsOfUser(Long userId)
    {
        return purchaseHistoryRepository.findAllPurchasesOfUser(userId);
    }
}
