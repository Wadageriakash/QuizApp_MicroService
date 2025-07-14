package com.telusko.question_service.questionentity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Response {

	private Integer id;
	private String response;

	
	public Integer getId() {
		return id;
	}
	public String getResponse() {
		return response;
	}
	
}
