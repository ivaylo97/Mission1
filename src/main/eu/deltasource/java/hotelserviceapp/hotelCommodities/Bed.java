package hotelserviceapp.hotelCommodities;

import hotelserviceapp.hotelCommodities.BedTypes.BedTypes;
import hotelserviceapp.hotelCommodities.domain.AbstractCommodity;

public class Bed extends AbstractCommodity {

	private BedTypes bedType;
	private boolean isDeployed;

	public Bed(String bedType) {
		initStaticInventoryNumber();
		STATIC_INVENTORY_NUMBER++;
		inventoryNumber = STATIC_INVENTORY_NUMBER;
		this.bedType = BedTypes.valueOf(bedType.toUpperCase());
	}

	public Bed(BedTypes bedType) {
		initStaticInventoryNumber();
		STATIC_INVENTORY_NUMBER++;
		inventoryNumber = STATIC_INVENTORY_NUMBER;
		this.bedType = bedType;
	}

	public Bed() {
		initStaticInventoryNumber();
		STATIC_INVENTORY_NUMBER++;
		inventoryNumber = STATIC_INVENTORY_NUMBER;
		bedType = BedTypes.valueOf("SINGLE");
	}

	/**
	 * @return Returns the current bed's bed type.
	 */
	public BedTypes getBedType() {
		return bedType;
	}

	/**
	 * isDeployed is a boolean variable that acts as an indicator whether the bed is already deployed in a room.
	 * This method is used to set it to true.
	 */
	//TODO :: some way of un-deployment .
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
