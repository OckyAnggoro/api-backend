package com.app.base;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
public class Response<E> {

	private String message;
	private List<E> resultList;
	private Long count;
	private E result;

	public Response(E result) {
		this.result = result;
	}

	public Response(List<E> resultList, Long count) {
		this.resultList = resultList;
		this.count = count;
	}

	public Response(String message) {
		this.message = message;
	}

	public Response(String message, List<E> resultList, Long count) {
		this.message = message;
		this.resultList = resultList;
		this.count = count;
	}
}
