package com.captainx.learningBackup.设计题;
import java.util.LinkedList;
/**
 * @Author: xuchengrui
 * @Date: 2024/2/26
 * @Description:限流滑动窗口
 **/
public class RateLimiter {
        private final LinkedList<Long> slidingWindow;
        private final long period;
        private final int maxRequests;

        public RateLimiter(int maxRequests, long period) {
            this.slidingWindow = new LinkedList<>();
            this.period = period * 60 * 1000; // convert minutes to milliseconds
            this.maxRequests = maxRequests;
        }

        public synchronized boolean isAllowed() {
            long currentTime = System.currentTimeMillis();
            while (!slidingWindow.isEmpty() && currentTime - slidingWindow.getFirst() > period) {
                slidingWindow.removeFirst();
            }
            if (slidingWindow.size() < maxRequests) {
                slidingWindow.addLast(currentTime);
                return true;
            } else {
                return false;
            }
        }
}

