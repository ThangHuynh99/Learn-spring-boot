package com.laptrinhjavaweb.dto;

public class NewDTO extends AbstractDTO<NewDTO> {

	private String title;
	private String thumbnail;
	private String shortDescription;
	private String content;
	private Long categoryID;
	//dung categoryCode la string vi client gui len la string
	private String categoryCode;
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getThumbnail() {
		return thumbnail;
	}


	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}


	public String getShortDescription() {
		return shortDescription;
	}


	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Long getCategoryID() {
		return categoryID;
	}


	public void setCategoryID(Long categoryID) {
		this.categoryID = categoryID;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	public String getCategoryCode() {
		return categoryCode;
	}


	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

}
