// Copyright 2004, FreeHEP.
package org.freehep.util.argv;

import java.io.*;
import java.math.*;
import java.util.*;

/**
 * Exception to handle options such as -version or -help which need to bail out from 
 * the parsing loop.
 *
 * @author Mark Donszelmann
 * @version $Id: src/main/java/org/freehep/util/argv/BailOutException.java f7331332881b 2005/11/19 00:04:58 duns $
 */ 
public class BailOutException extends Exception {
    public BailOutException() {
        super();
    }
}
