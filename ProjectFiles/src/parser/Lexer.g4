lexer grammar Lexer;

/** ignore white space during tokenization */
WS: [\r\n\t ]+ -> channel(HIDDEN);

/** map */
MAP_SECTION_START: '#start map';
MAP_CREATE_START: 'CREATE MAP' -> mode(TEXT_MODE);
MAP_CREATE_SIZE: 'of SIZE' -> mode(NUM_MODE);
MAP_CREATE_SIZE_SEP: 'x' -> mode(NUM_MODE);
MAP_CREATE_COLOUR: 'and COLOR' -> mode(COLOR_MODE);
MAP_SECTION_END: '#end map';

/** region */
REGION_SECTION_START: '#start region';
REGION_PLACE_START: 'PLACE REGION' -> mode(REGION_MODE);
REGION_PLACE_NAME: 'with NAME' -> mode(TEXT_MODE);
REGION_PLACE_SHAPE: 'and SHAPE' -> mode(SHAPE_MODE);
REGION_SECTION_END: '#end region';

/** function definition */
FUNCTION_SECTION_START: '#start function definitions';
FUNCTION_SIGNATURE_START: 'DEFINE FUNCTION' -> mode(TEXT_MODE);
FUNCTION_PARAM_START: '(' -> mode(TEXT_MODE);
FUNCTION_PARAM_END: ')' -> mode(STATEMENT_LOOP_MODE);
FUNCTION_SECTION_END: '#end function definitions';

/** other modes */
mode TEXT_MODE;
TEXT: [a-zA-Z0-9]* -> mode(DEFAULT_MODE);
WS_TEXT: [\r\n\t ]+ -> channel(HIDDEN);

mode NUM_MODE;
NUM: [0-9]+ -> mode(DEFAULT_MODE);
WS_NUM: [\r\n\t ]+ -> channel(HIDDEN);

mode COLOR_MODE;
COLOR: '#';
RRGGBB: [0-9A-F]{6} -> mode(DEFAULT_MODE);
WS_COLOR: [\r\n\t ]+ -> channel(HIDDEN);

mode REGION_MODE;
REGION: ('grass' | 'desert' | 'forest' | 'water' | 'snow' | 'ocean') -> mode(DEFAULT_MODE);
WS_REGION: [\r\n\t ]+ -> channel(HIDDEN);

mode SHAPE_MODE;
CIRCLE_START: 'CIRCLE of RADIUS';
CIRCLE_POSITION: 'at POSITION';
RECTANGLE_START: 'RECTANGLE from POSITION';
RECTANGLE_POSITION: 'to POSITION';
TRIANGLE_START: 'TRIANGLE facing DIRECTION';
TRIANGLE_DIRECTION: 'north-west' | 'north-east' | 'south-west' | 'south-east';
TRIANGLE_LENGTH: 'with LENGTH';
TRIANGLE_POSITION: 'at POSITION';
UNDEFINED_SPACE: 'UNDEFINED SPACE';
SHAPE_NUM: [0-9]+; // defined separately here because NUM_MODE returns to DEFAULT_MODE
COORDINATE_START: '[';
COORDINATE_SEP: ',';
COORDINATE_END: ']';
SHAPE_END_OF_LINE: ';' -> mode(DEFAULT_MODE);
WS_SHAPE: [\r\n\t ]+ -> channel(HIDDEN);

mode STATEMENT_LOOP_MODE;
WS_STATEMENT_LOOP: [\r\n\t ]+ -> channel(HIDDEN);
/** loops */
LOOP_START: 'DEFINE LOOP';

/** statements */
FUNCTION_SIGNATURE_END: 'END FUNCTION' -> mode(DEFAULT_MODE);




