import java.util.ArrayList;

public class FancySequence {
    public static void main(String[] args) {
        Fancy fancy = new Fancy();
        fancy.addAll(1);
        fancy.getIndex(0);
    }
}

class Fancy {
    private ArrayList<Integer> data;

    public Fancy() {
        data = new ArrayList<>();
    }

    public void append(int val) {
        data.add(val);
    }

    public void addAll(int inc) {
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) + inc);
        }
    }

    public void multAll(int m) {
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) * m);
        }
    }

    public int getIndex(int idx) {
        int result = -1;
        if (idx < data.size()) {
            idx %= 1000000007;
            result = data.get(idx);
        }
        return result;
    }
}
