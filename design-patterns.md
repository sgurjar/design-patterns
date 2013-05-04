Title: Design Patterns
Date: 3/2/2013

## Creational Patterns

### Abstract Factory
Encapsulate a group of individual factories that have a common theme
without specifying their concrete classes.

### Builder
Abstract steps of construction of objects so that different implementations
of these steps can construct different representations of objects.

### Factory Method
Creating objects without specifying the exact class of object that will be
created.

### Prototype
Type of objects to create is determined by a prototypical instance, which
is cloned to produce new objects.

### Singleton
Restricts the instantiation of a class to one object. Kind of like one
global variables in the languages that doesnt support a straight forward
global variables.

## Structural Patterns

### Adapter
Translates one interface for a class into a compatible interface. An
adapter allows classes to work together that normally could not because of
incompatible interfaces, by providing its interface to clients while using
the original interface. The adapter translates calls to its interface into
calls to the original interface, and the amount of code necessary to do
this is typically small. The adapter is also responsible for transforming
data into appropriate forms.

### Bridge
Decouple an abstraction from its implementation so that the two can vary
independently. The bridge uses encapsulation, aggregation, and can use
inheritance to separate responsibilities into different classes.

### Composite
A group of objects are to be treated in the same way as a single
instance of an object. Composite may be composed of more Composite or
Leafs. Leafs implements the operation, Composite delegate operation to
children its Leafs and Composites.

### Decorator
Attaches additional responsibilities to an object dynamically.
Provide a flexible alternative to subclassing for extending functionality.
For example: java.io.BufferedReader decorates a java.io.Reader

### Facade
Provides unified interface to a set of interfaces in a subsystem. Defines
higher level interfaces that makes the subsytem easier to use. Puts parts
together.

### Flyweight
Caching objects to reuse. Create on first use, cache it using a key and then
use same object for that key.

### Proxy
Proxy provides a wrapper to "Real", to intercept method calls to "Real". Proxy
can be used for several purpose, for example- to control number of instances
of "Real". AOP uses dynamic proxy classes to implement pointcuts and advice.

## Behavioral Patterns

### Chain of Responsibility
Commands chained together to execute in a sequence, any command can break
chain.

### Command
An object is used to represent and encapsulate all the information needed to 
call a method at a later time.

### Interpreter
### Iterator
### Mediator
### Memento
### Observer
### State
### Strategy
### Template Method
### Visitor