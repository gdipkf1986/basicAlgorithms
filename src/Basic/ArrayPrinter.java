package Basic;

public class ArrayPrinter {
	
	public static void twoDimension(Object[][] array){
		System.out.print("\n");
		for(int i=0;i<array.length;i++){
			Object[] row = array[i];
			for(int j=0;j<row.length;j++){
				System.out.print(row[j]==null?" ":row[j].toString());
				if(j!=row.length-1){
					System.out.print(",");
				}
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
}
