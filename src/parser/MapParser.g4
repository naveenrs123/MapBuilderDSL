parser grammar MapParser;
options { tokenVocab=MapLexer; }

//TOP LEVEL
program: map def? place_and_call?;
map: MAP_SECTION_START create_map MAP_SECTION_END;
def: DEF_SECTION_START (function | define_feature)+ DEF_SECTION_END;
place_and_call: PLACE_AND_CALL_START place_statement+ PLACE_AND_CALL_END;

// FUNCTIONS
function: function_start function_statement+ function_end ;
function_start: FUNCTION_SIGNATURE_START TEXT FUNCTION_PARAM_START TEXT (FUNCTION_PARAM_SEP TEXT)* FUNCTION_PARAM_END ;
function_end: FUNCTION_SIGNATURE_END ;

// LOOPS
loop: loop_start function_statement+ loop_end;
loop_start: LOOP_START FUNCTION_STATEMENT_TEXT_TEXT LOOP_TEXT_SEP FUNCTION_STATEMENT_TEXT_TEXT LOOP_FROM FUNCTION_STATEMENT_TEXT_TEXT LOOP_TO FUNCTION_STATEMENT_TEXT_TEXT ( LOOP_INCREMENT | LOOP_DECREMENT ) FUNCTION_STATEMENT_NUM SIGNATURE_END;
loop_end: LOOP_END FUNCTION_STATEMENT_TEXT_TEXT FUNCTION_STATEMENT_END_OF_LINE ;

// IF CONDITION
conditional: if_start function_statement+ (else_start function_statement+ else_end)? if_end;
if_start: IF_SIGNATURE_START comparison_if COMPARISON_FROM_IF_END;
else_start: ELSE_START;
else_end: ELSE_END;
if_end: IF_END;

// IF SPECIFIC THIGNS
comparison_if: math_compare_if | quote_compare_if;
math_compare_if: MATH_COMPARE_FROM_IF_START math_if comparison_op math_if;
quote_compare_if: QUOTE_COMPARE_FROM_IF_START quoted_text quote_comparison_op quoted_text;
math_if: MATH_FROM_IF_START MATH_FROM_IF_TEXT (math_op_if MATH_FROM_IF_TEXT)? MATH_FROM_IF_END;
math_op_if: MATH_FROM_IF_OPERATORS;

// FUNCTION STATEMENTS
function_statement: (loop | conditional | place_feature_from_func | place_region | assignment) ;

// PLACE STATEMENT
place_statement: (define_feature | place_feature | place_region | function_call) PLACE_STATEMENT_END;

// MAIN COMMANDS
create_map: MAP_CREATE_START quoted_text MAP_OR_REGION_DIMENSIONS xytuple MAP_CREATE_COLOUR color;
place_region: PLACE_REGION_START REGION FEATURE_OR_REGION_NAME quoted_text FEATURE_OR_REGION_LOCATION xytuple MAP_OR_REGION_DIMENSIONS xytuple (FEATURE_OR_REGION_DISPLAY boolean_antlr)?;
define_feature: DEFINE_FEATURE_START TEXT DEFINE_FEATURE_ICON quoted_text DEFINE_FEATURE_SIZE NUM;
place_feature: PLACE_FEATURE_START TEXT FEATURE_OR_REGION_NAME quoted_text FEATURE_OR_REGION_LOCATION xytuple PLACE_FEATURE_ON area (FEATURE_OR_REGION_DISPLAY boolean_antlr)?;
function_call: FUNCTION_CALL_START TEXT FUNCTION_PARAM_START TEXT (FUNCTION_PARAM_SEP TEXT)* FUNCITON_CALL_PARAM_END;
assignment: ASSIGNMENT_START FUNCTION_STATEMENT_TEXT_TEXT ASSIGNMENT_EQUALS expression;

