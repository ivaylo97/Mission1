package eu.deltasource.internship.hotelserviceapplication.hotelCommodities;

import eu.deltasource.internship.hotelserviceapplication.hotelCommodities.domain.AbstractCommodity;

/**
 *{@inheritDoc}
 */
public class Toilet extends AbstractCommodity {
	private static int STATIC_INVENTORY_NUMBER;

	/**
	 * A constructor of the Shower class.
	 * Takes no formal parameters.
	 * Increments the total number of objects created,
	 * and uses it to set the inventory number of the currently created object.
	 */
	public Toilet() {
		STATIC_INVENTORY_NUMBER++;
		inventoryNumber = STATIC_INVENTORY_NUMBER;
	}

	/**
	 * An inherited from AbstractCommodity method.
	 * Used to clean the toilet.
	 */
	public void prepare() {
		System.out.println("The toilet is being cleaned.");
	}

	@Override
	public boolean equals(Object compareObject) {
		if (!(compareObject instanceof Toilet)) return false;
		Toilet temporaryCommodity = (Toilet) compareObject;
		return this.inventoryNumber == temporaryCommodity.inventoryNumber;
	}
}
