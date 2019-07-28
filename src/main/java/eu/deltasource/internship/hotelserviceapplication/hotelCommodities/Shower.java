package eu.deltasource.internship.hotelserviceapplication.hotelCommodities;

import eu.deltasource.internship.hotelserviceapplication.hotelCommodities.domain.AbstractCommodity;

/**
 *{@inheritDoc}
 */
public class Shower extends AbstractCommodity {
	private static int STATIC_INVENTORY_NUMBER;

	/**
	 * A constructor of the Shower class.
	 * Takes no formal parameters.
	 * Increments the total number of objects created,
	 * and uses it to set the inventory number of the currently created object.
	 */
	public Shower() {
		STATIC_INVENTORY_NUMBER++;
		inventoryNumber = STATIC_INVENTORY_NUMBER;
	}

	/**
	 * An inherited from the base class method.
	 * Used to clean the shower.
	 */
	public void prepare() {
		System.out.println("The shower is being cleaned.");
	}

	@Override
	public boolean equals(Object compareObject) {
		if (!(compareObject instanceof Shower)) return false;
		Shower temporaryCommodity = (Shower) compareObject;
		return this.inventoryNumber == temporaryCommodity.inventoryNumber;
	}
}
