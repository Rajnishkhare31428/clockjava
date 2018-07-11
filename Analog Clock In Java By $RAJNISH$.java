import java.io.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.Math;
import java.applet.*;
import java.awt.datatransfer.*;
import java.util.*;
class cuboid_sample extends Frame implements WindowListener,MouseListener,MouseMotionListener
      {
Graphics ga = getGraphics();
tmr t;
public cuboid_sample()
  {
MenuBar menu_bar = new MenuBar();
Menu mnufile = new Menu("File");
MenuItem mnustop = new MenuItem("Stop");
mnufile.add(mnustop);
mnustop.addActionListener(new AL_Event_mnustop());
MenuItem mnuStart = new MenuItem("Start");
mnufile.add(mnuStart);
mnuStart.addActionListener(new AL_Event_mnuStart());
MenuItem mnuexit = new MenuItem("Exit");
mnufile.add(mnuexit);
mnuexit.addActionListener(new AL_Event_mnuexit());
menu_bar.add(mnufile);
setMenuBar(menu_bar);
//setLayout(null);

addMouseListener(this);
addWindowListener(this);
addMouseMotionListener(this);
setBackground(new Color(0,0,0));
setTitle("rajnishkhare3.1428@gmail.com");
setSize(400, 450);
setVisible(true);

t = new tmr();
t.setPriority(1);
t.start();
  }

public void windowClosing(WindowEvent closingframe)
   {
System.exit(0);
    }
public void windowActivated(WindowEvent eve){}
public void windowIconified(WindowEvent eve){}
public void windowOpened(WindowEvent eve){}
public void windowClosed(WindowEvent eve){}
public void windowDeactivated(WindowEvent eve){}
public void windowDeiconified(WindowEvent eve){}
public void mouseMoved(MouseEvent mouse_moved){}
public void mouseClicked(MouseEvent mouse_click){}
public void mouseExited(MouseEvent mouse_exited){}
public void mouseEntered(MouseEvent mouse_entered){}

//
public void mousePressed(MouseEvent mouse_press_eve)
      {
  
       }
public void mouseDragged(MouseEvent mouse_drag_eve)
      {
  
       }
public void mouseReleased(MouseEvent mouse_release_eve)
      {
  
       }

public static void main(String Args[])
	{
cuboid_sample ma = new cuboid_sample();

	}
////////////////////////////////////////////////////////////////////////////////////////////////
class AL_Event_mnustop implements ActionListener
   {      //Code Begins For Stop
public void actionPerformed(ActionEvent e) 
       {
t.stop();
       }
   }  // Code Ends For Stop
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
class AL_Event_mnuStart implements ActionListener
   {      //Code Begins For Start
public void actionPerformed(ActionEvent e) 
       {
t = new tmr();
t.start();
       }
   }  // Code Ends For Start
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
class AL_Event_mnuexit implements ActionListener
   {      //Code Begins For Exit
public void actionPerformed(ActionEvent e) 
       {
System.exit(0);
       }
   }  // Code Ends For Exit
////////////////////////////////////////////////////////////////////////////////////////////////

class tmr extends Thread {
Date dt = new Date();

int rad = 250;
 int sec=dt.getSeconds();
 int min=dt.getMinutes();
 int hr=dt.getHours();
int cx=200;
int cy=250;


public void run() {
 double an_hr=0;
 double an_min=0;
 double an_sec=0;

 int rad_hr=120;
 int rad_min=150;
 int rad_sec=150;

double Rad=350;
double pi = Math.PI;
Graphics ga = getGraphics();
int i=0;
int dx[];
int dy[];
 boolean started=false;



while (i!=410)
 {
try 
     {
sec = sec + 1;
 if (sec>=60) {
min=min + 1;
sec=-0;
}
 if (min>=60) {
hr=hr + 1;
min=0;
    }

int j=0;
int k;
for (j=0;j!=360;j=j+15)
  {
k=j % 30;
if (k==0) {
ga.setColor(Color.white);
ga.fillRect((int)(cx + rad_sec * Math.sin(j*pi/180)-5),(int)(cy + rad_sec * Math.cos(j*pi/180)-5),10,10); 
ga.setColor(Color.magenta);
ga.fillRect((int)(cx + rad_sec * Math.sin(j*pi/180)-3),(int)(cy + rad_sec * Math.cos(j*pi/180)-3),6,6); 

}
else {
ga.setColor(Color.white);
ga.fillRect((int)(cx + rad_sec * Math.sin(j*pi/180)-3),(int)(cy + rad_sec * Math.cos(j*pi/180)-3),6,6); 
ga.setColor(Color.black);
ga.fillRect((int)(cx + rad_sec * Math.sin(j*pi/180)-2),(int)(cy + rad_sec * Math.cos(j*pi/180)-2),4,4); 
}
//System.out.println("Current Value Of j is :" + j); 
  }
an_hr = (30 * (hr+((double)min/60))*pi/180); 
an_min = 6 * min * pi/180;
an_sec = 6 * sec * pi/180;
if (started==true) {
sleep(1000);

}
if (started==false) {
started=true;
}


ga.clearRect(0,0,600,600);

ga.setColor(new Color(150,150,150));
// programing for Hour Hand
int pdx_hr[] = new int[4];
int pdy_hr[] = new int[4];

pdx_hr[0] = (int)(cx + rad_hr * Math.sin(an_hr * -1 + pi));
pdx_hr[1] = (int)(cx + rad_hr * 0.12 * Math.sin(an_hr * -1+pi/2 + pi));
pdx_hr[2] = (int)(cx + rad_hr * 0.22  * Math.sin(an_hr * -1+2*pi/2 + pi));
pdx_hr[3] = (int)(cx + rad_hr * 0.12  * Math.sin(an_hr * -1+3*pi/2 + pi));

pdy_hr[0] = (int)(cy + rad_hr * Math.cos(an_hr * -1 + pi));
pdy_hr[1] = (int)(cy + rad_hr * 0.12 * Math.cos(an_hr * -1+pi/2 + pi));
pdy_hr[2] = (int)(cy + rad_hr * 0.22 * Math.cos(an_hr * -1+2*pi/2 + pi));
pdy_hr[3] = (int)(cy + rad_hr * 0.12 * Math.cos(an_hr * -1+3*pi/2 + pi));
ga.fillPolygon(pdx_hr ,pdy_hr ,4);

// programing for minute hand 
int pdx_min[] = new int[4];  
int pdy_min[] = new int[4];
ga.setColor(new Color(180,180,190));
pdx_min[0] = (int)(cx + rad_min * Math.sin(an_min * -1 + pi));
pdx_min[1] = (int)(cx + rad_min * 0.07 * Math.sin(an_min * -1+pi/2 + pi));
pdx_min[2] = (int)(cx + rad_min * 0.2  * Math.sin(an_min * -1+2*pi/2 + pi));
pdx_min[3] = (int)(cx + rad_min * 0.07  * Math.sin(an_min * -1+3*pi/2 + pi));

pdy_min[0] = (int)(cy + rad_min * Math.cos(an_min * -1 + pi));
pdy_min[1] = (int)(cy + rad_min * 0.07 * Math.cos(an_min * -1+pi/2 + pi));
pdy_min[2] = (int)(cy + rad_min * 0.2 * Math.cos(an_min * -1+2*pi/2 + pi));
pdy_min[3] = (int)(cy + rad_min * 0.07 * Math.cos(an_min * -1+3*pi/2 + pi));
ga.fillPolygon(pdx_min ,pdy_min ,4);

// Programing for second hand
int pdx_sec[] = new int[4];
int pdy_sec[] = new int[4];
ga.setColor(Color.white);

pdx_sec[0] = (int)(cx + rad_sec * 0.8 * Math.sin(an_sec * -1 + pi));
pdx_sec[1] = (int)(cx + rad_sec * 0.05 * Math.sin(an_sec * -1+pi/2 + pi));
pdx_sec[2] = (int)(cx + rad_sec * 0.25  * Math.sin(an_sec * -1+2*pi/2 + pi));
pdx_sec[3] = (int)(cx + rad_sec * 0.05  * Math.sin(an_sec * -1+3*pi/2 + pi));

pdy_sec[0] = (int)(cy + rad_sec * 0.8 * Math.cos(an_sec * -1 + pi));
pdy_sec[1] = (int)(cy + rad_sec * 0.05 * Math.cos(an_sec * -1+pi/2 + pi));
pdy_sec[2] = (int)(cy + rad_sec * 0.25 * Math.cos(an_sec * -1+2*pi/2 + pi));
pdy_sec[3] = (int)(cy + rad_sec * 0.05 * Math.cos(an_sec * -1+3*pi/2 + pi));

ga.fillPolygon(pdx_sec,pdy_sec,4);

// Graphics starts here 

System.out.println(hr + " : " + min + " : "   + sec);   
    }
catch(Exception e)
     {
System.out.println("Error Occured " + e); 
     }
if (i>=360){i=0;}
i=i+1;

 }

  }

}

  //do main loop

 }
