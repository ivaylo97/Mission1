package hotelserviceapp.hotelCommodities;

import hotelserviceapp.hotelCommodities.BedTypes.BedTypes;

public class Bed extends AbstractCommodity {

	private BedTypes.BedType bedType;
	private boolean isDeployed;

	public Bed(String bedType) {
		initStaticInventoryNumber();
		STATICINVENTORYNUMBER++;
		inventoryNumber = STATICINVENTORYNUMBER;
		this.bedType = BedTypes.BedType.valueOf(bedType.toUpperCase());
	}

	public Bed(BedTypes.BedType bedType) {
		initStaticInventoryNumber();
		STATICINVENTORYNUMBER++;
		inventoryNumber = STATICINVENTORYNUMBER;
		this.bedType = bedType;
	}

	public Bed() {
		initStaticInventoryNumber();
		STATICINVENTORYNUMBER++;
		inventoryNumber = STATICINVENTORYNUMBER;
		bedType = BedTypes.BedType.valueOf("SINGLE");
	}

	/**
	 * @return Returns the current bed's bed type.
	 */
	public BedTypes.BedType getBedType() {
		return bedType;
	}

	/**
	 * isDeployed is a boolean variable that acts as an indicator whether the bed is already deployed in a room.
	 * This method is used to set it to true.
	 */
	public void deployBed() {
		isDeployed = true;
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
