import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;

public class ChartPanel extends JPanel {
private double[] values;
private String[] names;
private String title;

public ChartPanel(double[] v, String[] n, String t) {
names = n;
values = v;
title = t;
}

public void paintComponent(Graphics g) {
super.paintComponent(g);
if (values == null || values.length == 0)
return;
double minValue = 0;
double maxValue = 0;
for (int i = 0; i < values.length; i++) {
System.out.println("i>>>>>>>>>" + i);
if(minValue > values[i])
minValue = values[i];
if(maxValue < values[i])
maxValue = values[i];
}

Dimension d = getSize();
int clientWidth = d.width;
int clientHeight = d.height;
int barWidth = clientWidth / values.length;
System.out.println("d>>>>>>>>>>>>>>>>" + d);
System.out.println("clientWidth>>>>>>" + clientWidth);
System.out.println("clientHeight>>>>>" + clientHeight); 
System.out.println("barWidth>>>>>>>>>" + barWidth);

Font titleFont = new Font("SansSerif", Font.BOLD, 20);
FontMetrics titleFontMetrics = g.getFontMetrics(titleFont);
Font labelFont = new Font("SansSerif", Font.PLAIN, 10);
FontMetrics labelFontMetrics = g.getFontMetrics(labelFont);

int titleWidth = titleFontMetrics.stringWidth(title);
int y = titleFontMetrics.getAscent();
int x = (clientWidth - titleWidth) / 2;
g.setFont(titleFont);
g.drawString(title, x, y);

int top = titleFontMetrics.getHeight();
int bottom = labelFontMetrics.getHeight();
if (maxValue == minValue)
return;
double scale = (clientHeight - top - bottom) / (maxValue - minValue);
y = clientHeight - labelFontMetrics.getDescent();
g.setFont(labelFont);

for (int i = 0; i < values.length; i++) {
int valueX = i * barWidth + 1;
int valueY = top;
int height = (int) (values[i] * scale);
if (values[i] >= 0)
valueY += (int) ((maxValue - values[i]) * scale);
else {
valueY += (int) (maxValue * scale);
height = -height;
}

g.setColor(Color.blue);
g.fillRect(valueX, valueY, barWidth - 2, height);
g.setColor(Color.black);
g.drawRect(valueX, valueY, barWidth - 2, height);
int labelWidth = labelFontMetrics.stringWidth(names[i]);
x = i * barWidth + (barWidth - labelWidth)/ 2;
g.drawString(names[i], x, y);
}
}

public static void main(String[] argv) {
JFrame f = new JFrame();
f.setSize(400, 300);
double[] values = new double[4];
String[] names = new String[4];
values[0] = 1;
names[0] = "0-18";

values[1] = 2;
names[1] = "18-25";

values[2] = 4;
names[2] = "26-30";

values[3] = 6;
names[3] = ">30"; 



f.getContentPane().add(new ChartPanel(values, names, "Column chart showing age and distribution"));
WindowListener wndCloser = new WindowAdapter() {
public void windowClosing(WindowEvent e) {
System.exit(0);
}
};
f.addWindowListener(wndCloser);
f.setVisible(true);
}
}

