package io.robusta.fora.swing;

import java.util.List;

import io.robusta.fora.ForaDataSource;
import io.robusta.fora.domain.Comment;
import io.robusta.fora.domain.Subject;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ListModel;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class SubjectView extends JPanel {

	Subject model;
	SubjectController controller;
	

	public SubjectView(Subject model) {
		super();
		this.model = model;
		initView();
	}

	JPanel commentsPanel;
	JLabel numberLabel;
	private void initView() {

		// R�cup�ration du sujet pirelli

		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		// affichage du sujet
		JLabel label = new JLabel(model.getTitle());
		panel.add(label, BorderLayout.WEST);
		
		numberLabel = new JLabel(this.model.getComments().size()+ " comments");
		panel.add(numberLabel, BorderLayout.EAST);

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		 commentsPanel = new JPanel();
		scrollPane.setViewportView(commentsPanel);
		commentsPanel.setLayout(new BoxLayout(commentsPanel, BoxLayout.Y_AXIS));

		// affichage des commentaires
		List<Comment> comments = model.getComments();
		for (Comment comment : comments) {
			CommentView commentView = createCommentView(comment);
			commentsPanel.add(commentView);
		}

	}

	private CommentView createCommentView(Comment comment) {

		CommentView commentView = new CommentView(comment);
		CommentController controller = new CommentController(comment,
				commentView);
		commentView.setController(controller);
		return commentView;
	}

	
	void updateNumberLabel(){
		numberLabel.setText(this.model.getComments().size()+ " comments");
	}
	
	
	

	public void addComment(Comment comment) {

		CommentView commentView = createCommentView(comment);
		
		commentsPanel.add(commentView);
		commentsPanel.validate();
		updateNumberLabel();
		

	}

	/**
	 * Create the panel.
	 */
	public SubjectView() {
		this.model = ForaDataSource.getInstance().getSubjects().get(0);
		initView();

	}

	public void setController(SubjectController controller) {
		this.controller = controller;
	}

}
