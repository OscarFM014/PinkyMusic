import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

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
	public ArrayList<JLabel> lista = new ArrayList<>();
	
	public JButton titulo,artista,fecha,album,duracion;
	private int numCanciones = 0;
	public ArrayList<Cancion> canciones;
  /**public int cancionActual;

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
	  canciones = new ArrayList<Cancion>();

	  this.setPreferredSize(new Dimension(1066,600));
	  this.setBackground(new Color(254,201,255));
	  
	  Border blackline = BorderFactory.createLineBorder(Color.black);
	  this.setBorder(blackline);
	  this.setLayout(null);
	  
	  //Button to change the title of the current play-list showed on mainPanel.
	  this.namePlaylist = new JButton("Fiesta");
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
	  this.tiempoTotal = new JLabel("5 canciones, 0 hr 20 min");
	  this.tiempoTotal.setFont(new Font("Arial",Font.PLAIN,14));
	  this.tiempoTotal.setBounds(230,170,250,15);
	  this.add(this.tiempoTotal);
	  
	  //Button of title.
	  this.titulo = new JButton("TITULO");
	  this.titulo.setFont(new Font("Arial",Font.PLAIN,14));
	  this.titulo.setBackground(new Color(254,201,255));
	  this.titulo.setBorder(null);
	  this.titulo.setBounds(60,270,50,10);
	  this.titulo.setHorizontalAlignment(SwingConstants.LEFT);
	  this.titulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Order the array of current songs based on the title of each song.
				for(JLabel jl: lista){
					remove(jl);
				}repaint();
				lista = new ArrayList<JLabel>();
				numCanciones = 0;
				System.out.println("ORDENAR POR TITULO");
				Image img1 = new ImageIcon("Images/Savagelove.PNG").getImage();
				Image img2 = new ImageIcon("Images/ChillDay.PNG").getImage();
				Image img3 = new ImageIcon("Images/Cloudsurfing.PNG").getImage();
				Image img4 = new ImageIcon("Images/Chill.PNG").getImage();
				Image img5 = new ImageIcon("Images/Emotional.PNG").getImage();
				canciones = new ArrayList<Cancion>();
				canciones.add(new Cancion("songs/DrewsThatDude.mp3","Chill", "Drews that dude","Trey songs", "2015-08-5",272, img4));
				canciones.add(new Cancion("songs/ChillDay.mp3","Chill Day", "DrewsThatDude","Inspired", "2020-09-09",272, img2));
				canciones.add(new Cancion("songs/Emotional(VirtualRiotRemix).mp3","Emotional", "Flux Pavillion & Mathew Koma","Virtual Riot", "2016-02-03",220, img5));
				canciones.add(new Cancion("songs/Cloudsurfing.mp3","Cloudsurfing", "Omniboi","Uknown", "2015-05-18",220, img3));
				canciones.add(new Cancion("songs/AlanWalkerStyle-SavageLove(NewSong2020).mp3","Savage Love", "Alan Walker","Greatest hits", "2021-07-09",213, img1));
				for(int i = 0; i < canciones.size(); i++){
					pintaCancion(canciones.get(i).getTitulo(),canciones.get(i).artista,canciones.get(i).album,canciones.get(i).fecha,String.valueOf(canciones.get(i).duracion));
				}

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
				for(JLabel jl: lista){
					remove(jl);
				}repaint();
				lista = new ArrayList<JLabel>();
				numCanciones = 0;
				System.out.println("ORDENAR POR ARTISTA");
				Image img1 = new ImageIcon("Images/Savagelove.PNG").getImage();
				Image img2 = new ImageIcon("Images/ChillDay.PNG").getImage();
				Image img3 = new ImageIcon("Images/Cloudsurfing.PNG").getImage();
				Image img4 = new ImageIcon("Images/Chill.PNG").getImage();
				Image img5 = new ImageIcon("Images/Emotional.PNG").getImage();
				canciones = new ArrayList<Cancion>();
				canciones.add(new Cancion("songs/AlanWalkerStyle-SavageLove(NewSong2020).mp3","Savage Love", "Alan Walker","Greatest hits", "2021-07-09",213, img1));
				canciones.add(new Cancion("songs/DrewsThatDude.mp3","Chill", "Drews that dude","Trey songs", "2015-08-5",272, img4));
				canciones.add(new Cancion("songs/ChillDay.mp3","Chill Day", "DrewsThatDude","Inspired", "2020-09-09",272, img2));
				canciones.add(new Cancion("songs/Emotional(VirtualRiotRemix).mp3","Emotional", "Flux Pavillion & Mathew Koma","Virtual Riot", "2016-02-03",220, img5));
				canciones.add(new Cancion("songs/Cloudsurfing.mp3","Cloudsurfing", "Omniboi","Uknown", "2015-05-18",220, img3));

				for(int i = 0; i < canciones.size(); i++){
					pintaCancion(canciones.get(i).getTitulo(),canciones.get(i).artista,canciones.get(i).album,canciones.get(i).fecha,String.valueOf(canciones.get(i).duracion));
				}
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
				System.out.println("ORDENAR POR ALBUM");
				for(JLabel jl: lista){
					remove(jl);
				}repaint();
				lista = new ArrayList<JLabel>();
				numCanciones = 0;
				Image img1 = new ImageIcon("Images/Savagelove.PNG").getImage();
				Image img2 = new ImageIcon("Images/ChillDay.PNG").getImage();
				Image img3 = new ImageIcon("Images/Cloudsurfing.PNG").getImage();
				Image img4 = new ImageIcon("Images/Chill.PNG").getImage();
				Image img5 = new ImageIcon("Images/Emotional.PNG").getImage();
				canciones = new ArrayList<Cancion>();
				canciones.add(new Cancion("songs/AlanWalkerStyle-SavageLove(NewSong2020).mp3","Savage Love", "Alan Walker","Greatest hits", "2021-07-09",213, img1));
				canciones.add(new Cancion("songs/ChillDay.mp3","Chill Day", "DrewsThatDude","Inspired", "2020-09-09",272, img2));
				canciones.add(new Cancion("songs/DrewsThatDude.mp3","Chill", "Drews that dude","Trey songs", "2015-08-5",272, img4));
				canciones.add(new Cancion("songs/Cloudsurfing.mp3","Cloudsurfing", "Omniboi","Uknown", "2015-05-18",220, img3));
				canciones.add(new Cancion("songs/Emotional(VirtualRiotRemix).mp3","Emotional", "Flux Pavillion & Mathew Koma","Virtual Riot", "2016-02-03",220, img5));

				for(int i = 0; i < canciones.size(); i++){
					pintaCancion(canciones.get(i).getTitulo(),canciones.get(i).artista,canciones.get(i).album,canciones.get(i).fecha,String.valueOf(canciones.get(i).duracion));
				}
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
				System.out.println("ORDENAR POR FECHA");
				for(JLabel jl: lista){
					remove(jl);
				}repaint();
				lista = new ArrayList<JLabel>();
				numCanciones = 0;
				Image img1 = new ImageIcon("Images/Savagelove.PNG").getImage();
				Image img2 = new ImageIcon("Images/ChillDay.PNG").getImage();
				Image img3 = new ImageIcon("Images/Cloudsurfing.PNG").getImage();
				Image img4 = new ImageIcon("Images/Chill.PNG").getImage();
				Image img5 = new ImageIcon("Images/Emotional.PNG").getImage();
				canciones = new ArrayList<Cancion>();
				canciones.add(new Cancion("songs/DrewsThatDude.mp3","Chill", "Drews that dude","Trey songs", "2015-08-5",272, img4));
				canciones.add(new Cancion("songs/Cloudsurfing.mp3","Cloudsurfing", "Omniboi","Uknown", "2015-05-18",220, img3));
				canciones.add(new Cancion("songs/Emotional(VirtualRiotRemix).mp3","Emotional", "Flux Pavillion & Mathew Koma","Virtual Riot", "2016-02-03",220, img5));
				canciones.add(new Cancion("songs/ChillDay.mp3","Chill Day", "DrewsThatDude","Inspired", "2020-09-09",272, img2));
				canciones.add(new Cancion("songs/AlanWalkerStyle-SavageLove(NewSong2020).mp3","Savage Love", "Alan Walker","Greatest hits", "2021-07-09",213, img1));
				for(int i = 0; i < canciones.size(); i++){
					pintaCancion(canciones.get(i).getTitulo(),canciones.get(i).artista,canciones.get(i).album,canciones.get(i).fecha,String.valueOf(canciones.get(i).duracion));
				}
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
				System.out.println("ORDENAR POR DURACION");
				//Order the array of current songs based on the duration of each song.
				for(JLabel jl: lista){
					remove(jl);
				}repaint();
				lista = new ArrayList<JLabel>();
				numCanciones = 0;
				Image img1 = new ImageIcon("Images/Savagelove.PNG").getImage();
				Image img2 = new ImageIcon("Images/ChillDay.PNG").getImage();
				Image img3 = new ImageIcon("Images/Cloudsurfing.PNG").getImage();
				Image img4 = new ImageIcon("Images/Chill.PNG").getImage();
				Image img5 = new ImageIcon("Images/Emotional.PNG").getImage();
				canciones = new ArrayList<Cancion>();
				canciones.add(new Cancion("songs/AlanWalkerStyle-SavageLove(NewSong2020).mp3","Savage Love", "Alan Walker","Greatest hits", "2021-07-09",213, img1));
				canciones.add(new Cancion("songs/Emotional(VirtualRiotRemix).mp3","Emotional", "Flux Pavillion & Mathew Koma","Virtual Riot", "2016-02-03",220, img5));
				canciones.add(new Cancion("songs/Cloudsurfing.mp3","Cloudsurfing", "Omniboi","Uknown", "2015-05-18",220, img3));
				canciones.add(new Cancion("songs/DrewsThatDude.mp3","Chill", "Drews that dude","Trey songs", "2015-08-5",272, img4));
				canciones.add(new Cancion("songs/ChillDay.mp3","Chill Day", "DrewsThatDude","Inspired", "2020-09-09",272, img2));

				for(int i = 0; i < canciones.size(); i++){
					pintaCancion(canciones.get(i).getTitulo(),canciones.get(i).artista,canciones.get(i).album,canciones.get(i).fecha,String.valueOf(canciones.get(i).duracion));
				}
			}
		});
	  this.add(this.duracion);
	  //Example of showing a song.
	  /**pintaCancion("Amor prohibido", "Selena", "Amor prohibido", "2020-07-09", "2:53");
	  pintaCancion("Amor prohibido", "Selena", "Amor prohibido", "2020-07-09", "2:53");
	  pintaCancion("Amor prohibido", "Selena", "Amor prohibido", "2020-07-09", "2:53");
	  pintaCancion("Amor prohibido", "Selena", "Amor prohibido", "2020-07-09", "2:53");
	  pintaCancion("Amor prohibido", "Selena", "Amor prohibido", "2020-07-09", "2:53");
	  pintaCancion("Amor prohibido", "Selena", "Amor prohibido", "2020-07-09", "2:53");**/
	  //AGREGAR CANCIONES AL ARRAYLIST Y LLAMAR A PINTA-CANCION
	  //String ruta, String titulo, String artista, String album, Date fecha, long duracion, Image imagen
	  Image img1 = new ImageIcon("Images/Savagelove.PNG").getImage();
	  Image img2 = new ImageIcon("Images/ChillDay.PNG").getImage();
	  Image img3 = new ImageIcon("Images/Cloudsurfing.PNG").getImage();
	  Image img4 = new ImageIcon("Images/Chill.PNG").getImage();
	  Image img5 = new ImageIcon("Images/Emotional.PNG").getImage();
	  canciones.add(new Cancion("songs/AlanWalkerStyle-SavageLove(NewSong2020).mp3","Savage Love", "Alan Walker","Greatest hits", "2021-07-09",213, img1));
	  canciones.add(new Cancion("songs/ChillDay.mp3","Chill Day", "DrewsThatDude","Inspired", "2020-09-09",272, img2));
	  canciones.add(new Cancion("songs/Cloudsurfing.mp3","Cloudsurfing", "Omniboi","Uknown", "2015-05-18",220, img3));
	  canciones.add(new Cancion("songs/DrewsThatDude.mp3","Chill", "Drews that dude","Trey songs", "2015-08-5",272, img4));
	  canciones.add(new Cancion("songs/Emotional(VirtualRiotRemix).mp3","Emotional", "Flux Pavillion & Mathew Koma","Virtual Riot", "2016-02-03",220, img5));

	  for(int i = 0; i < canciones.size(); i++){
	  	pintaCancion(canciones.get(i).getTitulo(),canciones.get(i).artista,canciones.get(i).album,canciones.get(i).fecha,String.valueOf(canciones.get(i).duracion));
	  }
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
		  lista.add(fila[i]);
		  for(JLabel jl: this.lista){
		  	this.add(jl);
		  }
	  }
	  this.numCanciones++;
  }

}