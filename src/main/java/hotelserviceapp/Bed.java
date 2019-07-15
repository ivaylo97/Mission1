package hotelserviceapp;

public class Bed extends AbstractCommodity {
	private int numberOfPersonas;

	Bed() {
		initStaticInventoryNumber();
		StaticInventoryNumber++;
		inventoryNumber = StaticInventoryNumber;
		numberOfPersonas = 1;
	}

	public void setNumberOfPersonas(int numberOfPersons) {
		this.numberOfPersonas = numberOfPersons;
	}

	public int getNumberOfPersonas() {
		return numberOfPersonas;
	}

	public void prepare() {
		System.out.println("The beds sheets are being replaced.");
	}

	@Override
	public int hashCode() {
		return this.inventoryNumber;
	}

	private void initStaticInventoryNumber() {
		if (inventoryNumber == 0) {
			inventoryNumber = 1;
		}
	}
}
