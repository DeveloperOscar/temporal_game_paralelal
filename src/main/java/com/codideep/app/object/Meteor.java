package com.codideep.app.object;

import com.codideep.app.generic.ObjectAttribute;
import com.codideep.app.util.Util;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Meteor extends ObjectAttribute {

  private ImageIcon icon = null;

  public Meteor() {
    this.component = new JLabel();
    this.speed = 5;
    this.dimension[0] = 80;
    this.dimension[1] = 100;
    this.destroy();
    this.icon = Util.getGIFFromPath("/home/oscar/Downloads/ship/meteor.gif", this.dimension[0], this.dimension[1]);
    this.component.setIcon(icon);
  }

  public void setPosition(int x, int y) {
    this.position[0] = x;
    this.position[1] = y;
    this.component.setBounds(this.position[0], this.position[1], this.dimension[0], this.dimension[1]);
  }

  public void destroy() {
    this.position[0] = -150;
    this.position[1] = -150;
    this.component.setBounds(this.position[0], this.position[1], this.dimension[0], this.dimension[1]);
  }

  public boolean isDestroyed() {
    return this.position[0] <= 0 || this.position[1] <= 0;
  }

  public void moveDown() {
    this.position[1] += this.speed;
    this.component.setBounds(position[0], position[1], dimension[0], dimension[1]);
  }

}
