package com.stevencl.resthr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>Spring Boot application used to manage employee records for HR purposes.</p>
 *
 * <p>The application uses H2 database as its data source and provides a
 * RESTful API for performing CRUD operations.</p>
 */
@SpringBootApplication
public class RestHrApplication {

    /**
     * Entry point for the application.
     *
     * @param args  command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(RestHrApplication.class, args);
    }

}
