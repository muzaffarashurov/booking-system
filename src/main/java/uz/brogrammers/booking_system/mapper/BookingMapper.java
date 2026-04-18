package uz.brogrammers.booking_system.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import uz.brogrammers.booking_system.dto.request.BookingCreateRequest;
import uz.brogrammers.booking_system.dto.request.BookingUpdateRequest;
import uz.brogrammers.booking_system.dto.response.BookingDetailedResponse;
import uz.brogrammers.booking_system.dto.response.BookingResponse;
import uz.brogrammers.booking_system.entity.Booking;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {UserMapper.class, ResourceMapper.class})
public interface BookingMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "resource", ignore = true)
    @Mapping(target = "status", constant = "PENDING")
    @Mapping(target = "totalPrice", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "cancelledAt", ignore = true)
    @Mapping(target = "cancellationReason", ignore = true)
    @Mapping(target = "reminderSent", constant = "false")
    Booking toEntity(BookingCreateRequest request);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "resource", ignore = true)
    @Mapping(target = "totalPrice", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "cancelledAt", ignore = true)
    void updateEntityFromRequest(BookingUpdateRequest request, @MappingTarget Booking booking);

    @Mapping(source = "user.fullName", target = "userName")
    @Mapping(source = "resource.name", target = "resourceName")
    BookingResponse toResponse(Booking booking);

    @Mapping(source = "user", target = "user")
    @Mapping(source = "resource", target = "resource")
    BookingDetailedResponse toDetailedResponse(Booking booking);

    List<BookingResponse> toResponseList(List<Booking> bookings);

}
