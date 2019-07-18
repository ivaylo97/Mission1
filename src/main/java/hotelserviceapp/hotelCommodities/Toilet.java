package hotelserviceapp.hotelCommodities;

import hotelserviceapp.hotelCommodities.domain.AbstractCommodity;

public class Toilet extends AbstractCommodity {
	public Toilet() {
		initStaticInventoryNumber();
		STATICINVENTORYNUMBER++;
		inventoryNumber = STATICINVENTORYNUMBER;
	}

	public void prepare() {
		System.out.println("The toilet is being cleaned.");
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
