package com.github.jingshouyan.peotry.controller;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jingshouyan
 * #date 2019/2/12 17:26
 */

public abstract class BaseController {

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    public void responseJson(String json) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().print(json);
    }
}
