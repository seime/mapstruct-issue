package mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import composition.MessageC;
import composition.MessageD;
import composition.MessageE;
import inheritance.DomainC;
import inheritance.DomainD;
import inheritance.DomainE;

@Mapper
public interface MappingAnnotationRepeatMapper {

	public static final MappingAnnotationRepeatMapper INSTANCE = Mappers.getMapper(MappingAnnotationRepeatMapper.class);

	@Mapping(target = "id", source = "a.id")
	@Mapping(target = "name", source = "b.name")
	DomainC mapToDomainC(MessageC in);

	@Mapping(source = "id", target = "a.id")
	@Mapping(source = "name", target = "b.name")
	MessageC mapToMessageC(DomainC in);

	@Mapping(source = "id", target = "a.id") // Repeat
	@Mapping(source = "name", target = "b.name") // Repeat
	@Mapping(source = "cake", target = "c.cake")
	MessageD mapToMessageD(DomainD in);

	@Mapping(target = "id", source = "a.id") // Repeat
	@Mapping(target = "name", source = "b.name") // Repeat
	@Mapping(target = "cake", source = "c.cake")
	DomainD mapToDomainD(MessageD in);

	@Mapping(target = "id", source = "a.id") // Repeat
	@Mapping(target = "name", source = "b.name") // Repeat
	DomainE mapToDomainE(MessageE in);

	@Mapping(source = "id", target = "a.id") // Repeat
	@Mapping(source = "name", target = "b.name") // Repeat
	MessageE mapToMessageE(DomainE in);

}
