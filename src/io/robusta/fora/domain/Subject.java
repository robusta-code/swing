package io.robusta.fora.domain;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Subject implements Serializable, Flagable {

	private static final long serialVersionUID = 8551283529065516442L;

	
	long id;
	String title;
	String content;	
	List<Comment> comments = new ArrayList<Comment>();
	List<Flag> flags = new ArrayList<Flag>();
	User user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	// Using id and title
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Subject other = (Subject) obj;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public boolean isFlagged() {

		return this.flags != null && !this.flags.isEmpty();
	}

	@Override
	public List<Flag> getFlags() {
		return this.flags;
	}

	public void setFlags(List<Flag> flags) {
		this.flags = flags;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private void writeObject(java.io.ObjectOutputStream stream)
			throws IOException {
		System.out.println(">>>> Making serialization");
		stream.writeLong(id);
		stream.writeObject(content);
		stream.writeObject(title);

	}

	private void readObject(java.io.ObjectInputStream stream)
			throws IOException, ClassNotFoundException {
		System.out.println(">>>> Unserialization");
		id = stream.readLong();
		content = (String) stream.readObject();
		title = (String) stream.readObject();
	}

}
