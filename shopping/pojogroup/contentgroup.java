package com.shopping.pojogroup;

import java.io.Serializable;
import java.util.List;

import com.shopping.pojo.TbContent;
import com.shopping.pojo.TbContentCategory;

public class contentgroup implements Serializable{

	private  List<TbContentCategory> contentCategory;
	private TbContent content;
	public contentgroup() {
		super();
	}
	public contentgroup(List<TbContentCategory> contentCategory, TbContent content) {
		super();
		this.contentCategory = contentCategory;
		this.content = content;
	}
	public List<TbContentCategory> getContentCategory() {
		return contentCategory;
	}
	public void setContentCategory(List<TbContentCategory> contentCategory) {
		this.contentCategory = contentCategory;
	}
	public TbContent getContent() {
		return content;
	}
	public void setContent(TbContent content) {
		this.content = content;
	}
	
}
