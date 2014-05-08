import java.text.SimpleDateFormat;
import java.util.Date;

//import javax.mail.internet.ParseException;


public class TaskType {
	private String taskName;
	private int timeOrMail;//0-time;1-mail
	private String date;
	private String time;
	private String srcID;
	private String srcPassword;
	private int weiboOrMail;//0-weibo;1-mail
	private String weiboID;
	private String weiboPassword;
	private String desID;
	private String content;
	private String description;
	
	public TaskType(){
		super();
		this.taskName = "(空白)";
		this.timeOrMail = 0;
		this.date = "";
		this.time = "";
		this.srcID = "";
		this.srcPassword = "";
		this.weiboOrMail = 1;
		this.weiboID = "";
		this.weiboPassword = "";
		this.desID = "";
		this.content = "";
		this.description = "这里展示任务的描述";
	}
	public TaskType(String taskName,int timeOrMail,String date,String time,String srcID,String srcPassword,
			int weiboOrMail,String weiboID,String weiboPassword,String desID,String content,String description){
		this.taskName = taskName;
		this.timeOrMail = timeOrMail;
		this.date = date;
		this.time = time;
		this.srcID = srcID;
		this.srcPassword = srcPassword;
		this.weiboOrMail = weiboOrMail;
		this.weiboID = weiboID;
		this.weiboPassword = weiboPassword;
		this.desID = desID;
		this.content = content;
		this.description = description;
		showTask(this);
	}
	public void changeTask(int timeOrMail,String date,String time,String srcID,String srcPassword,
			int weiboOrMail,String weiboID,String weiboPassword,String desID,String content){
		//this.taskName = taskName;
		this.timeOrMail = timeOrMail;
		this.date = date;
		this.time = time;
		this.srcID = srcID;
		this.srcPassword = srcPassword;
		this.weiboOrMail = weiboOrMail;
		this.weiboID = weiboID;
		this.weiboPassword = weiboPassword;
		this.desID = desID;
		this.content = content;
		showTask(this);
	}
	
	public void showTask(TaskType task){
		System.out.println(task.taskName+"\n time or mail "
				+task.timeOrMail+"\n date "
				+task.date+"\n time "
				+task.time+"\n srcID "
				+task.srcID+"\n srcPassword"
				+task.srcPassword+"\n weibo or mail"
				+task.weiboOrMail+"\n weiboID "
				+task.weiboID+"\n weiboPassword "
				+task.weiboPassword+"\n desID "
				+task.desID+"\n content "
				+task.content+"\n description "
				+task.description);
	}
	
	public static boolean dateEqual(Date current,Date goal){
		if(current.toString().compareTo(goal.toString()) == 0)
			return true;
		else
			return false;
	}
	
	public Date getCurrentTime(){
		Date date = new Date();
		return date;
	}
	public Date getGoalTime() throws java.text.ParseException {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		date = format.parse(this.date+" "+this.time);	
		return date;
	}

	public String getTaskName(){
		return this.taskName;
	}
	public void setTaskName(String taskName){
		this.taskName = taskName;
	}
	public int getThisType(){
		return this.timeOrMail;
	}
	public void setThisType(int timeOrMail){
		this.timeOrMail = timeOrMail;
	}
	public String getDate(){
		return this.date;
	}
	public void setDate(String date){
		this.date = date;
	}
	public String getTime(){
		return this.time;
	}
	public void setTime(String time){
		this.time = time;
	}
	public String getSrcID(){
		return this.srcID;
	}
	public void setSrcID(String srcID){
		this.srcID = srcID;
	}
	public String getSrcPassword(){
		return this.srcPassword;
	}
	public void setSrcPassword(String srcPassword){
		this.srcPassword = srcPassword;
	}
	public int getThatType(){
		return this.weiboOrMail;
	}
	public void setThatType(int weiboOrType){
		this.weiboOrMail = weiboOrType;
	}
	public String getWeiboID(){
		return this.weiboID;
	}
	public void setWeiboID(String weiboID){
		this.weiboID = weiboID;
	}
	public String getWeiboPassword(){
		return this.weiboPassword;
	}
	public void setWeiboPassword(String weiboPassword){
		this.weiboPassword = weiboPassword;
	}
	public String getDesID(){
		return this.desID;
	}
	public void setDesID(String desID){
		this.desID = desID;
	}
	public String getContent(){
		return this.content;
	}
	public void setContent(String content){
		this.content = content;
	}
	public String getDescription(){
		return this.description;
	}
}
