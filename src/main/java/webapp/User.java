package webapp;

public class User {

	private String name, message, calendar;

	public User(String name, String message, String calendar) {
		this.setName(name);
		this.setMessage(message);
		this.setCalendar(calendar);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCalendar() {
		return calendar;
	}

	public void setCalendar(String calendar) {
		this.calendar = calendar;
	}

}
