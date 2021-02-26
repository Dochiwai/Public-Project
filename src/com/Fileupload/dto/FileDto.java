package com.Fileupload.dto;

public class FileDto {
	private String filename;
	private String filerealname;
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilerealname() {
		return filerealname;
	}
	public void setFilerealname(String filerealname) {
		this.filerealname = filerealname;
	}
	public FileDto(String filename, String filerealname) {
		super();
		this.filename = filename;
		this.filerealname = filerealname;
	}
	
	
}
