_Use this file to commit information clearly documenting your milestones'
content. If you want to store more information/details besides what's required
for the milestones that's fine too. Make sure that your TA has had a chance to
sign off on your milestones each week (before the deadline); typically you
should discuss your material with them before finalizing it here._

# Milestone 2

## Summary of Progress

We have drafted a roadmap, the grammar, as well as created a mock of the input and output. Our work so far can be reviewed in this [Google Doc](https://docs.google.com/document/d/1CWNSy-IMKIfC1-GpDZXa8GnXh_WnrGVWELMTEM6A15o/edit?usp=sharing).

## Roadmap

| **Team Member**    | **Deadline** | **Task**                      |
| ------------------ | ------------ | ----------------------------- |
| All                | Fri Sept 24  | Create grammar rules          |
| Adam               | Mon Sept 27  | Design user study 1           |
| Naveen, Zoe, Kevin | Mon Sept 27  | Get uesr study 1 participants |
| All                | Fri Oct 1    | Complete user study 1         |
| Naveen             | Mon Oct 4    | Implement tokenizer           |
| Zoe                | Mon Oct 4    | Implement parser              |
| Adam               | Mon Oct 4    | Implement AST creation        |
| Kevin              | Mon Oct 4    | Implement validator           |
| Naveen             | Fri Oct 8    | Plan user study 2             |
| Kai + All          | Tues Oct 12  | Render map                    |
| All                | Wed Oct 13   | Complete user study 2         |
| All                | Mon Oct 18   | Wrap up project + video       |

## Grammar

**program:** map region_section? func_def? feature_and_call_section?;
**map:** ‘#start map’ create_map ‘#end map’;
**region_section:** ‘#start region’ place_region+ ‘#end region’;
**func_def:** ‘#start function definitions’ function+ ‘#end function definitions’;
**feature_and_call_section:** ‘#start features and calls’ statement+ ‘#end features and calls’;

**function:** function_start (statement | loop)+ function_end;
**function_start:** ‘DEFINE FUNCTION’ TEXT ‘(‘ TEXT\* ‘)’;
**function_end:** ‘END FUNCTION’;

**loop:** loop_start statement+ loop_end;
**loop_start:** ‘DEFINE LOOP’ TEXT TEXT ‘FROM’ NUM ‘TO’ NUM ‘INCREMENT BY’ NUM;
**loop_end:** ‘END LOOP’ TEXT;

**statement:** feature | place_feature | function_call | loop | variable | conditional | math;

**create_map:** ‘CREATE MAP’ TEXT ‘of SIZE’ NUM 'x' NUM ‘and COLOR’ color;
**feature:** ‘DEFINE FEATURE’ TEXT ‘with ICON’ TEXT ‘and SIZE’ NUM;
**place_feature:** ‘PLACE FEATURE’ TEXT ‘with NAME’ TEXT ‘at LOCATION’ coordinates ‘on’ area;
**place_region:** ‘PLACE REGION’ region ‘with NAME’ TEXT ‘and SHAPE’ shape;
**function_call:** ‘CALL FUNCTION’ TEXT ‘(‘ TEXT\* ‘)’;
**variable:** TEXT '=' (TEXT | math);
**conditional:** 'if' TEXT comparison_operator TEXT;
**comparison_operator:** "==" | ">" | "<" | "<=" | ">=" | "!=";
**math:** (NUM | TEXT) math_operator (NUM | TEXT);
**math_operator:** "+" | "-" | "/" | "\*";

**region:** ‘grass’ | ‘desert’ | ‘forest’ | ‘water’ | ‘snow’ | ‘ocean’;
**shape:** circle | rectangle | triangle | ‘UNDEFINED SPACE’;
**circle:** ‘CIRCLE of RADIUS’ NUM ‘at POSITION’ coordinates;
**rectangle:** ‘RECTANGLE from POSITION’ coordinates ‘to POSITION’ coordinates;
**triangle:** ‘TRIANGLE facing DIRECTION’ direction ‘with LENGTH’ NUM ‘at POSITION’ coordinates;
**direction:** ‘north-west’ | ‘north-east’ | ‘south-west’ | ‘south-east’;
**color:** ‘#’ RRGGBB;
**area:** ‘map’ | 'region' TEXT;  
**coordinates:** ‘[‘ NUM ‘,’ NUM ‘]’;
**TEXT:** [a-zA-Z0-9]+;
**NUM:** [0-9]+;
**RRGGBB:** [0-9A-F]{6};

## Example

### Flow of Input

#start map
Create Map
#end map

#start region
Place Regions
#end region

#start function definitions
Function Definition Block
#end function definitions

#start features and calls
Place Features/Function Calls
#end features and calls

### Sample Input

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

    DEFINE FEATURE "mountain" ‘with ICON’ "mountain" ‘and SIZE’ 1

    counter = y_start

    DEFINE LOOP loop1 X FROM x_start TO x_stop INCREMENT BY 1

        DEFINE LOOP loop2 Y FROM y_start TO y_stop INCREMENT BY 1

            if Y == counter

                PLACE FEATURE "mountain" ‘with NAME’ "Rockies" ‘at LOCATION’ [X,Y] ‘on’ "map";

        END LOOP loop2

        counter = counter - 1

    END LOOP loop1

END FUNCTION
#end function definitions

#start features and calls
CALL FUNCTION makeMountains(3 6 6 3)
#end features and calls

### Sample Output

See "MapOutputExample" image in repo.

### Other Notes

We will have a predefined list of icons the user can choose from. There will be a generic icon the user can use if no other icons are appropriate.

# Milestone 1

Our project will be a World Builder implemented in Java. It is intended to be used by RPG enthusiasts, DnD Dungeon Masters, and fantasy story writers.

This DSL will allow users to generate a plot of land/water with various regions and features (e.g., mountains, rivers), which will be rendered as a PNG image. A legend will be provided to clarify colour coding.

Users will be given the option to create an empty piece of land of specified size (width and height), or select from 3 existing templates (small, medium, and large). Users can create regions with specific parameters, such as size, color, and biome, and place them at particular points in the world. The color parameter is used to color-code the regions on the map.

Users can add predefined feature blocks to their regions, such as mountains, rivers, or lakes, or they can define custom features. Feature blocks have a fixed size and can be placed at points within a region. To place multiple blocks of the same feature in close proximity, the implementation will use loops. For example, a mountain range can be made by placing multiple mountain blocks in a line using a loop.

After consulting with our TA we aim to give users as much control as possible, thereby reducing the amount of randomization required in the backend. Our TA also suggested that we use loops to place multiple blocks of the same feature and allow the user to create custom definitions for features. These suggestions have been incorporated into the DSL.
