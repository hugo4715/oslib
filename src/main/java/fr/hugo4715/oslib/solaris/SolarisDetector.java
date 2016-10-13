package fr.hugo4715.oslib.solaris;

import fr.hugo4715.oslib.OperatingSystem;

public class SolarisDetector {
	
	public static boolean detect(boolean fallback) {
		if (fallback) {
			for (String search : OperatingSystem.SOLARIS.getSearch()) {
				if (System.getProperty("os.name").toLowerCase().contains(search)) {
					return true;
				}
			}
		}
		
		return false;
	}

}
