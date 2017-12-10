package br.com.poc.api.dto;

import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

public class PageDTO {
	
	private int page;
	
	private Optional<String> order = Optional.of("id");
	
	private Optional<String>  direction = Optional.of("DESC");

	public int getPage() {
		return page;
	}
	
	public PageRequest getPageRequest(int pageSize){
		PageRequest pageRequest = new PageRequest(getPage(), pageSize, Direction.valueOf(getDirection().get()), order.get());
		return pageRequest;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Optional<String> getOrder() {
		return order;
	}

	public void setOrder(Optional<String> order) {
		this.order = order;
	}

	public Optional<String> getDirection() {
		return direction;
	}

	public void setDirection(Optional<String> direction) {
		this.direction = direction;
	}
	
	
	

}
