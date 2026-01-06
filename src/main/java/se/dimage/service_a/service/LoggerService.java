package se.dimage.service_a.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Service
public class LoggerService {
    @Value("${service_b.url}")
    private String url;

    @Value("logfile")
    private String logFileName;

    public String getMessage() {
        String result = "";
        try {
            RestClient client = RestClient.create(url);
            result = client.get().retrieve().body(String.class);
            log(result);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return result;
    }

    public void log(String text) {
        log.info(text);
        try (FileWriter fw = new FileWriter(logFileName, true)) {
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write(text);
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
