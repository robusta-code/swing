package io.robusta.fora.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Comment implements Serializable, Flagable {

	
	private static final long serialVersionUID = -1622931234744081145L;


	String id;
	
	String content;

	User user = null;
	boolean anonymous = true;
	List<Flag>flags = new ArrayList<Flag>();
	
	int score;
	
	
	public Comment() {
		this.id = UUID.randomUUID().toString();
	}
	public Comment(String email, String content) {
		User user = new User();
		user.setEmail(email);
		user.setId(new Random().nextLong());
		this.id = UUID.randomUUID().toString();
		this.content = content;
	}
	
	
	//@XmlTransient
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
		this.anonymous = (user == null);
		
	}


	public boolean isAnonymous() {
		return anonymous;
	}


	public void setAnonymous(boolean anonymous) {
		this.anonymous = anonymous;
	}

	
	/*public List<Comment> getComments() {
		return comments;
	}*/
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}


	@Override
	public boolean isFlagged() {
		return this.flags == null || this.flags.isEmpty();
	}


	@Override
	public List<Flag> getFlags() {
		return this.flags;
	}
	
	public void setFlags(List<Flag> flags) {
		this.flags = flags;
	}
	
	@Override
	public String toString() {
		if (user != null){
			return this.user+" said :"+ this.content;
		}else{
			return "Anonymous said :"+ this.content;
		}
		
	}
	
}
