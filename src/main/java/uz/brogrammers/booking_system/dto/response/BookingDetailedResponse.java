package uz.brogrammers.booking_system.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class BookingDetailedResponse extends BookingResponse {
    private String notes;
    private LocalDateTime cancelledAt;
    private String cancellationReason;
    private Boolean reminderSent;
    private UserResponse user;
    private ResourceDetailedResponse resource;
}
