package Ver_3_7;



/* Ch4Tz - Ver 3.6 - Build 08012011
 * MultiClient Chatting
 * By:
 * Gredie Hafiz - 1006683053
 * Muhammad Anugerah Gunawan - 1006683141
 * 
 * Program ini dibuat untuk memenuhi kriteria kelulusan mata kuliah Object Oriented Programming oleh Prof. Dr.-Ing. Ir. Kalamullah Ramli, M.Eng
 * 
 * Deskripsi:
 * Program ini adalah program chatting multiclient dengan satu server terdedikasi dan klien hingga 100 klien yang semuanya dapat saling berkomunikasi
 * Program chat ini juga dapat memperbolehkan klien mengupload file ke server atau klien tergantung ip yang dimasukkan
 * Program ini adalah bagian server GUI
 */

import java.awt.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.*;
import java.lang.*;


public class GuiServer extends JFrame implements Runnable{
    int Token=0,port=0,LastToken;

    private javax.swing.JLabel Action;
    private javax.swing.JButton ConfigButton;
    private javax.swing.JButton ConnectButton;
    private javax.swing.JButton DisconnectButton;
    private javax.swing.JLabel SeverStatus;
    public javax.swing.JTextArea StatusArea;
    private javax.swing.JTextField StatusField;
    private javax.swing.JLabel Title;
    private javax.swing.JLabel Version;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private static Socket client = null;
    private static ServerSocket serverSocket = null;
    private static ObjectInputStream is = null;
    private static ObjectOutputStream os = null;
    private String host = "localhost";//127.0.0.1
     String Test,Name;  
    ServerSocket server[]= new ServerSocket[99];
    BufferedReader br[]= new BufferedReader[99];
    BufferedWriter bw[]= new BufferedWriter[99];    
    Socket socket[]= new Socket[99];


    public GuiServer() {

        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        SeverStatus = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        StatusArea = new javax.swing.JTextArea();
        StatusField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        ConnectButton = new javax.swing.JButton();
        DisconnectButton = new javax.swing.JButton();
        ConfigButton = new javax.swing.JButton();
        Action = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        Version = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SeverStatus.setText("Server status:");

        StatusArea.setColumns(20);
        StatusArea.setEditable(false);
        StatusArea.setRows(5);
        jScrollPane1.setViewportView(StatusArea);

        StatusField.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(SeverStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StatusField, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SeverStatus)
                    .addComponent(StatusField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
        );

        ConnectButton.setText("Connect");
        ConnectButton.setActionCommand("ConnectButton");
        ConnectButton.setName("ConnectButton"); // NOI18N
        ConnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConnectButtonActionPerformed(evt);
            }
        });

        DisconnectButton.setText("Disconnect");
        DisconnectButton.setActionCommand("DisconnectButton");
        DisconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisconnectButtonActionPerformed(evt);
            }
        });

        ConfigButton.setText("Ping Client!");
        ConfigButton.setToolTipText("");
        ConfigButton.setActionCommand("ConfigButton");
        ConfigButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfigButtonActionPerformed(evt);
            }
        });

        Action.setText("Action:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ConnectButton, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                            .addComponent(DisconnectButton, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                            .addComponent(ConfigButton, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(Action)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Action)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ConnectButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DisconnectButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ConfigButton)
                .addContainerGap())
        );

        ConnectButton.getAccessibleContext().setAccessibleName("ConnectButton");
        DisconnectButton.getAccessibleContext().setAccessibleName("DisconnectButton");
        ConfigButton.getAccessibleContext().setAccessibleName("ConfigButton");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 115, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        Title.setBackground(new java.awt.Color(255, 255, 255));
        Title.setFont(new java.awt.Font("Tahoma", 0, 24));
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Ch4Tz Server");

        Version.setText("Ver. 3.6 Beta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(13, 13, 13)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Version)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Version))
                    .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, 0, 122, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        StatusArea.append("Server started...\n Waiting command to connect...\n");
    }// </editor-fold>

private void DisconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 

         System.out.println("Pinging");
    int param=Token;
    Token=LastToken;
    int count=1;
    while(count<=LastToken){
    try{  
    bw[Token].write("U're disconnected");System.out.println("nice");
    bw[Token].newLine();
    bw[Token].flush();
    
    }
    catch(Exception e){
    }
    
    StatusArea.append("Closing server...\n");    
    try{
         bw[Token].close();
        br[Token].close();
        socket[Token].close();
        server[Token].close();   
       
        
    }
    catch (Exception e){            
    }
    Token--;
    count++;
    StatusArea.append("Closing socket "+Token+"\n");
    }
    Token=param;

    StatusArea.append("Server is offline...\n");
    StatusField.setText("Offline");
    Token=1;
    port=0;
}

