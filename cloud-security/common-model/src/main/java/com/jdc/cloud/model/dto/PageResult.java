package com.jdc.cloud.model.dto;

import java.util.List;

public record PageResult<T>(
		List<T> content,
		PageInfo page
		) {

}
