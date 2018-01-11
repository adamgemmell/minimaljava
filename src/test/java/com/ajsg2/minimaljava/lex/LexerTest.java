package com.ajsg2.minimaljava.lex;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.ajsg2.minimaljava.common.tokens.Token;
import com.ajsg2.minimaljava.common.tokens.UnexpectedCharacterException;
import com.ajsg2.minimaljava.common.tokens.simple.Assignment;
import com.ajsg2.minimaljava.common.tokens.simple.BracketL;
import com.ajsg2.minimaljava.common.tokens.simple.BracketR;
import com.ajsg2.minimaljava.common.tokens.simple.CurlyBraceL;
import com.ajsg2.minimaljava.common.tokens.simple.CurlyBraceR;
import com.ajsg2.minimaljava.common.tokens.simple.KeywordClass;
import com.ajsg2.minimaljava.common.tokens.simple.KeywordExtends;
import com.ajsg2.minimaljava.common.tokens.simple.KeywordNew;
import com.ajsg2.minimaljava.common.tokens.simple.KeywordReturn;
import com.ajsg2.minimaljava.common.tokens.simple.KeywordVoid;
import com.ajsg2.minimaljava.common.tokens.simple.OpAnd;
import com.ajsg2.minimaljava.common.tokens.simple.OpDiv;
import com.ajsg2.minimaljava.common.tokens.simple.OpEq;
import com.ajsg2.minimaljava.common.tokens.simple.OpGT;
import com.ajsg2.minimaljava.common.tokens.simple.OpGTE;
import com.ajsg2.minimaljava.common.tokens.simple.OpMinus;
import com.ajsg2.minimaljava.common.tokens.simple.OpMod;
import com.ajsg2.minimaljava.common.tokens.simple.OpMult;
import com.ajsg2.minimaljava.common.tokens.simple.OpNot;
import com.ajsg2.minimaljava.common.tokens.simple.OpOr;
import com.ajsg2.minimaljava.common.tokens.simple.OpPlus;
import com.ajsg2.minimaljava.common.tokens.simple.Period;
import com.ajsg2.minimaljava.common.tokens.simple.Semicolon;
import com.ajsg2.minimaljava.common.tokens.simple.TypeBoolean;
import com.ajsg2.minimaljava.common.tokens.simple.TypeChar;
import com.ajsg2.minimaljava.common.tokens.simple.TypeDouble;
import com.ajsg2.minimaljava.common.tokens.simple.TypeInt;
import com.ajsg2.minimaljava.common.tokens.simple.TypeLong;
import com.ajsg2.minimaljava.common.tokens.value.Identifier;
import com.ajsg2.minimaljava.common.tokens.value.LitBool;
import com.ajsg2.minimaljava.common.tokens.value.LitInt;
import com.ajsg2.minimaljava.common.tokens.value.LitLong;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import org.junit.jupiter.api.Test;

class LexerTest {

	private BufferedReader mockReader(String fileContents) {
		return new BufferedReader(new StringReader(fileContents));
	}

	@Test
	void testLexerInitialise() {
		String file = "class";

		try (Reader reader = mockReader(file)) {
			Lexer lexer = new Lexer(reader);

			Token classToken = lexer.yylex();
			assertTrue(classToken instanceof KeywordClass,
					"Expected class token, received " + classToken.getClass());

		} catch (IOException e) {
			fail("IOException thrown: " + e.getLocalizedMessage());
		} catch (UnexpectedCharacterException e) {
			fail("UnexpectedCharacterException thrown: " + e.getLocalizedMessage());
		}
	}

	@Test
	void testLexerFileNotFound() {
		String filePath = "as;dofihasofi";

		try {
			new Lexer(new BufferedReader(new FileReader(filePath)));
			fail("No exception thrown");
		} catch (FileNotFoundException e) {
			// Success
		} catch (Exception e) {
			fail("Suitable exception not thrown: " + e.getClass());
		}
	}

