package MyQQ;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

public class MainInterface extends JFrame{
	
	MainInterface(String ID,int status)
	{
		MainInterface2 mif = new MainInterface2(ID,status);
		//JFrame��
		//this.setTitle("�������^^");
		mif.setResizable(false);//���ɵ�����С
		mif.setUndecorated(true);//����ʾ�߿�
		mif.setLocationRelativeTo(null);
		mif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mif.setSize(300, 800);
		mif.setVisible(true);
		mif.setLocation(500,0);//ʹ���濿����ʾ
		
	}
	
	public static void main(String[] args)
	{
		new MainInterface("418084903",1);
	}
	
	public class MainInterface2 extends JFrame
	{
		//������Ϣ
		userdata mydata;
		private String my_name;
		private String my_ID;
		private int my_status;
		private ImageIcon my_picture;
		
		//����ͼƬ
		ImageIcon MI_back = new ImageIcon("Image/back2.jpg");//����ͼƬ
		ImageIcon MI_pr = new ImageIcon("Image/pr.png");//˽��ͼ��
		ImageIcon MI_gr = new ImageIcon("Image/gr.png");//Ⱥ��ͼ��
		private   boolean   startDrag   =   false;  //�϶���� 
		private   Point   p   =   null;   //���λ��
		
		public MainInterface2(String ID,int status)
		{	//��ȡ������Ϣ(my_name,my_picture)(my_ID,my_statusֱ�Ӵӵ�½����Landed��ȡ)
			my_ID=ID;
			my_status=status;
			my_name="Hurray";
			my_picture= new ImageIcon("Image/picture.png");
			mydata=new userdata(my_ID,my_name,my_picture,my_status);//�ӷ�������ȡ������ݣ�������
			//mydata��Ҫ�����̲߳���ˢ��
			frienddata myself = new frienddata(mydata.getID(),mydata.getname(),mydata.getpicture(),mydata.other_getstatus());
			mydata.addfriend(myself);//�Լ����Լ��ĺ���
			frienddata fr_zxj = new frienddata("329340496","С����",new ImageIcon("Image/fr_picture.png"),0);
			mydata.addfriend(fr_zxj);
			group trygroup = new group("23333","���Խ�����Ⱥ");
			mydata.addgroup(trygroup);
			
			//��ȡ�����б�������Ϣ(name,ID,picture,status,)��Ⱥ�б�
			
			
			
			//GUI����
				//mainpanel��(����)
			Image img=MI_back.getImage();
			ImagePanel mainpanel = new ImagePanel(img);
			add(mainpanel);
			mainpanel.setLayout(null);/*��һ��ǳ���Ҫ�����û����䣬����������û������λ��*/
			
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
			jbt_exit.setBounds(275, 0, 25, 25);
			mainpanel.add(jbt_exit);
			jbt_exit.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					System.exit(0);
				}
			});
			
				//��С����ť
			ImageIcon minimize1 = new ImageIcon("Image/minimize1.png");
			ImageIcon minimize2 = new ImageIcon("Image/minimize2.png");
			ImageIcon minimize3 = new ImageIcon("Image/minimize3.png");
			JButton jbt_minimize = new JButton(minimize1);
			jbt_minimize.setPressedIcon(minimize3);
			jbt_minimize.setRolloverIcon(minimize2);
			jbt_minimize.setBounds(250, 0, 25, 25);
			mainpanel.add(jbt_minimize);
			jbt_minimize.addActionListener( new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					 setState( Frame.ICONIFIED ); 
				}
			});
					
				//ͷ��
			Image IMG_my_picture = my_picture.getImage();
			ImagePanel IMP_my_picture = new ImagePanel(IMG_my_picture);
			IMP_my_picture.setBounds(20,20,80,80);
			mainpanel.add(IMP_my_picture);
			
				//����
			JLabel jl_my_name = new JLabel(my_name);
			jl_my_name.setFont(new Font("΢���ź�",Font.PLAIN,20));
			jl_my_name.setForeground(new Color(0,0,0));
			jl_my_name.setBounds(120, 25, 100, 40);
			mainpanel.add(jl_my_name);
			
				//ID
			JLabel jl_my_ID = new JLabel("("+my_ID+")");
			jl_my_ID.setFont(new Font("΢���ź�",Font.PLAIN,15));
			jl_my_ID.setForeground(new Color(0,0,150));
			jl_my_ID.setBounds(120, 60, 100, 20);
			mainpanel.add(jl_my_ID);
			
				//���ø�����Ϣ
			ImageIcon IMI_setting = new ImageIcon("Image/setting.png");
			JButton jbt_setting = new JButton(IMI_setting);
			jbt_setting.setPressedIcon(IMI_setting);
			jbt_setting.setRolloverIcon(IMI_setting);
			jbt_setting.setBounds(100, 700, 30, 30);
			mainpanel.add(jbt_setting);
			//������Ҫ�Ӻöණ���������������������ͷ�񣬲������ߴ������������ݿ���£���Ҫ�½�ҳ��
			jbt_setting.addActionListener(new act_jbt_setting());
			
			
				//˽��panel_pr
			//��Ҫ����̲߳���ˢ��
			JList jl_pr = new JList();
			final JScrollPane jsp_pr = new JScrollPane(jl_pr);
			jsp_pr.setBounds(10, 160, 280, 500);
			frienddata myfriend = null;
			for(int i=0;i<mydata.getNum();i++)
			{
				myfriend = mydata.getfriend(i); 
				userpanel fr_userpanel = new userpanel(myfriend,i);
				jl_pr.add(fr_userpanel);
			}
			mainpanel.add(jsp_pr);
			
				//Ⱥ��panel_gr
			//��Ҫ����̲߳���ˢ��
			JList jl_gr = new JList();
			final JScrollPane jsp_gr = new JScrollPane(jl_gr);
			jsp_gr.setBounds(10, 160, 280, 500);
			group mygroup = null;
			for(int i=0;i<mydata.getgroup_num();i++)
			{
				mygroup = mydata.getgroup(i); 
				grouppanel gr_grouppanel = new grouppanel(mygroup,i);
				jl_gr.add(gr_grouppanel);
			}
			
			mainpanel.add(jsp_gr);
			
				//ѡ��˽�ġ�Ⱥ��
			JButton jbt_pr = new JButton(MI_pr);
			jbt_pr.setPressedIcon(MI_pr);
			jbt_pr.setRolloverIcon(MI_pr);
			JButton jbt_gr = new JButton(MI_gr);
			jbt_gr.setPressedIcon(MI_gr);
			jbt_gr.setRolloverIcon(MI_gr);
			jbt_pr.setBounds(10, 125, 94, 33);
			jbt_gr.setBounds(105,125,94,33);
			mainpanel.add(jbt_pr);
			mainpanel.add(jbt_gr);
			jbt_pr.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					jsp_pr.setVisible(true);
					jsp_gr.setVisible(false);
				}
			});/*����Ⱥ���б���ʾ˽���б�*/
			jbt_gr.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					 jsp_gr.setVisible(true);
					 jsp_pr.setVisible(false);
				}
			});/*����˽���б���ʾȺ���б�*/
			
				//���Һ��ѡ�Ⱥ
			ImageIcon imi_add = new ImageIcon("Image/add.png");
			JButton jbt_add = new JButton(imi_add);
			jbt_add.setPressedIcon(imi_add);
			jbt_add.setRolloverIcon(imi_add);
			jbt_add.setBounds(20, 700, 60, 28);
			mainpanel.add(jbt_add);
			jbt_add.addActionListener(new act_add());
			
			//�½�Ⱥ
			ImageIcon imi_addgroup = new ImageIcon("Image/addgroup.png");
			JButton jbt_addgroup = new JButton(imi_addgroup);
			jbt_addgroup.setPressedIcon(imi_addgroup);
			jbt_addgroup.setRolloverIcon(imi_addgroup);
			jbt_addgroup.setBounds(20, 750, 60, 28);
			mainpanel.add(jbt_addgroup);
			jbt_addgroup.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) 
				{
					//�½�ҳ��
					JFrame jfm_addgroup = new JFrame();
					jfm_addgroup.setTitle("�½�Ⱥ");
					jfm_addgroup.setLocationRelativeTo(null);
					jfm_addgroup.setDefaultCloseOperation(jfm_addgroup.HIDE_ON_CLOSE);
					jfm_addgroup.setSize(300, 150);
					jfm_addgroup.setVisible(true);
					
					//�½�Panel
					JPanel jpn_addgroup = new JPanel();
					jpn_addgroup.setLayout(null);
					jfm_addgroup.add(jpn_addgroup);
					
					//������Ⱥ��
					JLabel jlb_entername = new JLabel("������Ⱥ����");
					jlb_entername.setBounds(20, 20, 150, 30);
					jpn_addgroup.add(jlb_entername);
					
					//�����
					JTextField jtf_entername = new JTextField();
					jtf_entername.setBounds(120,20,120,30);
					jpn_addgroup.add(jtf_entername);
					
					//���밴ť
					JButton jbt_newgroup = new JButton("����");
					jbt_newgroup.setBounds(120, 70, 70, 30);
					jpn_addgroup.add(jbt_newgroup);
					jbt_newgroup.addActionListener(new newgroup());
				}
			});
			
		}
		
		
		
		//���ð�ťAction
		class act_jbt_setting implements ActionListener
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				//��ʾ�������jfm_setting
				JFrame jfm_setting = new JFrame();
				jfm_setting.setTitle("����");
				jfm_setting.setLocationRelativeTo(null);
				jfm_setting.setDefaultCloseOperation(jfm_setting.HIDE_ON_CLOSE);
				jfm_setting.setSize(300, 300);
				jfm_setting.setVisible(true);
				
				//������Panel
				JPanel jpn_setting = new JPanel();
				jfm_setting.add(jpn_setting);
				jpn_setting.setLayout(null);/*��һ��ǳ���Ҫ�����û����䣬����������û������λ��*/
				
				//��ӡͷ��
				Image IMG_my_picture = my_picture.getImage();
				ImagePanel IMP_my_picture = new ImagePanel(IMG_my_picture);
				IMP_my_picture.setBounds(20,20,80,80);
				jpn_setting.add(IMP_my_picture);
				
				//�޸�ͷ��
				JButton jbt_cgpicture = new JButton("�޸�ͷ��");
				jbt_cgpicture.setFont(new Font("΢���ź�",Font.PLAIN,10));
				jbt_cgpicture.setBounds(20, 110, 80, 25);
				jpn_setting.add(jbt_cgpicture);
				jbt_cgpicture.addActionListener(null);//������Ҫд
				
				//��ӡID
				JLabel jl_my_ID = new JLabel("�˺ţ�"+my_ID);
				jl_my_ID.setFont(new Font("΢���ź�",Font.PLAIN,15));
				jl_my_ID.setForeground(new Color(0,0,150));
				jl_my_ID.setBounds(130, 60, 200, 30);
				jpn_setting.add(jl_my_ID);
				
				//����
					//��ӡ���ǳƣ���
				JLabel jl_my_name = new JLabel("�ǳƣ�");
				jl_my_name.setFont(new Font("΢���ź�",Font.PLAIN,15));
				jl_my_name.setForeground(new Color(0,0,150));
				jl_my_name.setBounds(130, 100, 200, 30);
				jpn_setting.add(jl_my_name);
					//�޸Ŀ�
				JTextField jfm_newname = new JTextField(my_name);
				jfm_newname.setBounds(175, 100, 100, 30);
				jpn_setting.add(jfm_newname);
				
				//�޸�״̬
				String[] status = {"����","����"};
				JComboBox jcb_my_status = new JComboBox(status);
				jcb_my_status.setSelectedIndex(1);
				jcb_my_status.setBounds(130	,140 ,60, 20);
				jpn_setting.add(jcb_my_status);
				
				//���水ť
				JButton jbt_save = new JButton("����");
				jbt_save.setFont(new Font("΢���ź�",Font.PLAIN,10));
				jbt_save.setBounds(150, 200, 80, 25);
				jpn_setting.add(jbt_save);
				jbt_save.addActionListener(null);//������Ҫд
				
				//�޸�����
				JButton jbt_cgcode = new JButton("�޸�����");
				jbt_cgcode.setFont(new Font("΢���ź�",Font.PLAIN,10));
				jbt_cgcode.setBounds(50, 200, 80, 25);
				jpn_setting.add(jbt_cgcode);
				jbt_cgcode.addActionListener(new act_cgcode());
			}
		}
		
		class act_cgpicture implements ActionListener
		{
			public void actionPerformed(ActionEvent arg0) {
				
			}
			
		}
		
		class act_save implements ActionListener
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
			
		}
		
		class act_cgcode implements ActionListener
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				//����һ��JFrame
				final JFrame jfm_cgcode = new JFrame();
				jfm_cgcode.setTitle("�޸�����");
				jfm_cgcode.setLocationRelativeTo(null);
				jfm_cgcode.setDefaultCloseOperation(jfm_cgcode.HIDE_ON_CLOSE);
				jfm_cgcode.setSize(300, 300);
				jfm_cgcode.setVisible(true);
				
				//���һ����JPanel
				JPanel jpn_cgcode = new JPanel();
				jfm_cgcode.add(jpn_cgcode);
				jpn_cgcode.setLayout(null);/*��һ��ǳ���Ҫ�����û����䣬����������û������λ��*/
				
				//���������
					//������ʾ
				JLabel jl_oldcode = new JLabel("�������������룺");
				jl_oldcode.setFont(new Font("΢���ź�",Font.PLAIN,15));
				jl_oldcode.setForeground(new Color(0,0,150));
				jl_oldcode.setBounds(20, 20, 140, 30);
				jpn_cgcode.add(jl_oldcode);
					//�޸Ŀ�
				JTextField jfm_oldcode = new JTextField();
				jfm_oldcode.setBounds(150, 20, 100, 30);
				jpn_cgcode.add(jfm_oldcode);
				
				//������
					//������ʾ
				JLabel jl_newcode = new JLabel("�����������룺");
				jl_newcode.setFont(new Font("΢���ź�",Font.PLAIN,15));
				jl_newcode.setForeground(new Color(0,0,150));
				jl_newcode.setBounds(20, 120, 140, 30);
				jpn_cgcode.add(jl_newcode);
					//�޸Ŀ�
				JTextField jfm_newcode = new JTextField();
				jfm_newcode.setBounds(150, 120, 100, 30);
				jpn_cgcode.add(jfm_newcode);
				
				//ȷ���޸İ�ť
				JButton jbt_cgcode_y = new JButton("�޸�����");
				jbt_cgcode_y.setFont(new Font("΢���ź�",Font.PLAIN,10));
				jbt_cgcode_y.setBounds(150, 200, 80, 25);
				jpn_cgcode.add(jbt_cgcode_y);
				jbt_cgcode_y.addActionListener(new act_savecode());//��Ҫ����д����Ҫ����������ݿ���֤
				
				//ȡ����ť
				JButton jbt_cgcode_n = new JButton("ȡ��");
				jbt_cgcode_n.setFont(new Font("΢���ź�",Font.PLAIN,10));
				jbt_cgcode_n.setBounds(50, 200, 80, 25);
				jpn_cgcode.add(jbt_cgcode_n);
				jbt_cgcode_n.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						jfm_cgcode.hide();
					}
				});
			}	
		}
		
		class act_savecode implements ActionListener
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		}

		class act_add implements ActionListener
		{
			protected int choice;
			JTextField jtf_add = new JTextField();

			public void actionPerformed(ActionEvent e) 
			{
				//�½�JFrame
				JFrame jfm_add = new JFrame();
				jfm_add.setTitle("����");
				jfm_add.setLocationRelativeTo(null);
				jfm_add.setDefaultCloseOperation(jfm_add.HIDE_ON_CLOSE);
				jfm_add.setSize(300, 300);
				jfm_add.setVisible(true);
				jfm_add.setResizable(false);//���ɵ�����С
				
				//�½�JPanel
				JPanel jpn_add = new JPanel();
				jpn_add.setLayout(null);
				jfm_add.add(jpn_add);
				
				//��ѡ��ť��������/Ⱥ
				choice =-1;
				JPanel jpn_jrb_add = new JPanel();
				jpn_jrb_add.setBounds(0, 20, 200, 100);
				jpn_add.add(jpn_jrb_add);
				JRadioButton jrb_1 = new JRadioButton("�����û�");
				jpn_jrb_add.add(jrb_1);
				JRadioButton jrb_2 = new JRadioButton("����Ⱥ");
				jpn_jrb_add.add(jrb_2);
				ButtonGroup group = new ButtonGroup();
				group.add(jrb_1);
				group.add(jrb_2);
				jrb_1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						choice =1;
					}
				});
				jrb_2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						choice =2;
					}
				});
				
				//Label��ʾ
				JLabel jlb_add = new JLabel("�������˺ţ�");
				jlb_add.setFont(new Font("΢���ź�",Font.PLAIN,15));
				jlb_add.setBounds(20, 150, 200, 30);
				jpn_add.add(jlb_add);
				
				//�����
				//JTextField jtf_add = new JTextField();�����ж���
				jtf_add.setBounds(120, 150, 100, 30);
				jpn_add.add(jtf_add);
				
				//�����ҡ���ť
				JButton jbt_search = new JButton("����");
				jbt_search.setBounds(150,200, 70, 30);
				jbt_search.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) 
					{
						if(choice==1)
						{
							new search_person(jtf_add.getText());
						}
						if(choice==2)
						{
							new search_group(jtf_add.getText());
						}
					}
				});
				jpn_add.add(jbt_search);
				
			}
			
		}
		
		class newgroup implements ActionListener
		{
			public void actionPerformed(ActionEvent e) 
			{
				int judge = 1;
				//�ж��Ƿ�����ɹ����ɹ�judge��Ϊ1
				if(judge==0)
				{
					//�½�ҳ��
					JFrame jfm_newgroup = new JFrame();
					jfm_newgroup.setTitle("error");
					jfm_newgroup.setLocationRelativeTo(null);
					jfm_newgroup.setDefaultCloseOperation(jfm_newgroup.HIDE_ON_CLOSE);
					jfm_newgroup.setSize(300, 150);
					jfm_newgroup.setVisible(true);
					
					//�½�Panel
					JPanel jpn_newgroup = new JPanel();
					jpn_newgroup.setLayout(null);
					jfm_newgroup.add(jpn_newgroup);
					
					//������Ⱥ��
					JLabel jlb_entername = new JLabel("����ʧ�ܣ������ԣ�");
					jlb_entername.setBounds(20, 20, 250, 30);
					jpn_newgroup.add(jlb_entername);
				}
				else
				{
					//��ȡnewgroupID
					String newgroupID="null";
					
					//�½�ҳ��
					JFrame jfm_newgroup = new JFrame();
					jfm_newgroup.setTitle("seccess");
					jfm_newgroup.setLocationRelativeTo(null);
					jfm_newgroup.setDefaultCloseOperation(jfm_newgroup.HIDE_ON_CLOSE);
					jfm_newgroup.setSize(300, 150);
					jfm_newgroup.setVisible(true);
					
					//�½�Panel
					JPanel jpn_newgroup = new JPanel();
					jpn_newgroup.setLayout(null);
					jfm_newgroup.add(jpn_newgroup);
					
					//������Ⱥ��
					JLabel jlb_entername = new JLabel("����ɹ�������Ⱥ���ǣ�"+newgroupID);
					jlb_entername.setBounds(20, 20, 250, 30);
					jpn_newgroup.add(jlb_entername);
				}
			}
		}
		
		class search_person extends JFrame
		{
			int search_yn;
			search_person(String s)
			{
				//GUI
					//JFrame����
				this.setTitle("�����û�");
				this.setLocationRelativeTo(null);
				this.setDefaultCloseOperation(this.HIDE_ON_CLOSE);
				this.setSize(300, 200);
				this.setVisible(true);
				this.setResizable(false);//���ɵ�����С
				
					//JPanel����
				JPanel jpn_search = new JPanel();
				jpn_search.setLayout(null);
				this.add(jpn_search);
				
				//����
				search_yn = 0;//��Ҫ��Ӳ����ж�
				if(search_yn==0)
				{
					JLabel jlb_search_err = new JLabel("û���ҵ���");
					jlb_search_err.setBounds(20, 20, 150, 30);
					jpn_search.add(jlb_search_err);
				}
				else
				{
					//Label
					JLabel jlb_search_sec = new JLabel("�ɹ��ҵ����Ƿ���Ӻ��ѣ�");
					jlb_search_sec.setBounds(20, 20, 200, 30);
					jpn_search.add(jlb_search_sec);
					
					//�������û���ͷ��
					ImageIcon imi_search = new ImageIcon("Image/fr_picture.png");
						//������Ҫ�����û�ͷ��,������һ��������Ķ���ɾ��
					Image img_fr_picture=imi_search.getImage();
					ImagePanel imp_fr_picture = new ImagePanel(img_fr_picture);
					imp_fr_picture.setBounds(20,50,40,40);
					jpn_search.add(imp_fr_picture);
					
					//�������û����ǳ�
					String str_search_name = "searchname";
					JLabel jlb_search_name = new JLabel(str_search_name);
					jlb_search_name.setBounds(90,50, 150,30);
					jpn_search.add(jlb_search_name);
					
					//�������û���ID
					String str_search_ID = "searchID";
					JLabel jlb_search_ID = new JLabel("("+str_search_ID+")");
					jlb_search_ID.setBounds(90,80, 150,30);
					jpn_search.add(jlb_search_ID);
					
					//��ť��
					JButton jbt_yes = new JButton("��");
					jbt_yes.setBounds(70, 120, 70, 30);
					jpn_search.add(jbt_yes);
					jbt_yes.addActionListener(null);//�Ժ���д
					
					//��ť��
					final JFrame t = this;
					JButton jbt_no = new JButton("��");
					jbt_no.setFont(new Font("΢���ź�",Font.PLAIN,10));
					jbt_no.setBounds(170, 120, 70, 30);
					jpn_search.add(jbt_no);
					jbt_no.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e)
						{
							t.hide();
						}
					});
				}
				
			}
		}
		
		class search_group extends JFrame
		{
			int search_yn;
			search_group(String s)
			{
				//GUI
					//JFrame����
				this.setTitle("����Ⱥ");
				this.setLocationRelativeTo(null);
				this.setDefaultCloseOperation(this.HIDE_ON_CLOSE);
				this.setSize(300, 200);
				this.setVisible(true);
				this.setResizable(false);//���ɵ�����С
				
					//JPanel����
				JPanel jpn_search = new JPanel();
				jpn_search.setLayout(null);
				this.add(jpn_search);
				
				//����
				search_yn = 0;//��Ҫ��Ӳ����ж�
				if(search_yn==0)
				{
					JLabel jlb_search_err = new JLabel("û���ҵ���");
					jlb_search_err.setBounds(20, 20, 150, 30);
					jpn_search.add(jlb_search_err);
				}
				else
				{
					//Label
					JLabel jlb_search_sec = new JLabel("�ɹ��ҵ����Ƿ�����Ⱥ��");
					jlb_search_sec.setBounds(20, 20, 200, 30);
					jpn_search.add(jlb_search_sec);
					
					//������Ⱥ���ǳ�
					String str_search_name = "searchname";
					JLabel jlb_search_name = new JLabel(str_search_name);
					jlb_search_name.setBounds(90,50, 150,30);
					jpn_search.add(jlb_search_name);
					
					//������Ⱥ��ID
					String str_search_ID = "searchID";
					JLabel jlb_search_ID = new JLabel("("+str_search_ID+")");
					jlb_search_ID.setBounds(90,80, 150,30);
					jpn_search.add(jlb_search_ID);
					
					//��ť��
					JButton jbt_yes = new JButton("��");
					jbt_yes.setBounds(70, 120, 70, 30);
					jpn_search.add(jbt_yes);
					jbt_yes.addActionListener(null);//�Ժ���д
					
					//��ť��
					final JFrame t = this;
					JButton jbt_no = new JButton("��");
					jbt_no.setFont(new Font("΢���ź�",Font.PLAIN,10));
					jbt_no.setBounds(170, 120, 70, 30);
					jpn_search.add(jbt_no);
					jbt_no.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e)
						{
							t.hide();
						}
					});
				}
			}
		}

		public class userpanel extends JPanel
		{
			public frienddata myfriend;
			userpanel(final frienddata myfriend,int i)
			{
				this.myfriend=myfriend;
				//i������panel��λ��,��0��ʼ
				
				//panel������
				this.setLayout(null);
				this.setBounds(7, 40*i, 250, 40);
				
				//ͷ��
				ImageIcon imi_picture = myfriend.getpicture();
				Image img_picture=imi_picture.getImage();
				ImagePanel imp_picture = new ImagePanel(img_picture);
				imp_picture.setBounds(5,5,30,30);
				this.add(imp_picture);
				
				//����
				JLabel jl_name = new JLabel(myfriend.getname());
				jl_name.setFont(new Font("΢���ź�",Font.PLAIN,15));
				jl_name.setForeground(new Color(0,0,0));
				jl_name.setBounds(45, 5, 100, 15);
				this.add(jl_name);
				
				//ID
				JLabel jl_ID = new JLabel("("+myfriend.getID()+")");
				jl_ID.setFont(new Font("΢���ź�",Font.PLAIN,10));
				jl_ID.setForeground(new Color(0,0,150));
				jl_ID.setBounds(45, 25, 100, 10);
				this.add(jl_ID);
				
				//״̬
				if(myfriend.getstatus()==1)
				{
					ImageIcon imi_status = new ImageIcon("Image/green.png");
					Image img_status = imi_status.getImage();
					ImagePanel imp_status = new ImagePanel(img_status);
					imp_status.setBounds(0, 0, 40, 5);
					this.add(imp_status);
				}
				else
				{
					ImageIcon imi_status = new ImageIcon("Image/red.png");
					Image img_status = imi_status.getImage();
					ImagePanel imp_status = new ImagePanel(img_status);
					imp_status.setBounds(0, 0, 40, 5);
					this.add(imp_status);
				}
				
				//�����¼�
				this.addMouseListener(new MouseListener(){

					public void mouseClicked(MouseEvent arg0) {
						int judge = 0;
						for(int i=0;i<mydata.getNum();i++)
						{
							frienddata thisfriend=mydata.getfriend(i);
							if(thisfriend.getID()==myfriend.getID())
							{
								new PrivateChat(myfriend,mydata);
								judge =1;
								break;
							}
						}
						if(judge==0)
						{
							//JFrame
							JFrame jfm_err = new JFrame();
							jfm_err.setTitle("error");
							jfm_err.setLocationRelativeTo(null);
							jfm_err.setDefaultCloseOperation(jfm_err.HIDE_ON_CLOSE);
							jfm_err.setSize(300, 150);
							jfm_err.setVisible(true);
							
							//�½�Panel
							JPanel jpn_err = new JPanel();
							jpn_err.setLayout(null);
							jfm_err.add(jpn_err);
							
							//JLabel
							JLabel jlb_entername = new JLabel("�������ڸú��ѣ�");
							jlb_entername.setBounds(20, 20, 250, 30);
							jpn_err.add(jlb_entername);
						}
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
			}
		}
		
		public class grouppanel extends JPanel
		{
			public group mygroup;
			
			grouppanel(final group mygroup,int i)
			{
				this.mygroup=mygroup;
				//i������panel��λ��,��0��ʼ
				
				//panel������
				this.setLayout(null);
				this.setBounds(7, 40*i, 250, 40);
				
				//����
				JLabel jl_name = new JLabel(mygroup.getname());
				jl_name.setFont(new Font("΢���ź�",Font.PLAIN,15));
				jl_name.setForeground(new Color(0,0,0));
				jl_name.setBounds(10, 5, 100, 15);
				this.add(jl_name);
				
				//ID
				JLabel jl_ID = new JLabel("("+mygroup.getID()+")");
				jl_ID.setFont(new Font("΢���ź�",Font.PLAIN,10));
				jl_ID.setForeground(new Color(0,0,150));
				jl_ID.setBounds(10, 25, 100, 10);
				this.add(jl_ID);
				
				//�����¼�
				this.addMouseListener(new MouseListener(){

					public void mouseClicked(MouseEvent arg0) {
						int judge = 0;
						for(int i=0;i<mydata.getgroup_num();i++)
						{
							group thisgroup=mydata.getgroup(i);
							if(thisgroup.getID()==mygroup.getID())
							{
								new GroupChat(mygroup,mydata);
								judge =1;
								break;
							}
						}
						if(judge==0)
						{
							//JFrame
							JFrame jfm_err = new JFrame();
							jfm_err.setTitle("error");
							jfm_err.setLocationRelativeTo(null);
							jfm_err.setDefaultCloseOperation(jfm_err.HIDE_ON_CLOSE);
							jfm_err.setSize(300, 150);
							jfm_err.setVisible(true);
							
							//�½�Panel
							JPanel jpn_err = new JPanel();
							jpn_err.setLayout(null);
							jfm_err.add(jpn_err);
							
							//JLabel
							JLabel jlb_entername = new JLabel("�������ڸ�Ⱥ��");
							jlb_entername.setBounds(20, 20, 250, 30);
							jpn_err.add(jlb_entername);
						}
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
			}
		}
		
	}
}

class frienddata
{
	public String ID;
	public String name;
	public ImageIcon picture;
	public int status;
	frienddata(String ID,String name,ImageIcon picture,int status)
	{
		this.ID=ID;
		this.name=name;
		this.picture=picture;
		this.status=status;
	}
	public String getID()
	{
		return ID;
	}
	public void setID(String ID)
	{
		this.ID=ID;
	}
	public String getname()
	{
		return name;
	}
	public void setname(String name)
	{
		this.name=name;
	}
	public ImageIcon getpicture()
	{
		return picture;
	}
	public void setpicture(ImageIcon picture)
	{
		this.picture=picture;
	}
	public int getstatus()
	{
		return status;
	}
	public void setstatus(int status)
	{
		this.status=status;
	}
}

class userdata
{
	//��������ͻ��˱������ݿ⣬���кܶණ����Ҫ�ظģ�����
	public String ID;
	public String name;
	public ImageIcon picture;
	private String code;
	public int status;
	private frienddata[] friends = new frienddata[100];
	private int num_fr;
	private group[] my_group = new group[100];
	public int group_num;
	
	
	userdata()
	{
		frienddata[] friends = new frienddata[100];
		for(int i=0;i<100;i++)
		{
			friends[i]=new frienddata(null,null,null,0);
		}
		for(int i=0;i<100;i++)
		{
			my_group[i]=new group(null,null);
		}
		num_fr=0;
		group_num=0;
		this.code=null;
		this.ID="null";
		this.name="null";
		this.picture=null;
		this.status=0;
	}
	
	userdata(String ID)
	{
		frienddata[] friends = new frienddata[100];
		for(int i=0;i<100;i++)
		{
			friends[i]=new frienddata(null,null,null,0);
		}
		for(int i=0;i<100;i++)
		{
			my_group[i]=new group(null,null);
		}
		num_fr=0;
		group_num=0;
		this.code=null;
		this.ID="null";
		this.name="null";//�ӷ������ض�
		this.picture=null;//�ӷ������ض�
		this.status=0;//�ӷ������ض�
	}
	userdata(String ID,String name,ImageIcon picture,int status)
	{
		this.ID=ID;
		this.name=name;
		this.picture=picture;
		this.status=status;
		for(int i=0;i<100;i++)
		{
			friends[i]=new frienddata(null,null,null,0);
		}
		for(int i=0;i<100;i++)
		{
			my_group[i]=new group(null,null);
		}
		num_fr=0;
		group_num=0;
	}
	public void setID(String ID)
	{
		this.ID=ID;
	}
	public String getID()
	{
		return ID;
	}
	public void setname(String name)
	{
		this.name=name;
	}
	public String getname()
	{
		return name;
	}
	public void setcode(String code)
	{
		this.code=code;
	}
	public int judgecode(String Code)
	{
		if(Code==code)
			return 1;
		else
			return 0;
	}
	public void setstatus(int status)
	{
		this.status=status;
	}
	public int other_getstatus()
	{
		if(this.status==0||this.status==2)
			return 0;
		else
			return 1;
	}
	public int my_getstatus()
	{
		return status;
	}
	public void setpicture(ImageIcon picture)
	{
		this.picture=picture;
	}
	public ImageIcon getpicture()
	{
		return picture;
	}
	protected String getcode()
	{
		return code;
	}
	/*public void setfriends(frienddata[] friends)
	{
		int i=0;
		while(i<friends.length)
		{	
			this.friends[i]=friends[i];
		}
		this.num_fr=i+1;
	}*/
	public void addfriend(frienddata newfriend)
	{
		int i = num_fr;
		friends[i].setname(newfriend.getname());
		friends[i].setID(newfriend.getID());
		friends[i].setstatus(newfriend.getstatus());
		friends[i].setpicture(newfriend.getpicture());
		this.num_fr++;
	}
	public int delefriend(String id)
	{
		//����ɹ�ɾ������1�����򷵻�0
		int YN=0;
		for(int i=0;i<this.num_fr;i++)
		{
			if(friends[i].getID()==id)
			{
				for(int j=i;j<this.num_fr-1;j++)
				{
					friends[i]=friends[i+1];
				}
				friends[this.num_fr]=null;
				this.num_fr--;
				YN=1;
				break;
			}
		}
		return YN;
	}
	public int getNum()
	{
		return this.num_fr;
	}
	public frienddata getfriend(int i)
	{
		return friends[i];
	}
	public void addgroup(group newgroup)
	{
		int i = this.getgroup_num();
		my_group[i].setname(newgroup.getname());
		my_group[i].setID(newgroup.getID());
		this.group_num++;
	}
	//public int delegroup()
	//���ں��ѱ����Ⱥ���˳�������Ⱥ��dele���԰����˹��ܡ���Ҫע�⣬�������ɾȺ������Ҫ���¸����û���userdata
	public int getgroup_num()
	{
		return this.group_num;
	}
	
	public group getgroup(int i)
	{
		return my_group[i];
	}
	
	public group getgroupfromID(String groupID)
	{
		group nullgroup = new group();
		for(int i=0;i<this.getgroup_num();i++)
		{
			group thisgroup = this.my_group[i];
			if(groupID==thisgroup.getID())
			{
				return thisgroup;
			}
		}
		return nullgroup;
	}
	
	public void delegroup(String groupID)
	{
		for(int i=0;i<this.getgroup_num();i++)
		{
			group thisgroup = this.my_group[i];
			if(groupID==thisgroup.getID())
			{
				for(int j=0;j<this.getgroup_num()-1;j++)
				{
					my_group[j]=my_group[i];
				}
			}
		}
	}
	
}

class group
{
	public String name;
	public String ID;
	private frienddata[] users=new frienddata[100];
	private int usernum;
	
	group()
	{
		this.name=null;
		this.ID=null;
		this.users=new frienddata[100];
		usernum=0;
		for(int i=0;i<100;i++)
		{
			users[i]=new frienddata(null,null,null,0);
		}
	}
	
	group(String ID,String name)
	{
		this.ID=ID;
		this.name=name;
		this.users=new frienddata[100];
		usernum=0;
		for(int i=0;i<100;i++)
		{
			users[i]=new frienddata(null,null,null,0);
		}
	}
	
	public String getname()
	{
		return name;
	}
	public String getID()
	{
		return ID;
	}
	public void setname(String newname)
	{
		this.name=newname;
	}
	public void setID(String newID)
	{
		this.ID=newID;
	}
	public int getNum()
	{
		return this.usernum;
	}
	public void adduser(frienddata user)
	{
		users[this.usernum]=user;
		this.usernum++;
	}
	public int deleuser(String ID)
	{
		//����ɹ�ɾ������1�����򷵻�0
				int YN=0;
				for(int i=0;i<this.getNum();i++)
				{
					if(users[i].ID==ID)
					{
						for(int j=i;j<this.getNum()-1;j++)
						{
							users[i]=users[i+1];
						}
						users[this.getNum()]=null;
						this.usernum--;
						YN=1;
						break;
					}
				}
				return YN;
	}
}