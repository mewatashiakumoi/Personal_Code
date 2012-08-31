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
 * Program ini adalah bagian client GUI
 */
 

import javax.swing.JFileChooser;
import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.lang.*;
import javax.*;
import java.awt.*;
import java.awt.event.*;

public class GUIMain extends javax.swing.JFrame implements Runnable {
    
    public javax.swing.JTextArea ChatArea;
    private javax.swing.JTextField ChatInput;
    private javax.swing.JButton ConfigButton;
    private javax.swing.JButton ConnectButton;
    private javax.swing.JButton DisconnectButton;
    private javax.swing.JTextField FileInput;
    private javax.swing.JLabel OnlineLabel;
    private javax.swing.JTextArea OnlineList;
    private javax.swing.JLabel SayLabel;
    private javax.swing.JButton SendButton;
    private javax.swing.JLabel ShareLabel;
    private javax.swing.JTextField StatusField;
    private javax.swing.JLabel StatusLabel;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JButton UploadButton;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private Socket socket;
    public BufferedReader br;
    public BufferedWriter bw;
     static final JFileChooser browser = new JFileChooser();


    /** Creates new form GUIprogram */
    public GUIMain() {
        initComponents();
    }
    
        String login=("Null");
        int Port;
        String IpAddress=("Null");
        String IpAddress2=("Null");


      @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        ChatInput = new javax.swing.JTextField();
        SendButton = new javax.swing.JButton();
        SayLabel = new javax.swing.JLabel();
        ShareLabel = new javax.swing.JLabel();
        FileInput = new javax.swing.JTextField();
        UploadButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ChatArea = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        ConnectButton = new javax.swing.JButton();
        DisconnectButton = new javax.swing.JButton();
        StatusField = new javax.swing.JTextField();
        StatusLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        OnlineList = new javax.swing.JTextArea();
        OnlineLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        TitleLabel = new javax.swing.JLabel();
        ConfigButton = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ch4Tz - Beta Version");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ChatInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChatInputActionPerformed(evt);
            }
        });

        SendButton.setText("Send!");

        SayLabel.setText("Say: ");

        ShareLabel.setText("Share:");

        FileInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileInputActionPerformed(evt);
            }
        });

            UploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadButtonActionPerformed(evt);
            }
        });
            SendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendButtonActionPerformed(evt);
            }
        });            
                
        UploadButton.setText("Upload!");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ShareLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SayLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ChatInput, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FileInput, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(UploadButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SendButton, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ChatInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(SendButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UploadButton)
                    .addComponent(ShareLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FileInput))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ChatArea.setColumns(20);
        ChatArea.setRows(5);
        ChatArea.setEditable(false);
        ChatInput.setEnabled(false);
        FileInput.setEnabled(false);
        SendButton.setEnabled(false);
        UploadButton.setEnabled(false);
        jScrollPane4.setViewportView(ChatArea);
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ConnectButton.setLabel("OnLine!");
        ConnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConnectButtonActionPerformed(evt);
            }
        });

        DisconnectButton.setText("OffLine!");
        DisconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisconnectButtonActionPerformed(evt);
            }
        });

        StatusLabel.setText("Ur Status:");
        StatusField.setEditable(false);
        
        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(ConnectButton, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DisconnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(StatusField, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(StatusLabel))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DisconnectButton)
                    .addComponent(ConnectButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StatusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StatusField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        OnlineList.setColumns(20);
        OnlineList.setEditable(false);
        OnlineList.setLineWrap(true);
        OnlineList.setRows(5);
        jScrollPane5.setViewportView(OnlineList);

        OnlineLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        OnlineLabel.setText("Log:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(OnlineLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(OnlineLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TitleLabel.setBackground(new java.awt.Color(255, 255, 255));
        TitleLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TitleLabel.setText("Ch4Tz! Ver 3.6 Beta --- Your apps to chit-chat---");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleLabel)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(TitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ConfigButton.setText("Config");
        ConfigButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfigButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 659, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ConfigButton, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ConfigButton, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>

public void ChatInputActionPerformed(java.awt.event.ActionEvent evt) {                                          
// TODO add your handling code here:
    String data=login;
    //System.out.println(login);
     try{ 
    bw.write(data+": "+ChatInput.getText());
    bw.newLine();
    bw.flush();
    }
    catch (Exception e){}
 
    String inputchat2 = ChatInput.getText();
//    ChatArea.append(login+": "+inputchat2+"\n");
    ChatInput.setText("");
}                                    
 
public void SendButtonActionPerformed(java.awt.event.ActionEvent evt){
    String data=login;
    //System.out.println(data);
    try{ bw.write(data+": "+ChatInput.getText());
    bw.newLine();
    bw.flush();
    }
    catch (Exception e){}
    String inputchat2 = ChatInput.getText();
 
    ChatInput.setText("");
    

}

private void FileInputActionPerformed(java.awt.event.ActionEvent evt) {                                          

}                                         

public void ConnectButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
// TODO add your handling code here:
         connection();
login = JOptionPane.showInputDialog(null, "What's ur nick?", "Sign-as", 3);
StatusField.setText(login+" Logged in @ "+socket.getInetAddress()+": "+socket.getLocalPort());
ChatArea.setText("Hello! - Enjoy your time with Ch4Tz!\n");
ChatInput.setText("");
FileInput.setText("");
 ChatInput.setEnabled(true);
        FileInput.setEnabled(true);
        SendButton.setEnabled(true);
        UploadButton.setEnabled(true);
        ConnectButton.setEnabled(false);
        DisconnectButton.setEnabled(true);
       OnlineList.setText("");
}                                             

private void DisconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
     try{
        bw.close();
        br.close();
        socket.close();
    }
    catch (Exception e){            
    }
    ChatInput.setEnabled(false);
        FileInput.setEnabled(false);
        SendButton.setEnabled(false);
        UploadButton.setEnabled(false);
        ChatArea.setText("You have Signed off");
        StatusField.setText("");
        DisconnectButton.setEnabled(false);
        ConnectButton.setEnabled(true);
        OnlineList.setText("");
}                                                



