package com.github.jingshouyan.peotry.impo.factory;

import com.github.jingshouyan.peotry.impo.AuthorImport;
import com.github.jingshouyan.peotry.impo.Import;
import com.github.jingshouyan.peotry.impo.PoetImport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jingshouyan
 * #date 2019/2/15 19:59
 */
@Component
public class ImportFactory {

    @Autowired
    private AuthorImport authorImport;

    @Autowired
    private PoetImport poetImport;

    public Import getImport(String type) {
        switch (type) {
            case "authors": return authorImport;
            case "poet": return poetImport;
        }

        return null;
    }
}
