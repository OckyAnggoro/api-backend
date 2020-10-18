package com.app.base;

public class TableRequest {
	
	private Integer page;
	private Integer size;
	private PaginationPropertySort paginationPropertySort;
	private String search;
	
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public PaginationPropertySort getPaginationPropertySort() {
		return paginationPropertySort;
	}

	public void setPaginationPropertySort(
			PaginationPropertySort paginationPropertySort) {
		this.paginationPropertySort = paginationPropertySort;
	}
	
	class PaginationPropertySort {
		private String direction;
		private String property;
		
		public String getDirection() {
			return direction;
		}
		public void setDirection(String direction) {
			this.direction = direction;
		}
		public String getProperty() {
			return property;
		}
		public void setProperty(String property) {
			this.property = property;
		}
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
}
