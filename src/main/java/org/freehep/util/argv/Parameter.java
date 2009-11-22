// Copyright 2004-2009, FreeHEP.
package org.freehep.util.argv;

import java.util.List;

/**
 * Interface for parameters that may be registered and parsed by the
 * ArgumentParser.
 */

public interface Parameter {
	/**
	 * Must check for a parameter. This method must return the number of
	 * arguments belonging to this parameter (normally one, but more for lists).
	 * 
	 * ArgumentParser.parse( values ) will invoke this method once for each
	 * possible starting position of this parameter in values.
	 */

	int parse(List<String> values) throws MissingArgumentException,
			ArgumentFormatException;

	/**
	 * Must return name of the parameter.
	 */
	String getName();

	/**
	 * Must return a description of the usage of this parameter.
	 */

	String getUsage();
};