private void ConfigButtonActionPerformed(java.awt.event.ActionEvent evt) {
     System.out.println("Pinging");
    int param=Token;
    Token=LastToken;
    int count=1;
    while(count<=LastToken){
    Name=("Server");
    try{
    bw[Token].write(Name+": PING!!");
    bw[Token].newLine();
    bw[Token].flush();
    System.out.println("Ping token "+Token);
    }

    catch (Exception e){System.out.println("Failed pinging "+Token);}      
    Token--;
    count++;
    System.out.println("Succeeded in pinging, add Token and count to"+Token+
            " "+count);
    }
    Token=param;
}
private void ConnectButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 

     port++;
    Token++;
    if(LastToken<=Token){
    LastToken=Token;
    }
    StatusArea.append("Server is listening...\n");
    System.out.println(port+"   "+Token);
    

    connection();

    
    try{ bw[Token].write("##############################\n");System.out.println("nice");
    bw[Token].newLine();
    bw[Token].flush();
    }
    catch (Exception e){System.out.println("Bad");}
    
    try{ bw[Token].write("Connected to "+ socket[Token].getInetAddress()+" : "+socket[Token].getLocalPort()+"\n");
    bw[Token].newLine();
    bw[Token].flush();
    }
    catch (Exception e){System.out.println("Bad");}
    
    try{ bw[Token].write("U're connected to server, enjoy~!\n");System.out.println("nice");
    bw[Token].newLine();
    bw[Token].flush();
    }
    catch (Exception e){System.out.println("Bad");}
    
    StatusField.setText("Online");
}                                                
        



  
    public void connection(){
        System.out.println("11111");


    try { 
    StatusArea.append("User Number: "+port+" Is online \n");
    System.out.println(port+" 2  "+Token);
    server[Token] = new ServerSocket(port);
        server[Token].setSoTimeout(15000);    
		socket[Token]=server[Token].accept(); System.out.println("bbbbbb");
		br[Token] = new BufferedReader(new InputStreamReader(socket[Token].getInputStream()));

                bw[Token] = new BufferedWriter(new OutputStreamWriter(socket[Token].getOutputStream()));
                Thread th;
                System.out.println(port+" 3  "+Token);
    System.out.println("Creating new token&thread");
                th = new Thread(this);
		th.start();
    System.out.println("Finished creating new thread");



}
    catch(Exception e){
    System.out.println("Socket can't be created");
    StatusArea.append("Failed Estabilishing socket: "+port+"\n");
    //port--;
    Token--;
    System.out.println(port+Token);
    }
    
}
 
   public void run(){
    String text,text2=null;
    int param1=LastToken;
    System.out.println("The last token is"+param1);
    while(true){
    int param=Token;
    Token=LastToken;
    int count=1;
    while(count<=LastToken){
        try{
            
        System.out.println("Waiting data from"+Token);

        text=(br[Token].readLine());
       
                    if(text==null){
                StatusArea.append("User "+ Token+ " has left the air");
                br[Token].close();
                bw[Token].close();
                socket[Token].close();
                server[Token].close();
            }
                    else{

         StatusArea.append(text+"\n");
            System.out.println("Success reading from"+Token);

        

            //-------------------------------
    int param2=Token;
    Token=LastToken;
    int count2=1;
    while(count2<=LastToken){
    try{ text2= text+" ";
    System.out.println("Sending back text to "+Token);
    bw[Token].write(text2+"\n");
    bw[Token].flush();
    System.out.println("Succeeded in sending back data to "+Token);
    }
    catch (Exception e){
    System.out.println("FAIL,decreaseing token and add count"+Token);}
    Token--;
    count2++;
    System.out.println("Success adding token to "+Token);
    }
    Token=param2;
            
            //------------------------------
            }             
        }
            catch(Exception e){
            System.out.println("Failed to append text");
            }

        Token--;
        count++;
        System.out.println("Token run"+ Token);
        }

    System.out.println("Exit from running" +count);
    }

}
   
 
  static class FileTransfer extends Thread{
    	@Override
    public void run(){
try{
    		while(true){
        ServerSocket  server = new ServerSocket (6789);

        /* Accept the sk */

        Socket  sk = server.accept();
        
        System.out.println("Server accepted client");
        InputStream  input = sk.getInputStream();
        BufferedReader  inReader = new BufferedReader (new InputStreamReader (sk.getInputStream()));
        BufferedWriter  outReader = new BufferedWriter (new OutputStreamWriter (sk.getOutputStream()));

        /* Read the filename */
        String  filename = inReader.readLine();

       
        if ( !filename.equals("") ){
            /* Reply back to client with READY status */

            outReader.write("READY\n");
            outReader.flush();
        

        /* Create a new file in the tmp directory using the filename */
        FileOutputStream  wr = new FileOutputStream (new File ("C://temp/" + filename));

        byte[] buffer = new byte[sk.getReceiveBufferSize()];

        int bytesReceived = 0;

        while((bytesReceived = input.read(buffer))>0)
        {
            /* Write to the file */
           wr.write(buffer,0,bytesReceived);
        }}
        inReader.close();
        outReader.close();
        sk.close();
    		}
    }catch(Exception dd){}
}}

   

    public static void main(String args[]) {


        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new GuiServer().setVisible(true);
                            }
        });
{  FileTransfer ft=new FileTransfer();
	ft.start();}
      
    }
    


}