package com.github.jingshouyan.peotry.controller;

import com.github.jingshouyan.jrpc.base.bean.Rsp;
import com.github.jingshouyan.peotry.constant.PoetryConstant;
import com.github.jingshouyan.peotry.helper.ApiHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * @author jingshouyan
 * #date 2019/2/12 16:03
 */
@RestController
@RequestMapping("api")
@Slf4j
public class ApiController extends BaseController implements PoetryConstant {


    @Autowired
    ApiHelper apiHelper;

    @GetMapping("index")
    public String index() {
        return "index";
    }

    @RequestMapping("v1/{method}")
    public void api(@PathVariable String method) throws Exception {
        String param = getParam();
        String ticket = getTicket();
        Rsp rsp = apiHelper.action(ticket, method, param);
        responseJson(rsp.json());
    }

    private String getTicket() {
        String ticket = request.getParameter(PARAM_TICKET);
        if (null == ticket) {
            ticket = request.getHeader(HEADER_TICKET);
        }
        return ticket;
    }

    private String getParam() throws Exception {
        String param = request.getParameter(PARAM_PARAM);
        if (param == null) {
            try (InputStream in = request.getInputStream();
                 ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                param = out.toString("utf-8");
                if (null == param || "".equals(param)) {
                    param = "{}";
                }
            } catch (Exception e) {
                throw e;
            }
        }
        return param;
    }

}
