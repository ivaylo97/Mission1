package eu.deltasource.internship.hotelserviceapplication.Support.CommodityExceptions;

import eu.deltasource.internship.hotelserviceapplication.Support.domain.CustomAbstractException;

public class ObjectAlreadyPresentException extends CustomAbstractException {
	public ObjectAlreadyPresentException(){
		super("The commodity is already present !");
	}
}
