package base;

import java.util.Date;

public class FriendsPost extends Post {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return friend + "\n" + super.toString();
	}

	public FriendsPost(Date date, String content, User user) {
		super(date, content);
		this.friend = user;
		
		
		// TODO Auto-generated constructor stub
	}

	private User friend;
}
