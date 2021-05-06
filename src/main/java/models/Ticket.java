package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    private String departDate;
    private String bookingDate;
    private String expiredDate;
    private String departFrom;
    private String arriveAt;
    private String seatType;
    private int ticketAmount;
}
