import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;

public class codewars {
	public static void main(String[] args) {

		// int[] names2 = { 1, 2, 3, 4, 5, 6 };
		// int[] arr = new int[names.length + names2.length];
		// Integer uniqueNumber = find(names);
		// Date current = new Date(105, 5, 4, 12, 15, 0);
		// System.out.println(current.getYear());
		// System.out.println(current.getMonth());
		// System.out.println(current.getDate());
		// System.out.println(current.getDay());
		// String[] arr = {
		// ";~d", "(~X", ";p)", "~4o)", ":)", ":d", "'pd", "(2)", "5dd", ":-D", "o~)",
		// "8)", "ooD", ";)", ";~D",
		// "p2D", "oX", ";)", "8~)", ":P", "')", "pD", "(~D", "4~x", ";D", ";)", "'D"
		// };

		// // Создание списка и добавление в него элементов массива
		// List<String> b = new ArrayList<>();
		// for (String s : arr) {
		// b.add(s);
		// }
		// List<String> a = new ArrayList<String>();
		// a.add(":)");
		// a.add(":)");
		// a.add("x-]");
		// a.add(":ox");
		// a.add(";-(");
		// a.add(";-)");
		// a.add(";~(");
		// a.add(":~D");
		String original = "test original";
		String[] words = original.split(" ");
		String str = "";
		for (int i = 0; i < words.length; i++) {
			char ch = words[i].charAt(0);
			str += Character.toUpperCase(ch);
			if (i == words.length - 1)
				break;
			else
				str += ".";
		}
		int[] names2 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(sequence(names2));

	}

