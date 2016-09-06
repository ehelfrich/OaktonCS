
import javax.swing.JOptionPane;

public class BowlingDriver {
	public static void main(String[] args) {
		String n = JOptionPane.showInputDialog("Please enter a name for a bowler: ");
		BowlingGame g = new BowlingGame(n);
		int pins;
		while(g.getFrame() < 10){
			do{
				pins = Integer.parseInt(JOptionPane.showInputDialog("Enter the pins knocked over for frame " + (g.getFrame()+1) + " :"));
			}while(g.shot(pins));
			g.computeScoreFrame();
			JOptionPane.showMessageDialog(null, g);
		}
		JOptionPane.showMessageDialog(null, "The bowler's score is: " + g.getScore());
	}
}
