import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.text.ParseException;
import java.util.Date;

import javax.mail.Folder;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.Timer;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private String[] taskNameList = new String[StartIFTTT.taskCount];
	public static JComboBox<String> taskChoose;
	public static JTextArea taskInfo;
	private String description;
	private JTextArea info;
	private Timer timer;
	private String formerText;
	private static TaskType tempTask;
	private Date tempDate;
	private Folder folder;
	private static int activeTask = 0;
	private int index;
	//private static int clickCount = 0;
	public MainFrame(){
		initialization();
		//设置menu
		CreateMenu menu = new CreateMenu();
		this.setJMenuBar(menu.getMenubar());
		
		JPanel center = new JPanel(new GridLayout(1,2));		
		JPanel centerLeft = new JPanel(new BorderLayout(20,20));		
		JPanel chooseType = new JPanel(new BorderLayout());
		JLabel jlb = new JLabel("             单机版IFTTT");
		jlb.setFont(new Font("Courier",Font.BOLD,29));
		chooseType.add(jlb,BorderLayout.CENTER);		
		JPanel subChoosePane = new JPanel(new BorderLayout(10,10));
		JLabel label1 = new JLabel("选择需要运行的任务:");
		label1.setFont(new Font("Courier",Font.BOLD,12));		
		subChoosePane.add(label1,BorderLayout.WEST);
			
		subChoosePane.add(taskChoose,BorderLayout.CENTER);
		chooseType.add(subChoosePane,BorderLayout.SOUTH);
		
		JPanel taskInfomation = new JPanel(new BorderLayout());
		JLabel jlb1 = new JLabel("正在运行的任务描述:");
		jlb1.setFont(new Font("Courier",Font.BOLD,12));
		taskInfomation.add(jlb1,BorderLayout.NORTH);
		taskInfo = new JTextArea(description,6,13);
		taskInfo.setLineWrap(true);
		taskInfo.setWrapStyleWord(true);
		taskInfo.setEditable(false);
		JScrollPane taskScrollInfo = new JScrollPane(taskInfo);
		taskScrollInfo.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		taskInfomation.add(taskScrollInfo,BorderLayout.SOUTH);
		
		centerLeft.add(chooseType,BorderLayout.NORTH);		
		centerLeft.add(taskInfomation,BorderLayout.SOUTH);
		centerLeft.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
	
		JPanel centerRight = new JPanel(new FlowLayout());
		JTextArea instructions = new JTextArea("使用说明:\n" +
				"1.首先用户新建任务\n" +
				"2.然后选择控制->运行任务来开始任务\n" +
				"3.可在下列文本域内查看当前任务的完整性描述\n\n",11,30);
		instructions.setLineWrap(true);
		instructions.setWrapStyleWord(true);
		instructions.setEditable(false);
		instructions.setBorder(new LineBorder(Color.gray));
		centerRight.add(instructions,BorderLayout.CENTER);
		centerRight.setBorder(BorderFactory.createEmptyBorder(8,0,0,0));	
		center.add(centerLeft);
		center.add(centerRight);
		this.add(center,BorderLayout.CENTER);
		
		JPanel outputInfo = new JPanel(new BorderLayout());
		Label outputLabel = new Label("输出信息:");
		outputLabel.setFont(new Font("Courier",Font.BOLD,12));
		outputInfo.add(outputLabel,BorderLayout.NORTH);
		
		JScrollPane outputScrollInfo = new JScrollPane(info);
		outputScrollInfo.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		outputInfo.setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 8));
		outputInfo.add(outputScrollInfo,BorderLayout.CENTER);	
		this.add(outputInfo,BorderLayout.SOUTH);
		this.setTitle("IFTTT");
		
		taskChoose.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int index = taskChoose.getSelectedIndex();
				taskInfo.setText(StartIFTTT.task[index].getDescription());
			}
		});
	}
	public void initialization(){
		for(int i = 0;i < StartIFTTT.taskCount;i++)
			taskNameList[i] = StartIFTTT.task[i].getTaskName();
		taskChoose = new JComboBox<String>(taskNameList);
		taskChoose.setSelectedIndex(0);
		description = StartIFTTT.task[0].getDescription();
		info = new JTextArea("当前任务的执行情况...",11,15);
		info.setLineWrap(true);
		info.setWrapStyleWord(true);
		info.setEditable(false);
		tempTask = new TaskType();
		this.setSize(700,500);
		this.setVisible(false);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	class CreateMenu {
		JMenuBar menubar = new JMenuBar();
		JMenu file;
		JMenu control;
		JMenu help;
		JMenuItem create,change,delete,view;
		JMenuItem start,pause,end;
		JMenuItem about;
		public JMenuBar getMenubar(){
			return menubar;
		}
		public CreateMenu(){
			//构造“任务”菜单选项
			MainActionListener listen = new MainActionListener();
			file = new JMenu("任务");
			control = new JMenu("控制");
			help = new JMenu("帮助");
			create = new JMenuItem("新建任务...    Ctrl-N");
			create.setMnemonic('N');
			create.addActionListener(listen);
			change = new JMenuItem("修改任务...    Ctrl-C");
			change.setMnemonic('C');
			change.addActionListener(listen);
			delete = new JMenuItem("删除任务...    Ctrl-D");
			delete.setMnemonic('D');
			delete.addActionListener(listen);
			view = new JMenuItem("查看所有任务...    Ctrl-V");
			view.setMnemonic('V');
			view.addActionListener(listen);
			file.add(create);
			file.add(change);
			file.add(delete);
			file.add(view);
			//构造“控制”菜单选项
			start = new JMenuItem("开始任务...    Ctrl-Y");
			start.setMnemonic('Y');
			start.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(activeTask != 0)
						JOptionPane.showMessageDialog(null,"A task is running!","Warning",JOptionPane.INFORMATION_MESSAGE);
					else{
						index = taskChoose.getSelectedIndex();
						tempTask = StartIFTTT.task[index];
						if(index >= 1){
							//if(StartIFTTT.taskActive[index] == 1)
							//	JOptionPane.showMessageDialog(null,"The task is running~","Warning",JOptionPane.INFORMATION_MESSAGE);
							//else{
								if(tempTask.getThisType() == 0){
									if(tempTask.getThatType() == 0){
										//time->weibo
										timer = new Timer(1000,new ActionListener(){
											public void actionPerformed(ActionEvent e){
												//System.out.println(tempTask.getCurrentTime());
												try {
													//System.out.println(tempTask.getGoalTime());
													formerText = info.getText() + "\n";
													info.setText(formerText+"Now ("+tempTask.getCurrentTime()+")  Goa" +
															"lTime ("+tempTask.getGoalTime()+") : Waiting...");
													if(TaskType.dateEqual(tempTask.getCurrentTime(), tempTask.getGoalTime())){	
															WeiboAction.SendWeibo(tempTask.getContent());
															formerText = info.getText()+"\n";
															info.setText(formerText+"1225339342@qq.com"+" updated status successfully!");
															activeTask--;
															StartIFTTT.taskActive[index]--;
															timer.stop();
													}
												} catch (Exception e1) {
													e1.printStackTrace();
												}
											}
										});
										timer.start();
										activeTask++;
										StartIFTTT.taskActive[index]++;
									}
									else{
										//time->email
										timer = new Timer(1000,new ActionListener(){
											public void actionPerformed(ActionEvent e){
												//System.out.println(tempTask.getCurrentTime());
												try {
													//System.out.println(tempTask.getGoalTime());
													formerText = info.getText() + "\n";
													info.setText(formerText+"Now ("+tempTask.getCurrentTime()+")  Goa" +
															"lTime ("+tempTask.getGoalTime()+") : Waiting...");
													if(TaskType.dateEqual(tempTask.getCurrentTime(), tempTask.getGoalTime())){
															MailAction.SendMail("xiaoyu.lu0405@gmail.com", "deskmate2314", tempTask.getDesID(), tempTask.getContent());
															formerText = info.getText()+"\n";
															info.setText(formerText+"send email to "+tempTask.getDesID()+" successfully!");
															activeTask--;
															StartIFTTT.taskActive[index]--;
															timer.stop();
													}
												} catch (Exception e1) {
													e1.printStackTrace();
												}
											}
										});
										timer.start();
										activeTask++;
										StartIFTTT.taskActive[index]++;
									}
								}
								else{
									if(tempTask.getThatType() == 1){
										//email->email
										formerText = info.getText() + "\n";
										info.setText(formerText+"Now ("+tempTask.getCurrentTime()+") : Signing in "+tempTask.getSrcID()+"");
										tempDate = new Date();
										//System.out.println("email->email listener");
										folder = MailAction.SignIn(tempTask.getSrcID(), tempTask.getSrcPassword());
										if(folder == null){
											formerText = info.getText() + "\n";
											info.setText(formerText+"Now ("+tempTask.getCurrentTime()+") : Signing in "+tempTask.getSrcID()+" Failure..");
										}
										else{
											timer = new Timer(1000,new ActionListener(){
												public void actionPerformed(ActionEvent e){
													formerText = info.getText() + "\n";
													info.setText(formerText+"Now ("+tempTask.getCurrentTime()+") : Testing the "+tempTask.getSrcID()+"'s inbox");
													if(MailAction.CheckReceivedMail(folder, tempDate)){
														try {
															MailAction.SendMail(tempTask.getSrcID(), tempTask.getSrcPassword(), tempTask.getDesID(), tempTask.getContent());
															formerText = info.getText()+"\n";
															info.setText(formerText+"send email to "+tempTask.getDesID()+" successfully!");
															activeTask--;
															StartIFTTT.taskActive[index]--;
															timer.stop();
														} catch (Exception e1) {
															// TODO Auto-generated catch block
															e1.printStackTrace();
														}
													}
												}
											});
											timer.start();
											activeTask++;
											StartIFTTT.taskActive[index]++;
										}
									}
									else{
										//email->weibo
										formerText = info.getText() + "\n";
										info.setText(formerText+"Now ("+tempTask.getCurrentTime()+") : Signing in "+tempTask.getSrcID()+"");
										tempDate = new Date();
										//System.out.println("email->email listener");
										folder = MailAction.SignIn(tempTask.getSrcID(), tempTask.getSrcPassword());
										if(folder == null){
											formerText = info.getText() + "\n";
											info.setText(formerText+"Now ("+tempTask.getCurrentTime()+") : Signing in "+tempTask.getSrcID()+" Failure..");
										}
										else{
											timer = new Timer(1000,new ActionListener(){
												public void actionPerformed(ActionEvent e){
													formerText = info.getText() + "\n";
													info.setText(formerText+"Now ("+tempTask.getCurrentTime()+") : Testing the "+tempTask.getSrcID()+"'s inbox");
													if(MailAction.CheckReceivedMail(folder, tempDate)){
														try {
															WeiboAction.SendWeibo(tempTask.getContent());
															formerText = info.getText()+"\n";
															info.setText(formerText+"send email to "+tempTask.getDesID()+" successfully!");
															activeTask--;
															StartIFTTT.taskActive[index]--;
															timer.stop();			
														} catch (Exception e1) {
															// TODO Auto-generated catch block
															e1.printStackTrace();
														}
													}
												}
											});
											timer.start();
											activeTask++;
											StartIFTTT.taskActive[index]++;
										}
									}
								}
							}
						//}
					}
				}
			});
			pause = new JMenuItem("暂停任务...    Ctrl-P");
			pause.setMnemonic('P');
			pause.addActionListener(listen);
			end = new JMenuItem("结束任务...    Ctrl-N");
			end.setMnemonic('N');
			end.addActionListener(listen);
			control.add(start);
			control.add(pause);
			control.add(end);
			//构造“帮助”菜单选项
			about = new JMenuItem("关于...    Ctrl-A");
			about.setMnemonic('A');
			about.addActionListener(listen);
			help.add(about);
			//添加到menubar中
			menubar.add(file);
			menubar.add(control);
			menubar.add(help);
		}
		private class MainActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Object src = e.getSource();
			if(src == create){
				@SuppressWarnings("unused")
				NewTaskFrame newFrame = new NewTaskFrame();
			}
			else if(src == change){
				@SuppressWarnings("unused")
				ChangeFrame changeFrame = new ChangeFrame();
			}
			else if(src == view || src == delete){
				ViewDeleteFrame viewDeleteFrame = new ViewDeleteFrame();
				viewDeleteFrame.setVisible(true);
			}
			else if(src == about){
				String temp= "If you are bothered by any bugs,Please\n  email your complaints to 1225339342@qq.com(推荐" +
						") \\ lxyu0405@sina.com \n                                         —Xiaoyu";
				JOptionPane.showMessageDialog(null,temp,"Version 1.0.0",JOptionPane.INFORMATION_MESSAGE);
			}
			else if(src == pause){
				int index = taskChoose.getSelectedIndex();
				if(StartIFTTT.taskActive[index] == 0)
					JOptionPane.showMessageDialog(null,"Task "+index+" is not active now!","Warning",JOptionPane.INFORMATION_MESSAGE);
				else{
					//int index = taskChoose.getSelectedIndex();
					TaskType tempTask = StartIFTTT.task[index];
					Date tempDate = new Date();
					String former = info.getText()+"\n";
					info.setText(former+tempDate+":   "+tempTask.getTaskName() + " is currently paused..");
					timer.stop();
				}
			}
			else if(src == end){
				int index = taskChoose.getSelectedIndex();
				if(StartIFTTT.taskActive[index] == 0)
					JOptionPane.showMessageDialog(null,"Task "+index+" is not active now!","Warning",JOptionPane.INFORMATION_MESSAGE);
				else{
					timer.stop();
					activeTask--;
					StartIFTTT.taskActive[index]--;
					info.setText("当前任务的执行情况...");
				}
			}
		}
	}	
		
	}

}
