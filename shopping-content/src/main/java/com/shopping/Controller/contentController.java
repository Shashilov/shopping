package com.shopping.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.pojo.TbContent;
import com.shopping.pojogroup.contentgroup;
import com.shopping.service.contentService;

@RestController
@RequestMapping("/content")
public class contentController {

	@Autowired
	private contentService contentservice;
	@RequestMapping(value="/findpicture",method=RequestMethod.GET)
	public List<TbContent> findpicture(Long id){
	System.out.println("进入到findpicture");
		
		return contentservice.findpicture(id);
		
	}
	
	
	
	@RequestMapping(value="/findcontent",method=RequestMethod.GET)
	public List<TbContent> findcontent(){
	System.out.println("进入到findcontent");
		
		return contentservice.findcontent();	
	}
	
	
	@RequestMapping(value="/findone",method=RequestMethod.GET)
	public contentgroup findone(Long id){
	System.out.println("进入到findcontentid"+id);
		
		return contentservice.findone(id);	
	}
	
	
	
	@RequestMapping(value="/findsecond",method=RequestMethod.GET)
	public contentgroup findsecond(){
	System.out.println("进入到findsecond");
		
		return contentservice.findsecond();	
	}
	
}
