class Process {
    int pid;
    int priority;

    public Process(int pid, int priority) {
        this.pid = pid;
        this.priority = priority;
    }

    public String toString() {
        return "进程" + pid + "(优先级:" + priority + ")";
    }
}

public class PriorityQueue {
    private java.util.PriorityQueue<Process> queue;

    public PriorityQueue() {
        queue = new java.util.PriorityQueue<>((p1, p2) -> {
            if (p1.priority != p2.priority) {
                return p1.priority - p2.priority;
            }
            return 0;
        });
    }

    public void addProcess(Process process) {
        queue.offer(process);
    }

    public Process serveProcess() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void display() {
        System.out.println("等待进程: " + queue);
    }
}

// 模拟进程管理
class ProcessManager {
    public static void main(String[] args) {
        System.out.println("进程管理模拟");

        PriorityQueue pq = new PriorityQueue();

        // 添加测试数据
        Process[] processes = {
                new Process(1, 5),
                new Process(2, 10),
                new Process(3, 20),
                new Process(4, 10),
                new Process(5, 40),
                new Process(6, 10)
        };

        System.out.println("初始进程队列:");
        for (Process p : processes) {
            pq.addProcess(p);
            System.out.println("加入: " + p);
        }

        System.out.println("\n服务顺序:");
        while (!pq.isEmpty()) {
            Process served = pq.serveProcess();
            System.out.println("服务: " + served);
        }
    }
}