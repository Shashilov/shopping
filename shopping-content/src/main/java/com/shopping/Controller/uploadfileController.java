package com.shopping.Controller;

import java.io.File;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shopping.pojo.RequestMessage;
import com.shopping.pojo.TbContent;

@RestController
@RequestMapping("/uploadpic")
public class uploadfileController {

	@RequestMapping("/upload")
	public RequestMessage upload(MultipartFile file) {
		System.out.println("进入到upload");
		System.out.println(file);
		try {
			String path="D:/file";
			String url="";
			if (file!=null&&file.getSize()>0) {
				file.transferTo(new File(path, file.getOriginalFilename()));
				url="http://localhost:8887/upload/"+file.getOriginalFilename();
			}
			return new RequestMessage(true, url);
		} catch (Exception e) {
			return new RequestMessage(false, "上传失败");
		}
		
	
		
	}
	
	
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public RequestMessage save(@RequestBody TbContent tbcontent) {
		System.out.println("进入到save");
		System.out.println(tbcontent.getPic());
		System.out.println(tbcontent.getTitle());
		System.out.println(tbcontent.getCategoryId());
		System.out.println(tbcontent.getStatus());
		
		return null;
	
		
	}
}
