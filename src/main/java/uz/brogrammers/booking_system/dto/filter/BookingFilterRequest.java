package uz.brogrammers.booking_system.dto.filter;

import lombok.*;
import uz.brogrammers.booking_system.entity.enums.BookingStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingFilterRequest {
    private Long userId;
    private Long resourceId;
    private BookingStatus status;
    private LocalDateTime startDateFrom;
    private LocalDateTime startDateTo;

}
