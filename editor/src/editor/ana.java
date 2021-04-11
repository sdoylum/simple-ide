package editor;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;

public class ana extends JFrame {
	private JTextArea textArea;
	private JTextArea textArea_1;
	private JPanel contentPane;
	private String file;
	private String enSonAcilan;
	private int kontrol;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ana frame = new ana();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					
					frame.setVisible(true);
					frame.addKeyListener(new KeyListener(){
			             @Override
			             
			                public void keyPressed(KeyEvent e) {
			                    if(e.getKeyCode() == KeyEvent.VK_PAGE_UP){
			                    	System.out.println("up");
			                    	frame.kaydet();
			                    }else if(e.getKeyCode() == KeyEvent.VK_HOME){
			                    	System.out.println("home");

			                    	frame.yorumla();
			                    }
			                }

			                @Override
			                public void keyTyped(KeyEvent e) {
			                }

			                @Override
			                public void keyReleased(KeyEvent e) {
			                }
			        });
		
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ana() {
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Dosya");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Yeni");
		mntmNewMenuItem.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	textArea.setVisible(true);
		        textArea.setText("");
		        kontrol = 0;
		    }
		});

		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Aç");
		mnNewMenu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	JFileChooser j = new JFileChooser("f:"); 
	            int r = j.showOpenDialog(null); 
	 	            if (r == JFileChooser.APPROVE_OPTION) {
	 	            String fileName = j.getSelectedFile().getName();
	 	            if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
	 	            	if(fileName.substring(fileName.lastIndexOf(".")+1).equals("vv")) {
		 	            	
	 		                File fi = new File(file = j.getSelectedFile().getAbsolutePath()); 
	 		                try { 
	 		                    String s1 = "", sl = ""; 
	 		 	                FileReader fr = new FileReader(fi); 
	 		 	                BufferedReader br = new BufferedReader(fr); 
	 		                    sl = br.readLine(); 
	 		                    while ((s1 = br.readLine()) != null) { 
	 		                        sl = sl + "\n" + s1; 
	 		                    } 
	 		                    kontrol = 1;
	 		                    textArea.setVisible(true);
	 		                    textArea.setText(sl); 
	 		                } 
	 		                catch (Exception es) { 
	 		                    es.printStackTrace();
	 		                } 
	 	            	}else {
	 	            		JOptionPane.showMessageDialog(null, "Dosya uzantısı hatalı");
	 	            	}
	 	            }else {
	 	            	JOptionPane.showMessageDialog(null, "Dosya uzantısı yok");
	 	            }

	            } 
		    }
		});
		
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Kaydet");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		mntmNewMenuItem_2.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	JFileChooser j = new JFileChooser("f:"); 
		    	if(kontrol == 0) {
		    		int r = j.showSaveDialog(null); 
		            if (r == JFileChooser.APPROVE_OPTION) { 
		            	File fi = new File(j.getSelectedFile().getAbsolutePath()); 
		                try { 
		                    FileWriter wr = new FileWriter(fi, false); 
		                    BufferedWriter w = new BufferedWriter(wr); 
		                    w.write(textArea.getText()); 
		                    w.flush(); 
		                    w.close(); 
		                } 
		                catch (Exception es) { 
		                    es.printStackTrace();
		                } 
		            }
		    	}else {
		    		File fi = new File(file);
		    		try { 
	                    FileWriter wr = new FileWriter(fi, false); 
	                    BufferedWriter w = new BufferedWriter(wr); 
	                    w.write(textArea.getText()); 
	                    w.flush(); 
	                    w.close(); 
	                } 
	                catch (Exception es) { 
	                    es.printStackTrace();
	                } 
		    	}
		    }  
		});
		
		JMenu mnNewMenu_1 = new JMenu("Çalıştır");
		menuBar.add(mnNewMenu_1);	
		JMenuItem mtmNewMenuItem_3 = new JMenuItem("Yorumla");
		mnNewMenu_1.add(mtmNewMenuItem_3);
		
		mtmNewMenuItem_3.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	try {
		    		textArea_1.setText("");
		            Runtime runTime = Runtime.getRuntime();  
		            System.out.println(textArea.getText());
		            File tempFile = File.createTempFile("temp", ".vv");
		            BufferedWriter wr;
		            try { wr = new BufferedWriter(new FileWriter(tempFile.getPath()));
		                wr.write(textArea.getText());
		                wr.close();
		            } catch (IOException ex) {
		            	ex.printStackTrace();
		            }
		            
		            ProcessBuilder processBuilder = new ProcessBuilder(System.getProperty("user.dir")+"/a.out", tempFile.getPath());

		            processBuilder.redirectErrorStream(true);

		            Process process = processBuilder.start();
		            StringBuilder processOutput = new StringBuilder();

		            try (BufferedReader processOutputReader = new BufferedReader(
		                    new InputStreamReader(process.getInputStream()));)
		            {
		                String readLine;
		                int i = 1;
		                while ((readLine = processOutputReader.readLine()) != null)
		                {
		                    processOutput.append(i++ +": "+readLine + System.lineSeparator());
		                }

		                process.waitFor();
		            }
		            tempFile.deleteOnExit();

		            textArea_1.setText(processOutput.toString().trim()); 
		            
		        
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		});
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		contentPane.add(scrollPane_1, BorderLayout.CENTER);

		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		scrollPane_1.setViewportView(textArea);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Result", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setPreferredSize(new Dimension(10, 100));
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 15));
		JScrollPane sampleScrollPane = new JScrollPane (textArea_1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		textArea_1.setEditable(false);
		panel.add(sampleScrollPane);
		textArea.setVisible(false);
		
	}
	
	public void yorumla() {
		try {
    		textArea_1.setText("");
            Runtime runTime = Runtime.getRuntime();
            System.out.println(file);
            ProcessBuilder processBuilder = new ProcessBuilder("a.out", file);

            processBuilder.redirectErrorStream(true);

            Process process = processBuilder.start();
            StringBuilder processOutput = new StringBuilder();

            try (BufferedReader processOutputReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));)
            {
                String readLine;
                int i = 1;
                while ((readLine = processOutputReader.readLine()) != null)
                {
                    processOutput.append(i++ +": "+readLine + System.lineSeparator());
                }

                process.waitFor();
            }

            textArea_1.setText(processOutput.toString().trim()); 
            
        
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	
	public void kaydet() {
    	JFileChooser j = new JFileChooser("f:"); 
    	if(kontrol == 0) {
    		int r = j.showSaveDialog(null); 
            
            if (r == JFileChooser.APPROVE_OPTION) { 
  
                // Set the label to the path of the selected directory 
                File fi = new File(j.getSelectedFile().getAbsolutePath()); 
  
                try { 
                    // Create a file writer 
                    FileWriter wr = new FileWriter(fi, false); 
  
                    // Create buffered writer to write 
                    BufferedWriter w = new BufferedWriter(wr); 
  
                    // Write 
                    w.write(textArea.getText()); 
  
                    w.flush(); 
                    w.close(); 
                } 
                catch (Exception es) { 
                    es.printStackTrace();
                } 
            }
    	}else {
    		File fi = new File(file);
    		try { 
                // Create a file writer 
                FileWriter wr = new FileWriter(fi, false); 

                // Create buffered writer to write 
                BufferedWriter w = new BufferedWriter(wr); 

                // Write 
                w.write(textArea.getText()); 

                w.flush(); 
                w.close(); 
            } 
            catch (Exception es) { 
                es.printStackTrace();
            } 
    	}
	}
}
