package com.example.demo.ServiceImpl;

import com.example.demo.Model.BlogResponseDto;
import com.example.demo.Service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {
   // private final BlogService blogService;
   private final RestTemplate restTemplate = new RestTemplate();
    private final String CLIENT_ID = "nNyF_A5HdfCwqHO9KWwm";
    private final String CLIENT_SECRET = "MdlqFBZjRF";

    private final String BLOG_URL = "https://openapi.naver.com/v1/search/blog.json?query={keyword}";
    @Override
    public BlogResponseDto findByKeyword(String keyword) {

        final HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", CLIENT_ID);
        headers.set("X-Naver-Client-Secret", CLIENT_SECRET);

        final HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(BLOG_URL, HttpMethod.GET, entity, BlogResponseDto.class, keyword).getBody();

    }
}
