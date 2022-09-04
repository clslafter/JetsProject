# JetsProject

## Description
In this application, an original list of jets in the airfield fleet in loaded from a 
properly formatted text file.

After that, the user is prompted with different options. 
The user can choose to view the entire fleet, and the program will display each jet
in the airfield and their properties.

The user can choose to fly all the jets and is presented with a readout of all the jets
that are flying and what their maximum flying time is calculated based on the speed and range.

The user can also choose to view the jet with its properties of the fastest Jet or the Jet with
the longest range.

The user may also choose to execute type-specific behaviors of the specialized jets like loading
cargo for Cargo Planes, or fighting for the Fighter Jets.

The user may also choose to add a jet to the fleet, and may quit at any time without adding it.
The user will be prompted for a jet type. If there is an invalid entry, 
the default jet type is assigned.

The user's final choice, besides quitting the program is to remove a jet from the fleet.

Until the user quits the program, all these options are available again, and will
use the most updated list of either added or removed jets in the airfield.


## What I Learned
I learned how to convert strings into numbers types using wrapper classes, 
and also learned how to cast an integer from a converted double.

I learned that we can cast objects of a list from it's parent abstract set in order to 
access it's interface behaviors.

I also worked on trying to break the program and adding in if statements and try/catch blocks 
to anticipate user error and keep the program running smoothly.

In the add jet method, I used a while(true) loop with a final break at the end to give the
user an option to quit at any time while also only going through the menu once.

I had an interesting issue with the remove option showing up twice, and realized it was
because I was passing in a menu argument. I was able to solve that by creating a local
variable and passing that instead.


## Technologies Used
Eclipse, Java, Git, GitHub, Mac OS
