package webapp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DataBase {

	private ArrayList<User> users = new ArrayList<>();

	public DataBase() {
	}

	public void addNewUser(String userName, String message) {
		Date dat = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm");
		String date = dateFormat.format(dat);
		User temp = new User(userName, message, date);
		users.add(temp);
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public ArrayList<User> search(String name, String message, String date) {
		ArrayList<User> temp = new ArrayList<>();
		for (User user : users) {
			if (user.getName().equals(name) && !name.isEmpty() && name != null) {
				temp.add(user);
			} else if (user.getMessage().contains(message) && !message.isEmpty() && message != null) {
				temp.add(user);
			} else if (user.getCalendar().contains(date) && !date.isEmpty() && date != null) {
				temp.add(user);
			}
		}
		return temp;
	}
	
}
