import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Mandelbrot {
	private Plan plan;
	private int maxIter;
	
	public Mandelbrot(Plan plan) {
		this.plan = plan;
	}
	
	public void printMandelbrot(PrintStream out) {
		for (int j = 0; j < plan.getPixelHeight(); ++j) {
			for (int i = 0; i < plan.getPixelWidth(); ++i) {
				Imaginary c = plan.pointAt(i, j);
				if (belongToMandelbrot(c)) {
					out.print('*');
				} else {
					out.print('.');
				}
			}
			out.println();
		}
	}
	
	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	
	public void setMaxIter(int maxIter) {
		this.maxIter = maxIter;
	}
	
	public boolean belongToMandelbrot(Imaginary c) {
		Imaginary z = new Imaginary(0.0, 0.0);
		for (int iter = 0; iter < this.maxIter; ++iter) {
			if (z.squaredMod() >= 4.0) {
				return false;
			}
			
			z = (z.mul(z)).add(c);
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean running = true;
		Mandelbrot m = new Mandelbrot(new Plan(30, 20, -2, -1, 3, 2));
		m.setMaxIter(200);
		
		while (running) {
			System.out.print("> ");
			String[] input = s.nextLine().split(" ");
			System.out.println();
			if (input.length < 1) {
				continue;
			} else {
				if (input[0].equals("quit") || input[0].equals("exit")) {
					running = false;
				} else if (input[0].equals("plan")) {
					if (input.length == 7) {
						Plan plan = new Plan();
						plan.setPixelWidth(Integer.parseInt(input[1]));
						plan.setPixelHeight(Integer.parseInt(input[2]));
						plan.setLeft(Double.parseDouble(input[3]));
						plan.setUp(Double.parseDouble(input[4]));
						plan.setWidth(Double.parseDouble(input[5]));
						plan.setHeight(Double.parseDouble(input[6]));
						m.setPlan(plan);
					}
				} else if (input[0].equals("iter")) {
					if (input.length == 2) {
						m.setMaxIter(Integer.parseInt(input[1]));
					}
				} else if (input[0].equals("print")) {
					m.printMandelbrot(System.out);
				} else if (input[0].equals("file")) {
					if (input.length == 2) {
						File file = new File(input[1]);
						try {
							file.createNewFile();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						try {
							FileOutputStream fos = new FileOutputStream(file);
							m.printMandelbrot(new PrintStream(fos));
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
}
