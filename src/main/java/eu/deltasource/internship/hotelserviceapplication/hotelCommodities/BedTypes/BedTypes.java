package eu.deltasource.internship.hotelserviceapplication.hotelCommodities.BedTypes;

/**
 * An enumeration containing the bed types , which are used in the Bed class to specify the current bed's type.
 */
public enum BedTypes {
	SINGLE(1),
	DOUBLE(2),
	KING_SIZE(2);
	private final int bedCapacity;

	BedTypes(int bedCapacity) {
		this.bedCapacity = bedCapacity;
	}

	public int getBedCapacity() {
		return bedCapacity;
	}
}
