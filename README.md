# Project - MapBuilder DSL

## Description
The aim of this project is to create a Domain Specific Language (DSL) that can be used to design and build a map of a world. The target audience for this DSL is people with an interest in RPGs, Dungeons and Dragons, fantasy writing, or other situations that involve worldbuilding and lore.

## Build and Run
This project is configured to work best in IntelliJ IDEA. Before running the project, make sure that the following things have been completed:
* Make sure that the top-level directory is marked as the content root in *Project Structure* > *Modules* > *Sources*.
* Mark the `src` folder as the sources root in *Project Structure* > *Modules* > *Sources*.
* Make sure that the ANTLR .jar file is included as a dependency in *Project Structure* > *Modules* > *Dependencies*.
* Install the latest ANTLR plugin for IntelliJ IDEA.
* Right-click `MapLexer.g4` then click *Generate ANTLR Recognizer*.
* Right-click `MapParser.g4` then click *Generate ANTLR Recognizer*.
* Mark the `gen` folder as the generated sources root in *Project Structure* > *Modules* > *Sources*.

Once those actions have all been completed, specify the name of the file to run in `Main.java`, making sure that it has the `.mpb` file extension. Then the program will run by running the `main` function in the class.

## Language Design

### General Structure
The language is broken down into three main regions, **Map**, **Definitions** and **Place and Call**. This creates a clear separation for the user and provides a structure that the user must follow.

```
#start map

< - insert statements here ->

#end map


#start definitions

< - insert statements here ->

#end definitions


#start place and call

< - insert statements here ->

#end place and call
```

### Map Section
This section contains only one line.

#### CREATE MAP
**Syntax:**
```
CREATE MAP <quoted_text> WITH DIMENSIONS <xytuple> WITH COLOR <rgb>;
```
**Example:**
```
CREATE MAP {World Map} WITH DIMENSIONS [5,7] WITH COLOR #238F9D;
```
**Details:** Creates a map image with the width and height values specified in `<xytuple>`, colours it with the color `<rgb>`, and gives the map a label given by `<quoted_text>`.

### Definitions Section
