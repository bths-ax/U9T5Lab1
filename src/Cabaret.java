import java.util.ArrayList;

public class Cabaret {
	private String name;
	private ArrayList<Performer> performers;

	public Cabaret(String name) {
		this.name = name;
		this.performers = new ArrayList<Performer>();
	}

	public String getName() { return name; }
	public ArrayList<Performer> getPerformers() { return performers; }

	public boolean addPerformer(Performer performer) {
		if (performers.contains(performer))
			return false;
		performers.add(performer);
		return true;
	}

	public boolean removePerformer(Performer performer) {
		int idx = performers.indexOf(performer);
		if (idx == -1)
			return false;
		performers.remove(idx);
		return true;
	}

	public double averagePerformerAge() {
		int ageSum = 0;
		for (Performer performer : performers)
			ageSum += performer.getAge();
		return (double)ageSum / performers.size();
	}

	public ArrayList<Performer> performersOverAge(int age) {
		ArrayList<Performer> result = new ArrayList<Performer>();
		for (Performer performer : performers)
			if (performer.getAge() >= age)
				result.add(performer);
		return result;
	}

	public void groupRehearsal() {
		for (Performer performer : performers) {
			System.out.print("REHEARSAL CALL! ");
			System.out.println(performer.getName());
			if (performer instanceof Comedian) {
				((Comedian)performer).rehearse(false);
			} else {
				performer.rehearse();
			}
		}
	}

	public void cabaretShow() {
		for (Performer performer : performers) {
			System.out.print("Welcome to the cabaret! Next act up... ");
			System.out.println(performer.getName());
			if (performer instanceof Dancer)
				((Dancer)performer).pirouette(2);
			performer.perform();
		}
	}
}
