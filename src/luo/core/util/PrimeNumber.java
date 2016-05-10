package luo.core.util;

import java.util.HashMap;
import java.util.Map;

public class PrimeNumber {
	private static final Map<Integer, int[]> primeMap = new HashMap<Integer, int[]>();

	/**
	 * ������һ������
	 * 
	 * @param max
	 *            ������
	 * @param pre
	 *            ��һ������
	 * @return ���û����һ���򷵻�0�������һ�������ڷ�Χ�ڣ�����-1��
	 */
	public static int getNextPrime(int max, int pre) {
		int[] primeArr = primeMap.get(max);
		if (primeArr == null) {
			primeArr = generatorPrimes(max);
			primeMap.put(max, primeArr);
		}
		return getNext(primeArr, pre);
	}

	/**
	 * Ѱ����һ��
	 * 
	 * @param primeArr
	 * @param pre
	 * @return
	 */
	private static int getNext(int[] primeArr, int pre) {
		for (int i = 0; i < primeArr.length; i++) {
			if (pre == primeArr[i]) {
				if (primeArr.length > i + 1) {
					return primeArr[i + 1];
				} else {
					return 0;
				}
			}
		}
		return -1;
	}

	/**
	 * ��������
	 * 
	 * @param max
	 * @return
	 */
	private static int[] generatorPrimes(int max) {
		int size = max + 1;
		int[] allArr = new int[size];
		// 0��1����������
		allArr[0] = 1;
		allArr[1] = 1;
		// �ڿ�
		for (int i = 2; i < Math.sqrt(size - 1); i++) {
			if (allArr[i] == 0) {
				for (int j = 2; j <= ((size - 1) / i); j++) {
					allArr[i * j] = 1;
				}
			}
		}
		// ��������
		int primeCount = 0;
		for (int i = 0; i < allArr.length; i++) {
			primeCount += allArr[i];
		}
		primeCount = size - primeCount;
		// ��������
		int[] primeArr = new int[primeCount];
		int index = 0;
		for (int i = 0; i < allArr.length; i++) {
			if (allArr[i] == 0) {
				primeArr[index++] = i;
			}
		}
		return primeArr;
	}
}
