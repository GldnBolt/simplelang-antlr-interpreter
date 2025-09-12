grammar simple;

@header {
package com.miorgnizacion.simple.interprete;
import java.util.*;
import com.miorgnizacion.simple.interprete.ast.*;
}

@parser::members {
    Map<String, Object> symbolTable = new HashMap<String, Object>();
}

program: PROGRAM ID BRACKET_OPEN 
	{
		List<ASTNode> body = new ArrayList<ASTNode>();
		Map<String, Object> symbolTable = new HashMap<String, Object>();
	}
    (sentence {body.add($sentence.node);})*
    BRACKET_CLOSE
    {
    	for(ASTNode n :  body){
    		n.execute(symbolTable);
    	}
    };

sentence returns [ASTNode node]: println {$node = $println.node;}
				| conditional {$node = $conditional.node;}
				| var_decl    {$node = $var_decl.node;}
				|var_assign   {$node = $var_assign.node;}
				;

println returns [ASTNode node]: PRINTLN expression SEMICOLON
        {$node = new Println($expression.node)};
        
conditional returns [ASTNode node]: IF PAR_OPEN expression PAR_CLOSE
			{
				List<ASTNode> body = new ArrayList<ASTNode>();
			}
			BRACKET_OPEN (s1=sentence { body.add($s1.node);})* BRACKET_CLOSE
			ELSE
			{
				List<ASTNode> elseBody = new ArrayList<ASTNode>();
			}
			BRACKET_OPEN (s2=sentence {elseBody.add($s2.node);} )* BRACKET_CLOSE
			{
				$node = new If($expression.node, body, elseBody);
			}
			
			;
			
var_decl returns [ASTNode node]:
	VAR ID SEMICOLON {$node = new VarDecl($ID.text);}
;

var_assign returns [ASTNode node]:
	ID ASSIGN expression SEMICOLON{$node = new VarAssign($ID.text, $expression.node);}
;
        
expression returns [ASTNode node]: 
        t1=factor                 {$node = $t1.node;}
            (PLUS  t2=factor      {$node = new Addition($node, $t2.node);}
            |MINUS t2=factor      {}
            )*;

factor returns [ASTNode node]:
        t1=term                   {$node = $t1.node;}    
            (MULT t2=term         {$node = new Multiplication($node, $t2.node);}
            |DIV  t2=term         {}
            |POW  t2=term         {}
            )*;
    
term returns [ASTNode node]: 
        NUMBER                    {$node = new Constant(Integer.parseInt($NUMBER.text));}
        | BOOLEAN 				  {$node = new Constant(Boolean.parseBoolean($BOOLEAN.text));}
        | ID {$node = new VarRef($ID.text);}
        | PAR_OPEN expression     {$node = $expression.node; } PAR_CLOSE;


PROGRAM: 'program';
VAR: 'var';
PRINTLN: 'println';
IF: 'if';
ELSE: 'else';

PLUS: '+';
MINUS: '-';
MULT: '*';
DIV: '/';
POW: '^';

AND: '&&';
OR: '||';
NOT: '!';

GEQ: '>=';
LEQ: '<=';
EQ: '==';
NEQ: '!=';

GT: '>';
LT: '<';
ASSIGN: '=';

BRACKET_OPEN: '{';
BRACKET_CLOSE: '}';

PAR_OPEN: '(';
PAR_CLOSE: ')';

SEMICOLON: ';';

BOOLEAN: 'true' | 'false';

ID: [a-zA-Z_][a-zA-Z0-9_]*;

NUMBER: [0-9]+;

BOM : '\uFEFF' -> skip ;

WS: [ \t\n\r]+ -> skip;

LINE_COMMENT  : '//' ~[\r\n]* -> skip ;
BLOCK_COMMENT : '/*' .*? '*/' -> skip ;

