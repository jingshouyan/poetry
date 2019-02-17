package com.github.jingshouyan.peotry.helper;

import com.github.jingshouyan.jrpc.base.bean.Req;
import com.github.jingshouyan.jrpc.base.bean.Rsp;
import com.github.jingshouyan.jrpc.base.bean.Token;
import com.github.jingshouyan.jrpc.base.code.Code;
import com.github.jingshouyan.jrpc.base.exception.JException;
import com.github.jingshouyan.jrpc.base.util.rsp.RspUtil;
import com.github.jingshouyan.jrpc.server.method.handler.ServerActionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jingshouyan
 * #date 2019/2/12 17:58
 */
@Component
@Slf4j
public class ApiHelper {

    @Autowired
    private ServerActionHandler serverActionHandler;

    public Rsp action(String ticket, String method, String param) {
        log.info("action: ticket[{}],method[{}],param[{}]",ticket,method,param);
        try {
            Token token = getToken(ticket, method);
            Req req = new Req();
            req.setMethod(method);
            req.setParam(param);
            return serverActionHandler.handle(token, req);
        } catch (JException e) {
            return RspUtil.error(e);
        } catch (Exception e) {
            log.error("server error", e);
            return RspUtil.error(Code.SERVER_ERROR);
        }
    }

    private Token getToken(String ticket, String method) {
        return new Token();
    }
}
