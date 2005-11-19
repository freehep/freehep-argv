// Copyright 2004, FreeHEP.
package org.freehep.util.argv;

import java.math.BigDecimal;

/**
 * 
 *
 * @author Mark Donszelmann
 * @version $Id: src/main/java/org/freehep/util/argv/IntOption.java a98adf3dfd10 2005/11/19 07:52:18 duns $
 */ 
public class IntOption extends NumberOption {

    public IntOption(String flag, String name, String description) {
        super(flag, name, description);
    }
    
    public IntOption(String flag, String shortCut, String name, String description) {
        super(flag, shortCut, name, description);
    }
    
    public IntOption(String flag, String name, int defaultValue, String description) {
        super(flag, name, new BigDecimal(defaultValue), description);
    }
    
    public IntOption(String flag, String shortCut, String name, int defaultValue, String description) {
        super(flag, shortCut, name, new BigDecimal(defaultValue), description);
    }
    
    public int getInt() {
        return super.getValue().intValue();
    }
      
}
