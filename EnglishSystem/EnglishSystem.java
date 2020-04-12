import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;


public class EnglishSystem extends JFrame {

	private JPanel panel01 = new JPanel();//�˵���
	private JMenuBar jb = new JMenuBar();
	private JMenu menu01 = new JMenu("����");
	private JMenuItem item01 = new JMenuItem("����");
	private JMenuItem item02 = new JMenuItem("����");
	
	private JMenu menu02 = new JMenu("��ɫ");
	private JMenuItem item03 = new JMenuItem("õ��ɫ");
	private JMenuItem item04 = new JMenuItem("��ɫ");
	private JMenuItem item05 = new JMenuItem("��ɫ");
	private JMenuItem item06 = new JMenuItem("��ɫ");
	private JMenuItem item07 = new JMenuItem("��ɫ");
	
	private JMenu menu03 = new JMenu("����");
	private JMenuItem item08 = new JMenuItem("����ֽ");
	private JMenuItem item09 = new JMenuItem("�˳�");
	

	
	private JPanel panel03 = new JPanel();//������ʾ
	private  static JTextArea text01 = new JTextArea(30,89);
	
	private JPanel panel04 = new JPanel();
	private JButton btn_next = new JButton("��һҳ");
	private JButton btn_last = new JButton("��һҳ");
	
	private int photoNum=1;//����ͼ��
	private JPanel imagePanel;
	private ImageIcon bg= new ImageIcon("photo//photo"+photoNum+".png");//����ͼ
	private JLabel label = new JLabel(bg);
	
	private MyListener my = new MyListener();
	
	private String[] s = new String[]{"resource//s01.txt","resource//s02.txt","resource//s03.txt","resource//s04.txt",
			"resource//s05.txt","resource//s06.txt","resource//s07.txt","resource//s08.txt","resource//s09.txt","resource//s10.txt",
			"resource//s11.txt","resource//s12.txt","resource//s13.txt","resource//s14.txt"};
	private int papeNum=1;//ҳ��
	EnglishSystem(){
		jb.add(menu01);
		jb.add(menu02);
		jb.add(menu03);
		
		menu01.add(item01);
		menu01.add(item02);
		
		menu02.add(item03);
		menu02.add(item04);
		menu02.add(item05);
		menu02.add(item06);
		menu02.add(item07);
		
		menu03.add(item08);
		menu03.add(item09);
		panel01.add(jb);
		this.add(panel01);
		this.setJMenuBar(jb);
		
		panel03.add(text01);
		text01.setText(str1);
		text01.setEditable(false);
		text01.setLineWrap(true);
		text01.setWrapStyleWord(true);
		panel03.setBorder(new TitledBorder("������"));
		this.add(panel03,BorderLayout.CENTER);
		text01.setFont(new Font("����",Font.PLAIN,14));
			
		panel04.add(btn_last);
		panel04.add(btn_next);
		this.add(panel04,BorderLayout.SOUTH);
		
		text01.setOpaque(false);
		panel01.setOpaque(false);
		panel03.setOpaque(false);
		panel04.setOpaque(false);
		
		label.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight());//���ñ߽�
        imagePanel=(JPanel)this.getContentPane();//��ȡ������������
        imagePanel.setOpaque(false);//����͸��
        this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
		
        item01.addActionListener(my);
		item02.addActionListener(my);
		item03.addActionListener(my);
		item04.addActionListener(my);
		item05.addActionListener(my);
		item06.addActionListener(my);
		item07.addActionListener(my);
		item08.addActionListener(my);
		item09.addActionListener(my);
		
		btn_next.addActionListener(my);
		btn_last.addActionListener(my);
	}
	
	
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args){
		// TODO Auto-generated method stub
        EnglishSystem es =new EnglishSystem();
        es.setTitle("Ӣ��ѧϰϵͳ");
        es.setSize(750, 600);
        es.setVisible(true);
        es.setResizable(false);
        es.setLocationRelativeTo(null);
        
	}
	
		File file = new File(s[0]);
		String str1 = getFileContent(file);
	 private String getFileContent(File file) {//��ȡ�ļ�����
		   BufferedReader br = null;
		   StringBuffer sb = new StringBuffer();
		   try {
		    br = new BufferedReader(new FileReader(file));
		    String hasRead = null;
		    while ((hasRead = br.readLine()) != null) {
		     sb.append(hasRead + "\n");
		    }
		   } catch (Exception e) {
			   
		   } finally {
		    if (br != null) {
		     try {
		      br.close();
		     } catch (IOException e) {
		    
		     }
		    }
		   }
		   return sb.toString();
		  }
	private class MyListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource()==item01){//����
				text01.setFont(new Font("����",Font.PLAIN,14));
			}  
		    if(e.getSource()==item02){//����
		    	text01.setFont(new Font("����",Font.PLAIN,14));
		    }
		    if(e.getSource()==item03){//õ��ɫ
		    	text01.setForeground(new Color(255,0,255));
		    }
		    if(e.getSource()==item04){//��ɫ
		    	   text01.setForeground(Color.blue);
			  }
		    if(e.getSource()==item05){//��ɫ
		    	   text01.setForeground(new Color(0,100,0));
			  }
		    if(e.getSource()==item06){//��ɫ
		    	   text01.setForeground(new Color(255,140,0));
			  }
		    if(e.getSource()==item07){//��ɫ
		    	   text01.setForeground(Color.BLACK);
			  }
		    if(e.getSource()==item08){//����ֽ
		    	photoNum++;
		    	if(photoNum>=6){
		    		photoNum=1;
		    		}
		    	label.setIcon(new ImageIcon("photo//photo"+photoNum+".png"));
		    	}
		    if(e.getSource()==item09){//�˳�
		    	dispose();
		    }
			if(e.getSource()==btn_next){//��һҳ
				if(papeNum<s.length){//�������һҳ
					papeNum++;
					btn_last.setEnabled(true);
					btn_next.setEnabled(true);
				}
				if(papeNum==s.length){
					btn_last.setEnabled(true);
					btn_next.setEnabled(false);
				}
			}
			if(e.getSource()==btn_last){//��һҳ
				if(papeNum>1){//���ǵ�һҳ
					papeNum--;
					btn_last.setEnabled(true);
					btn_next.setEnabled(true);
				}
				if(papeNum==1){
					btn_last.setEnabled(false);
					btn_next.setEnabled(true);
				}
		}
			File file = new File(s[papeNum-1]);
			String str1 = getFileContent(file);
			  text01.setText(str1);
		}
	}
}
