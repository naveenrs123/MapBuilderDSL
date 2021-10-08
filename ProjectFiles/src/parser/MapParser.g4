parser grammar MapParser;
options { tokenVocab=MapLexer; }

//TOP LEVEL
program: map def? place_and_call?;
map: MAP_SECTION_START create_map MAP_SECTION_END;
def: DEF_SECTION_START (function | define_feature) DEF_SECTION_END;
place_and_call: PLACE_AND_CALL_START place_statement PLACE_AND_CALL_END;

// FUNCTIONS
function: function_start function_statement+ function_end ;
function_start: FUNCTION_SIGNATURE_START TEXT FUNCTION_PARAM_START TEXT (FUNCTION_PARAM_SEP TEXT)* FUNCTION_PARAM_END ;
FUNCTION_END: FUNCTION_SIGNATURE_END ;

// LOOPS
loop: loop_start functionloop_statement+ loop_end;
loop_start: LOOP_START TEXT LOOP_TEXT_SEP TEXT LOOP_FROM TEXTNUM LOOP_TO TEXTNUM ( LOOP_INCREMENT | LOOP_DECREMENT ) NUM SIGNATURE_END;
loop_end: LOOP_END TEXT FUNCTION_STATEMENT_END_OF_LINE ;

// IF CONDITION
conditional: if_start function_statement+ (else_start function_statement+ else_end)? if_end;
if_start: '$IF' comparison ‘:’;
else_start: ‘$ELSE:’;
else_end: ‘$END ELSE;’;
if_end: ‘$END IF;’;

// FUNCTION STATEMENTS
function_statement: (loop | conditional | place_feature | place_region | assignment) ‘;’;
loop_statement: (conditional | place_feature | place_region | assignment | loop) ‘;’;

// PLACE STATEMENT
place_statement: (define_feature | place_feature | place_region | function_call) ‘;’;

// MAIN COMMANDS
create_map: ‘CREATE MAP’ quoted_text ‘WITH DIMENSIONS’ xytuple ‘WITH COLOR’ COLOR ‘;’;
place_region: ‘PLACE REGION’ REGION ‘WITH NAME’ quoted_text ‘WITH LOCATION’ xytuple ‘WITH DIMENSIONS’ xytuple (‘DISPLAY NAME’ BOOLEAN)?;
define_feature: ‘DEFINE FEATURE’ TEXT ‘WITH ICON’ quoted_text ‘WITH SIZE’ NUM;
place_feature: ‘PLACE FEATURE’ TEXT ‘WITH NAME’ quoted_text ‘WITH LOCATION’ xytuple ‘ON’ area (‘DISPLAY NAME’ BOOLEAN)?;
function_call: ‘CALL FUNCTION’ TEXT ‘(‘ TEXT (‘,’ TEXT)* expression* ‘)’ ;
assignment: %assign TEXT '=' expression;

expression: (comparison | math | quoted_text | TEXT | BOOLEAN)’;’;

comparison: math_compare | quote_compare;
math_compare: ‘#math compare’ math comparison_op math;
quote_compare: ‘#text compare’ quoted_text QUOTE_COMPARISON_OP quoted_text;
comparison_op: '>' | '<' | '<=' | '>=' | QUOTE_COMPARISON_OP;

math: ‘$math’ TEXT(math_op TEXT)? ‘$end_math’;
math_op: '+' | '-' | '/' | '*';
area: ‘map’ | 'region' quoted_text;
xytuple: ‘[‘ TEXTNUM ‘,’ TEXTNUM ‘]’;
quoted_text: ‘{“’ (TEXT | WS)+* ‘}”’;

// TERMINALS
QUOTE_COMPARISON_OP: '==' | '!=';
REGION: REGION_FROM_FUNC;
COLOR: ‘#’ [0-9A-F]{6};
TEXT: [a-zA-Z0-9_]+;
WS: [/r/n/t ]+;
NUM: [0-9]+;
BOOLEAN: ‘%’(‘TRUE’ | ‘FALSE’);


