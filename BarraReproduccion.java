import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;

public class BarraReproduccion extends JPanel{
	public JButton botonPlay,
					avanzarBoton,
					retrocederBoton,
					loopBoton,
					randomBoton,
					newListBoton,
					colaBoton;
	public JSlider volumeSlider,
				   speedSlider,
				   playingSlider;
	public JLabel titlePlaying,
				  artistPlaying;
  /*private Cancion cancionActual;
  private boolean repetir;
  private JButton pause;
  private JButton play;
  private JButton avanzar;
  private JButton retroceder;
  private JButton volumen;
  private JButton activarRepetir;
  private JButton aleatorio;
  private JButton crearPlaylist;
  private JButton mostrarQueue;
  private JSlider volumenSlider;
  private JSlider reproduccionSlider;
  private MainPanel panelMain;

  private void pause(){

  }
  private void play(){

  }
  private void avanzar(){

  }
  private void retroceder(){

  }
  private void cambiarVolumen(){

  }
  private void repetir(){

  }
  private void reproduccionAleatoria(){

  }
  private void crearPlaylist(){

  }

  private void displayQueue(){

  }
  private void cambiarVelocidad(){
    
  }*/
	
  //***************PARTE GRAFICA*************+
	public BarraReproduccion() {
		super();
		this.setPreferredSize(new Dimension(950,105));
		this.setBackground(new Color(253,153,255));
		this.setLayout(null);
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		this.setBorder(blackline);
		
		this.botonPlay = new JButton();
		Icon playIcon = new ImageIcon("playMini.PNG");
		this.botonPlay.setIcon(playIcon);
		this.botonPlay.setBorder(null);
		this.botonPlay.setBounds(655,30,40,40);
		this.add(this.botonPlay);
		
		//Boton avanzar
		this.avanzarBoton = new JButton();
		playIcon = new ImageIcon("avanzarBoton.PNG");
		this.avanzarBoton.setIcon(playIcon);
		this.avanzarBoton.setBorder(null);
		this.avanzarBoton.setBounds(700,35,28,28);
		this.add(this.avanzarBoton);
		
		//Boton retroceder
		this.retrocederBoton = new JButton();
		playIcon = new ImageIcon("retrocederBoton.PNG");
		this.retrocederBoton.setIcon(playIcon);
		this.retrocederBoton.setBorder(null);
		this.retrocederBoton.setBounds(621,34,28,28);
		this.add(this.retrocederBoton);
		
		//Boton loop
		this.loopBoton = new JButton();
		playIcon = new ImageIcon("loopBoton.PNG");
		this.loopBoton.setIcon(playIcon);
		this.loopBoton.setBorder(null);
		this.loopBoton.setBounds(540,34,28,28);
		this.add(this.loopBoton);
		
		//Boton random
		this.randomBoton = new JButton();
		playIcon = new ImageIcon("randomBoton.PNG");
		this.randomBoton.setIcon(playIcon);
		this.randomBoton.setBorder(null);
		this.randomBoton.setBounds(480,37,28,23);
		this.add(this.randomBoton);
		
		//Boton agregar Playlist
		this.newListBoton = new JButton();
		playIcon = new ImageIcon("newListBoton.PNG");
		this.newListBoton.setIcon(playIcon);
		this.newListBoton.setBorder(null);
		this.newListBoton.setBounds(781,37,28,23);
		this.add(this.newListBoton);
		
		//Boton cola de reproduccion
		this.colaBoton = new JButton();
		playIcon = new ImageIcon("colaBoton.PNG");
		this.colaBoton.setIcon(playIcon);
		this.colaBoton.setBorder(null);
		this.colaBoton.setBounds(841,39,28,23);
		this.add(this.colaBoton);
		
		//Slider de velocidad de reproduccion
		this.speedSlider = new JSlider(JSlider.HORIZONTAL,1,4,1);
		this.speedSlider.setMajorTickSpacing(1);
		this.speedSlider.setPaintTicks(true);
		this.speedSlider.setPaintLabels(true);
		this.speedSlider.setForeground(Color.BLACK);
		this.speedSlider.setFont(new Font("Arial",Font.BOLD,10));
		this.speedSlider.setBackground(new Color(253,153,255));
		this.speedSlider.setBounds(1100,12,200,40);
		this.add(this.speedSlider);
		
		
		//Slider de volumen
		this.volumeSlider = new JSlider(JSlider.HORIZONTAL,1,100,50);
		this.volumeSlider.setBackground(new Color(253,153,255));
		this.volumeSlider.setBounds(1100,60,200,40);
		this.add(this.volumeSlider);
		
		//Slider de reproduccion
		this.playingSlider = new JSlider(JSlider.HORIZONTAL,0,100,0);
		this.playingSlider.setBackground(new Color(253,153,255));
		this.playingSlider.setBounds(426,70,500,30);
		this.add(this.playingSlider);
		
		//Label título cancion en reproduccion
		this.titlePlaying = new JLabel("Amor Prohibido");
		this.titlePlaying.setBackground(new Color(253,153,255));
		this.titlePlaying.setFont(new Font("Arial",Font.BOLD,14));
		this.titlePlaying.setBounds(110,20,250,30);
		this.add(this.titlePlaying);
		
		//Label título cancion en reproduccion
		this.artistPlaying = new JLabel("Selena");
		this.artistPlaying.setBackground(new Color(253,153,255));
		this.artistPlaying.setFont(new Font("Arial",Font.BOLD,11));
		this.artistPlaying.setBounds(110,40,250,30);
		this.add(this.artistPlaying);
	}
	
	public void paintComponent(Graphics g) { //Cuando dibujemos en un panel, usar paintComponent
		super.paintComponent(g);	
		Image speedIcon = new ImageIcon("speedIcon.PNG").getImage();
		g.drawImage(speedIcon,1065,10,27,27,this);
		Image volumeIcon = new ImageIcon("volumeBoton.PNG").getImage();
		g.drawImage(volumeIcon,1065,65,27,27,this);
		Image ejemploIcon = new ImageIcon("imagenEjemplo.PNG").getImage();
		g.drawImage(ejemploIcon,10,10,90,90,this);
		
	}

}