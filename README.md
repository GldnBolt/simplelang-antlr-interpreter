SimpleLang Interpreter

A small educational interpreter for a custom .smp programming language, built with Java, ANTLR4, and Maven.

The project demonstrates the main stages involved in building a language interpreter: lexical and syntactic analysis, parse-tree generation, construction of an Abstract Syntax Tree (AST), symbol-table-based execution, and runtime evaluation of statements and expressions.

Features

Currently implemented in the project:

ANTLR4 grammar for the custom SimpleLang language.

Program blocks using program <name> { ... }.

Variable declarations with var.

Variable assignment and references.

Integer and boolean literals.

Arithmetic expressions with addition and multiplication.

Parenthesized expressions.

println statements.

if / else conditional statements.

AST-based execution.

Basic symbol table using a Java Map.

Runtime semantic error support for some numeric operations.

Maven integration for ANTLR source generation.

The codebase also contains AST nodes for subtraction, division, and exponentiation. Their parser integration is still incomplete in the current grammar. Logical/comparison tokens and some function examples are also present as groundwork for future extensions.

Example

program demo {
    var x;
    x = 5;

    println x;
    println 2 + 3 * 4;
    println (2 + 3) * 4;

    if (true) {
        println 1;
    } else {
        println 0;
    }
}

How it works

The interpreter follows this general flow:

.smp source file
      |
      v
ANTLR Lexer
      |
      v
ANTLR Parser
      |
      v
Parse Tree
      |
      v
AST Nodes
      |
      v
Symbol Table + Runtime Execution
      |
      v
Program Output

ANTLR generates the lexer and parser from simple.g4. Semantic actions in the grammar create AST nodes such as Addition, Multiplication, VarDecl, VarAssign, Println, and If. These nodes implement the ASTNode interface and execute using a shared symbol table.

Project structure

interprete/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── antlr4/
│   │   │   └── com/miorgnizacion/simple/interprete/
│   │   │       └── simple.g4
│   │   └── java/
│   │       └── com/miorgnizacion/simple/interprete/
│   │           ├── Main.java
│   │           ├── simpleCustomVisitor.java
│   │           └── ast/
│   │               ├── ASTNode.java
│   │               ├── Constant.java
│   │               ├── Addition.java
│   │               ├── Multiplication.java
│   │               ├── Subtraction.java
│   │               ├── Division.java
│   │               ├── Power.java
│   │               ├── VarDecl.java
│   │               ├── VarAssign.java
│   │               ├── VarRef.java
│   │               ├── Println.java
│   │               ├── If.java
│   │               └── RuntimeSemError.java
│   └── test/
│       └── resources/
│           └── test.smp
└── target/                 # Generated build files

Technologies

Java

ANTLR 4.9.2

Maven

Visitor pattern

Abstract Syntax Tree (AST)

Symbol table

Requirements

To build the project you need:

JDK 8 or newer

Apache Maven

Check your installation with:

java -version
mvn -version

Build

From the project root:

mvn clean generate-sources compile

ANTLR will generate the lexer, parser, listener, and visitor classes inside Maven's generated-sources directory.

Run

The entry point is:

com.miorgnizacion.simple.interprete.Main

Main reads .smp files from:

src/test/resources/

If no argument is supplied, it tries to execute:

test.smp

The easiest way to run the current version is to import the project as a Maven project in an IDE such as Eclipse or IntelliJ IDEA and run Main.java.

Language syntax

Program

program myProgram {
    // statements
}

Variable declaration

var x;

Assignment

x = 10;

Output

println x;
println 2 + 3 * 4;

Conditional

if (true) {
    println 1;
} else {
    println 0;
}

Comments

// Single-line comment

/*
   Multi-line comment
*/

Current limitations

This repository is an educational prototype rather than a complete programming language implementation. In the current source code:

subtraction (-), division (/), and power (^) have AST classes but are not fully connected to the grammar;

logical operators such as &&, ||, and ! are tokenized but do not yet have parser rules;

comparison operators are defined as tokens but are not yet parsed as expressions;

functions such as powmod, seed, and binom shown in the test file are not currently implemented by the grammar;

variable declaration, scope, and type validation can be made stricter;

the symbol table currently uses a simple Map rather than nested scopes.

Possible improvements

Future versions could add:

complete arithmetic operator support;

boolean and comparison expressions;

strict semantic validation for undeclared/redeclared variables;

nested scopes;

typed symbols;

custom functions and built-in functions;

improved syntax and semantic error messages;

automated unit tests;

command-line support for arbitrary .smp file paths.

Purpose

This project was developed as an academic exercise to understand the construction of interpreters and compilers using ANTLR, including grammar definition, parsing, AST design, semantic analysis, symbol tables, and execution.
