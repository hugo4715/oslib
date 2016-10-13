package fr.hugo4715.oslib.linux;

import fr.hugo4715.oslib.Utils;

public class CommandExistsType extends SearchType {
	
	private String cmd;
	
	public CommandExistsType(String cmd) {
		this.cmd = cmd;
	}

	@Override
	public boolean detect() {		
		try {
			Utils.readProcess(new String[] { cmd });
			
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return false;
	}

}
