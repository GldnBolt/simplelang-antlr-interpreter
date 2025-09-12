package com.miorgnizacion.simple.interprete;

import java.io.IOException;
import java.nio.file.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {
  private static final String EXTENSION = "smp";
  private static final String DIRBASE = "src/test/resources/";

  public static void main(String[] args) throws IOException {
    String[] files = (args.length == 0) ? new String[] { "test.smp"} : args;
    System.out.println("Dirbase: " + DIRBASE);

    for (String file : files) {
      System.out.println("START: " + file);
      String path = DIRBASE + file;
      System.out.println("Leyendo: " + Paths.get(path).toAbsolutePath());

      CharStream in = CharStreams.fromPath(Paths.get(path));
      simpleLexer lexer = new simpleLexer(in);
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      simpleParser parser = new simpleParser(tokens);

      // Opcional: comentarios de error más verbosos
      // parser.removeErrorListeners();
      // parser.addErrorListener(new DiagnosticErrorListener());

      simpleParser.ProgramContext tree = parser.program();
      System.out.println(tree.toStringTree(parser));

      simpleCustomVisitor visitor = new simpleCustomVisitor();
      visitor.visit(tree);

      System.out.println("FINISH: " + file);
    }
  }
}
