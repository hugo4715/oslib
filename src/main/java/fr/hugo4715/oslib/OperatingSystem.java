package fr.hugo4715.oslib;

import fr.hugo4715.oslib.bsd.BSDOperatingSystem;
import fr.hugo4715.oslib.bsd.Flavor;
import fr.hugo4715.oslib.bsd.FlavorDetector;
import fr.hugo4715.oslib.linux.DistroDetector;
import fr.hugo4715.oslib.linux.LinuxDetector;
import fr.hugo4715.oslib.linux.LinuxOperatingSystem;
import fr.hugo4715.oslib.osx.OSXDetector;
import fr.hugo4715.oslib.osx.OSXOperatingSystem;
import fr.hugo4715.oslib.solaris.SolarisDetector;
import fr.hugo4715.oslib.solaris.SolarisOperatingSystem;
import fr.hugo4715.oslib.windows.WindowsDetector;
import fr.hugo4715.oslib.windows.WindowsOperatingSystem;

public enum OperatingSystem {

	WINDOWS("Windows", "win"),
	OSX("Mac OS X", "mac"),
	LINUX("Linux", "linux"),
	SOLARIS("Solaris", "solaris", "sunos"),
	BSD("BSD"),
	UNKNOWN("unknown", "unknown");
	
	private static AbstractOperatingSystem cache;
		
	private String name;
	private String[] search;
	
	private OperatingSystem(String name, String... search) {
		this.name = name;
		this.search = search;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String[] getSearch() {
		return this.search;
	}
	
	public String getPrimarySearch() {
		return this.search[0];
	}
	
	/**
	 * Gets the operating system (Not linux distro)
	 * @param str String like System.getProperty("os.name");
	 * @return
	 */
	public static OperatingSystem getOperatingSystem(String str) {
		str = str.toLowerCase();

		OperatingSystem os = null;
		
		for (OperatingSystem o : OperatingSystem.values()) {
			if (os != null) {
				break;
			}
			
			if (o.getName().equalsIgnoreCase(str)) {
				os = o;
				break;
			}
			
			for (String s : o.getSearch()) {
				if (str.contains(s)) {
					os = o;
					break;
				}
			}
		}

		return os;
	}
	
	public static AbstractOperatingSystem getOperatingSystem() {
		return getOperatingSystem(true);
	}

	/**
	 * Gets this machines operating system
	 * @return
	 */
	public static AbstractOperatingSystem getOperatingSystem(boolean b) {
		AbstractOperatingSystem os = null;
		
		if (cache == null) {
			Flavor flavor = FlavorDetector.detect(b);
						
			if (flavor != null) {
				os = new BSDOperatingSystem(flavor);
			}
					
			if (LinuxDetector.detect(b)) {
				os = new LinuxOperatingSystem(DistroDetector.detect());
			}
			
			if (OSXDetector.detect(b)) {
				os = new OSXOperatingSystem();
			}
			
			if (WindowsDetector.detect(b)) {
				os = new WindowsOperatingSystem();
			}
			
			if (SolarisDetector.detect(b)) {
				os = new SolarisOperatingSystem();
			}

			if (os == null) {
				os = new UnknownOperatingSystem();
			}
			
			if (os instanceof UnixOperatingSystem) {
				UnixOperatingSystem uos = (UnixOperatingSystem) os;
				uos.setDetailed(Utils.getUname());
			}
			cache = os;
		} else {
			os = cache;
		}
		
		return os;
	}
	
	/**
	 * Forces reloading of data next time retreiving operating system
	 */
	public static void clearCache() {
		cache = null;
	}
	
	public static boolean isUnix() {
		return isUnix(getOperatingSystem().getType());
	}
	
	public static boolean isUnix(OperatingSystem os) {
		return os == BSD || os == OSX || os == LINUX || os == SOLARIS;
	}

}
