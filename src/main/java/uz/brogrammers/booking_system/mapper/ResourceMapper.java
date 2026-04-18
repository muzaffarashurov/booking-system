package uz.brogrammers.booking_system.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import uz.brogrammers.booking_system.dto.request.ResourceCreateRequest;
import uz.brogrammers.booking_system.dto.request.ResourceUpdateRequest;
import uz.brogrammers.booking_system.dto.response.ResourceDetailedResponse;
import uz.brogrammers.booking_system.dto.response.ResourceResponse;
import uz.brogrammers.booking_system.entity.Category;
import uz.brogrammers.booking_system.entity.Resource;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {CategoryMapper.class}
)
public interface ResourceMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "status", constant = "AVAILABLE")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "bookings", ignore = true)
    @Mapping(target = "isActive", constant = "true")
    Resource toEntity(ResourceCreateRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "bookings", ignore = true)
    void updateEntityFromRequest(ResourceUpdateRequest request, @MappingTarget Resource resource);

    @Mapping(source = "category.name", target = "categoryName")
    ResourceResponse toResponse(Resource resource);

    @Mapping(source = "category", target = "category")
    ResourceDetailedResponse toDetailedResponse(Resource resource);

    List<ResourceResponse> toResponseList(List<Resource> resources);

    @Named("categoryToId")
    default Long categoryToId(Category category) {
        return category != null ? category.getId() : null;
    }

}
