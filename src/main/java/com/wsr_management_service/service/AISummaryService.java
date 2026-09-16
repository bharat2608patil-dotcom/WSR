package com.wsr_management_service.service;

import java.util.List;

import com.wsr_management_service.entity.AISummary;

public interface AISummaryService {

    AISummary save(AISummary aiSummary);

    List<AISummary> getAllSummaries();

    AISummary getSummaryById(Long id);

    AISummary getSummaryByUpdateId(Long updateId);

    void deleteSummary(Long id);
}