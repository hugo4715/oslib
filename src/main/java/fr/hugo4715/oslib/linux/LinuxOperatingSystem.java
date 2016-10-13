package fr.hugo4715.oslib.linux;

import java.io.Serializable;

import fr.hugo4715.oslib.Arch;
import fr.hugo4715.oslib.OperatingSystem;
import fr.hugo4715.oslib.UnixOperatingSystem;

public class LinuxOperatingSystem extends UnixOperatingSystem implements Serializable {

	private static final long serialVersionUID = -1997336870542013705L;
	
	private DistroSpec ds;
	
	public LinuxOperatingSystem(Distro d) {
		this(new DistroSpec(d), Arch.getArch());
	}
	
	public LinuxOperatingSystem(DistroSpec ds, Arch arch) {
		super(OperatingSystem.LINUX, arch);
		this.ds = ds;
	}
	
	public LinuxOperatingSystem() {
		this(Distro.getLocalDistroSpec(), Arch.getArch());
	}
	
	public LinuxOperatingSystem(DistroSpec ds) {
		this(ds, Arch.getArch());
	}

	public Distro getDistro() {
		return this.ds.getDistro();
	}
	
	public DistroSpec getDistroSpec() {
		return this.ds;
	}

	@Override
	public String getDisplayString() {
		Distro d = ds.getDistro();
				
		String name = d.getDisplayString();
		
		if (ds.getRelease() != null) {
			name += " " + ds.getRelease();
		}
		
		return name;
	}

}
