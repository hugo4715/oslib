package fr.hugo4715.oslib;

public abstract interface VersionCompare {
	
	/**
	 * Checks if current version is newer than e
	 * @param e
	 * @return
	 */
	public abstract boolean isNewer(Enum<?> e);
	
	/**
	 * Checks if current version is older than e
	 * @param e
	 * @return
	 */
	public abstract boolean isOlder(Enum<?> e);

}
