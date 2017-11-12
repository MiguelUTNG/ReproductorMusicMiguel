/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

/**
 * @author Miguel
 * @version 1.0
 */
public class MP3 {

    private String filename;
    private Player player;

    public MP3(String filename) {
        this.filename = filename;
    }

    public void close() {
        if (player != null) {
            player.close();
        }
    }

    public void play() {
        try {
            FileInputStream fia = new FileInputStream(filename);
            BufferedInputStream bis = new BufferedInputStream(fia);
            player = new Player(bis);
        } catch (Exception e) {
            System.err.println("Error al cargar archivo ");
            System.err.println(e.getMessage());
        }
        new Thread() {
            public void run() {
                try {
                    player.play();
                } catch (Exception e) {
                    System.err.println("Error al intentar reproducir ");
                }
            }
        }.start();
    }
}
