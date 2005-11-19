// Copyright 2005, FreeHEP.
package org.freehep.util.argv;

import java.util.Collections;
import java.util.List;

/**
 * A Multiple String option for use with ArgumentParser. This allows for multiple
 * occurences of this option with a string (typically -I for compilers). The result is
 * a List of Strings.
 *
 * @author Mark Donszelmann
 * @version $Id: src/main/java/org/freehep/util/argv/MultiStringOption.java a98adf3dfd10 2005/11/19 07:52:18 duns $
 */

public class MultiStringOption implements Option {
    private String flag;
    private String shortCut;
    private String name;
    private String desc;
    private List value = Collections.EMPTY_LIST;

    public MultiStringOption( String flag, String name, String description ) {
        this(flag, null, name, description);
    }
    
    public MultiStringOption( String flag, String shortCut, String name, String description ) {
        this.flag = flag;
        this.shortCut = shortCut;
        this.name = name;
        this.desc = description;
    }

    public List getValue() {
        return value;
    }

    public int parse( List values ) throws MissingArgumentException {
        if( values.get( 0 ).equals( flag ) || values.get(0).equals(shortCut)) {
            if( values.size() == 1 ) {
                throw new MissingArgumentException( flag+": expects '"+name+"' of type <string>" );
            }

            value.add((String)( values.get( 1 )));
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
