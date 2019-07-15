package hotelserviceapp;

public abstract class AbstractCommodity {
	protected static int StaticInventoryNumber;
	int inventoryNumber;

	abstract void prepare();

	/**
	 * An overridden version of the equals method,reconfigured to be commodity oriented.
	 * Takes an java.lang.Object as a formal parameter,which it later uses in comparison operations with
	 * the current invoker's values.
	 * Returns boolean result,which representing the equality between the two objects.
	 */
	@Override
	public boolean equals(Object compareObject) {
		if (!(compareObject instanceof AbstractCommodity)) return false;
		Bed temporaryCommodity = (Bed) compareObject;
		return this.inventoryNumber == temporaryCommodity.inventoryNumber;
	}

	/**
	 * An overridden version of the hashCode() method.Reconfigured specifically for the commodities class.
	 * Simply returns the inventory number upon invocation.
	 *
	 * @return
	 */
	@Override
	public abstract int hashCode();
}
