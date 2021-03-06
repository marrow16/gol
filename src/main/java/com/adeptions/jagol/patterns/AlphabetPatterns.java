package com.adeptions.jagol.patterns;

import java.util.ArrayList;
import java.util.List;

public class AlphabetPatterns {
	public static final int CHAR_HEIGHT = 9;

	private static final IPattern[] ASCII_PATTERNS = new IPattern[] {
			new Pattern(" (32)", 3, new int[] {
					0,0,0,
					0,0,0,
					0,0,0,
					0,0,0,
					0,0,0,
					0,0,0,
					0,0,0,
					0,0,0,
					0,0,0,
			}),
			new Pattern("! (33)", 1, new int[] {
					1,
					1,
					1,
					1,
					1,
					0,
					1,
					0,
					0,
			}),
			new Pattern("\" (34)", 3, new int[] {
					1,0,1,
					1,0,1,
					0,0,0,
					0,0,0,
					0,0,0,
					0,0,0,
					0,0,0,
					0,0,0,
					0,0,0,
			}),
			new Pattern("# (35)", 5, new int[] {
					0,1,0,1,0,
					0,1,0,1,0,
					1,1,1,1,1,
					0,1,0,1,0,
					1,1,1,1,1,
					0,1,0,1,0,
					0,1,0,1,0,
					0,0,0,0,0,
					0,0,0,0,0
			}),
			new Pattern("$ (36)", 5, new int[] {
					0,0,1,0,0,
					0,1,1,1,0,
					1,0,1,0,1,
					0,1,1,0,0,
					0,0,1,1,0,
					1,0,1,0,1,
					0,1,1,1,0,
					0,0,1,0,0,
					0,0,0,0,0
			}),
			new Pattern("% (37)", 6, new int[] {
					0,0,0,0,0,0,
					1,1,0,0,0,1,
					1,1,0,0,1,0,
					0,0,0,1,0,0,
					0,0,1,0,0,0,
					0,1,0,0,1,1,
					1,0,0,0,1,1,
					0,0,0,0,0,0,
					0,0,0,0,0,0
			}),
			new Pattern("& (38)", 5, new int[] {
					0,1,0,0,0,
					1,0,1,0,0,
					0,1,0,0,0,
					1,0,1,0,1,
					1,0,0,1,0,
					1,0,0,1,0,
					0,1,1,0,1,
					0,0,0,0,0,
					0,0,0,0,0
			}),
			new Pattern("' (39)", 1, new int[] {
					1,
					1,
					0,
					0,
					0,
					0,
					0,
					0,
					0
			}),
			new Pattern("( (40)", 2, new int[] {
					0,1,
					1,0,
					1,0,
					1,0,
					1,0,
					1,0,
					1,0,
					0,1,
					0,0
			}),
			new Pattern(") (41)", 2, new int[] {
					1,0,
					0,1,
					1,1,
					1,1,
					1,1,
					1,1,
					1,1,
					1,0,
					0,0
			}),
			new Pattern("* (42)", 3, new int[] {
					0,1,0,
					1,1,0,
					0,1,0,
					1,0,1,
					0,0,0,
					0,0,0,
					0,0,0,
					0,0,0,
					0,0,0
			}),
			new Pattern("+ (43)", 3, new int[] {
					0,0,0,
					0,0,0,
					0,0,0,
					0,1,0,
					1,1,1,
					0,1,0,
					0,0,0,
					0,0,0,
					0,0,0
			}),
			new Pattern(", (44)", 1, new int[] {
					0,
					0,
					0,
					0,
					0,
					0,
					1,
					1,
					0
			}),
			new Pattern("- (45)", 3, new int[] {
					0,0,0,
					0,0,0,
					0,0,0,
					0,0,0,
					1,1,1,
					0,0,0,
					0,0,0,
					0,0,0,
					0,0,0
			}),
			new Pattern(". (46)", 1, new int[] {
					0,
					0,
					0,
					0,
					0,
					0,
					1,
					0,
					0
			}),
			new Pattern("/ (47)", 3, new int[] {
					0,0,1,
					0,0,1,
					0,1,0,
					0,1,0,
					0,1,0,
					1,0,0,
					1,0,0,
					0,0,0,
					0,0,0
			}),
			new Pattern("0 (48)", 4, new int[] {
					0,1,1,0,
					1,0,0,1,
					1,0,0,1,
					1,0,0,1,
					1,0,0,1,
					1,0,0,1,
					0,1,1,0,
					0,0,0,0,
					0,0,0,0
			}),
			new Pattern("1 (49)", 2, new int[] {
					0,1,
					1,1,
					0,1,
					0,1,
					0,1,
					0,1,
					0,1,
					0,0,
					0,0
			}),
			new Pattern("2 (50)", 4, new int[] {
					0,1,1,0,
					1,0,0,1,
					0,0,0,1,
					0,0,1,0,
					0,1,0,0,
					1,0,0,0,
					1,1,1,1,
					0,0,0,0,
					0,0,0,0
			}),
			new Pattern("3 (51)", 4, new int[] {
					0,1,1,0,
					1,0,0,1,
					0,0,0,1,
					0,0,1,0,
					0,0,0,1,
					1,0,0,1,
					0,1,1,0,
					0,0,0,0,
					0,0,0,0
			}),
			new Pattern("4 (52)", 4, new int[] {
					0,0,1,0,
					0,1,1,0,
					0,1,1,0,
					1,0,1,0,
					1,1,1,1,
					0,0,1,0,
					0,0,1,0,
					0,0,0,0,
					0,0,0,0
			}),
			new Pattern("5 (53)", 4, new int[] {
					1,1,1,1,
					1,0,0,0,
					1,1,1,0,
					1,0,0,1,
					0,0,0,1,
					1,0,0,1,
					0,1,1,0,
					0,0,0,0,
					0,0,0,0
			}),
			new Pattern("6 (54)", 4, new int[] {
					0,1,1,0,
					1,0,0,1,
					1,0,0,0,
					1,1,1,0,
					1,0,0,1,
					1,0,0,1,
					0,1,1,0,
					0,0,0,0,
					0,0,0,0
			}),
			new Pattern("7 (55)", 4, new int[] {
					1,1,1,1,
					0,0,0,1,
					0,0,1,0,
					0,0,1,0,
					0,1,0,0,
					0,1,0,0,
					0,1,0,0,
					0,0,0,0,
					0,0,0,0
			}),
			new Pattern("8 (56)", 4, new int[] {
					0,1,1,0,
					1,0,0,1,
					1,0,0,1,
					0,1,1,0,
					1,0,0,1,
					1,0,0,1,
					0,1,1,0,
					0,0,0,0,
					0,0,0,0
			}),
			new Pattern("9 (57)", 4, new int[] {
					0,1,1,0,
					1,0,0,1,
					1,0,0,1,
					0,1,1,1,
					0,0,0,1,
					1,0,0,1,
					0,1,1,0,
					0,0,0,0,
					0,0,0,0
			}),
			new Pattern(": (58)", 1, new int[] {
					0,
					0,
					0,
					1,
					0,
					0,
					1,
					0,
					0
			}),
			new Pattern("; (59)", 1, new int[] {
					0,
					0,
					0,
					1,
					0,
					0,
					1,
					1,
					0
			}),
			new Pattern("< (60)", 3, new int[] {
					0,0,0,
					0,0,0,
					0,0,1,
					0,1,0,
					1,0,0,
					0,1,0,
					0,0,1,
					0,0,0,
					0,0,0
			}),
			new Pattern("= (61)", 3, new int[] {
					0,0,0,
					0,0,0,
					0,0,0,
					1,1,1,
					0,0,0,
					1,1,1,
					0,0,0,
					0,0,0,
					0,0,0
			}),
			new Pattern("> (62)", 3, new int[] {
					0,0,0,
					0,0,0,
					1,0,0,
					0,1,0,
					0,0,1,
					0,1,0,
					1,0,0,
					0,0,0,
					0,0,0
			}),
			new Pattern("? (63)", 4, new int[] {
					0,1,1,0,
					1,0,0,1,
					0,0,0,1,
					0,0,1,0,
					0,1,0,0,
					0,0,0,0,
					0,1,0,0,
					0,0,0,0,
					0,0,0,0
			}),
			new Pattern("@ (64)", 8, new int[] {
					0,0,1,1,1,1,0,0,
					0,1,0,0,0,0,1,0,
					1,0,0,1,1,0,0,1,
					1,0,1,0,1,0,0,1,
					1,0,1,0,1,0,0,1,
					1,0,0,1,0,1,1,0,
					0,1,0,0,0,0,0,0,
					0,0,1,1,1,1,0,0,
					0,0,0,0,0,0,0,0
			}),
			new Pattern("A", 6, new int[] {
					0,0,1,1,0,0,
					0,0,1,1,0,0,
					0,1,0,0,1,0,
					0,1,0,0,1,0,
					0,1,1,1,1,0,
					1,0,0,0,0,1,
					1,0,0,0,0,1,
					0,0,0,0,0,0,
					0,0,0,0,0,0
			}),
			new Pattern("B", 5, new int[] {
					1,1,1,1,0,
					1,0,0,0,1,
					1,0,0,0,1,
					1,1,1,1,0,
					1,0,0,0,1,
					1,0,0,0,1,
					1,1,1,1,0,
					0,0,0,0,0,
					0,0,0,0,0
			}),
			new Pattern("C", 5, new int[] {
					0,1,1,1,0,
					1,0,0,0,1,
					1,0,0,0,0,
					1,0,0,0,0,
					1,0,0,0,0,
					1,0,0,0,1,
					0,1,1,1,0,
					0,0,0,0,0,
					0,0,0,0,0
			}),
			new Pattern("D", 5, new int[] {
					1,1,1,1,0,
					1,0,0,0,1,
					1,0,0,0,1,
					1,0,0,0,1,
					1,0,0,0,1,
					1,0,0,0,1,
					1,1,1,1,0,
					0,0,0,0,0,
					0,0,0,0,0
			}),
			new Pattern("E", 4, new int[] {
					1,1,1,1,
					1,0,0,0,
					1,0,0,0,
					1,1,1,0,
					1,0,0,0,
					1,0,0,0,
					1,1,1,1,
					0,0,0,0,
					0,0,0,0
			}),
			new Pattern("F", 4, new int[] {
					1,1,1,1,
					1,0,0,0,
					1,0,0,0,
					1,1,1,0,
					1,0,0,0,
					1,0,0,0,
					1,0,0,0,
					0,0,0,0,
					0,0,0,0
			}),
			new Pattern("G", 5, new int[] {
					0,1,1,1,0,
					1,0,0,0,1,
					1,0,0,0,0,
					1,0,1,1,1,
					1,0,0,0,1,
					1,0,0,1,1,
					0,1,1,0,1,
					0,0,0,0,0,
					0,0,0,0,0
			}),
			new Pattern("H", 5, new int[] {
					1,0,0,0,1,
					1,0,0,0,1,
					1,0,0,0,1,
					1,1,1,1,1,
					1,0,0,0,1,
					1,0,0,0,1,
					1,0,0,0,1,
					0,0,0,0,0,
					0,0,0,0,0
			}),
			new Pattern("I", 3, new int[] {
					1,1,1,
					0,1,0,
					0,1,0,
					0,1,0,
					0,1,0,
					0,1,0,
					1,1,1,
					0,0,0,
					0,0,0
			}),
			new Pattern("J", 4, new int[] {
					0,0,0,1,
					0,0,0,1,
					0,0,0,1,
					0,0,0,1,
					1,0,0,1,
					1,0,0,1,
					0,1,1,0,
					0,0,0,0,
					0,0,0,0,
			}),
			new Pattern("K", 5, new int[] {
					1,0,0,0,1,
					1,0,0,1,0,
					1,0,1,0,0,
					1,1,0,0,0,
					1,0,1,0,0,
					1,0,0,1,0,
					1,0,0,0,1,
					0,0,0,0,0,
					0,0,0,0,0,
			}),
			new Pattern("L", 4, new int[] {
					1,0,0,0,
					1,0,0,0,
					1,0,0,0,
					1,0,0,0,
					1,0,0,0,
					1,0,0,0,
					1,1,1,1,
					0,0,0,0,
					0,0,0,0
			}),
			new Pattern("M", 7, new int[] {
					1,1,0,0,0,1,1,
					1,1,0,0,0,1,1,
					1,0,1,0,1,0,1,
					1,0,1,0,1,0,1,
					1,0,0,1,0,0,1,
					1,0,0,1,0,0,1,
					1,0,0,0,0,0,1,
					0,0,0,0,0,0,0,
					0,0,0,0,0,0,0
			}),
			new Pattern("N", 5, new int[] {
					1,1,0,0,1,
					1,1,0,0,1,
					1,0,1,0,1,
					1,0,1,0,1,
					1,0,0,1,1,
					1,0,0,1,1,
					1,0,0,0,1,
					0,0,0,0,0,
					0,0,0,0,0
			}),
			new Pattern("O", 5, new int[] {
					0,1,1,1,0,
					1,0,0,0,1,
					1,0,0,0,1,
					1,0,0,0,1,
					1,0,0,0,1,
					1,0,0,0,1,
					0,1,1,1,0,
					0,0,0,0,0,
					0,0,0,0,0
			}),
			new Pattern("P", 5, new int[] {
					1,1,1,1,0,
					1,0,0,0,1,
					1,0,0,0,1,
					1,1,1,1,0,
					1,0,0,0,0,
					1,0,0,0,0,
					1,0,0,0,0,
					0,0,0,0,0,
					0,0,0,0,0
			}),
			new Pattern("Q", 5, new int[] {
					0,1,1,1,0,
					1,0,0,0,1,
					1,0,0,0,1,
					1,0,0,0,1,
					1,0,1,0,1,
					1,0,0,1,1,
					0,1,1,1,0,
					0,0,0,0,1,
					0,0,0,0,0
			}),
			new Pattern("R", 5, new int[] {
					1,1,1,1,0,
					1,0,0,0,1,
					1,0,0,0,1,
					1,1,1,1,0,
					1,0,0,0,1,
					1,0,0,0,1,
					1,0,0,0,1,
					0,0,0,0,0,
					0,0,0,0,0
			}),
			new Pattern("S", 5, new int[] {
					0,1,1,1,0,
					1,0,0,0,1,
					1,0,0,0,0,
					0,1,1,1,0,
					0,0,0,0,1,
					1,0,0,0,1,
					0,1,1,1,0,
					0,0,0,0,0,
					0,0,0,0,0
			}),
			new Pattern("T", 5, new int[] {
					1,1,1,1,1,
					0,0,1,0,0,
					0,0,1,0,0,
					0,0,1,0,0,
					0,0,1,0,0,
					0,0,1,0,0,
					0,0,1,0,0,
					0,0,0,0,0,
					0,0,0,0,0
			}),
			new Pattern("U", 5, new int[] {
					1,0,0,0,1,
					1,0,0,0,1,
					1,0,0,0,1,
					1,0,0,0,1,
					1,0,0,0,1,
					1,0,0,0,1,
					0,1,1,1,0,
					0,0,0,0,0,
					0,0,0,0,0
			}),
			new Pattern("V", 5, new int[] {
					1,0,0,0,1,
					1,0,0,0,1,
					0,1,0,1,0,
					0,1,0,1,0,
					0,1,0,1,0,
					0,0,1,0,0,
					0,0,1,0,0,
					0,0,0,0,0,
					0,0,0,0,0
			}),
			new Pattern("W", 7, new int[] {
					1,0,0,0,0,0,1,
					1,0,0,0,0,0,1,
					0,1,0,0,0,1,0,
					0,1,0,1,0,1,0,
					0,1,0,1,0,1,0,
					0,0,1,0,1,0,0,
					0,0,1,0,1,0,0,
					0,0,0,0,0,0,0,
					0,0,0,0,0,0,0
			}),
			new Pattern("X", 5, new int[] {
					1,0,0,0,1,
					1,0,0,0,1,
					0,1,0,1,0,
					0,0,1,0,0,
					0,1,0,1,0,
					1,0,0,0,1,
					1,0,0,0,1,
					0,0,0,0,0,
					0,0,0,0,0
			}),
			new Pattern("Y", 5, new int[] {
					1,0,0,0,1,
					1,0,0,0,1,
					0,1,0,1,0,
					0,0,1,0,0,
					0,0,1,0,0,
					0,0,1,0,0,
					0,0,1,0,0,
					0,0,0,0,0,
					0,0,0,0,0
			}),
			new Pattern("Z", 5, new int[] {
					1,1,1,1,1,
					0,0,0,0,1,
					0,0,0,1,0,
					0,0,1,0,0,
					0,1,0,0,0,
					1,0,0,0,0,
					1,1,1,1,1,
					0,0,0,0,0,
					0,0,0,0,0
			}),
			new Pattern("[", 2 , new int[] {
					1,1,
					1,0,
					1,0,
					1,0,
					1,0,
					1,0,
					1,0,
					1,0,
					1,1
			}),
			new Pattern("\\", 3 , new int[] {
					1,0,0,
					1,0,0,
					0,1,0,
					0,1,0,
					0,1,0,
					0,0,1,
					0,0,1,
					0,0,0,
					0,0,0
			}),
			new Pattern("]", 2 , new int[] {
					1,1,
					0,1,
					0,1,
					0,1,
					0,1,
					0,1,
					0,1,
					0,1,
					1,1
			}),
			new Pattern("^", 3 , new int[] {
					0,1,0,
					1,0,1,
					0,0,0,
					0,0,0,
					0,0,0,
					0,0,0,
					0,0,0,
					0,0,0,
					0,0,0
			}),
			new Pattern("_", 5, new int[] {
					0,0,0,0,0,
					0,0,0,0,0,
					0,0,0,0,0,
					0,0,0,0,0,
					0,0,0,0,0,
					0,0,0,0,0,
					0,0,0,0,0,
					0,0,0,0,0,
					1,1,1,1,1
			}),
			new Pattern("`", 2, new int[] {
					1,0,
					0,1,
					0,0,
					0,0,
					0,0,
					0,0,
					0,0,
					0,0,
					0,0
			}),
			new Pattern("a", 4, new int[] {
					0,0,0,0,
					0,0,0,0,
					0,1,1,0,
					0,0,0,1,
					0,1,1,1,
					1,0,0,1,
					0,1,1,1,
					0,0,0,0,
					0,0,0,0
			}),
			new Pattern("b", 4, new int[] {
					1,0,0,0,
					1,0,0,0,
					1,1,1,0,
					1,0,0,1,
					1,0,0,1,
					1,0,0,1,
					1,1,1,0,
					0,0,0,0,
					0,0,0,0
			}),
			new Pattern("c", 4 , new int[] {
					0,0,0,0,
					0,0,0,0,
					0,1,1,0,
					1,0,0,1,
					1,0,0,0,
					1,0,0,1,
					0,1,1,0,
					0,0,0,0,
					0,0,0,0
			}),
			new Pattern("d", 4, new int[] {
					0,0,0,1,
					0,0,0,1,
					0,1,1,1,
					1,0,0,1,
					1,0,0,1,
					1,0,0,1,
					0,1,1,1,
					0,0,0,0,
					0,0,0,0
			}),
			new Pattern("e", 4, new int[] {
					0,0,0,0,
					0,0,0,0,
					0,1,1,0,
					1,0,0,1,
					1,1,1,1,
					1,0,0,0,
					0,1,1,0,
					0,0,0,0,
					0,0,0,0
			}),
			new Pattern("f", 2, new int[] {
					0,1,
					1,0,
					1,0,
					1,1,
					1,0,
					1,0,
					1,0,
					0,0,
					0,0
			}),
			new Pattern("g", 4, new int[] {
					0,0,0,0,
					0,0,0,0,
					0,1,1,1,
					1,0,0,1,
					1,0,0,1,
					1,0,0,1,
					0,1,1,1,
					0,0,0,1,
					1,1,1,0
			}),
			new Pattern("h", 4, new int[] {
					1,0,0,0,
					1,0,0,0,
					1,0,1,0,
					1,1,0,1,
					1,0,0,1,
					1,0,0,1,
					1,0,0,1,
					0,0,0,0,
					0,0,0,0
			}),
			new Pattern("i", 1, new int[] {
					1,
					0,
					1,
					1,
					1,
					1,
					1,
					0,
					0
			}),
			new Pattern("j", 2, new int[] {
					0,1,
					0,0,
					0,1,
					0,1,
					0,1,
					0,1,
					0,1,
					0,1,
					1,0
			}),
			new Pattern("k", 4, new int[] {
					1,0,0,0,
					1,0,0,0,
					1,0,0,1,
					1,0,1,0,
					1,1,0,0,
					1,0,1,0,
					1,0,0,1,
					0,0,0,0,
					0,0,0,0
			}),
			new Pattern("l", 2, new int[] {
					1,0,
					1,0,
					1,0,
					1,0,
					1,0,
					1,0,
					0,1,
					0,0,
					0,0
			}),
			new Pattern("m", 7, new int[] {
					0,0,0,0,0,0,0,
					0,0,0,0,0,0,0,
					1,1,1,1,1,1,0,
					1,0,0,1,0,0,1,
					1,0,0,1,0,0,1,
					1,0,0,1,0,0,1,
					1,0,0,1,0,0,1,
					0,0,0,0,0,0,0,
					0,0,0,0,0,0,0
			}),
			new Pattern("n", 4, new int[] {
					0,0,0,0,
					0,0,0,0,
					1,1,1,0,
					1,0,0,1,
					1,0,0,1,
					1,0,0,1,
					1,0,0,1,
					0,0,0,0,
					0,0,0,0
			}),
			new Pattern("o", 5, new int[] {
					0,0,0,0,0,
					0,0,0,0,0,
					0,1,1,1,0,
					1,0,0,0,1,
					1,0,0,0,1,
					1,0,0,0,1,
					0,1,1,1,0,
					0,0,0,0,0,
					0,0,0,0,0
			}),
			new Pattern("p", 4, new int[] {
					0,0,0,0,
					0,0,0,0,
					1,1,1,0,
					1,0,0,1,
					1,0,0,1,
					1,0,0,1,
					1,1,1,0,
					1,0,0,0,
					1,0,0,0
			}),
			new Pattern("q", 4, new int[] {
					0,0,0,0,
					0,0,0,0,
					0,1,1,1,
					1,0,0,1,
					1,0,0,1,
					1,0,0,1,
					0,1,1,1,
					0,0,0,1,
					0,0,0,1
			}),
			new Pattern("r", 3, new int[] {
					0,0,0,
					0,0,0,
					1,1,0,
					1,0,1,
					1,0,0,
					1,0,0,
					1,0,0,
					0,0,0,
					0,0,0
			}),
			new Pattern("s", 4, new int[] {
					0,0,0,0,
					0,0,0,0,
					0,1,1,1,
					1,0,0,0,
					0,1,1,0,
					0,0,0,1,
					1,1,1,0,
					0,0,0,0,
					0,0,0,0
			}),
			new Pattern("t", 2, new int[] {
					0,0,
					1,0,
					1,1,
					1,0,
					1,0,
					1,0,
					0,1,
					0,0,
					0,0
			}),
			new Pattern("u", 4, new int[] {
					0,0,0,0,
					0,0,0,0,
					1,0,0,1,
					1,0,0,1,
					1,0,0,1,
					1,0,0,1,
					0,1,1,1,
					0,0,0,0,
					0,0,0,0
			}),
			new Pattern("v", 4, new int[] {
					0,0,0,0,
					0,0,0,0,
					1,0,0,1,
					1,0,0,1,
					1,0,0,1,
					0,1,1,0,
					0,1,1,0,
					0,0,0,0,
					0,0,0,0
			}),
			new Pattern("w", 5, new int[] {
					0,0,0,0,0,
					0,0,0,0,0,
					1,0,0,0,1,
					1,0,1,0,1,
					1,0,1,0,1,
					0,1,0,1,0,
					0,1,0,1,0,
					0,0,0,0,0,
					0,0,0,0,0
			}),
			new Pattern("x", 3, new int[] {
					0,0,0,
					0,0,0,
					1,0,1,
					1,0,1,
					0,1,0,
					1,0,1,
					1,0,1,
					0,0,0,
					0,0,0
			}),
			new Pattern("y", 4, new int[] {
					0,0,0,0,
					0,0,0,0,
					1,0,0,1,
					1,0,0,1,
					1,0,0,1,
					1,0,0,1,
					0,1,1,1,
					0,0,0,1,
					1,1,1,0
			}),
			new Pattern("z", 3, new int[] {
					0,0,0,
					0,0,0,
					1,1,1,
					0,0,1,
					0,1,0,
					1,0,0,
					1,1,1,
					0,0,0,
					0,0,0
			}),
			new Pattern("{", 3, new int[] {
					0,0,1,
					0,1,0,
					0,1,0,
					0,1,0,
					1,0,0,
					0,1,0,
					0,1,0,
					0,1,0,
					0,0,1
			}),
			new Pattern("|", 1, new int[] {
					1,
					1,
					1,
					1,
					1,
					1,
					1,
					0,
					0
			}),
			new Pattern("}", 3, new int[] {
					1,0,0,
					0,1,0,
					0,1,0,
					0,1,0,
					0,0,1,
					0,1,0,
					0,1,0,
					0,1,0,
					1,0,0
			}),
			new Pattern("~", 4, new int[] {
					0,1,0,1,
					1,0,1,0,
					0,0,0,0,
					0,0,0,0,
					0,0,0,0,
					0,0,0,0,
					0,0,0,0,
					0,0,0,0,
					0,0,0,0
			})
	};
	private static final IPattern BAD_CHAR = new Pattern("???", 6, new int[] {
			1,1,1,1,1,1,
			1,0,0,0,0,1,
			1,0,0,0,0,1,
			1,0,0,0,0,1,
			1,0,0,0,0,1,
			1,0,0,0,0,1,
			1,0,0,0,0,1,
			1,1,1,1,1,1,
			0,0,0,0,0,0
	});

