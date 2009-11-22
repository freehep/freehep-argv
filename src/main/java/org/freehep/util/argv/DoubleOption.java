// Copyright 2004-2009, FreeHEP.
package org.freehep.util.argv;

import java.math.BigDecimal;

/**
 * 
 * 
 * @author Mark Donszelmann
 */
public class DoubleOption extends NumberOption {

	public DoubleOption(String flag, String name, String description) {
		super(flag, name, description);
	}

	public DoubleOption(String flag, String shortCut, String name,
			String description) {
		super(flag, shortCut, name, description);
	}

	public DoubleOption(String flag, String name, double defaultValue,
			String description) {
		super(flag, name, new BigDecimal(defaultValue), description);
	}

	public DoubleOption(String flag, String shortCut, String name,
			double defaultValue, String description) {
		super(flag, shortCut, name, new BigDecimal(defaultValue), description);
	}

	public double getDouble() {
		return super.getValue().doubleValue();
	}

}
