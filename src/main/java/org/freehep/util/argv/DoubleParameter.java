// Copyright 2004, FreeHEP.
package org.freehep.util.argv;


/**
 * 
 *
 * @author Mark Donszelmann
 * @version $Id: src/main/java/org/freehep/util/argv/DoubleParameter.java a98adf3dfd10 2005/11/19 07:52:18 duns $
 */ 
public class DoubleParameter extends NumberParameter {

    public DoubleParameter(String name, String description) {
        super(name, description);
    }
        
    public double getDouble() {
        return super.getValue().doubleValue();
    }
      
}
