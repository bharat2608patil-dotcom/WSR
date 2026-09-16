package com.wsr_management_service.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "wsr_reports")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WSRReport extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reportId;

	@ManyToOne
	@JoinColumn(name = "team_id")
	private Team team;

	private LocalDate weekStart;

	private LocalDate weekEnd;

	@Lob
	private String reportSummary;

	@ManyToOne
	@JoinColumn(name = "generated_by")
	private User generatedBy;

	@ManyToOne
	@JoinColumn(name = "approved_by")
	private User approvedBy;

	private String approvalStatus;
}