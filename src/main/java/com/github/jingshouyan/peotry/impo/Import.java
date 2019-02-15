package com.github.jingshouyan.peotry.impo;

/**
 * @author jingshouyan
 * #date 2019/2/15 21:15
 */
@FunctionalInterface
public interface Import {

    void action(String filename,String json);
}
