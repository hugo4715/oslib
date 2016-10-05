package oslib;

import static org.junit.Assert.*;

import org.junit.Test;

import oslib.bsd.BSDOperatingSystem;
import oslib.linux.DistroSpec;
import oslib.linux.LinuxOperatingSystem;
import oslib.osx.OSXOperatingSystem;
import oslib.solaris.SolarisOperatingSystem;
import oslib.windows.WindowsOperatingSystem;

public class TestDebug {

	@Test
	public void test() {
		AbstractOperatingSystem os = OperatingSystem.getOperatingSystem();

		String display = os.getDisplayString();
		String detailed = os.getDetailedString();

		System.out.println("Type: " + os.getType().name());

		if (os.getType() == OperatingSystem.WINDOWS) {
			WindowsOperatingSystem wos = (WindowsOperatingSystem) os;

			System.out.println("Windows Version: " + wos.getVersion().getSearch());
		} else if (os.getType() == OperatingSystem.OSX) {
			OSXOperatingSystem xos = (OSXOperatingSystem) os;

			System.out.println("OSX Version: " + xos.getVersion().getDisplay() + ", " + xos.getVersion().getVersion());
		} else if (os.getType() == OperatingSystem.LINUX) {
			LinuxOperatingSystem los = (LinuxOperatingSystem) os;

			DistroSpec d = los.getDistroSpec();

			System.out.println("Distro: " + d.getDistro().getDisplayString());
			System.out.println("Codename: " + d.getCodename());
			System.out.println("Release: " + d.getRelease());
		} else if (os.getType() == OperatingSystem.BSD) {
			BSDOperatingSystem bos = (BSDOperatingSystem) os;

			System.out.println("Flavor: " + bos.getFlavor().getName());
		} else if (os.getType() == OperatingSystem.SOLARIS) {
			SolarisOperatingSystem sos = (SolarisOperatingSystem) os;

		}

		System.out.println("Display: " + display);
		System.out.println("Detailed: " + detailed);
	}

}
