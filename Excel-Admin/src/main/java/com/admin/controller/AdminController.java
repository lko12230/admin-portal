package com.admin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final WebClient webClient;

    @Value("${app.main.url}")
    private String mainApp;

    public AdminController(WebClient.Builder builder) {
        this.webClient = builder.build();
    }

    @PostMapping("/maintenance/on")
    public Map<String, Object> enableMaintenance() {

        Map<String, Object> res = new HashMap<>();

        try {
            callMainPost("/api/admin/maintenance/on");
            res.put("status", "SUCCESS");
            res.put("message", "🚨 Maintenance Enabled");

        } catch (Exception e) {
            res.put("status", "FAILED");
            res.put("message", "Main App Down ❌");
        }

        return res;
    }

    @PostMapping("/maintenance/off")
    public Map<String, Object> disableMaintenance() {

        Map<String, Object> res = new HashMap<>();

        try {
            callMainPost("/api/admin/maintenance/off");
            res.put("status", "SUCCESS");
            res.put("message", "✅ Maintenance Disabled");

        } catch (Exception e) {
            res.put("status", "FAILED");
            res.put("message", "Main App Down ❌");
        }

        return res;
    }

    @GetMapping("/health")
    public Map<String, Object> health() {

        Map<String, Object> res = new HashMap<>();
        res.put("admin", "UP");

        try {
            Object health = callMainObj("/actuator/health");
            res.put("mainApp", "UP");
            res.put("details", health);

        } catch (Exception e) {
            res.put("mainApp", "DOWN");
        }

        return res;
    }

    @GetMapping("/cpu")
    public Object cpu() {
        return safeCall("/actuator/metrics/system.cpu.usage");
    }

    @GetMapping("/memory")
    public Object memory() {
        return safeCall("/actuator/metrics/jvm.memory.used");
    }

    private Object safeCall(String uri) {
        try {
            return callMainObj(uri);
        } catch (Exception e) {
            return Map.of("status", "DOWN");
        }
    }

    private void callMainPost(String uri) {
        webClient.post()
                .uri(mainApp + uri)
                .retrieve()
                .bodyToMono(String.class)
                .timeout(Duration.ofSeconds(5))
                .block();
    }

    private Object callMainObj(String uri) {
        return webClient.get()
                .uri(mainApp + uri)
                .retrieve()
                .bodyToMono(Object.class)
                .timeout(Duration.ofSeconds(5))
                .block();
    }
}