package uz.brogrammers.booking_system.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.security.crypto.password.PasswordEncoder;
import uz.brogrammers.booking_system.dto.request.UserCreateRequest;
import uz.brogrammers.booking_system.dto.request.UserUpdateRequest;
import uz.brogrammers.booking_system.dto.response.UserDetailedResponse;
import uz.brogrammers.booking_system.dto.response.UserResponse;
import uz.brogrammers.booking_system.entity.User;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", expression = "java(passwordEncoder.encode(request.getPassword()))")
//    @Mapping(target = "role", source = "role", defaultValue = "USER")
    @Mapping(target = "isActive", constant = "true")
    @Mapping(target = "emailVerified", constant = "false")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "lastLoginAt", ignore = true)
    @Mapping(target = "bookings", ignore = true)
    @Mapping(target = "notifications", ignore = true)
    User toEntity(UserCreateRequest request, PasswordEncoder passwordEncoder);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", expression = "java(request.getPassword() != null ? passwordEncoder.encode(request.getPassword()) : null)")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "lastLoginAt", ignore = true)
    @Mapping(target = "bookings", ignore = true)
    @Mapping(target = "notifications", ignore = true)
    @Mapping(target = "emailVerified", ignore = true)
    void updateEntityFromRequest(UserUpdateRequest request, @MappingTarget User user, PasswordEncoder passwordEncoder);

    UserResponse toResponse(User user);

    @Mapping(target = "recentBookings", ignore = true)
    @Mapping(target = "totalBookingsCount", expression = "java(user.getBookings() != null ? (long) user.getBookings().size() : 0L)")
    UserDetailedResponse toDetailedResponse(User user);

    List<UserResponse> toResponseList(List<User> users);

}
