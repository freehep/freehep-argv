// Copyright 2004-2009, FreeHEP.
package org.freehep.util.argv;

import java.util.List;

/**
 * A String parameter for use with ArgumentParser.
 * 
 * @author Mark Donszelmann
 */

public class StringParameter implements Parameter {
	private String name;
	private String desc;
	private String value = null;

	/**
	 * Initialize a new String argument with the given flag and description but
	 * without a default value.
	 */

	public StringParameter(String name, String description) {
		this.name = name;
		this.desc = description;
	}

	/**
	 * Return the string value of this argument, which may be null. Returns the
	 * default value if the value was not set when the command line was parsed.
	 */

	public String getValue() {
		return value;
	}

	/**
	 * Parsing method invoked by ArgumentParser.
	 */

	public int parse(List<String> values) throws MissingArgumentException {
		if (values.size() < 1) {
			throw new MissingArgumentException("Parameter '" + name
					+ "' of type <string> expected");
		}

		value = (values.get(0));
		return 1;
	}

	public String getName() {
		return "<" + name + ">";
	}

	/**
	 * Usage method invoked by ArgumentParser.
	 */

	public String getUsage() {
		return desc;
	}
}
