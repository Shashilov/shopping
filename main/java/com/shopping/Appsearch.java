package com.shopping;

import org.apache.solr.client.solrj.SolrClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.solr.core.SolrTemplate;

@SpringBootApplication
@EnableEurekaClient
public class Appsearch {
public static void main(String[] args) {
	SpringApplication.run(Appsearch.class, args);
}

@Autowired
private SolrClient solrClient;

@Bean
public SolrTemplate solrTemplate() {
	return new SolrTemplate(solrClient);
	
}
}
