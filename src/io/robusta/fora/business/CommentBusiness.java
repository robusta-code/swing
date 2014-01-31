package io.robusta.fora.business;

import io.robusta.fora.ForaDataSource;
import io.robusta.fora.domain.Comment;
import io.robusta.fora.domain.Subject;
import io.robusta.fora.domain.User;

public class CommentBusiness {

	ForaDataSource fora = ForaDataSource.getInstance();

	public Comment getCommentById(String id) {

		synchronized (fora) {
			for (Comment c : fora.getComments()) {
				if (c.getId().equals(id)) {
					return c;
				}
			}
		}

		return null;// or throw exception

	}

	public Comment createComment(Subject s, String content, User u,
			boolean anonymous) {
		Comment c = new Comment();
		c.setAnonymous(anonymous);
		if (!anonymous) {
			c.setUser(u);
		}
		c.setContent(content);
		s.getComments().add(c);
		synchronized (fora) {
			fora.getComments().add(c);
		}
		return c;
	}
}
