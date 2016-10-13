package fr.hugo4715.oslib.solaris;

import java.io.Serializable;

import fr.hugo4715.oslib.Arch;
import fr.hugo4715.oslib.OperatingSystem;
import fr.hugo4715.oslib.UnixOperatingSystem;

public class SolarisOperatingSystem extends UnixOperatingSystem implements Serializable {
	
	private static final long serialVersionUID = -9050140134144959153L;

	public SolarisOperatingSystem() {
		this(Arch.getArch());
	}
	
	public SolarisOperatingSystem(Arch arch) {
		super(OperatingSystem.SOLARIS, arch);
	}

	@Override
	public String getDisplayString() {
		return "Solaris";
	}

}
