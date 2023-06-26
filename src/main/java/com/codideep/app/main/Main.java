package com.codideep.app.main;

import com.codideep.app.object.Meteor;
import com.codideep.app.object.Ship;
import com.codideep.app.process.ShipProcess;
import com.codideep.app.view.FrmGeneral;
import com.codideep.app.process.MeteorProccess;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;


public class Main {

    public static void main(String[] args) {
        FrmGeneral frmGeneral = new FrmGeneral();

        frmGeneral.setExtendedState(JFrame.MAXIMIZED_BOTH);

        frmGeneral.setVisible(true);

        Ship ship = new Ship();
        List<Meteor> meteors = new LinkedList();
        for(var i = 0 ; i < 20 ; ++i){
          var meteor = new Meteor();
          meteors.add(meteor);
          frmGeneral.add(meteor.component);
        }

        frmGeneral.add(ship.component);
 
        frmGeneral.repaint();
        new MeteorProccess(meteors).start();
        new ShipProcess(ship).start();
    }
}
