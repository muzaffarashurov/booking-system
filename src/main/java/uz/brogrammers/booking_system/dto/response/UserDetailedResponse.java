package uz.brogrammers.booking_system.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserDetailedResponse extends UserResponse {
    private Boolean emailVerified;
    private LocalDateTime lastLoginAt;
    private LocalDateTime updatedAt;
    private List<BookingResponse> recentBookings;
    private Long totalBookingsCount;
}
