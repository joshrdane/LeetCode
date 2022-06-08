public class ValidateIPAddress {
    public static String validIPAddress(String queryIP) {
        if (validIPv4Address(queryIP)) {
            return "IPv4";
        } else if (validIPv6Address(queryIP)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }

    public static boolean validIPv4Address(String queryIP) {
        if (queryIP.startsWith(".") || queryIP.endsWith(".")) {
            return false;
        }
        String[] pieces = queryIP.split("\\.");
        if (pieces.length != 4) {
            return false;
        }
        for (String piece : pieces) {
            switch (piece.length()) {
                case 0 -> {
                    return false;
                }
                case 1 -> {
                    if (piece.charAt(0) < '0' || piece.charAt(0) > '9') {
                        return false;
                    }
                }
                default -> {
                    try {
                        int number = Integer.parseInt(piece);
                        if (piece.charAt(0) == '0' || number < 10 || number > 255) {
                            return false;
                        }
                    } catch (NumberFormatException e) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean validIPv6Address(String queryIP) {
        if (queryIP.startsWith(":") || queryIP.endsWith(":")) {
            return false;
        }
        String[] pieces = queryIP.split(":");
        if (pieces.length != 8) {
            return false;
        }
        for (String piece : pieces) {
            if (!piece.matches("^[a-fA-F\\d]{1,4}$")) {
                return false;
            }
        }
        return true;
    }
}
