import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.*;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
	public Image albumImage;
  private Cancion cancionActual = new Cancion("songs/prueba2.mp3");
  private JButton pause;
  public MainPanel panelMain;
  private ArrayList<Cancion> queue;
  int i = 0;

  //private void pause(){

  //}
  private void play(){

  }


  /**private void avanzar(){

  }
  private void retroceder(){

  }
   **/
  private void cambiarVolumen(float volumen){
  	Port.Info source = Port.Info.SPEAKER;
  	if(AudioSystem.isLineSupported(source)){
  		try{
  			Port outline = (Port) AudioSystem.getLine(source);
  			outline.open();
  			FloatControl volumeControl = (FloatControl) outline.getControl(FloatControl.Type.VOLUME);
  			System.out.println("         VOLUME: " + volumeControl.getValue());
			volumeControl.setValue(volumen/100);
  			System.out.println("    new volume: " + volumen/100);
  			if(volumeControl.getValue() < 0.08f){
  				volumeControl.setValue(0);
			}

		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

  }/**
  private void repetir(){

  }
  private void reproduccionAleatoria(){

  }
  private void crearPlaylist(){

  }

  private void displayQueue(){

  }**/
  /**private void cambiarVelocidad(){
    
  }**/

	public void setTitleCurrent(String titleSong) {
		this.titlePlaying.setText(titleSong);
	}
	public void setArtistCurrent(String artistSong) {
		this.artistPlaying.setText(artistSong);
	}
	public void setImageCurrent(Image album) {
		this.albumImage = album;
	}
	
  //***************PARTE GRAFICA*************+
	public BarraReproduccion(MainPanel panel) throws IOException {
		super();
		this.setPreferredSize(new Dimension(950,105));
		this.setBackground(new Color(253,153,255));
		this.setLayout(null);
		this.panelMain = panel;
		queue = panelMain.canciones;
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		this.setBorder(blackline);
		
		
		//Button to play current song.

		this.botonPlay = new JButton();
		Icon playIcon = new ImageIcon("Images/playMini.PNG");
		this.botonPlay.setIcon(playIcon);
		this.botonPlay.setBorder(null);
		this.botonPlay.setBounds(655,30,40,40);
		this.botonPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(cancionActual.playing){
					botonPlay.setIcon(new ImageIcon("Images/playMini.PNG"));
					cancionActual.pausar();
				}else{

					cancionActual = queue.get(i);
					cancionActual.reproducir();
					botonPlay.setBackground(new Color(253,153,255));
					botonPlay.setBorder(null);
					botonPlay.setIcon(new ImageIcon("Images/pauseIcon.PNG"));
				}
				play();

			}
		});
		this.add(this.botonPlay);
		
		
		//Button to play next song.
		this.avanzarBoton = new JButton();
		playIcon = new ImageIcon("Images/avanzarBoton.PNG");
		this.avanzarBoton.setIcon(playIcon);
		this.avanzarBoton.setBorder(null);
		this.avanzarBoton.setBounds(700,35,28,28);
		this.avanzarBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Play next song.
				if(i < queue.size()){
					System.out.println(i);
					cancionActual.stop();
					cancionActual = new Cancion(queue.get(i+1).rutaArchivo);
					cancionActual.reproducir();
					i++;
				}

			}
		});
		this.add(this.avanzarBoton);


		
		//Button to play previous song.
		this.retrocederBoton = new JButton();
		playIcon = new ImageIcon("Images/retrocederBoton.PNG");
		this.retrocederBoton.setIcon(playIcon);
		this.retrocederBoton.setBorder(null);
		this.retrocederBoton.setBounds(621,34,28,28);
		this.retrocederBoton.addActionListener(e -> {
			//Play previous song.
			if(i > 0){
				i--;
				System.out.println("CANCION PREVIA");
				System.out.println(i);
				cancionActual.stop();
				cancionActual = new Cancion(queue.get(i).rutaArchivo);
				cancionActual.reproducir();
			}



		});
		this.add(this.retrocederBoton);
		
		
		//Button to loop current song.
		this.loopBoton = new JButton();
		playIcon = new ImageIcon("Images/loopBoton.PNG");
		this.loopBoton.setIcon(playIcon);
		this.loopBoton.setBorder(null);
		this.loopBoton.setBounds(540,34,28,28);
		this.loopBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Keep playing current song.
				if(cancionActual.repetir){
					cancionActual.playThread.interrupt();
					cancionActual.noRepetir();
				}else{
					cancionActual.repetir();
				}
			}
		});
		this.add(this.loopBoton);
		
		
		//Button to play random songs.
		this.randomBoton = new JButton();
		playIcon = new ImageIcon("Images/randomBoton.PNG");
		this.randomBoton.setIcon(playIcon);
		this.randomBoton.setBorder(null);
		this.randomBoton.setBounds(480,37,28,23);
		this.randomBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Keep selecting random songs to play next.
				i = (int) (Math.random() * (queue.size()));
				if(i > 0 ){
					System.out.println("CANCION ALEATORIA");
					System.out.println(i);
					cancionActual.stop();
					cancionActual = new Cancion(queue.get(i).rutaArchivo);
					cancionActual.reproducir();
				}
			}
		});
		this.add(this.randomBoton);
		
		
		//Button to add a new Play-list
		this.newListBoton = new JButton();
		playIcon = new ImageIcon("Images/newListBoton.PNG");
		this.newListBoton.setIcon(playIcon);
		this.newListBoton.setBorder(null);
		this.newListBoton.setBounds(781,37,28,23);
		this.newListBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Start routine of creation of new Playlist.
			}
		});
		this.add(this.newListBoton);
		
		
		//Button to open reproduction queue.
		this.colaBoton = new JButton();
		playIcon = new ImageIcon("Images/colaBoton.PNG");
		this.colaBoton.setIcon(playIcon);
		this.colaBoton.setBorder(null);
		this.colaBoton.setBounds(841,39,28,23);
		this.colaBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Start routine of viewing and modifying reproduction queue.
			}
		});
		this.add(this.colaBoton);
		
		
		//Slider of reproduction speed.
		this.speedSlider = new JSlider(JSlider.HORIZONTAL,1,4,1);
		this.speedSlider.setMajorTickSpacing(1);
		this.speedSlider.setPaintTicks(true);
		this.speedSlider.setPaintLabels(true);
		this.speedSlider.setForeground(Color.BLACK);
		this.speedSlider.setFont(new Font("Arial",Font.BOLD,10));
		this.speedSlider.setBackground(new Color(253,153,255));
		this.speedSlider.setBounds(1100,12,200,40);
		this.add(this.speedSlider);
		
		
		//Slider of volume.
		this.volumeSlider = new JSlider(JSlider.HORIZONTAL,1,100,50);
		this.volumeSlider.setBackground(new Color(253,153,255));
		this.volumeSlider.setBounds(1100,60,200,40);
		volumeSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				float volumen =volumeSlider.getValue();
				System.out.println(volumen);
				cambiarVolumen(volumen);
			}
		});
		this.add(this.volumeSlider);
		
		
		//Slider of current song reproduction.
		this.playingSlider = new JSlider(JSlider.HORIZONTAL,0,100,0);
		this.playingSlider.setBackground(new Color(253,153,255));
		this.playingSlider.setBounds(426,70,500,30);
		this.add(this.playingSlider);


		
		//JLabel of title of current song. Method -> setTitleCurrent(String)
		this.titlePlaying = new JLabel("Amor Prohibido");
		this.titlePlaying.setBackground(new Color(253,153,255));
		this.titlePlaying.setFont(new Font("Arial",Font.BOLD,14));
		this.titlePlaying.setBounds(110,20,250,30);
		this.add(this.titlePlaying);
		
		//JLabel of artist of current song. Method -> setArtistCurrent(String
		this.artistPlaying = new JLabel("Selena");
		this.artistPlaying.setBackground(new Color(253,153,255));
		this.artistPlaying.setFont(new Font("Arial",Font.BOLD,11));
		this.artistPlaying.setBounds(110,40,250,30);
		this.add(this.artistPlaying);
	}
	
	public void paintComponent(Graphics g) { //Cuando dibujemos en un panel, usar paintComponent
		super.paintComponent(g);	
		Image speedIcon = new ImageIcon("Images/speedIcon.PNG").getImage();
		g.drawImage(speedIcon,1065,10,27,27,this);
		Image volumeIcon = new ImageIcon("Images/volumeBoton.PNG").getImage();
		g.drawImage(volumeIcon,1065,65,27,27,this);
		
		Image ejemploIcon = new ImageIcon("Images/imagenEjemplo.PNG").getImage();
		g.drawImage(ejemploIcon,10,10,90,90,this);
		
	}

}