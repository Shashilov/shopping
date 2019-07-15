package com.shopping.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import com.shopping.mapper.TbContentCategoryMapper;
import com.shopping.mapper.TbContentMapper;
import com.shopping.pojo.TbContent;
import com.shopping.pojo.TbContentCategory;
import com.shopping.pojo.TbContentExample;
import com.shopping.pojo.TbContentExample.Criteria;
import com.shopping.pojogroup.contentgroup;
import com.shopping.service.contentService;
@Service
public class contentServiceimpl implements contentService{

	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private TbContentCategoryMapper contentcategorymapper;
	
	@Autowired
	private TbContentMapper contentmapper;
	

	@Override
	public List<TbContent> findpicture(Long id) {
		// 加入缓存的代码:
		List<TbContent> list = (List<TbContent>) redisTemplate.boundHashOps("content").get(id);
		
		if(list==null){
			System.out.println("查询数据库===================");
			TbContentExample example = new TbContentExample();
			Criteria criteria = example.createCriteria();
			// 有效广告:
			criteria.andStatusEqualTo("1");
			
			criteria.andCategoryIdEqualTo(id);
			// 排序
			example.setOrderByClause("sort_order");
			
			list = contentmapper.selectByExample(example);
			
			redisTemplate.boundHashOps("content").put(id, list);
		}else{
			System.out.println("从缓存中获取====================");
		}
		
		
		return list;
	}


	@Override
	public List<TbContent> findcontent() {
		List<TbContent> list = (List<TbContent>) redisTemplate.boundHashOps("contentall").get(1);
		if (list==null) {
		 list = contentmapper.selectByExample(null);
		 
			redisTemplate.boundHashOps("contentall").put(1, list);
				
		}
		else {
			System.out.println("从redis中取数据");
		}
		
		return list;
	}


	@Override
	public contentgroup findone(Long id) {
		System.out.println("findone+id"+id);
		contentgroup contentgroup2;
		
		 contentgroup2 = (contentgroup) redisTemplate.boundHashOps("contentgroup").get(id);
	 if (contentgroup2==null) {
		 TbContent selectByPrimaryKey = contentmapper.selectByPrimaryKey(id);
		 List<TbContentCategory> selectByExample = contentcategorymapper.selectByExample(null);
		 
		 contentgroup2=	new contentgroup(selectByExample, selectByPrimaryKey);
		
		
		 redisTemplate.boundHashOps("contentgroup").put(id, contentgroup2);
	}else {
		System.out.println("在redis里面找");
	}
		
		
		
		return contentgroup2;
	}


	@Override
	public contentgroup findsecond() {
		contentgroup contentgroup2;
		
		 contentgroup2 = (contentgroup) redisTemplate.boundHashOps("contentgroupnew").get(99);
	 if (contentgroup2==null) {
		
		 List<TbContentCategory> selectByExample = contentcategorymapper.selectByExample(null);
		 
		 contentgroup2=	new contentgroup(selectByExample, null);
		
		
		 redisTemplate.boundHashOps("contentgroupnew").put(99, contentgroup2);
	}else {
		System.out.println("在redis里面找");
	}
		
		
		
		return contentgroup2;
	}
}
