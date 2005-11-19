// Copyright 2004, FreeHEP.
package org.freehep.util.argv;

import java.io.*;
import java.math.*;
import java.util.*;

/**
 * 
 *
 * @author Mark Donszelmann
 * @version $Id: src/main/java/org/freehep/util/argv/IntParameter.java f7331332881b 2005/11/19 00:04:58 duns $
 */ 
public class IntParameter extends NumberParameter {

    public IntParameter(String name, String description) {
        super(name, description);
    }
        
    public int getInt() {
        return super.getValue().intValue();
    }
      
}
