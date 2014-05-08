import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class NewTaskFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JTextField jtfTaskName;
	private String taskName;	
	private JComboBox<String> jcbTimeOrMail;
	private int timeOrMail;
	private JTextField jtfDate;
	private String date;
	private JTextField jtfTime;
	private String time;
	private JTextField jtfSrcID;
	private String srcID;
	private JPasswordField jpfSrcPassword;
	private String srcPassword;
	private JComboBox<String> jcbWeiboOrMail;
	private int weiboOrMail;
	private JTextField jtfWeiboID;
	private String weiboID;
	private JPasswordField jpfWeiboPassword;
	private String weiboPassword;
	private JTextField jtfDesID;
	private String desID;
	private JTextArea jtaContent;
	private String content;
	private JLabel label3;//date
	private JLabel label5;//srcID
	private JLabel label4;//time
	private JLabel label6;//srcPassword
	private JLabel label9;//weiboID
	private JLabel label10;//desID
	private JLabel label11;//weiboPassword

	private JButton jbtConfirm = new JButton("确定");
	private JButton jbtReset = new JButton("重置");
	private JButton jbtCancel = new JButton("取消");
	public NewTaskFrame(){
		intialization();
		
		JPanel north = new JPanel(new BorderLayout());
		JPanel northNorth = new JPanel(new FlowLayout(1));
		JLabel label0 = new JLabel("新建任务");
		label0.setFont(new Font("Courier",Font.BOLD,29));
		northNorth.add(label0);
		JPanel northSouth = new JPanel(new BorderLayout(20,5));
		northSouth.add(new JLabel(" 任务名称:      "),BorderLayout.WEST);

		northSouth.add(jtfTaskName,BorderLayout.CENTER);
		north.add(northNorth,BorderLayout.NORTH);
		north.add(northSouth,BorderLayout.SOUTH);
		
		JPanel center = new JPanel(new GridLayout(1,2));
		JPanel centerLeft = new JPanel(new BorderLayout());
		JPanel centerLeftIF = new JPanel(new FlowLayout(0));
		JLabel label1 = new JLabel("  IF  ");
		label1.setFont(new Font("Courier",Font.PLAIN,29));
		centerLeftIF.add(label1);
		JPanel centerLeftThis = new JPanel(new GridLayout(7,1,0,10));
		centerLeftThis.setBorder(new LineBorder(Color.gray));
		JLabel label2 = new JLabel("THIS");
		label2.setFont(new Font("Courier",Font.PLAIN,29));
		centerLeftThis.add(label2);
		jcbTimeOrMail.setBorder(BorderFactory.createEmptyBorder(2, 38, 2, 38));
		centerLeftThis.add(jcbTimeOrMail);
		
		JPanel centerLeftThisDate = new JPanel(new BorderLayout(20,5));
		//label3 = new JLabel("日期:");
		label3.setFont(new Font("Courier",Font.BOLD,12));
		centerLeftThisDate.add(label3,BorderLayout.WEST);
		centerLeftThisDate.add(jtfDate,BorderLayout.CENTER);
		centerLeftThisDate.setBorder(BorderFactory.createEmptyBorder(2, 18, 2, 18));
		
		JPanel centerLeftThisID = new JPanel(new BorderLayout(20,5));
		//label5 = new JLabel("用户:");
		label5.setFont(new Font("Courier",Font.BOLD,12));
		centerLeftThisID.add(label5,BorderLayout.WEST);
		centerLeftThisID.add(jtfSrcID,BorderLayout.CENTER);
		centerLeftThisID.setBorder(BorderFactory.createEmptyBorder(2, 18, 2, 18));
			
		JPanel centerLeftThisTime = new JPanel(new BorderLayout(20,5));
		//label4 = new JLabel("时间:");
		label4.setFont(new Font("Courier",Font.BOLD,12));
		centerLeftThisTime.add(label4,BorderLayout.WEST);
		centerLeftThisTime.add(jtfTime,BorderLayout.CENTER);
		centerLeftThisTime.setBorder(BorderFactory.createEmptyBorder(2, 18, 2, 18));
		
		JPanel centerLeftThisPass = new JPanel(new BorderLayout(20,5));
		//label6 = new JLabel("密码:");
		label6.setFont(new Font("Courier",Font.BOLD,12));
		centerLeftThisPass.add(label6,BorderLayout.WEST);
		centerLeftThisPass.add(jpfSrcPassword,BorderLayout.CENTER);
		centerLeftThisPass.setBorder(BorderFactory.createEmptyBorder(2, 18, 2, 18));
		
		centerLeftThis.add(centerLeftThisDate);
		centerLeftThis.add(centerLeftThisID);
		centerLeftThis.add(centerLeftThisTime);
		centerLeftThis.add(centerLeftThisPass);
		centerLeft.add(centerLeftIF,BorderLayout.WEST);
		centerLeft.add(centerLeftThis,BorderLayout.CENTER);
		
		JPanel centerRight = new JPanel(new BorderLayout());
		JPanel centerRightThen = new JPanel(new FlowLayout(0));
		JLabel label7 = new JLabel("THEN ");
		label7.setFont(new Font("Courier",Font.PLAIN,29));
		centerRightThen.add(label7);
		JPanel centerRightThat = new JPanel(new GridLayout(2,1));
		centerRightThat.setBorder(new LineBorder(Color.gray));
		
		JPanel centerRightThatItems = new JPanel(new GridLayout(5,1,0,1));
		JLabel label8 = new JLabel("THAT");
		label8.setFont(new Font("Courier",Font.PLAIN,29));
		centerRightThatItems.add(label8);
		jcbWeiboOrMail.setBorder(BorderFactory.createEmptyBorder(2, 38, 2, 38));
		centerRightThatItems.add(jcbWeiboOrMail);
		
		JPanel centerRightWeiboID = new JPanel(new BorderLayout(20,5));
		//JLabel label9 = new JLabel("用户:");
		label9.setFont(new Font("Courier",Font.BOLD,12));
		centerRightWeiboID.add(label9,BorderLayout.WEST);
		centerRightWeiboID.add(jtfWeiboID,BorderLayout.CENTER);
		centerRightWeiboID.setBorder(BorderFactory.createEmptyBorder(2, 18, 2, 18));
		
		JPanel centerRightDesID = new JPanel(new BorderLayout(20,5));
		//JLabel label10 = new JLabel("邮箱:");
		label10.setFont(new Font("Courier",Font.BOLD,12));
		centerRightDesID.add(label10,BorderLayout.WEST);
		centerRightDesID.add(jtfDesID,BorderLayout.CENTER);
		centerRightDesID.setBorder(BorderFactory.createEmptyBorder(2, 18, 2, 18));
		
		JPanel centerRightWeiboPass = new JPanel(new BorderLayout(20,5));
		//JLabel label11 = new JLabel("密码:");
		label11.setFont(new Font("Courier",Font.BOLD,12));
		centerRightWeiboPass.add(label11,BorderLayout.WEST);
		centerRightWeiboPass.add(jpfWeiboPassword,BorderLayout.CENTER);
		centerRightWeiboPass.setBorder(BorderFactory.createEmptyBorder(2, 18, 2, 18));
		
		centerRightThatItems.add(centerRightWeiboID);
		centerRightThatItems.add(centerRightDesID);
		centerRightThatItems.add(centerRightWeiboPass);
		
		JPanel centerRightThatMessage = new JPanel(new BorderLayout());
		JLabel label12 = new JLabel("内容: ");
		label12.setFont(new Font("Courier",Font.BOLD,12));
		centerRightThatMessage.add(label12,BorderLayout.NORTH);
		JScrollPane weiboMessage = new JScrollPane(jtaContent);
		weiboMessage.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		weiboMessage.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		centerRightThatMessage.add(weiboMessage,BorderLayout.CENTER);
		centerRightThatMessage.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
		
		centerRightThat.add(centerRightThatItems);
		centerRightThat.add(centerRightThatMessage);
		centerRight.add(centerRightThen,BorderLayout.WEST);
		centerRight.add(centerRightThat,BorderLayout.CENTER);
		center.add(centerLeft);
		center.add(centerRight);
		
		JPanel buttonPane = new JPanel(new FlowLayout(1,60,20));
		buttonPane.add(jbtConfirm);
		buttonPane.add(jbtReset);
		buttonPane.add(jbtCancel);
		
		center.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 10));//up-left-down-right
		north.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 10));
		
		this.add(center,BorderLayout.CENTER);
		this.add(north,BorderLayout.NORTH);
		this.add(buttonPane,BorderLayout.SOUTH);
		
		addListener();
	}
	public void intialization(){
		jtfTaskName = new JTextField();
		String[] chooseType1 = {"时钟","收邮件"};
		jcbTimeOrMail = new JComboBox<String>(chooseType1);
		jcbTimeOrMail.setSelectedIndex(0);
		jtfDate =  new JTextField();
		jtfDate.setVisible(true);
		jtfTime = new JTextField();
		jtfTime.setVisible(true);
		jtfSrcID = new JTextField();
		jtfSrcID.setVisible(false);
		jpfSrcPassword = new JPasswordField();
		jpfSrcPassword.setVisible(false);
		String[] chooseType2 = {"发微博","发邮件"};
		jcbWeiboOrMail = new JComboBox<String>(chooseType2);
		jcbWeiboOrMail.setSelectedIndex(0);
		jtfWeiboID = new JTextField();
		jtfWeiboID.setVisible(true);
		jpfWeiboPassword = new JPasswordField();
		jpfWeiboPassword.setVisible(true);
		jtfDesID = new JTextField();
		jtfDesID.setVisible(false);
		jtaContent = new JTextArea();
		
		label3 = new JLabel("日期(yyyy-MM-dd): ");
		label3.setVisible(true);
		label4 = new JLabel("时间(hh:mm:ss): ");
		label4.setVisible(true);
		label5 = new JLabel("用户: ");
		label5.setVisible(false);
		label6 = new JLabel("密码: ");
		label6.setVisible(false);
		label9 = new JLabel("用户: ");
		label9.setVisible(true);
		label10 = new JLabel("邮箱: ");
		label10.setVisible(false);
		label11 = new JLabel("密码: ");
		label11.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setTitle("新建任务");
		this.setSize(690,490);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	public void resetAction(){
		jtfTaskName.setText("");
		jcbTimeOrMail.setSelectedIndex(0);
		jtfDate.setText("");
		jtfTime.setText("");
		jtfSrcID.setText("");
		jpfSrcPassword.setText("");
		jcbWeiboOrMail.setSelectedIndex(0);
		jtfWeiboID.setText("");
		jpfWeiboPassword.setText("");
		jtfDesID.setText("");
		jtaContent.setText("");
	}
	public void closeWindow(){
		this.setVisible(false);
	}
	public void addListener(){
		jbtReset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				resetAction();
			}
		});
		jbtCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				closeWindow();
			}
		});
		jbtConfirm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String description = "";
				if(timeOrMail == 0 && weiboOrMail == 0)
					description = "于 "+date+" "+time+" ,通过  "+weiboID+" 发微博";
				else if(timeOrMail == 1 && weiboOrMail == 0)
					description = srcID+" 收到邮件时,通过  "+weiboID+" 发微博";
				else if(timeOrMail == 1 && weiboOrMail == 1)
					description = srcID+" 收到邮件时,向  "+desID+" 发邮件";
				else
					description = "于 "+date+" "+time+" ,向 "+desID+" 发邮件";
				StartIFTTT.task[StartIFTTT.taskCount] = new TaskType("Task"+StartIFTTT.taskCount+" "+taskName,
						timeOrMail,date,time,srcID,srcPassword,weiboOrMail,
						weiboID,weiboPassword,desID,content,description);
				StartIFTTT.taskActive[StartIFTTT.taskCount] = 0;
				StartIFTTT.taskNameList[StartIFTTT.taskCount] = "Task"+StartIFTTT.taskCount+" "+taskName;
				StartIFTTT.taskDescription[StartIFTTT.taskCount] = description;
				MainFrame.taskChoose.addItem("Task"+StartIFTTT.taskCount+" "+taskName);
				StartIFTTT.taskCount++;
				closeWindow();
			}
		});
		jcbTimeOrMail.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				timeOrMail = jcbTimeOrMail.getSelectedIndex();
				if(timeOrMail == 0){
					jtfDate.setVisible(true);
					jtfTime.setVisible(true);
					label3.setVisible(true);
					label4.setVisible(true);
					jtfSrcID.setVisible(false);
					jtfSrcID.setText("");
					jpfSrcPassword.setVisible(false);
					jpfSrcPassword.setText("");
					label5.setVisible(false);
					label6.setVisible(false);
				}
				else{
					jtfSrcID.setVisible(true);
					jpfSrcPassword.setVisible(true);
					label5.setVisible(true);
					label6.setVisible(true);
					jtfDate.setVisible(false);
					jtfDate.setText("");
					jtfTime.setVisible(false);
					jtfTime.setText("");
					label3.setVisible(false);
					label4.setVisible(false);
				}
			}
		});
		jcbWeiboOrMail.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				weiboOrMail = jcbWeiboOrMail.getSelectedIndex();
				if(weiboOrMail == 0){
					jtfWeiboID.setVisible(true);
					label9.setVisible(true);
					jpfWeiboPassword.setVisible(true);
					label11.setVisible(true);
					jtfDesID.setVisible(false);
					jtfDesID.setText("");
					label10.setVisible(false);
				}
				else{
					jtfWeiboID.setVisible(false);
					jtfWeiboID.setText("");
					label9.setVisible(false);
					jpfWeiboPassword.setVisible(false);
					jpfWeiboPassword.setText("");
					label11.setVisible(false);
					jtfDesID.setVisible(true);
					label10.setVisible(true);
				}
			}
		});
		jtfTaskName.getDocument().addDocumentListener(new DocumentListener(){
			public void insertUpdate(DocumentEvent e){
				taskName = jtfTaskName.getText();
			}
			public void changedUpdate(DocumentEvent e){
				taskName = jtfTaskName.getText();
			}
			public void removeUpdate(DocumentEvent e){
				taskName = jtfTaskName.getText();
			}
		});
		jtfDate.getDocument().addDocumentListener(new DocumentListener(){
			public void insertUpdate(DocumentEvent e){
				date = jtfDate.getText();
			}
			public void changedUpdate(DocumentEvent e){
				date = jtfDate.getText();
			}
			public void removeUpdate(DocumentEvent e){
				date = jtfDate.getText();
			}
		});
		jtfTime.getDocument().addDocumentListener(new DocumentListener(){
			public void insertUpdate(DocumentEvent e){
				time = jtfTime.getText();
			}
			public void changedUpdate(DocumentEvent e){
				time = jtfTime.getText();
			}
			public void removeUpdate(DocumentEvent e){
				time = jtfTime.getText();
			}
		});
		jtfSrcID.getDocument().addDocumentListener(new DocumentListener(){
			public void insertUpdate(DocumentEvent e){
				srcID = jtfSrcID.getText();
			}
			public void changedUpdate(DocumentEvent e){
				srcID = jtfSrcID.getText();
			}
			public void removeUpdate(DocumentEvent e){
				srcID = jtfSrcID.getText();
			}
		});
		jpfSrcPassword.getDocument().addDocumentListener(new DocumentListener(){
			@SuppressWarnings("deprecation")
			public void insertUpdate(DocumentEvent e){
				srcPassword = jpfSrcPassword.getText();
			}
			@SuppressWarnings("deprecation")
			public void changedUpdate(DocumentEvent e){
				srcPassword = jpfSrcPassword.getText();
			}
			@SuppressWarnings("deprecation")
			public void removeUpdate(DocumentEvent e){
				srcPassword = jpfSrcPassword.getText();
			}
		});
		jtfWeiboID.getDocument().addDocumentListener(new DocumentListener(){
			public void insertUpdate(DocumentEvent e){
				weiboID = jtfWeiboID.getText();
			}
			public void changedUpdate(DocumentEvent e){
				weiboID = jtfWeiboID.getText();
			}
			public void removeUpdate(DocumentEvent e){
				weiboID = jtfWeiboID.getText();
			}
		});
		jpfWeiboPassword.getDocument().addDocumentListener(new DocumentListener(){
			@SuppressWarnings("deprecation")
			public void insertUpdate(DocumentEvent e){
				weiboPassword = jpfWeiboPassword.getText();
			}
			@SuppressWarnings("deprecation")
			public void changedUpdate(DocumentEvent e){
				weiboPassword = jpfWeiboPassword.getText();
			}
			@SuppressWarnings("deprecation")
			public void removeUpdate(DocumentEvent e){
				weiboPassword = jpfWeiboPassword.getText();
			}
		});
		jtfDesID.getDocument().addDocumentListener(new DocumentListener(){
			public void insertUpdate(DocumentEvent e){
				desID = jtfDesID.getText();
			}
			public void changedUpdate(DocumentEvent e){
				desID = jtfDesID.getText();
			}
			public void removeUpdate(DocumentEvent e){
				desID = jtfDesID.getText();
			}
		});
		jtaContent.getDocument().addDocumentListener(new DocumentListener(){
			public void insertUpdate(DocumentEvent e){
				content = jtaContent.getText();
			}
			public void changedUpdate(DocumentEvent e){
				content = jtaContent.getText();
			}
			public void removeUpdate(DocumentEvent e){
				content = jtaContent.getText();
			}
		});
	}
}
