package eu.deltasource.internship.hotelserviceapplication.hotelCommodities;

import eu.deltasource.internship.hotelserviceapplication.hotelCommodities.domain.AbstractCommodity;

/**
 * One of the inheritors of the AbstractCommodity class ,representing the Bed commodity.
 * Uses only inherited member from the base class.
 */
public class Shower extends AbstractCommodity {
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
}
