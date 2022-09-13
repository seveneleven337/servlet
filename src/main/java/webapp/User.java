package webapp;

public class User {

	private String name, message, calendar;
	private String[] sports, views;

	public User(String name, String message, String calendar, String[] sports, String[] views) {
		this.setName(name);
		this.setMessage(message);
		this.setCalendar(calendar);
		this.setSports(sports);
		this.setViews(views);
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

	public String[] getSports() {
		return sports;
	}

	public void setSports(String[] sports) {
		this.sports = sports;
	}

	public String[] getViews() {
		return views;
	}

	public void setViews(String[] views) {
		this.views = views;
	}

}
