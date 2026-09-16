package com.wsr_management_service.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ai_summaries")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AISummary extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long summaryId;

	@OneToOne
	@JoinColumn(name = "update_id")
	private WeeklyUpdate weeklyUpdate;

	@Column(columnDefinition = "TEXT")
	private String generatedSummary;

	@Column(columnDefinition = "TEXT")
	private String generatedRisks;

	@Column(columnDefinition = "TEXT")
	private String generatedActionItems;

	private String aiModel;

}