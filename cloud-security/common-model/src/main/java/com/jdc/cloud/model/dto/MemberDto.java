package com.jdc.cloud.model.dto;

import java.time.LocalDate;

public record MemberDto(
		int id,
		String name,
		String loginId,
		Role role,
		LocalDate registAt
		) {

}
