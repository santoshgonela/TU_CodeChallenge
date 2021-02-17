package jackSparrowProblem;

import java.util.Scanner;

public class JackSparrowProblem {

	static int climbUp = 0;
	static int climbDown = 0;
	static int noOfWalls = 0;
	static int[] wallHeights = null;

	public static void main(String arg[]) {

		// Range of cliambUp in meters should be 1 to 104
		boolean climbUpValueInExceedRange = true;

		// Range of climbDown in meters should be 1 to 104
		boolean climbDownValueInExceedRange = true;

		// Range of noOfWalls in meters should be 1 to 104
		boolean noOfWallsValueInExceedRange = true;

		// Range of wallHeight in meters should be 1 to 1000
		boolean wallHeightValueInExceedRange = true;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter climbUp value in meters");
		climbUp = sc.nextInt();
		if (climbUp < 1 || climbUp > 104) {
			while (climbUpValueInExceedRange) {
				System.out.println("climbUp value should not be < 1 and > 104");
				System.out.println("Enter climbUp value in meters");
				climbUp = sc.nextInt();
				if (climbUp >= 1 || climbUp <= 104) {
					climbUpValueInExceedRange = false;
				}
			}
		}
		System.out.println("Enter climbDown value in meters");
		climbDown = sc.nextInt();
		if (climbDown < 1 || climbDown >= climbUp) {
			while (climbDownValueInExceedRange) {
				System.out.println("climbDown value should not be < 1 and > 104 and shold be < ClimbUp value");
				System.out.println("Enter climbDown value in meters");
				climbDown = sc.nextInt();
				if (climbDown >= 1 && climbDown < climbUp) {
					climbDownValueInExceedRange = false;
				}
			}
		}
		System.out.println("Enter noOfWalls, he need to jump to escape");
		noOfWalls = sc.nextInt();
		if (noOfWalls < 1 || noOfWalls > 104) {
			while (noOfWallsValueInExceedRange) {
				System.out.println("noOfWalls value should not be < 1 and > 104");
				System.out.println("Enter noOfWalls, he need to jump to escape");
				noOfWalls = sc.nextInt();
				if (noOfWalls >= 1 || noOfWalls <= 104) {
					noOfWallsValueInExceedRange = false;
				}
			}
		}

		wallHeights = new int[noOfWalls];
		for (int i = 0; i < noOfWalls; i++) {
			wallHeightValueInExceedRange = true;
			System.out.println("Enter wallHeights of wall->" + (i + 1));
			wallHeights[i] = sc.nextInt();
			if (climbUp < 1 || climbUp > 1000) {
				while (wallHeightValueInExceedRange) {
					System.out.println("noOfWalls value should not be < 1 and > 1000");
					System.out.println("Enter wallHeights of wall->" + (i + 1));
					wallHeights[i] = sc.nextInt();
					if (wallHeights[i] >= 1 || wallHeights[i] <= 1000) {
						wallHeightValueInExceedRange = false;
					}
				}
			}
		}

		int numberOFJumps = calculateNumberOfJumps(climbUp, climbDown, noOfWalls, wallHeights);
		
		System.out.println("Number of jumps to escape is --> "+numberOFJumps);

	}

	private static int calculateNumberOfJumps(int climbUp, int climbDown, int noOfWalls, int[] wallHeights2) {
		int jumps = 0;

		for (int i = 0; i < noOfWalls; i++) {
			if (wallHeights2[i] <= climbUp) {
				jumps++;
				continue;
			}

			/*
			 * If height of wall is greater than up move
			 */
			int h = wallHeights2[i];
			while (h > climbUp) {
				jumps++;
				h = h - (climbUp - climbDown);
			}
			jumps++;
		}
		return jumps;
	}

}
