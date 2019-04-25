import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.rmi.CORBA.Util;
import javax.swing.*;
import org.junit.runner.*;

public class LeftPanel extends JPanel {
	private JButton chooseBtn;
	private JButton runBtn;
	private JLabel testsPassed;
	private JPanel piePanel;
	private JPanel btnPanel;
	private PieChart pieChart;
	private TestManager testManager;
	
	LeftPanel() {
		pieChart = new PieChart(1, 1);
		
		piePanel = new JPanel(new BorderLayout());
		piePanel.add(pieChart);
		
		chooseBtn = new JButton("Choose File");
		runBtn = new JButton("Run Test");
		
		// Attach action listeners
		chooseBtn.addActionListener(new FileListener1());
		runBtn.addActionListener(new FileListener2());
		
		btnPanel = new JPanel(new GridLayout());
		btnPanel.add(chooseBtn);
		btnPanel.add(runBtn);
		
		testsPassed = new JLabel("0 / 0 Tests Passed");
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(testsPassed);
		this.add(piePanel);
		this.add(btnPanel);
	}
	
	private class FileListener1 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser fileChooser = new JFileChooser();
	        fileChooser.showOpenDialog(null);
	        testManager = TestManager.TestManager();
	        testManager.setFile(fileChooser.getSelectedFile());
		}
	}
	
	private class FileListener2 implements ActionListener {		
		@Override
		public void actionPerformed(ActionEvent e) {
			testManager = TestManager.TestManager();
			
			if(testManager.getFile() == null) {
				JOptionPane.showMessageDialog(btnPanel, "Please first selected a file to be run.");
				return;
			}
			
			Class c;
			try {
				c = Class.forName(testManager.getFile().getName().substring(0,testManager.getFile().getName().length()-5));
				JUnitCore jUnitCore = new JUnitCore();
			    Result result = jUnitCore.run(c);
			    pieChart.update(result.getFailureCount(), result.getRunCount());
			    testsPassed.setText(result.getRunCount()-result.getFailureCount() + " / " + result.getRunCount() + " Tests Passed");
			    System.out.println(result.getRunCount()-result.getFailureCount() + " / " + result.getRunCount() + " Tests Passed");
			    testManager.setResult(result);
			    RightPanel.update();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}	
	}
}