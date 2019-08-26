package com.example.demo;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RssService {

	@Autowired
	private RestTemplate restTemplate;

	public String getFeed() {
		return restTemplate.getForObject("https://blogpeople.blog.me/rss", String.class);
	}

	public String getFeedByRest(String id) {
		Map<String, String> urlVariables = Collections.singletonMap("id", id);
		return restTemplate.getForObject("http://localhost:8080/get/{id}", String.class, urlVariables);
	}

}
