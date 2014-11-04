package MyQQ;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class PrivateChat extends JFrame{
	private   boolean   startDrag   =   false;  //�϶���� 
	private   Point   p   =   null;   //���λ��
	
	PrivateChat(frienddata myfriend,userdata mydata)//֮����Ҫ��PrivateChat_2����������ΪsetUndecorated�ὫFrame�����ж������
	{
		PrivateChat_2 prc = new PrivateChat_2(myfriend,mydata);
		prc.setResizable(false);//���ɵ�����С
		prc.setUndecorated(true);
		//this.setTitle("��"+fr_name+"������");
		prc.setLocationRelativeTo(null);
		prc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		prc.setSize(600, 400);
		prc.setVisible(true);
		prc.setLocationRelativeTo(null);
	}

	public class PrivateChat_2 extends JFrame
	{
		private JTextArea jta_print = new JTextArea();
		private JTextArea jta_send = new JTextArea();
		PrivateChat_2(final frienddata myfriend,final userdata mydata)
		{
			//����
			ImageIcon imageicon=new ImageIcon("Image/back_chat.png");
			Image img=imageicon.getImage();
			ImagePanel mainpanel = new ImagePanel(img);
			add(mainpanel);
			mainpanel.setLayout(null);
			
			//����϶�(copy from CSDN)
			addMouseListener(new   MouseAdapter()
			{   
				 public   void   mousePressed(MouseEvent   e)
				 {   
					 startDrag   =   true;   
					 p   =   e.getPoint();   
				 }   
				 public   void   mouseReleased(MouseEvent   e)
				 {   
					 startDrag   =   false;   
				 }  
			}); 
			addMouseMotionListener(new   MouseMotionAdapter()
			{   
				public   void   mouseDragged(MouseEvent   e)
				{   
					Point   p1   =   e.getPoint();   
					Point   p2   =   getLocation(null);   
					p2.x   +=   p1.x   -   p.x;   
					p2.y   +=   p1.y   -   p.y;   
					setLocation(p2);   
				}   
			});
			
			//�رհ�ť
			ImageIcon exit1 = new ImageIcon("Image/exit1.png");
			ImageIcon exit2 = new ImageIcon("Image/exit2.png");
			ImageIcon exit3 = new ImageIcon("Image/exit3.png");
			JButton jbt_exit = new JButton(exit1);
			jbt_exit.setPressedIcon(exit3);
			jbt_exit.setRolloverIcon(exit2);
			jbt_exit.setBounds(575, 0, 25, 25);
			mainpanel.add(jbt_exit);
			final JFrame t = this;//�����ڷ����в�����this��������t�滻һ��
			jbt_exit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					t.hide();
				}
			});
			
			//��С����ť
			ImageIcon minimize1 = new ImageIcon("Image/minimize1.png");
			ImageIcon minimize2 = new ImageIcon("Image/minimize2.png");
			ImageIcon minimize3 = new ImageIcon("Image/minimize3.png");
			JButton jbt_minimize = new JButton(minimize1);
			jbt_minimize.setPressedIcon(minimize3);
			jbt_minimize.setRolloverIcon(minimize2);
			jbt_minimize.setBounds(550, 0, 25, 25);
			mainpanel.add(jbt_minimize);
			jbt_minimize.addActionListener( new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					 t.setState( Frame.ICONIFIED ); 
				}
			});
			
			//���ѵ�ͷ��
				//�ӷ�������ȡ��֮����д����
			ImageIcon imi_fr_picture = myfriend.getpicture();
			Image img_fr_picture=imi_fr_picture.getImage();
			ImagePanel imp_fr_picture = new ImagePanel(img_fr_picture);
			imp_fr_picture.setBounds(10,8,30,30);
			mainpanel.add(imp_fr_picture);
			
			//���ѵ�����
				//�ӷ�������ȡ��֮����д����
			String string_fr_name = myfriend.getname();
			JLabel jl_fr_name = new JLabel(string_fr_name);
			jl_fr_name.setFont(new Font("΢���ź�",Font.PLAIN,15));
			jl_fr_name.setForeground(new Color(0,0,0));
			jl_fr_name.setBounds(50, 0, 100, 30);
			mainpanel.add(jl_fr_name);
			JLabel jl_fr_name2 = new JLabel(string_fr_name);
			jl_fr_name2.setFont(new Font("΢���ź�",Font.PLAIN,15));
			jl_fr_name2.setForeground(new Color(255,255,255));
			jl_fr_name2.setBounds(51, 1, 100, 30);
			mainpanel.add(jl_fr_name2);
			
			
			//���ѵ�ID
				//�ӷ�������ȡ��֮����д����
			String string_fr_ID = "("+myfriend.getID()+")";
			JLabel jl_fr_ID = new JLabel(string_fr_ID);
			jl_fr_ID.setFont(new Font("΢���ź�",Font.PLAIN,10));
			jl_fr_ID.setForeground(new Color(0,0,150));
			jl_fr_ID.setBounds(50, 20, 100, 30);
			mainpanel.add(jl_fr_ID);
			
			//������Ϣ��
			//JTextArea jta_print = new JTextArea();д����˽�б�����
			jta_print.setLineWrap(true);//������ʹJTextArea������ֲ��ܱ��޸�
			jta_print.setEditable(false);//������ʹJTextArea������ֲ��ܱ��޸�
			JScrollPane jsp_print = new JScrollPane(jta_print);
			jsp_print.setBounds(10, 55, 580, 195);
			mainpanel.add(jsp_print);
			
			//������Ϣ��
			//JTextArea jta_send = new JTextArea();д����˽�б�����
			JScrollPane jsp_send = new JScrollPane(jta_send);
			jsp_send.setBounds(10, 300, 580, 90);
			mainpanel.add(jsp_send);
			
			//���Ͱ�ť
			JButton jbt_send = new JButton("����");
			jbt_send.setBounds(510, 260, 70, 30);
			mainpanel.add(jbt_send);
			
			//��ӱ���
			ImageIcon imi_sendface = new ImageIcon("Image/sendface.png");
			JButton jbt_sendface = new JButton(imi_sendface);
			jbt_sendface.setPressedIcon(imi_sendface);
			jbt_sendface.setRolloverIcon(imi_sendface);
			jbt_sendface.setBounds(10, 275, 25, 25);
			mainpanel.add(jbt_sendface);
			
			//����ͼƬ
			ImageIcon imi_sendpicture = new ImageIcon("Image/sendpicture.png");
			JButton jbt_sendpicture = new JButton(imi_sendpicture);
			jbt_sendpicture.setPressedIcon(imi_sendpicture);
			jbt_sendpicture.setRolloverIcon(imi_sendpicture);
			jbt_sendpicture.setBounds(35, 275, 40, 25);
			mainpanel.add(jbt_sendpicture);
			
			//��������
			ImageIcon imi_sendvoice = new ImageIcon("Image/sendvoice.png");
			JButton jbt_sendvoice = new JButton(imi_sendvoice);
			jbt_sendvoice.setPressedIcon(imi_sendvoice);
			jbt_sendvoice.setRolloverIcon(imi_sendvoice);
			jbt_sendvoice.setBounds(75, 275, 25, 25);
			mainpanel.add(jbt_sendvoice);
			
			//������Ƶ
			ImageIcon imi_sendvideo = new ImageIcon("Image/sendvideo.png");
			JButton jbt_sendvideo = new JButton(imi_sendvideo);
			jbt_sendvideo.setPressedIcon(imi_sendvideo);
			jbt_sendvideo.setRolloverIcon(imi_sendvideo);
			jbt_sendvideo.setBounds(100, 275, 25, 25);
			mainpanel.add(jbt_sendvideo);
			
			//���ͽ�ͼ
			ImageIcon imi_sendsc = new ImageIcon("Image/sendsc.png");
			JButton jbt_sendsc = new JButton(imi_sendsc);
			jbt_sendsc.setPressedIcon(imi_sendsc);
			jbt_sendsc.setRolloverIcon(imi_sendsc);
			jbt_sendsc.setBounds(125, 275, 40, 25);
			mainpanel.add(jbt_sendsc);
			
			//ɾ���ú��Ѱ�ť
			JButton jbt_dele_friend = new JButton("ɾ���ú���");
			jbt_dele_friend.setBounds(380, 260,120, 30);
			mainpanel.add(jbt_dele_friend);
			final JFrame tt = this;
			jbt_dele_friend.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					mydata.delefriend(myfriend.getID());
					tt.hide();
				}});
			
		}
	}
	
	public static void main(String[] args)
	{
		userdata mydata = new userdata("418084903","Hurray",new ImageIcon("Image/picture"),1);
		frienddata myfriend = new frienddata("329340496","С����",new ImageIcon("Image/fr_picture.png"),1);
		new PrivateChat(myfriend,mydata);
	}
}
