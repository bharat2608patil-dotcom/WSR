package com.wsr_management_service.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "weekly_updates")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeeklyUpdate extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long updateId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;

	private LocalDate weekStart;

	private LocalDate weekEnd;

	@Column(columnDefinition = "TEXT")
	private String accomplishments;

	@Column(columnDefinition = "TEXT")
	private String plannedWork;

	@Column(columnDefinition = "TEXT")
	private String blockers;

	private String status;

}