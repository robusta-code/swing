package io.robusta.fora.swing;

import io.robusta.fora.domain.Comment;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

public class CommentListRenderer extends JPanel implements ListCellRenderer<Comment>{

	@Override
	public Component getListCellRendererComponent(
			JList<? extends Comment> list, Comment value, int index,
			boolean isSelected, boolean cellHasFocus) {

		
		CommentView view = new CommentView(value);
		CommentController controller = new CommentController(value, view);
		view.setController(controller);
		
		return view;
	}


}
