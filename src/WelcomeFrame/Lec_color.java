package WelcomeFrame;

import java.awt.Color;

import javax.swing.JLabel;

public class Lec_color extends JLabel {
	
	public Lec_color(int i) {
		if(i==1){
			this.setOpaque(true);
			this.setBackground(Color.WHITE);	
		}
		else if(i==2){
			this.setOpaque(true);
			this.setBackground(Color.red);	
			
		}
		else if(i==3){
			this.setOpaque(true);
			this.setBackground(Color.GREEN);	
			
		}else if(i==4){
			this.setOpaque(true);
			this.setBackground(Color.yellow);	
			
		}
	}

}
