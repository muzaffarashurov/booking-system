package uz.brogrammers.booking_system.dto.request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Size;
import lombok.*;
import uz.brogrammers.booking_system.entity.enums.BookingStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingUpdateRequest {
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;

    @Size(max = 500, message = "Description must not exceed 500 characters")
    private String description;

    @FutureOrPresent(message = "Start time must be in the present or future")
    private LocalDateTime startTime;

    @FutureOrPresent(message = "End time must be in the present or future")
    private LocalDateTime endTime;

    private BookingStatus status;

    private Integer participantsCount;

    @Size(max = 200, message = "Notes must not exceed 200 characters")
    private String notes;

    @Size(max = 200, message = "Cancellation reason must not exceed 200 characters")
    private String cancellationReason;

}
