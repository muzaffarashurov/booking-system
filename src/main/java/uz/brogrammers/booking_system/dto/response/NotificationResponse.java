package uz.brogrammers.booking_system.dto.response;

import lombok.*;
import uz.brogrammers.booking_system.entity.enums.NotificationType;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationResponse {
    private Long id;
    private String title;
    private String message;
    private NotificationType type;
    private Boolean isRead;
    private Boolean isEmailSent;
    private LocalDateTime createdAt;
    private LocalDateTime readAt;
    private Long bookingId;

}
