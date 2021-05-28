import com.sun.jdi.ThreadGroupReference;
import com.sun.jdi.ThreadReference;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Date;

public class Cancion{
  boolean playing;
  boolean pausado = false;
  long pause;
  boolean repetir = false;
  Player player;
  Thread playThread;
  Thread resumeThread;
  FileInputStream fileInputStream;
  BufferedInputStream bufferedInputStream;
  private String rutaArchivo;
  private String titulo;
  private String artista;
  private String album;
  private Date fecha;
  private long duracion;
  private double velocidad;
  private Image foto;
  private double volumen;

    public Cancion(String rutaArchivo) {
        this.rutaArchivo = new String(rutaArchivo);
        playThread = new Thread(runnablePlay);
        resumeThread = new Thread(runnableResume);
    }
    public Cancion(){}

    public Cancion(String titulo, String artista, String album, Date fecha, long duracion){
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.fecha = fecha;
        this.duracion = duracion;
        this.volumen = 50;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public void reproducir(){
        if(!pausado){
            playThread.start();
            System.out.println("REPRODUCIENDO MUSICA");
            playing = true;
        }
        else{
            resumeThread.start();
        }

    }
  public void stop(){
        if(player != null){
            player.close();
        }
  }

  public void pausar(){
     if(player != null){
         try {
             playing = false;
             pausado = true;
             pause=fileInputStream.available();
             player.close();
         } catch (IOException e1) {
             e1.printStackTrace();
         }
     }
  }
  public void repetir(){
        repetir = true;
        while(repetir){
            runnablePlay.run();
        }

  }
  public void noRepetir(){
        this.repetir = false;
  }
  public void modificarVelocidad(double nuevaVelocidad){

  }
  Runnable runnablePlay = new Runnable() {
    @Override
    public void run() {
        try {
            //code for play button
            fileInputStream=new FileInputStream(rutaArchivo);
            bufferedInputStream=new BufferedInputStream(fileInputStream);
            player=new Player(bufferedInputStream);
            duracion=fileInputStream.available();
            player.play();//starting music
        } catch (JavaLayerException | IOException e) {
            e.printStackTrace();
        }
    }
    };
  Runnable runnableResume=new Runnable() {
    @Override
    public void run() {
        try {

            //code for resume button
            fileInputStream=new FileInputStream(rutaArchivo);
            bufferedInputStream=new BufferedInputStream(fileInputStream);
            player=new Player(bufferedInputStream);
            fileInputStream.skip(duracion-pause);
            player.play();
        } catch (JavaLayerException | IOException e) {
            e.printStackTrace();
        }
    }
    };
  public static void main(String[] args) throws InterruptedException {

        String filename = "songs/prueba2.mp3";
        Cancion song = new Cancion(filename);
        song.reproducir();
        for(int i = 0; i < 10000000; i++){
            System.out.println(i);
        }
        System.out.println("PAUSE");
        song.pausar();
      for(int i = 0; i < 100000; i++){
          System.out.println(i);
      }
      song.repetir();



  }

}