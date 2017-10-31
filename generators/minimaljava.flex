/**
 * The Minimal Java Lexer
 */
%%
%class Lexer
%unicode
%line
%column

%{
    StringBuffer string = new StringBuffer();