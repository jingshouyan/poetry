package com.github.jingshouyan.peotry.impo.factory;

import com.github.jingshouyan.peotry.impo.AuthorImport;
import com.github.jingshouyan.peotry.impo.Import;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * @author jingshouyan
 * #date 2019/2/15 19:59
 */
@Component
public class ImportFactory {

    private AuthorImport authorImport;

    public Import getImport(String filename) {
        if(filename.startsWith("author")){
            return authorImport;
        }

        return null;
    }
}
