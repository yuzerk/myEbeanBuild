package com.example.ebean.modules.xmlResultTest;

import com.example.ebean.result.XMLResult;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author yuzk
 * @date 2017/11/24
 */
@RestController
@RequestMapping("/xml")
public class XmlController {

    @GetMapping("/test")
    public XMLResult xmlTest() {
        return new XMLResult().setCode(1).setMessage("this is a XML result test response");
    }

    @PostMapping(value = "/post",consumes = MediaType.APPLICATION_XML_VALUE)
    public XMLResult postTest(@RequestBody XMLResult xmlResult) {
        return new XMLResult().setCode(xmlResult.getCode()).setMessage(xmlResult.getMessage());
    }
}
