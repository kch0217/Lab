package base;

import java.util.Comparator;

public class PostSortByContentLength implements Comparator<Post> {

	@Override
	public int compare(Post o1, Post o2) {
		// TODO Auto-generated method stub
		if (o1.getContent().length() > o2.getContent().length())
			return 1;
		else if (o1.getContent().length() == o2.getContent().length())
			return 0;
		else
			return -1;
	}

}
