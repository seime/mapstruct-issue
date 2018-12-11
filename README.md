# Mapstruct mapping issue

Domain model using inheritance (simplified)
![Domain model](src/main/java/inheritance.png)

DTO model using composition (simplified)
Each superclass from the domain model is a separate message field in the corresponding DTO class.

![DTO model](src/main/java/Composition.png)

## Current way of solving it

Add @Mapping-annotations for each field, repeat for each concrete class.

[See here](src/main/java/mapper/MappingAnnotationRepeatMapper.java)

## Possible ways ahead for mapstruct

[See here for example and discussion](src/main/java/mapper/CompositionAndInheritanceMapper.java)
