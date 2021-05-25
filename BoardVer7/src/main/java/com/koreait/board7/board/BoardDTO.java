package com.koreait.board7.board;

public class BoardDTO {
	private int recordCnt;
	private int startIdx;
	private int searchType;
	private String searchText;
	private int ibaord;
	
	public int getIbaord() {
		return ibaord;
	}
	public void setIbaord(int ibaord) {
		this.ibaord = ibaord;
	}
	public int getSearchType() {
		return searchType;
	}
	public void setSearchType(int searchType) {
		this.searchType = searchType;
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	public int getRecordCnt() {
		return recordCnt;
	}
	public void setRecordCnt(int recordCnt) {
		this.recordCnt = recordCnt;
	}
	public int getStartIdx() {
		return startIdx;
	}
	public void setStartIdx(int startIdx) {
		this.startIdx = startIdx;
	}
	
}
