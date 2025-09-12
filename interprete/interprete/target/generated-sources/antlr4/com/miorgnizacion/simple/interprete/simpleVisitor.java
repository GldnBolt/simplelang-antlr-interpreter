// Generated from com\miorgnizacion\simple\interprete\simple.g4 by ANTLR 4.9.2
package com.miorgnizacion.simple.interprete;

package com.miorgnizacion.simple.interprete;
import java.util.*;
import com.miorgnizacion.simple.interprete.ast.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link simpleParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface simpleVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link simpleParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(simpleParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleParser#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentence(simpleParser.SentenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleParser#println}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintln(simpleParser.PrintlnContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleParser#conditional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional(simpleParser.ConditionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleParser#var_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_decl(simpleParser.Var_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleParser#var_assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_assign(simpleParser.Var_assignContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(simpleParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(simpleParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(simpleParser.TermContext ctx);
}