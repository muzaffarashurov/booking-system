package uz.brogrammers.booking_system.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResourceCreateRequest {
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @Size(max = 1000, message = "Description must not exceed 1000 characters")
    private String description;

    @NotNull(message = "Category ID is required")
    private Long categoryId;

    @NotNull(message = "Capacity is required")
    @Min(value = 1, message = "Capacity must be at least 1")
    private Integer capacity;

    private BigDecimal hourlyRate;

    @Size(max = 200, message = "Location must not exceed 200 characters")
    private String location;

    private List<String> amenities;

    private String imageUrl;

    private Boolean requiresApproval = false;

    private Integer minBookingHours = 1;

    private Integer maxBookingHours = 8;

    private Integer advanceBookingDays = 30;

}
