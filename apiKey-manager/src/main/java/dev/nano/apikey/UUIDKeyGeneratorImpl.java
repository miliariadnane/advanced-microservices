package dev.nano.apikey;

import java.util.UUID;

public class UUIDKeyGeneratorImpl implements KeyGenerator {
    @Override
    public String generateKey() {
        return UUID.randomUUID().toString();
    }
}
