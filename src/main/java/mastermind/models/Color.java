package mastermind.models;

public enum Color {
	RED('r'), 
	BLUE('b'), 
	YELLOW('y'), 
	GREEN('g'), 
	ORANGE('o'), 
	PURPLE('p');

	private char initial;

	private Color(char initial) {
		this.initial = initial;
	}

	public char getInitial() {
		return this.initial;
	}

	public static String allInitials() {
		String result = "";
		for(Color color: Color.values()) {
			result += color.initial;
		}
		return result;
	}

	public static Color getInstance(int code) {
		assert 0 <= code && code < Color.length();
		return Color.values()[code];
	}

	public static Color getInstance(char character) {
		for (Color color : Color.values()) {
			if (color.initial == character) {
				return color;
			}
		}
		return null;
	}

	public static int length() {
		return Color.values().length;
	}
}