package com.project.resto.app.controller;

import com.project.resto.app.model.response.ApiResponse;
import com.project.resto.app.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/v1/api")
@Slf4j
public class StatusController {

    @GetMapping("/app-status")
    public ResponseEntity<ApiResponse<String>> getAppStatus() {
        log.info("Requested application running status.");

        ApiResponse<String> response = ApiResponse.<String>builder()
                .success(true)
                .message(Constants.SUCCESS)
                .Data(Constants.UP)
                .timeStamp(LocalDateTime.now())
                .build();
        log.info("getAppStatus() exit response {}",response);
        return ResponseEntity.ok(response);
    }
}
