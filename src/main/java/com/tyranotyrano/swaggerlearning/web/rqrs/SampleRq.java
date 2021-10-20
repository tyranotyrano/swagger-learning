package com.tyranotyrano.swaggerlearning.web.rqrs;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@ApiModel(description = "SampleRq 모델")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SampleRq {

	@ApiModelProperty(value = "ID", required = true, example = "1")
	private Long id;
}
