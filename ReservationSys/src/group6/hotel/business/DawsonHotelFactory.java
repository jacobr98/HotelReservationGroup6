package group6.hotel.business;

import dw317.hotel.business.RoomType;
import dw317.hotel.business.interfaces.Customer;
import dw317.hotel.business.interfaces.HotelFactory;
import dw317.hotel.business.interfaces.Reservation;
import dw317.hotel.business.interfaces.Room;
import dw317.lib.creditcard.CreditCard;

/**
 * 
 * @author Danny Manzano
 * @version Phase I
 *
 */
public enum DawsonHotelFactory implements HotelFactory {
	DAWSON;
	
	/**
	 * @return DawsonCustomer object
	 */
	@Override
	public Customer getCustomerInstance(String firstName, String lastName, String email) {
		return new DawsonCustomer(firstName, lastName, email);
	}

	/**
	 * @return CreditCard object
	 */
	@Override
	public CreditCard getCard(String cardtype, String number) {
		return CreditCard.getInstance(
				CreditCard.CardType.valueOf(cardtype.toUpperCase()), number);
	}
	
	/**
	 * return DawsonRoom object
	 */
	@Override
	public Room getRoomInstance(int roomNumber, String roomtype) {
		return new DawsonRoom(roomNumber, 
				RoomType.valueOf(roomtype.toUpperCase()));
	}

	/**
	 * By using taking all the parameters that define Reservation
	 * @return DawsonReservation object
	 */
	@Override
	public Reservation getReservationInstance(Customer aCustomer, Room aRoom, int inYear, int inMonth, int inDay,
			int outYear, int outMonth, int outDay) {
		return new DawsonReservation(aCustomer, aRoom, inYear, inMonth, inDay, outYear, outMonth, outDay);
	}


	/**
	 * By using taking a Reservation object
	 * @return DawsonReservation object
	 */
	@Override
	public Reservation getReservationInstance(Reservation toCopy) {
		return new DawsonReservation(toCopy.getCustomer(),
				toCopy.getRoom(),
				toCopy.getCheckInDate().getYear(),
				toCopy.getCheckInDate().getMonthValue(),
				toCopy.getCheckInDate().getDayOfMonth(), 
				toCopy.getCheckOutDate().getYear(),
				toCopy.getCheckOutDate().getMonthValue(),
				toCopy.getCheckOutDate().getDayOfMonth());
	}

}
