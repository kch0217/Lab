package blog;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import base.Post;
import base.User;

public class Blog implements Serializable{
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
	
	public ArrayList<Post> getAllPost(){
		return allPosts;
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


	public void setPosts(ArrayList<Post> listP){
		allPosts = listP;
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	/**
	 * Search posts created in month and mentioned someone
	 * 
	 * @param month
	 * @param someone
	 */
	public void search(int month, String someone){
		Calendar cal = Calendar.getInstance();
		//search from all posts
		for(Post p: allPosts){
			//get the current post's month (note that Calendar.Month starts with 0, not 1)
			cal.setTime(p.getDate());
			int postMonth = cal.get(Calendar.MONTH);
			
			if (postMonth+1 == month && p.contains(someone)){
				System.out.println(p);
			}
		}
	}
	
	public void save(String filepath){
		try{
			FileOutputStream out = new FileOutputStream(filepath);
			ObjectOutputStream objout = new ObjectOutputStream(out);
			objout.writeObject(this);
			objout.close();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void load(String filepath){
		try{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filepath));
			Blog temp = (Blog) in.readObject();
			this.user = temp.user;
			this.allPosts = temp.allPosts;
			in.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Wait! There is something wrong. I cannot find the file..");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Wait! There is something wrong. I cannot find the file..");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Wait! There is something wrong. I cannot find the file..");
		}
	}
}
