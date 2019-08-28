package club.xiaodaicoding.spring.boot.start.initializer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * example
 */
@RestController
public class example {

    @RequestMapping("/")
    public String helloworld() {
        return "Hello World";
    }
    
}