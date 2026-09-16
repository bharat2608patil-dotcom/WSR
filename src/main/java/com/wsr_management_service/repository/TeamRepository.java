package com.wsr_management_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wsr_management_service.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

}