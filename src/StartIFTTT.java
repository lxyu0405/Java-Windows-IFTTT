
public class StartIFTTT {

	public static TaskType[] task = new TaskType[20];
	public static int[] taskActive = new int[20];
	public static int taskCount = 1;
	public static String[] taskNameList = new String[20];
	public static String[] taskDescription = new String[20];
	public static MainFrame mainFrame;
			/**
	 * @param args
	 */
	public static void main(String[] args) {
		task[0] = new TaskType();
		/*task[1] = new TaskType("task 1 weibo at time",0,"2013-11-11","12:00",
				"","",0,"1225339342@qq.com","******","","deliver weibo when",
				"descriptionLove1");
		taskCount++;
		task[2] = new TaskType("task 2 send email at time",0,"2013-11-13","22:54:00",
				"","",1,"","","1225339342@qq.com","send email when",
				"descriptionLove2");
		taskCount++;
		task[3] = new TaskType("task 3 receive email->deliver weibo",1,"2013-01-23",
				"12:49","xiaoyu.lu0405@gmail.com","deskmate2314",0,"1225339342@qq.com",
				"************","","receive email->deliver weibo","descriptionLove3");
		taskCount++;
		task[4] = new TaskType("task 4 receive email->send email",1,"2012-11-13",
				"23:34","xiaoyu.lu0405@gmail.com","1234567890",1,"","","1225339342@qq.com",
				"I received an email,thx~\nreceive email->send email","descriptionLove4");
		taskCount++;*/
		mainFrame =  new MainFrame();
		mainFrame.setVisible(true);
	}

}
