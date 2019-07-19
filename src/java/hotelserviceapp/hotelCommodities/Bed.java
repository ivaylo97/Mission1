package hotelserviceapp.hotelCommodities;

import hotelserviceapp.hotelCommodities.domain.AbstractCommodity;

public class Bed extends AbstractCommodity {

	private int numberOfPersonas;

	public enum BedTypes {
		SINGLE,
		DOUBLE,
		KINGSIZE,
		COUCH,
	}

	BedTypes bedType;

	public Bed() {
		STATICINVENTORYNUMBER++;
		inventoryNumber = STATICINVENTORYNUMBER;
		bedType = BedTypes.SINGLE;
		setNumberOfPersonas();
	}

	private void setNumberOfPersonas() {
		switch (bedType) {
			case SINGLE:
			case COUCH: {
				numberOfPersonas = 1;
				break;
			}
			case DOUBLE:
			case KINGSIZE: {
				numberOfPersonas = 2;
				break;
			}
		}
	}

	public void setNumberOfPersonas(int numberOfPersons) {
		this.numberOfPersonas = numberOfPersons;
	}

	public BedTypes getBedType() {
		return bedType;
	}

	public void prepare() {
		System.out.println("The bed sheets are being replaced.");
	}

	@Override
	public int hashCode() {
		return this.inventoryNumber;
	}
}

