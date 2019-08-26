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

	@GetMapping("/get/naver")
	public String get() {
		return rssService.getFeed();
	}

	@PostMapping("/rss")
	public String post(@RequestBody RssDto rssDto) {
		if (rssDto.getId() == null || rssDto.getId().isBlank()) {
			throw new IllegalArgumentException("id cannot be null");
		}
		return rssService.getFeedByRest(rssDto.getId());
	}

}
