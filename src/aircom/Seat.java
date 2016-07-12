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
    Integer SeatId;
    Passenger seatedPassenger;
    
    public Seat() {
        this.SeatId = null;
        this.seatedPassenger = null;
    }
    
    public Seat(Integer SeatId, Passenger seatedPassenger) {
        this.SeatId = SeatId;
        this.seatedPassenger = seatedPassenger;
    }
    
}
