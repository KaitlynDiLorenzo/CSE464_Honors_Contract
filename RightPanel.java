import javax.swing.*;
import org.junit.runner.notification.Failure;

public class RightPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private DefaultListModel passedList;
	private static DefaultListModel<Failure> failedList;
	
	/*
	private JScrollPane topScroll;
	private JList topList;
	private JLabel topLabel;
	*/
	
	private JScrollPane bottomScroll;
	private JList bottomList;
	private JLabel bottomLabel;
	
	
	RightPanel() {
		passedList = new DefaultListModel();
		failedList = new DefaultListModel();
		
		/*
		topList = new JList(passedList);
		topScroll = new JScrollPane(topList);
		topLabel = new JLabel("Passed");
		*/
		
		bottomList = new JList(failedList);
		bottomScroll = new JScrollPane(bottomList);
		bottomLabel = new JLabel("Failed Tests");
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		//this.add(topLabel);
		//this.add(topScroll);
		this.add(bottomLabel);
		this.add(bottomScroll);
	}
	
	public static void update() {
		TestManager testManager = TestManager.TestManager();
		failedList.clear();
		for(int i = 0; i < testManager.getResult().getFailures().size(); i++) {
			failedList.add(i, testManager.getResult().getFailures().get(i));
		}
	}
}
