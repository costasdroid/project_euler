package problem054;

import java.util.ArrayList;

public class Hand {

	// The string identifying the hand
	String hand;

	/*
	 * the category which the hand falls 0 High Card: Highest value card. 1 One
	 * Pair: Two cards of the same value. 2 Two Pairs: Two different pairs. 3
	 * Three of a Kind: Three cards of the same value. 4 Straight: All cards are
	 * consecutive values. 5 Flush: All cards of the same suit. 6 Full House:
	 * Three of a kind and a pair. 7 Four of a Kind: Four cards of the same
	 * value. 8 Straight Flush: All cards are consecutive values of same suit. 9
	 * Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.
	 */
	int category;

	// make value of each card
	ArrayList<Integer> handNumbers = new ArrayList<Integer>();

	// create shapes
	ArrayList<Character> handShapes = new ArrayList<Character>();

	// create highest cards
	ArrayList<Integer> highest = new ArrayList<Integer>();

	public Hand(String hand) {
		this.hand = hand;

		// populate ArrayLists
		form();

		// categorize
		category = getCategory();
	}

	void form() {
		for (int i = 0; i < 5; i++) {
			switch (hand.charAt(3 * i)) {
			case 'T':
				handNumbers.add(10);
				break;
			case 'J':
				handNumbers.add(11);
				break;
			case 'Q':
				handNumbers.add(12);
				break;
			case 'K':
				handNumbers.add(13);
				break;
			case 'A':
				handNumbers.add(14);
				break;
			default:
				handNumbers.add((int) hand.charAt(3 * i) - 48);
				break;
			}
			handShapes.add(hand.charAt(3 * i + 1));
		}
	}

	int getCategory() {

		// flush royal
		{
			boolean b;
			b = handNumbers.contains(10) && handNumbers.contains(11)
					&& handNumbers.contains(12) && handNumbers.contains(13)
					&& handNumbers.contains(14);
			char c = handShapes.get(0);
			b = b && handShapes.get(1) == c && handShapes.get(2) == c
					&& handShapes.get(3) == c && handShapes.get(4) == c;
			if (b)
				return 9;
		}

		// Straight Flush
		{
			boolean b;
			b = false;
			char c = handShapes.get(0);
			for (int i = 14; i >= 5; i--) {
				boolean temp = true;
				for (int j = i - 4; j <= i; j++) {
					if (j == 0)
						temp = temp && handNumbers.contains(14);
					else
						temp = temp && handNumbers.contains(j);
					temp = temp && handShapes.get(j - i + 4) == c;
				}
				if (temp)
					highest.add(i);
				b = b || temp;
			}
			if (b)
				return 8;
		}

		// Four cards of the same value
		{
			for (int i = 2; i <= 14; i++) {
				int count = 0;
				for (int j : handNumbers) {
					if (j == i)
						count++;
				}
				if (count == 4) {
					highest.add(i);
					return 7;
				}
			}
		}

		// full
		{
			int i1 = handNumbers.get(0);
			int count1 = 0;
			int i2 = i1;
			int count2 = 0;
			for (int i : handNumbers)
				if (i != i1) {
					i2 = i;
					count2 = 0;
				}
			for (int i : handNumbers) {
				if (i == i1) {
					count1++;
				}
				if (i == i2) {
					count2++;
				}
			}
			if ((count1 == 3 && count2 == 2) || (count1 == 2 && count2 == 3)) {
				highest.add(i1);
				return 6;
			}
		}

		// flush
		{
			boolean b;
			char c = handShapes.get(0);
			b = true;
			for (int i : handShapes) {
				b = b && i == c;
			}
			if (b) {
				int[] sort = new int[15];
				for (int i : handNumbers)
					sort[i] = 1;
				for (int i = 14; i > 0; i--) {
					if (sort[i] == 1)
						highest.add(i);
				}
				return 5;
			}
		}

		// Straight
		{
			boolean b;
			b = false;
			for (int i = 14; i >= 5; i--) {
				boolean temp = true;
				for (int j = i - 4; j <= i; j++) {
					if (j == 0)
						temp = temp && handNumbers.contains(14);
					else
						temp = temp && handNumbers.contains(j);
				}
				if (temp)
					highest.add(i);
				b = b || temp;
			}
			if (b)
				return 4;
		}

		// Three cards of the same value
		for (int i = 2; i <= 14; i++) {
			int count = 0;
			for (int j : handNumbers) {
				if (j == i)
					count++;
			}
			if (count == 3) {
				highest.add(i);
				return 3;
			}
		}

		// Two pairs
		{
			int count1 = 0;
			int pair1 = handNumbers.get(0);
			for (int i : handNumbers) {
				count1 = 0;
				for (int j : handNumbers) {
					if (j == i)
						count1++;
					if (count1 == 2) {
						pair1 = j;
						break;
					}
				}
				if (count1 == 2)
					break;
			}
			if (count1 == 2) {
				int count2;
				for (int i : handNumbers) {
					if (i == pair1)
						continue;
					count2 = 0;
					for (int j : handNumbers) {
						if (j == i && i != pair1) {
							count2++;
						}
						if (count2 == 2) {
							if (pair1 > j) {
								highest.add(pair1);
								highest.add(j);
							} else {
								highest.add(j);
								highest.add(pair1);
							}

							return 2;
						}
					}
				}
			}
		}

		// One pair
		{
			int count;
			for (int i : handNumbers) {
				count = 0;
				for (int j : handNumbers) {
					if (j == i)
						count++;
				}
				if (count == 2) {
					highest.add(i);
					int[] sort = new int[15];
					for (int j : handNumbers)
						sort[j] = 1;
					for (int j = 14; j > 0; j--) {
						if (sort[j] == 1 && j != i)
							highest.add(j);
					}
					return 1;
				}
			}
		}

		int[] sort = new int[15];
		for (int i : handNumbers)
			sort[i] = 1;
		for (int i = 14; i > 0; i--) {
			if (sort[i] == 1)
				highest.add(i);
		}
		return 0;
	}

}
