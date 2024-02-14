package org.technous.bloggingApp.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class SecurityConfiguration {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable())
//                .cors(cors -> cors.disable())
//                .authorizeHttpRequests(req -> req
//                        .requestMatchers("/v2/api-docs").permitAll())
//                .authorizeHttpRequests(req->req
//                        .requestMatchers(HttpMethod.POST,"/api/user")
//                        .hasAnyRole("ADMIN").anyRequest().authenticated())
//                .httpBasic(Customizer.withDefaults());
//        return http.build();
//    }
//    @Bean
//    public UserDetailsService userDetailsService() {
//
//        UserDetails peter = User.builder().username("tisha")
//                .password(passwordEncoder().encode("tisha@123")).roles("USER")
//                .build();
//
//        UserDetails admin = User.builder().username("abc")
//                .password(passwordEncoder().encode("abc")).roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(peter,admin);
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

}