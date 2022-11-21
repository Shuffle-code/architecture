package interview.ping_pong;

public class PingPong {
        private Object state = new Object();
        private String pong = "pong ";
        private String ping = "ping ";
        private volatile String current = "ping ";

        public void printPing() {
            synchronized (state) {
                try {
                    for (int i = 0; i < 10; i++) {
                        String ping = "ping ";
                        while (!current.equals(ping)) {
                            state.wait();
                        }
                        System.out.print(ping);
                        current = pong;
                        state.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void printPong() {
            synchronized (state) {
                try {
                    for (int i = 0; i < 10; i++) {
                        while (!current.equals(pong)) {
                            state.wait();
                        }
                        System.out.print(pong);
                        current = ping;
                        state.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
}
