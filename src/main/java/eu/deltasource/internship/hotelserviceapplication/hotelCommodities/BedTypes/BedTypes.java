package eu.deltasource.internship.hotelserviceapplication.hotelCommodities.BedTypes;

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
