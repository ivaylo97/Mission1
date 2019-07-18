package hotelserviceapp.hotelCommodities;

import hotelserviceapp.hotelCommodities.domain.AbstractCommodity;

public class Bed extends AbstractCommodity {

	public enum BedTypes{
		SINGLE,
		DOUBLE,
		KING_SIZE,
		COUCH,
	}
	private BedTypes bedType ;

	 public Bed() {
		initStaticInventoryNumber();
		STATICINVENTORYNUMBER++;
		inventoryNumber = STATICINVENTORYNUMBER;
		bedType = BedTypes.SINGLE;
	}

	public BedTypes getBedType(){
	 	return bedType;
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
