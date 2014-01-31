package io.robusta.fora;


import io.robusta.fora.domain.Comment;
import io.robusta.fora.domain.Flag;
import io.robusta.fora.domain.Subject;
import io.robusta.fora.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;


public class ForaDataSource {
	
	public static final String NOT_OK = UUID.randomUUID().toString();
	public static final long PIRELLI_ID = 1L;
	public static final String You_dont_know_enough = UUID.randomUUID().toString();
	protected static ForaDataSource instance;
	
	List<User> users = new ArrayList<User>();
	List<Subject> subjects = new ArrayList<Subject>();
	List<Comment> comments = new ArrayList<Comment>();
	List<Flag> flags = new ArrayList<Flag>();
	Subject pirelli;
	
	private ForaDataSource(){		
		
		initUsers();
		initSubjects();

		//fillMany(24);
		
	}
	
	protected ForaDataSource (boolean create){
		ForaDataSource instance = getInstance();
		if (create){
			this.subjects = instance.subjects;
			this.comments = instance.comments;
			this.users = instance.users;
			this.flags = instance.flags;
			this.pirelli= instance.pirelli;
		}
		
		
		
	}
	
	public static ForaDataSource getInstance(){
		if (instance == null){
			instance = new ForaDataSource();			
		}
		return instance;
	}

	
	private void initUsers(){
		User nicolas = new User();
		nicolas.setId(1L);
		nicolas.setEmail("nz@robusta.io");
		nicolas.setFirstname("Nicolas");
		nicolas.setLastname("Zozol");

		User jo = new User();
		jo.setId(2L);
		jo.setEmail("jo@robusta.io");
		
		Collections.addAll(this.users, nicolas, jo);
	}
	
	
	private void initSubjects(){
		pirelli = new Subject();
		pirelli.setId(PIRELLI_ID);
		pirelli.setTitle("Pirelli or Michelin ?");
		pirelli.setContent("*Pirelli* is better than Michelin");

		Subject kids = new Subject();
		kids.setId(2L);
		kids.setTitle("Kids ar' cool");
		kids.setContent("But I'm so <strong>tired</strong> <script type='text/javascript'>alert('you're fired!')</script>");

		// Usually, we would like to make business stuff with a addComment
		// method
		pirelli.setComments(this.getAndInitPirelliComments());

		this.subjects.add(pirelli);
		this.subjects.add(kids);
	}

	public List<User> getUsers(){		
		return this.users;
	}
	
	public User nicolas(){
		return this.getUsers().get(0);
	}
	
	public User jo(){
		return this.getUsers().get(1);
	}
	
	public List<Subject> getSubjects() {
		return this.subjects;
	}
	
	public List<Comment> getComments() {
		
		return this.comments;
	}
	
	
	
	private List<Comment> getAndInitPirelliComments(){
		
		Comment c1 = new Comment();
		c1.setId(NOT_OK);
		c1.setAnonymous(true);
		c1.setContent("I'm not ok");

		Comment c2 = new Comment();
		c2.setId(You_dont_know_enough);
		c2.setUser(jo());
		c2.setContent("You don't know enough about tires");

		Comment c3 = new Comment();
		c3.setId(UUID.randomUUID().toString());
		c3.setAnonymous(true);
		c3.setContent("What ? You stupid !");
		
		Flag flag = new Flag();
		flag.setId(1L);
		flag.setContent("This guy went too far.");
		c3.getFlags().add(flag);
		flags.add(flag);
		
		List<Comment>result = new ArrayList<Comment>();		
		Collections.addAll(result, c1, c2, c3);
		this.comments.addAll(result);
		return result; 
	}
	
	public List<Comment> getPirelliComments() {
		return pirelli.getComments();
	}

	public List<Flag> getFlags() {
		return flags;
	}


	
	public int getTotalCommentsCount(){
		int count = 0;
		for (Subject s : this.getSubjects()){
			count+=s.getComments().size();
		}
		return count;
	}
	
	
	public void fillMany(int size) {
		// int size = 24;
		int userSize = size;
		int subjectSize = userSize * 3;
		int commentSize = userSize * 12;
		int flagSize = userSize;

		for (int i = 0; i < userSize; i++) {
			User u = new User();
			u.setEmail("user" + i + "@fora.com");
			u.setFirstname("John");
			u.setLastname("Doe-" + i);
			users.add(u);
		}

		for (int i = 0; i < subjectSize; i++) {
			Subject s = new Subject();
			s.setContent("Some content " + i);
			s.setTitle("Title " + i);
			User u = getRandomItem(User.class, users);			
			s.setUser(u);
			subjects.add(s);
		}

		for (int i = 0; i < commentSize; i++) {
			Comment c = new Comment();
			c.setUser(getRandomItem(User.class, users));
			c.setContent("My comment says " + i);
			Subject s = getRandomItem(Subject.class, subjects);
			s.getComments().add(c);
			comments.add(c);
		}

		for (int i = 0; i < flagSize; i++) {
			Flag flag = new Flag();
			Comment c = getRandomItem(Comment.class, comments);
			flag.setContent("This is a flag for `" + c.getContent()+"`");
			c.getFlags().add(flag);
			flags.add(flag);
		}

	}

	public <T> T getRandomItem(Class<T> clazz, List<T> list) {

		int length = list.size();

		try {
			int index = new Random().nextInt(length);
			return list.get(index);
		} catch (RuntimeException e) {
			System.out.println("length is " + length);
			throw e;
		}

	}


}
