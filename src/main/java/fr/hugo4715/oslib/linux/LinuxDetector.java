package fr.hugo4715.oslib.linux;

import fr.hugo4715.oslib.OperatingSystem;

public class LinuxDetector {
	
	public static boolean detect(boolean fallback) {
		if (fallback) {
			return System.getProperty("os.name").toLowerCase().contains(OperatingSystem.LINUX.getPrimarySearch());
		}
		
		return false;
	}

}
