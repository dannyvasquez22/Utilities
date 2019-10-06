package com.admin.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

public class StringUtility {

	public static final String EMPTY = "";
	public static final int INDEX_NOT_FOUND = -1;

	public static boolean hasLength(String str) {
		return (str != null && str.length() > 0);
	}

	public static String[] toStringArray(Collection<?> collection) {
		if (collection == null) {
			return null;
		}
		return (String[]) collection.toArray(new String[collection.size()]);
	}

	public static boolean isNotEmpty(final CharSequence cs) {
		return !isEmpty(cs);
	}

	public static boolean isEmpty(final CharSequence cs) {
		return cs == null || cs.length() == 0;
	}

	public static boolean isAnyEmpty(final CharSequence... css) {
		if (css != null && css.length == 0) {
			return false;
		}
		for (final CharSequence cs : css) {
			if (isEmpty(cs)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isNoneEmpty(final CharSequence... css) {
		return !isAnyEmpty(css);
	}

	public static boolean isAllEmpty(final CharSequence... css) {
		if (css != null && css.length == 0) {
			return true;
		}
		for (final CharSequence cs : css) {
			if (isNotEmpty(cs)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isBlank(final CharSequence cs) {
		int strLen;
		if (cs == null || (strLen = cs.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if (!Character.isWhitespace(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isNotBlank(final CharSequence cs) {
		return !isBlank(cs);
	}

	public static boolean isAnyBlank(final CharSequence... css) {
		if (css != null && css.length == 0) {
			return false;
		}
		for (final CharSequence cs : css) {
			if (isBlank(cs)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isNoneBlank(final CharSequence... css) {
		return !isAnyBlank(css);
	}

	public static boolean isAllBlank(final CharSequence... css) {
		if (css != null && css.length == 0) {
			return true;
		}
		for (final CharSequence cs : css) {
			if (isNotBlank(cs)) {
				return false;
			}
		}
		return true;
	}

	public static int compare(final String str1, final String str2) {
		return compare(str1, str2, true);
	}

	public static int compare(final String str1, final String str2, final boolean nullIsLess) {
		if (str1 == str2) {
			return 0;
		}
		if (str1 == null) {
			return nullIsLess ? -1 : 1;
		}
		if (str2 == null) {
			return nullIsLess ? 1 : -1;
		}
		return str1.compareTo(str2);
	}

	public static int compareIgnoreCase(final String str1, final String str2) {
		return compareIgnoreCase(str1, str2, true);
	}

	public static int compareIgnoreCase(final String str1, final String str2, final boolean nullIsLess) {
		if (str1 == str2) {
			return 0;
		}
		if (str1 == null) {
			return nullIsLess ? -1 : 1;
		}
		if (str2 == null) {
			return nullIsLess ? 1 : -1;
		}
		return str1.compareToIgnoreCase(str2);
	}

	public static boolean containsWhitespace(final CharSequence seq) {
		if (isEmpty(seq)) {
			return false;
		}
		final int strLen = seq.length();
		for (int i = 0; i < strLen; i++) {
			if (Character.isWhitespace(seq.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	public static String upperCase(final String str) {
		if (str == null) {
			return null;
		}
		return str.toUpperCase();
	}

	public static String upperCase(final String str, final Locale locale) {
		if (str == null) {
			return null;
		}
		return str.toUpperCase(locale);
	}

	public static String lowerCase(final String str) {
		if (str == null) {
			return null;
		}
		return str.toLowerCase();
	}

	public static String lowerCase(final String str, final Locale locale) {
		if (str == null) {
			return null;
		}
		return str.toLowerCase(locale);
	}

	public static int countMatches(final CharSequence str, final char ch) {
		if (isEmpty(str)) {
			return 0;
		}
		int count = 0;
		// We could also call str.toCharArray() for faster look ups but that
		// would generate more garbage.
		for (int i = 0; i < str.length(); i++) {
			if (ch == str.charAt(i)) {
				count++;
			}
		}
		return count;
	}

	public static boolean isAlpha(final CharSequence cs) {
		if (isEmpty(cs)) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isLetter(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static String[] trimArrayElements(String[] array) {
		if (array.length <= 0) {
			return new String[0];
		}

		String[] result = new String[array.length];
		for (int i = 0; i < array.length; i++) {
			String element = array[i];
			result[i] = (element != null ? element.trim() : null);
		}
		return result;
	}

	public static String trimWhitespace(String str) {
		if (!hasLength(str)) {
			return str;
		}

		int beginIndex = 0;
		int endIndex = str.length() - 1;

		while (beginIndex <= endIndex && Character.isWhitespace(str.charAt(beginIndex))) {
			beginIndex++;
		}

		while (endIndex > beginIndex && Character.isWhitespace(str.charAt(endIndex))) {
			endIndex--;
		}

		return str.substring(beginIndex, endIndex + 1);
	}

	public static String trimAllWhitespace(String str) {
		if (!hasLength(str)) {
			return str;
		}

		int len = str.length();
		StringBuilder sb = new StringBuilder(str.length());
		for (int i = 0; i < len; i++) {
			char c = str.charAt(i);
			if (!Character.isWhitespace(c)) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public static String trimLeadingWhitespace(String str) {
		if (!hasLength(str)) {
			return str;
		}

		StringBuilder sb = new StringBuilder(str);
		while (sb.length() > 0 && Character.isWhitespace(sb.charAt(0))) {
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}

	public static String trimTrailingWhitespace(String str) {
		if (!hasLength(str)) {
			return str;
		}

		StringBuilder sb = new StringBuilder(str);
		while (sb.length() > 0 && Character.isWhitespace(sb.charAt(sb.length() - 1))) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	public static String uppercaseFirstChar(String in) {
		if (in == null || in.length() == 0) {
			return in;
		}
		int length = in.length();
		StringBuilder sb = new StringBuilder(length);

		sb.append(Character.toUpperCase(in.charAt(0)));
		if (length > 1) {
			String remaining = in.substring(1);
			sb.append(remaining);
		}
		return sb.toString();
	}

	public static boolean isAlphaSpace(final CharSequence cs) {
		if (cs == null) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isLetter(cs.charAt(i)) && cs.charAt(i) != ' ') {
				return false;
			}
		}
		return true;
	}

	public static boolean isAlphanumeric(final CharSequence cs) {
		if (isEmpty(cs)) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isLetterOrDigit(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isAlphanumericSpace(final CharSequence cs) {
		if (cs == null) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isLetterOrDigit(cs.charAt(i)) && cs.charAt(i) != ' ') {
				return false;
			}
		}
		return true;
	}

	public static boolean isNumeric(final CharSequence cs) {
		if (isEmpty(cs)) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isDigit(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isNumericSpace(final CharSequence cs) {
		if (cs == null) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isDigit(cs.charAt(i)) && cs.charAt(i) != ' ') {
				return false;
			}
		}
		return true;
	}

	public static String getDigits(final String str) {
		if (isEmpty(str)) {
			return str;
		}
		final int sz = str.length();
		final StringBuilder strDigits = new StringBuilder(sz);
		for (int i = 0; i < sz; i++) {
			final char tempChar = str.charAt(i);
			if (Character.isDigit(tempChar)) {
				strDigits.append(tempChar);
			}
		}
		return strDigits.toString();
	}

	public static boolean isWhitespace(final CharSequence cs) {
		if (cs == null) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isWhitespace(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isAllLowerCase(final CharSequence cs) {
		if (cs == null || isEmpty(cs)) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isLowerCase(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isAllUpperCase(final CharSequence cs) {
		if (cs == null || isEmpty(cs)) {
			return false;
		}
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (!Character.isUpperCase(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isMixedCase(final CharSequence cs) {
		if (isEmpty(cs) || cs.length() == 1) {
			return false;
		}
		boolean containsUppercase = false;
		boolean containsLowercase = false;
		final int sz = cs.length();
		for (int i = 0; i < sz; i++) {
			if (containsUppercase && containsLowercase) {
				return true;
			} else if (Character.isUpperCase(cs.charAt(i))) {
				containsUppercase = true;
			} else if (Character.isLowerCase(cs.charAt(i))) {
				containsLowercase = true;
			}
		}
		return containsUppercase && containsLowercase;
	}

	public static String defaultString(final String str) {
		return defaultString(str, EMPTY);
	}

	public static String defaultString(final String str, final String defaultStr) {
		return str == null ? defaultStr : str;
	}

	@SafeVarargs
	public static <T extends CharSequence> T firstNonBlank(final T... values) {
		if (values != null) {
			for (final T val : values) {
				if (isNotBlank(val)) {
					return val;
				}
			}
		}
		return null;
	}

	@SafeVarargs
	public static <T extends CharSequence> T firstNonEmpty(final T... values) {
		if (values != null) {
			for (final T val : values) {
				if (isNotEmpty(val)) {
					return val;
				}
			}
		}
		return null;
	}

	public static <T extends CharSequence> T defaultIfBlank(final T str, final T defaultStr) {
		return isBlank(str) ? defaultStr : str;
	}

	public static <T extends CharSequence> T defaultIfEmpty(final T str, final T defaultStr) {
		return isEmpty(str) ? defaultStr : str;
	}

	public static String fromBufferedReader(BufferedReader bufferedReader) {
		StringBuffer sb = new StringBuffer();

		try {
			String line = bufferedReader.readLine();

			while (line != null) {
				sb.append(line);
				line = bufferedReader.readLine();
				if (line != null) {
					sb.append("\n");
				}
			}
		} catch (IOException e) {
			// replace this with log.error
			e.printStackTrace();
		}

		return sb.toString();
	}

	public static String fromInputStream(InputStream inputStream) {
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		return fromBufferedReader(bufferedReader);
	}

	public static String getClasspath() {
		Properties prop = System.getProperties();
		return prop.getProperty("java.class.path", null);
	}

	public static String getAllFilesOnClasspath() {
		StringBuffer sb = new StringBuffer();
		for (final java.lang.String path : getClasspath().split(":")) {
			final java.io.File object = new java.io.File(path);
			if (object.isDirectory()) {
				for (File file : object.listFiles()) {
					sb.append(file.getAbsolutePath()).append("\n");
				}
			} else if (object.isFile()) {
				sb.append(object).append("\n");
			}
		}
		return sb.toString();
	}

	public static Map<String, String> arrayToMap(String[][] array) {
		Map<String, String> map = new HashMap<String, String>();

		for (String[] pair : array) {
			if (pair.length > 1) {
				// got a pair, add to map
				map.put(pair[0], pair[1]);
			}
		}
		return map;
	}

	public static String startsWith(String[] array, String startsWith) {
		String lcStartsWith = startsWith.toLowerCase();
		for (String element : array) {
			if (element.toLowerCase().startsWith(lcStartsWith)) {
				return element;
			}
		}
		return "";
	}

	public static int indexThatStartsWith(String[] array, String startsWith) {
		String lcStartsWith = startsWith.toLowerCase();

		for (int i = 0; i < array.length; i++) {
			if (array[i].toLowerCase().startsWith(lcStartsWith)) {
				return i;
			}
		}

		return -1;
	}

	public static String prependToLength(char prependChar, int targetLength, Integer initialInt) {

		if (initialInt == null) {
			return null;
		}

		return prependToLength(prependChar, targetLength, initialInt.toString());
	}

	public static String prependToLength(char prependChar, int targetLength, String initialString) {
		if (initialString == null) {
			return null;
		}

		StringBuffer result = new StringBuffer(initialString);

		while (result.length() < targetLength) {
			result.append(prependChar);
		}

		return result.reverse().toString();
	}

	public static String truncate(String str, int maxLength) {
		if (str == null || str.length() <= maxLength || maxLength < 1) {
			return str;
		}

		return str.substring(0, maxLength);
	}

	public static String trimLeadingCharacter(String str, char leadingCharacter) {
		if (!hasLength(str)) {
			return str;
		}

		StringBuilder sb = new StringBuilder(str);
		while (sb.length() > 0 && sb.charAt(0) == leadingCharacter) {
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}

	public static String trimTrailingCharacter(String str, char trailingCharacter) {
		if (!hasLength(str)) {
			return str;
		}

		StringBuilder sb = new StringBuilder(str);
		while (sb.length() > 0 && sb.charAt(sb.length() - 1) == trailingCharacter) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	public static boolean startsWithIgnoreCase(String str, String prefix) {
		return (str != null && prefix != null && str.length() >= prefix.length()
				&& str.regionMatches(true, 0, prefix, 0, prefix.length()));
	}

	public static String quote(String str) {
		return (str != null ? "'" + str + "'" : null);
	}

	public static Object quoteIfString(Object obj) {
		return (obj instanceof String ? quote((String) obj) : obj);
	}

	public static String[] mergeStringArrays(String array1[], String array2[]) {

		if (array1 == null || array1.length == 0)
			return array2;
		if (array2 == null || array2.length == 0)
			return array1;
		List<String> array1List = Arrays.asList(array1);
		List<String> array2List = Arrays.asList(array2);
		List<String> result = new ArrayList<String>(array1List);
		List<String> tmp = new ArrayList<String>(array1List);
		tmp.retainAll(array2List);
		result.removeAll(tmp);
		result.addAll(array2List);
		return ((String[]) result.toArray(new String[result.size()]));
	}

	public static boolean endsWithIgnoreCase(String str, String suffix) {

		if (str == null || suffix == null) {
			return false;
		}
		if (str.endsWith(suffix)) {
			return true;
		}
		if (str.length() < suffix.length()) {
			return false;
		} else {
			return str.toLowerCase().endsWith(suffix.toLowerCase());
		}
	}

}
