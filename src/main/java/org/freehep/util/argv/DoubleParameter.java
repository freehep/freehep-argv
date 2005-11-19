// Copyright 2004, FreeHEP.
package org.freehep.util.argv;

import java.io.*;
import java.math.*;
import java.util.*;

/**
 * 
 *
 * @author Mark Donszelmann
 * @version $Id: src/main/java/org/freehep/util/argv/DoubleParameter.java f7331332881b 2005/11/19 00:04:58 duns $
 */ 
public class DoubleParameter extends NumberParameter {

    public DoubleParameter(String name, String description) {
        super(name, description);
    }
        
    public double getDouble() {
        return super.getValue().doubleValue();
    }
      
}
