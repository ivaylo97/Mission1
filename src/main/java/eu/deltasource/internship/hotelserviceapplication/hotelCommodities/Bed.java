package eu.deltasource.internship.hotelserviceapplication.hotelCommodities;

import eu.deltasource.internship.hotelserviceapplication.hotelCommodities.BedTypes.BedTypes;
import eu.deltasource.internship.hotelserviceapplication.hotelCommodities.domain.AbstractCommodity;

/**
 * One of the inheritors of the AbstractCommodity class ,representing the Bed commodity.
 * It has 2 private members :
 * bedType -  a BedTypes variable that is used to point out the current bed's type,
 * for example : single , double etc.
 * isInUse - a boolean type variable that indicates whether the bed is placed in a room.
 */
public class Bed extends AbstractCommodity {

	private BedTypes bedType;
	private boolean isInUse;

	/**
	 * A private default constructor - used to prevent creating a Bed object without a specified bed type.
	 */
	private Bed(){ }

	/**
	 * One of the constructors of the Bed class.
	 * Takes a BedTypes variable as a formal parameter.
	 * @param bedType - Represents the bed type that will be forced onto the created Bed object.
	 */
	public Bed(BedTypes bedType) {
		inventoryNumber = ++STATIC_INVENTORY_NUMBER;
		this.bedType = bedType;
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
	public void deployBed() {
		isInUse = true;
	}

	/**
	 * @return Returns boolean answer based on whether the bed is deployed in some room , or not.
	 */
	public boolean isDeployed() {
		return isInUse;
	}

	/**
	 * Sets the deploy flag to false , which indicates that the bed was removed from it's room
	 * and is available for relocation.
	 */
	public void removeDeployment() {
		isInUse = false;
	}

	/**
	 * An inherited method from the AbstractCommodity class.
	 * Used to prepare the bed.
	 */
	public void prepare() {
		System.out.println("The bed sheets are being replaced.");
	}
}
