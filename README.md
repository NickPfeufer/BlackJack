BlackJack
=========
1 The amount people are currently betting does not display while playing because I could not find a good place to
put it and as I am running short on time, this probably will not get implemented

2 The cards are placed in an asteticly pleasing way and it works, hiding complexity from the user and I allow
players to change their bet by 1, besides the display of bet while playing I have accounted for every situation,
I did my best to break the program and then find the bugs

3 Using classes and objects, allow difrent sets of code to talk to each other, mass produce units of code and in general
make it much easier to understand, which in turn allows for increasingly complex code.

4 Private variables can only be accessed by methods writen in the same {} as the variable, Public Variables can
be accessed by any method, the same is true for methods, private methods can only be called by methods in the {}
where they are defined and public methods can be used by any method, in the case of the public variable and method
the methods calling on them still need to know where to look

5 A class is a blueprint for say a toster and the instance is a copy, with variables that can change, in this
analogy it is the actual toster built from the blueprint

6 inheritence allows classes to use methods writen in a parent class, it is usefull because the child class (the
one who inherants) can have its own methods and variables so rather than rewrite code, you can have to distinct
classes that use many of the same methods with less work (programers are lazy so this is good)

7 this refers to the object its self, I used it so my blackjack class could pass its self to the button pannels which
used the info to call methods writen in blackjack, super refers to a parent class and is how a variable calls the
methods of its parent

8 all objects have variables (what it is) and methods (what it does)

9 When is there to many objects
