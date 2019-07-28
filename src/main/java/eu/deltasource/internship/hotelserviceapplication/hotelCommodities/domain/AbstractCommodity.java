package eu.deltasource.internship.hotelserviceapplication.hotelCommodities.domain;

/**
 * Overrides equals() and hashCode() methods.
 * Apart from that it provides STATIC_INVENTORY_NUMBER - a protected static int type variable
 * which is further used to track the total number of objects created.
 * Another thing is the protected int inventoryNumber variable , which is used for comparison between
 * objects of this type.
 */
public abstract class AbstractCommodity {
	protected int inventoryNumber;

	/**
	 * A mandatory method for all of the AbstractCommodity's inheritors.
	 * Later used to "prepare" the specific commodity.
	 */
	public abstract void prepare();

	@Override
	public int hashCode() {
		return this.inventoryNumber;
	}

}