	@Test
	void testKeywords() {
		String file = "class\nextends\nnew\nreturn\nvoid";

		try (Reader reader = mockReader(file)) {
			Lexer lexer = new Lexer(reader);

			Token token = lexer.yylex();
			assertTrue(token instanceof KeywordClass,
					"Expected 'class', received " + token.getClass());
			token = lexer.yylex();
			assertTrue(token instanceof KeywordExtends,
					"Expected 'extends', received " + token.getClass());
			token = lexer.yylex();
			assertTrue(token instanceof KeywordNew,
					"Expected 'new', received " + token.getClass());
			token = lexer.yylex();
			assertTrue(token instanceof KeywordReturn,
					"Expected 'return', received " + token.getClass());
			token = lexer.yylex();
			assertTrue(token instanceof KeywordVoid,
					"Expected 'void', received " + token.getClass());

			token = lexer.yylex();
			assertNull(token, "Expected EOF, received something else");

		} catch (IOException e) {
			fail("IOException thrown: " + e.getLocalizedMessage());
		} catch (UnexpectedCharacterException e) {
			fail("UnexpectedCharacterException thrown: " + e.getLocalizedMessage());
		}
	}

	@Test
	void testPrimitiveTypes() {
		String file = "boolean\nchar\ndouble\nint\nlong";

		try (Reader reader = mockReader(file)) {
			Lexer lexer = new Lexer(reader);

			Token token = lexer.yylex();
			assertTrue(token instanceof TypeBoolean,
					"Expected 'boolean', received " + token.getClass());
			token = lexer.yylex();
			assertTrue(token instanceof TypeChar,
					"Expected 'char', received " + token.getClass());
			token = lexer.yylex();
			assertTrue(token instanceof TypeDouble,
					"Expected 'double', received " + token.getClass());
			token = lexer.yylex();
			assertTrue(token instanceof TypeInt,
					"Expected 'int', received " + token.getClass());
			token = lexer.yylex();
			assertTrue(token instanceof TypeLong,
					"Expected 'long', received " + token.getClass());

			token = lexer.yylex();
			assertNull(token, "Expected EOF, received something else");

		} catch (IOException e) {
			fail("IOException thrown: " + e.getLocalizedMessage());
		} catch (UnexpectedCharacterException e) {
			fail("UnexpectedCharacterException thrown: " + e.getLocalizedMessage());
		}
	}

	@Test
	void testOperators() {
		String file = "= && / == > >= - % * ! || +";

		try (Reader reader = mockReader(file)) {
			Lexer lexer = new Lexer(reader);

			Token token = lexer.yylex();
			assertTrue(token instanceof Assignment,
					"Expected '=', received " + token.getClass());
			token = lexer.yylex();
			assertTrue(token instanceof OpAnd,
					"Expected '&&', received " + token.getClass());
			token = lexer.yylex();
			assertTrue(token instanceof OpDiv,
					"Expected '/', received " + token.getClass());
			token = lexer.yylex();
			assertTrue(token instanceof OpEq,
					"Expected '==', received " + token.getClass());
			token = lexer.yylex();
			assertTrue(token instanceof OpGT,
					"Expected '>', received " + token.getClass());
			token = lexer.yylex();
			assertTrue(token instanceof OpGTE,
					"Expected '>=', received " + token.getClass());
			token = lexer.yylex();
			assertTrue(token instanceof OpMinus,
					"Expected '-', received " + token.getClass());
			token = lexer.yylex();
			assertTrue(token instanceof OpMod,
					"Expected '%', received " + token.getClass());
			token = lexer.yylex();
			assertTrue(token instanceof OpMult,
					"Expected '*', received " + token.getClass());
			token = lexer.yylex();
			assertTrue(token instanceof OpNot,
					"Expected '!', received " + token.getClass());
			token = lexer.yylex();
			assertTrue(token instanceof OpOr,
					"Expected '||', received " + token.getClass());
			token = lexer.yylex();
			assertTrue(token instanceof OpPlus,
					"Expected '++', received " + token.getClass());

			token = lexer.yylex();
			assertNull(token, "Expected EOF, received something else");

		} catch (IOException e) {
			fail("IOException thrown: " + e.getLocalizedMessage());
		} catch (UnexpectedCharacterException e) {
			fail("UnexpectedCharacterException thrown: " + e.getLocalizedMessage());
		}
	}

