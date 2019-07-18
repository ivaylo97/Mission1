package hotelserviceapp.hotelCommodities;

import hotelserviceapp.hotelCommodities.domain.AbstractCommodity;

public class Bed extends AbstractCommodity {

	public enum BedTypes{
		Single,
		Double,
		KingSize,
		Couch,
	}
	private BedTypes bedType ;

	 public Bed() {
		initStaticInventoryNumber();
		StaticInventoryNumber++;
		inventoryNumber = StaticInventoryNumber;
		bedType = BedTypes.Single;
	}

	private void setBedType(BedTypes bedType){
	 	if(bedType != null){
	 		this.bedType = bedType;
		}
	}

	public BedTypes getBedType(){
	 	return bedType;
	}

	public void prepare() {
		System.out.println("The bed sheets are being replaced.");
	}

	@Override
	public int hashCode() {
		return this.inventoryNumber;
	}

	private void initStaticInventoryNumber() {
		if (inventoryNumber == 0) {
			inventoryNumber = 1;
		}
	}
}
