package com.ozkan.musicStore.Repository;

import com.ozkan.musicStore.Model.InstrumentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InstrumentModelRepositoryI extends JpaRepository<InstrumentModel, Long> {

    Optional<InstrumentModel> findByModelName(String modelName);
    boolean existsByModelName(String modelName);
}
