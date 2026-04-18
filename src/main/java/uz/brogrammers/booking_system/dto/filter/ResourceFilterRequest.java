package uz.brogrammers.booking_system.dto.filter;

import lombok.*;
import uz.brogrammers.booking_system.entity.enums.ResourceStatus;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResourceFilterRequest {
    private Long categoryId;
    private ResourceStatus status;
    private Integer minCapacity;
    private BigDecimal maxHourlyRate;
    private Boolean requiresApproval;
    private String location;

}
