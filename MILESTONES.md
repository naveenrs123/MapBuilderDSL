*Use this file to commit information clearly documenting your milestones'
content. If you want to store more information/details besides what's required
for the milestones that's fine too. Make sure that your TA has had a chance to
sign off on your milestones each week (before the deadline); typically you
should discuss your material with them before finalizing it here.*

# Milestone 1
Our project will be a World Builder implemented in Java. It is intended to be used by RPG enthusiasts, DnD Dungeon Masters, and fantasy story writers.

This DSL will allow users to generate a plot of land/water with various regions and features (e.g., mountains, rivers), which will be rendered as a PNG image. A legend will be provided to clarify colour coding. 

Users will be given the option to create an empty piece of land of specified size (width and height), or select from 3 existing templates (small, medium, and large). Users can create regions with specific parameters, such as size, color, and biome, and place them at particular points in the world. The color parameter is used to color-code the regions on the map.

Users can add predefined feature blocks to their regions, such as mountains, rivers, or lakes, or they can define custom features. Feature blocks have a fixed size and can be placed at points within a region. To place multiple blocks of the same feature in close proximity, the implementation will use loops. For example, a mountain range can be made by placing multiple mountain blocks in a line using a loop.

After consulting with our TA we aim to give users as much control as possible, thereby reducing the amount of randomization required in the backend.