	@Test
	void testBrackets() {
		String file = "(){}";

		try (Reader reader = mockReader(file)) {
			Lexer lexer = new Lexer(reader);

			Token token = lexer.yylex();
			assertTrue(token instanceof BracketL,
					"Expected '(', received " + token.getClass());
			token = lexer.yylex();
			assertTrue(token instanceof BracketR,
					"Expected ')', received " + token.getClass());
			token = lexer.yylex();
			assertTrue(token instanceof CurlyBraceL,
					"Expected '{', received " + token.getClass());
			token = lexer.yylex();
			assertTrue(token instanceof CurlyBraceR,
					"Expected '}', received " + token.getClass());

			token = lexer.yylex();
			assertNull(token, "Expected EOF, received something else");

		} catch (IOException e) {
			fail("IOException thrown: " + e.getLocalizedMessage());
		} catch (UnexpectedCharacterException e) {
			fail("UnexpectedCharacterException thrown: " + e.getLocalizedMessage());
		}
	}

	@Test
	void testRandom() {
		String file = ". ;\n//this is a comment including a keyword class\nclass";

		try (Reader reader = mockReader(file)) {
			Lexer lexer = new Lexer(reader);

			Token token = lexer.yylex();
			assertTrue(token instanceof Period,
					"Expected '.', received " + token.getClass());
			token = lexer.yylex();
			assertTrue(token instanceof Semicolon,
					"Expected ';', received " + token.getClass());
			token = lexer.yylex();
			assertTrue(token instanceof KeywordClass,
					"Expected 'class', received " + token.getClass());

			token = lexer.yylex();
			assertNull(token, "Expected EOF, received something else");

		} catch (IOException e) {
			fail("IOException thrown: " + e.getLocalizedMessage());
		} catch (UnexpectedCharacterException e) {
			fail("UnexpectedCharacterException thrown: " + e.getLocalizedMessage());
		}
	}

	@Test
	void testIdents() {
		String file = "randomidentifier Class\nCLASS";

		try (Reader reader = mockReader(file)) {
			Lexer lexer = new Lexer(reader);

			Token token;
			Identifier ident;

			token = lexer.yylex();
			assertTrue(token instanceof Identifier,
					"Expected Identifier, received " + token.getClass());
			ident = (Identifier) token;
			assertTrue(ident.getValue().equals("randomidentifier"),
					"Expected Identifier with value 'randomidentifier', received: " + ident
							.getValue());

			token = lexer.yylex();
			assertTrue(token instanceof Identifier,
					"Expected Identifier, received " + token.getClass());
			ident = (Identifier) token;
			assertTrue(ident.getValue().equals("Class"),
					"Expected Identifier with value 'Class', received: " + ident
							.getValue());

			token = lexer.yylex();
			assertTrue(token instanceof Identifier,
					"Expected Identifier, received " + token.getClass());
			ident = (Identifier) token;
			assertTrue(ident.getValue().equals("CLASS"),
					"Expected Identifier with value 'CLASS', received: " + ident
							.getValue());

			token = lexer.yylex();
			assertNull(token, "Expected EOF, received something else");

		} catch (IOException e) {
			fail("IOException thrown: " + e.getLocalizedMessage());
		} catch (UnexpectedCharacterException e) {
			fail("UnexpectedCharacterException thrown: " + e.getLocalizedMessage());
		}
	}

