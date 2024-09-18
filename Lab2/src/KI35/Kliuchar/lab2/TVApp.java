/** 
 * lab 2 package 
 */ 
package KI35.Kliuchar.lab2; 
 
import static java.lang.System.out; 
import java.io.*;

import KI35.Kliuchar.lab2.TV.RemoteControl;
import KI35.Kliuchar.lab2.TV.Screen;
 
/** 
 * Computer Mouse Application class implements main method for  
 * ComputerMouse class abilities demonstration 
*/ 
public class TVApp  
{ 
 
 /** 
  * @param args 
 * @throws IOException 
  */ 
 public static void main(String[] args) throws IOException 
 { 
  // TODO Auto-generated method stub 
	 TV screen1= new TV();
	 Screen z1 = screen1.new Screen();
	 screen1.powerOnOff();
	 screen1.powerOnOff();
	 z1.setSizeX(10);
	 screen1.changeChannel(10);
	 screen1.powerOnOff();
	 screen1.changeChannel(10);
	 screen1.changeChannel(10000);
	 screen1.decreaseVolume(10000);
	 screen1.decreaseVolume(10000);
	 screen1.increaseVolume(50);
	 screen1.decreaseVolume(10);
	 screen1.setVolume(35);
	 screen1.mute();
	 screen1.unmute();
	 screen1.checkSignalStrength();
	 screen1.move(1000);
	 screen1.checkSignalStrength();
	 screen1.move(-1100);
	 screen1.checkSignalStrength();
	 screen1.simulateSignalLoss();
	 screen1.checkSignalStrength();
 } 
 
} 