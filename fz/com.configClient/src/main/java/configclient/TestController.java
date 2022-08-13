package configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${userN}")
    private String userN;

    @RequestMapping("/getUserN")
        public String getUserName(){
            return userN;
        }
    }

