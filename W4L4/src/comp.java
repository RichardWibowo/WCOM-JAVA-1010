
public class comp {
	private int ram;
	private String cpu;

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public comp(int ram,String cpu) {
		setCpu(cpu);
		setRam(ram);
	}
	public String toString() {
		return cpu +" "+ram;
	}


}
