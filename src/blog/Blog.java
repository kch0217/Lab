package blog;

import java.util.ArrayList;

import base.Post;
import base.User;

public class Blog {
	private User user;
	private ArrayList<Post> allPosts;
	
	
	
	public Blog(User user) {
		super();
		this.user = user;
		allPosts = new ArrayList<Post>();
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}
	
	public void post(Post p){
		allPosts.add(p);
		System.out.println("A new Post:");
		System.out.println(p);
	}
	
	public void list(){
		System.out.println("Current posts:");
		if (allPosts != null && allPosts.size() > 0){
			for (int i = 0; i< allPosts.size(); i++){
				
				System.out.println("Post[" + (i+1) + "]:" + allPosts.get(i));
			}
		}
		else
		{
			System.out.println("No posts!");
		}
	}
	
	public void delete(int index){
		index--;
		if (index < 0 || index >= allPosts.size() ){
			System.out.println("Illegal deletion.");
		}
		else
		{
			allPosts.remove(index);
		}
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((allPosts == null) ? 0 : allPosts.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Blog)) {
			return false;
		}
		Blog other = (Blog) obj;
		if (allPosts == null) {
			if (other.allPosts != null) {
				return false;
			}
		} else if (!allPosts.equals(other.allPosts)) {
			return false;
		}
		if (user == null) {
			if (other.user != null) {
				return false;
			}
		} else if (!user.equals(other.user)) {
			return false;
		}
		return true;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
