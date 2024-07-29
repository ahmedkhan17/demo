package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Value("${api.users.url}")
    private String usersUrl;

    @Value("${api.posts.url}")
    private String postsUrl;

    @Value("${api.comments.url}")
    private String commentsUrl;

    private final RestTemplate restTemplate;

    public ApiController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/users")
    public ResponseEntity<String> getAllUsers() {
        try {
            String users = restTemplate.getForObject(usersUrl, String.class);
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error fetching users");
        }
    }

    @GetMapping("/posts")
    public ResponseEntity<String> getAllPosts() {
        try {
            String posts = restTemplate.getForObject(postsUrl, String.class);
            return ResponseEntity.ok(posts);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error fetching posts");
        }
    }

    @GetMapping("/comments")
    public ResponseEntity<String> getAllComments() {
        try {
            String comments = restTemplate.getForObject(commentsUrl, String.class);
            return ResponseEntity.ok(comments);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error fetching comments");
        }
    }
}