package io.robusta.fora.swing;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;

public class MultiView extends JPanel {

	/**
	 * Create the panel.
	 */
	public MultiView() {
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("PMF", null, panel, null);
		
		JLabel lblSomePmfStuff = new JLabel("Some PMF Stuff");
		panel.add(lblSomePmfStuff);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Forum", null, panel_1, null);
		
		//By default it takes the first subject
		EditableSubjectView editableSubjectView = new EditableSubjectView();
		panel_1.add(editableSubjectView);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Flags", null, panel_2, null);
		
		JLabel lblAddThereAll = new JLabel("Add there all flagged comments");
		panel_2.add(lblAddThereAll);

	}

}
