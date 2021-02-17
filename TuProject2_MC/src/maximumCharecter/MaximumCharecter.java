package maximumCharecter;

import java.util.HashMap;
import java.util.Scanner;

public class MaximumCharecter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String");
		String inputString = sc.nextLine();
		char[] inputStringArray = inputString.replace(" ", "").toCharArray();
		System.out.println("Enter the char to find maximum distance between two similer chars");
		char inputChar = sc.next().charAt(0);

		int maxDistanceValue = maxDistance(inputStringArray, inputChar);
		System.out.println("maximum distance between '"+inputChar+"' : "+ maxDistanceValue);

	}

	private static int maxDistance(char[] inputStringArray, char inputChar) {
		HashMap<Character, Integer> map = new HashMap<>();
		int max_dist = 0;
		for (int i = 0; i < inputStringArray.length; i++) {
			if (inputStringArray[i] == inputChar) {
				// If this is first occurrence of element, insert its
				// index in map
				if (!map.containsKey(inputStringArray[i])) {
					map.put(inputStringArray[i], i);
				}

				// Else update max distance
				else {
					max_dist = Math.max(max_dist, i - map.get(inputStringArray[i]));
					map.put(inputStringArray[i], i);
				}
			}
		}

		if(max_dist == 0) {
			return -1;
		} else {
			return max_dist;
		}
	}

}

