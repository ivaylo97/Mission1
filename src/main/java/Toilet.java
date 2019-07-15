public class Toilet extends AbstractCommodity {
	Toilet() {
		inventoryNumber = hashCode();
	}
	public void Prepare() {
		System.out.println("The toilet is being cleaned.");
	}
}
