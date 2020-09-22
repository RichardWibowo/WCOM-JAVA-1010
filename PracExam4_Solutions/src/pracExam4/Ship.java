package pracExam4;

class Ship {
	private int crewSize;
	private String shipName;

	public int getCrewSize() {
		return crewSize;
	}

	public String getShipName() {
		return shipName;
	}

	public void setCrewSize(int crewSize) {
		if (crewSize < 0)
			crewSize = 0;
		this.crewSize = crewSize;
	}

	public void setName(String shipName) {
		this.shipName = shipName;
	}

	public Ship(int crewSize, String shipName) {
		setCrewSize(crewSize);
		setName(shipName);
	}

	public int compareTo(Ship other) {
		if (crewSize > other.getCrewSize())
			return 1;
		if (crewSize < other.getCrewSize())
			return -1;
		return 0;
	}

	public boolean equals(Object other) {
		if (!(other instanceof Ship))
			return false;
		Ship s = (Ship) other;
		if (s.getCrewSize() == crewSize)
			return true;
		return false;
	}
}