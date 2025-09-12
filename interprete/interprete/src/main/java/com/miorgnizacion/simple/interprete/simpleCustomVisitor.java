package com.miorgnizacion.simple.interprete;

public class simpleCustomVisitor extends simpleBaseVisitor<Void> {

  @Override
  public Void visitProgram(simpleParser.ProgramContext ctx) {
    // program ID { sentence* }
    System.out.println("Programa: " + ctx.ID().getText());
    return visitChildren(ctx);
  }

  @Override
  public Void visitVar_decl(simpleParser.Var_declContext ctx) {
    System.out.println("Declarando variable: " + ctx.ID().getText());
    return null;
  }

  @Override
  public Void visitVar_assign(simpleParser.Var_assignContext ctx) {
    System.out.println("Asignando: " + ctx.ID().getText() + " = " + ctx.expression().getText());
    return null;
  }

  @Override
  public Void visitPrintln(simpleParser.PrintlnContext ctx) {
    System.out.println("Imprimiendo: " + ctx.expression().getText());
    return null;
  }
}
