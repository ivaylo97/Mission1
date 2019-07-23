package eu.deltasource.internship.hotelserviceapplication.hotelCommodities.domain;

/**
 * A base commodity class , which is later inherited by certain commodities like :
 * Bed,Toilet and Shower.
 * Overrides equals() and hashCode() methods.
 * Apart from that it provides STATIC_INVENTORY_NUMBER - a protected static int type variable
 * which is further used to track the total number of objects created.
 * Another thing is the protected int inventoryNumber variable , which is used for comparison between
 * objects of this type.
 */
public abstract class AbstractCommodity {
	protected static int STATIC_INVENTORY_NUMBER;
	protected int inventoryNumber;

	/**
	 * A mandatory method for all of the AbstractCommodity's inheritors.
	 * Later used to "prepare" the specific commodity.
	 */
	public abstract void prepare();

	@Override
	public boolean equals(Object compareObject) {
		if (!(compareObject instanceof AbstractCommodity)) return false;
		AbstractCommodity temporaryCommodity = (AbstractCommodity) compareObject;
		return this.inventoryNumber == temporaryCommodity.inventoryNumber;
	}

	@Override
	public int hashCode() {
		return this.inventoryNumber;
	}

}
