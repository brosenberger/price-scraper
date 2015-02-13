package at.bro.code.pricingscraper

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ImportResource

@Slf4j
@CompileStatic
@ComponentScan
@Configuration
@ImportResource(value = "pricing_properties.xml")
@EnableAutoConfiguration
class PriceScraper{


    static void main(String... args) {
        SpringApplication.run(PriceScraper.class, args);
    }
}
