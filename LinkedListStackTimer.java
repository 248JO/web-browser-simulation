package assign06;

import java.text.DecimalFormat;
import java.util.Random;
import assign04.Timer1;
import lab02.TimerTemplate;

public class LinkedListStackTimer extends TimerTemplate {
	Random rng;
	private LinkedListStack<Integer> test;
	private final static int TIMES_TO_LOOP = 10000;
	private final static int NSTART = 500000;
	private final static int NINCREMENT = 5000;
	private final static int NSTEPS = 18;

	public LinkedListStackTimer(int[] problemSizes, int timesToLoop) {
		super(problemSizes, timesToLoop);
		rng = new Random(33);
	}

	protected void setup(int n) {
		test = new LinkedListStack<Integer>();
		int size = n;
		for (int i = 0; i < size; i++) {
			test.push(i);
		}
	}

	protected void timingIteration(int n) {
		test.push(5);
//		test.pop();
//		test.peek();

	}

	protected void compensationIteration(int n) {

	}

	public static void main(String[] args) {
//		
//		DecimalFormat formatter = new DecimalFormat("00000E00");
//
//		System.out.println("\nN\t|  T(N)/1\tT(N)/logN\tT(N)/N\t\tT(N)/N^2");
//		System.out.println("-----------------------------------------------------------------------------------");
//		
//		int[] problemSizes = new int[NSTEPS];
//		problemSizes[0] = NSTART;
//		for(int i = 1; i < NSTEPS; i++)
//			problemSizes[i] = problemSizes[i - 1] + NINCREMENT;
//		
//		LinkedListStackTimer checker = new LinkedListStackTimer(problemSizes, TIMES_TO_LOOP);
//		var results = checker.run();
//		
//		for(var result : results) {
//			int N = result.n();
//			double time = result.avgNanoSecs();
//			System.out.print(N + "\t|  ");
//			
//			System.out.println(formatter.format(time) + "\t" + 
//					formatter.format(time / (Math.log10(N) / Math.log10(2))) + "\t" + 
//					formatter.format(time / N) + "\t" + 
//					formatter.format((time / N) / N));
//		}

		int timesToLoop = 10000;
		int problemSizes[] = { 500000, 600000, 700000, 800000, 900000, 1000000, 1100000, 1200000, 1300000, 1400000,
				1500000, 1600000, 1700000, 1800000, 1900000, 2000000 };
		LinkedListStackTimer timer = new LinkedListStackTimer(problemSizes, timesToLoop);

		var results = timer.run();
		System.out.println("n, time");
		for (var result : results) {
			System.out.println(result.avgNanoSecs());
		}

	}
}
