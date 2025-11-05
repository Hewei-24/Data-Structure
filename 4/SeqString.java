public class SeqString {
    private char[] str;
    private int length;

    public SeqString(String s) {
        this.length = s.length();
        this.str = new char[this.length];
        for (int i = 0; i < this.length; i++) {
            this.str[i] = s.charAt(i);
        }
    }

    public SeqString(char[] chars) {
        this.length = chars.length;
        this.str = new char[this.length];
        System.arraycopy(chars, 0, this.str, 0, this.length);
    }

    // 获取串长度
    public int length() {
        return length;
    }

    // 获取指定位置的字符
    public char charAt(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("索引越界: " + index);
        }
        return str[index];
    }

    // 连接两个串
    public SeqString concat(SeqString s) {
        char[] newStr = new char[this.length + s.length()];
        System.arraycopy(this.str, 0, newStr, 0, this.length);
        System.arraycopy(s.str, 0, newStr, this.length, s.length());
        return new SeqString(newStr);
    }

    // 获取子串
    public SeqString substring(int begin, int end) {
        if (begin < 0 || end > length || begin > end) {
            throw new IndexOutOfBoundsException("索引范围错误: " + begin + " to " + end);
        }
        char[] sub = new char[end - begin];
        System.arraycopy(str, begin, sub, 0, end - begin);
        return new SeqString(sub);
    }

    // 判断是否为空串
    public boolean isEmpty() {
        return length == 0;
    }

    // 比较两个串是否相等
    public boolean equals(SeqString other) {
        if (other == null || this.length != other.length) {
            return false;
        }
        for (int i = 0; i < this.length; i++) {
            if (this.str[i] != other.str[i]) {
                return false;
            }
        }
        return true;
    }

    // 查找字符第一次出现的位置
    public int indexOf(char ch) {
        for (int i = 0; i < length; i++) {
            if (str[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        return new String(str);
    }
}