import com.sun.jdi.*;
import com.sun.jdi.ThreadReference;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.swing.*;
import java.util.*;


public class PlayList{
  private String nombre;
  private ArrayList<Cancion> listaCanciones;
  private long duracionTotal;

  public PlayList(String nombre, ArrayList<Cancion> listaCanciones){
    this.nombre = nombre;
    this.listaCanciones = listaCanciones;
    this.duracionTotal = getTotalTimePlaylist(listaCanciones);
  }

  public void eliminarCancion(Cancion song){
	  this.listaCanciones.remove(song);
  }

  public void agregarCancion(Cancion song){
	  this.listaCanciones.add(song);
    
  }
  
  private long getTotalTimePlaylist(ArrayList<Cancion> listaCanciones) {
	  long result = 0;
	  for (int i = 0; i < listaCanciones.size(); i++) {
		  result = result + listaCanciones.get(i).duracion;
	  }
	  return result;
  }
  
  public void sufflePlaylist() {
	  Collections.shuffle(this.listaCanciones);
	  System.out.println(this.listaCanciones.toString());
  }
}