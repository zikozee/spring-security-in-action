package com.zikozee.authorizationregexmatchers.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Ezekiel Eromosei
 * @created : 31 Dec, 2021
 */

@RestController
public class VideoController {

    @GetMapping(path = "video/{country}/{language}")
    public String video(@PathVariable String country, @PathVariable String language){
        return "Video allowed for " + country + " " + language;
    }
}