// FUNCTION SPECIFIC THINGS
place_feature_from_func: PLACE_FEATURE_START_FROM_FUNC FUNCTION_STATEMENT_TEXT_TEXT FEATURE_OR_REGION_NAME_FROM_FUNC quoted_text_func FEATURE_OR_REGION_LOCATION_FROM_FUNC xytuple_func PLACE_FEATURE_ON_FROM_FUNC area_func (FEATURE_OR_REGION_DISPLAY_FROM_FUNC boolean_antlr)?;
xytuple_func: FROM_FUNC_OPENING_BRACKET FROM_FUNC_TUPLE_TEXT FROM_FUNC_TUPLE_SEP FROM_FUNC_TUPLE_TEXT FROM_FUNC_CLOSING_BRACKET;
quoted_text_func: FROM_FUNC_OPENING_QUOTE FROM_FUNC_QUOTED_TEXT FROM_FUNC_CLOSING_QUOTE;
area_func: AREA_FROM_FUNC_MAP | (AREA_FRM_FUNC_REGION quoted_text); //REVIEW: COMPARE TO REVISED GRAMMAR


expression: (comparison_expressions | math | math_expression | quoted_text_from_expression | TEXT | EXPRESSION_TEXT | boolean_antlr | quoted_text_for_var) EXPRESSION_END; // | quoted_text

//expression specific things
comparison_expressions: math_compare | quote_compare;
math_expression: MATH_FROM_EXPRESSION_START MATH_FROM_EXPRESSION_TEXT(math_op MATH_FROM_EXPRESSION_TEXT)? MATH_FROM_EXPRESSION_END;
quoted_text_from_expression:  QUOTE_COMPARE_FROM_EXPRESSION_QUOTED_TEXT QUOTE_COMPARE_FROM_EXPRESSION_CLOSING_QUOTE;
quoted_text_from_expression_second: SECOND_QUOTE_COMPARE_FROM_EXPRESSION_OPENING_QUOTE SECOND_QUOTE_COMPARE_FROM_EXPRESSION_QUOTED_TEXT SECOND_QUOTE_COMPARE_FROM_EXPRESSION_CLOSING_QUOTE;
quoted_text_for_var: QUOTE_TEXT_START EXPRESSION_QUOTED_TEXT_FOR_VAR EXPRESSION_CLOSING_QUOTE_FOR_VAR;

math_compare: MATH_COMPARE_START math_expression comparison_op math_expression;
quote_compare: QUOTE_COMPARE_START quoted_text_from_expression quote_comparison_op quoted_text_from_expression_second;
comparison_op: math_comparison_op | quote_comparison_op;
math_comparison_op: MATH_COMPARE_COMPARISON_OP | MATH_COMPARE_FROM_IF_COMPARISON_OP;
quote_comparison_op: QUOTE_COMPARISON_OP_FROM_EXPRESSION | QUOTE_COMPARISON_OP_FROM_IF;

math: MATH_START MATH_FROM_EXPRESSION_TEXT(math_op MATH_FROM_EXPRESSION_TEXT)? MATH_FROM_EXPRESSION_END;
math_op: MATH_FROM_EXPRESSION_OPERATORS;
area: AREA_MAP | (AREA_REGION quoted_text); //REVIEW: COMPARE TO REVISED GRAMMAR
xytuple: OPENING_BRACKET TUPLE_TEXT TUPLE_SEP TUPLE_TEXT CLOSING_BRACKET;
quoted_text: OPENING_QUOTE QUOTED_TEXT CLOSING_QUOTE;

// TERMINALS
//QUOTE_COMPARISON_OP: QUOTE_COMPARISON_OP_FROM_EXPRESSION;
//REGION: REGION_FROM_FUNC;
color: COLOR_START COLOR_CODE COLOR_END;
//TEXT: [a-zA-Z0-9_]+;
//WS: [/r/n/t ]+;
//NUM: [0-9]+;
boolean_antlr: boolean_antlr_red | boolean_antlr_expression;
boolean_antlr_red: BOOLEAN_START (BOOLEAN_TRUE | BOOLEAN_FALSE);
boolean_antlr_expression: BOOLEAN_FROM_EXPRESSION_START (BOOLEAN_FROM_EXPRESSION_TRUE | BOOLEAN_FROM_EXPRESSION_FALSE);


