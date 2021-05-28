import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import java.util.*;

public class PanelLeft extends JPanel{
  /*private Cancion[] listaCanciones;
  private LinkedList<Cancion> listaPlaylists;
  private JButton cancionesB;
  private LinkedList<JButton> playlistB;*/

  private ArrayList<PlayList> listaPlaylist = new ArrayList<PlayList>();
  public Image logo;
  public JButton canciones,carpeta;
  public JButton[] buttonPlaylist;
  public JFileChooser fileChooser;
	
	
  private void seleccionarCarpeta(){
    
  }
  
  public PanelLeft() {
	  super();
	  this.setPreferredSize(new Dimension(300,600));
	  this.setBackground(new Color(254,192,255));
	  this.setLayout(null);
	 
	  Border blackline = BorderFactory.createLineBorder(Color.black);
	  this.setBorder(blackline);
	  this.logo = new ImageIcon("Pinky Music.png").getImage();
	  
	  //Button to show all Songs
	  this.canciones = new JButton("Canciones");
	  this.canciones.setFont(new Font("Arial",Font.PLAIN,14));
	  this.canciones.setBackground(new Color(254,192,255));
	  this.canciones.setBorder(null);
	  this.canciones.setBounds(15,140,100,15);
	  this.canciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Cancion> songs = new ArrayList<Cancion>(); 
				Cancion song1 = new Cancion("./songs/AlanWalkerStyle-SavageLove(NewSong2020).mp3", "Savage Love (NewSong2020) ", "Alan Walker", "NoCopyrightSounds", "05/08/19", 224L, new ImageIcon("./Images/Savagelove.PNG").getImage());
				Cancion song2 = new Cancion("./songs/ChillDay.mp3", "Chill Day", "LAKEY INSPIRED", "Unknown", "02/09/15", 186L, new ImageIcon("./Images/ChillDay.PNG").getImage());
				Cancion song3 = new Cancion("./songs/Cloudsurfing.mp3", "Cloudsurfing", "Omniboi","Unknown", "18/12/2014", 220L,  new ImageIcon("./Images/Cloudsurfing.PNG").getImage());
				Cancion song4 = new Cancion("./songs/DrewsThatDude.mp3", "Chill", "Drews That Dude", "Trey Songs", "01/10/2010",  272L,  new ImageIcon("./Images/Chill.PNG").getImage());
				Cancion song5 = new Cancion("./songs/Emotional(VirtualRiotRemix).mp3", "Emotional", "Flux Pavillion & Matthew Koma", "Virtual Riot", "16/12/2013", 268L,  new ImageIcon("./Images/Emotional.PNG").getImage() );
				Cancion song6 = new Cancion("./songs/INMYHEART(ORIGINALMIX)-DJDARLEXHOUSE.mp3", "In My Heart", "Darlex House", "NCM", "18/12/2016", 195L,  new ImageIcon("./Images/InMyHeart.PNG").getImage());
				Cancion song7 = new Cancion("./songs/MarkTarmonea-Clocks(RadioEdit).mp3", "Clocks", "Mark Tarmonea", "Bull In A China Shop", "25/08/2013", 206L,  new ImageIcon("./Images/Clocks.PNG").getImage());
				Cancion song8 = new Cancion("./songs/MÖWE-BirdsFlyingHigh.mp3", "Birds Flying High", "MÖWE", "Unknown", "06/01/2009" , 309L,  new ImageIcon("./Images/BirdsFlyHigh.PNG").getImage() );
				Cancion song9 = new Cancion("./songs/SKYJAXX-ThinkAboutIt.mp3", "THNK IT THRU", "yxsmay", "Unknown","05/09/17", 107L,  new ImageIcon("./Images/THNKTHROUGH.PNG").getImage());
				Cancion song10 = new Cancion("./SoLongft.BBDiamond(OriginalMix)-JerryFolk.mp3", "So Long", "Jerry Folk ft. BB Diamond", "Unknown", "10/12/2014", 224L,  new ImageIcon("./Images/SoLong.PNG").getImage());
				songs.add(song1);
				songs.add(song2);
				songs.add(song3);
				songs.add(song4);
				songs.add(song5);
				songs.add(song6);
				songs.add(song7);
				songs.add(song8);
				songs.add(song9);
				songs.add(song10);
				
				PlayList cancionesList = new PlayList("Canciones", songs);
			}
		});
	  this.add(this.canciones);
	  
	  
	  //Button to music folder source
	  this.carpeta = new JButton("Carpeta de musica");
	  this.carpeta.setFont(new Font("Arial",Font.PLAIN,14));
	  this.carpeta.setBackground(new Color(254,192,255));
	  this.carpeta.setBorder(null);
	  this.carpeta.setBounds(15,170,150,15);
	  this.carpeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Show a File Chooser to select a folder to read the songs from.
			}
		});
	  this.add(this.carpeta);
	  
	  
	  //Ten buttons of play-lists. At start, they aren't shown, until user adds a play-list it appears, up to a limit of 10.
	  this.buttonPlaylist = new JButton[10];
	  for (int i = 0; i < buttonPlaylist.length; i++) {
		this.buttonPlaylist[i] = new JButton("Dummy "+i);
		this.buttonPlaylist[i].setFont(new Font("Arial",Font.PLAIN,14));
		this.buttonPlaylist[i].setBackground(new Color(254,192,255));
		this.buttonPlaylist[i].setBorder(null);
		this.buttonPlaylist[i].setBounds(-10,280+(30*i),150,15);
		this.buttonPlaylist[i].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//On click, pass an array with the songs of the play-list to mainPanel
			}
		});
		this.add(this.buttonPlaylist[i]);
	  }

  }
  
  public void paintComponent(Graphics g) { //Cuando dibujemos en un panel, usar paintComponent
		super.paintComponent(g);	
		g.drawImage(this.logo,20,10,250,65,this);
		g.setFont(new Font("Arial",Font.PLAIN , 14));
		g.drawString("MI MUSICA", 35, 115);
		g.drawString("PLAYLISTS", 35, 250);
		
	}
  
}