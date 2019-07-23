package eu.deltasource.internship.hotelserviceapplication.hotelCommodities;

import eu.deltasource.internship.hotelserviceapplication.hotelCommodities.domain.AbstractCommodity;



// see {@inheritDoc}
/**
 * One of the inheritors of the AbstractCommodity class ,representing the Bed commodity.
 * Uses only inherited member from the base class.
 */
public class Toilet extends AbstractCommodity {

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
}
