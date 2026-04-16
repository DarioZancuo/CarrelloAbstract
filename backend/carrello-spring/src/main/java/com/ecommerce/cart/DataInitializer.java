package com.ecommerce.cart;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.ecommerce.cart.entity.jpa.User;
import com.ecommerce.cart.repository.UserRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
// Vincoliamo la creazione di TUTTO il componente alla proprietà
@ConditionalOnProperty(
    value = "app.features.db-init.enabled", 
    havingValue = "true", 
    matchIfMissing = false
)
public class DataInitializer {

    private final UserRepository userRepository;
    // Usiamo @Lazy per rompere eventuali cicli con la SecurityConfiguration
    @Lazy 
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        if (userRepository.findByUsername("rest").isEmpty()) {
            User uzr = new User();
            uzr.setUsername("rest");
            // L'encoder viene richiamato solo qui, quando serve davvero
            uzr.setPassword(passwordEncoder.encode("admin")); 
            userRepository.save(uzr);
            System.out.println("DEBUG: Utente " + uzr.getUsername() + " creato con successo!");
        }
    }
}