package net.jazgung.cfx.log;

public class Logger {

	private static final int CUT_OFF_RULE_LENGTH = 140;

	public static void log(String message) {
		StringBuilder sb = new StringBuilder();

		int beforLength = (int) ((CUT_OFF_RULE_LENGTH - message.length()) / 2);
		int afterLength = CUT_OFF_RULE_LENGTH - message.length() - beforLength;
		for (int i = 0; i < beforLength; i++) {
			sb.append('-');
		}
		sb.append(message);
		for (int i = 0; i < afterLength; i++) {
			sb.append('-');
		}

		System.out.println(sb.toString());
	}

}
