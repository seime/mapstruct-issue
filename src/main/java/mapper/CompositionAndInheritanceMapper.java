package mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import composition.MessageA;
import composition.MessageB;
import composition.MessageC;
import composition.MessageD;
import composition.MessageE;
import inheritance.DomainA;
import inheritance.DomainB;
import inheritance.DomainC;
import inheritance.DomainD;
import inheritance.DomainE;

@Mapper
public interface CompositionAndInheritanceMapper {

	public static final CompositionAndInheritanceMapper INSTANCE = Mappers.getMapper(CompositionAndInheritanceMapper.class);

	// All @Mappings are for fields contained in the super class
	@Mapping(target = "id", source = "a.id")
	@Mapping(target = "name", source = "b.name")
	DomainC mapToDomainC(MessageC in);

	// Same as above, @InverseConfiguration would have worked also
	@Mapping(source = "id", target = "a.id")
	@Mapping(source = "name", target = "b.name")
	MessageC mapToMessageC(DomainC in);

	@Mapping(source = "id", target = "a.id") // Could be replaced with @InheritConfiguration(name = "mapToMessageC")
	@Mapping(source = "name", target = "b.name") // Could be replaced with @InheritConfiguration(name = "mapToMessageC")
	@Mapping(source = "cake", target = "c.cake") // New field
	MessageD mapToMessageD(DomainD in);

	@InheritInverseConfiguration(name = "mapToMessageD") // PROBLEM 1: Does not work if @InheritConfiguration(name = "mapToMessageC") is used above, all
															// mappings provided by @InheritConfiguration are ignored
	DomainD mapToDomainD(MessageD in);

	// PROBLEM 2: Must repeat mappings for superclass as it is impossible to define a mapping that returns an abstract class
	@Mapping(target = "id", source = "a.id")
	@Mapping(target = "name", source = "b.name")
	DomainE mapToDomainE(MessageE in);

	// Must repeat mappings for superclass
	@Mapping(source = "id", target = "a.id")
	@Mapping(source = "name", target = "b.name")
	MessageE mapToMessageE(DomainE in);

	/*
	 * POSSIBLE SOLUTION 1:
	 */

	// Using * (star) as wildcard. Mapstruct will try to match all all fields from source.a to target and source.b to target
	// One @Mapping for each superclass. Or separate annotation
//	@Mapping(target = "*", source = "a.*")  
//	@Mapping(target = "*", source = "b.*")
	DomainE mapToDomainEUsingCompositionToInheritance(MessageE in);

	// Likewise mapstruct could find possible source fields in a and b and try to match them to target fields.
//	@Mapping(source = "*", target = "a.*")
//	@Mapping(source = "*", target = "b.*")
	MessageE mapConcreteEToMessageEUsingInheritanceToComposition(DomainE in);

	/*
	 * POSSIBLE SOLUTION 2
	 */
	// DomainA mapToDomainA_(MessageA in); // Does not compile, DomainA is abstract

	MessageA mapToMessageA_(DomainA in);

	// DomainB mapToDomainB_(MessageB in); // Does not compile, Domain B is abstract

	MessageB mapToMessageB_(DomainB in);

	// Duplicate annotation, no source attribute to define which property to read from
//	@InheritConfiguration(name = "mapToDomainA_", source = "a")
//	@InheritConfiguration(name = "mapToDomainB_", source = "b")
	DomainC mapToDomainC_(MessageC in);

// Duplicate annotation, no target attribute to define which property to write to 
//	@InheritConfiguration(name = "mapToMessageA_", target = "a")
//	@InheritConfiguration(name = "mapToMessageB_", target = "b")
	MessageC mapToMessageC_(DomainC in);

}
