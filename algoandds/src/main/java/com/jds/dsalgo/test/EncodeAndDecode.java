package com.jds.dsalgo.test;

public class EncodeAndDecode {

	public static void main(String[] args) {
		int operation = 1;
		String message = "Ope";
		System.out.println(secureChannel(operation, message, "" + 12345));

	}

	static String secureChannel(int operation, String message, String key) {
		int k;
		try {
			k = Integer.parseInt(key);
		} catch (Exception exp) {
			return String.valueOf(-1);
		}
		if(key.length()>message.length())
		{
			return "-1";
		}
		if (operation == 1) {
			String output="";
			int i=0;
			for (int j = 0; j <message.length(); j++) {
				char rc =message.charAt(j) ;
				int d = Integer.parseInt("" +key.charAt(j));
				String temp="";
				while (d > 0) {
					temp = temp + rc;
					d--;
				}
				output=output.substring(0,i)+temp+message.substring(j+1);
				i=i+temp.length();
			}
//			int i = 0;
//			String output = "";
//			for (char c : key.toCharArray()) {
//				int d = Integer.parseInt("" + c);
//				char rc = message.charAt(i);
//				output = message.substring(0, i);
//				String end = message.substring(i + 1);
//				while (d > 0) {
//					output = output + rc;
//					d--;
//					i++;
//				}
//				message = output + end;
//			}
			return output;
		} else if (operation == 2) {
			int i = 0;
			for (char c : key.toCharArray()) {
				int d = Integer.parseInt("" + c);
				message = message.substring(0, i) + message.substring(i, d) + message.substring(i + d);
				i = i + 1;
			}
			return message;
		} else {
			return String.valueOf(-1);
		}
	}

}
