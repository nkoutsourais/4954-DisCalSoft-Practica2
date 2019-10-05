package mastermind.models;

import java.util.List;
import java.util.ArrayList;

abstract class Combination {

	private static final int WIDTH = 4;

	protected List<Color> colors;

	protected Combination() {
		this.colors = new ArrayList<Color>();
	}

	public static int getWidth() {
		return Combination.WIDTH;
	}

	public Color[] getColors() {
		Color[] arrayColors = new Color[WIDTH];
		return this.colors.toArray(arrayColors);
	}
}