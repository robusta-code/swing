package io.robusta.fora.swing;

import javax.swing.JOptionPane;

import io.robusta.fora.ForaDataSource;
import io.robusta.fora.annotations.Controller;
import io.robusta.fora.domain.Comment;
import io.robusta.fora.domain.Flag;

@Controller
public class CommentController {

	Comment model;
	CommentView view;

	public CommentController(Comment model, CommentView view) {
		this.model = model;
		this.view = view;
	}

	public int like() {
		this.model.setScore(this.model.getScore() + 1);
		return this.model.getScore();
	}

	public int dislike() {
		this.model.setScore(this.model.getScore() - 1);
		return this.model.getScore();
	}

	public void flag() {
		String raison = JOptionPane.showInputDialog(null,
				"Pourquoi souhaitez-vous flaguer ce commentaire ?",
				"Confirmation", JOptionPane.QUESTION_MESSAGE);
		if (raison != null) {
			Flag flag = new Flag();
			flag.setComment(model);
			flag.setContent(raison);
			model.getFlags().add(flag);
			ForaDataSource.getInstance().getFlags().add(flag);
		}
	}

}
