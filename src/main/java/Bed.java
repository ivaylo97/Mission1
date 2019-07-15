public class Bed extends AbstractCommodity {
	Bed(){
		inventoryNumber = hashCode();
	}
	public void Prepare(){
		System.out.println("The beds sheets are being replaced.");
	}
}
