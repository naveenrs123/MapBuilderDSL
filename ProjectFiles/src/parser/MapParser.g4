parser grammar MapParser;
options { tokenVocab=MapLexer; }

program: map def? place_and_call?;
map: MAP_SECTION_START MAP_CREATE_START MAP_OR_REGION_DIMENSIONS MAP_CREATE_COLOUR MAP_SECTION_END;
def: TEXT;
place_and_call: TEXT;
