package com.ozkan.musicStore.Service;


import com.ozkan.musicStore.DTO.InstrumentDto;
import com.ozkan.musicStore.Model.Instrument;

import java.util.List;

public interface InstrumentServiceI
{

    Instrument saveInstrument(InstrumentDto instrumentDto);

    void deleteInstrument(Long id);

    List<Instrument> findAllInstruments();
}
