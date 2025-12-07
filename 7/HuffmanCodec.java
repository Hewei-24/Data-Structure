import java.util.Map;

// 哈夫曼编码译码系统
class HuffmanCodec {
    private HuffmanTree huffmanTree;
    private Map<Character, String> encodeMap;
    private Map<String, Character> decodeMap;

    public HuffmanCodec(int[] weights, String charset) {
        huffmanTree = new HuffmanTree(weights, charset);
        encodeMap = huffmanTree.getCodeMap();
        decodeMap = huffmanTree.getDecodeMap();
    }

    // 1. 压缩函数：文本到哈夫曼编码序列
    public String compress(String text) {
        StringBuilder compressed = new StringBuilder();
        for (char c : text.toCharArray()) {
            compressed.append(encodeMap.get(c));
        }
        return compressed.toString();
    }

    // 2. 解压缩函数：哈夫曼编码序列到文本
    public String decompress(String compressed) {
        StringBuilder text = new StringBuilder();
        StringBuilder code = new StringBuilder();
        for (char bit : compressed.toCharArray()) {
            code.append(bit);
            if (decodeMap.containsKey(code.toString())) {
                text.append(decodeMap.get(code.toString()));
                code.setLength(0);
            }
        }
        return text.toString();
    }

    // 测试函数
    public static void main(String[] args) {
        // 实验7.1 测试数据
        int[] weights = {5, 29, 7, 8, 14, 23, 3, 11};
        String charset = "ABCDEFGH";

        HuffmanCodec codec = new HuffmanCodec(weights, charset);
        System.out.println("哈夫曼树与编码");
        System.out.println(codec.huffmanTree.toString());

        // 实验7.2 文本压缩解压测试
        System.out.println("\n文本压缩解压测试");
        String text = "this program is my favorite";
        System.out.println("原文本: " + text);
        int[] freq = new int[27];
        // 模拟压缩
        String compressed = codec.compress("ABCD");
        System.out.println("压缩后: " + compressed);
        System.out.println("解压后: " + codec.decompress(compressed));
    }
}