package xyz.sadiulhakim.token;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import xyz.sadiulhakim.FastDBClient;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class TokenService {
    private final FastDBClient fastDBClient;

    public String save(Token token) {
        String command = "insert " + token.name() + " " + token.token();
        try {
            return fastDBClient.sendCommand(command);
        } catch (IOException e) {
            log.error("Could not save token");
            throw new RuntimeException(e);
        }
    }

    public String getToken(String name) {
        try {
            String command = "get " + name;
            return fastDBClient.sendCommand(command);
        } catch (Exception ex) {
            log.error("Could not get token");
            throw new RuntimeException(ex);
        }
    }

    public String removeToken(String name) {
        try {
            String command = "remove " + name;
            return fastDBClient.sendCommand(command);
        } catch (Exception ex) {
            log.error("Could not remove token");
            throw new RuntimeException(ex);
        }
    }
}
