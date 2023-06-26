package com.codideep.app.process;

import com.codideep.app.object.Meteor;
import com.codideep.app.util.Util;
import java.awt.Toolkit;
import static java.lang.Thread.sleep;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MeteorProccess extends Thread {

  List<Meteor> meteors;

  public MeteorProccess(List<Meteor> meteors) {
    this.meteors = meteors;
  }

  @Override
  public void run() {
    java.awt.Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    while (true) {
      // inicializando
      for (var meteor: meteors) {
        int x = Util.getRandomNumber(5,screen.width - 50);
        int y = Util.getRandomNumber(5, (int) (screen.height * 0.1));
        if (meteor.isDestroyed() && Util.lucky(1)) {
          meteor.setPosition(x, y);
        }
        
      }

      for (var meteor: meteors) {
        if (meteor.position[1] >= screen.height) {
          meteor.destroy();
        }
        if (!meteor.isDestroyed()) {
          meteor.moveDown();
        }
      }

      try {
        sleep(40);
      } catch (InterruptedException ex) {
        Logger.getLogger(ShipProcess.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
}
