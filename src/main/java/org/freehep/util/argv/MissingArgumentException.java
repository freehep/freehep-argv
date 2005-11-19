// Copyright 2004, FreeHEP.
package org.freehep.util.argv;

import java.io.*;
import java.math.*;
import java.util.*;

/**
 * 
 *
 * @author Mark Donszelmann
 * @version $Id: src/main/java/org/freehep/util/argv/MissingArgumentException.java f7331332881b 2005/11/19 00:04:58 duns $
 */ 
public class MissingArgumentException extends Exception {
    public MissingArgumentException(String msg) {
        super(msg);
    }
}
