package fr.hugo4715.oslib.windows;

import fr.hugo4715.oslib.OperatingSystem;

public class WindowsDetector {
	
	public static boolean detect(boolean fallback) {
		if (fallback) {
			return System.getProperty("os.name").toLowerCase().contains(OperatingSystem.WINDOWS.getPrimarySearch());
		}
		
		return false;
	}

}
