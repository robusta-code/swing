package io.robusta.fora.swing;

import java.awt.BorderLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MultiView extends JPanel {

	/**
	 * Create the panel.
	 */
	public MultiView() {
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
		add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("PMF", null, panel, null);
		
		JLabel lblSomePmfStuff = new JLabel("Some PMF Stuff");
		panel.add(lblSomePmfStuff);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Forum", null, panel_1, null);
		
		//By default it takes the first subject
		final EditableSubjectView editableSubjectView = new EditableSubjectView();
		panel_1.add(editableSubjectView);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Flags", null, panel_2, null);
		
		final EditableFlagView editableFlagView = new EditableFlagView();
		editableFlagView.setEditableFlagController(new EditableFlagController(editableFlagView, editableFlagView.getModel()));
		panel_2.add(editableFlagView);
		
		tabbedPane.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				editableFlagView.getEditableFlagController().updateView();
				editableSubjectView.getSubjectView().getController().updateView();
			}
			});

		
		/*JLabel lblAddThereAll = new JLabel("Add there all flagged comments");
		panel_2.add(lblAddThereAll);*/

	}

}