	public static int sequence(int[] arr) {
		if (arr.length == 0)
			return 0;
		boolean allNegative = true;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 0) {
				allNegative = false;
			}
		}
		if (allNegative)
			return 0;
		else {
			int maxSoFar = arr[0];
			int maxEndingHere = arr[0];

			for (int i = 1; i < arr.length; i++) {
				maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
				maxSoFar = Math.max(maxSoFar, maxEndingHere);
			}
			return maxSoFar;
		}

	}

	// таблица умножения
	public static int[][] multiplicationTable(int n) {
		int[][] matrix = new int[n][n];
		int rowValue = 1;
		int colValue = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = rowValue * colValue;

				colValue++;
			}
			rowValue++;
			colValue = 1;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		return matrix;
	}

	//
	public static int[] removeSmallest(int[] numbers) {
		if (numbers.length == 0) {
			return numbers;
		}
		List<Integer> intList = new ArrayList<>();
		int[] arr = new int[numbers.length - 1];
		int indexMin = 0;
		int min = numbers[0];
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] < min) {
				min = numbers[i];
				indexMin = i;
			}
		}
		for (int i = 0; i < numbers.length; i++) {
			if (i == indexMin)
				continue;
			else
				intList.add(numbers[i]);
		}
		for (int i = 0; i < intList.size(); i++) {
			arr[i] = intList.get(i);
		}
		return arr;
	}

	public int sum(List<?> mixed) {

		List<Integer> intList = new ArrayList<>();

		for (Object element : mixed) {
			if (element instanceof Integer) {
				intList.add((Integer) element);
			} else if (element instanceof String) {
				try {
					intList.add(Integer.parseInt((String) element));
				} catch (NumberFormatException e) {
					// Игнорируем элементы, которые не могут быть преобразованы в int
				}
			}
		}

		int sum = 0;
		for (int element : intList) {
			sum += element;
		}
		return sum;
	}

	public static int countSmileys(List<String> arr) {
		// Just Smile :)
		int countSmile = 0;
		for (String str : arr) {
			if (str.equals(";D") || str.equals(":D") || str.equals(":-D") || str.equals(";~D") || str.equals(":~D")
					|| str.equals(";-D") ||
					str.equals(":)") || str.equals(";)") || str.equals(":-)") || str.equals(";~)") || str.equals(":~)")
					|| str.equals(";-)")) {
				// Ваш код здесь
				countSmile++;
			}

		}
		return countSmile;
	}

	public static int removeElement(int[] nums, int val) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				list.add(nums[i]);
			}
		}
		return list.size();
	}

	// Найти слова у которого больше всех очков - считается по расположение в
	// алфавите
	public static String high(String s) {
		String[] words = s.split(" ");
		int[] scoreLetters = new int[words.length];
		int score = 0;
		for (int i = 0; i < words.length; i++) {
			char[] chWords = words[i].toCharArray();
			for (int j = 0; j < chWords.length; j++) {
				score += chWords[j] - 'a' + 1;
			}
			scoreLetters[i] = score;
			score = 0;
		}
		int index = 0;
		for (int i = 0; i < scoreLetters.length; i++) {
			if (scoreLetters[i] > score) {
				score = scoreLetters[i];
				index = i;
			}
		}
		return words[index];
	}

	// поиск в массиве дубликата
	public static int findDubDigit(int[] arr) {
		int digit = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i == j) {
					continue;
				} else if (arr[i] == arr[j]) {
					digit = arr[j];
					break;
				}
			}
		}
		return digit;
	}

	// увелечение каждой буквы +1
	public static String accum(String s) {
		String sToLowerCase = s.toLowerCase();
		String str = "";
		for (int i = 0; i < sToLowerCase.length(); i++) {
			char ch = sToLowerCase.charAt(i);
			int j = 0;
			while (j <= i) {
				if (j == 0)
					str += Character.toUpperCase(ch);
				else if (!Character.isLetterOrDigit(ch))
					break;
				else
					str += ch;
				j++;
			}
			if (i == sToLowerCase.length() - 1)
				break;
			else
				str += "-";
		}
		return str;
	}

	// 5 кю
	public static String incrementString(String str) {
		int counter = 0;
		String strReturn = "";

		for (int i = str.length() - 1; i >= 0; i--) {
			char ch = str.charAt(i);
			if (Character.isDigit(ch)) {
				counter++;
			} else {
				break;
			}
		}

		String substrDigit = str.substring(str.length() - counter, str.length());
		String substrSimbol = str.substring(0, str.length() - counter);

		if (substrDigit.isEmpty()) {
			strReturn = substrSimbol + 1;
		} else if (substrDigit.startsWith("0")) {
			String digitSetOneOnBegin = 1 + substrDigit;

			BigInteger digits = new BigInteger(digitSetOneOnBegin);
			digits = digits.add(BigInteger.ONE);

			String againMakeString = String.valueOf(digits).substring(1);
			strReturn = substrSimbol + againMakeString;
		} else {
			BigInteger digits = new BigInteger(substrDigit);
			digits = digits.add(BigInteger.ONE);
			strReturn = substrSimbol + digits;
		}
		return strReturn;
	}

	// Округляет до следующего кратного пяти
	public static int roundToNext5(int number) {
		double decimalPart = number / 5;
		double fractionPart = number % 5;
		double a = decimalPart + fractionPart / 10;
		int returnNumber = (int) Math.ceil(a);
		return returnNumber * 5;
	}

	// Метод сортирует каждое слово в обратном порядке
	public static String reverseWords(final String original) {
		String str = "";
		if (original.trim().isEmpty()) {
			str += original;
		} else {
			String[] words = original.split(" ");
			for (int i = 0; i < words.length; i++) {
				char[] charArray = words[i].toCharArray();
				for (int j = 0; j < charArray.length / 2; j++) {
					char temp = charArray[j];
					charArray[j] = charArray[charArray.length - 1 - j];
					charArray[charArray.length - 1 - j] = temp;
				}
				str += new String(charArray);
				if (i == words.length - 1)
					break;
				else
					str += " ";
			}
		}
		return str;
	}

	// Ищет элемент который повторяется не четное количество раз
	public static int findIt(int[] a) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[i] == a[j]) {
					count++;
				}
			}
			if (count % 2 != 0) {
				count = a[i];
				break;
			} else
				count = 0;
		}
		return count;
	}

	// Учитывая два массива, в которых значения представляют собой силу каждого
	// солдата, верните true, если вы переживете атаку, или false, если вы
	// погибнете.
	public static boolean block(int[] attackers, int[] defenders) {
		boolean winOrLuse = true;
		if (attackers.length == 0 && defenders.length == 0) {
			winOrLuse = false;
		} else {
			int minLengthArr = Math.min(attackers.length, defenders.length);
			int j = 0;
			for (int i = 0; i < minLengthArr; i++) {
				while (j < minLengthArr) {
					if (defenders[j] > attackers[i]) {
						defenders[j] = defenders[j] - attackers[i];
						attackers[i] = 0;
						j++;
						break;
					} else {
						attackers[i] = attackers[i] - defenders[j];
						defenders[j] = 0;
						j++;
						break;
					}
				}
			}
			int firstArr = 0;
			int secondArr = 0;
			for (int i : defenders) {
				if (i == 0)
					firstArr++;
			}
			for (int i : attackers) {
				if (i == 0)
					secondArr++;
			}
			if (firstArr > secondArr)
				winOrLuse = false;
			else if (firstArr == secondArr) {
				int sum = 0;
				int sum2 = 0;
				for (int i : defenders) {
					sum += i;
				}
				for (int i : attackers) {
					sum2 += i;
				}
				winOrLuse = sum >= sum2 ? true : false;
			}

		}

		return winOrLuse;

	}

	// Дается две точки, начала и конец, метод строит их путь
	public static int[] between(int a, int b) {
		int n = 1;
		for (int i = Math.min(a, b); i < Math.max(a, b); i++) {
			n++;
		}
		int min = Math.min(a, b);
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = min;
			min++;
		}
		return arr;
	}

	// Проверяет является ли строка анаграммой
	public static boolean isAnagram(String test, String original) {
		char[] charArray = test.toLowerCase().toCharArray();
		char[] charArray2 = original.toLowerCase().toCharArray();
		Arrays.sort(charArray);
		Arrays.sort(charArray2);

		return Arrays.equals(charArray, charArray2);
	}

	public static int sequenceSum(int start, int end, int step) {
		int sum = 0;
		if (start > end) {
			return 0;
		} else {
			for (int i = start; i <= end; i += step) {
				sum += i;
			}
		}
		return sum;

	}

	public static String toAlternativeString(String string) {
		String str = "";
		for (int i = 0; i < string.length(); i++) {
			char ch = string.charAt(i);
			if (Character.isLetter(ch) || ch == ' ') {
				if (Character.isUpperCase(ch)) {
					str += Character.toLowerCase(ch);

				} else if (Character.isLowerCase(ch)) {
					str += Character.toUpperCase(ch);

				} else if (ch == ' ') {
					str += ' ';
				}
			} else {
				str += ch;
			}

		}
		return str;
	}

	static Integer find(final int[] array) {
		Integer num = null;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] + 1 == array[i + 1]) {
				num = null;
			} else {
				num = array[i + 1];
				break;
			}
		}
		return num;
	}

	public static int[] sortArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i] % 2 != 0 && array[j] % 2 != 0 && array[i] < array[j]) {
					int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
		}
		return array;
	}

	public static String twoSort(String[] s) {
		Arrays.sort(s);
		String str = s[0];
		String strReturn = "";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			strReturn += ch;
			if (i < str.length() - 1)
				strReturn += "***";
		}
		return strReturn;
	}

	public static int duplicateCount(String text) {
		Map<Character, Integer> map = new HashMap<>();
		int b = 0;
		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			for (int j = 0; j < text.length(); j++) {
				char ch2 = text.charAt(j);
				if (Character.toLowerCase(ch) == Character.toLowerCase(ch2)) {
					b++;
				}
			}
			map.put(ch, b);
			b = 0;
		}
		int count = map.entrySet().stream()
				.filter(entry -> entry.getValue() >= 2)
				.mapToInt(entry -> 1) // Преобразовываем каждую запись в число 1
				.sum();
		return count;
	}

	public static List<Long> sumDigPow(long a, long b) {
		// your code
		List<Long> list = new ArrayList<>();
		long pow = 1;
		long sum = 0;
		for (long i = Math.min(a, b); i <= Math.max(a, b); i++) {
			String str = Long.toString(i);
			for (int j = 0; j < str.length(); j++) {
				long number = Character.getNumericValue(str.charAt(j));
				sum += Math.pow(number, pow);
				pow++;
			}

			if (sum == i) {
				list.add(i);
			}
			pow = 1;
			sum = 0;
		}
		return list;
	}

	public static String whoLikesIt(String... names) {
		// Do your magic here
		switch (names.length) {
			case 0:
				return "no one likes this";
			case 1:
				return names[0] + " likes this";
			case 2:
				return names[0] + " and " + names[1] + " like this";
			case 3:
				return names[0] + ", " + names[1] + " and " + names[2] + " like this";
			default:
				return names[0] + ", " + names[1] + " and " + (names.length - 2) + " others like this";
		}
	}

	public static int sortDesc(final int num) {
		// Your code
		String str = String.valueOf(num);
		int[] arr = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			int number = Character.getNumericValue(str.charAt(i));
			arr[i] = number;
		}
		Arrays.sort(arr);
		String sb = "";
		for (int i = arr.length - 1; i >= 0; i--) {
			sb += arr[i];
		}
		return Integer.parseInt(sb.toString());
	}

	public static Object[] removeEveryOther(Object[] arr) {
		// happy coding
		if (arr.length == 0) {
			return arr;
		} else {
			Object[] array;
			if (arr.length % 2 == 0)
				array = new Object[arr.length / 2];
			else
				array = new Object[(arr.length / 2) + 1];
			int i = 0;
			int j = 0;
			do {
				array[j] = arr[i];
				i += 2;
				j++;
			} while (i < arr.length);

			return array;
		}
	}

	public static Map<Character, Integer> count(String str) {
		// Happy coding!
		Map<Character, Integer> map = new HashMap<>();
		int countChar = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			for (int j = 0; j < str.length(); j++) {
				char ch2 = str.charAt(j);
				if (ch == ch2) {
					countChar++;
				}
			}
			map.put(ch, countChar);
			countChar = 0;
		}
		return map;
	}

	public static long digPow(int n, int p) {
		// your code
		int sum = 0;
		String strN = String.valueOf(n);
		for (int i = 0; i < strN.length(); i++) {
			char ch = strN.charAt(i);
			int digit = Character.getNumericValue(ch);
			sum += Math.pow(digit, p);
			p++;
		}
		int k = sum / n;
		return k * n == sum ? k : -1;
	}

	public static long sumCubes(long n) {
		// put your code here :D
		long sum = 0;
		for (long i = 1; i <= n; i++) {
			long cube = i * i * i;
			sum += cube;
		}
		return sum;
	}

	public static int ConvertBinaryArrayToInt(List<Integer> binary) {
		// Your Code
		int number = 0;
		for (int digit : binary) {
			number = number * 10 + digit;
		}
		return number;
	}

	public static boolean check(String sentence) {
		char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
				's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		char[] uniqueChars = new char[alphabet.length];
		sentence = sentence.toLowerCase(); // Приводим все символы к нижнему регистру для корректного сравнения
		for (int i = 0; i < sentence.length(); i++) {
			char ch = sentence.charAt(i);
			if (ch >= 'a' && ch <= 'z') { // Учитываем только символы от 'a' до 'z'
				uniqueChars[ch - 'a'] = ch;
			}
		}
		return Arrays.equals(alphabet, uniqueChars);
	}

	public static String[] towerBuilder(int nFloors) {
		String[] str = new String[nFloors];
		for (int i = 0; i < nFloors; i++) {
			StringBuilder row = new StringBuilder();
			// Рисуем пробелы слева от треугольника
			for (int j = 0; j < nFloors - i - 1; j++) {
				row.append(" ");
			}
			// Рисуем символы треугольника
			for (int j = 0; j < 2 * i + 1; j++) {
				row.append("*");
			}
			// Добавляем пробелы справа от треугольника
			for (int j = 0; j < nFloors - i - 1; j++) {
				row.append(" ");
			}
			// Сохраняем строку в массиве
			str[i] = row.toString();
		}
		return str;
	}

	public static int[] digitize(long n) {
		// Code here
		String numberAsString = Long.toString(n);
		int[] arr = new int[numberAsString.length()];
		for (int i = numberAsString.length() - 1, j = 0; i >= 0; i--, j++) {
			int number = Character.getNumericValue(numberAsString.charAt(i));
			arr[j] = number;
		}
		return arr;
	}

	public static String sortMyString(String s) {
		String evenIndex = "";
		String oddIndex = "";
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < sb.length(); i++) {
			char ch = sb.charAt(i);
			if (i % 2 == 0) {
				evenIndex += ch;
			} else {
				oddIndex += ch;
			}
		}
		return evenIndex + " " + oddIndex;
	}

	public static String isStrongNumber(int num) {
		String numberAsString = Integer.toString(num);
		int factorialNumber = 1;
		int sum = 0;
		for (int i = 0; i < numberAsString.length(); i++) {
			int number = Character.getNumericValue(numberAsString.charAt(i));
			for (int j = 1; j <= number; j++) {
				factorialNumber = factorialNumber * j;
			}
			sum += factorialNumber;
			factorialNumber = 1;
		}
		return sum == num ? "STRONG!!!!" : "Not Strong !!";
	}

	public static int multiArithmeticElements(int a1, int t, int n) {
		int[] arr = new int[n];
		int sum = 1;
		for (int i = 0; i < n; i++) {
			arr[i] = a1;
			a1 += t;
		}
		for (int i = 0; i < arr.length; i++) {
			sum *= arr[i];
		}
		return sum;

	}

	public static String disemvowel(String str) {
		// Code away...
		char[] vowels = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
		StringBuilder sb = new StringBuilder(str);
		for (int i = 0; i < sb.length(); i++) {
			char ch = sb.charAt(i);
			for (int j = 0; j < vowels.length; j++) {
				if (ch == vowels[j]) {
					sb.deleteCharAt(i);
					i--;
					break;
				}
			}
		}
		return sb.toString();
	}

	public static String camelCase(String input) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (Character.isUpperCase(ch)) {
				result.append(" ");
			}
			result.append(ch);
		}
		return result.toString();
	}

	static String encode(String word) {
		String str = "";
		int countChar = 0;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			for (int j = 0; j < word.length(); j++) {
				char ch2 = word.charAt(j);
				if (Character.toLowerCase(ch) == Character.toLowerCase(ch2)) {
					countChar++;
				}
			}
			if (countChar >= 2) {
				str += ")";
				countChar = 0;
			} else if (countChar == 1) {
				str += "(";
				countChar = 0;
			}
		}
		return str;
	}

}
