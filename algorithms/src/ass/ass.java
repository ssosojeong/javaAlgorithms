package ass;

public class ass {

	public static void main(String[] args) {
		
		Meeting[] meetings = Meeting.createMeetings();
		Meeting.printMeeting(meetings);
		System.out.println();
		
		
	
		
		
		Meeting[] schedule = Meeting.greedMeeting(meetings);
		
		
		Meeting.printMeeting(schedule);

		


	}

}
