package presentation;

import business.QRCodeGenerator;
import com.google.zxing.WriterException;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class QRCodeShower {

    private JFrame frame;
    private QRCodeGenerator qrCodeGenerator;

    public QRCodeShower(){
        qrCodeGenerator = new QRCodeGenerator(350,350);
    }

     public static void main(String[] args){
        QRCodeShower qrcs = new QRCodeShower();

         BufferedImage qrCode = null;
         try {
             qrCode = qrcs.qrCodeGenerator.generateQRCodeImage("This is my first QR Code");
         }catch(IOException | WriterException e) {
             e.printStackTrace();
         }

        qrcs.frame = new JFrame();
        qrcs.frame.getContentPane().setLayout(new FlowLayout());
        qrcs.frame.getContentPane().add(new JLabel(new ImageIcon(qrCode)));
        qrcs.frame.pack();
        qrcs.frame.setVisible(true);
        qrcs.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // if you want the X button to close the app


    }
}
