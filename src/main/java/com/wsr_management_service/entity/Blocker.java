package com.wsr_management_service.entity;

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
@Table(name = "blockers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Blocker extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long blockerId;

	@ManyToOne
	@JoinColumn(name = "update_id")
	private WeeklyUpdate weeklyUpdate;

	@Column(columnDefinition = "TEXT")
	private String blockerDescription;

	private String owner;
}