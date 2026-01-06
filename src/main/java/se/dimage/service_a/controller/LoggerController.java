package se.dimage.service_a.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.dimage.service_a.service.LoggerService;

import java.net.MalformedURLException;

@RestController
@RequestMapping("/hello")
@RequiredArgsConstructor
public class LoggerController {
    private final LoggerService service;

    @GetMapping
    public ResponseEntity<String> getMessage() {
        return ResponseEntity.ok(service.getMessage());
    }
}
