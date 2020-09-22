import java.util.ArrayList;

public class Main<Comp> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Double> test = new ArrayList<Double>();
		test.add(1.0);
		test.add(2.0);
		test.add(-1.0);
		remNegative(test);
		System.out.println(test);
		
		ArrayList<comp> computer = new ArrayList<comp>();
		computer.add(new comp(8, "Intel i5"));
		computer.add(new comp(8, "Intel i5"));
		computer.add(new comp(16, "Intel i7"));
		computer.add(new comp(64, "Intel i9"));
		computer.add(new comp(4, "AMD Ryzen 5"));
		computer.add(new comp(32, "AMD Ryzen 7"));

		System.out.println(computer);
		totalRam(computer);
		System.out.println(totalRam(computer));
		System.out.println(totalCpu(computer));
		System.out.println(ramMoreThan(computer,17));

	}

	public static int totalRam(ArrayList<comp> list) {
		int Total = 0;
		for (comp item : list) {
			Total += item.getRam();
		}

		return Total;
	}

	public static int totalCpu(ArrayList<comp> list) {
			int count =0;
				for(int i =0;i<list.size();i++) {
					if(list.get(i).getCpu().contains("intel")||
							list.get(i).getCpu().contains("Intel")	) {
						count++;
					}
				}
		return count;
	}

	public static ArrayList<comp>ramMoreThan(ArrayList<comp> list, int minRam) {
		
		ArrayList<comp> answer = new ArrayList<comp>();
		
		for(comp item : list) {
			if(item.getRam() > minRam) {
				answer.add(item);
				}
			}
		return answer;
		}
public static void remNegative(ArrayList<Double> list){
		
		for(int i = 0 ; i < list.size(); i++) {
			if(list.get(i)<0) {
				list.remove(i);
				i--;
			}
		}
		
	}

	

}
