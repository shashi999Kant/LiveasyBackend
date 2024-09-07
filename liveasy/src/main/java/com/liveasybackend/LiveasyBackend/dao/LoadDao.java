package com.liveasybackend.LiveasyBackend.dao;

import com.liveasybackend.LiveasyBackend.model.Loads;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoadDao extends JpaRepository<Loads,String> {
    List<Loads> findByLoadingPoint(String startingPoint);
    List<Loads> findByUnloadingPoint(String loadingPoint);
    List<Loads> findByProductType(String productType);
}
