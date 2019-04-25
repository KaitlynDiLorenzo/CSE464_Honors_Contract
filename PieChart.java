import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

class Part {
   double value;
   Color color;
   
   public Part(double value, Color color) {
      this.value = value;
      this.color = color;
   }
}

class PieChart extends JComponent {
   double pass, fail;
   Part[] slices;
   
   PieChart(int passedTests, int totalTests) {
	   pass = (double) passedTests/totalTests;
	   fail = (double) (totalTests-passedTests)/totalTests;
	   slices = new Part[]{new Part(pass, Color.green), new Part(fail, Color.red)};
   }
   
   public void paint(Graphics g) {
      drawPie((Graphics2D) g, getBounds(), slices);
   }
   
   void drawPie(Graphics2D g, Rectangle area, Part[] slices) {
      double total = 0.0D;
      for (int i = 0; i < slices.length; i++) {
         total += slices[i].value;
      } 
      double curValue = 0.0D;
      int startAngle = 0;
      for (int i = 0; i < slices.length; i++) {
         startAngle = (int) (curValue * 360 / total);
         int arcAngle = (int) (slices[i].value * 360 / total);
         
         g.setColor(slices[i].color);
         g.fillArc(area.x, area.y, area.width, area.height, startAngle, arcAngle);
         curValue += slices[i].value;
      } 
   }
   
   public void update(int failedTests, int totalTests) {
	   slices = new Part[]{new Part((double)(totalTests-failedTests)/totalTests, Color.green), new Part((double) failedTests/totalTests, Color.red)};
	   this.repaint();
   }
}