package uz.brogrammers.booking_system.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResourceUpdateRequest {
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @Size(max = 1000, message = "Description must not exceed 1000 characters")
    private String description;

    private Long categoryId;

    @Min(value = 1, message = "Capacity must be at least 1")
    private Integer capacity;

    private BigDecimal hourlyRate;

    @Size(max = 200, message = "Location must not exceed 200 characters")
    private String location;

    private List<String> amenities;

    private String imageUrl;

    private Boolean requiresApproval;

    private Integer minBookingHours;

    private Integer maxBookingHours;

    private Integer advanceBookingDays;

    private Boolean isActive;

}
