package hotelserviceapp.hotelCommodities;

import hotelserviceapp.hotelCommodities.domain.AbstractCommodity;

public class Bed extends AbstractCommodity {
	private int numberOfPersonas;

	 public Bed() {
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
		System.out.println("The bed sheets are being replaced.");
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
