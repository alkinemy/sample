package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RssController {

	@Autowired
	private RssService rssService;


	//curl -XGET localhost:8080/get/naver
	@GetMapping("/get/naver")
	public String get() {
		return rssService.getFeed();
	}

	//curl -XPOST localhost:8080/rss -H "Content-Type: application/json" -d '{ "id": "naver" }'
	@PostMapping("/rss")
	public String post(@RequestBody RssDto rssDto) {
		if (rssDto.getId() == null || rssDto.getId().isBlank()) {
			throw new IllegalArgumentException("id cannot be null");
		}
		return rssService.getFeedByRest(rssDto.getId());
	}

}
