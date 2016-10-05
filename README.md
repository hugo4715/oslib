# oslib

Java library to easily detect running Operating System, BSD Flavor, Linux Distribution, Desktop Environment and Architecture
This is the mavenized version

# Builds

Available at https://gitlab.com/hugo4715/oslib/builds

# Authors

Originally made by redpois0n
Mavenized by Hugo4715

## Examples

### Detecting if running Elementary OS (Linux)
```java
AbstractOperatingSystem os = OperatingSystem.getOperatingSystem();

if (os.getType() == OperatingSystem.LINUX) {
	LinuxOperatingSystem los = (LinuxOperatingSystem) os;

	if (los.getDistro() == Distro.ELEMENTARY_OS) {
		System.out.println("Is running eOS");
	} else {
		System.out.println("Is running " + los.getDisplayString());
	}
}
```

### Getting all information available about current OS
```java
AbstractOperatingSystem os = OperatingSystem.getOperatingSystem();

if (os.getType() == OperatingSystem.OSX) {
  	OSXOperatingSystem xos = (OSXOperatingSystem) os;

   	if (xos.getVersion() == OSXVersion.YOSEMITE) {
   		System.out.println("Is running Yosemite " + xos.getVersion().getVersion());
    	// Will print: Is running Yosemite 10.10
  	}

   	System.out.println(xos.getDisplayString());
   	// Will print (if running mavericks): Mac OS X Mavericks 10.9
}

if (os.getType() == OperatingSystem.LINUX) {
	LinuxOperatingSystem los = (LinuxOperatingSystem) os;

	System.out.println(los.getDisplayString());
	// Will print (if running Kali): Kali Linux 1.0

	if (los.getArch() == Arch.x86_64) {
		System.out.println("Is 64 bit");
	}
}
```

### Current Known Compatibility:

_Note:_ These are the only ones I have tested with. Will work well on untested systems, but the checked ones are absolutely working.
Linux distro and BSD flavor detection after 1.0 is based on [screenFetch](https://github.com/KittyKatt/screenFetch)

- [x] Mac OS X
- [x] Windows
- [ ] Arch Linux
- [x] Fedora
- [x] Linux Mint
- [x] Ubuntu
- [x] Debian
- [ ] Crunchbang
- [ ] Gentoo
- [ ] Funtoo
- [x] FreeBSD
- [x] OpenBSD
- [ ] NetBSD
- [ ] DragonFlyBSD
- [x] OpenSUSE
- [ ] Mandriva/Mandrake
- [ ] Slackware
- [ ] Red Hat (RHEL)
- [ ] Frugalware
- [x] Peppermint
- [ ] SolusOS
- [ ] Mageia
- [ ] ParabolaGNU/Linux-libre
- [ ] Viperr
- [ ] LinuxDeepin
- [ ] Chakra
- [ ] Trisquel
- [x] Manjaro
- [x] elementary OS
- [ ] Scientific Linux
- [x] Kali Linux
- [ ] Sabayon
- [ ] NixOS
- [ ] Crux
- [ ] Lunar Linux
- [ ] BLAG
- [ ] gNewSense
- [ ] Dragora
- [ ] Chapeau
- [ ] KDE neon
- [ ] Oracle Linux
- [ ] Qubes
- [x] Linux (If no distro detected or failed to detect)
- [x] Solaris
