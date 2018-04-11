package com.test.Test;

public class ParkingLot {
	
	public static int cost(String inTime, String outTime) {
		String[] entry = inTime.split(":");
		String[] exit = outTime.split(":");
		int inHour = getNumFromString(entry[0]);
		int inMin = getNumFromString(entry[1]);
		int outHour= getNumFromString(exit[0]);
		int outMin = getNumFromString(exit[1]);
		int totalHours = 0;
		if(inMin == 0) {
			totalHours = outHour - inHour;
			if(outMin > 0) {
				totalHours = totalHours + 1;
			}
		} else { 
			totalHours = outHour - inHour - 1;
			int totalMin = outMin + 60 - inMin;
			totalHours = (totalMin> 60) ? totalHours + 2 : totalHours + 1;
		}
		int totalCost = 2 + 3 + 4 * (totalHours - 1);
		return totalCost;
	}
	
	static int getNumFromString(String str) {
        int num = 0;
        for(int i=0; i<str.length(); i++) {
            num = num*10 + getIntFromChar(str.charAt(i));
        }
        return num;
    }
	
	static int getIntFromChar(char c) {
		switch (c) {
		case '1':
			return 1;
		case '2':
			return 2;
		case '3':
			return 3;
		case '4':
			return 4;
		case '5':
			return 5;
		case '6':
			return 6;
		case '7':
			return 7;
		case '8':
			return 8;
		case '9':
			return 9;
		default:
			return 0;
		}
	}
	
    public static void main( String[] args )
    {
        System.out.println(cost("10:00", "10:15"));
    }
}