	@Test
	void testBools() {
		String file = "true false\nfalsetrue";

		try (Reader reader = mockReader(file)) {
			Lexer lexer = new Lexer(reader);

			Token token;
			LitBool bool;

			token = lexer.yylex();
			assertTrue(token instanceof LitBool,
					"Expected boolean, received " + token.getClass());
			bool = (LitBool) token;
			assertTrue(bool.getValue(), "Expected 'true', received " + bool.getValue());

			token = lexer.yylex();
			assertTrue(token instanceof LitBool,
					"Expected boolean, received " + token.getClass());
			bool = (LitBool) token;
			assertTrue(!bool.getValue(), "Expected 'false', received " + bool.getValue());

			token = lexer.yylex();
			assertTrue(token instanceof Identifier,
					"Expected ident, received " + token.getClass());

			token = lexer.yylex();
			assertNull(token, "Expected EOF, received something else");

		} catch (IOException e) {
			fail("IOException thrown: " + e.getLocalizedMessage());
		} catch (UnexpectedCharacterException e) {
			fail("UnexpectedCharacterException thrown: " + e.getLocalizedMessage());
		}
	}

	@Test
	void testIntegers() {
		String file = "69 420 \n-846123 0123";

		try (Reader reader = mockReader(file)) {
			Lexer lexer = new Lexer(reader);

			Token token;
			LitInt integer;

			token = lexer.yylex();
			assertTrue(token instanceof LitInt,
					"Expected int, received " + token.getClass());
			integer = (LitInt) token;
			assertTrue(integer.getValue() == 69, "Expected '69', received " + integer.getValue());

			token = lexer.yylex();
			assertTrue(token instanceof LitInt,
					"Expected int, received " + token.getClass());
			integer = (LitInt) token;
			assertTrue(integer.getValue() == 420, "Expected '420', received " + integer.getValue());

			token = lexer.yylex();
			assertTrue(token instanceof OpMinus,
					"Expected '-', received " + token.getClass());
			token = lexer.yylex();
			assertTrue(token instanceof LitInt,
					"Expected int, received " + token.getClass());
			integer = (LitInt) token;
			assertTrue(integer.getValue() == 846123,
					"Expected '846123', received " + integer.getValue());

			try {
				token = lexer.yylex();
				fail("Expected UnexpectedCharacterException: 0. Lexed " + token.getClass());
			} catch (UnexpectedCharacterException e) {
				//Success
			}

		} catch (IOException e) {
			fail("IOException thrown: " + e.getLocalizedMessage());
		} catch (UnexpectedCharacterException e) {
			fail("UnexpectedCharacterException thrown: " + e.getLocalizedMessage());
		}
	}

	@Test
	void testLong() {
		long num = Integer.MAX_VALUE + 684613L;
		String file = "69L 69 \n" + num + "L";

		try (Reader reader = mockReader(file)) {
			Lexer lexer = new Lexer(reader);

			Token token;
			LitLong longNum;

			token = lexer.yylex();
			assertTrue(token instanceof LitLong,
					"Expected long, received " + token.getClass());
			longNum = (LitLong) token;
			assertTrue(longNum.getValue() == 69L, "Expected '69L', received " + longNum.getValue());

			token = lexer.yylex();
			assertTrue(token instanceof LitInt,
					"Expected int, received " + token.getClass());

			token = lexer.yylex();
			assertTrue(token instanceof LitLong,
					"Expected long, received " + token.getClass());
			longNum = (LitLong) token;
			assertTrue(longNum.getValue() > Integer.MAX_VALUE,
					"Expected value outside of range of Integer, received " + longNum.getValue());

			token = lexer.yylex();
			assertNull(token, "Expected EOF, received something else");

		} catch (IOException e) {
			fail("IOException thrown: " + e.getLocalizedMessage());
		} catch (UnexpectedCharacterException e) {
			fail("UnexpectedCharacterException thrown: " + e.getLocalizedMessage());
		}
	}
}