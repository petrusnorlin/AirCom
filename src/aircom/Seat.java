/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aircom;

/**
 *
 * @author PetrusNorlin
 */
public class Seat {
    private Integer SeatNr;
    private String seatId;
    private Passenger seatedPassenger;
    
    public Seat() {
        this.SeatNr = null;
        this.seatedPassenger = null;
    }

    public String getSeatId() {
        return seatId;
    }    
    
    public Seat(Integer SeatNr, Passenger seatedPassenger) {
        this.SeatNr = SeatNr;
        this.seatedPassenger = seatedPassenger;
    }
    
    public Seat(String SeatId, Passenger seatedPassenger) {
        this.seatId = SeatId;
        this.seatedPassenger = seatedPassenger;
    }

    public Passenger getSeatedPassenger() {
        return seatedPassenger;
    }

    public void setSeatedPassenger(Passenger seatedPassenger) {
        this.seatedPassenger = seatedPassenger;
    }

    public Integer getSeatNr() {
        return SeatNr;
    }

    public void setSeatNr(Integer SeatNr) {
        this.SeatNr = SeatNr;
    }

    @Override
    public String toString() {
        return "SeatId: " + seatId + " Passenger: " + seatedPassenger;
    }
    
    
    
}
