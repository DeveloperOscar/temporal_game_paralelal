
package com.codideep.app.object;

import com.codideep.app.util.Util;
import com.codideep.app.generic.ObjectAttribute;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Ship extends ObjectAttribute {

    private ImageIcon imageIconFront = null;
    private ImageIcon imageIconLeft = null;
    private ImageIcon imageIconRight = null;
    private ImageIcon imageIconDestroy = null;

    public static String move = null;/*static, left, right*/

    public Ship() {
        this.component = new JLabel();
        this.move = "static";
        this.speed = 5;
        this.dimension[0] = 80;
        this.dimension[1] = 100;

        java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        this.position[0] = (screenSize.width / 2) - (this.dimension[0] / 2);
        this.position[1] = screenSize.height - (this.dimension[1] + 50);

        imageIconFront = Util.getGIFFromPath("/home/oscar/Downloads/ship/front.gif", this.dimension[0], this.dimension[1]);
        imageIconLeft = Util.getGIFFromPath("/home/oscar/Downloads/ship/left.gif",this.dimension[0], this.dimension[1]);
        imageIconRight = Util.getGIFFromPath("/home/oscar/Downloads/ship/right.gif",this.dimension[0], this.dimension[1]);
        imageIconDestroy = Util.getGIFFromPath("/home/oscar/Downloads/ship/boom.gif",this.dimension[0], this.dimension[1]);

        this.component.setBounds(this.position[0], this.position[1], this.dimension[0], this.dimension[1]);
        this.setImageFront();
    }

    public void moveLeft() {
        position[0] -= this.speed;
        component.setBounds(position[0], position[1], dimension[0], dimension[1]);
    }
    
    public void moveRight() {
        position[0] += this.speed;
        this.component.setIcon(this.imageIconRight);
        component.setBounds(position[0], position[1], dimension[0], dimension[1]);
    }

    public void setImageFront() {
        this.component.setIcon(imageIconFront);
    }

    public void setImageLeft() {
        this.component.setIcon(imageIconLeft);
    }

    public void setImageRight() {
        this.component.setIcon(imageIconRight);
    }

    public void setImageDestroy() {
        this.component.setIcon(imageIconDestroy);
    }
}