	public static IPattern stringToPattern(String str) {
		List<IPattern> charPatterns = new ArrayList<>();
		int totalWidth = str.length() - 1;
		IPattern addCharPattern;
		for (int c = 0; c < str.length();) {
			int cp = str.codePointAt(c);
			if (cp >= 32 && (cp - 32) < ASCII_PATTERNS.length) {
				addCharPattern = ASCII_PATTERNS[cp - 32];
			} else {
				addCharPattern = BAD_CHAR;
			}
			charPatterns.add(addCharPattern);
			totalWidth += addCharPattern.columns();
			c += Character.charCount(cp);
		}
		int[] bitPattern = new int[totalWidth * CHAR_HEIGHT];
		int startColumn = 0;
		for (IPattern pattern: charPatterns) {
			for (int row = 0; row < CHAR_HEIGHT; row++) {
				for (int column = 0; column < pattern.columns(); column++) {
					if (pattern.cell(row, column).isAlive()) {
						bitPattern[(row * totalWidth) + column + startColumn] = 1;
					}
				}
			}
			startColumn += (1 + pattern.columns());
		}
		return new Pattern(str, totalWidth, bitPattern);
	}

	public static IPattern patternForChar(char ch) {
		if (ch >= 32 && (ch - 32) < ASCII_PATTERNS.length) {
			return ASCII_PATTERNS[ch - 32];
		}
		return null;
	}
}
