public class AddBinary {
    public static String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder(a);
        while (builder.length() < b.length()) {
            builder.insert(0, '0');
        }
        a = builder.toString();
        builder = new StringBuilder(b);
        while (a.length() > builder.length()) {
            builder.insert(0, '0');
        }
        b = builder.toString();
        builder = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            switch (a.charAt(i) + b.charAt(i) + carry) {
                case 96 -> builder.insert(0, '0');
                case 97 -> {
                    builder.insert(0, '1');
                    carry = 0;
                }
                case 98 -> {
                    builder.insert(0, '0');
                    carry = 1;
                }
                case 99 -> {
                    builder.insert(0, '1');
                    carry = 1;
                }
            }
        }
        if (carry == 1) {
            builder.insert(0, '1');
        }
        return builder.toString();
    }
}
