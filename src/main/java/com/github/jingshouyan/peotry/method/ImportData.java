package com.github.jingshouyan.peotry.method;

import com.github.jingshouyan.jrpc.base.bean.Token;
import com.github.jingshouyan.jrpc.server.method.Method;
import com.github.jingshouyan.peotry.helper.ImportHelpler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jingshouyan
 * #date 2019/2/26 16:42
 */
@Component("importData")
public class ImportData implements Method<String,Void> {
    @Autowired
    private ImportHelpler importHelpler;
    @Override
    public Void action(Token token, String s) {
        importHelpler.importData(s);
        return null;
    }
}
