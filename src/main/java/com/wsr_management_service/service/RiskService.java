package com.wsr_management_service.service;

import java.util.List;

import com.wsr_management_service.entity.Risk;

public interface RiskService {

    Risk save(Risk risk);

    List<Risk> getAllRisks();

    Risk getRiskById(Long id);

    List<Risk> getRisksByWeeklyUpdate(Long updateId);

    void deleteRisk(Long id);
}