package com.ozkan.musicStore.Repository;

import com.ozkan.musicStore.Model.InstrumentModel;
import com.ozkan.musicStore.Model.InstrumentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InstrumentTypeRepositoryI extends JpaRepository<InstrumentType, Long> {

    Optional<InstrumentType> findByTypeName(String typeName);
    boolean existsByTypeName(String typeName);
}
