package com.jsoft.framework.ssm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Index Controller
 *
 * @author jim
 * @date 2018/04/25
 */
@Controller
public class IndexController {
    
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ModelAndView index() {
        logger.info("访问index视图");
        ModelAndView index = new ModelAndView("index");
        index.addObject("message", "hello world");
        return index;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String hello(ModelMap modelMap) {
        logger.info("访问hello视图");
        modelMap.addAttribute("message", "hello world");
        return "hello";
    }
}
