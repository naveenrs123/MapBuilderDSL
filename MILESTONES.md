_Use this file to commit information clearly documenting your milestones'
content. If you want to store more information/details besides what's required
for the milestones that's fine too. Make sure that your TA has had a chance to
sign off on your milestones each week (before the deadline); typically you
should discuss your material with them before finalizing it here._


# Milestone 3

## User Study 1 Notes

We conducted our first user study on September 30th on two people. See this [document](https://docs.google.com/document/d/1IEgUtsPOKzx8dMeXvcACd8LlX0J6yRDyWC7sULtSYfI/edit?usp=sharing) we wrote to conduct the user study.

We had our two participants attempt to write code that would represent maps we showed them. We utilized the grammar listed in milestone 2. 

See this [document](https://docs.google.com/document/d/1y-FbWe8Lyf2YGHl0yXMLw0CpWOJO1tjWbeb48FEHzJM/edit?usp=sharing) for all the detailed feedback we got:
The main feedback/comments we got were:
- wrap names/labels in quotation marks, so it is easier to identify them
- Defining rectangles using two coordinates was confusing, better to define a point and dimensions (length, height)
- Users were interested in placing regions/referring to regions inside of functions
- The users found the ordering/structure of our code blocks to be a bit counter-intuitive. They suggested defining features and functions in the same block, and placing features and calling functions in another block
- The users were assuming that if you create two overlapping regions, the one written later/further down the file would overlay the first one
- When creating a region or feature with no name, users found it more intuitive to completely remove the NAME/LABEL parameter from the statement. However, having this optional may over-complicate our language


These are the main changes we will be making to our grammar/language after this user study:
- Indicate Labels/Names as being wrapped in quotation marks
- Restructure the main blocks/layout of our code so that functions and features are defined in the same block
- When placing a region or feature, add a boolean flag to indicate whether the label/display name should be visible, so as to avoid optional labels
- When defining the shape of a region as a rectangle, define the upper coordinate and the length and height
- Remove circles, undefined space, and triangles from our available shapes for regions. Only use rectangles. With a big enough map and multiple regions, we should be able to represent a variety of landscapes using only rectangles.

Below is the updated grammar, incorporating user feedback from our user study:

## Reworked Grammar 

// TOP LEVEL <br />
**program**: map def? place_and_call?; <br />
**map**: ‘#start map’ create_map ‘#end map’; <br />
**def**: ‘#start definitions’ ( function | define_feature )+ ‘#end definitions’; <br />
**place_and_call**: ‘#start place and call’ place_statement+ ‘#end place and call’; <br />

// FUNCTIONS <br />
**function**: function_start function_statement+ function_end ; <br />
**function_start**: ‘DEFINE FUNCTION’ TEXT ‘(‘ TEXT (‘,’ TEXT)* ‘):’ ; <br />
**FUNCTION_END**: ‘END FUNCTION;’ ; <br />

// LOOPS <br />
**loop**: loop_start loop_statement+ loop_end; <br />
**loop_start**: ‘START LOOP’ TEXT ',' TEXT ‘FROM’ NUM ‘TO’ NUM ( ‘INCREMENT BY’ | 'DECREMENT BY' ) NUM ‘:’; <br />
**loop_end**: ‘END LOOP’ TEXT ';' ; <br />

// IF CONDITION <br />
**conditional**: if_start function_statement+ (else_start function_statement+ else_end)? if_end; <br />
**if_start**: 'IF' comparison ‘:’; <br />
**else_start**: ‘ELSE’ ‘:’; <br />
**else_end**: ‘END ELSE ;’; <br />
**if_end**: ‘END IF;’; <br />

// FUNCTION STATEMENTS <br />
**function_statement**: (loop | conditional | place_feature | place_region | assignment) ‘;’; <br />
**loop_statement**: (conditional | place_feature | place_region | assignment) ‘;’; <br />

// PLACE STATEMENT <br />
**place_statement**: (define_feature | place_feature | place_region | function_call) ‘;’; <br />

// MAIN COMMANDS <br />
**create_map**: ‘CREATE MAP’ quoted_text ‘WITH DIMENSIONS’ xytuple ‘WITH COLOR’ COLOR ‘;’; <br />
**place_region**: ‘PLACE REGION’ REGION ‘WITH NAME’ quoted_text ‘WITH LOCATION’ xytuple ‘WITH DIMENSIONS’ xytuple (‘DISPLAY NAME’ BOOLEAN)?; <br />
**define_feature**: ‘DEFINE FEATURE’ TEXT ‘WITH ICON’ quoted_text ‘WITH SIZE’ NUM; <br />
**place_feature**: ‘PLACE FEATURE’ TEXT ‘WITH NAME’ quoted_text ‘WITH LOCATION’ xytuple ‘ON’ area (‘DISPLAY NAME’ BOOLEAN)?; <br />
**function_call**: ‘CALL FUNCTION’ TEXT ‘(‘ expression* ‘)’ ; <br />
**assignment**: TEXT '=' expression; <br />

**expression**: comparison | math | quoted_text | TEXT | BOOLEAN; <br />

**comparison**: math_compare | quote_compare; <br />
**math_compare**: math comparison_op math; <br />
**quote_compare**: quoted_text QUOTE_COMPARISON_OP quoted_text; <br />
**comparison_op**: '>' | '<' | '<=' | '>=' | QUOTE_COMPARISON_OP; <br />

**math**: TEXT(math_op TEXT)?; <br />
**math_op**: '+' | '-' | '/' | '\*'; <br />
**area**: 'map' | 'region' quoted_text; <br />
**xytuple**: ‘[‘ NUM ‘,’ NUM ‘]’; <br />
**quoted_text**: ‘“’ (TEXT | WS)* ‘”’; <br />

// TERMINALS <br />
**QUOTE_COMPARISON_OP**: '==' | '!='; <br />
**REGION**: ‘grass’ | ‘desert’ | ‘forest’ | ‘water’ | ‘snow’ | ‘ocean’; <br />
**COLOR**: ‘#’ [0-9A-F]{6}; <br />
**TEXT**: [a-zA-Z0-9_]+; <br />
**WS**: [/r/n/t ]+; <br />
**NUM**: [0-9]+; <br />
**BOOLEAN**: ‘TRUE’ | ‘FALSE’; <br />


# Milestone 2

## Summary of Progress

We have drafted a roadmap, the grammar, as well as created a mock of the input and output. Our work so far can be reviewed in this [Google Doc](https://docs.google.com/document/d/1CWNSy-IMKIfC1-GpDZXa8GnXh_WnrGVWELMTEM6A15o/edit?usp=sharing).

## Roadmap

| **Team Member**    | **Deadline** | **Task**                      |
| ------------------ | ------------ | ----------------------------- |
| All                | Fri Sept 24  | Create grammar rules          |
| Adam               | Mon Sept 27  | Design user study 1           |
| Naveen, Zoe, Kevin | Mon Sept 27  | Get user study 1 participants |
| All                | Thurs Sept 30| Complete user study 1         |
| All                | Fri Oct 1    | Revist grammar & submit milestone 3 |
| Adam               | Mon Oct 4    | Implement tokenizer           |
| Zoe                | Mon Oct 4    | Implement parser              |
| Naveen             | Mon Oct 4    | Implement AST creation        |
| Kevin              | Mon Oct 4    | Implement validator           |
| Naveen             | Fri Oct 8    | Plan user study 2             |
| Kai + All          | Tues Oct 12  | Render map                    |
| All                | Wed Oct 13   | Complete user study 2         |
| All                | Mon Oct 18   | Wrap up project + video       |

## Grammar

**program:** map region_section? func_def? feature_and_call_section?; <br />
**map:** ‘#start map’ create_map ‘#end map’; <br />
**region_section:** ‘#start region’ place_region+ ‘#end region’; <br />
**func_def:** ‘#start function definitions’ function+ ‘#end function definitions’; <br />
**feature_and_call_section:** ‘#start features and calls’ statement+ ‘#end features and calls’; <br />

**function:** function_start (statement | loop)+ function_end; <br />
**function_start:** ‘DEFINE FUNCTION’ TEXT ‘(‘ TEXT\* ‘)’; <br />
**function_end:** ‘END FUNCTION’; <br />

**loop:** loop_start statement+ loop_end; <br />
**loop_start:** ‘DEFINE LOOP’ TEXT TEXT ‘FROM’ NUM ‘TO’ NUM ‘INCREMENT BY’ NUM; <br />
**loop_end:** ‘END LOOP’ TEXT; <br />

**statement:** feature | place_feature | function_call | loop | variable | conditional | math; <br />

**create_map:** ‘CREATE MAP’ TEXT ‘of SIZE’ NUM 'x' NUM ‘and COLOR’ color; <br />
**feature:** ‘DEFINE FEATURE’ TEXT ‘with ICON’ TEXT ‘and SIZE’ NUM; <br />
**place_feature:** ‘PLACE FEATURE’ TEXT ‘with NAME’ TEXT ‘at LOCATION’ coordinates ‘on’ area; <br />
**place_region:** ‘PLACE REGION’ region ‘with NAME’ TEXT ‘and SHAPE’ shape; <br />
**function_call:** ‘CALL FUNCTION’ TEXT ‘(‘ TEXT\* ‘)’; <br />
**variable:** TEXT '=' (TEXT | math); <br />
**conditional:** 'if' TEXT comparison_operator TEXT; <br />
**comparison_operator:** '==' | '>' | '<' | '<=' | '>=' | '!='; <br />
**math:** (NUM | TEXT) math_operator (NUM | TEXT); <br />
**math_operator:** '+' | '-' | '/' | '\*'; <br />

**region:** ‘grass’ | ‘desert’ | ‘forest’ | ‘water’ | ‘snow’ | ‘ocean’; <br />
**shape:** circle | rectangle | triangle | ‘UNDEFINED SPACE’; <br />
**circle:** ‘CIRCLE of RADIUS’ NUM ‘at POSITION’ coordinates; <br />
**rectangle:** ‘RECTANGLE from POSITION’ coordinates ‘to POSITION’ coordinates; <br />
**triangle:** ‘TRIANGLE facing DIRECTION’ direction ‘with LENGTH’ NUM ‘at POSITION’ coordinates; <br />
**direction:** ‘north-west’ | ‘north-east’ | ‘south-west’ | ‘south-east’; <br />
**color:** ‘#’ RRGGBB; <br />
**area:** ‘map’ | 'region' TEXT; <br />
**coordinates:** ‘[‘ NUM ‘,’ NUM ‘]’; <br />
**TEXT:** [a-zA-Z0-9]+; <br />
**NUM:** [0-9]+; <br />
**RRGGBB:** [0-9A-F]{6}; <br />

## Example

### Flow of Input

#start map <br />
Create Map <br />
#end map <br />

#start region <br />
Place Regions <br />
#end region <br />

#start function definitions <br />
Function Definition Block <br />
#end function definitions <br />

#start features and calls <br />
Place Features/Function Calls <br />
#end features and calls <br />

### Sample Input

```
#start map
CREATE MAP Cool Map of SIZE 8x8 and COLOR #00FF80
#end map

#start region
PLACE REGION desert with NAME Sahara and SHAPE CIRCLE of RADIUS 2 at POSITION [0,1]
PLACE REGION forest with NAME Treeville and SHAPE TRIANGLE facing DIRECTION north-west with LENGTH 5 at POSITION [7,7]
PLACE REGION grass with NAME Death Valley and SHAPE UNDEFINED SPACE
#end region

#start function definitions
DEFINE FUNCTION makeMountains (x_start x_stop y_start y_stop)

    DEFINE FEATURE mountain with ICON mountain and SIZE 1

    counter = y_start

    DEFINE LOOP loop1 X FROM x_start TO x_stop INCREMENT BY 1

        DEFINE LOOP loop2 Y FROM y_start TO y_stop INCREMENT BY 1

            if Y == counter

                PLACE FEATURE mountain with NAME Rockies at LOCATION [X,Y] on map;

        END LOOP loop2

        counter = counter - 1

    END LOOP loop1

END FUNCTION
#end function definitions

#start features and calls
CALL FUNCTION makeMountains(3 6 6 3)
#end features and calls
```

### Sample Output

See 'MapOutputExample' image in repo.

### Other Notes

We will have a predefined list of icons the user can choose from. There will be a generic icon the user can use if no other icons are appropriate.

---

# Milestone 1

Our project will be a World Builder implemented in Java. It is intended to be used by RPG enthusiasts, DnD Dungeon Masters, and fantasy story writers.

This DSL will allow users to generate a plot of land/water with various regions and features (e.g., mountains, rivers), which will be rendered as a PNG image. A legend will be provided to clarify colour coding.

Users will be given the option to create an empty piece of land of specified size (width and height), or select from 3 existing templates (small, medium, and large). Users can create regions with specific parameters, such as size, color, and biome, and place them at particular points in the world. The color parameter is used to color-code the regions on the map.

Users can add predefined feature blocks to their regions, such as mountains, rivers, or lakes, or they can define custom features. Feature blocks have a fixed size and can be placed at points within a region. To place multiple blocks of the same feature in close proximity, the implementation will use loops. For example, a mountain range can be made by placing multiple mountain blocks in a line using a loop.

After consulting with our TA we aim to give users as much control as possible, thereby reducing the amount of randomization required in the backend. Our TA also suggested that we use loops to place multiple blocks of the same feature and allow the user to create custom definitions for features. These suggestions have been incorporated into the DSL.
