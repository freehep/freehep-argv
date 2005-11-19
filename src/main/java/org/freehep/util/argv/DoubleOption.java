// Copyright 2004, FreeHEP.
package org.freehep.util.argv;

import java.io.*;
import java.math.*;
import java.util.*;

/**
 * 
 *
 * @author Mark Donszelmann
 * @version $Id: src/main/java/org/freehep/util/argv/DoubleOption.java f7331332881b 2005/11/19 00:04:58 duns $
 */ 
public class DoubleOption extends NumberOption {

    public DoubleOption(String flag, String name, String description) {
        super(flag, name, description);
    }
    
    public DoubleOption(String flag, String shortCut, String name, String description) {
        super(flag, shortCut, name, description);
    }
    
    public DoubleOption(String flag, String name, double defaultValue, String description) {
        super(flag, name, new BigDecimal(defaultValue), description);
    }
    
    public DoubleOption(String flag, String shortCut, String name, double defaultValue, String description) {
        super(flag, shortCut, name, new BigDecimal(defaultValue), description);
    }
    
    public double getDouble() {
        return super.getValue().doubleValue();
    }
      
}
