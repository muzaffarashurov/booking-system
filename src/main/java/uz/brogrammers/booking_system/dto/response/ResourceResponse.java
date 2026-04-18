package uz.brogrammers.booking_system.dto.response;

import lombok.*;
import uz.brogrammers.booking_system.entity.enums.ResourceStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResourceResponse {
    private Long id;
    private String name;
    private String description;
    private ResourceStatus status;
    private Integer capacity;
    private BigDecimal hourlyRate;
    private String location;
    private List<String> amenities;
    private String imageUrl;
    private String categoryName;
    private LocalDateTime createdAt;
}
