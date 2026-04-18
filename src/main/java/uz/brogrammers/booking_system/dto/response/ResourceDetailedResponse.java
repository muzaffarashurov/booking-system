package uz.brogrammers.booking_system.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class ResourceDetailedResponse extends ResourceResponse{
    private Boolean requiresApproval;
    private Integer minBookingHours;
    private Integer maxBookingHours;
    private Integer advanceBookingDays;
    private LocalDateTime updatedAt;
    private Boolean isActive;
    private CategoryResponse category;
}
