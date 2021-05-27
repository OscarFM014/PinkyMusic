import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PanelLeft extends JPanel{
  /*private Cancion[] listaCanciones;
  private LinkedList<Cancion> listaPlaylists;
  private JButton cancionesB;
  private LinkedList<JButton> playlistB;*/

  public Image logo;
  public JButton canciones,carpeta;
  public JButton[] buttonPlaylist;
	
	
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
				//Pass an array with all the songs to mainPanel so it displays them all.
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
		g.drawString("Mi MUSICA", 35, 115);
		g.drawString("PLAYLISTS", 35, 250);
		
	}
  
}