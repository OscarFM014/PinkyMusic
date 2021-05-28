import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;

public class Frame extends JFrame { //JFrame maneja por default es BorderLayout, con cinco regiones, norte sur, este, oeste y centro. El centro trata de llenar los espacios vacíos.
	public Frame() throws IOException {
		super("Pinky Music");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		PanelLeft pd = new PanelLeft();
		this.add(pd,BorderLayout.WEST);
		
		MainPanel mp = new MainPanel();
		this.add(mp, BorderLayout.CENTER);
		
		BarraReproduccion rp = new BarraReproduccion(mp);
		this.add(rp, BorderLayout.SOUTH);
		
		this.pack();//Hace que la ventana se ajuste a sus componentes 
		this.setVisible(true);
	}
	
	/*public void paint(Graphics g) {
		super.paint(g);
		g.fillOval(100,100,200,200);
	}*/
	
	public static void main(String[] args) throws IOException {
		Frame ventana = new Frame();
	}
}
