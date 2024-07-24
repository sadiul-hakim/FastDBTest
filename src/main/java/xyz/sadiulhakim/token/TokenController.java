package xyz.sadiulhakim.token;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/v1/token")
@RequiredArgsConstructor
public class TokenController {
    private final TokenService tokenService;

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Token token) {
        String save = tokenService.save(token);
        return ResponseEntity.ok(Collections.singletonMap("message", save));
    }

    @GetMapping("/")
    public ResponseEntity<?> get(@RequestParam String name) {
        String save = tokenService.getToken(name);
        return ResponseEntity.ok(Collections.singletonMap("message", save));
    }

    @DeleteMapping("/")
    public ResponseEntity<?> remove(@RequestParam String name) {
        String save = tokenService.removeToken(name);
        return ResponseEntity.ok(Collections.singletonMap("message", save));
    }
}
