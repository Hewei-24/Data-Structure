import java.util.*;

// 哈夫曼树结点类
class HuffmanNode {
    int weight;          // 权值
    char ch;             // 字符
    int parent, left, right; // 父节点、左孩子、右孩子索引

    public HuffmanNode(int weight, char ch) {
        this.weight = weight;
        this.ch = ch;
        this.parent = this.left = this.right = -1;
    }

    public HuffmanNode(int weight) {
        this.weight = weight;
        this.ch = ' ';
        this.parent = this.left = this.right = -1;
    }


    public String toString() {
        return "weight=" + weight + ", ch=" + ch + ", parent=" + parent + ", left=" + left + ", right=" + right;
    }
}

// 哈夫曼树类
class HuffmanTree {
    private HuffmanNode[] nodes;  // 静态链表存储哈夫曼树
    private int n;                 // 叶子节点数
    private String[] huffmanCodes; // 哈夫曼编码表
    private String charset;        // 字符集

    // 构造函数
    public HuffmanTree(int[] weights, String charset) {
        this.n = weights.length;
        this.charset = charset;
        int m = 2 * n - 1; // 哈夫曼树总节点数
        nodes = new HuffmanNode[m];
        huffmanCodes = new String[n];

        // 初始化叶子节点
        for (int i = 0; i < n; i++) {
            nodes[i] = new HuffmanNode(weights[i], charset.charAt(i));
        }
        // 构建哈夫曼树
        for (int i = n; i < m; i++) {
            int[] minIndices = selectTwoMin(i);
            int left = minIndices[0];
            int right = minIndices[1];
            nodes[left].parent = i;
            nodes[right].parent = i;
            nodes[i] = new HuffmanNode(nodes[left].weight + nodes[right].weight);
            nodes[i].left = left;
            nodes[i].right = right;
        }
        // 生成哈夫曼编码
        generateHuffmanCodes();
    }

    // 选择两个最小权值节点
    private int[] selectTwoMin(int end) {
        int min1 = -1, min2 = -1;
        for (int i = 0; i < end; i++) {
            if (nodes[i].parent != -1) continue;
            if (min1 == -1 || nodes[i].weight < nodes[min1].weight) {
                min2 = min1;
                min1 = i;
            } else if (min2 == -1 || nodes[i].weight < nodes[min2].weight) {
                min2 = i;
            }
        }
        return new int[]{min1, min2};
    }

    // 生成哈夫曼编码
    private void generateHuffmanCodes() {
        for (int i = 0; i < n; i++) {
            StringBuilder code = new StringBuilder();
            int c = i;
            int p = nodes[c].parent;
            while (p != -1) {
                if (nodes[p].left == c) {
                    code.append('0');
                } else {
                    code.append('1');
                }
                c = p;
                p = nodes[c].parent;
            }
            huffmanCodes[i] = code.reverse().toString();
        }
    }

    // 获取所有节点信息
    public String getNodesInfo() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nodes.length; i++) {
            sb.append("Node ").append(i).append(": ").append(nodes[i]).append("\n");
        }
        return sb.toString();
    }

    // 获取所有字符的哈夫曼编码
    public String getHuffmanCodes() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(charset.charAt(i)).append(": ").append(huffmanCodes[i]).append("\n");
        }
        return sb.toString();
    }


    public String toString() {
        return "哈夫曼树所有结点数据值：\n" + getNodesInfo() + "\n各字符的哈夫曼编码：\n" + getHuffmanCodes();
    }

    // 获取编码表（字符到编码）
    public Map<Character, String> getCodeMap() {
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(charset.charAt(i), huffmanCodes[i]);
        }
        return map;
    }

    // 获取解码表（编码到字符）
    public Map<String, Character> getDecodeMap() {
        Map<String, Character> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(huffmanCodes[i], charset.charAt(i));
        }
        return map;
    }
}