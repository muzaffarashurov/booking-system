package uz.brogrammers.booking_system.dto.response;

import lombok.*;
import uz.brogrammers.booking_system.entity.enums.BookingStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingResponse {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private BookingStatus status;
    private BigDecimal totalPrice;
    private Integer participantsCount;
    private String resourceName;
    private String userName;
    private LocalDateTime createdAt;

}
