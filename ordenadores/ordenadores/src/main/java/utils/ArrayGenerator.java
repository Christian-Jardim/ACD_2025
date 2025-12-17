package utils;
import java.util.Random;

public class ArrayGenerator {
	
	public static Integer[] generateRandomArray(int tamanho) {
        	Random random = new Random();
        	Integer[] array = new Integer[tamanho];

        	for (int i = 0; i < tamanho; i++) {
            		array[i] = random.nextInt(tamanho); // gera número de 0 a n
        	}
        	return array;
	}

	public static Integer[] generateAscendingArray(int tamanho) {
		Integer[] array = new Integer[tamanho];

		for(int i = 0; i < tamanho; i++){
			array[i] = i;
		}
		return array;
    	}

	public static Integer[] generateDescendingArray(int tamanho) {
		Integer[] array = new Integer[tamanho];

		for(int i = 0; i < tamanho; i++){
			array[i] = tamanho - i -1;
		}
		return array;
	}

	public static Integer[] generateRepeatedArray(int tamanho) {
		Integer[] array = new Integer[tamanho];
		Random random = new Random();
		
		int maxRepetidos = tamanho/2;

		for(int i = 0; i < tamanho; i++){
			array[i] = random.nextInt(maxRepetidos);
		}
		return array;
	}
}
