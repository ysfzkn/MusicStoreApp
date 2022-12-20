package com.ozkan.musicStore.Service;

import com.ozkan.musicStore.DTO.InstrumentDto;
import com.ozkan.musicStore.Model.Instrument;
import com.ozkan.musicStore.Model.InstrumentModel;
import com.ozkan.musicStore.Model.InstrumentType;
import com.ozkan.musicStore.Repository.InstrumentModelRepositoryI;
import com.ozkan.musicStore.Repository.InstrumentRepositoryI;
import com.ozkan.musicStore.Repository.InstrumentTypeRepositoryI;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InstrumentService implements InstrumentServiceI
{
    private final InstrumentRepositoryI instRepository;
    private final InstrumentModelRepositoryI instrumentModelRepository;
    private final InstrumentTypeRepositoryI instrumentTypeRepository;

    public InstrumentService(InstrumentRepositoryI instRepository,
                             InstrumentModelRepositoryI instrumentModelRepository,
                             InstrumentTypeRepositoryI instrumentTypeRepository)
    {
        this.instRepository = instRepository;
        this.instrumentModelRepository = instrumentModelRepository;
        this.instrumentTypeRepository = instrumentTypeRepository;
    }

    @Override
    public Instrument saveInstrument(InstrumentDto instrumentDto)
    {
        Instrument instrument = dtoToEntity(instrumentDto);
        instrument.setCreateTime(LocalDateTime.now());
        InstrumentModel model = checkAndGetModel(instrumentDto.getModel());
        InstrumentType type = checkAndGetType(instrumentDto.getType());
        instrument.setModel(model);
        instrument.setType(type);

        return instRepository.save(instrument);
    }

    private InstrumentModel checkAndGetModel(String modelName) {
        if (instrumentModelRepository.existsByModelName(modelName))
            return instrumentModelRepository.findByModelName(modelName).get();
        else{
            InstrumentModel model = new InstrumentModel();
            model.setModelName(modelName);
            return instrumentModelRepository.save(model);
        }
    }

    private InstrumentType checkAndGetType(String typeName) {
        if (instrumentTypeRepository.existsByTypeName(typeName))
            return instrumentTypeRepository.findByTypeName(typeName).get();
        else{
            InstrumentType type = new InstrumentType();
            type.setTypeName(typeName);
            return instrumentTypeRepository.save(type);
        }
    }

    private Instrument dtoToEntity(InstrumentDto instrumentDto) {
        Instrument instrument = new Instrument();
        BeanUtils.copyProperties(instrumentDto, instrument);
        return instrument;
    }
    @Override
    public void deleteInstrument(Long id)
    {
        instRepository.deleteById(id);
    }

    @Override
    public List<Instrument> findAllInstruments()
    {
        return instRepository.findAll();
    }

}