private void UploadButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
   JFileChooser  fileDlg = new JFileChooser ();
        fileDlg.showOpenDialog(this);
        IpAddress2 = JOptionPane.showInputDialog(null, "Enter Destination IP Address", "IP Destinator", 3);
        if( "Null".equals(IpAddress2)){
        IpAddress="localhost";}
        String  filename = fileDlg.getSelectedFile().getAbsolutePath();
        FileInput.setText(filename);

        try{

            /* Try to connect to the server on localhost, port 6789 */
            System.out.println("new sock");
            Socket  sk = new Socket (IpAddress2, 6789);System.out.println("aftersock");
            BufferedOutputStream  output = new BufferedOutputStream(sk.getOutputStream());
            System.out.println("bos");
            /* Send filename to server */

            OutputStreamWriter  outputStream = new OutputStreamWriter (sk.getOutputStream());
            outputStream.write(fileDlg.getSelectedFile().getName() + "\n");
            outputStream.flush();

            /* Get reponse from server */

            BufferedReader  inReader = new BufferedReader (new InputStreamReader (sk.getInputStream()));

            String  serverStatus = inReader.readLine(); // Read the first line

            /* If server is ready, send the file */

            if ( serverStatus.equals("READY") ){

                FileInputStream  file = new FileInputStream (filename);
                byte[] buffer = new byte[sk.getSendBufferSize()];

                int bytesRead = 0;

                while((bytesRead = file.read(buffer))>0)
                {
                    output.write(buffer,0,bytesRead);
                }
                output.flush();
                output.close();
                file.close();
                sk.close();
                

                JOptionPane .showMessageDialog(null, "Transfer complete");
                FileInput.setText("");
                
            }
        }
        catch (Exception  ex){
            /* Catch any errors */
           JOptionPane .showMessageDialog(null, "Transfer failed, retry");
           
        }
      
    
              
           
}

private void ConfigButtonActionPerformed(java.awt.event.ActionEvent evt) {
// TODO add your handling code here:
IpAddress = JOptionPane.showInputDialog(null, "Enter server IP Address", "IP Destinator", 3);
Port =Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your user number", "User assigner", 3));


    
}

public void connection(){
    try { socket= new Socket (IpAddress, Port);System.out.println("haha");
    if( "Null".equals(IpAddress)){
        IpAddress="localhost";}
//    bw1= new BufferedWriter (new OutputStreamWriter(socket.getOutputStream()));
    bw= new BufferedWriter (new OutputStreamWriter(socket.getOutputStream()));    
    br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    Thread th;
    th= new Thread(this);
    th.start();} catch (Exception e){System.out.println("heheh");}
}

public void run(){
    while(true){  
        
       try{String w= br.readLine(); 
       
            if( w==null ){
            
                ChatArea.setText("Server Terminated");
                br.close();
                bw.close();
                socket.close();
                
            }
        else{
            
            ChatArea.append(w+ "\n");
            Scanner temp= new Scanner(w);
            String list= temp.next();
            OnlineList.append(list+" acknowledged\n");
 

        } 
        }
        catch(Exception e){}
//    }
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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(GUIMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GUIMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GUIMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GUIMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                 new GUIMain().setVisible(true);
               
            }
            
        });    
    {  FileTransfer ft=new FileTransfer();
	ft.start();}
    }



}