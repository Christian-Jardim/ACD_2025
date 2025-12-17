package utils;
import java.util.Random;

public class Vectors{
	static Integer[] vector_asc = {0,1,2,3,4,5,6,7,8,9};
	static Integer[] vector_dec = {9,8,7,6,5,4,3,2,1,0};
	static Integer[] vector_ale = ArrayGenerator.generateRandomArray(10);
	static Integer[] vector_rep = {0,5,7,3,9,2,9,3,1,0};
    
    public static Integer[] escolheVetorTeste(int vetor) {
		switch(vetor) {
			case 1:
				return vector_asc;
			case 2:
				return vector_dec;
			case 3:
				return vector_ale;
			case 4:
				return vector_rep;
			default:
				return null;
			}
	}

	public static Integer[] escolheVetorPersonalizado(int vetor, int n) {
		Integer[] array = null;
		
		switch(vetor) {
			case 1:
				array = ArrayGenerator.generateAscendingArray(n);
				return array;
			case 2:
				array = ArrayGenerator.generateDescendingArray(n);
				return array;
			case 3:
				array = ArrayGenerator.generateRandomArray(n);
				return array;
			default:
				return null;
			}
	}
	
	public static void display(Integer[] array){
		System.out.print("\n");
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
            if(i < (array.length - 1)) {
				System.out.print(",");
			}
        }
        System.out.print("\n");
    }
}
