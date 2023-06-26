
package com.codideep.app.util;

import java.util.concurrent.ThreadLocalRandom;
import javax.swing.ImageIcon;

public class Util {
 public static ImageIcon getGIFFromPath(String path, int width, int height){
   ImageIcon gif = new ImageIcon(path);
   return new ImageIcon(gif.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_DEFAULT));
 }
 
 public static int getRandomNumber(int min, int max){
   return ThreadLocalRandom.current().nextInt(min, max + 1);
 }
 
 public static boolean lucky(int percent){
   int luckyNumber = Util.getRandomNumber(0,100);
   return luckyNumber >= 0 && luckyNumber <= percent;
 }
}
