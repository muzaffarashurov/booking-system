package uz.brogrammers.booking_system.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResponse {
    private Long id;
    private String name;
    private String description;
    private String icon;
    private Integer displayOrder;
    private Boolean isActive;
    private Long resourcesCount;
    private LocalDateTime createdAt;
}
