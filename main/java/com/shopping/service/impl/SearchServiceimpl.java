package com.shopping.service.impl;

import com.shopping.pojo.TbItem;
import com.shopping.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class SearchServiceimpl implements SearchService{

	
	@Autowired
	private SolrTemplate solrTemplate;
	
	@Override
	public Map searchMap(Map searchMap) {
		
		Map map=new HashMap();
		
		System.out.println("map"+searchMap);
	
		Query simpleQuery = new SimpleQuery("*:*");
		Criteria criteria = new Criteria("item_keywords").is(searchMap.get("keywords"));
		simpleQuery.addCriteria(criteria);
		ScoredPage<TbItem> page = solrTemplate.queryForPage("collection1", simpleQuery, TbItem.class);
		map.put("rows", page.getContent());
	
		return map;
	}

}
