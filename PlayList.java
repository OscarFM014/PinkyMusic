import com.sun.jdi.*;
import com.sun.jdi.ThreadReference;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.swing.*;
import java.util.*;


public class PlayList{
  private String nombre;
  private ArrayList<Cancion> listaCanciones;
  private int duracionTotal;

  public PlayList(String nombre, ArrayList<Cancion> listaCanciones, int duracionTotal){
    this.nombre = nombre;
    this.listaCanciones = listaCanciones;
    this.duracionTotal = duracionTotal;
  }

  public void eliminarCancion(Cancion song){
	  this.listaCanciones.remove(song);
  }

  public void agregarCancion(Cancion song){
	  this.listaCanciones.add(song);
    
  }
  
  
  public void sufflePlaylist() {
	  Collections.shuffle(this.listaCanciones);
	  System.out.println(this.listaCanciones.toString());
  }
}