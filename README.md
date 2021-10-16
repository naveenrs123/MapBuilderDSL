# Project - MapBuilder DSL

## Description
The aim of this project is to create a Domain Specific Language (DSL) that can be used to design and build a map of a world. The target audience for this DSL is people with an interest in RPGs, Dungeons and Dragons, fantasy writing, or other situations that involve worldbuilding and lore.

## Build and Run
This project is configured to work best in IntelliJ IDEA. Before running the project, make sure that the following things have been completed:

### ANTLR
* Make sure that the ANTLR .jar file is included as a dependency in *Project Structure* > *Modules* > *Dependencies*.
* Right-click `MapLexer.g4` then click *Generate ANTLR Recognizer*.
* Right-click `MapParser.g4` then click *Generate ANTLR Recognizer*.

### Project Structure - Changes to `Project Structure > Modules > Sources`
* Make sure that the top-level directory is marked as the content root.
* Mark the `src` folder as the sources root. Contains the main program content.
* Mark the `gen` folder as the generated sources root. Contains the generated ANTLR classes and helpers.
* Mark the `icons` folder as the resources root. Required to allow icons to be retrieved and rendered.

Once those actions have all been completed, specify the name of the file to run in `Main.java`, making sure that it has the `.tdot` file extension. Then the program will run by running the `main` function in the class.

## Language Design

### General Structure
The language is broken down into three main regions, **MAP**, **DEFINITIONS** and **PLACE AND CALL**. This creates a clear separation for the user and provides a structure that the user must follow.

```
#start map

<- INSERT STATEMENTS HERE ->

#end map


#start definitions

<- INSERT STATEMENTS HERE ->

#end definitions


#start place and call

<- INSERT STATEMENTS HERE ->

#end place and call
```
---
### Functions and Control Flow

#### FUNCTION
**Syntax:**
```
DEFINE FUNCTION <function-name> (<parameter-list>):

  <- INSERT STATEMENTS HERE ->
  
END FUNCTION;
```
**Details:** Functions allow repetitive code sections to be reused. They are identified by a name and can take one or more parameters.
* `<function-name>`: Type: `TEXT`. The name of the function. 
* `<parameter-list>`: Type: `TEXT`. A list of **0 or more parameters**. If there are at least **2 parameters**, they must be separated with a comma (`,`).
 
#### LOOP
```
START LOOP <loop-name>, <loop-variable> FROM <start> TO <stop> INCREMENT BY <change>:

<- INSERT STATEMENTS HERE ->

END LOOP <loop-name>
```
or
```
START LOOP <loop-name>, <loop-variable> FROM <start> TO <stop> DECREMENT BY <change>:

<- INSERT STATEMENTS HERE ->

END LOOP <loop-name>
```

**Details:** Loops allow code sections to be repeated a specified number of times. **MUST BE PLACED WITH A FUNCTION OR CONDITIONAL.**
* `<loop-name>`: Type: `TEXT`. The name of the loop.
* `<loop-variable>`: TYPE: `TEXT`. The name of the variable that will be used in the loop.
* `<start>`: TYPE: `TEXT` or `NUMBER`. The start of the range of numbers that will be used in the loop. Can reference a variable.
* `<stop>`: TYPE: `TEXT` or `NUMBER`. The end of the range of numbers that will be used in the loop. Can reference a variable.
* `<change>:` TYPE: `TEXT` or `NUMBER`. The increment or decrement value. At the end of each loop, the `<loop variable>` will be incremented or decremented by this amount. Can reference a variable.

#### CONDITIONAL
```
$IF <comparison>:

<- INSERT STATEMENTS HERE ->

$ELSE:

<- INSERT STATEMENTS HERE ->

$END ELSE;
$END IF;
```

**Details:** Conditionals allow different sections to be run depending on the result of a specific condition. **MUST be placed within a FUNCTION OR LOOP.**
* `<comparison>`: TYPE: `COMPARISON`. A comparison that must evaluate to a `BOOLEAN` value.

**Note:** `$ELSE: ... $END ELSE;` is optional.

---
### Main Statements

#### CREATE MAP 
Must be in **MAP** section.
**Syntax:** | **Example:**
------------ | -------------
`CREATE MAP <map-name> WITH DIMENSIONS <dimensions> WITH COLOR <color>;` | `CREATE MAP {World Map} WITH DIMENSIONS [5,7] WITH COLOR #238F9D;`

**Details:** Creates a **Map** with a specified size and color.
* `<map-name>`: TYPE: `QUOTED_TEXT`. The name of the map.
* `<dimensions>`: TYPE: `XYTUPLE`. A tuple representing the width and height of the map in that order.
* `<color>`: TYPE: `COLOR`. An RGB color value.

#### PLACE REGION
Must be in **PLACE AND CALL** section or in a **FUNCTION**, **LOOP**, or **CONDITIONAL**.
**Syntax:** | **Example:**
------------ | -------------
`PLACE REGION <region-type> WITH NAME <region-name> WITH LOCATION <location> WITH DIMENSIONS <dimensions> DISPLAY LABELS <display>;` | `PLACE REGION desert WITH NAME {Sahara} WITH LOCATION [0,100] WITH DIMENSIONS [100,100] DISPLAY NAME %TRUE;` 
 
 **Details:** Creates a **Region**, which is a specific area on a **Map**.
