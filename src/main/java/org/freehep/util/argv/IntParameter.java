// Copyright 2004, FreeHEP.
package org.freehep.util.argv;


/**
 * 
 *
 * @author Mark Donszelmann
 * @version $Id: src/main/java/org/freehep/util/argv/IntParameter.java a98adf3dfd10 2005/11/19 07:52:18 duns $
 */ 
public class IntParameter extends NumberParameter {

    public IntParameter(String name, String description) {
        super(name, description);
    }
        
    public int getInt() {
        return super.getValue().intValue();
    }
      
}
