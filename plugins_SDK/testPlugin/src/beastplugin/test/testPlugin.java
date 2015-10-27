package beastplugin.test;
import java.util.*;

import beastplugin.test.*;
import dr.app.plugin.*;
import dr.xml.XMLObjectParser;
public class testPlugin implements Plugin {

	public Set<XMLObjectParser> getParsers() {
		Set<XMLObjectParser> parsers = new HashSet<XMLObjectParser>();
		testPluginParser pluginParser = new testPluginParser();
		parsers.add(pluginParser);
		return parsers;
	}
	
}
