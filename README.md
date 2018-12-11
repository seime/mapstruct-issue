# Mapstruct mapping issue

### Domain model using inheritance (simplified)
![Domain model](src/main/java/inheritance.png)

### DTO model using composition (simplified)
Each superclass from the domain model is a separate message field in the corresponding DTO class.

![DTO model](src/main/java/Composition.png)

## Current way of solving it

Add @Mapping-annotations for each field, repeat for each concrete class (imagine an hierarchy 5-7 levels deep with hundreds of abstract classes - each with 2-10 own fields)

[See here](src/main/java/mapper/MappingAnnotationRepeatMapper.java)

## Possible ideas for solutions

[See here for example and discussion](src/main/java/mapper/CompositionAndInheritanceMapper.java)
