// Generated from com\miorgnizacion\simple\interprete\simple.g4 by ANTLR 4.9.2
package com.miorgnizacion.simple.interprete;

package com.miorgnizacion.simple.interprete;
import java.util.*;
import com.miorgnizacion.simple.interprete.ast.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link simpleParser}.
 */
public interface simpleListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link simpleParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(simpleParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(simpleParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterSentence(simpleParser.SentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitSentence(simpleParser.SentenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#println}.
	 * @param ctx the parse tree
	 */
	void enterPrintln(simpleParser.PrintlnContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#println}.
	 * @param ctx the parse tree
	 */
	void exitPrintln(simpleParser.PrintlnContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterConditional(simpleParser.ConditionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitConditional(simpleParser.ConditionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl(simpleParser.Var_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl(simpleParser.Var_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#var_assign}.
	 * @param ctx the parse tree
	 */
	void enterVar_assign(simpleParser.Var_assignContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#var_assign}.
	 * @param ctx the parse tree
	 */
	void exitVar_assign(simpleParser.Var_assignContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(simpleParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(simpleParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(simpleParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(simpleParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(simpleParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(simpleParser.TermContext ctx);
}