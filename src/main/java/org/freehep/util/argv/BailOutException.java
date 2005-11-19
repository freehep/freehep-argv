// Copyright 2004, FreeHEP.
package org.freehep.util.argv;


/**
 * Exception to handle options such as -version or -help which need to bail out from 
 * the parsing loop.
 *
 * @author Mark Donszelmann
 * @version $Id: src/main/java/org/freehep/util/argv/BailOutException.java a98adf3dfd10 2005/11/19 07:52:18 duns $
 */ 
public class BailOutException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8748945748952662967L;

	public BailOutException() {
        super();
    }
}
