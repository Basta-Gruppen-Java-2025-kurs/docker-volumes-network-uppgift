package se.dimage.service_a.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URL;

@Slf4j
@RequiredArgsConstructor
@Service
public class LoggerService {
    @Value("${service_b.url}")
    private String url;

    public String getMessage() {
        try {
            URL url_b = new URL(url);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "";
    }
}
