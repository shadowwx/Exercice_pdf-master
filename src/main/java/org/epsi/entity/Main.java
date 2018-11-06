package org.epsi.entity;


public class Main {

	public static void main(String[] args) {
		
		int []tableNombre = {0,1,2,3,4,5,6,7,8,9,10};
		int maxOccurenceTable = tableNombre.length;
//		calculNombre(tableNombre);
		
		
		
		System.out.println(maxOccurenceTable);
		System.out.println(calculTotal(tableNombre));

	}
	
	public static int calculTotal(int[] tableNombre) {
		int result = 0;
		for(int i = 0; i < tableNombre.length; i++) {
			result = result + tableNombre[i];
		}
		return result;
	}
	
//	public int calculNombre(int maxOccurenceTable) {
//		for(int i = maxOccurenceTable; i <= maxOccurenceTable; i++) {
//			int total = i + i;
//			System.out.println(total);
//		}
//		return maxOccurenceTable;
//	}
	
}
