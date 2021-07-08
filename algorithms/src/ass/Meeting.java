package ass;

import java.util.*;

public class Meeting {
	private int num;
	private int start;
	private int end;
	private int time;
	
	//생성자
	private Meeting(int num, int start, int end, int time) {
		this.num = num;
		this.start = start;
		this.end = end;
		this.time = time;
	}
	
	//시간을 입력받아 미팅 객체를 만들고 전체 미팅 배열을 만드는 createMeetings()
	public static Meeting[] createMeetings() {
		Scanner scan = new Scanner(System.in);
		
		//신청 개수를 입력받고 유효성 체크 후 빈 배열 생성
		int length;
		while(true) {
			System.out.print("회의 신청 개수: ");
			length = scan.nextInt();
			if(length>=5 && length<=10) break;
			else {
				System.out.println("회의 개수를 5개 이상, 10개 이하의 값으로 입력해주세요.");
				continue;
			}
		}
		Meeting[] meetings = new Meeting[length];
		
		//입력 시간, 종료 시간을 입력받으며 각 값에 대해 checkTime()으로 유효성 체크
		Loop1:
			for(int i=0; i<length; i++) {
			int num, start, end, time;
			num = i+1;
			//시작 시간
			System.out.print("회의 " + (i+1) + " 시작 시간: ");
			start = scan.nextInt();
			if(!checkTime(start)) {
				i -= 1; 
				continue; 
			}
			//종료 시간
			System.out.print("회의 " + (i+1) + " 종료 시간: ");
			end = scan.nextInt();
			if(!checkTime(end)) {
				i -= 1; 
				continue; 
			}
			//소요 시간 계산
			time = end - start;
			if(!checkTime(time)) {
				i -= 1;
				continue;
			}
			//다른 회의와 동일한 시간인지 체크
			for(int j=0; j<i; j++) {
				if(meetings[j].start == start && meetings[j].end == end) {
					System.out.println((j+1) + "번째 입력한 회의와 시작 및 종료 시간이 동일합니다. 다시 입력해주세요.");
					i -=1;
					continue Loop1;
				}
			}
			
			//모두 유효한 값이면 미팅 객체 생성 후 배열에 저장
			meetings[i] = new Meeting(num, start, end, time);
		}
		return meetings;
	}
	
	//미팅 배열을 입력받아 출력하는 printMeeting()
	public static void printMeeting(Meeting[] meetings) {
		
		int length=0;
		for(int i=0; i<meetings.length; i++) {
			if(meetings[i] != null) { length += 1;}
		}
		
		System.out.println("배정 가능 회의 개수: " + length);
		
		//sortMeetingStart(meetings, length);
		
		for(int i=0; i<length; i++) {
			if(i!=(length-1)) {
				System.out.print(meetings[i].num + "->");
			} else {System.out.print(meetings[i].num + "\n");}
		}
		
		for(int i=0; i<length; i++) {
			if(i!=(length-1)) {
				System.out.print(meetings[i].start + "~" + meetings[i].end + "시->");
			} else {System.out.print(meetings[i].start + "~" + meetings[i].end + "시");}
		}
	}
	
	//미팅 배열을 입력받아 종료 시간이 빠른 순서대로 삽입 정렬하는 sortMeetingTime()
	public static void sortMeetingTime(Meeting[] meetings) {
		
		int i, j;
		Meeting insertElement;
		int n = meetings.length;
		
		for(i=1; i<n; i++) {
			insertElement = meetings[i];
			j = i-1;
			
			while( j>=0 && meetings[j].time>insertElement.time ) {
				meetings[j+1] = meetings[j];
				j = j-1;
			}
			
			meetings[j+1] = insertElement; //삽입			
		}
	}

	//미팅 배열과 정렬할 길이를 입력받아 시간대 순으로 삽입 정렬하는 sortMeetingStart()
	/*public static void sortMeetingStart(Meeting[] meetings, int length) {
		
		int i, j;
		Meeting insertElement;
		
		//start가 작은 순서대로 정렬
		for(i=1; i<length; i++) {
			insertElement = meetings[i];
			j = i-1;
			
			while( j>=0 && meetings[j].start>insertElement.start ) {
				meetings[j+1] = meetings[j];
				j = j-1;
			}
			
			meetings[j+1] = insertElement; //삽입			
		}
	}
	*/
	
	public static Meeting[] greedMeeting(Meeting[] meetings) {
		
		sortMeetingTime(meetings);
		
		Meeting[] schedule = new Meeting[meetings.length];
		
		int j=1;
		schedule[j-1] = meetings[0];
		
		for(int i=1; i<meetings.length; i++) {
			for(int k=0; k<j; k++) {
				if(!((meetings[i].start>=schedule[k].end)||(meetings[i].end<=schedule[k].start))) {
					break;}

			}
			schedule[j] = meetings[i]; j++;
			
		}
		
		
		return schedule;
	}
	
	//시간이 유효한 값인지 확인하는 checkTime()
	public static boolean checkTime(int i) {
		if(i<=0 || i>=24) {
			System.out.println("시간을 다시 입력해주세요. 시간은 0~23 사이의 값이어야 하며 종료시간은 시작 시간 이후여야 합니다.");
			return false;
		}
		return true;
	}
	
	
	

}
