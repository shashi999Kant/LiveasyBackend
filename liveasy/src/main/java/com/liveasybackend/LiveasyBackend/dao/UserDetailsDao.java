package com.liveasybackend.LiveasyBackend.dao;

import com.liveasybackend.LiveasyBackend.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsDao extends JpaRepository<UserDetails,String> {
}
