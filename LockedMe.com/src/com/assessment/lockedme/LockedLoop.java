package com.assessment.lockedme;

public class LockedLoop {
	private boolean locked;
	private boolean bloLoop;

	public LockedLoop() {
		super();
		this.locked = true;
		this.bloLoop = true;
	}

	//main loop true
	public boolean isLocked() {
		return locked;
	}

	//main loop false
	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	//BLO loop true
	public boolean isBloLoop() {
		return bloLoop;
	}

	//BLO loop false
	public void setBloLoop(boolean bloLoop) {
		this.bloLoop = bloLoop;
	}

}
