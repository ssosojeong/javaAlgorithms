package assignment;

public class MeetingMain {

	public static void main(String[] args) {
		
		//회의 목록 입력
		Meeting[] meetings = Meeting.createMeetings();

		//그리디 알고리즘을 통한 회의실 배정
		Meeting[] schedule = Meeting.greedMeeting(meetings);
		
		//배정 목록 출력
		Meeting.printMeeting(schedule);
		
	}

}
