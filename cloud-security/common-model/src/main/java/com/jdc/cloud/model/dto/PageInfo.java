package com.jdc.cloud.model.dto;

public record PageInfo(
		long pageNumber,
		long pageSize,
		long totalCount
) {

}
