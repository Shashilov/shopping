package com.shopping.service;

import java.util.List;

import com.shopping.pojo.TbContent;
import com.shopping.pojo.TbContentCategory;
import com.shopping.pojogroup.contentgroup;

public interface contentService {
	public List<TbContent> findpicture(Long id);
	public List<TbContent> findcontent();
	public contentgroup findone(Long id);
	public contentgroup findsecond();
}
