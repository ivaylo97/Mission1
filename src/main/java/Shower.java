public class Shower extends AbstractCommodity {
	Shower() {
		inventoryNumber = hashCode();
	}

	public void Prepare() {
		System.out.println("The shower is being cleaned.");
	}
}
