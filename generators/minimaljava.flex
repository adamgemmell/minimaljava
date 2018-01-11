/* Spec file built with the guidance of the example lexer at http://jflex.de/manual.html */

package com.ajsg2.minimaljava.lex;

import com.ajsg2.minimaljava.common.tokens.*;
import com.ajsg2.minimaljava.common.tokens.simple.*;
import com.ajsg2.minimaljava.common.tokens.value.*;

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
%type Token
%yylexthrow UnexpectedCharacterException,NumberFormatException
%eofclose

// Custom code block
%{
    //empty
%}

LineTerminator	= \r|\n|\r\n
InputCharacter	= [^\r\n]
WhiteSpace		= {LineTerminator}|[ \t\f]

Comment = "//" {InputCharacter}*{LineTerminator}?

Identifier = [:jletter:][:jletterdigit:]*
DecIntegerLiteral = 0[^0-9]|[1-9][0-9]*
DecLongLiteral = 0[Ll]|[1-9][0-9]*[Ll]
DecDoubleLiteral = (0[^0-9]|[1-9][0-9]*)\.[0-9]*

%%

// Keywords

<YYINITIAL> "new"	{ return new KeywordNew(yyline, yycolumn);}
<YYINITIAL> "return"	{ return new KeywordReturn(yyline, yycolumn);}
<YYINITIAL> "void"	{ return new KeywordVoid(yyline, yycolumn);}
<YYINITIAL> "class"	{ return new KeywordClass(yyline, yycolumn);}
<YYINITIAL> "extends"	{ return new KeywordExtends(yyline, yycolumn);}

// Primitive types

<YYINITIAL> "boolean"	{ return new TypeBoolean(yyline, yycolumn);}
<YYINITIAL> "char"	{ return new TypeChar(yyline, yycolumn);}
<YYINITIAL> "double"	{ return new TypeDouble(yyline, yycolumn);}
<YYINITIAL> "int"	{ return new TypeInt(yyline, yycolumn);}
<YYINITIAL> "long"	{ return new TypeLong(yyline, yycolumn);}

// Operators

<YYINITIAL> "="		{ return new Assignment(yyline, yycolumn);}
<YYINITIAL> "&&"	{ return new OpAnd(yyline, yycolumn);}
<YYINITIAL> "/"		{ return new OpDiv(yyline, yycolumn);}
<YYINITIAL> "=="	{ return new OpEq(yyline, yycolumn);}
<YYINITIAL> ">"		{ return new OpGT(yyline, yycolumn);}
<YYINITIAL> ">="	{ return new OpGTE(yyline, yycolumn);}
<YYINITIAL> "-"		{ return new OpMinus(yyline, yycolumn);}
<YYINITIAL> "%"		{ return new OpMod(yyline, yycolumn);}
<YYINITIAL> "*"		{ return new OpMult(yyline, yycolumn);}
<YYINITIAL> "!"		{ return new OpNot(yyline, yycolumn);}
<YYINITIAL> "||"		{ return new OpOr(yyline, yycolumn);}
<YYINITIAL> "+"		{ return new OpPlus(yyline, yycolumn);}

// Brackets

<YYINITIAL> "("		{ return new BracketL(yyline, yycolumn);}
<YYINITIAL> ")"		{ return new BracketR(yyline, yycolumn);}
<YYINITIAL> "{"		{ return new CurlyBraceL(yyline, yycolumn);}
<YYINITIAL> "}"		{ return new CurlyBraceR(yyline, yycolumn);}

// Random

<YYINITIAL> "\."		{ return new Period(yyline, yycolumn);}
<YYINITIAL> ";"		{ return new Semicolon(yyline, yycolumn);}

// Ignore comments and whitespace
	
{Comment}			{ }
{WhiteSpace}		{ }

// Literals

<YYINITIAL> "true"	{ return new LitBool(yyline, yycolumn, true);}
<YYINITIAL> "false"	{ return new LitBool(yyline, yycolumn, false);}
{DecIntegerLiteral}	{
					Integer num;
					
					// throws NumberFormatException
					num = Integer.parseInt(yytext());

					return new LitInt(yyline, yycolumn, num);
				}
{DecLongLiteral}		{
					Long num;

					// Guaranteed to end in L or l
					String numText = yytext().substring(0, yytext().length()-1);

					// throws NumberFormatException
					num = Long.parseLong(numText);

					return new LitLong(yyline, yycolumn, num);
				}
'.'				{
					// character guaranteed to be 2nd char, of 3
					Character c = yytext().charAt(1);

					return new LitChar(yyline, yycolumn, c);
				}
{DecDoubleLiteral}	{
					double num;

					// throws NumberFormatException
					num = Double.parseDouble(yytext());

					return new LitDouble(yyline, yycolumn, num);
				}


// Idents
{Identifier}			{ return new Identifier(yyline, yycolumn, yytext()); }

// Error
[^]		{ throw new UnexpectedCharacterException(yytext(), yyline, yycolumn); }