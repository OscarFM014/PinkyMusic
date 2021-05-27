import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;


public class MainPanel extends JPanel{
	public JButton namePlaylist,
				   botonPlay;
	private JLabel headerLista;
	public JLabel tiempoTotal;
	
	public JButton titulo,artista,fecha,album,duracion;
	private int numCanciones = 0;
  
	/*public ArrayList<Cancion> colaReproduccion;
  public int cancionActual;

  public void ordenarMinToMax(){

  }

  public void reproducir(){

  }

  public void reproducirFromStart(){

  }

  public void crearPlaylist(){

  }

  public void modificarLista(){

  }

  public void ventanaCrearPlaylist(){

  }
  public void ventanaQueue(){

  }

  public void panelMisCanciones(Cancion[] canciones){

  }

  public void interfazPlaylist(Playlist lista){
    
  }*/
	//Method to update total duration JLabel
	public void setSumDuration(String durationText) {
		this.tiempoTotal.setText(durationText);
	}
  
  //************************PARTE GRAFICA*****************
  public MainPanel() {
	  super();
	  this.setPreferredSize(new Dimension(1066,600));
	  this.setBackground(new Color(254,201,255));
	  
	  Border blackline = BorderFactory.createLineBorder(Color.black);
	  this.setBorder(blackline);
	  this.setLayout(null);
	  
	  //Button to change the title of the current play-list showed on mainPanel.
	  this.namePlaylist = new JButton("Para hacer el quehacer");
	  this.namePlaylist.setFont(new Font("Arial",Font.BOLD,45));
	  this.namePlaylist.setBackground(new Color(254,201,255));
	  this.namePlaylist.setBorder(null);
	  this.namePlaylist.setBounds(50,25,1000,100);
	  this.namePlaylist.setHorizontalAlignment(SwingConstants.LEFT);
	  this.namePlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Show a string input field so the user can update the name of the play-list.
			}
		});
	  this.add(this.namePlaylist);
	  
	  //Button to play current play-list from start.
	  this.botonPlay = new JButton();
	  Icon playIcon = new ImageIcon("Images/botonPlay.PNG");
	  this.botonPlay.setIcon(playIcon);
	  this.botonPlay.setBorder(null);
	  this.botonPlay.setBounds(50,120,100,100);
	  this.botonPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Call reproducirFromStart()
			}
		});
	  this.add(this.botonPlay);
	  
	  //Simple JLabel. DON'T MODIFY THIS.
	  this.headerLista = new JLabel("LISTA");
	  this.headerLista.setFont(new Font("Arial",Font.PLAIN,14));
	  this.headerLista.setBounds(230,140,50,15);
	  this.add(this.headerLista);
	  
	  //JLabel that show the sum of duration of the whole play-list. To modify it, call method setSumDuration()
	  this.tiempoTotal = new JLabel("25 canciones, 1 hr 28 min");
	  this.tiempoTotal.setFont(new Font("Arial",Font.PLAIN,14));
	  this.tiempoTotal.setBounds(230,170,250,15);
	  this.add(this.tiempoTotal);
	  
	  //Button of title.
	  this.titulo = new JButton("TiTULO");
	  this.titulo.setFont(new Font("Arial",Font.PLAIN,14));
	  this.titulo.setBackground(new Color(254,201,255));
	  this.titulo.setBorder(null);
	  this.titulo.setBounds(60,270,50,10);
	  this.titulo.setHorizontalAlignment(SwingConstants.LEFT);
	  this.titulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Order the array of current songs based on the title of each song.
			}
		});
	  this.add(this.titulo);
	  
	  //Button of artist.
	  this.artista = new JButton("ARTISTA");
	  this.artista.setFont(new Font("Arial",Font.PLAIN,14));
	  this.artista.setBackground(new Color(254,201,255));
	  this.artista.setBorder(null);
	  this.artista.setBounds(300,270,70,10);
	  this.artista.setHorizontalAlignment(SwingConstants.LEFT);
	  this.artista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Order the array of current songs based on the artist of each song.
			}
		});
	  this.add(this.artista);
	  
	  //Button of album.
	  this.album = new JButton("ALBUM");
	  this.album.setFont(new Font("Arial",Font.PLAIN,14));
	  this.album.setBackground(new Color(254,201,255));
	  this.album.setBorder(null);
	  this.album.setBounds(520,270,70,10);
	  this.album.setHorizontalAlignment(SwingConstants.LEFT);
	  this.album.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Order the array of current songs based on the album of each song.
			}
		});
	  this.add(this.album);
	  
	  //Button of date
	  this.fecha = new JButton("FECHA");
	  this.fecha.setFont(new Font("Arial",Font.PLAIN,14));
	  this.fecha.setBackground(new Color(254,201,255));
	  this.fecha.setBorder(null);
	  this.fecha.setBounds(750,270,70,10);
	  this.fecha.setHorizontalAlignment(SwingConstants.LEFT);
	  this.fecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Order the array of current songs based on the date of each song.
			}
		});
	  this.add(this.fecha);
	  
	  //Button of duration
	  this.duracion = new JButton("DURACION");
	  this.duracion.setFont(new Font("Arial",Font.PLAIN,14));
	  this.duracion.setBackground(new Color(254,201,255));
	  this.duracion.setBorder(null);
	  this.duracion.setBounds(900,270,80,10);
	  this.duracion.setHorizontalAlignment(SwingConstants.LEFT);
	  this.duracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Order the array of current songs based on the duration of each song.
			}
		});
	  this.add(this.duracion);
	  
	  //Example of showing a song.
	  pintaCancion("Amor prohibido", "Selena", "Amor prohibido", "2020-07-09", "2:53");
	  pintaCancion("Amor prohibido", "Selena", "Amor prohibido", "2020-07-09", "2:53");
	  pintaCancion("Amor prohibido", "Selena", "Amor prohibido", "2020-07-09", "2:53");
	  pintaCancion("Amor prohibido", "Selena", "Amor prohibido", "2020-07-09", "2:53");
	  pintaCancion("Amor prohibido", "Selena", "Amor prohibido", "2020-07-09", "2:53");
	  pintaCancion("Amor prohibido", "Selena", "Amor prohibido", "2020-07-09", "2:53");
  }
  
  public void pintaCancion(String title,String artista,String album,String fecha,String duracion) {
	  JLabel[] fila = new JLabel[5];
	  fila[0] = new JLabel(title);
	  fila[1] = new JLabel(artista);
	  fila[2] = new JLabel(album);
	  fila[3] = new JLabel(fecha);
	  fila[4] = new JLabel(duracion);
	  int[] distanciasX = {60,300,520,750,920};
	  
	  for (int i = 0; i < fila.length; i++) {
		  fila[i].setFont(new Font("Arial",Font.PLAIN,14));
		  fila[i].setBackground(new Color(254,201,255));
		  fila[i].setBorder(null);
		  fila[i].setBounds(distanciasX[i],320+(35*this.numCanciones),150,15);
		  fila[i].setHorizontalAlignment(SwingConstants.LEFT);
		  this.add(fila[i]);
	  }
	  this.numCanciones++;
  }
}