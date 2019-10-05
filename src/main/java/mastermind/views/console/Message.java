package mastermind.views.console;

enum Message {

	ATTEMPTS("#attempts attempt(s): "), 
	SECRET("*"), 
	RESUME("Do you want to continue"), 
	RESULT(" --> #blacks blacks and #whites whites"), 
	PROPOSED_COMBINATION("Propose a combination: "), 
	TITLE("----- MASTERMIND -----"), 
	WINNER("You've won!!! ;-)"), 
	LOOSER("You've lost!!! :-("),
	NEW_LINE("\n");

	private String message;
	
	private Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}