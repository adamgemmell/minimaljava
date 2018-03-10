/* Spec file built with the guidance of the example lexer at http://jflex.de/manual.html */

package com.ajsg2.minimaljava.lex;

import com.ajsg2.minimaljava.common.tokens.UnexpectedCharacterException;
import com.ajsg2.minimaljava.parse.sym;
import java_cup.runtime.*;

/**
 * The Minimal Java Lexer
 */
%%

// Options
%class Lexer
%unicode
%line
%column
%public
%yylexthrow UnexpectedCharacterException,NumberFormatException
%cup
//%debug

// Custom code block
%{
	private Symbol symbol(int type) {
     		return new Symbol(type, yyline+1, yycolumn+1);
     	}

      private Symbol symbol(int type, Object value) {
      	return new Symbol(type, yyline+1, yycolumn+1, value);
      }
%}

LineTerminator	= \r|\n|\r\n
InputCharacter	= [^\r\n]
WhiteSpace		= {LineTerminator}|[ \t\f]

Comment = "//" {InputCharacter}*{LineTerminator}?

Identifier = [:jletter:][:jletterdigit:]*
DecIntegerLiteral = [0-9]+
DecLongLiteral = [0-9]+[Ll]
DecDoubleLiteral = [0-9]*\.[0-9]+

%%

// Keywords

<YYINITIAL> "new"	{ return symbol(sym.NEW);}
<YYINITIAL> "return"	{ return symbol(sym.RETURN);}
<YYINITIAL> "void"	{ return symbol(sym.VOID);}
<YYINITIAL> "class"	{ return symbol(sym.CLASS);}
<YYINITIAL> "extends"	{ return symbol(sym.EXTENDS);}
<YYINITIAL> "if"		{ return symbol(sym.IF);}
<YYINITIAL> "else"	{ return symbol(sym.ELSE);}
<YYINITIAL> "null"	{ return symbol(sym.NULL);}
<YYINITIAL> "super"	{ return symbol(sym.SUPER);}

<YYINITIAL> "public static void main(String[] args)" {return symbol(sym.MAIN);}


// Primitive types

<YYINITIAL> "boolean"	{ return symbol(sym.BOOL);}
<YYINITIAL> "char"	{ return symbol(sym.CHAR);}
<YYINITIAL> "double"	{ return symbol(sym.DOUBLE);}
<YYINITIAL> "int"	{ return symbol(sym.INT);}
<YYINITIAL> "long"	{ return symbol(sym.LONG);}

// Operators

<YYINITIAL> "="		{ return symbol(sym.ASSIGN);}
<YYINITIAL> "&&"	{ return symbol(sym.AND);}
<YYINITIAL> "/"		{ return symbol(sym.DIV);}
<YYINITIAL> "=="	{ return symbol(sym.EQ);}
<YYINITIAL> ">"		{ return symbol(sym.GT);}
<YYINITIAL> ">="	{ return symbol(sym.GTE);}
<YYINITIAL> "-"		{ return symbol(sym.MINUS);}
<YYINITIAL> "%"		{ return symbol(sym.MOD);}
<YYINITIAL> "*"		{ return symbol(sym.MULT);}
<YYINITIAL> "!"		{ return symbol(sym.NOT);}
<YYINITIAL> "||"		{ return symbol(sym.OR);}
<YYINITIAL> "+"		{ return symbol(sym.PLUS);}

// Brackets

<YYINITIAL> "("		{ return symbol(sym.BRACKETL);}
<YYINITIAL> ")"		{ return symbol(sym.BRACKETR);}
<YYINITIAL> "{"		{ return symbol(sym.CURLYBRACEL);}
<YYINITIAL> "}"		{ return symbol(sym.CURLYBRACER);}

// Random

<YYINITIAL> "\."		{ return symbol(sym.PERIOD);}
<YYINITIAL> ";"		{ return symbol(sym.SEMICOLON);}
<YYINITIAL> ","		{ return symbol(sym.COMMA);}

// Ignore comments and whitespace
	
{Comment}			{ }
{WhiteSpace}		{ }

// Literals

<YYINITIAL> "true"	{ return symbol(sym.LITBOOL, Boolean.TRUE);}
<YYINITIAL> "false"	{ return symbol(sym.LITBOOL, Boolean.FALSE);}
{DecIntegerLiteral}	{
					Integer num;
					
					// throws NumberFormatException
					num = Integer.parseInt(yytext());

					return  symbol(sym.LITINT, num);
				}
{DecLongLiteral}		{
					Long num;

					// Guaranteed to end in L or l
					String numText = yytext().substring(0, yytext().length()-1);

					// throws NumberFormatException
					num = Long.parseLong(numText);

					return symbol(sym.LITLONG, num);
				}
'.'				{
					// character guaranteed to be 2nd char, of 3
					Character c = yytext().charAt(1);

					return symbol(sym.LITCHAR, c);
				}
{DecDoubleLiteral}	{
					double num;

					// throws NumberFormatException
					num = Double.parseDouble(yytext());

					return symbol(sym.LITDOUBLE, num);
				}


// Idents
{Identifier}			{ return symbol(sym.IDENT, yytext()); }

// Error
[^]		{ throw new UnexpectedCharacterException(yytext(), yyline, yycolumn); }