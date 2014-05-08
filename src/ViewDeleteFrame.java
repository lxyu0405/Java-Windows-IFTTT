import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ViewDeleteFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private String[] taskNameList = new String[StartIFTTT.taskCount];
	private JTextArea jtaTaskDescription;
	private String description;
	private JList<String> jlTaskChoose;
	private JButton jbtDelete = new JButton("删除");
	private JButton jbtQuit = new JButton("退出");
	public ViewDeleteFrame(){
		initialization();
		JPanel north = new JPanel(new FlowLayout(1));
		JLabel label0 = new JLabel("查看、删除任务");
		label0.setFont(new Font("Courier",Font.BOLD,29));
		north.add(label0);
		
		JPanel center = new JPanel(new GridLayout(1,2,30,20));
		
		JPanel centerLeft = new JPanel(new BorderLayout());
		centerLeft.setBorder(BorderFactory.createEmptyBorder(12, 15, 12, 15));
		JLabel jlabel1 = new JLabel("任务列表:");
		jlabel1.setFont(new Font("Courier",Font.BOLD,15));
		centerLeft.add(jlabel1,BorderLayout.NORTH);
		centerLeft.add(jlTaskChoose,BorderLayout.CENTER);
		
		JPanel centerRight = new JPanel(new BorderLayout());
		centerRight.setBorder(BorderFactory.createEmptyBorder(12, 15, 12, 15));
		JLabel jlabel2 = new JLabel("选中任务中的详细信息:");
		jlabel2.setFont(new Font("Courier",Font.BOLD,15));
		centerRight.add(jlabel2,BorderLayout.NORTH);
		JScrollPane jspTaskDescription = new JScrollPane(jtaTaskDescription);
		jspTaskDescription.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		centerRight.add(jspTaskDescription,BorderLayout.CENTER);
		
		center.add(centerLeft);
		center.add(centerRight);
		
		JPanel south = new JPanel(new FlowLayout(1,80,30));
		south.add(jbtDelete);
		south.add(jbtQuit);
		
		this.add(north,BorderLayout.NORTH);
		this.add(center,BorderLayout.CENTER);
		this.add(south,BorderLayout.SOUTH);
		jbtQuit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				closeWindow();
			}
		});
		jbtDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int index = jlTaskChoose.getSelectedIndex();
				if(index >= 1){
					for(int i = index;i < StartIFTTT.taskCount;i++)
						StartIFTTT.task[i] = StartIFTTT.task[i+1];
					StartIFTTT.taskCount--;
					closeWindow();
					MainFrame.taskChoose.removeItemAt(index);
				}
			}
		});
		jlTaskChoose.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e) {
				int index = jlTaskChoose.getSelectedIndex();
				jtaTaskDescription.setText(StartIFTTT.task[index].getDescription());
			}
		});
	}
	public void closeWindow(){
		this.setVisible(false);
	}
	public void initialization(){
		for(int i = 0;i < StartIFTTT.taskCount;i++)
			taskNameList[i] = StartIFTTT.task[i].getTaskName();
		description = StartIFTTT.task[0].getDescription();
		
		jlTaskChoose = new JList<String>(taskNameList);
		jlTaskChoose.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlTaskChoose.setBorder(new LineBorder(Color.gray));
		
		jtaTaskDescription = new JTextArea(description,11,30);
		jtaTaskDescription.setBorder(new LineBorder(Color.gray));
		jtaTaskDescription.setEditable(false);
		this.setTitle("查看、删除任务");
		this.setSize(690,490);
		this.setVisible(false);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
}
