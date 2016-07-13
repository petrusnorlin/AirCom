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
    private Integer SeatId;
    private Passenger seatedPassenger;
    
    public Seat() {
        this.SeatId = null;
        this.seatedPassenger = null;
    }
    
    public Seat(Integer SeatId, Passenger seatedPassenger) {
        this.SeatId = SeatId;
        this.seatedPassenger = seatedPassenger;
    }

    public Passenger getSeatedPassenger() {
        return seatedPassenger;
    }

    public void setSeatedPassenger(Passenger seatedPassenger) {
        this.seatedPassenger = seatedPassenger;
    }

    public Integer getSeatId() {
        return SeatId;
    }

    public void setSeatId(Integer SeatId) {
        this.SeatId = SeatId;
    }
    
}