* `<region-type>`: TYPE: `TEXT`. The region type identifier.
* `<region-name>`: TYPE: `QUOTED_TEXT`. 
* `<location>`: TYPE: `XYTUPLE`. A tuple representing the X, Y coordinate location of the top-left corner of the region.
* `<dimensions>`: TYPE: `XYTUPLE`. A tuple representing the width and height of the map in that order.
* `<display>`: TYPE: `BOOLEAN`. Decides whether to display the label specified in `<region-name>`.

**Note:** `DISPLAY LABELS <display>` is optional.

#### DEFINE FEATURE
Must be in **DEFINTIONS** section.
**Syntax:** | **Example:**
------------ | -------------
 `DEFINE FEATURE <feature-type> WITH ICON <icon> WITH SIZE <size>;` | `DEFINE FEATURE wave WITH ICON {wave} WITH SIZE SMALL;`
 
 **Details:** Defines a **Feature**, which is like a landmark, that can be placed on a map.
* `<feature-type>`: TYPE: `TEXT`. The feature type identifier.
* `<icon>`: TYPE: `ICON`. One of various icons that the user can select.
* `<size>`: TYPE: `TEXT`. One of `SMALL`, `MEDIUM` or `LARGE`.

#### PLACE FEATURE
Must be in **PLACE AND CALL** section or in a **FUNCTION**, **LOOP**, or **CONDITIONAL**.
**Syntax:** | **Example:**
------------ | -------------
`PLACE FEATURE <feature-type> WITH NAME <feature-name> WITH LOCATION <location> ON map DISPLAY LABELS <display>;` | `PLACE FEATURE wave WITH NAME {Waves} WITH LOCATION [X, 100] ON map DISPLAY NAME %FALSE;`
`PLACE FEATURE <feature-type> WITH NAME <feature-name> WITH LOCATION <location> ON region <region-name> DISPLAY LABELS <display>;` | `PLACE FEATURE wave WITH NAME {Waves} WITH LOCATION [X, 100] ON region {Ocean} DISPLAY NAME %TRUE;`

 **Details:** Creates a **Region**, which is a specific area on a **Map**.
* `<feature-type>`: TYPE: `TEXT`. The feature type identifier.
* `<feature-name>`: TYPE: `QUOTED_TEXT`. 
* `<location>`: TYPE: `XYTUPLE`. A tuple representing the X, Y coordinate location of the top-left corner of the feature.
* `<region-name:` TYPE: `TEXT`. Name of region on which the feature will be placed. **Only used when `ON region` is present.**
* `<display>`: TYPE: `BOOLEAN`. Decides whether to display the label specified in `<feature-name>`.

#### ASSIGNMENT
Must be in a **FUNCTION**, **LOOP**, or **CONDITIONAL**.
**Syntax:** | **Example:**
------------ | -------------
 `%assign <variable-name> = <expression>;` | `%assign X = #math compare 5 != 5;`, `%assign var = {my text};`, `%assign var5 = 6;`
 
 **Details:** Assigns an expression to a variable, which can then be referred to later.
 * `<variable-name>`: TYPE: `TEXT`. The variable identifier. 
 * `<expression>`: TYPE: `EXPRESSION`. The value assigned to the variable. 

---
### Expressions and Comparisons and Tuples

#### EXPRESSION
Used in **ASSIGNMENT**. One of:
**Syntax:** | **Example:**
------------ | -------------
`COMPARISON` | `5 > 5`, `var_x > 4`
`QUOTED_TEXT` | `{Hello}`
`NUMBER` | `5`
`TEXT` | `text_2`
`BOOLEAN` | `%TRUE`

#### COMPARISON
Used in **EXPRESSIONS**. One of:
**Syntax:** | **Example:**
------------ | -------------
`<number/text> <number-operator> <number/text>` | `5 > 5`, `var_x > 4` 
`<quote> <quoted-text-operator> <quote>` | `{Chocolate} == {Vanilla}`

**Details:**
* `<number/text>`. TYPE: `NUMBER` or `TEXT`.
* `<quote>.` TYPE: `QUOTED_TEXT`.
* `<number-operator>.` ONE OF: `==`, `!=`, `>`, `<`, `>=`, `<=`.
* `<quote-operator>`. ONE OF: `==`, `!=`.

#### XYTUPLE
**Syntax:** | **Example:**
------------ | -------------
`[<number/text> , <number/text>]` | `[X, 100]`, `[100, 49]`

**Details:**
* `<number/text>`. TYPE: `NUMBER` or `TEXT`.

---

### Primitive Types

**Type:** | **Details:** | **Example:**
------------ | ------------- | -------------
`NUMBER` | A positive integer. | `5`
`BOOLEAN` | One of `%TRUE` or `%FALSE` | `%TRUE`
`TEXT` | A sequence of uppercase, lowercase, and underscore characters with no whitespace separation. | `text_2`
`QUOTED_TEXT` | A sequence of uppercase and lowercase characters with allowed whitespace, wrapped in `{}` | `{Hello}`
`COLOR` | `#` + a sequence of 6 hexadecimal characters. | `#FF438A`
