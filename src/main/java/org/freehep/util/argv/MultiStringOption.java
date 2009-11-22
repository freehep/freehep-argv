// Copyright 2005-2009, FreeHEP.
package org.freehep.util.argv;

import java.util.ArrayList;
import java.util.List;

/**
 * A Multiple String option for use with ArgumentParser. This allows for
 * multiple occurences of this option with a string (typically -I for
 * compilers). The result is a List of Strings.
 * 
 * @author Mark Donszelmann
 */

public class MultiStringOption implements Option {
	private String flag;
	private String shortCut;
	private String name;
	private String desc;
	private List<String> value = new ArrayList<String>();

	public MultiStringOption(String flag, String name, String description) {
		this(flag, null, name, description);
	}

	public MultiStringOption(String flag, String shortCut, String name,
			String description) {
		this.flag = flag;
		this.shortCut = shortCut;
		this.name = name;
		this.desc = description;
	}

	public List<String> getValue() {
		return value;
	}

	public int parse(List<String> values) throws MissingArgumentException {
		if (values.get(0).equals(flag) || values.get(0).equals(shortCut)) {
			if (values.size() == 1) {
				throw new MissingArgumentException(flag + ": expects '" + name
						+ "' of type <string>");
			}

			value.add((values.get(1)));
			return 2;
		}
		return 0;
	}

	public String getOption() {
		StringBuffer s = new StringBuffer(flag);
		s.append(" <");
		s.append(name);
		s.append(">");
		return s.toString();
	}

	public String getUsage() {
		return desc;
	}
}
